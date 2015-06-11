package es.tid.tedb.ospfv2;

import java.net.ServerSocket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;

public class OSPFTCPSessionServer extends Thread {
	
	private int OSPFTCPPort;
	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue;
	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue;
	/**
	 * OSPF logger
	 */
		private Logger log;
	
	public OSPFTCPSessionServer(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue, LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue){
		log=Logger.getLogger("OSPFParser");
		log.info("In OSPFTCPSessionServer");
		this.ospfv2PacketQueue = ospfv2PacketQueue;
		this.redisOspfv2PacketQueue = redisOspfv2PacketQueue;
		
		
	}
	
	public void run(){
		
	    ServerSocket serverSocket = null;
	    boolean listening=true;
	    
		try {
	      	  log.info("Listening on port OSPF::"+OSPFTCPPort);	
	          serverSocket = new ServerSocket(OSPFTCPPort);
		
		}
		catch (Exception e){
			
			log.severe("Could not listen management on port 8889");
			e.printStackTrace();
			return;
						
		}		
		try {
	        while (listening) {
	        	//Pasar la cola
	        	log.info("Accepting socket! OSPF");
	        	new OSPFTCPSession(serverSocket.accept(),this.ospfv2PacketQueue).start();
	        
	        }
	        
	       	serverSocket.close();
	       	
	    } catch (Exception e) {
	     
	    	e.printStackTrace();
	    
	    }
	    
	}
	
	public int getOSPFTCPPort() {
		return OSPFTCPPort;
	}

	public void setOSPFTCPPort(int oSPFTCPPort) {
		OSPFTCPPort = oSPFTCPPort;
	}

//	public int readOSPFTCPPort(){
//		return 7777;		
//	}
	
}
