package es.tid.bgp.bgp4Peer.bgp4session;

import es.tid.bgp.bgp4.messages.BGP4Message;
import es.tid.bgp.bgp4.messages.BGP4MessageTypes;
import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4Peer.peer.BGP4Exception;
import es.tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Timer;
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
	private String localBGP4Address;
	private int localBGP4Port; 
	/**
	 * Class to dispatch the BGP4 update messages. 
	 * If a BGP5 update message is received, it is stored in a queue of UpdateDispatcher. 
	 */
	private UpdateDispatcher updateDispatcher;
	
	public BGP4SessionClient(BGP4SessionsInformation bgp4SessionsInformation,UpdateDispatcher updateDispatcher, Inet4Address peerBGP_IPaddress, int peerBGP_port, int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem, String localBGP4Address, int localBGP4Port,int keepAliveTimer){
		super(bgp4SessionsInformation, holdTime, BGPIdentifier, version, myAutonomousSystem,keepAliveTimer);
		timer=new Timer();
		log = LoggerFactory.getLogger("BGP4Client");		
		this.peerBGP_port = peerBGP_port;
		this.updateDispatcher=updateDispatcher;
		this.localBGP4Address=localBGP4Address;
		this.localBGP4Port=localBGP4Port;
		this.remotePeerIP = peerBGP_IPaddress;
	}
	/**
	 * Initiates a Session between the local BGP Peer and the remote BGP Peer
	 */
	public void run() {
	
		log.debug("Opening new BGP4 Session with host "+ this.remotePeerIP.getHostAddress() + " on port " + this.peerBGP_port);
		log.debug("Do we want to update from peer?" + updateFrom);
		log.debug("Do we want to send to peer?" + sendTo);
		try {
			Inet4Address addr = (Inet4Address) Inet4Address.getByName(localBGP4Address);
			Inet4Address addrPeer = remotePeerIP;
			socket = new Socket(addrPeer, peerBGP_port, addr, 0);
			if (no_delay){
				this.socket.setTcpNoDelay(true);
				log.debug("No delay activated");
			}
			
		} catch (IOException e) {
			log.error("Connection refused trying to connect " + remotePeerIP.getHostAddress() + " on port " + peerBGP_port);
			//As there is not yet a session added (it is added in the beginning of initializeBGP4Session());
			//endSession();
			return;
		}			

		try {
			initializeBGP4Session();
			log.info("BGP4 Session established with peer "+this.remotePeerIP);
			this.keepAliveT= new KeepAliveThread(this.getOut(),this.keepAliveTimer);
			keepAliveT.start();
		} catch (BGP4Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			log.error("Session with "+this.remotePeerIP+" already exists: "+e2.getMessage());
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Problem closing socket "+e.getMessage());
			}
			return;
		}
		
		
		
		
		try{
			while(this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP) {
				try {

					this.msg = readBGP4Msg(in);//Read a new message	

				}catch (IOException e){
					cancelDeadTimer();
					cancelKeepAlive();
					timer.cancel();		
					try {
						in.close();
						out.close();
					} catch (Exception e1) {
						log.warn("problem closing sockets");
					}
					log.debug("Finishing BGP4 Session abruptly!");
					return;
				}
				if (this.msg != null) {//If null, it is not a valid PCEP message			
					boolean bgp4Msg = true;//By now, we assume a valid PCEP message has arrived
					//Depending on the type a different action is performed
					switch(BGP4Message.getMessageType(this.msg)) {

					case BGP4MessageTypes.MESSAGE_OPEN:
						log.debug("BGP OPEN message received from "+this.remotePeerIP);
						//After the session has been started, ignore subsequent OPEN messages
						log.warn("OPEN message ignored");
						break;

					case BGP4MessageTypes.MESSAGE_KEEPALIVE:
						log.debug("BGP KEEPALIVE message received from "+this.remotePeerIP);
						//The Keepalive message allows to reset the deadtimer
						break;

					case BGP4MessageTypes.MESSAGE_NOTIFICATION:
						log.debug("BGP NOTIFICATION message received from "+this.remotePeerIP);
						break;

					case BGP4MessageTypes.MESSAGE_UPDATE:
						log.debug("BGP UPDATE message received from "+this.remotePeerIP);
						if(this.getUpdateFrom()){
							BGP4Update bgp4Update = new BGP4Update(msg);
							log.debug(bgp4Update.toString());
							bgp4Update.setLearntFrom(this.remotePeerIP.getHostAddress() );
							updateDispatcher.dispatchRequests(bgp4Update);
						}
						else
							log.debug("Update message from " + this.remotePeerIP + " discarded");
						break;

					default:
						log.warn("ERROR: unexpected message received");
						bgp4Msg = false;
					}

					if (bgp4Msg) {
						//Reseting Dead Timer as BGP4 Session Message has arrived
						resetDeadTimer();
					}
				} 
			}
		}finally{
			//log.error("SESSION "+ internalSessionID+" IS KILLED");
			log.info("BGP4 session with peer "+this.remotePeerIP+" has been closed");
			cancelDeadTimer();
			cancelKeepAlive();
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


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void endSession() {
		// TODO Auto-generated method stub
		log.debug("Ending session with id "+this.getSessionId());
		this.BGP4SessionsInformation.deleteSession(this.getSessionId());
	}

}
