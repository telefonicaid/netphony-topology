package es.tid.topologyModuleBase.TAPITopoModel.api;

import es.tid.topologyModuleBase.TAPITopoModel.model.*;
import es.tid.topologyModuleBase.TAPITopoModel.api.OperationsApiService;
import es.tid.topologyModuleBase.TAPITopoModel.api.factories.OperationsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import es.tid.topologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyListRPCOutputSchema;

import java.util.List;
import es.tid.topologyModuleBase.TAPITopoModel.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/operations")


@io.swagger.annotations.Api(description = "the operations API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class OperationsApi  {
   private final OperationsApiService delegate = OperationsApiServiceFactory.getOperationsApi();

    @POST
    @Path("/getLinkDetails/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create getLinkDetails by ID", notes = "Create operation of resource: getLinkDetails", response = GetLinkDetailsRPCOutputSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = GetLinkDetailsRPCOutputSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = GetLinkDetailsRPCOutputSchema.class) })
    public Response createGetLinkDetailsById(@ApiParam(value = "getLinkDetailsbody object" ,required=true) GetLinkDetailsRPCInputSchema getLinkDetails
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createGetLinkDetailsById(getLinkDetails,securityContext);
    }
    @POST
    @Path("/getNodeDetails/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create getNodeDetails by ID", notes = "Create operation of resource: getNodeDetails", response = GetNodeDetailsRPCOutputSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = GetNodeDetailsRPCOutputSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = GetNodeDetailsRPCOutputSchema.class) })
    public Response createGetNodeDetailsById(@ApiParam(value = "getNodeDetailsbody object" ,required=true) GetNodeDetailsRPCInputSchema getNodeDetails
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createGetNodeDetailsById(getNodeDetails,securityContext);
    }
    @POST
    @Path("/getNodeEdgePointDetails/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create getNodeEdgePointDetails by ID", notes = "Create operation of resource: getNodeEdgePointDetails", response = GetNodeEdgePointDetailsRPCOutputSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = GetNodeEdgePointDetailsRPCOutputSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = GetNodeEdgePointDetailsRPCOutputSchema.class) })
    public Response createGetNodeEdgePointDetailsById(@ApiParam(value = "getNodeEdgePointDetailsbody object" ,required=true) GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createGetNodeEdgePointDetailsById(getNodeEdgePointDetails,securityContext);
    }
    @POST
    @Path("/getTopologyDetails/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create getTopologyDetails by ID", notes = "Create operation of resource: getTopologyDetails", response = GetTopologyDetailsRPCOutputSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = GetTopologyDetailsRPCOutputSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = GetTopologyDetailsRPCOutputSchema.class) })
    public Response createGetTopologyDetailsById(@ApiParam(value = "getTopologyDetailsbody object" ,required=true) GetTopologyDetailsRPCInputSchema getTopologyDetails
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createGetTopologyDetailsById(getTopologyDetails,securityContext);
    }
    @POST
    @Path("/getTopologyList/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create getTopologyList by ID", notes = "Create operation of resource: getTopologyList", response = GetTopologyListRPCOutputSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = GetTopologyListRPCOutputSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = GetTopologyListRPCOutputSchema.class) })
    public Response createGetTopologyListById(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createGetTopologyListById(securityContext);
    }
}
