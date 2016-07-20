package es.tid.topologyModuleBase.IETFTopoModel.api;

import es.tid.topologyModuleBase.IETFTopoModel.model.*;
import es.tid.topologyModuleBase.IETFTopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.IETFTopoModel.api.factories.ConfigApiServiceFactory;

import io.swagger.annotations.ApiParam;

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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/restconf/data")


@io.swagger.annotations.Api(description = "the config API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class ConfigApi  {
   private final ConfigApiService delegate = ConfigApiServiceFactory.getConfigApi();

    @POST
    @Path("/networks/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create networks by ID", notes = "Create operation of resource: networks", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createNetworksById(
        @ApiParam(value = "networksbody object" ,required=true) NetworksSchema networks,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createNetworksById(networks,securityContext);
    }
    @POST
    @Path("/networks/network/{networkId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create network by ID", notes = "Create operation of resource: network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createNetworksNetworkNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "networkbody object" ,required=true) NetworkSchema network,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createNetworksNetworkNetworkById(networkId,network,securityContext);
    }
    @POST
    @Path("/networks/network/{networkId}/node/{nodeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create node by ID", notes = "Create operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createNetworksNetworkNodeNodeById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
        @ApiParam(value = "nodebody object" ,required=true) NodeSchema node,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createNetworksNetworkNodeNodeById(networkId,nodeId,node,securityContext);
    }
//    @POST
//    @Path("/networks/network/{networkId}/node/{nodeId}/supporting-node/{networkRef nodeRef}/")
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "Create supporting-node by ID", notes = "Create operation of resource: supporting-node", response = void.class, tags={  })
//    @io.swagger.annotations.ApiResponses(value = { 
//        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
//        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
//    public Response createNetworksNetworkNodeSupportingNodeSupportingNodeById(
//        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
//        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
//        @ApiParam(value = "ID of networkRef nodeRef",required=true) @PathParam("networkRef nodeRef") String networkRefNodeRef,
//        @ApiParam(value = "supporting-nodebody object" ,required=true) SupportingNodeSchema supportingNode,
//        @Context SecurityContext securityContext)
//    throws NotFoundException {
//        return delegate.createNetworksNetworkNodeSupportingNodeSupportingNodeById(networkId,nodeId,networkRefNodeRef,supportingNode,securityContext);
//    }
    @POST
    @Path("/networks/network/{networkId}/supporting-network/{networkRef}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create supporting-network by ID", notes = "Create operation of resource: supporting-network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createNetworksNetworkSupportingNetworkSupportingNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of networkRef",required=true) @PathParam("networkRef") String networkRef,
        @ApiParam(value = "supporting-networkbody object" ,required=true) SupportingNetworkSchema supportingNetwork,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createNetworksNetworkSupportingNetworkSupportingNetworkById(networkId,networkRef,supportingNetwork,securityContext);
    }
    @DELETE
    @Path("/networks/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete networks by ID", notes = "Delete operation of resource: networks", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteNetworksById(
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteNetworksById(securityContext);
    }
    @DELETE
    @Path("/networks/network/{networkId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete network by ID", notes = "Delete operation of resource: network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteNetworksNetworkNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteNetworksNetworkNetworkById(networkId,securityContext);
    }
    @DELETE
    @Path("/networks/network/{networkId}/node/{nodeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete node by ID", notes = "Delete operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteNetworksNetworkNodeNodeById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteNetworksNetworkNodeNodeById(networkId,nodeId,securityContext);
    }
//    @DELETE
//    @Path("/networks/network/{networkId}/node/{nodeId}/supporting-node/{networkRef nodeRef}/")
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "Delete supporting-node by ID", notes = "Delete operation of resource: supporting-node", response = void.class, tags={  })
//    @io.swagger.annotations.ApiResponses(value = { 
//        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
//        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
//    public Response deleteNetworksNetworkNodeSupportingNodeSupportingNodeById(
//        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
//        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
//        @ApiParam(value = "ID of networkRef nodeRef",required=true) @PathParam("networkRef nodeRef") String networkRefNodeRef,
//        @Context SecurityContext securityContext)
//    throws NotFoundException {
//        return delegate.deleteNetworksNetworkNodeSupportingNodeSupportingNodeById(networkId,nodeId,networkRefNodeRef,securityContext);
//    }
    @DELETE
    @Path("/networks/network/{networkId}/supporting-network/{networkRef}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete supporting-network by ID", notes = "Delete operation of resource: supporting-network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteNetworksNetworkSupportingNetworkSupportingNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of networkRef",required=true) @PathParam("networkRef") String networkRef,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteNetworksNetworkSupportingNetworkSupportingNetworkById(networkId,networkRef,securityContext);
    }
    @GET
    @Path("/networks/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve networks", notes = "Retrieve operation of resource: networks", response = NetworksSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NetworksSchema.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NetworksSchema.class) })
    public Response retrieveNetworks(
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveNetworks(securityContext);
    }
    @GET
    @Path("/networks/network/{networkId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve network by ID", notes = "Retrieve operation of resource: network", response = NetworkSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NetworkSchema.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NetworkSchema.class) })
    public Response retrieveNetworksNetworkNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveNetworksNetworkNetworkById(networkId,securityContext);
    }
    @GET
    @Path("/networks/network/{networkId}/node/{nodeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node by ID", notes = "Retrieve operation of resource: node", response = NodeSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NodeSchema.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NodeSchema.class) })
    public Response retrieveNetworksNetworkNodeNodeById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveNetworksNetworkNodeNodeById(networkId,nodeId,securityContext);
    }
//    @GET
//    @Path("/networks/network/{networkId}/node/{nodeId}/supporting-node/{networkRef nodeRef}/")
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "Retrieve supporting-node by ID", notes = "Retrieve operation of resource: supporting-node", response = SupportingNodeSchema.class, tags={  })
//    @io.swagger.annotations.ApiResponses(value = { 
//        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SupportingNodeSchema.class),
//        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SupportingNodeSchema.class) })
//    public Response retrieveNetworksNetworkNodeSupportingNodeSupportingNodeById(
//        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
//        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
//        @ApiParam(value = "ID of networkRef nodeRef",required=true) @PathParam("networkRef nodeRef") String networkRefNodeRef,
//        @Context SecurityContext securityContext)
//    throws NotFoundException {
//        return delegate.retrieveNetworksNetworkNodeSupportingNodeSupportingNodeById(networkId,nodeId,networkRefNodeRef,securityContext);
//    }
    @GET
    @Path("/networks/network/{networkId}/supporting-network/{networkRef}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve supporting-network by ID", notes = "Retrieve operation of resource: supporting-network", response = SupportingNetworkSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SupportingNetworkSchema.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SupportingNetworkSchema.class) })
    public Response retrieveNetworksNetworkSupportingNetworkSupportingNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of networkRef",required=true) @PathParam("networkRef") String networkRef,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveNetworksNetworkSupportingNetworkSupportingNetworkById(networkId,networkRef,securityContext);
    }
    @PUT
    @Path("/networks/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update networks by ID", notes = "Update operation of resource: networks", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateNetworksById(
        @ApiParam(value = "networksbody object" ,required=true) NetworksSchema networks,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateNetworksById(networks,securityContext);
    }
    @PUT
    @Path("/networks/network/{networkId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update network by ID", notes = "Update operation of resource: network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateNetworksNetworkNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "networkbody object" ,required=true) NetworkSchema network,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateNetworksNetworkNetworkById(networkId,network,securityContext);
    }
    @PUT
    @Path("/networks/network/{networkId}/node/{nodeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update node by ID", notes = "Update operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateNetworksNetworkNodeNodeById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
        @ApiParam(value = "nodebody object" ,required=true) NodeSchema node,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateNetworksNetworkNodeNodeById(networkId,nodeId,node,securityContext);
    }
//    @PUT
//    @Path("/networks/network/{networkId}/node/{nodeId}/supporting-node/{networkRef nodeRef}/")
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "Update supporting-node by ID", notes = "Update operation of resource: supporting-node", response = void.class, tags={  })
//    @io.swagger.annotations.ApiResponses(value = { 
//        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
//        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
//    public Response updateNetworksNetworkNodeSupportingNodeSupportingNodeById(
//        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
//        @ApiParam(value = "ID of nodeId",required=true) @PathParam("nodeId") String nodeId,
//        @ApiParam(value = "ID of networkRef nodeRef",required=true) @PathParam("networkRef nodeRef") String networkRefNodeRef,
//        @ApiParam(value = "supporting-nodebody object" ,required=true) SupportingNodeSchema supportingNode,
//        @Context SecurityContext securityContext)
//    throws NotFoundException {
//        return delegate.updateNetworksNetworkNodeSupportingNodeSupportingNodeById(networkId,nodeId,networkRefNodeRef,supportingNode,securityContext);
//    }
    @PUT
    @Path("/networks/network/{networkId}/supporting-network/{networkRef}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update supporting-network by ID", notes = "Update operation of resource: supporting-network", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateNetworksNetworkSupportingNetworkSupportingNetworkById(
        @ApiParam(value = "ID of networkId",required=true) @PathParam("networkId") String networkId,
        @ApiParam(value = "ID of networkRef",required=true) @PathParam("networkRef") String networkRef,
        @ApiParam(value = "supporting-networkbody object" ,required=true) SupportingNetworkSchema supportingNetwork,
        @Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateNetworksNetworkSupportingNetworkSupportingNetworkById(networkId,networkRef,supportingNetwork,securityContext);
    }
}
