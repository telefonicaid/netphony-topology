package es.tid.topologyModuleBase.writer;

import java.util.concurrent.locks.Lock;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;

public class TopologyServerBGPLS extends TopologyServer
{
	public TopologyServerBGPLS(SimpleTopology ted, TopologyModuleParams params,
			Lock lock) 
	{
		super(ted, params, lock);
	}

	@Override
	public void serveTopology() 
	{
		log.info("Acting as BGP Peer");
		BGPPeer bgpPeer = new BGPPeer();		

		//bgpPeer.configure("PCEServerConfiguration.xml");
		bgpPeer.configure(params.getBGPSConfigurationFile());
			
		bgpPeer.setReadDomainTEDB((SimpleTEDB)(ted.getDB()));
		bgpPeer.setSimpleTEDB((SimpleTEDB)(ted.getDB()));
		
		bgpPeer.createUpdateDispatcher();
		bgpPeer.startClient();		
		bgpPeer.startServer();
		bgpPeer.startManagementServer();
		bgpPeer.startSendTopology();	
		
	}
}
