package es.tid.topologyModuleBase.plugins.reader;

import java.util.concurrent.locks.Lock;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;

public class TopologyReaderBGPLS extends TopologyReader{


		private boolean isRunning;

		public TopologyReaderBGPLS(TopologiesDataBase ted, TopologyModuleParams params,
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
		@Override
		public void run(){
			readTopology();
		}

		@Override
		public boolean isRunning() {
			// TODO Auto-generated method stub
			return isRunning;
		}

		@Override
		public String getPluginName() {
			// TODO Auto-generated method stub
			return "BGPLS importer peer";
		}

		@Override
		public String displayInfo() {
			// TODO Auto-generated method stub
			String str=getPluginName()+"\n";
			str+="Status: ";
			if(isRunning())str+="running";
			else str+="stop";
			str+="\nParameters file:"+params.getBGPSConfigurationFile();
			return str;
		}
}


