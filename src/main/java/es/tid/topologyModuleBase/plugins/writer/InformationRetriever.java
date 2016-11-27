package es.tid.topologyModuleBase.plugins.writer;


import java.util.concurrent.locks.Lock;

import com.google.gson.Gson;

import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
/**
 * 
 * @author jaume
 *
 */
public class InformationRetriever 
{
	
	TopologiesDataBase ted;
	TopologyModuleParams params;
	Lock lock;
	
	public InformationRetriever(TopologiesDataBase ted, TopologyModuleParams params, Lock lock)
	{
		this.ted = ted;
		this.params = params;
		this.lock = lock;
	}
	/*
	 * I wish Gson could handle a class like DomainTEDB this but it can't;
	public String getFullTopology(String domainID)
	{
		Gson gson = new Gson();
		
		lock.lock();
		TEDB ted = this.ted.getDB(domainID);
		lock.unlock();
		
		return gson.toJson(ted);
	}
	
	
	public String getFullTopology()
	{
		Gson gson = new Gson();
		
		lock.lock();
		TEDB ted = this.ted.getDB();
		lock.unlock();
		
		return gson.toJson(ted);
	}
	*/
	
	public String getNodes()
	{
		
		return getNodes("");
	}
	
	public String getNodes(String id)
	{
		
		Gson gson = new Gson();
		
		lock.lock();
		SimpleTEDB ted = (SimpleTEDB)(this.ted.getDB());
		lock.unlock();
		
		return gson.toJson(ted.getNetworkGraph().vertexSet());
	}
	
	public String getLinks()
	{
		return getLinks("");
	}
	
	public String getLinks(String id)
	{
		Gson gson = new Gson();
		
		lock.lock();
		SimpleTEDB ted = (SimpleTEDB)(this.ted.getDB());
		lock.unlock();
		
		return gson.toJson(ted.getNetworkGraph().edgeSet());
	}

}
