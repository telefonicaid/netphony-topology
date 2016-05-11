package es.tid.tedb.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TE_Information;
import es.tid.tedb.elements.RouterInfoPM;

/**
 * 
 * @author jaume i la humiltat
 *
 *
 * Class that receives a DomainTED and updates. Then it dies.
 */

public class TEDUpdaterController extends Thread
{
	protected Hashtable<Integer,MyEdge> interDomainLinks = new Hashtable<Integer,MyEdge>();
	protected ArrayList<String> ips = null;
	protected ArrayList<String> ports = null;
	protected String topologyPathNodes = "";
	protected String topologyPathLinks = "";
	protected SimpleTEDB TEDB;
	protected Logger log;
	protected Lock lock = null;
	protected String interDomainFile = null;
	
	public TEDUpdaterController(){};
	
	public TEDUpdaterController(String ip, String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
	{
		ips = new ArrayList<String>();
		ports = new ArrayList<String>();
		
		ips.add(ip);
		ports.add(port);
		
		this.topologyPathLinks = topologyPathLinks;
		this.topologyPathNodes = topologyPathNodes;
		this.TEDB = (SimpleTEDB)ted;
		this.log = log;
	}
	
	
	public TEDUpdaterController(String ip, String port, String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log, Lock lock)
	{
		ips = new ArrayList<String>();
		ports = new ArrayList<String>();
		
		ips.add(ip);
		ports.add(port);
		
		this.topologyPathLinks = topologyPathLinks;
		this.topologyPathNodes = topologyPathNodes;
		this.TEDB = (SimpleTEDB)ted;
		this.log = log;
		this.lock = lock;
	}
	
	public TEDUpdaterController(ArrayList<String> ips, ArrayList<String>ports , String topologyPathLinks, String topologyPathNodes,DomainTEDB ted, Logger log)
	{
		this.ips = ips;
		this.ports = ports;
		this.topologyPathLinks = topologyPathLinks;
		this.topologyPathNodes = topologyPathNodes;
		this.TEDB = (SimpleTEDB)ted;
		this.log = log;
	}
	
	public static void parseRemainingLinksFromXML(DomainTEDB TEDB, String interDomainFile) 
	{
		Hashtable<Integer,MyEdge> interDomainLinks = readInterDomainFile(interDomainFile);
		Map<Integer, MyEdge> map = interDomainLinks;
		Iterator<Map.Entry<Integer, MyEdge>> it = map.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry<Integer, MyEdge> entry = it.next();

			MyEdge edgeAux = entry.getValue(); 
			
			IntraDomainEdge edge= new IntraDomainEdge();
			edge.setSrc_if_id(new Long(edgeAux.source_port));
			edge.setDst_if_id(new Long(edgeAux.dest_port));
			
			TE_Information tE_info = new TE_Information();
			tE_info.setNumberWLANs(15);
			tE_info.initWLANs();
			
			tE_info.setVlanLink(true);
			tE_info.setVlan(edgeAux.vlan);
			
			edge.setTE_info(tE_info);
			
			
			System.out.println("Adding InterDomain Edge!!::Vlan::"+edgeAux.vlan);
			
			
			SimpleDirectedWeightedGraph sdwg =  ((SimpleTEDB)TEDB).getNetworkGraph();
			if (!sdwg.containsVertex(new RouterInfoPM(edgeAux.source)))
			{
				sdwg.addVertex(new RouterInfoPM(edgeAux.source));
			}
			
			if (!sdwg.containsVertex(new RouterInfoPM(edgeAux.dest)))
			{
				sdwg.addVertex(new RouterInfoPM(edgeAux.dest));
			}
			
			
			((SimpleTEDB)TEDB).getNetworkGraph().addEdge(new RouterInfoPM(edgeAux.source), new RouterInfoPM(edgeAux.dest), edge);
		}
	}
	
	
	public static Hashtable<Integer, MyEdge> readInterDomainFile(String interDomainFile) 
	{
		System.out.println("Parsing intradomain File");
		Hashtable<Integer, MyEdge>  interDomainLinks = new Hashtable<Integer,MyEdge>();
		try 
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File confFile = new File(interDomainFile);		
			Document doc = builder.parse(confFile);
			
			NodeList list_nodes_Edges = doc.getElementsByTagName("edge");
			System.out.println("num edges: " + list_nodes_Edges.getLength());
			for (int i = 0; i < list_nodes_Edges.getLength(); i++) 
			{
				Element nodes_servers = (Element) list_nodes_Edges.item(i);
				String source = getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("source").item(0));
				String dest = getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("dest").item(0));
				Integer vlan = Integer.parseInt(getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("vlan").item(0)));
				String direction = getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("direction").item(0));
				int source_port = Integer.parseInt(getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("source_port").item(0)));
				int dest_port = Integer.parseInt(getCharacterDataFromElement((Element) nodes_servers.getElementsByTagName("dest_port").item(0)));
				
				System.out.println("Adding IntraDomain Link! source: "+source+", dest: "+dest+", source_port: "+source_port+", dest_port: "+dest_port);
				
				MyEdge auxEdge = new TEDUpdaterController().new MyEdge(source, dest, vlan, source_port, dest_port);
				interDomainLinks.put(auxEdge.hashCode(), auxEdge);
				
				if (direction.equals("bidirectional"))
				{
					MyEdge reverseEdge = new TEDUpdaterController().new MyEdge(dest, source, vlan, source_port, dest_port);
					interDomainLinks.put(reverseEdge.hashCode(), reverseEdge);
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
		
		return interDomainLinks;
	}
	
	private static String getCharacterDataFromElement(Element e) 
	{
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) 
		{
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		else 
		{
			return "?";
		}
	}
	
	public class MyEdge
	{
		String source;
		String dest;
		Integer source_port;
		Integer dest_port;
		Integer vlan;
		
		MyEdge(String source, String dest)
		{
			this.source = source;
			this.dest = dest;
		}
		
		MyEdge(String source, String dest, Integer vlan, Integer source_port, Integer dest_port)
		{
			this.source = source;
			this.dest = dest;
			this.source_port = source_port;
			this.dest_port = dest_port; 
			this.vlan = vlan;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dest == null) ? 0 : dest.hashCode());
			result = prime * result
					+ ((source == null) ? 0 : source.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyEdge other = (MyEdge) obj;
			if (dest == null) {
				if (other.dest != null)
					return false;
			} else if (!dest.equals(other.dest))
				return false;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			return true;
		}		
		
	}
	
	public String getInterDomainFile() 
	{
		return interDomainFile;
	}

	public void setInterDomainFile(String interDomainFile) 
	{
		this.interDomainFile = interDomainFile;
	}

}
