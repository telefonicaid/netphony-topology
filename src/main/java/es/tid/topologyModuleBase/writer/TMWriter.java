package es.tid.topologyModuleBase.writer;

import java.util.concurrent.locks.Lock;

import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;


public class TMWriter 
{
	SimpleTopology ted;
	TopologyModuleParams params;
	Lock lock;
	
	public static String serveGson = "serveGson";
	public static String serveBGPLS = "serveBGPLS";
	
	public TMWriter(SimpleTopology ted, TopologyModuleParams params, Lock lock)
	{
		this.ted = ted;
		this.params = params;
		this.lock = lock;
	}
	
	public void initServers()
	{
		System.out.println("Inside initServers::"+params.getInitFrom());
		String[] serve = params.getServers();
		System.out.println("initFrom.length:"+serve.length);
		for (int i = 0; i < serve.length; i++)
		{
			System.out.println("initFrom[i]:"+serve[i]);
			if (serve[i].equals(TMWriter.serveGson))
			{
				(new TopologyServerGson(ted, params,lock)).serveTopology();
			}
			if (serve[i].equals(TMWriter.serveBGPLS))
			{
				(new TopologyServerBGPLS(ted, params,lock)).serveTopology();
			}
		}
	}
}
