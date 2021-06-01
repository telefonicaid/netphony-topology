package es.tid.topologyModuleBase.TAPITopoModel.api;

import es.tid.topologyModuleBase.TAPITopoModel.model.*;
import es.tid.topologyModuleBase.TAPITopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.TAPITopoModel.api.factories.ConfigApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import es.tid.topologyModuleBase.TAPITopoModel.model.ContextSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.NetworkTopologyService;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocol;
import es.tid.topologyModuleBase.TAPITopoModel.model.ServiceEndPoint;
import es.tid.topologyModuleBase.TAPITopoModel.model.LifecycleStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.Link;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocolTransitionPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskParameterPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.AdminStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.Capacity;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCapacityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.CostCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCostPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferIntegrityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.LatencyCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferTimingPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.ValidationPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.ValidationMechanism;
import es.tid.topologyModuleBase.TAPITopoModel.model.Node;
import es.tid.topologyModuleBase.TAPITopoModel.model.NodeEdgePoint;
import es.tid.topologyModuleBase.TAPITopoModel.model.Topology;

import java.util.List;
import es.tid.topologyModuleBase.TAPITopoModel.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/config")


@io.swagger.annotations.Api(description = "the config API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class ConfigApi  {
   private final ConfigApiService delegate = ConfigApiServiceFactory.getConfigApi();

    @POST
    @Path("/context/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create context by ID", notes = "Create operation of resource: context", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createContextById(@ApiParam(value = "contextbody object" ,required=true) ContextSchema context
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createContextById(context,securityContext);
    }
    @POST
    @Path("/context/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create label by ID", notes = "Create operation of resource: label", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createContextLabelLabelById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@ApiParam(value = "labelbody object" ,required=true) NameAndValue label
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createContextLabelLabelById(valueName,label,securityContext);
    }
    @POST
    @Path("/context/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create name by ID", notes = "Create operation of resource: name", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createContextNameNameById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@ApiParam(value = "namebody object" ,required=true) NameAndValue name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createContextNameNameById(valueName,name,securityContext);
    }
    @DELETE
    @Path("/context/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete context by ID", notes = "Delete operation of resource: context", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteContextById(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteContextById(securityContext);
    }
    @DELETE
    @Path("/context/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete label by ID", notes = "Delete operation of resource: label", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteContextLabelLabelById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteContextLabelLabelById(valueName,securityContext);
    }
    @DELETE
    @Path("/context/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete name by ID", notes = "Delete operation of resource: name", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteContextNameNameById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteContextNameNameById(valueName,securityContext);
    }
    @GET
    @Path("/context/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve context", notes = "Retrieve operation of resource: context", response = ContextSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ContextSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ContextSchema.class) })
    public Response retrieveContext(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContext(securityContext);
    }
    @GET
    @Path("/context/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextLabelLabel(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextLabelLabel(securityContext);
    }
    @GET
    @Path("/context/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextLabelLabelById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextLabelLabelById(valueName,securityContext);
    }
    @GET
    @Path("/context/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextNameName(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNameName(securityContext);
    }
    @GET
    @Path("/context/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextNameNameById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNameNameById(valueName,securityContext);
    }
    @GET
    @Path("/context/nw-topology-service/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextNwTopologyServiceLabelLabel(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceLabelLabel(securityContext);
    }
    @GET
    @Path("/context/nw-topology-service/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextNwTopologyServiceLabelLabelById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceLabelLabelById(valueName,securityContext);
    }
    @GET
    @Path("/context/nw-topology-service/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextNwTopologyServiceNameName(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNameName(securityContext);
    }
    @GET
    @Path("/context/nw-topology-service/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextNwTopologyServiceNameNameById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNameNameById(valueName,securityContext);
    }
    @GET
    @Path("/context/nw-topology-service/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve nw-topology-service", notes = "Retrieve operation of resource: nw-topology-service", response = NetworkTopologyService.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NetworkTopologyService.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NetworkTopologyService.class) })
    public Response retrieveContextNwTopologyServiceNwTopologyService(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNwTopologyService(securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextServiceEndPointLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLabelLabel(uuid,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextServiceEndPointLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLabelLabelById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/layer-protocol/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve layer-protocol", notes = "Retrieve operation of resource: layer-protocol", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextServiceEndPointLayerProtocolLayerProtocol(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLayerProtocolLayerProtocol(uuid,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/layer-protocol/{local-id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve layer-protocol by ID", notes = "Retrieve operation of resource: layer-protocol", response = LayerProtocol.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LayerProtocol.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LayerProtocol.class) })
    public Response retrieveContextServiceEndPointLayerProtocolLayerProtocolById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLayerProtocolLayerProtocolById(uuid,localId,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/layer-protocol/{local-id}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextServiceEndPointLayerProtocolNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLayerProtocolNameName(uuid,localId,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/layer-protocol/{local-id}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextServiceEndPointLayerProtocolNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointLayerProtocolNameNameById(uuid,localId,valueName,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextServiceEndPointNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointNameName(uuid,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextServiceEndPointNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointNameNameById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/context/service-end-point/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve service-end-point", notes = "Retrieve operation of resource: service-end-point", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextServiceEndPointServiceEndPoint(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointServiceEndPoint(securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve service-end-point by ID", notes = "Retrieve operation of resource: service-end-point", response = ServiceEndPoint.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ServiceEndPoint.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ServiceEndPoint.class) })
    public Response retrieveContextServiceEndPointServiceEndPointById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointServiceEndPointById(uuid,securityContext);
    }
    @GET
    @Path("/context/service-end-point/{uuid}/state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve state", notes = "Retrieve operation of resource: state", response = LifecycleStatePac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LifecycleStatePac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LifecycleStatePac.class) })
    public Response retrieveContextServiceEndPointStateState(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextServiceEndPointStateState(uuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLabelLabel(uuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLabelLabelById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLabelLabel(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLinkLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLabelLabelById(uuid,linkUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link", notes = "Retrieve operation of resource: link", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkLink(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLink(uuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link by ID", notes = "Retrieve operation of resource: link", response = Link.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Link.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Link.class) })
    public Response retrieveContextTopologyLinkLinkById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLinkById(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/lp-transition/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve lp-transition", notes = "Retrieve operation of resource: lp-transition", response = LayerProtocolTransitionPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LayerProtocolTransitionPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LayerProtocolTransitionPac.class) })
    public Response retrieveContextTopologyLinkLpTransitionLpTransition(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLpTransitionLpTransition(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkNameName(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLinkNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkNameNameById(uuid,linkUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/risk-parameter/risk-characteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve risk-characteristic", notes = "Retrieve operation of resource: risk-characteristic", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/risk-parameter/risk-characteristic/{risk-characteristic-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve risk-characteristic by ID", notes = "Retrieve operation of resource: risk-characteristic", response = RiskCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = RiskCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = RiskCharacteristic.class) })
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of risk-characteristic-name",required=true) @PathParam("risk-characteristic-name") String riskCharacteristicName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristicById(uuid,linkUuid,riskCharacteristicName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/risk-parameter/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve risk-parameter", notes = "Retrieve operation of resource: risk-parameter", response = RiskParameterPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = RiskParameterPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = RiskParameterPac.class) })
    public Response retrieveContextTopologyLinkRiskParameterRiskParameter(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkRiskParameterRiskParameter(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve state", notes = "Retrieve operation of resource: state", response = AdminStatePac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AdminStatePac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AdminStatePac.class) })
    public Response retrieveContextTopologyLinkStateState(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkStateState(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-capacity/available-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve available-capacity", notes = "Retrieve operation of resource: available-capacity", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyLinkTransferCapacityAvailableCapacityAvailableCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityAvailableCapacityAvailableCapacity(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-capacity/capacity-assigned-to-user-view/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacity-assigned-to-user-view", notes = "Retrieve operation of resource: capacity-assigned-to-user-view", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-capacity/capacity-assigned-to-user-view/{total-size}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacity-assigned-to-user-view by ID", notes = "Retrieve operation of resource: capacity-assigned-to-user-view", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of total-size",required=true) @PathParam("total-size") String totalSize
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(uuid,linkUuid,totalSize,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-capacity/total-potential-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve total-potential-capacity", notes = "Retrieve operation of resource: total-potential-capacity", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyLinkTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-capacity", notes = "Retrieve operation of resource: transfer-capacity", response = TransferCapacityPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferCapacityPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferCapacityPac.class) })
    public Response retrieveContextTopologyLinkTransferCapacityTransferCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityTransferCapacity(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-cost/cost-characteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve cost-characteristic", notes = "Retrieve operation of resource: cost-characteristic", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-cost/cost-characteristic/{cost-name-cost-value-cost-algorithm}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve cost-characteristic by ID", notes = "Retrieve operation of resource: cost-characteristic", response = CostCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = CostCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = CostCharacteristic.class) })
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of cost-name cost-value cost-algorithm",required=true) @PathParam("cost-name-cost-value-cost-algorithm") String costNameCostValueCostAlgorithm
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicById(uuid,linkUuid,costNameCostValueCostAlgorithm,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-cost/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-cost", notes = "Retrieve operation of resource: transfer-cost", response = TransferCostPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferCostPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferCostPac.class) })
    public Response retrieveContextTopologyLinkTransferCostTransferCost(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCostTransferCost(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-integrity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-integrity", notes = "Retrieve operation of resource: transfer-integrity", response = TransferIntegrityPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferIntegrityPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferIntegrityPac.class) })
    public Response retrieveContextTopologyLinkTransferIntegrityTransferIntegrity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferIntegrityTransferIntegrity(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-timing/latency-characteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latency-characteristic", notes = "Retrieve operation of resource: latency-characteristic", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-timing/latency-characteristic/{traffic-property-name-traffic-property-queing-latency}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latency-characteristic by ID", notes = "Retrieve operation of resource: latency-characteristic", response = LatencyCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LatencyCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LatencyCharacteristic.class) })
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of traffic-property-name traffic-property-queing-latency",required=true) @PathParam("traffic-property-name-traffic-property-queing-latency") String trafficPropertyNameTrafficPropertyQueingLatency
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicById(uuid,linkUuid,trafficPropertyNameTrafficPropertyQueingLatency,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/transfer-timing/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-timing", notes = "Retrieve operation of resource: transfer-timing", response = TransferTimingPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferTimingPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferTimingPac.class) })
    public Response retrieveContextTopologyLinkTransferTimingTransferTiming(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferTimingTransferTiming(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/validation/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve validation", notes = "Retrieve operation of resource: validation", response = ValidationPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ValidationPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ValidationPac.class) })
    public Response retrieveContextTopologyLinkValidationValidation(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkValidationValidation(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/validation/validation-mechanism/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve validation-mechanism", notes = "Retrieve operation of resource: validation-mechanism", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanism(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkValidationValidationMechanismValidationMechanism(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/link/{link_uuid}/validation/validation-mechanism/{validation-mechanism-layer-protocol-adjacency-validated-validation-robustness}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve validation-mechanism by ID", notes = "Retrieve operation of resource: validation-mechanism", response = ValidationMechanism.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ValidationMechanism.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ValidationMechanism.class) })
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of validation-mechanism layer-protocol-adjacency-validated validation-robustness",required=true) @PathParam("validation-mechanism-layer-protocol-adjacency-validated-validation-robustness") String validationMechanismLayerProtocolAdjacencyValidatedValidationRobustness
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismById(uuid,linkUuid,validationMechanismLayerProtocolAdjacencyValidatedValidationRobustness,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNameName(uuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNameNameById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeLabelLabel(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeLabelLabelById(uuid,nodeUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNameName(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNameNameById(uuid,nodeUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node", notes = "Retrieve operation of resource: node", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeNode(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNode(uuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node by ID", notes = "Retrieve operation of resource: node", response = Node.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })
    public Response retrieveContextTopologyNodeNodeById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNodeById(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabel(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabelById(uuid,nodeUuid,ownedNodeEdgePointUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/layer-protocol/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve layer-protocol", notes = "Retrieve operation of resource: layer-protocol", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocol(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocol(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/layer-protocol/{local-id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve layer-protocol by ID", notes = "Retrieve operation of resource: layer-protocol", response = LayerProtocol.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LayerProtocol.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LayerProtocol.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocolById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocolById(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/layer-protocol/{local-id}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameName(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/layer-protocol/{local-id}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of local-id",required=true) @PathParam("local-id") String localId
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameNameById(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointNameName(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid,nodeUuid,ownedNodeEdgePointUuid,valueName,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve owned-node-edge-point", notes = "Retrieve operation of resource: owned-node-edge-point", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve owned-node-edge-point by ID", notes = "Retrieve operation of resource: owned-node-edge-point", response = NodeEdgePoint.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NodeEdgePoint.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NodeEdgePoint.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned-node-edge-point_uuid}/state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve state", notes = "Retrieve operation of resource: state", response = AdminStatePac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AdminStatePac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AdminStatePac.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointStateState(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of owned-node-edge-point_uuid",required=true) @PathParam("owned-node-edge-point_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointStateState(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve state", notes = "Retrieve operation of resource: state", response = AdminStatePac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AdminStatePac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AdminStatePac.class) })
    public Response retrieveContextTopologyNodeStateState(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeStateState(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-capacity/available-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve available-capacity", notes = "Retrieve operation of resource: available-capacity", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyNodeTransferCapacityAvailableCapacityAvailableCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityAvailableCapacityAvailableCapacity(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-capacity/capacity-assigned-to-user-view/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacity-assigned-to-user-view", notes = "Retrieve operation of resource: capacity-assigned-to-user-view", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-capacity/capacity-assigned-to-user-view/{total-size}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacity-assigned-to-user-view by ID", notes = "Retrieve operation of resource: capacity-assigned-to-user-view", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of total-size",required=true) @PathParam("total-size") String totalSize
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(uuid,nodeUuid,totalSize,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-capacity/total-potential-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve total-potential-capacity", notes = "Retrieve operation of resource: total-potential-capacity", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyNodeTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-capacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-capacity", notes = "Retrieve operation of resource: transfer-capacity", response = TransferCapacityPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferCapacityPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferCapacityPac.class) })
    public Response retrieveContextTopologyNodeTransferCapacityTransferCapacity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityTransferCapacity(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-cost/cost-characteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve cost-characteristic", notes = "Retrieve operation of resource: cost-characteristic", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristic(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-cost/cost-characteristic/{cost-name-cost-value-cost-algorithm}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve cost-characteristic by ID", notes = "Retrieve operation of resource: cost-characteristic", response = CostCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = CostCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = CostCharacteristic.class) })
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of cost-name cost-value cost-algorithm",required=true) @PathParam("cost-name-cost-value-cost-algorithm") String costNameCostValueCostAlgorithm
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicById(uuid,nodeUuid,costNameCostValueCostAlgorithm,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-cost/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-cost", notes = "Retrieve operation of resource: transfer-cost", response = TransferCostPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferCostPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferCostPac.class) })
    public Response retrieveContextTopologyNodeTransferCostTransferCost(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCostTransferCost(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-integrity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-integrity", notes = "Retrieve operation of resource: transfer-integrity", response = TransferIntegrityPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferIntegrityPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferIntegrityPac.class) })
    public Response retrieveContextTopologyNodeTransferIntegrityTransferIntegrity(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferIntegrityTransferIntegrity(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-timing/latency-characteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latency-characteristic", notes = "Retrieve operation of resource: latency-characteristic", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristic(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-timing/latency-characteristic/{traffic-property-name-traffic-property-queing-latency}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latency-characteristic by ID", notes = "Retrieve operation of resource: latency-characteristic", response = LatencyCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LatencyCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LatencyCharacteristic.class) })
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of traffic-property-name-traffic-property-queing-latency",required=true) @PathParam("traffic-property-name-traffic-property-queing-latency") String trafficPropertyNameTrafficPropertyQueingLatency
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicById(uuid,nodeUuid,trafficPropertyNameTrafficPropertyQueingLatency,securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/node/{node_uuid}/transfer-timing/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve transfer-timing", notes = "Retrieve operation of resource: transfer-timing", response = TransferTimingPac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = TransferTimingPac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = TransferTimingPac.class) })
    public Response retrieveContextTopologyNodeTransferTimingTransferTiming(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferTimingTransferTiming(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/context/topology/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve topology", notes = "Retrieve operation of resource: topology", response = String.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = String.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = String.class, responseContainer = "List") })
    public Response retrieveContextTopologyTopology(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyTopology(securityContext);
    }
    @GET
    @Path("/context/topology/{uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve topology by ID", notes = "Retrieve operation of resource: topology", response = Topology.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Topology.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Topology.class) })
    public Response retrieveContextTopologyTopologyById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyTopologyById(uuid,securityContext);
    }
    @PUT
    @Path("/context/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update context by ID", notes = "Update operation of resource: context", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateContextById(@ApiParam(value = "contextbody object" ,required=true) ContextSchema context
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateContextById(context,securityContext);
    }
    @PUT
    @Path("/context/label/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update label by ID", notes = "Update operation of resource: label", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateContextLabelLabelById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@ApiParam(value = "labelbody object" ,required=true) NameAndValue label
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateContextLabelLabelById(valueName,label,securityContext);
    }
    @PUT
    @Path("/context/name/{value-name}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update name by ID", notes = "Update operation of resource: name", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateContextNameNameById(@ApiParam(value = "ID of value-name",required=true) @PathParam("value-name") String valueName
,@ApiParam(value = "namebody object" ,required=true) NameAndValue name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateContextNameNameById(valueName,name,securityContext);
    }
}
