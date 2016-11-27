package es.tid.topologyModuleBase.IETFTopoModel.api;

import es.tid.topologyModuleBase.IETFTopoModel.api.*;
import es.tid.topologyModuleBase.IETFTopoModel.model.*;

import com.sun.jersey.multipart.FormDataParam;

import es.tid.topologyModuleBase.IETFTopoModel.model.NetworksSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworkSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.NodeSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.SupportingNodeSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.SupportingNetworkSchema;

import java.util.List;
import es.tid.topologyModuleBase.IETFTopoModel.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public abstract class ConfigApiService {
      public abstract Response createNetworksById(NetworksSchema networks,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response createNetworksNetworkNetworkById(String networkId,NetworkSchema network,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response createNetworksNetworkNodeNodeById(String networkId,String nodeId,NodeSchema node,SecurityContext securityContext)
      throws NotFoundException;
     // public abstract Response createNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId,String nodeId,String networkRefNodeRef,SupportingNodeSchema supportingNode,SecurityContext securityContext)
     // throws NotFoundException;
      public abstract Response createNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId,String networkRef,SupportingNetworkSchema supportingNetwork,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response deleteNetworksById(SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response deleteNetworksNetworkNetworkById(String networkId,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response deleteNetworksNetworkNodeNodeById(String networkId,String nodeId,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response deleteNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId,String nodeId,String networkRefNodeRef,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response deleteNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId,String networkRef,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response retrieveNetworks(SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response retrieveNetworksNetworkNetworkById(String networkId,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response retrieveNetworksNetworkNodeNodeById(String networkId,String nodeId,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response retrieveNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId,String nodeId,String networkRefNodeRef,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response retrieveNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId,String networkRef,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateNetworksById(NetworksSchema networks,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateNetworksNetworkNetworkById(String networkId,NetworkSchema network,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateNetworksNetworkNodeNodeById(String networkId,String nodeId,NodeSchema node,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId,String nodeId,String networkRefNodeRef,SupportingNodeSchema supportingNode,SecurityContext securityContext)
      throws NotFoundException;
      public abstract Response updateNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId,String networkRef,SupportingNetworkSchema supportingNetwork,SecurityContext securityContext)
      throws NotFoundException;
}
