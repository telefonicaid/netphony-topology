package tid.bgp.bgp4Peer.pruebas;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Logger;

import tid.bgp.bgp4Peer.bgp4session.BGP4SessionServer;
import tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;
import tid.pce.tedb.TEDB;

public class BGP4SessionServerManager implements Runnable {
	private BGP4SessionServer bgp4SessionServer;
	private Logger log;
	BGP4SessionsInformation bgp4SessionsInformation;
	int bgp4Port;
	private int holdTime;
	private int keepAliveTimer;
	private Inet4Address BGPIdentifier;
	private int version = 4;
	private int myAutonomousSystem;
	private boolean noDelay;
	private  TEDB tedb;
	private UpdateDispatcher ud;
	Inet4Address localBGP4Address; 
	public BGP4SessionServerManager(BGP4SessionsInformation bgp4SessionInformation, TEDB tedb,UpdateDispatcher ud, int bgp4Port,int holdTime,Inet4Address BGPIdentifier,int version,int myAutonomousSystem,boolean noDelay,Inet4Address localAddress ,int mykeepAliveTimer ){
		log = Logger.getLogger("BGP4Server");
		this.holdTime=holdTime;
		this.BGPIdentifier=BGPIdentifier;
		this.version = version;
		System.out.println("myAS7:"+myAutonomousSystem);
		this.myAutonomousSystem=myAutonomousSystem;
		this.bgp4SessionsInformation=bgp4SessionInformation;
		this.bgp4Port=bgp4Port;
		this.noDelay=noDelay;
		this.tedb=tedb;
		this.ud=ud;
		this.localBGP4Address=localAddress;
		this.keepAliveTimer = mykeepAliveTimer;
	}
	
	@Override
	public void run() {

		

		ServerSocket serverSocket = null;
		boolean listening = true;
		try {
			log.info("SERVER Listening on port: "+ bgp4Port);
			log.info("SERVER Listening on address: "+ localBGP4Address);
			serverSocket = new ServerSocket( bgp4Port,0,localBGP4Address);
		} catch (IOException e) {
			log.severe("Could not listen on port: "+ bgp4Port);
			System.exit(-1);
		}
		while (listening) {	
			try {
				bgp4SessionServer = new BGP4SessionServer(serverSocket.accept(),bgp4SessionsInformation,ud,holdTime,BGPIdentifier,version,myAutonomousSystem,noDelay,keepAliveTimer);		
				bgp4SessionServer.start();			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			log.info("Closing the socket");
			serverSocket.close();
		
		}catch (Exception e) {
				e.printStackTrace();
		}

	}

}