package es.tid.tedb.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TE_Information;
import es.tid.tedb.elements.RouterInfoPM;

/**
 * Thread that reads topology from Openflow controller and from XML if there are intradomain links
 * @author jaume
 *
 */

public class TEDUpdaterFloodlight extends TEDUpdaterController
{
	public static String controllerName = "Floodlight";
	
	
	private String topologyPathLinks = "/wm/topology/links/json";
	private String topologyPathNodes = "/wm/core/controller/switches/json";
	
	public TEDUpdaterFloodlight(String ip,String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
	{
		super();
		ips = new ArrayList<String>();
		ports = new ArrayList<String>();
		
		ips.add(ip);
		ports.add(port);
		this.TEDB = (SimpleTEDB)ted;
		this.log = log;
	}
	
	public TEDUpdaterFloodlight(String ip, String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log, Lock lock)
	{
		super( ip,  port,  topologyPathLinks,  topologyPathNodes, ted,  log,  lock);
	}
	
	public TEDUpdaterFloodlight(ArrayList<String> ips, ArrayList<String>ports , String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
	{
		super(ips, ports ,  topologyPathLinks,  topologyPathNodes, ted,  log);
	}
	
	
	
	
	
	
	@Override
	public void run()
	{	
		
		if(interDomainFile != null)
		{
			interDomainLinks = TEDUpdaterController.readInterDomainFile(interDomainFile);
		}
		
		String responseLinks = "";
		String responseNodes = "";
		
		try
		{
			//log.info("TopologyUpdaterWLAN thread, Updating TEDB");
			
			Hashtable<String,RouterInfoPM> nodes = new Hashtable<String,RouterInfoPM>();
			
			
			log.info("ips.size():"+ips.size());
			
			for (int i = 0; i < ips.size(); i++)
			{
				responseNodes = queryForNodes(ips.get(i), ports.get(i));
				parseNodes(responseNodes, nodes, ips.get(i), ports.get(i));
				log.info("responseNodes:::"+responseNodes);
			}
			
			for (int i = 0; i < ips.size(); i++)
			{			
				responseLinks = queryForLinks(ips.get(i), ports.get(i));	
						
		        log.info("responseLinks:::"+responseLinks);
		        
		        lock();
		        parseLinks(responseLinks, nodes);
		        unlock();
	        
			}
			
	        			
	        //parseJSON("[{\"src-switch\":\"00:14:2c:59:e5:5e:2b:00\",\"src-port\":20,\"src-port-state\":0,\"dst-switch\":\"00:14:2c:59:e5:64:21:00\",\"dst-port\":19,\"dst-port-state\":0,\"type\":\"internal\"},{\"src-switch\":\"00:14:2c:59:e5:64:21:00\",\"src-port\":19,\"src-port-state\":0,\"dst-switch\":\"00:14:2c:59:e5:5e:2b:00\",\"dst-port\":20,\"dst-port-state\":0,\"type\":\"internal\"},{\"src-switch\":\"00:14:2c:59:e5:66:ed:00\",\"src-port\":9,\"src-port-state\":0,\"dst-switch\":\"00:14:2c:59:e5:64:21:00\",\"dst-port\":20,\"dst-port-state\":0,\"type\":\"internal\"},{\"src-switch\":\"00:14:2c:59:e5:64:21:00\",\"src-port\":20,\"src-port-state\":0,\"dst-switch\":\"00:14:2c:59:e5:66:ed:00\",\"dst-port\":9,\"dst-port-state\":0,\"type\":\"internal\"}]");
	        //System.out.println(response);
		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
	}
	
	

	private void parseNodes(String response, Hashtable<String,RouterInfoPM> routerInfoList, String ip, String port)
	{	
		try
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(response);
		
			JSONArray msg = (JSONArray) obj;
			Iterator<JSONObject> iterator = msg.iterator();
			while (iterator.hasNext()) 
			{
				JSONObject jsonObject = (JSONObject) iterator.next();
				
				RouterInfoPM rInfo = new RouterInfoPM();
				rInfo.setMacAddress((String)jsonObject.get("mac"));
				rInfo.setRouterID((String)jsonObject.get("dpid"));
				rInfo.setControllerType(TEDUpdaterFloodlight.controllerName);
				
				
				JSONArray ports = (JSONArray) jsonObject.get("ports");
				Iterator<JSONObject> portIterator = ports.iterator();
				while (portIterator.hasNext()) 
				{
					JSONObject jsonPortObject = (JSONObject) portIterator.next();
					rInfo.setMacAddress((String)jsonPortObject.get("hardwareAddress"));
				}
				
				log.info("(String)((JSONObject)jsonObject.get(description)).get(manufacturer)::"+(String)((JSONObject)jsonObject.get("description")).get("manufacturer"));
				rInfo.setRouterType((String)((JSONObject)jsonObject.get("description")).get("manufacturer"));
				rInfo.setConfigurationMode("Openflow");
				
				rInfo.setControllerIdentifier(ip, port);
				rInfo.setControllerIP(ip);
				rInfo.setControllerPort(port);
				rInfo.setHardware((String)((JSONObject)jsonObject.get("description")).get("hardware"));
				
				routerInfoList.put(rInfo.getRouterID(),rInfo);
				
				
				log.info("Adding Vertex::"+rInfo);
				((SimpleTEDB)TEDB).getNetworkGraph().addVertex(rInfo);
			}
		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
	}
	
	private void parseLinks(String links,Hashtable<String,RouterInfoPM> nodes)
	{
		try {
			//log.info("Inside parseJSON");
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(links);
		
			JSONArray msg = (JSONArray) obj;
			Iterator<JSONObject> iterator = msg.iterator();
			while (iterator.hasNext()) 
			{
				JSONObject jsonObject = (JSONObject) iterator.next();
				//System.out.println(jsonObject.get("src-switch"));
				IntraDomainEdge edge= new IntraDomainEdge();

				RouterInfoPM source = nodes.get(jsonObject.get("src-switch"));
				RouterInfoPM dest = nodes.get(jsonObject.get("dst-switch"));
				
				
				//((SimpleTEDB)TEDB).getNetworkGraph().addVertex(source);
				//((SimpleTEDB)TEDB).getNetworkGraph().addVertex(dest);

				log.info("Adding Vertex->"+source+" hashcode:"+source.hashCode());
				log.info("Adding Vertex->"+dest+" hashcode:"+dest.hashCode());
				
				edge.setSrc_if_id((Long)jsonObject.get("src-port"));
				edge.setDst_if_id((Long)jsonObject.get("dst-port"));
				
				
				  // This is a big problem because info is not initialized from file
				  // and the controller doesn't give information about how many wlans
				  // the are
				
				TE_Information tE_info = new TE_Information();
				tE_info.setNumberWLANs(15);
				tE_info.initWLANs();
				
				if (interDomainFile != null)
				{
					completeTE_Information(tE_info, source.getRouterID(), dest.getRouterID());
				}
				
				edge.setTE_info(tE_info);
				
				String isBidirectional = (String)jsonObject.get("direction");
				
				
				
				//log.info("isBidirectional::"+isBidirectional);
				
				if ((1==1)||(isBidirectional != null) && (isBidirectional.equals("bidirectional")))
				{
					//((SimpleTEDB)TEDB).getNetworkGraph().addEdge(source, dest, edge);
					
					TE_Information tE_infoOtherWay = new TE_Information();
					tE_infoOtherWay.setNumberWLANs(15);
					tE_infoOtherWay.initWLANs();
					IntraDomainEdge edgeOtherWay= new IntraDomainEdge();
					
					edgeOtherWay.setSrc_if_id((Long)jsonObject.get("dst-port"));
					edgeOtherWay.setDst_if_id((Long)jsonObject.get("src-port"));
					edgeOtherWay.setTE_info(tE_infoOtherWay);
					
					((SimpleTEDB)TEDB).getNetworkGraph().addEdge(source, dest, edge);
					((SimpleTEDB)TEDB).getNetworkGraph().addEdge(dest, source, edgeOtherWay);
					
					completeTE_Information(tE_info, dest.getRouterID(), source.getRouterID());
					
					log.info("source::"+source);
					log.info("dest::"+dest);
					log.info("edgeOtherWay::"+edgeOtherWay);
					log.info("edge::"+edge);
					//log.info("Adding two!");
				}
				else
				{
					((SimpleTEDB)TEDB).getNetworkGraph().addEdge(source, dest, edge);
				}
				
				//log.info("Edge added:"+edge);
				//log.info(((SimpleTEDB)TEDB).getIntraDomainLinks().toString());
			}
			//parseRemainingLinksFromXML(nodes);
	 
		} 
		catch (Exception e)
		{
			log.info(e.toString());
		}
	}

	private void completeTE_Information(TE_Information tE_info, String source, String dest) 
	{
		MyEdge auxEdge = new MyEdge(source, dest);
		MyEdge completEdge = interDomainLinks.get(auxEdge.hashCode());
		if ((completEdge != null)&&(completEdge.vlan != null))
		{
			tE_info.setVlanLink(true);
			tE_info.setVlan(completEdge.vlan);
			//If it has been found it will be removed so the rest can be proccessed later
			interDomainLinks.remove(completEdge.vlan);
		}
		else
		{
			tE_info.setVlanLink(false);
		}
	}

	private String queryForLinks(String ip, String port)
	{
		String response = ""; 
		try
		{
			URL topoplogyURL = new URL("http://"+ip+":"+port+topologyPathLinks);
			
			//log.info("URL::"+"http://"+ip+":"+port+topologyPathLinks);
			
	        URLConnection yc = topoplogyURL.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        String inputLine;
	
	        while ((inputLine = in.readLine()) != null) 
	        {
	        	response = response + inputLine;
	        }
		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
        return response;
	}
	
	private String queryForNodes(String ip, String port)
	{
        String response = "";
		try
		{
			URL topoplogyURL = new URL("http://"+ip+":"+port+topologyPathNodes);
			
			log.info("http://+port+topologyPathNodes:::"+"http://"+ip+":"+port+topologyPathNodes);
			
	        URLConnection yc = topoplogyURL.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        
	        String inputLine;	
	        while ((inputLine = in.readLine()) != null) 
	        {
	        	response = response + inputLine;
	        }
	        in.close();
		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
        return response;
	}
	
	private void lock()
	{
		if (lock != null)
		{
			lock.lock();
		}
	}
	
	private void unlock()
	{
		if (lock != null)
		{
			lock.unlock();
		}
	}
	
	private String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		} else {
			return "?";
		}
	}
}
