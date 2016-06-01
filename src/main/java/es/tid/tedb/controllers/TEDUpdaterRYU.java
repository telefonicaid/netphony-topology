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


public class TEDUpdaterRYU extends TEDUpdaterController
{
	public static String controllerName = "RYU";
	private Hashtable<Integer,MyEdge> interDomainLinks = new Hashtable<Integer,MyEdge>();
	
	
	//Overwritten father variables and fixing the topology urls in code
	private String topologyPathNodes = "/v1.0/topology/switches";
	private String topologyPathLinks = "/v1.0/topology/links";
	
	public TEDUpdaterRYU(String ip, String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
	{
		super( ip,  port,  topologyPathLinks,  topologyPathNodes, ted,  log);
	}
	
	public TEDUpdaterRYU(String ip, String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log, Lock lock)
	{
		super( ip,  port,  topologyPathLinks,  topologyPathNodes, ted,  log,  lock);
	}
	
	public TEDUpdaterRYU(ArrayList<String> ips, ArrayList<String>ports , String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
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
			
			Hashtable<String,RouterInfoPM> nodes = new Hashtable<String,RouterInfoPM>();
			
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
	
	
	private String RYUtoFloodlight(String RYUFormat)
	{
		String floodFormat = new String(RYUFormat);
		//Por algo se me conoce como el hacker
		for (int i = 2; i < floodFormat.length(); i += 3)
		{
			floodFormat =  floodFormat.substring(0, i) + ":" + floodFormat.substring(i, floodFormat.length());
		}
		log.info("RYUFormat--> " + RYUFormat + ", floodFormat-->" + floodFormat);
		return floodFormat;
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
				
				log.info("(String)jsonObject.get(dpid)::"+(String)jsonObject.get("dpid"));
				
				RouterInfoPM rInfo = new RouterInfoPM();

				rInfo.setRouterID(RYUtoFloodlight((String)jsonObject.get("dpid")));
				rInfo.setConfigurationMode("Openflow");
				rInfo.setControllerType(TEDUpdaterRYU.controllerName);
				
				rInfo.setControllerIdentifier(ip, port);
				rInfo.setControllerIP(ip);
				rInfo.setControllerPort(port);
				
				routerInfoList.put(rInfo.getRouterID(),rInfo);
								
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
				
				JSONObject jsonObject_src = (JSONObject) jsonObject.get("src");
				JSONObject jsonObject_dst = (JSONObject) jsonObject.get("dst");

				RouterInfoPM source = nodes.get(RYUtoFloodlight((String)jsonObject_src.get("dpid")));
				RouterInfoPM dest = nodes.get(RYUtoFloodlight((String)jsonObject_dst.get("dpid")));
					
				//((SimpleTEDB)TEDB).getNetworkGraph().addVertex(source);
				//((SimpleTEDB)TEDB).getNetworkGraph().addVertex(dest);

				log.info("Adding Vertex->"+source+" hashcode:"+source.hashCode());
				log.info("Adding Vertex->"+dest+" hashcode:"+dest.hashCode());
					
				edge.setSrc_if_id(Long.parseLong((String) jsonObject_src.get("port_no")));
				edge.setDst_if_id(Long.parseLong((String) jsonObject_dst.get("port_no")));
				
				
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
				
				
				// En RYU los enlaces son unidirecctionales, pero asumimos que hay uno en una direccion
				// esta el otro
				isBidirectional = "bidirectional";
				
				//log.info("isBidirectional::"+isBidirectional);
				
				if ((1==1)||(isBidirectional != null) && (isBidirectional.equals("bidirectional")))
				{
					//((SimpleTEDB)TEDB).getNetworkGraph().addEdge(source, dest, edge);
					
					TE_Information tE_infoOtherWay = new TE_Information();
					tE_infoOtherWay.setNumberWLANs(15);
					tE_infoOtherWay.initWLANs();
					IntraDomainEdge edgeOtherWay= new IntraDomainEdge();

					edgeOtherWay.setSrc_if_id(Long.parseLong((String) jsonObject_src.get("port_no"))); 
					edgeOtherWay.setDst_if_id(Long.parseLong((String) jsonObject_dst.get("port_no"))); 
					edgeOtherWay.setTE_info(tE_infoOtherWay);
					
					((SimpleTEDB)TEDB).getNetworkGraph().addEdge(source, dest, edge);
					((SimpleTEDB)TEDB).getNetworkGraph().addEdge(dest, source, edgeOtherWay);
					
					completeTE_Information(tE_info, dest.getRouterID(), source.getRouterID());
					
					log.info("source::"+source);
					log.info("dest::"+dest);
					log.info("edgeOtherWay::"+edgeOtherWay);
					log.info("edge::"+edge);
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
			
			log.info("URL::"+"http://"+ip+":"+port+topologyPathLinks);
			
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
	
	public String getInterDomainFile() 
	{
		return interDomainFile;
	}

	public void setInterDomainFile(String interDomainFile) 
	{
		this.interDomainFile = interDomainFile;
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
}
