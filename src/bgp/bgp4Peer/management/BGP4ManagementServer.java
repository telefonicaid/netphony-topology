package tid.bgp.bgp4Peer.management;

import java.net.ServerSocket;
import java.util.logging.Logger;

import tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import tid.bgp.bgp4Peer.pruebas.BGP4Parameters;
import tid.bgp.bgp4Peer.pruebas.SendTopology;
import tid.bgp.bgp4Peer.tedb.IntraTEDBS;

import tid.pce.tedb.MultiDomainTEDB;
import tid.pce.tedb.SimpleTEDB;
import tid.pce.tedb.TEDB;
/**
 * To manage the server 
 * 
 * @author mcs
 *
 */
public class BGP4ManagementServer extends Thread {
	private Logger log;
	private int BGP4ManagementPort = 8888;
	private BGP4SessionsInformation bgp4SessionsInformation;
	/**
	 * Topology database for interDomain Links.
	 */
	private MultiDomainTEDB multiTEDB;
	/**
	 * Topology database for intradomain Links. It owns several domains.
	 */
	private IntraTEDBS intraTEDB;
	private SimpleTEDB simpleTEDB;
	/**
	 * Class to send the topology. It is needes to set the parameters sendTopology to true or false.
	 */
	private SendTopology sendTopology;
	
	public BGP4ManagementServer(int BGP4ManagementPort, MultiDomainTEDB multiTEDB, IntraTEDBS intraTEDB,SimpleTEDB simpleTEDB, BGP4SessionsInformation bgp4SessionsInformation, SendTopology sendTopology){
		log =Logger.getLogger("BGP4Server");
		this.BGP4ManagementPort = BGP4ManagementPort;
		this.multiTEDB=multiTEDB;
		this.intraTEDB=intraTEDB;
		this.bgp4SessionsInformation =bgp4SessionsInformation;
		this.sendTopology=sendTopology;
		this.simpleTEDB=simpleTEDB;
	}
	/**
	 * RUN
	 */
	public void run(){
	    ServerSocket serverSocket = null;
	    boolean listening=true;
		try {
	      	  log.info("Listening management on port "+BGP4ManagementPort);	
	          serverSocket = new ServerSocket(BGP4ManagementPort);
		  }
		catch (Exception e){
			 log.severe("Could not listen management on port "+BGP4ManagementPort);
			e.printStackTrace();
			return;
		}
		
		   try {
	        	while (listening) {
	        		new BGP4ManagementSession(serverSocket.accept(),multiTEDB,intraTEDB,bgp4SessionsInformation, sendTopology).start();
	        	}
	        	serverSocket.close();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }				
	}
}
