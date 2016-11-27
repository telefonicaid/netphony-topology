package es.tid.topologyModuleBase.COPServiceTopology.server.api;

import es.tid.topologyModuleBase.COPServiceTopology.model.*;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.ConfigApiService;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.NotFoundException;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.factories.ConfigApiServiceFactory;
import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import java.util.List;
import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/restconf/data")


@io.swagger.annotations.Api(value = "/data", description = "the config API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class ConfigApi  {

   private final ConfigApiService delegate = ConfigApiServiceFactory.getConfigApi();

    @GET
    @Path("/topologies/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve topologies", notes = "Retrieve operation of resource: topologies", response = TopologiesSchema.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TopologiesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TopologiesSchema.class) })

    public Response retrieveTopologies()
    throws NotFoundException {
    return delegate.retrieveTopologies();
    }
    @GET
    @Path("/topologies/topology/{topologyId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve topology by ID", notes = "Retrieve operation of resource: topology", response = Topology.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Topology.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Topology.class) })

    public Response retrieveTopologiesTopologyTopologyById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyTopologyById(topologyId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve edges by ID", notes = "Retrieve operation of resource: edges", response = Edge.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Edge.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Edge.class) })

    public Response retrieveTopologiesTopologyEdgesEdgesById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesEdgesById(topologyId,edgeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/local_ifid/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve local_ifid by ID", notes = "Retrieve operation of resource: local_ifid", response = EdgeEnd.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = EdgeEnd.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = EdgeEnd.class) })

    public Response retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById(topologyId,edgeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/remote_ifid/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve remote_ifid by ID", notes = "Retrieve operation of resource: remote_ifid", response = EdgeEnd.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = EdgeEnd.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = EdgeEnd.class) })

    public Response retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById(topologyId,edgeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/source/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve source by ID", notes = "Retrieve operation of resource: source", response = Node.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })

    public Response retrieveTopologiesTopologyEdgesSourceSourceById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesSourceSourceById(topologyId,edgeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/source/edge_end/{edgeEndId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve edge_end by ID", notes = "Retrieve operation of resource: edge_end", response = EdgeEnd.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = EdgeEnd.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = EdgeEnd.class) })

    public Response retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId,
    @ApiParam(value = "ID of edgeEndId",required=true ) @PathParam("edgeEndId") String edgeEndId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById(topologyId,edgeId,edgeEndId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/target/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve target by ID", notes = "Retrieve operation of resource: target", response = Node.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })

    public Response retrieveTopologiesTopologyEdgesTargetTargetById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesTargetTargetById(topologyId,edgeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/edges/{edgeId}/target/edge_end/{edgeEndId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve edge_end by ID", notes = "Retrieve operation of resource: edge_end", response = EdgeEnd.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = EdgeEnd.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = EdgeEnd.class) })

    public Response retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of edgeId",required=true ) @PathParam("edgeId") String edgeId,
    @ApiParam(value = "ID of edgeEndId",required=true ) @PathParam("edgeEndId") String edgeEndId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById(topologyId,edgeId,edgeEndId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/nodes/{nodeId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve nodes by ID", notes = "Retrieve operation of resource: nodes", response = Node.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })

    public Response retrieveTopologiesTopologyNodesNodesById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of nodeId",required=true ) @PathParam("nodeId") String nodeId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyNodesNodesById(topologyId,nodeId);
    }
    @GET
    @Path("/topologies/topology/{topologyId}/nodes/{nodeId}/edge_end/{edgeEndId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve edge_end by ID", notes = "Retrieve operation of resource: edge_end", response = EdgeEnd.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = EdgeEnd.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = EdgeEnd.class) })

    public Response retrieveTopologiesTopologyNodesEdgeEndEdgeEndById(@ApiParam(value = "ID of topologyId",required=true ) @PathParam("topologyId") String topologyId,
    @ApiParam(value = "ID of nodeId",required=true ) @PathParam("nodeId") String nodeId,
    @ApiParam(value = "ID of edgeEndId",required=true ) @PathParam("edgeEndId") String edgeEndId)
    throws NotFoundException {
    return delegate.retrieveTopologiesTopologyNodesEdgeEndEdgeEndById(topologyId,nodeId,edgeEndId);
    }
}

