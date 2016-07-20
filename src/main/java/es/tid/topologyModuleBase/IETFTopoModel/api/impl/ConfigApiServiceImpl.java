package es.tid.topologyModuleBase.IETFTopoModel.api.impl;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.TEDB;
import es.tid.topologyModuleBase.IETFTopoModel.api.*;
import es.tid.topologyModuleBase.IETFTopoModel.model.*;

import com.sun.jersey.multipart.FormDataParam;

import es.tid.topologyModuleBase.IETFTopoModel.model.NetworksSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworkSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.NodeSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.SupportingNodeSchema;
import es.tid.topologyModuleBase.IETFTopoModel.model.SupportingNetworkSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.tid.topologyModuleBase.IETFTopoModel.api.NotFoundException;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.writer.TopologyServerIETF;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T19:03:40.260+02:00")
public class ConfigApiServiceImpl extends ConfigApiService {
    @Override
    public Response createNetworksById(NetworksSchema networks, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createNetworksNetworkNetworkById(String networkId, NetworkSchema network, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createNetworksNetworkNodeNodeById(String networkId, String nodeId, NodeSchema node, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
//    @Override
//    public Response createNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId, String nodeId, String networkRefNodeRef, SupportingNodeSchema supportingNode, SecurityContext securityContext)
//    throws NotFoundException {
//        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
//    }
    @Override
    public Response createNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId, String networkRef, SupportingNetworkSchema supportingNetwork, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteNetworksById(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteNetworksNetworkNetworkById(String networkId, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteNetworksNetworkNodeNodeById(String networkId, String nodeId, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId, String nodeId, String networkRefNodeRef, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId, String networkRef, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveNetworks(SecurityContext securityContext)
    throws NotFoundException {
  	  System.out.println("HOLA BOLA");
  	  	NetworksSchema ns = new NetworksSchema();
  	  	NetworksSchemaNetwork network = new NetworksSchemaNetwork();
  	  	List<NetworksSchemaNetwork> nsList=new ArrayList<NetworksSchemaNetwork>();
  	  	ns.setNetwork(nsList);
  	    TopologiesDataBase ted = TopologyServerIETF.getActualTed();

  	    for(Map.Entry<String, TEDB>entry : ted.getTeds().entrySet() ){
  		 System.out.println("Topologia servida con id: "+entry.getKey());
  		  if (entry.getValue() instanceof DomainTEDB) {
  			nsList.add( TranslateModel.translateTopology(entry.getKey(),(DomainTEDB)entry.getValue()));
  		  }else if (entry.getValue() instanceof MultiDomainTEDB){
  			nsList.add( TranslateModel.translateTopology(entry.getKey(),(MultiDomainTEDB)entry.getValue()));

  		  }
  	  }
        return Response.ok().entity(ns).build();
    }
    @Override
    public Response retrieveNetworksNetworkNetworkById(String networkId, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveNetworksNetworkNodeNodeById(String networkId, String nodeId, SecurityContext securityContext)
    throws NotFoundException {
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId, String nodeId, String networkRefNodeRef, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId, String networkRef, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateNetworksById(NetworksSchema networks, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateNetworksNetworkNetworkById(String networkId, NetworkSchema network, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateNetworksNetworkNodeNodeById(String networkId, String nodeId, NodeSchema node, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId, String nodeId, String networkRefNodeRef, SupportingNodeSchema supportingNode, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateNetworksNetworkSupportingNetworkSupportingNetworkById(String networkId, String networkRef, SupportingNetworkSchema supportingNetwork, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
