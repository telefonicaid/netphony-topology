package es.tid.topologyModuleBase.plugins.writer.gson;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.tid.provisioningManager.objects.RouterInfoPM;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.controllers.TEDUpdaterFloodlight;
import es.tid.topologyModuleBase.TopologyModuleParams;

public class GsonTest 
{
	
	static Logger log=Logger.getLogger("TMController");
	
	public static void main(String [] args)
	{
		
		TopologyModuleParams params;
		params=new TopologyModuleParams("/home/jaume/Desktop/TopologyModuleNoONE.xml");
		params.initialize();
		
		
		log.warning("Initializing TED from WLAN Controller");
		
		SimpleTEDB ted = new SimpleTEDB();
		
		
		//Thread thread = new TEDUpdaterFloodlight(params.getControllerIP(), params.getControllerPORT(), params.getTopologyPath(), params.getTopologyNodesPath(), ted, log);
		//thread.start();	
		
		
		Gson gson = new Gson();
		//String json = gson.toJson(ted); 
		

		Collection<IntraDomainEdge> links = ted.getIntraDomainLinks();
		Collection<Object> nodes = ted.getNetworkGraph().vertexSet();
		 
		//TE_Information te = new TE_Information(((IntraDomainEdge)(edge.toArray()[0])));
		//String json = gson.toJson(((IntraDomainEdge)(links.toArray()[0])));
		/*
		String json = gson.toJson(nodes); 
		
		Type collectionType = new TypeToken<Collection<RouterInfoPM>>(){}.getType();
		
		Collection<RouterInfoPM> recoveredNodes = gson.fromJson(json, collectionType);
		*/
		
		GsonTEDB gsonTed = new GsonTEDB(ted);
		String json = gson.toJson(gsonTed); 
		
		Type collectionType = new TypeToken<Collection<RouterInfoPM>>(){}.getType();
		
		class auxGsonClass
		{
			Collection<IntraDomainEdge> links;
			Collection<RouterInfoPM> nodes;
			
			public String toString()
			{
				return links +"|"+nodes;
			}
		}
		
		//auxGsonClass recoveredNodes = gson.fromJson(json, auxGsonClass.class);
		
		json = gson.toJson(nodes);
		Collection<RouterInfoPM> recoveredNodes = gson.fromJson(json, collectionType);
		
		
		collectionType = new TypeToken<Collection<IntraDomainEdge>>(){}.getType();
		String jsonLinks = gson.toJson(links);
		//Collection<IntraDomainEdge> recoverdLinks = gson.fromJson(jsonLinks, collectionType);
		
		log.info(json.toString());
		log.info("As JSON:::"+recoveredNodes);
		//log.info("Recoverd nodes::"+recoverdLinks.toString());
	}
}
