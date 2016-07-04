package es.tid.topologyModuleBase.reader;

import java.util.concurrent.locks.Lock;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;

public class TopologyReaderBGPLS extends TopologyReader{


		public TopologyReaderBGPLS(SimpleTopology ted, TopologyModuleParams params,
				Lock lock) 
		{
			super(ted, params, lock);
		}

		@Override
		public void readTopology() 
		{
			log.info("Acting as BGP Peer");
			BGPPeer bgpPeer = new BGPPeer();		

			//bgpPeer.configure("PCEServerConfiguration.xml");
			bgpPeer.configure(params.getBGPSConfigurationFile());
				
			bgpPeer.setReadDomainTEDB((SimpleTEDB)(ted.getDB()));
			bgpPeer.setSimpleTEDB((SimpleTEDB)(ted.getDB()));
			
			bgpPeer.createUpdateDispatcher();
			log.info("Testing change");
			//bgpPeer.startClient();		
			bgpPeer.startServer();
			bgpPeer.startManagementServer();
			//bgpPeer.startSendTopology();
			
		}
}


