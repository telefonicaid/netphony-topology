package es.tid.topologyModuleBase.COPServiceTopology.server.api;

import com.sun.jersey.multipart.FormDataParam;


import java.util.List;

import es.tid.topologyModuleBase.COPServiceTopology.model.*;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.*;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public abstract class ConfigApiService {
  
      public abstract Response retrieveTopologies()
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyTopologyById(String topologyId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesEdgesById(String topologyId,String edgeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById(String topologyId,String edgeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById(String topologyId,String edgeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesSourceSourceById(String topologyId,String edgeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById(String topologyId,String edgeId,String edgeEndId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesTargetTargetById(String topologyId,String edgeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById(String topologyId,String edgeId,String edgeEndId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyNodesNodesById(String topologyId,String nodeId)
      throws NotFoundException;
  
      public abstract Response retrieveTopologiesTopologyNodesEdgeEndEdgeEndById(String topologyId,String nodeId,String edgeEndId)
      throws NotFoundException;
  
}
