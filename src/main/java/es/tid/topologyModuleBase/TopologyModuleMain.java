package es.tid.topologyModuleBase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.database.SimpleTopology;
import es.tid.topologyModuleBase.management.TMManagementServer;


/**
 *  
 * @author jaume
 *
 */

public class TopologyModuleMain 
{
	public static void  main(String []args)
	{
		
		TopologyModuleParamsArray params;
		
		if (args.length >=1 ){
			params=new TopologyModuleParamsArray(args[0]);
		}else{
			params=new TopologyModuleParamsArray();
		}
		params.initialize();	
		
		
		SimpleTopology sTop = new SimpleTopology(new SimpleTEDB());
		((SimpleTEDB)sTop.getDB()).createGraph();
		Lock lock = new ReentrantLock();
		
		
		TMManagementServer TMms=new TMManagementServer(sTop,params);
		TMms.start();
		
		(new TMModuleInitiater(sTop, params, lock)).intiate();
		
	}
	
}
