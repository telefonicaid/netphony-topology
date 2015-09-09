package es.tid.bgp.bgp4Peer.updateTEDB;

import java.net.Inet4Address;
import java.util.Hashtable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4Peer.tedb.IntraTEDBS;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TEDB;


/**
 * This class is in charge of storing the BGP4 update messages in a queue to be processing 
 * 
 * @author pac
 *
 */
public class UpdateDispatcher {
	
	private Logger log;
	private LinkedBlockingQueue<BGP4Update> updateList;
	private UpdateProccesorThread upt;

	
	public UpdateDispatcher(MultiDomainTEDB multiTedb,Hashtable<Inet4Address,SimpleTEDB> intraTEDBs ){
		this.updateList=new LinkedBlockingQueue<BGP4Update>();
		this.upt=new UpdateProccesorThread(updateList, multiTedb,intraTEDBs );		
		upt.start();
		log=Logger.getLogger("BGP4Server");
	}
	public void dispatchRequests(BGP4Update updateMessage){
		log.info("Adding update message to the queue");
		updateList.add(updateMessage);
	}



}
