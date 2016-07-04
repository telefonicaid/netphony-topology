package es.tid.topologyModuleBase.reader;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;

import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.topologyModuleBase.updaters.RedisTEDUpdaterThread;
import es.tid.topologyModuleBase.updaters.TopologyUpdaterThread;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.FileTEDBUpdater;
import es.tid.tedb.ReachabilityEntry;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.ospfv2.OSPFSessionServer;
import es.tid.tedb.ospfv2.OSPFTCPSessionServer;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;
import es.tid.topologyModuleBase.util.UtilsFunctions;
/**
 * 
 * @author jaume
 *
 */
public class TopologyReaderOSPF extends TopologyReader
{

	public TopologyReaderOSPF(SimpleTopology ted, TopologyModuleParams params, Lock lock)
	{
		super(ted,params,lock);
	}
	
	@Override
	public void readTopology()
	{	
		LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue = new LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket>();		
		TopologyUpdaterThread tut = null;
		
		
		ReachabilityEntry reachabilityEntry = new ReachabilityEntry();

		FileTEDBUpdater.getDomainReachabilityFromFile(params.getReachabilityFile(),reachabilityEntry);
		
		//((SimpleTEDB)ted.getDB()).createGraph();
		((SimpleTEDB)ted.getDB()).setReachabilityEntry(reachabilityEntry);

		
		if (params.isMultilayer()==true)
		{
			tut = new TopologyUpdaterThread(ospfv2PacketQueue, (DomainTEDB)ted.getDB(),params.getLambdaIni(),params.getLambdaEnd(), params.isCompletedAuxGraph(), params.isMultilayer());		
		}
		else
		{
			tut = new TopologyUpdaterThread(ospfv2PacketQueue, (DomainTEDB)ted.getDB(),params.getLambdaIni(),params.getLambdaEnd());
		}
		tut.start();
		
		/*
		 * Code added to handle the redis topology update
		 * 
		 */
		
		boolean redisDatabase = true;
				
		LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue = new LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket>();
		if(redisDatabase)
		{
			RedisTEDUpdaterThread rtut = new RedisTEDUpdaterThread(redisOspfv2PacketQueue);
			rtut.start();			
		}
		
		if (params.isOSPFTCPSession())
		{
			OSPFTCPSessionServer OSPFsessionserver= new OSPFTCPSessionServer(ospfv2PacketQueue,redisOspfv2PacketQueue);
			OSPFsessionserver.setOSPFTCPPort(params.getOSPFTCPPort());
			OSPFsessionserver.start();	
		}
		else if (params.isOSPFSession())
		{
			System.out.println("Es OSPF Session");
			OSPFSessionServer OSPFsessionserver = null;
			try {
				
				/*
				 * Redis database
				 */
				
				if(redisDatabase){
				
					OSPFsessionserver = new OSPFSessionServer(ospfv2PacketQueue, redisOspfv2PacketQueue, ((Inet4Address) InetAddress.getByName(params.getOSPFListenerIP())));
					OSPFsessionserver.setMulticast(params.isOSPFSession());
					OSPFsessionserver.start();
				
					
				}
				else{
				
					OSPFsessionserver = new OSPFSessionServer(ospfv2PacketQueue, ((Inet4Address) InetAddress.getByName(params.getOSPFListenerIP())));
					OSPFsessionserver.setMulticast(params.isOSPFSession());
					OSPFsessionserver.start();
				}
			} 
			catch (UnknownHostException e) 
			{
				log.info(UtilsFunctions.exceptionToString(e));
			}
		}
	}
}
