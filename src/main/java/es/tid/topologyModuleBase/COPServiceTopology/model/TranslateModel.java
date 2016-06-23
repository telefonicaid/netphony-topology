package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.IntraDomainEdge;
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
  		  }
  	  }
  	  return null;
    }
	
	public static Node translateNode(DomainTEDB db, es.tid.tedb.elements.Node n){
		  Node node = new Node();
		  node.setName(n.getNodeID());
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
		  if( src instanceof es.tid.tedb.elements.EndPoint ){
			  Node node = TranslateModel.getNodeById( db, ((es.tid.tedb.elements.EndPoint) src).getNode());
			  edge.setSource(node);
			  for(EdgeEnd end : node.getEdgeEnd()){
				  if(end.getName().equals(((es.tid.tedb.elements.EndPoint) src).getIntf()) ){
					  edge.setLocalIfid(end);
				  }
			  }
			  
		  }
		  
		  Object dst = e.getDst_Numif_id();
		  if( dst instanceof es.tid.tedb.elements.EndPoint ){
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
	  
	
	  
	public static Topology translateTopology(DomainTEDB ted){
		  Topology topology = new Topology();
		  /*if(ted==null){
			  topology.setTopologyId("topology null Exception");
			  return topology;
		  }
		  if(ted.getDomainID()==null){
			  topology.setTopologyId("getDomainID null Exception");
			  return topology;
		  }*/
		  //topology.setTopologyId(ted.getDomainID().toString());
		  
		  List<Edge> edges = new ArrayList<Edge>();
		  for(IntraDomainEdge link : ted.getIntraDomainLinks()){
			  edges.add(translateEdge(ted, link));
		  }
		  topology.setEdges(edges);
		  
		  List<Node> nodes = new ArrayList<Node>();
		  for(Object node : ted.getIntraDomainLinksvertexSet()){
			  if(node instanceof es.tid.tedb.elements.Node){
				  nodes.add(translateNode(ted, (es.tid.tedb.elements.Node)node));
			  }
		  }
		  topology.setNodes(nodes);
		  
		  //topology.setUnderlayTopology(); //TODO
		  
		  return topology;
	  }

	public static es.tid.tedb.elements.Node translate2Node(Node node) {
		es.tid.tedb.elements.Node n = new es.tid.tedb.elements.Node();
		n.setNodeID(node.getName());
		n.setDomain(Integer.parseInt(node.getDomain()));
		n.setLayer(node.getNodetype());
		n.setNodeID(node.getNodeId());
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
		return (new EndPoint(source.getName(),edgeEnd.getName()));
	}
	  

}
