package tid.bgp.bgp4Peer.bgp4session;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.logging.Logger;

import es.tid.bgp.bgp4.messages.BGP4Message;
import es.tid.bgp.bgp4.messages.BGP4MessageTypes;
import es.tid.bgp.bgp4.messages.BGP4Update;
import tid.bgp.bgp4Peer.pruebas.BGP4Exception;
import tid.bgp.bgp4Peer.pruebas.BGP4Parameters;
import tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;
/**
 * Client session
 * 
 * @author mcs
 *
 */
public class BGP4SessionClient extends GenericBGP4Session{
	/**
	 * Peer BGP port to which the session is connected
	 */
	private int peerBGP_port;
	/**
	 * Delay
	 */
	
	
	private boolean no_delay=true;
	private String peerBGP_IPaddress;
	private String localBGP4Address;
	private int localBGP4Port; 
	/**
	 * Class to dispatch the BGP4 update messages. 
	 * If a BGP5 update message is received, it is stored in a queue of UpdateDispatcher. 
	 */
	private UpdateDispatcher updateDispatcher;
	
	public BGP4SessionClient(BGP4SessionsInformation bgp4SessionsInformation,UpdateDispatcher updateDispatcher, String peerBGP_IPaddress, int peerBGP_port, int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem, String localBGP4Address, int localBGP4Port,int keepAliveTimer){
		super(bgp4SessionsInformation, holdTime, BGPIdentifier, version, myAutonomousSystem,keepAliveTimer);
		timer=new Timer();
		log = Logger.getLogger("BGP4Parser");		
		this.peerBGP_IPaddress = peerBGP_IPaddress;
		this.peerBGP_port = peerBGP_port;
		this.updateDispatcher=updateDispatcher;
		this.localBGP4Address=localBGP4Address;
		this.localBGP4Port=localBGP4Port;
		
	}
	/**
	 * Initiates a Session between the Domain PCE and the peer PCC
	 */
	public void run() {
		try {
			this.setRemotePeerId((Inet4Address)InetAddress.getByName(peerBGP_IPaddress));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//int holdTime,long BGPIdentifier,int myAutonomousSystem,int version
		log.info("Opening new BGP4 Session with host "+ peerBGP_IPaddress + " on port " + peerBGP_port +" local " + localBGP4Address);
		log.info("Do we want to update from peer?" + updateFrom);
		log.info("Do we want to send to peer?" + sendTo);
		try {
			Inet4Address addr = (Inet4Address) Inet4Address.getByName(localBGP4Address);
			Inet4Address addrPeer = (Inet4Address) Inet4Address.getByName(peerBGP_IPaddress);
			socket = new Socket(addrPeer, peerBGP_port, addr, 0);
			if (no_delay){
				this.socket.setTcpNoDelay(true);
				log.info("No delay activated");
			}
			log.info("Socket opened");
			//this.setRemotePeerId((Inet4Address)Inet4Address.getByName(peerBGP_IPaddress));
			
		} catch (IOException e) {
			log.severe("Couldn't get I/O for connection to " + peerBGP_IPaddress + " on port " + peerBGP_port);
			e.printStackTrace();
			//FIXME: Salir de manera limpia
			//System.exit(1);
			endSession();
			return;
		}			

		try {
			initializeBGP4Session();
		} catch (BGP4Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			log.info("La session ya existe");	
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		log.info("BGP4 Session succesfully established!!");
		
		this.keepAliveT= new KeepAliveThread(this.getOut(),this.keepAliveTimer);
		keepAliveT.start();
		
		try{
			while(this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP) {
				try {
//					if(params.isOptimizedRead()){
//						this.msg=readMsgOptimized(in);
//					}else {
						this.msg = readBGP4Msg(in);//Read a new message	
//					}

				}catch (IOException e){
					cancelDeadTimer();
					cancelKeepAlive();
					timer.cancel();
					try {
						in.close();
						out.close();
					} catch (Exception e1) {
						log.warning("AYAYAYYA");
					}
					log.warning("Finishing BGP4 Session abruptly!");
					return;
				}
				if (this.msg != null) {//If null, it is not a valid PCEP message			
					boolean bgp4Msg = true;//By now, we assume a valid PCEP message has arrived
					//Depending on the type a different action is performed
					switch(BGP4Message.getMessageType(this.msg)) {

					case BGP4MessageTypes.MESSAGE_OPEN:
						log.info("OPEN message received");
						//After the session has been started, ignore subsequent OPEN messages
						log.warning("OPEN message ignored");
						break;

					case BGP4MessageTypes.MESSAGE_KEEPALIVE:
						log.info("KEEPALIVE message received");
						//The Keepalive message allows to reset the deadtimer
						break;

					case BGP4MessageTypes.MESSAGE_NOTIFICATION:
						log.info("NOTIFICATION message received");
						break;

					case BGP4MessageTypes.MESSAGE_UPDATE:
						log.info("UPDATE message received");
						if(this.getUpdateFrom()){
						BGP4Update bgp4Update = new BGP4Update(msg);
						log.info(bgp4Update.toString());
						bgp4Update.setLearntFrom(this.getPeerBGP_IPaddress());
						updateDispatcher.dispatchRequests(bgp4Update);
						}
						else
							log.info("Update message from " + this.getPeerBGP_IPaddress() + " discarded");
						break;

					default:
						log.warning("ERROR: unexpected message received");
						bgp4Msg = false;
					}

					if (bgp4Msg) {
						log.info("Reseting Dead Timer as BGP4 Session Message has arrived");
						resetDeadTimer();
					}
				} 
			}
		}finally{
			//log.severe("SESSION "+ internalSessionID+" IS KILLED");
			log.severe("BGP4 SESSION WITH "+this.remotePeerId+" PEER IS KILLED");
			this.FSMstate=BGP4StateSession.BGP4_STATE_IDLE;
			endSession();
		}
	}
	

	public int getPeerBGP_port() {
		return peerBGP_port;
	}
	public void setPeerBGP_port(int peerBGP_port) {
		this.peerBGP_port = peerBGP_port;
	}
	public Boolean getUpdateFrom() {
		return updateFrom;
	}
	public void setUpdateFrom(Boolean updateFrom) {
		this.updateFrom = updateFrom;
	}
	public Boolean getSendTo() {
		return sendTo;
	}
	public void setSendTo(Boolean sendTo) {
		this.sendTo = sendTo;
	}
	public boolean isNo_delay() {
		return no_delay;
	}
	public void setNo_delay(boolean no_delay) {
		this.no_delay = no_delay;
	}

	public String getPeerBGP_IPaddress() {
		return peerBGP_IPaddress;
	}
	public void setPeerBGP_IPaddress(String peerBGP_IPaddress) {
		this.peerBGP_IPaddress = peerBGP_IPaddress;
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void endSession() {
		// TODO Auto-generated method stub
		log.info("Ending session with id "+this.getSessionId());
		BGP4SessionsInformation.deleteSession(this.getSessionId());
	}

}