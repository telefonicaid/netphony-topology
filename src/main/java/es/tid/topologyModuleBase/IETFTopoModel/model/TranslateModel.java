package es.tid.topologyModuleBase.IETFTopoModel.model;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.Node_Info;
import es.tid.tedb.TEDB;
import es.tid.tedb.TE_Information;
import es.tid.tedb.elements.EndPoint;
import es.tid.tedb.elements.Intf;
import es.tid.tedb.elements.Link;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to translate TEDB model to a topology container following 
 * IETEF model.
 */
public class TranslateModel {
    public static NetworksSchemaNode getNodeById(DomainTEDB db, String nodeId){
  	  for (Object n : db.getIntraDomainLinksvertexSet()){
  		  if(n instanceof es.tid.tedb.elements.Node){
  			NetworksSchemaNode node= translateNode(db, (es.tid.tedb.elements.Node)n);
  			  if(node.getNodeId().equals(nodeId)){
  				  return node;
  			  }
  		  }else if(n instanceof Inet4Address){
  			NetworksSchemaNode node= translateNodeIp(db, (Inet4Address)n, db.getNodeTable().get(n));
  			  if(node.getNodeId().equals(nodeId)){
  				  return node;
  			  }
  		  }
  	  }
  	  return null;
    }
    
        
    /**
     * This method translate a MultiDomainTEDB object to a NetworksSchemaNetwork
     * @param topId String with the identification for the current multi domain
     * model.
     * @param ted MultiDomainTEDB object.
     * @return Network topology container object.
     */
    public static NetworksSchemaNetwork translateTopology(String topId, MultiDomainTEDB ted){
        // TODO: Need to be developed.
        NetworksSchemaNetwork topology = common(topId, ted);
        // LinkedList<InterDomainEdge> ted.getInterDomainLinks();
        /*List<InterDomainEdge> node = new ArrayList<InterDomainEdge>();
        for(InterDomainEdge link : ted.getInterDomainLinks()){
			  node.add(translateEdge(ted, link));
		  }
        topology.setNode(node);
		  topology.setNode(node);.setEdges(node);
        */
        return topology;

    }
    
    /**
     * This method translate a DomainTEDB object to a NetworksSchemaNetwork
     * @param topId String with the identification for the current domain model.
     * @param ted DomainTEDB object.
     * @return Network topology container object.
     */
    public static NetworksSchemaNetwork translateTopology(String topId, DomainTEDB ted) {
        NetworksSchemaNetwork topology = common(topId, ted);
		  
        List<NetworksSchemaNode> nodes = new ArrayList<NetworksSchemaNode>();
        for(Object node : ted.getIntraDomainLinksvertexSet()){
             if(node instanceof es.tid.tedb.elements.Node){
                     nodes.add(translateNode(ted, (es.tid.tedb.elements.Node)node));
             }
             else if(node instanceof java.net.Inet4Address){
                     nodes.add(translateNodeIp(ted, (java.net.Inet4Address)node, ted.getNodeTable().get(node)));
             }
        }
        topology.setNode(nodes);
        return topology;
    }
    
    public static NetworksSchemaNode translateNode(DomainTEDB db, es.tid.tedb.elements.Node n){
		  //System.out.println("DEBUG translateNode: NodeInput: "+n);
    	NetworksSchemaNode node = new NetworksSchemaNode();
		  //node.setName(n.getNodeID());
		  if(n.getAddress().size()>0){
			  node.setNodeId(n.getAddress().get(0));
		  }else{
			  node.setNodeId(n.getNodeID());
		  }
		  //node.s.setDomain(n.getDomain()+"");
		  //node.setNodetype(n.getLayer());
		  //node.setNodeId(n.getNodeID());
		  
		  
		  //List<EdgeEnd>intList = new ArrayList<EdgeEnd>();
		  //for (es.tid.tedb.elements.Intf i : n.getIntfList()){
			  //intList.add(translateEdgeEnd( n, i));
		  //}
		  //node.setEdgeEnd(intList);
		  ////node.setUnderlayAbstractTopology(underlayAbstractTopology);
		  
		  return node;
	  }
    
   
    
	public static NetworksSchemaNode translateNodeIp(DomainTEDB ted, Inet4Address n, Node_Info nodeInfo) {
		NetworksSchemaNode node = new NetworksSchemaNode();
		System.out.println("DEBUG translateNodeIP, nodeInfo (of node "+n+"):"+nodeInfo);
		node.setNodeId(n.getHostAddress());
		//node.setNodeId(n.getHostAddress());
		if(nodeInfo==null){
			System.out.println("No node Info: DomainID:"+ted.getDomainID());
			//node.setDomain(ted.getDomainID().getHostAddress());
		}else{
			//node.setDomain(nodeInfo.getAs_number().getHostAddress());
		}
		//node.setEdgeEnd(new ArrayList<EdgeEnd>());
		return node;
	}
    
        public static es.tid.tedb.elements.Node translate2Node(NodeSchema node) {
		es.tid.tedb.elements.Node n = new es.tid.tedb.elements.Node();
		//n.setNodeID(node.getName());
                n.setNodeID(node.getNodeId());
		//n.setDomain(Integer.parseInt(node.getDomain()));
		//n.setLayer(node.getNodetype());
		n.setNodeID(node.getNodeId());
		try{
			//Inet4Address addr = (Inet4Address)Inet4Address.getByName(node.getName());
                        Inet4Address addr = (Inet4Address)Inet4Address.getByName(node.getNodeId());
			ArrayList<String> l_addr= new ArrayList<String>();
			l_addr.add(addr.getHostAddress());
			n.setAddress(l_addr);
		}catch(UnknownHostException e){
			//TODO
		}
//		ArrayList<es.tid.tedb.elements.Intf>intList = new ArrayList<es.tid.tedb.elements.Intf>();
//		  //for (EdgeEnd end : node.getEdgeEnd()){
//                  for (EdgeEnd end : node.getEdgeEnd()){
//			  intList.add(translate2EdgeEnd(node, end));
//		  }
		//n.setIntfList(intList);
		
		return n;
	}
        
//        private static Intf translate2EdgeEnd(NodeSchema node, EdgeEnd edgeEnd) {
//		Intf intf = new Intf();
//		intf.setName(edgeEnd.getName());
//		ArrayList<String> adds = new ArrayList<String>(1);
//		adds.add(edgeEnd.getPeerNodeId());
//		intf.setAddress(adds);
//		//edgeEnd.setEdgeEndId(e.getNode()+"-"+e.getIntf());
//		//edgeEnd.setName(e.getNode()+"-"+e.getIntf());
//		//edgeEnd.setPeerNodeId(e.getNode()); //correct map?
//		  //edgeEnd.setSwitchingCap(SwitchingCapEnum.lsc);
//		return intf;
//	}
        
        
        
    /**
     * Common code for the previous methods.
     * @param topId String with the identification for the current domain model.
     * @param ted TEDB object.
     * @return Initialized NetworksSchemaNetwork object.
     */
    private static NetworksSchemaNetwork common(String topId, TEDB ted){
        NetworksSchemaNetwork topology = new NetworksSchemaNetwork();
        topology.setNetworkId(topId);
        return topology;
    }
}
