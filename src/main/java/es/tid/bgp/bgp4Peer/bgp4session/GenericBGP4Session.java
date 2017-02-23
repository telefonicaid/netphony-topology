package es.tid.bgp.bgp4Peer.bgp4session;

import es.tid.bgp.bgp4.messages.BGP4Keepalive;
import es.tid.bgp.bgp4.messages.BGP4Message;
import es.tid.bgp.bgp4.messages.BGP4MessageTypes;
import es.tid.bgp.bgp4.messages.BGP4Open;
import es.tid.bgp.bgp4.open.BGP4CapabilitiesOptionalParameter;
import es.tid.bgp.bgp4.open.BGP4OctetsASByteCapabilityAdvertisement;
import es.tid.bgp.bgp4.open.MultiprotocolExtensionCapabilityAdvertisement;
import es.tid.bgp.bgp4.update.fields.pathAttributes.AFICodes;
import es.tid.bgp.bgp4.update.fields.pathAttributes.SAFICodes;
import es.tid.bgp.bgp4Peer.peer.BGP4Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Timer;


/**
 * Generic BGP4 Session.
 * Implements the basics of a BGP4 Session
 * Any particular session must inherit this one
 * 
 * @author ogondio
 *
 */
public abstract class GenericBGP4Session extends Thread implements BGP4Session {

	/**
	 * PCEP Session Manager
	 */
	protected BGP4SessionsInformation BGP4SessionsInformation;

	/**
	 * Thread to send periodic Keepalives
	 */
	protected KeepAliveThread keepAliveT = null;

	/**
	 * Value of the Keepalive timer set by the Local PCE. Used to send keepalives
	 */

	protected int keepAliveLocal;

	/**
	 * Value of the Keepalive timer of the peer PCC. It is not used in the server!!!
	 */
	protected int keepAlivePeer;

	/**
	 * Thread to check if the connection is still alive. 
	 * If in this time the PCE has not received anything, it closes the session
	 * It is set by the PCC (in this case, the remote peer)
	 */
	protected DeadTimerThread deadTimerT = null; 

	/**
	 * Value of the deadtimer that the PCC sends. It is used in the PCC in the thread
	 */
	protected int deadTimerPeer;

	/**
	 * Socket of the communication between BGP peers
	 */
	protected Socket socket = null; 

	/**
	 * Remote Peer IP Address
	 * Obtained from the socket for convenience
	 */
	protected Inet4Address remotePeerIP=null;
	
	/**
	 * DataOutputStream to send messages to the peer 
	 */
	protected DataOutputStream out=null; 



	/**
	 * DataInputStream to receive messages from PCC
	 */
	protected DataInputStream in=null;//
	/**
	 * Queue to send the Computing Path Requests
	 */
	//protected RequestQueueSend req;

	/**
	 * Logger to write the Parent PCE server log
	 */
	protected Logger log;

	/**
	 * Timer to schedule KeepWait and OpenWait Timers
	 */
	protected Timer timer;

	/**
	 * Finite State Machine of the PCEP protocol
	 */
	protected int FSMstate;

	/**
	 * Remote Domain ID
	 * null if not sent
	 */
	protected Inet4Address remoteDomainId=null;

	/**
	 * Remote List of OF Codes
	 * If sent by the peer PCE
	 */
	//private LinkedList<Integer> remoteOfCodes;//FIME: What do we do with them?

	/**
	 * RemoteOK:  a boolean that is set to 1 if the system has received an
	      acceptable Open message.
	 */
	private boolean remoteOK=false;

	/**
	 * 
	 */
	private boolean localOK=false;

	/**
	 * 
	 */
	private int openRetry=0;

	/**
	 * Byte array to store the last PCEP message read.
	 */
	protected byte[] msg = null;

	/**
	 * Initial number of the session ID (internal use only)
	 */
	public static long sessionIdCounter=0;

	/**
	 * 
	 */
	protected Boolean updateFrom;
	protected boolean sendTo;

	/**
	 * Session ID (internal use only)
	 */
	private long sessionId;
	/**************** PARAMETROS DE LA SESION ********************/		
	private int ConnectRetryCounter=0;
	private ConnectRetryTimer connectRetryTimer = null;
	private int connectRetryTime; //FIXME: esto aun no se que es.

	/**************PARAMETROS OPEN MESSAGE************************/
	protected int holdTime;
	/**
	 * Time between sending keepalives
	 */
	protected int keepAliveTimer;
	/**
	 * IP address that is assigned to that BGP speaker
	 */
	protected Inet4Address BGPIdentifier;
	/**
	 * Autonomous System number of the sender
	 */
	protected int myAutonomousSystem;
	/**
	 * version indicates the protocol version number of the message
	 * it must be 4
	 */
	protected int version;


	public GenericBGP4Session(BGP4SessionsInformation bgp4SessionsInformation,int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem,int mykeepAliveTimer) {
		log=LoggerFactory.getLogger("BGP4Parser");
		this.BGP4SessionsInformation=bgp4SessionsInformation;
		this.holdTime=holdTime;
		this.BGPIdentifier=BGPIdentifier;
		this.version = version;
		this.myAutonomousSystem=myAutonomousSystem;
		this.keepAliveTimer = mykeepAliveTimer;
		this.newSessionId();

	}

	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 * @return byte array with a BGP4 Message
	 * @throws IOException Execption thrown trying to read message
	 */
	protected byte[] readBGP4Msg(DataInputStream in) throws IOException{
		byte[] ret = null;

		byte[] hdr = new byte[BGP4Message.getBGPHeaderLength()];
		byte[] temp = null;
		boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;

		while (!endMsg) {
			try {
				if (endHdr) {
					r = in.read(temp, offset, 1);
				}
				else {
					r = in.read(hdr, offset, 1);
				}
			} catch (IOException e){
				log.warn("Error reading data: "+ e.getMessage());
				throw e;
			}catch (Exception e) {
				log.warn("readMsg Oops: " + e.getMessage());
				throw new IOException();
			}

			if (r > 0) {
				if (offset == BGP4Message.getBGPMarkerLength()) {
					length = ((int)hdr[offset]&0xFF) << 8;
				}
				if (offset ==  BGP4Message.getBGPMarkerLength() + 1) {
					length = length | (((int)hdr[offset]&0xFF));
					temp = new byte[length];
					endHdr = true;
					System.arraycopy(hdr, 0, temp, 0, BGP4Message.getBGPHeaderLength());
				}
				if ((length > 0) && (offset == length - 1)) {
					endMsg = true;
				}
				offset++;
			}
			else if (r==-1){
				log.debug("End of stream has been reached");
				throw new IOException();
			}
		}
		if (length > 0) {
			ret = new byte[length];
			System.arraycopy(temp, 0, ret, 0, length);
		}		
		return ret;
	}

	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 * @return byte array with a BGP4 Message
	 * @throws IOException Execption thrown trying to read message
	 */
	protected byte[] readMsgOptimized(DataInputStream in) throws IOException{
		byte[] ret = null;

		byte[] hdr = new byte[4];
		byte[] temp = null;
		boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;


		while (!endMsg) {
			try {
				if (endHdr) {
					//log.info("Vamos a leer datos ");
					r = in.read(temp, offset, length-offset);
					if (r>0){
						if ((offset+r)>=length){
							//log.info("Bien ");
							endMsg=true;	
						}else {
							offset=offset+r;
						}

					}
					else if (r<0){
						log.error("End of stream has been reached reading data");
						throw new IOException();
					}
				}
				else {
					//log.info("Vamos a leer la cabecera ");
					r = in.read(hdr, offset, 4-offset);
					if (r < 0) {
						log.error("End of stream has been reached reading header");
						throw new IOException();
					}else if (r >0){
						if ((offset+r)>=4){
							length = ( (hdr[offset+2]&0xFF) << 8)  | ((hdr[offset+3]&0xFF));
							offset=4;
							temp = new byte[length];
							endHdr = true;
							System.arraycopy(hdr, 0, temp, 0, 4);
							if (length==4){
								endMsg=true;
							}		
						}else {
							offset=offset+r;
						}

					}

				}
			} catch (IOException e){
				log.error("Error reading data: "+ e.getMessage());
				throw e;
			}catch (Exception e) {
				log.error("readMsg Oops: " + e.getMessage());
				log.error("Failure reason : "+e.getStackTrace());
				throw new IOException();
			}

		}
		if (length > 0) {
			ret = new byte[length];
			System.arraycopy(temp, 0, ret, 0, length);
		}		
		return ret;
	}


	//		/**
	//		 * <p>Close the PCE session</p>
	//		 * <p>List of reasons (RFC 5440):</p>
	//		 *  Value        Meaning
	//	          1          No explanation provided
	//	          2          DeadTimer expired
	//	          3          Reception of a malformed PCEP message
	//	          4          Reception of an unacceptable number of unknown
	//	                     requests/replies
	//	          5          Reception of an unacceptable number of unrecognized
	//	                     PCEP messages
	//		 * @param reason Reason for closing the PCEP Session
	//		 * @return PCEP Session closed OK
	//		 */
	//		public void close(int reason){
	//			log.info("Closing PCEP Session"); 
	//			BGP4Close p_close=new BGP4Close();
	//			p_close.setReason(reason);
	//			sendPCEPMessage(p_close);
	//			killSession();
	//		}
	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	/**
	 * Starts the deadTimerThread
	 */
	protected void startDeadTimer() {
		this.deadTimerT.start();
	}
	/**
	 * Resets the DeadTimerThread
	 * To be called every time a message in the session is received
	 */
	protected void resetDeadTimer() {
		if (this.deadTimerT != null) {
			this.deadTimerT.interrupt();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	/**
	 * Ends the DeadTimer Thread
	 */
	protected void cancelDeadTimer() {
		log.debug("Cancelling DeadTimer");
		if (this.deadTimerT != null) {
			this.deadTimerT.stopRunning();
			this.deadTimerT.interrupt();
			this.deadTimerT=null;
		}
	}

	/**
	 * Starts the Keep Alive Thread
	 */
	public void startKeepAlive() {
		this.keepAliveT.start();		
	}

	/**
	 * Ends the KeepAlive Thread
	 */
	public void cancelKeepAlive() {
		log.debug("Cancelling KeepAliveTimer");
		if (this.keepAliveT != null) {
			this.keepAliveT.stopRunning();
			this.keepAliveT.interrupt();
			this.keepAliveT=null;	
		}
	}

	/**
	 * Ends current connections
	 */
	protected void endConnections(){
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (this.socket != null) {
				log.warn("Closing socket");
				this.socket.close();
			}

		} catch (Exception e) {
			log.warn("Error closing connections: " + e.getMessage());
		}
	}

	public int getFSMstate() {
		return FSMstate;
	}

	protected void setFSMstate(int fSMstate) {
		FSMstate = fSMstate;
	}

	public void killSession(){	
		log.warn("Killing Session");
		timer.cancel();
		this.endConnections();
		this.cancelDeadTimer();
		this.cancelKeepAlive();
		this.endSession();
		this.BGP4SessionsInformation.deleteSession(this.sessionId);
		log.warn("Interrupting thread!!!!");
		this.interrupt();				
	}

	/**
	 * DO HERE ANYTHING NEEDED AT CLOSING??
	 * STATISTICS, ETC
	 */
	protected abstract void endSession();

	protected void initializeBGP4Session() throws BGP4Exception {
		this.BGP4SessionsInformation.addSession(this.getSessionId(), this);

		/**
		 * Byte array to store the last PCEP message read.
		 */
		byte[] msg = null;
		//First get the input and output stream
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			log.warn("Problem in the sockets, ending BGP4Session");
			killSession();
			return;
		}
		//-	Starts the ConnectRetryTimer with initial value 
		int initialValue=1000;//FIXME: no tengo ni idea de este parametro aun
		connectRetryTimer= new ConnectRetryTimer(initialValue) ;

		//STARTING PCEP SESSION ESTABLISHMENT PHASE
		//It begins in Open Wait State
		this.setFSMstate(BGP4StateSession.BGP4_STATE_OPEN_WAIT);
		log.debug("Entering BGP4_STATE_OPEN_WAIT, Scheduling Open Wait Timer");

		//Create the 60 seconds Open Wait Timer to wait for an OPEN message
		OpenWaitTimerTask owtt= new OpenWaitTimerTask(this);
		this.timer.schedule(owtt, 60000);
		//Define (Not use yet), the keepwait timer
		KeepWaitTimerTask kwtt=new KeepWaitTimerTask(this);	
		BGP4Open open_msg=new BGP4Open();
		//Rellenar:
		// - My autonomous system
		// - holdTime
		// - BGPIdentifier
		open_msg.setMyAutonomousSystem(myAutonomousSystem);
		open_msg.setBGPIdentifier(BGPIdentifier);
		open_msg.setHoldTime(holdTime);
		//Chek optional parameters
		BGP4CapabilitiesOptionalParameter cop = new BGP4CapabilitiesOptionalParameter();
		open_msg.getParametersList().add(cop);	
		MultiprotocolExtensionCapabilityAdvertisement multProtExtCapAdv = new MultiprotocolExtensionCapabilityAdvertisement();
		multProtExtCapAdv.setAFI(AFICodes.AFI_BGP_LS);
		multProtExtCapAdv.setSAFI(SAFICodes.SAFI_BGP_LS);		
		cop.getCapabilityList().add(multProtExtCapAdv);
		BGP4OctetsASByteCapabilityAdvertisement fouroctects = new BGP4OctetsASByteCapabilityAdvertisement();
		fouroctects.setAS(myAutonomousSystem);
		cop.getCapabilityList().add(fouroctects);

		//Send the OPEN message
		this.sendBGP4Message(open_msg);
		//Now, read messages until we are in SESSION UP
		while (this.FSMstate!=BGP4StateSession.BGP4_STATE_SESSION_UP){
			//log.info("State session "+this.FSMstate);
			try {
				//Read a new message
				msg = readBGP4Msg(in);

			}catch (IOException e){
				log.warn("Error reading message, ending session"+e.getMessage());
				killSession();
				return;
			}
			if (msg != null) {//If null, it is not a valid PCEP message
				//log.info("Read a message");
				switch(BGP4Message.getMessageType(msg)) {
				case BGP4MessageTypes.MESSAGE_OPEN:
					//log.info("OPEN Message Received");
					if (this.FSMstate==BGP4StateSession.BGP4_STATE_OPEN_WAIT){
						log.debug("FSMstate = BGP4_STATE_OPEN_WAIT");
						BGP4Open open_received;
						//								try {
						open_received=new BGP4Open(msg);
						log.debug("**** Open received ****\n"+ open_received.toString());//FIXME!!! Cambiar a finest
						owtt.cancel();
						//Check parameters
						if (openRetry==1){
							boolean checkOK=true;
							this.version = open_received.getVersion();
							if (this.version != 4){
								checkOK=false;
							}
							//										this.deadTimerPeer=open_received.getDeadTimer();
							//										this.keepAlivePeer=open_received.getKeepalive();
							//										
							//										if (this.deadTimerPeer>maxDeadTimerAccepted){
							//											checkOK=false;
							//										}	
							//										if (this.deadTimerPeer==0){
							//											if(zeroDeadTimerAccepted==false){
							//												checkOK=false;
							//											}
							//										}
							//										if (this.keepAlivePeer<minimumKeepAliveTimerAccepted){
							//											checkOK=false;
							//										}									
							if (checkOK==false){
								log.debug("Dont accept");
								//											PCEPError perror=new PCEPError();
								//											PCEPErrorObject perrorObject=new PCEPErrorObject();
								//											perrorObject.setErrorType(ObjectParameters.ERROR_ESTABLISHMENT);
								//											perrorObject.setErrorValue(ObjectParameters.ERROR_ESTABLISHMENT_SECOND_OPEN_MESSAGE_UNACCEPTABLE_SESSION_CHARACTERISTICS);
								//											ErrorConstruct error_c=new ErrorConstruct();
								//											error_c.getErrorObjList().add(perrorObject);
								//											perror.setError(error_c);
								//											log.info("Sending Error and ending PCEPSession");
								//											sendPCEPMessage(perror);										
							}
							else {
								/**
								 *  If no errors are detected, and the session characteristics are
								 *	acceptable to the local system, the system:

	   												o  Sends a Keepalive message to the PCEP peer,
	   												o  Starts the Keepalive timer,
	   												o  Sets the RemoteOK variable to 1.
	   											If LocalOK=1, the system clears the OpenWait timer and moves to the
	   											UP state.
	   											If LocalOK=0, the system clears the OpenWait timer, starts the
	   											KeepWait timer, and moves to the KeepWait state.
								 */

								this.BGPIdentifier=open_received.getBGPIdentifier();
								this.myAutonomousSystem=open_received.getMyAutonomousSystem();
								this.holdTime=open_received.getHoldTime();
//								if (open_received.getOptionalParameterLength() != 0){
//									log.info("Tiene parametros opcionales");
//								}


								log.debug("OPEN Accepted");
								log.debug("Sending KA to confirm");
								BGP4Keepalive ka_snd= new BGP4Keepalive();
								log.debug("Sending Keepalive message");
								sendBGP4Message(ka_snd);										//Creates the Keep Wait Timer to wait for a KA to acknowledge the OPEN sent
								//FIXME: START KA TIMER!
								this.remoteOK=true;										
								if(this.localOK==true){
									log.debug("Entering STATE_SESSION_UP");
									this.setFSMstate(BGP4StateSession.BGP4_STATE_SESSION_UP);							
								}
								else {
									log.debug("Entering STATE_KEEP_WAIT");
									log.debug("Scheduling KeepwaitTimer");
									timer.schedule(kwtt, 60000);
									this.setFSMstate(BGP4StateSession.BGP4_STATE_KEEP_WAIT);
								}									
							}
						}
						else {//Open retry is 0
							log.debug("Open retry is equal to 0");
							boolean dtOK=true;
							//										boolean kaOK=true;
							this.version=open_received.getVersion();
							if (this.version != 4){
								dtOK=false;
							}										
							if (dtOK==false){
								///Parameters are unacceptable but negotiable
								log.debug("PEER  Open parameters are unaccpetable, but negotiable");
								//											PCEPError perror=new PCEPError();
								//											PCEPErrorObject perrorObject=new PCEPErrorObject();
								//											perrorObject.setErrorType(ObjectParameters.ERROR_ESTABLISHMENT);
								//											perrorObject.setErrorValue(ObjectParameters.ERROR_ESTABLISHMENT_UNACCEPTABLE_NEGOTIABLE_SESSION_CHARACTERISTICS);
								//											if (dtOK==false){
								//												open_received.setDeadTimer(this.deadTimerLocal);	
								//											}
								//											if (kaOK==false) {
								//												open_received.setKeepalive(this.keepAliveLocal);
								//											}
								//											LinkedList<PCEPErrorObject> perrobjlist=new LinkedList<PCEPErrorObject>(); 
								//											perrobjlist.add(perrorObject);
								//											perror.setErrorObjList(perrobjlist);
								//											perror.setOpen(open_received.getOpen());
								//											log.info("Sending Error with new proposal");
								//											this.sendPCEPMessage(perror);
								//											this.openRetry=this.openRetry+1;
								/**
								 * o  If LocalOK=1, the system restarts the OpenWait timer and stays in
	     											the OpenWait state.
	     											o  If LocalOK=0, the system clears the OpenWait timer, starts the
	     											KeepWait timer, and moves to the KeepWait state.
								 */
								if (localOK==true){
									//log.info("Local ok esta a true, vamos a open wait");
									owtt.cancel();
									owtt= new OpenWaitTimerTask(this);
									this.timer.schedule(owtt, 60000);
									this.setFSMstate(BGP4StateSession.BGP4_STATE_OPEN_WAIT);
								}
								else {
									//log.info("Local ok esta a false, vamos a keep wait");
									owtt.cancel();
									this.setFSMstate(BGP4StateSession.BGP4_STATE_KEEP_WAIT);
									this.timer.schedule(kwtt, 60000);
								}
							}
							else {
								/*
								 * If no errors are detected, and the session characteristics are
	   											acceptable to the local system, the system:
	   											o  Sends a Keepalive message to the PCEP peer,
	   											o  Starts the Keepalive timer,
	   											o  Sets the RemoteOK variable to 1.
	   											If LocalOK=1, the system clears the OpenWait timer and moves to the
	   											UP state.
	   											If LocalOK=0, the system clears the OpenWait timer, starts the
	   											KeepWait timer, and moves to the KeepWait state.
								 */
								this.BGPIdentifier=open_received.getBGPIdentifier();
								this.myAutonomousSystem=open_received.getMyAutonomousSystem();
								this.holdTime=open_received.getHoldTime();
//								if (open_received.getOptionalParameterLength() != 0){
//									log.info("Tiene parametros opcionales");
//								}
								//this.BGP4SessionsInformation.addSession(this.getSessionId(), this);
								BGP4Keepalive p_ka= new BGP4Keepalive();
								//log.info("Sending Keepalive message");
								sendBGP4Message(p_ka);										//Creates the Keep Wait Timer to wait for a KA to acknowledge the OPEN sent
								//FIXME: START KA TIMER!
								this.remoteOK=true;										
								if(this.localOK==true){
									//log.info("Entering STATE_SESSION_UP");
									//He conseguido establecer sesion. Hay que matar el otro hilo

									this.setFSMstate(BGP4StateSession.BGP4_STATE_SESSION_UP);
									//La sesion se ha establecido

								}
								else {
									//log.info("Entering STATE_KEEP_WAIT");
									//log.fine("Scheduling KeepwaitTimer");
									timer.schedule(kwtt, 60000);
									this.setFSMstate(BGP4StateSession.BGP4_STATE_KEEP_WAIT);
								}										
							}
						}								
					}
					else{
						log.debug("Ignore OPEN message, already one received!!");
					}

					break;
				case BGP4MessageTypes.MESSAGE_KEEPALIVE:
					//log.info("KeepAlive Message Received");
					this.localOK=true;
					if(this.FSMstate==BGP4StateSession.BGP4_STATE_KEEP_WAIT){
						// If RemoteOK=1, the system clears the KeepWait timer and moves to
						//  the UP state.
						// If RemoteOK=0, the system clears the KeepWait timer, starts the
						//  OpenWait timer, and moves to the OpenWait State. 

						if (remoteOK==true){
							kwtt.cancel();
							//log.info("Entering STATE_SESSION_UP");
							this.setFSMstate(BGP4StateSession.BGP4_STATE_SESSION_UP);								
						}
						else{
							kwtt.cancel();
							//log.info("Entering OPEN WAIT STATE");
							owtt=new OpenWaitTimerTask(this);
							this.timer.schedule(owtt, 60000);
							this.setFSMstate(BGP4StateSession.BGP4_STATE_OPEN_WAIT);
						}

					}
					//If not... seguimos igual que estabamos
					//Mas KA no hacen mal...
					break;

				default:
					log.error("UNEXPECTED Message Received");
					if (this.FSMstate!=BGP4StateSession.BGP4_STATE_OPEN_WAIT){
						log.debug("Ignore OPEN message, already one received!!");
					}
					else {
						log.error("Unexpected message RECEIVED, closing");

					}
					break;
				}
			}
			else {
				if (this.FSMstate!=BGP4StateSession.BGP4_STATE_OPEN_WAIT){
					log.info("Ignore message, already one received!!");
				}
				else {
					log.error("Unexpected message RECEIVED, closing");
	
				}
			}//Fin del else
		}//Fin del WHILE
	}


	@Override
	public void sendBGP4Message(BGP4Message message) {
		message.encode();
		try {
			out.write(message.getBytes());
			out.flush();
		} catch (Exception e) {
			log.error("Problem writing message, finishing session "+e.getMessage());
			killSession();
		}

	}


	public Inet4Address getRemotePeerIP() {
		return remotePeerIP;
	}


	public Inet4Address getBGPIdentifier() {
		return BGPIdentifier;
	}

	public void setBGPIdentifier(Inet4Address bGPIdentifier) {
		BGPIdentifier = bGPIdentifier;
	}

	public Boolean getUpdateFrom() {
		return updateFrom;
	}

	public void setUpdateFrom(Boolean updateFrom) {
		this.updateFrom = updateFrom;
	}

	public Boolean getSendTo(){
		return sendTo;
	}

	public void setSendTo(boolean sendTo) {
		this.sendTo = sendTo;
	}

	public int getMyAutonomousSystem() {
		return myAutonomousSystem;
	}

	public void setMyAutonomousSystem(int myAutonomousSystem) {
		this.myAutonomousSystem = myAutonomousSystem;
	}



	public String shortInfo(){
		StringBuffer sb=new StringBuffer(1000);
		if (this.socket!=null){
			sb.append("remAddr: ");
			sb.append(this.socket.getRemoteSocketAddress());
			sb.append(" state: ");
			if (this.FSMstate==BGP4StateSession.BGP4_STATE_OPEN_WAIT){
				sb.append("OPEN_WAIT");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_IDLE){
				sb.append("IDLE");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_KEEP_WAIT){
				sb.append("KEEP_WAIT");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP){
				sb.append("SESSION_UP");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP){
				sb.append("TCP_PENDING");
			}else {
				sb.append("UNKNOWN");
			}			

		}

		return sb.toString();
	}

	public String toString(){
		StringBuffer sb=new StringBuffer(1000);
		sb.append("\t> Session ID: "+this.sessionId+"\n");
		sb.append("\t> BGP Remote Peer: "+this.remotePeerIP+"\n");			
		sb.append("\t> BGPIdentifier: "+this.BGPIdentifier+"\n");
		if (this.socket!=null){
			sb.append("\t> remAddr: ");
			sb.append(this.socket.getRemoteSocketAddress()+"\n");
			sb.append("\t> state: ");
			if (this.FSMstate==BGP4StateSession.BGP4_STATE_OPEN_WAIT){
				sb.append("OPEN_WAIT\n");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_IDLE){
				sb.append("IDLE\n");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_KEEP_WAIT){
				sb.append("KEEP_WAIT\n");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP){
				sb.append("SESSION_UP\n");
			}else if (this.FSMstate==BGP4StateSession.BGP4_STATE_SESSION_UP){
				sb.append("TCP_PENDING\n");
			}else {
				sb.append("UNKNOWN");
			}
		}

		return sb.toString();
	}

	public synchronized void newSessionId(){
		this.sessionId=GenericBGP4Session.sessionIdCounter+1;
		sessionIdCounter=sessionIdCounter+1;
	}

	public long getSessionId() {
		return sessionId;
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object obj) {
		if (remotePeerIP != null){
			if (this.remotePeerIP.equals(((GenericBGP4Session)obj).getBGPIdentifier())){
				return true;
			}
		}
		else {
			log.info("TODO NUL!! en el equals!");
		}
		return false;
	}


	public Inet4Address getPeerIP(){
		return (Inet4Address)this.socket.getInetAddress();
	}
}
