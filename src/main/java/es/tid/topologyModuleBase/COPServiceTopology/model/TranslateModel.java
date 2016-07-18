package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.Node_Info;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TE_Information;
import es.tid.tedb.elements.EndPoint;
import es.tid.tedb.elements.Intf;
import es.tid.tedb.elements.Link;
import es.tid.topologyModuleBase.COPServiceTopology.model.Edge.EdgeTypeEnum;

public class TranslateModel {
    public static Node getNodeById(DomainTEDB db, String nodeId){
  	  for (Object n : db.getIntraDomainLinksvertexSet()){
  		  if(n instanceof es.tid.tedb.elements.Node){
  			  Node node= translateNode(db, (es.tid.tedb.elements.Node)n);
  			  if(node.getNodeId().equals(nodeId)){
  				  return node;
  			  }
  		  }else if(n instanceof Inet4Address){
  			  Node node= translateNodeIp(db, (Inet4Address)n, db.getNodeTable().get(n));
  			  if(node.getNodeId().equals(nodeId)){
  				  return node;
  			  }
  		  }
  	  }
  	  return null;
    }
	
	public static Node translateNode(DomainTEDB db, es.tid.tedb.elements.Node n){
		  //System.out.println("DEBUG translateNode: NodeInput: "+n);
			Node node = new Node();
		  //node.setName(n.getNodeID());
		  if(n.getAddress().size()>0){
			  node.setName(n.getAddress().get(0));
		  }else{
			  node.setName(n.getNodeID());
		  }
		  node.setDomain(n.getDomain()+"");
		  node.setNodetype(n.getLayer());
		  node.setNodeId(n.getNodeID());
		  
		  
		  List<EdgeEnd>intList = new ArrayList<EdgeEnd>();
		  for (es.tid.tedb.elements.Intf i : n.getIntfList()){
			  intList.add(translateEdgeEnd( n, i));
		  }
		  node.setEdgeEnd(intList);
		  //node.setUnderlayAbstractTopology(underlayAbstractTopology);
		  
		  return node;
	  }
	public static Node translateNodeIp(DomainTEDB ted, Inet4Address n, Node_Info nodeInfo) {
		Node node = new Node();
		System.out.println("DEBUG translateNodeIP, nodeInfo (of node "+n+"):"+nodeInfo);
		node.setName(n.getHostAddress());
		node.setNodeId(n.getHostAddress());
		if(nodeInfo==null){
			System.out.println("No node Info: DomainID:"+ted.getDomainID());
			node.setDomain(ted.getDomainID().getHostAddress());
		}else{
			node.setDomain(nodeInfo.getAs_number().getHostAddress());
		}
		node.setEdgeEnd(new ArrayList<EdgeEnd>());
		return node;
	}
	  
	public static EdgeEnd translateEdgeEnd(es.tid.tedb.elements.Node n, es.tid.tedb.elements.Intf i){
		  EdgeEnd edgeEnd = new EdgeEnd();
		  edgeEnd.setEdgeEndId(i.getName());
		  edgeEnd.setName(i.getName());
		  
		  //edgeEnd.setPeerNodeId(i.getAddress().get(0)); //correct map?
		  //edgeEnd.setSwitchingCap(SwitchingCapEnum.lsc);
		  
		  return edgeEnd;
	  }
	  
	public static EdgeEnd translateEdgeEnd(DomainTEDB db, es.tid.tedb.elements.EndPoint e){
		  EdgeEnd edgeEnd = new EdgeEnd();
		  edgeEnd.setEdgeEndId(e.getNode()+"-"+e.getIntf());
		  edgeEnd.setName(e.getNode()+"-"+e.getIntf());
		  edgeEnd.setPeerNodeId(e.getNode()); //correct map?
		  //edgeEnd.setSwitchingCap(SwitchingCapEnum.lsc);
		  return edgeEnd;
	  }
	  
	  
	
	  
	public static Bitmap translateBitmap(TE_Information te_Information){
		  Bitmap bitmap = new Bitmap();
		  
		  return bitmap;
	  }
	public static Edge translateEdge(DomainTEDB db,IntraDomainEdge e){
		//if(e.getTE_info()==null){
			return translateEthEdge(db, e);
		//}else{
		//	return translateDwdmEdge(db, e);
		//}
	}
	
	public static Edge translateEdge(MultiDomainTEDB db,InterDomainEdge e){
		//if(e.getTE_info()==null){
			return translateEthEdge(db, e);
		//}else{
		//	return translateDwdmEdge(db, e);
		//}
	}
	
	public static DwdmEdge translateDwdmEdge(DomainTEDB db, IntraDomainEdge e){
		  DwdmEdge dwdmEdge = new DwdmEdge();
		  dwdmEdge.setName(e.getLinkID());
		  dwdmEdge.setEdgeId(e.getLinkID());
		  dwdmEdge.setEdgeType(EdgeTypeEnum.dwdm_edge);
		  dwdmEdge.setMetric(e.getTemetric()+"");
		  if(e.getBw()!=null){
			  dwdmEdge.setMaxResvBw(e.getBw().getMaxBandwidth()+"");
			  dwdmEdge.setUnreservBw(e.getBw().getUnreservedBw()+"");
		  }
		  Object src = e.getSrc_Numif_id();
		  if( src instanceof es.tid.tedb.elements.EndPoint ){
			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.EndPoint) src).getNode());
			  dwdmEdge.setSource(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) src).getIntf()) ){
					  dwdmEdge.setLocalIfid(end);
				  }
			  }
			  
		  }
		  Object dst = e.getDst_Numif_id();
		  if( dst instanceof es.tid.tedb.elements.EndPoint ){
			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.EndPoint) dst).getNode());
			  dwdmEdge.setTarget(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) dst).getIntf()) ){
					  dwdmEdge.setRemoteIfid(end);
				  }
			  }
		  }	
		  //Write special DWDM fields
		  if(e.getTE_info().getAvailableLabels()!=null && e.getTE_info().getAvailableLabels().getLabelSet()!=null){
			  byte[] bytesBitMap = ((BitmapLabelSet)e.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap();
			  List<Integer> lBits = new ArrayList<Integer>();
			  for(byte b : bytesBitMap){
				  for(int i=0;i<8;i++){
					  if(lBits.size()<=((BitmapLabelSet)e.getTE_info().getAvailableLabels().getLabelSet()).getNumLabels())
						  lBits.add(b|(1<<i));
				  }
			  }
			  Bitmap bitmap = new Bitmap();
			  bitmap.setArrayBits(lBits);
			  bitmap.setNumChannels(lBits.size());
			  dwdmEdge.setBitmap(bitmap);
			 
			  //TODO codify dwdmEdge.setChannels
			//dwdmEdge.setChannels(translateDwdmChannel(e.getTE_info()));
		  }
		  
		 
		  
		  return dwdmEdge;
	  }
	public static Edge translateEthEdge(DomainTEDB db,IntraDomainEdge e){
		  //System.out.println("DEBUG translateEdge: edgeInput= source (class "+e.getSource().getClass()+")="+e.getSource());//+" | getSrc_Numif_id (class "+e.getSrc_Numif_id().getClass()+")="+e.getSrc_Numif_id());
		  Edge edge = new Edge();
		  edge.setName(e.getLinkID());
		  edge.setEdgeId(e.getLinkID());
		  edge.setEdgeType(EdgeTypeEnum.eth_edge);
		  
		  edge.setMetric(e.getTemetric()+"");
		  if(e.getBw()!=null){
			  edge.setMaxResvBw(e.getBw().getMaxBandwidth()+"");
			  edge.setUnreservBw(e.getBw().getUnreservedBw()+"");
		  }
		  Object src = e.getSrc_Numif_id();
		  if( e.getSource() instanceof  java.net.Inet4Address){
			  Node node = TranslateModel.getNodeById( db, ((java.net.Inet4Address)e.getSource()).getHostAddress());
			  edge.setSource(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(e.getSrc_if_id())){
					  edge.setLocalIfid(end);
				  }
			  }
		  }else if( src instanceof es.tid.tedb.elements.EndPoint ){
			 
			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.Node)e.getSource()).getNodeID());
			  edge.setSource(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) src).getIntf()) ){
					  edge.setLocalIfid(end);
				  }
			  }
			  
		  }
		  
		  Object dst = e.getDst_Numif_id();
		  if( e.getTarget() instanceof  java.net.Inet4Address){
			  Node node = TranslateModel.getNodeById( db, ((java.net.Inet4Address)e.getTarget()).getHostAddress());
			  edge.setTarget(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(e.getDst_if_id())){
					  edge.setRemoteIfid(end);
				  }
			  }
		  }else if( dst instanceof es.tid.tedb.elements.EndPoint ){
			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.EndPoint) dst).getNode());
			  edge.setTarget(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) dst).getIntf()) ){
					  edge.setRemoteIfid(end);
				  }
			  }
		  }	  
		  return edge;
	  }
	
	public static Edge translateEthEdge(MultiDomainTEDB db,InterDomainEdge e){
		  //System.out.println("DEBUG translateEdge: edgeInput= source (class "+e.getSource().getClass()+")="+e.getSource());//+" | getSrc_Numif_id (class "+e.getSrc_Numif_id().getClass()+")="+e.getSrc_Numif_id());
		  Edge edge = new Edge();
		  edge.setName(e.domain_src_router.toString()+":"+e.domain_dst_router.toString());
		  edge.setEdgeId("0");
		  edge.setEdgeType(EdgeTypeEnum.eth_edge);
		  if (e.getTE_info()!=null) {
			  if (e.getTE_info().getDefaultTEMetric()!=null) {
				  edge.setMetric(e.getTE_info().getDefaultTEMetric().toString());
			  } 
			  if (e.getTE_info().getMaximumBandwidth()!=null) {
				  edge.setMaxResvBw(e.getTE_info().getMaximumBandwidth().toString());
			  } 
			  if (e.getTE_info().getUnreservedBandwidth()!=null) {
				  edge.setMaxResvBw(e.getTE_info().getUnreservedBandwidth().toString());
			  } 
			  
			 
		  }
		  
//		  edge.s
		  Node src_node = new Node();
		  if (e.getDomain_src_router() instanceof Inet4Address) {
			  src_node.setDomain(((Inet4Address)(e.getDomain_src_router())).getHostName());
		  } else {
			  src_node.setDomain(e.getDomain_src_router().toString());

		  }
		  if (e.getSrc_router_id() instanceof Inet4Address) {
			  src_node.setNodeId(((Inet4Address)(e.getSrc_router_id())).getHostName());
		  }else {
			  src_node.setNodeId(e.getSrc_router_id().toString());
		  }
		 
		  edge.setSource(src_node);
		  Node dst_node = new Node();
		  dst_node.setDomain(e.getDomain_dst_router().toString());
		  dst_node.setNodeId(e.getDst_router_id().toString());
		  edge.setTarget(dst_node);
		  
		  
//		  node.setDomain(de)
//
//		  Object src = e.getSrc_Numif_id();
//		  
//		  if( e.getSource() instanceof  java.net.Inet4Address){
//			  Node node = TranslateModel.getNodeById( db, ((java.net.Inet4Address)e.getSource()).getHostAddress());
//			  edge.setSource(node);
//			  for(EdgeEnd end : node.getEdgeEnd()){
//				  if(end.getName().equals(e.getSrc_if_id())){
//					  edge.setLocalIfid(end);
//				  }
//			  }
//		  }else if( src instanceof es.tid.tedb.elements.EndPoint ){
//			 
//			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.Node)e.getSource()).getNodeID());
//			  edge.setSource(node);
//			  for(EdgeEnd end : node.getEdgeEnd()){
//				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) src).getIntf()) ){
//					  edge.setLocalIfid(end);
//				  }
//			  }
//			  
//		  }
//		  
//		  Object dst = e.getDst_Numif_id();
//		  if( e.getTarget() instanceof  java.net.Inet4Address){
//			  Node node = TranslateModel.getNodeById( db, ((java.net.Inet4Address)e.getTarget()).getHostAddress());
//			  edge.setTarget(node);
//			  for(EdgeEnd end : node.getEdgeEnd()){
//				  if(end.getName().equals(e.getDst_if_id())){
//					  edge.setRemoteIfid(end);
//				  }
//			  }
//		  }else if( dst instanceof es.tid.tedb.elements.EndPoint ){
//			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.EndPoint) dst).getNode());
//			  edge.setTarget(node);
//			  for(EdgeEnd end : node.getEdgeEnd()){
//				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) dst).getIntf()) ){
//					  edge.setRemoteIfid(end);
//				  }
//			  }
//		  }	  
		  return edge;
	  }
	  /*private Edge translateEdge(InterDomainEdge e){
		  Edge edge = new Edge();
		  edge.setName(e.getDomain_src_router()+"-"+e.getDomain_dst_router());
		  edge.setEdgeId(e.hashCode()+"");
		  if(e.getType().equals("")){
			  edge.setEdgeType(EdgeTypeEnum.dwdm_edge);
		  }else if(e.getType().equals("")){
			  edge.setEdgeType(EdgeTypeEnum.eth_edge);
		  }
		  edge.setMetric(e.get+"");
		  edge.setMaxResvBw(e.getBw().getMaxBandwidth()+"");
		  edge.setUnreservBw(e.getBw().getUnreservedBw()+"");
		  edge.setSource( translateNode(e.getLocal_Node_Info()) );
		  edge.setTarget( translateNode(e.getRemote_Node_Info()) );
		  //edge.setLocalIfid( translateEdgeEnd(e.getSrc_if_id())) ); 
		  //edge.setRemoteIfid( translateEdgeEnd(e.getDst_if_id()) );
		  
		  return edge;
	  }*/
	  
	  
	 

	public static DwdmChannel translateDwdmChannel(TE_Information te_Information){
		  DwdmChannel dwdmChannel = new DwdmChannel();
		  
		  return dwdmChannel;
	  }
	  
	
	  
	public static Topology translateTopology(String topId, DomainTEDB ted){
		//System.out.println("DEBUG translateTopology: TEDinput: "+ted.printTopology());
		  Topology topology = new Topology();
		  /*if(ted==null){
			  topology.setTopologyId("topology null Exception");
			  return topology;
		  }
		  if(ted.getDomainID()==null){
			  topology.setTopologyId("getDomainID null Exception");
			  return topology;
		  }*/
		  topology.setTopologyId(topId);
		  
		  List<Edge> edges = new ArrayList<Edge>();
		  for(IntraDomainEdge link : ted.getIntraDomainLinks()){
			  edges.add(translateEdge(ted, link));
		  }
		  topology.setEdges(edges);
		  
		  List<Node> nodes = new ArrayList<Node>();
		  for(Object node : ted.getIntraDomainLinksvertexSet()){
			 // System.out.println("DEBUG nodeInTopology, (class "+node.getClass()+"):" +node );
			  if(node instanceof es.tid.tedb.elements.Node){
				  nodes.add(translateNode(ted, (es.tid.tedb.elements.Node)node));
			  }
			  else if(node instanceof java.net.Inet4Address){
				  nodes.add(translateNodeIp(ted, (java.net.Inet4Address)node, ted.getNodeTable().get(node)));
			  }
		  }
		  topology.setNodes(nodes);
		  
		  //topology.setUnderlayTopology(); //TODO
		  
		  return topology;
	  }
	
	public static Topology translateTopology(String topId, MultiDomainTEDB ted){
		//System.out.println("DEBUG translateTopology: TEDinput: "+ted.printTopology());
		  Topology topology = new Topology();
		  /*if(ted==null){
			  topology.setTopologyId("topology null Exception");
			  return topology;
		  }
		  if(ted.getDomainID()==null){
			  topology.setTopologyId("getDomainID null Exception");
			  return topology;
		  }*/
		  topology.setTopologyId(topId);
		  
		  List<Edge> edges = new ArrayList<Edge>();
		  for(InterDomainEdge link : ted.getInterDomainLinks()){
			  edges.add(translateEdge(ted, link));
		  }
		  topology.setEdges(edges);
		  
//		  List<Node> nodes = new ArrayList<Node>();
//		  for(Object node : ted.getIntraDomainLinksvertexSet()){
//			 // System.out.println("DEBUG nodeInTopology, (class "+node.getClass()+"):" +node );
//			  if(node instanceof es.tid.tedb.elements.Node){
//				  nodes.add(translateNode(ted, (es.tid.tedb.elements.Node)node));
//			  }
//			  else if(node instanceof java.net.Inet4Address){
//				  nodes.add(translateNodeIp(ted, (java.net.Inet4Address)node, ted.getNodeTable().get(node)));
//			  }
//		  }
//		  topology.setNodes(nodes);
		  
		  //topology.setUnderlayTopology(); //TODO
		  
		  return topology;
	  }


	

	public static es.tid.tedb.elements.Node translate2Node(Node node) {
		es.tid.tedb.elements.Node n = new es.tid.tedb.elements.Node();
		n.setNodeID(node.getName());
		n.setDomain(Integer.parseInt(node.getDomain()));
		n.setLayer(node.getNodetype());
		n.setNodeID(node.getNodeId());
		try{
			Inet4Address addr = (Inet4Address)Inet4Address.getByName(node.getName());
			ArrayList<String> l_addr= new ArrayList<String>();
			l_addr.add(addr.getHostAddress());
			n.setAddress(l_addr);
		}catch(UnknownHostException e){
			//TODO
		}
		ArrayList<es.tid.tedb.elements.Intf>intList = new ArrayList<es.tid.tedb.elements.Intf>();
		  for (EdgeEnd end : node.getEdgeEnd()){
			  intList.add(translate2EdgeEnd(node, end));
		  }
		n.setIntfList(intList);
		
		return n;
	}

	private static Intf translate2EdgeEnd(Node node, EdgeEnd edgeEnd) {
		Intf intf = new Intf();
		intf.setName(edgeEnd.getName());
		ArrayList<String> adds = new ArrayList<String>(1);
		adds.add(edgeEnd.getPeerNodeId());
		intf.setAddress(adds);
		//edgeEnd.setEdgeEndId(e.getNode()+"-"+e.getIntf());
		//edgeEnd.setName(e.getNode()+"-"+e.getIntf());
		//edgeEnd.setPeerNodeId(e.getNode()); //correct map?
		  //edgeEnd.setSwitchingCap(SwitchingCapEnum.lsc);
		return intf;
	}

	public static Link translate2Link(Edge e) {
		System.out.println("translate2Link, Edge: "+e);
		Link link= new Link();
		link.setLinkID(e.getEdgeId());
		link.setSource(translate2EndPoint(e.getSource(),e.getLocalIfid()));
		link.setDest(translate2EndPoint(e.getTarget(), e.getRemoteIfid()));	
		link.setDirectional(false);
		if(e.getEdgeType() != null){
			link.setType(e.getEdgeType().toString());
		}
		return link;
	}

	private static EndPoint translate2EndPoint(Node source, EdgeEnd edgeEnd) {
		System.out.println("translate2EndPoint, node: "+source+"\nEdgeEnd: "+edgeEnd);
		return (new EndPoint(source.getNodeId(),edgeEnd.getName()));
	}
	  

}
