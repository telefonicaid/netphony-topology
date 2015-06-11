package es.tid.bgp.bgp4Peer.pruebas;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Logger;

import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionClient;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionExistsException;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import es.tid.bgp.bgp4Peer.bgp4session.GenericBGP4Session;
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
	//Lista de "peers" configurados (a los que quiero conectarme)
	private String peer;
	private Inet4Address peerIP;
	private String localBGP4Address;
	private int localBGP4Port; 

	private int holdTime;
	private int keepAliveTimer;
	private Inet4Address BGPIdentifier;
	private int version = 4;
	private int myAutonomousSystem;
	private int bgp4Port;
	private UpdateDispatcher ud;
	private Boolean updateFrom;
	private Boolean sendTo;

	public BGP4SessionClientManager(BGP4SessionsInformation bgp4SessionInformation,UpdateDispatcher ud, String peer,int bgp4Port,String my_IPAddress,int  my_bgp4Port , int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem, int my_keepAliveTimer){	
		log=Logger.getLogger("BGP4Client");
		this.bgp4SessionInformation=bgp4SessionInformation;
		this.holdTime=holdTime;
		this.BGPIdentifier=BGPIdentifier;
		this.version = version;
		this.myAutonomousSystem=myAutonomousSystem;
		this.peer = peer;
		this.bgp4Port = bgp4Port;
		this.ud=ud;
		this.localBGP4Address=my_IPAddress;
		this.localBGP4Port=my_bgp4Port;
		this.keepAliveTimer = my_keepAliveTimer;
		try {
			this.peerIP=(Inet4Address)Inet4Address.getByName(this.peer);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
					log.severe("THREAD VIVO... SESION DE BACKUP MUERTA");

				}
				log.fine("Session viva y no interrumpida");
				return;	
			}
			else{
				try{
					bgp4SessionInformation.notifySessionStart(peerIP);	
					log.severe("Session with BGP-LS peer"+peer +" dead, trying to establish new session");
					bgp4SessionClient= new BGP4SessionClient(bgp4SessionInformation,ud,peer,bgp4Port,holdTime,BGPIdentifier,version,myAutonomousSystem,localBGP4Address, localBGP4Port,keepAliveTimer);
					bgp4SessionClient.start();
				} catch(BGP4SessionExistsException e){
					log.info("Checked that there is already a peer initiated session with "+this.peerIP);
				}

				return;
			}
		} else {
			try{
				bgp4SessionInformation.notifySessionStart(peerIP);		
				log.severe("No Session BGP with peer, trying to establish new session with peer "+ peer);
				bgp4SessionClient = new BGP4SessionClient(bgp4SessionInformation,ud, peer, bgp4Port, holdTime, BGPIdentifier,
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
		log.info("Cierro BGP4Session");
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