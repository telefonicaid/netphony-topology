package es.tid.topologyModuleBase.plugins.writer;

import java.util.concurrent.locks.Lock;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;

public class TopologyServerBGPLS extends TopologyServer
{
	private boolean isRunning;

	public TopologyServerBGPLS(TopologiesDataBase ted, TopologyModuleParams params,
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
			
		//bgpPeer.setReadDomainTEDB((SimpleTEDB)(ted.getDB()));
		//bgpPeer.setSimpleTEDB((SimpleTEDB)(ted.getDB()));
		bgpPeer.setIntraTEDBs(ted.getTeds());
		
		bgpPeer.createUpdateDispatcher();
		bgpPeer.startClient();		
		bgpPeer.startServer();
		bgpPeer.startManagementServer();
		bgpPeer.startSendTopology();	
		
	}
	
	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return isRunning;
	}

	@Override
	public String getPluginName() {
		// TODO Auto-generated method stub
		return "BGPLS exporter peer";
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

	@Override
	public void run() {
		serveTopology();
	}
}
