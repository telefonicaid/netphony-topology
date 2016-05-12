package es.tid.bgp.bgp4Peer.peer;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionClient;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionExistsException;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import es.tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;

/**
 * Client session manager
 * @author mcs
 *
 */
public class BGP4SessionClientManager implements Runnable{



	private BGP4SessionClient bgp4SessionClient;
	private Logger log;

	BGP4SessionsInformation bgp4SessionInformation;
	/**
	 * peer contains the IP address and port where the peer listens.
	 */
	private BGP4LSPeerInfo peer;
	private Inet4Address peerIP;
	private String localBGP4Address;
	private int localBGP4Port; 
	private int holdTime;
	private int keepAliveTimer;
	private Inet4Address BGPIdentifier;
	private int version = 4;
	private int myAutonomousSystem;
	private UpdateDispatcher ud;
	private Boolean updateFrom;
	private Boolean sendTo;

	public BGP4SessionClientManager(BGP4SessionsInformation bgp4SessionInformation,UpdateDispatcher ud, BGP4LSPeerInfo peer,int bgp4Port,String my_IPAddress,int  my_bgp4Port , int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem, int my_keepAliveTimer){	
		log=LoggerFactory.getLogger("BGP4Client");
		this.bgp4SessionInformation=bgp4SessionInformation;
		this.holdTime=holdTime;
		this.BGPIdentifier=BGPIdentifier;
		this.version = version;
		this.myAutonomousSystem=myAutonomousSystem;
		this.peer = peer;
		this.ud=ud;
		this.localBGP4Address=my_IPAddress;
		this.localBGP4Port=my_bgp4Port;
		this.keepAliveTimer = my_keepAliveTimer;
		this.peerIP=peer.getPeerIP();
		this.setSendTo(peer.isSendToPeer());
		this.setUpdateFrom(peer.isUpdateFromPeer());
		
	}

	/**
	 * 
	 * 
	 * 
	 */
	public void run(){
		if(bgp4SessionClient != null){
			if (bgp4SessionClient.isAlive()){
				if (bgp4SessionClient.isInterrupted()){
					log.error("Thread alive... backup session dead");

				}
				log.debug("Session alive and not interrupted");
				return;	
			}
			else{
				try{
					bgp4SessionInformation.notifySessionStart(peerIP);	
					log.error("Session with BGP-LS peer"+peer +" dead, trying to establish new session");
					bgp4SessionClient= new BGP4SessionClient(bgp4SessionInformation,ud,peer.getPeerIP(),peer.getPeerPort(),holdTime,BGPIdentifier,version,myAutonomousSystem,localBGP4Address, localBGP4Port,keepAliveTimer);
					bgp4SessionClient.setSendTo(sendTo);
					bgp4SessionClient.setUpdateFrom(updateFrom);
					bgp4SessionClient.start();
				} catch(BGP4SessionExistsException e){
					log.info("Checked that there is already a peer initiated session with "+this.peerIP);
				}

				return;
			}
		} else {
			try{
				bgp4SessionInformation.notifySessionStart(peerIP);		
				log.error("No Session BGP with peer, trying to establish new session from"+this.localBGP4Address+"with peer "+ peer.getPeerIP()+":"+peer.getPeerPort());
				bgp4SessionClient = new BGP4SessionClient(bgp4SessionInformation,ud, peer.getPeerIP(), peer.getPeerPort(), holdTime, BGPIdentifier,
						version,myAutonomousSystem,localBGP4Address, localBGP4Port ,keepAliveTimer);
				bgp4SessionClient.setSendTo(sendTo);
				bgp4SessionClient.setUpdateFrom(updateFrom);
				bgp4SessionClient.start();

			} catch(BGP4SessionExistsException e){
				log.info("No need to start new connection with "+this.peerIP);
			}


			return;

		}

	}
	public BGP4SessionClient getBgp4SessionClient() {
		return bgp4SessionClient;
	}

	public void setBgp4SessionClient(BGP4SessionClient bgp4SessionClient) {
		this.bgp4SessionClient = bgp4SessionClient;
	}

	public void killBGP4Session(){
		bgp4SessionClient.killSession();
	}

	public void closeBGP4Session(){
		log.info("Closing BGP4Session");
		if (bgp4SessionClient.isAlive()){
			//FIXME reason for close????
			bgp4SessionClient.close();
		}

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

}
