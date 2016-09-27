package es.tid.topologyModuleBase.UnifyTopoModel.model;

import es.tid.tedb.*;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

//import es.tid.tedb.elements.Link;


public class TranslateModel {
	

	

	public static Port translateNode(DomainTEDB db, es.tid.tedb.elements.Node n){
		Port port = new Port();
		port.setId( ((es.tid.tedb.elements.Node) n).getNodeID() );
		return port;
	}
	
	public static Port translateNodeIp(DomainTEDB ted, Inet4Address n, Node_Info nodeInfo) {
		Port port = new Port();
		port.setId(((java.net.Inet4Address) n).getHostAddress());
		return port;
	}
	
	
	
	
	public static Node translateTopology(String domainID, DomainTEDB ted){
		  Node node = new Node();
		  node.setId(domainID);
		  
		  //Translating nodes from TEDB to Unify Model
		  PortsSchema ports = new PortsSchema();
		  List<Port> portlist = new ArrayList<Port>();
		  for(Object nodeFromTed : ted.getIntraDomainLinksvertexSet()){			  
			  if(nodeFromTed instanceof es.tid.tedb.elements.Node){
				  portlist.add(translateNode(ted, (es.tid.tedb.elements.Node)nodeFromTed));
			  } else if(nodeFromTed instanceof java.net.Inet4Address){
				  portlist.add(translateNodeIp(ted, (java.net.Inet4Address)nodeFromTed, ted.getNodeTable().get(node)));
			  }
			  
		  }
		  
		  node.setLinks(translateIntraDomainLinks(domainID, ted));
		  if (ted.getItResources()!=null){
			  SoftwareResource resources = new SoftwareResource();		  
			  resources.setCpu(ted.getItResources().getCpu());
			  resources.setMem(ted.getItResources().getMem());
			  resources.setStorage(ted.getItResources().getStorage());
			  node.setResources(resources);
			  Metadata metadata = new Metadata();
			  MetadataMetadata e= new MetadataMetadata();
			  e.setKey("unify-slor");
			  e.setValue(ted.getItResources().getControllerIT());
			  metadata.getMetadata().add(e);
			  node.metadata.add(e);
		  }
				  
		  ports.setPort(portlist);
		  node.setPorts(ports);
		  
		  return node;
	  }
	
	public static LinksSchema translateInterDomainLinks(String domainID, MultiDomainTEDB ted){
			//Translating InterDomain links from TEDB to Unify Model
			LinksSchema links = new LinksSchema();
			List<Link> linklist = new ArrayList<Link>();
			
			for(InterDomainEdge linkTed : ted.getInterDomainLinks()){
				Link link = new Link();
				if (linkTed.getSrc_router_id() instanceof java.net.Inet4Address){
					String src = ((java.net.Inet4Address) linkTed.getSrc_router_id()).getHostAddress();
					String srcDomain = ((java.net.Inet4Address) linkTed.getDomain_src_router()).getHostAddress();
					String srcUnify = "/nodes/node[id="+srcDomain+"]/ports/port[id="+src+"]";
					link.setSrc(srcUnify);		
				}else{
					System.out.println("Type of InterDomain link not implemented for UnifyModel");
				}
				
				if (linkTed.getDst_router_id() instanceof java.net.Inet4Address){
					String dst = ((java.net.Inet4Address) linkTed.getDst_router_id()).getHostAddress();
					String dstDomain = ((java.net.Inet4Address) linkTed.getDomain_dst_router()).getHostAddress();
					String dstUnify = "/nodes/node[id="+dstDomain+"]/ports/port[id="+dst+"]";
					link.setDst(dstUnify);					
				}else{
					System.out.println("Type of InterDomain link not implemented for UnifyModel");
				}
				linklist.add(link);
			}
			links.setLink(linklist);
		  
			return links;
		}
	
	public static LinksSchema translateIntraDomainLinks(String domainID, DomainTEDB ted){
		//Translating InterDomain links from TEDB to Unify Model
		LinksSchema links = new LinksSchema();
		List<Link> linklist = new ArrayList<Link>();
		
	  
		for(IntraDomainEdge linkTed : ted.getIntraDomainLinks()){
			Link link = new Link();
			link.setId(linkTed.getLinkID());
			
			if( linkTed.getSource() instanceof  java.net.Inet4Address){
				String src = "/nodes/node[id="+domainID+"]/ports/port[id="+((java.net.Inet4Address)linkTed.getSource()).getHostAddress()+"]";
				link.setSrc(src);
			//} else if( linkTed.getSource( instanceof es.tid.tedb.elements.EndPoint ){
				
			} else {
				System.out.println("Type of link not implemented for UnifyModel");
			}
			
			
			if( linkTed.getTarget() instanceof  java.net.Inet4Address){
				String dst = "/nodes/node[id="+domainID+"]/ports/port[id="+((java.net.Inet4Address)linkTed.getTarget()).getHostAddress()+"]";
				link.setDst(dst);
			//} else if( linkTed.getTarget( instanceof es.tid.tedb.elements.EndPoint ){
				
			} else {
				System.out.println("Type of link not implemented for UnifyModel");
			}
			LinkResource linkResource = new LinkResource();
			if (linkTed.getTE_info().getUndirLinkDelay() != null) linkResource.setDelay(String.valueOf(linkTed.getTE_info().getUndirLinkDelay().getDelay()));
			if (linkTed.getTE_info().getUndirAvailableBw() != null) linkResource.setBandwidth(String.valueOf(linkTed.getTE_info().getUndirAvailableBw().getAvailableBw()));
			if (linkResource != null) link.setResources(linkResource);
			linklist.add(link);
		}
		links.setLink(linklist);
	  
		return links;
	}




}
