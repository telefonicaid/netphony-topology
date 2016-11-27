package es.tid.topologyModuleBase.COPServiceTopology.server.api.impl;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.Node_Info;
import es.tid.tedb.TEDB;

import com.sun.jersey.multipart.FormDataParam;

import es.tid.topologyModuleBase.COPServiceTopology.model.*;
import es.tid.topologyModuleBase.COPServiceTopology.model.Edge.EdgeTypeEnum;
import es.tid.topologyModuleBase.COPServiceTopology.model.EdgeEnd.SwitchingCapEnum;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.*;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.writer.TopologyServerCOP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class ConfigApiServiceImpl extends ConfigApiService {
  
      @Override
      public Response retrieveTopologies()
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TopologiesSchema tSchema = new TopologiesSchema();
    	  List<Topology> tops = new ArrayList<Topology>();
    	  
    	  for(Map.Entry<String, TEDB>entry : ted.getTeds().entrySet() ){
     		 System.out.println("Topologia servida con id: "+entry.getKey());
     		  if (entry.getValue() instanceof DomainTEDB) {
        		  tops.add( TranslateModel.translateTopology(entry.getKey(),(DomainTEDB)entry.getValue()));
     		  }else {
        		  tops.add( TranslateModel.translateTopology(entry.getKey(),(MultiDomainTEDB)entry.getValue()));

     		  }
     	  }
    	  tSchema.setTopology(tops);
	      return Response.ok().entity(tSchema).build();
	  }
  
      @Override
      public Response retrieveTopologiesTopologyTopologyById(String topologyId)
      throws NotFoundException {
      
    	  TEDB db = TopologyServerCOP.getActualTed().getDB(topologyId);
    	  if(db == null)
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  else
    		  return Response.ok().entity(TranslateModel.translateTopology(topologyId, (DomainTEDB) db)).build();
      }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesEdgesById(String topologyId,String edgeId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
    	  for( ; it.hasNext() ; ){
    		   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
    		   if( edge.getEdgeId().equals(edgeId)){
    			   return Response.ok().entity(edge).build();
    		   }
    		  
    	  }
    	  return Response.noContent().build();
      }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById(String topologyId,String edgeId)
	      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
    	  for( ; it.hasNext() ; ){
    		   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
    		   if( edge.getEdgeId().equals(edgeId)){
    			   return Response.ok().entity(edge.getLocalIfid()).build();
    		   }
    		  
    	  }
    	  throw new NotFoundException(0, "No found Edge with id:"+edgeId);
	  }
	  
      @Override
      public Response retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById(String topologyId,String edgeId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
    	  for( ; it.hasNext() ; ){
    		   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
    		   if( edge.getEdgeId().equals(edgeId)){
    			   return Response.ok().entity(edge.getRemoteIfid()).build();
    		   }
    		  
    	  }
    	  throw new NotFoundException(0, "No found Edge with id:"+edgeId);
	  }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesSourceSourceById(String topologyId,String edgeId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
    	  for( ; it.hasNext() ; ){
    		   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
    		   if( edge.getEdgeId().equals(edgeId)){
    			   return Response.ok().entity(edge.getSource()).build();
    		   }
    	  }
	      throw new NotFoundException(0, "No found Edge with id:"+edgeId);
	  }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById(String topologyId,String edgeId,String edgeEndId)
      throws NotFoundException {
      	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
		  TEDB db = ted.getDB(topologyId);
		  if(db==null){
			  throw new NotFoundException(0, "No found topology with id:"+topologyId);
		  }
		  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
		  for( ; it.hasNext() ; ){
			   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
			   if( edge.getEdgeId().equals(edgeId)){
				   Node n = edge.getSource();
				   for(EdgeEnd eEnd : n.getEdgeEnd()){
					   if(eEnd.getEdgeEndId().equals(edgeEndId)){
						   return Response.ok().entity(eEnd).build();
					   }
				   }
				   throw new NotFoundException(0, "No found EdgeEnd with id:"+edgeEndId);
				   
			   }
			  
		  }
		  throw new NotFoundException(0, "No found Edge with id:"+edgeId);
	  }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesTargetTargetById(String topologyId,String edgeId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
    	  for( ; it.hasNext() ; ){
    		   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
    		   if( edge.getEdgeId().equals(edgeId)){
    			   
    			   return Response.ok().entity(edge.getTarget()).build();
    		   }
    		  
    	  }
	      return Response.noContent().build();
  }
  
      @Override
      public Response retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById(String topologyId,String edgeId,String edgeEndId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
		  TEDB db = ted.getDB(topologyId);
		  if(db==null){
			  throw new NotFoundException(0, "No found topology with id:"+topologyId);
		  }
		  Iterator<IntraDomainEdge> it = ((DomainTEDB)db).getIntraDomainLinks().iterator();
		  for( ; it.hasNext() ; ){
			   Edge edge = TranslateModel.translateEdge((DomainTEDB)db, it.next());
			   if( edge.getEdgeId().equals(edgeId)){
				   Node n = edge.getTarget();
				   for(EdgeEnd eEnd : n.getEdgeEnd()){
					   if(eEnd.getEdgeEndId().equals(edgeEndId)){
						   return Response.ok().entity(eEnd).build();
					   }
				   }
				   
			   }
			  
		  }
	      return Response.noContent().build();
	  }
      

  
      @Override
      public Response retrieveTopologiesTopologyNodesNodesById(String topologyId,String nodeId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Node node = TranslateModel.getNodeById((DomainTEDB) db, nodeId);
    	  if(node == null){
    		  return Response.noContent().build();
    	  }else{
    		  return Response.ok().entity(node).build();
    	  }
	  }
  
      @Override
      public Response retrieveTopologiesTopologyNodesEdgeEndEdgeEndById(String topologyId,String nodeId,String edgeEndId)
      throws NotFoundException {
    	  TopologiesDataBase ted = TopologyServerCOP.getActualTed();
    	  TEDB db = ted.getDB(topologyId);
    	  if(db==null){
    		  throw new NotFoundException(0, "No found topology with id:"+topologyId);
    	  }
    	  Node node = TranslateModel.getNodeById((DomainTEDB) db, nodeId);
    	  if(node == null){
    		  return Response.noContent().build();
    	  }else{
    		  for(EdgeEnd edgeEnd : node.getEdgeEnd()){
    			  if(edgeEnd.getEdgeEndId().equals(edgeEndId)){
    				  return Response.ok().entity(edgeEnd).build();
    			  }
    		  }
    	  }
    	  return Response.noContent().build();
	  }
      
  
 
  
  
  
  
  
  
}
