package es.tid.topologyModuleBase.management;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Logger;

import es.tid.topologyModuleBase.TopologyModuleParamsArray;
import es.tid.topologyModuleBase.database.SimpleTopology;

/**
 * 
 * @author valors
 *
 */

public class TMManagementServer extends Thread {
	
	private Logger log;
		
	private SimpleTopology tedb;
	 
	private TopologyModuleParamsArray params;
	
	public TMManagementServer(SimpleTopology tedb, TopologyModuleParamsArray params){
		log =Logger.getLogger("TMController");
		this.tedb=tedb;
		this.params = params;
		
	}
	
	public void run(){
	    ServerSocket serverSocket = null;
	    boolean listening=true;
		try {
	      	  log.info("Listening on port "+params.getMangementPort());	
	          serverSocket = new ServerSocket(params.getMangementPort(), 0,(Inet4Address) InetAddress.getByName(params.getMangementIP()));
		  }
		catch (Exception e){
			 log.severe("Could not listen management on port "+params.getMangementPort());
			e.printStackTrace();
			return;
		}
		
		try {
	       	while (listening) {
	       		new TMManagementSession(serverSocket.accept(), tedb, params).start();
	       	}	    
	       	serverSocket.close();
		} catch (Exception e) {
	       	e.printStackTrace();
		}				
	}
}
