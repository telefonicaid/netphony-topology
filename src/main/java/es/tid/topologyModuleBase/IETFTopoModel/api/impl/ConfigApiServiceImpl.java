package es.tid.topologyModuleBase.IETFTopoModel.api.impl;

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
    @Override
    public Response createNetworksNetworkNodeSupportingNodeSupportingNodeById(String networkId, String nodeId, String networkRefNodeRef, SupportingNodeSchema supportingNode, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
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
        // do some magic!
  	  System.out.println("HOLA BOLA");

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
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
        // do some magic!
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
