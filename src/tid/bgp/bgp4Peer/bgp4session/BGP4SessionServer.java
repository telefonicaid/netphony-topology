package tid.bgp.bgp4Peer.bgp4session;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Timer;
import java.util.logging.Logger;

import tid.bgp.bgp4.messages.BGP4Message;
import tid.bgp.bgp4.messages.BGP4MessageTypes;
import tid.bgp.bgp4.messages.BGP4Update;
import tid.bgp.bgp4Peer.pruebas.BGP4Exception;
import tid.bgp.bgp4Peer.pruebas.BGP4Parameters;
import tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;

/**
 * BGP4 session server
 * 
 * @author mcs
 *
 */
public class BGP4SessionServer extends GenericBGP4Session{
	/**
	 * Class to dispatch the BGP4 update messages. 
	 * If a BGP5 update message is received, it is stored in a queue of UpdateDispatcher. 
	 */
	private UpdateDispatcher updateDispatcher;


	/**
	 * Constructor of the BGP4 Session
	 * @param s Socket of the BGP4Peer-BGP4Peer Communication
	 * @throws BGP4Exception 
	 */
	public BGP4SessionServer(Socket s, BGP4SessionsInformation bgp4SessionsInformation, UpdateDispatcher updateDispatcher,int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem,boolean noDelay,int keepAliveTimer ){
		super(bgp4SessionsInformation, holdTime, BGPIdentifier, version, myAutonomousSystem,keepAliveTimer);

		this.setFSMstate(BGP4StateSession.BGP4_STATE_IDLE);
		log=Logger.getLogger("BGP4Server");
		log.info("New BGP4Session: "+s);
		this.socket = s;
		try {
			s.setTcpNoDelay(noDelay);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.newSessionId();

		this.remotePeerId =(Inet4Address) ((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress();

			
		timer=new Timer();
		this.updateDispatcher = updateDispatcher;
		//this.keepAliveLocal=params.getKeepAliveTimer();
		//this.deadTimerLocal=params.getDeadTimer();
	}

	

	/**
	 * Initiates a Session between the Domain PCE and the peer PCC
	 */
	public void run() {
		try {
			initializeBGP4Session();
		} catch (BGP4Exception e2) {
			// TODO Auto-generated catch block
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		log.info("BGP4 Session succesfully established!!");	
		log.info("Hold time is "+this.holdTime);
		log.info("KeepAlive local "+this.keepAliveTimer);
		this.deadTimerT=new DeadTimerThread(this, this.holdTime);
		startDeadTimer();	
		this.keepAliveT=new KeepAliveThread(out, this.keepAliveTimer);
		startKeepAlive();

		//Listen to new messages
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
						log.warning("Exception Closing BGP4 Session!");
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
						BGP4Update bgp4Update = new BGP4Update(msg);
						log.info(bgp4Update.toString());
						bgp4Update.setLearntFrom(this.getRemotePeerId().toString());
						updateDispatcher.dispatchRequests(bgp4Update);
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

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void endSession() {
		// TODO Auto-generated method stub
		BGP4SessionsInformation.deleteSession(this.getSessionId());
	}

}