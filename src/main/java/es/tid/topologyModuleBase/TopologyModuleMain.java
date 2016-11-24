package es.tid.topologyModuleBase;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import es.tid.tedb.MDTEDB;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.management.TMManagementServer;
import es.tid.topologyModuleBase.plugins.TMPlugin;
import es.tid.tedb.MultiDomainTEDB;

/**
 *  
 * @author jaume
 *
 */

public class TopologyModuleMain 
{
	public static void  main(String []args)
	{
		ArrayList<TMPlugin> pluginsList = new ArrayList<TMPlugin>();
		TopologyModuleParamsArray params;
		
		if (args.length >=1 ){
			params=new TopologyModuleParamsArray(args[0]);
		}else{
			params=new TopologyModuleParamsArray();
		}
		params.initialize();	
		
		
		TopologiesDataBase sTop = new TopologiesDataBase();
		
//	    sTop.addTEDB("255.255.255.255", new SimpleTEDB() );
//		
//		((SimpleTEDB)sTop.getDB()).createGraph();
//		
		MultiDomainTEDB mdTed = new MDTEDB();
		sTop.setMdTed(mdTed);
		
		//((SimpleTEDB)sTop.getDB()).createGraph();
		Lock lock = new ReentrantLock();
		
		
		TMManagementServer TMms=new TMManagementServer(sTop,params,pluginsList);
		TMms.start();
		
		(new TMModuleInitiater(sTop, params, lock, pluginsList)).intiate();
		
	}
	
}
