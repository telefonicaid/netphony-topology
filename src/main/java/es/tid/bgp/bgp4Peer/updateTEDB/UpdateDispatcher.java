package es.tid.bgp.bgp4Peer.updateTEDB;

import java.net.Inet4Address;
import java.util.Hashtable;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4Peer.tedb.IntraTEDBS;
import es.tid.tedb.DomainTEDB;
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

	
	public UpdateDispatcher(MultiDomainTEDB multiTedb,Hashtable<Inet4Address,DomainTEDB> intraTEDBs ){
		this.updateList=new LinkedBlockingQueue<BGP4Update>();
		this.upt=new UpdateProccesorThread(updateList, multiTedb,intraTEDBs );		
		upt.start();
		log=LoggerFactory.getLogger("BGP4Server");
	}
	public void dispatchRequests(BGP4Update updateMessage){
		updateList.add(updateMessage);
	}



}
