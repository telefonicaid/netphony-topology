package tid.bgp.bgp4Peer.updateTEDB;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;
import tid.bgp.bgp4.messages.BGP4Update;
import tid.bgp.bgp4Peer.tedb.IntraTEDBS;

import tid.pce.tedb.MultiDomainTEDB;
import tid.pce.tedb.SimpleTEDB;
import tid.pce.tedb.TEDB;


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

	
	public UpdateDispatcher(MultiDomainTEDB multiTedb,SimpleTEDB simpleTEDB ){
		this.updateList=new LinkedBlockingQueue<BGP4Update>();
		this.upt=new UpdateProccesorThread(updateList, multiTedb,simpleTEDB );		
		upt.start();
		log=Logger.getLogger("BGP4Server");
	}
	public void dispatchRequests(BGP4Update updateMessage){
		log.info("Adding update message to the queue");
		updateList.add(updateMessage);
	}



}
