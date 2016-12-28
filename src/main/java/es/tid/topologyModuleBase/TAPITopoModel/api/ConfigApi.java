package es.tid.topologyModuleBase.TAPITopoModel.api;

import es.tid.topologyModuleBase.TAPITopoModel.model.*;
import es.tid.topologyModuleBase.TAPITopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.TAPITopoModel.api.factories.ConfigApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse200;
import es.tid.topologyModuleBase.TAPITopoModel.model.ExtensionsSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2001;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2002;
import es.tid.topologyModuleBase.TAPITopoModel.model.NwTopologyServiceSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2004;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20029;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2006;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20014;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2005;
import es.tid.topologyModuleBase.TAPITopoModel.model.Link;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2008;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2007;
import es.tid.topologyModuleBase.TAPITopoModel.model.LinkPort;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocolTransitionPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20015;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2009;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskParameterPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.AdminStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.Capacity;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20010;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCapacityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20011;
import es.tid.topologyModuleBase.TAPITopoModel.model.CostCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCostPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferIntegrityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20012;
import es.tid.topologyModuleBase.TAPITopoModel.model.LatencyCharacteristic;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferTimingPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.ValidationPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20013;
import es.tid.topologyModuleBase.TAPITopoModel.model.ValidationMechanism;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20030;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20017;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20027;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20028;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20016;
import es.tid.topologyModuleBase.TAPITopoModel.model.Node;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20019;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20022;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20021;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20020;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocol;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20023;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20018;
import es.tid.topologyModuleBase.TAPITopoModel.model.NodeEdgePoint;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20024;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20025;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse20026;
import es.tid.topologyModuleBase.TAPITopoModel.model.InlineResponse2003;
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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class ConfigApi  {
   private final ConfigApiService delegate = ConfigApiServiceFactory.getConfigApi();

    @GET
    @Path("/Context/_nwTopologyService/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse200.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse200.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse200.class) })
    public Response retrieveContextNwTopologyServiceExtensionsExtensions(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceExtensionsExtensions(securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextNwTopologyServiceExtensionsExtensionsById(@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceExtensionsExtensionsById(extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = InlineResponse2001.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2001.class) })
    public Response retrieveContextNwTopologyServiceLabelLabel(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceLabelLabel(securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/label/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextNwTopologyServiceLabelLabelById(@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceLabelLabelById(valueName,securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = InlineResponse2002.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2002.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2002.class) })
    public Response retrieveContextNwTopologyServiceNameName(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNameName(securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/name/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextNwTopologyServiceNameNameById(@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNameNameById(valueName,securityContext);
    }
    @GET
    @Path("/Context/_nwTopologyService/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _nwTopologyService", notes = "Retrieve operation of resource: _nwTopologyService", response = NwTopologyServiceSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NwTopologyServiceSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NwTopologyServiceSchema.class) })
    public Response retrieveContextNwTopologyServiceNwTopologyService(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextNwTopologyServiceNwTopologyService(securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse2004.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2004.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2004.class) })
    public Response retrieveContextTopologyExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyExtensionsExtensions(uuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyExtensionsExtensionsById(uuid,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = InlineResponse20029.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20029.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20029.class) })
    public Response retrieveContextTopologyLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLabelLabel(uuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/label/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLabelLabelById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse2006.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2006.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2006.class) })
    public Response retrieveContextTopologyLinkExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkExtensionsExtensions(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyLinkExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkExtensionsExtensionsById(uuid,linkUuid,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = InlineResponse20014.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20014.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20014.class) })
    public Response retrieveContextTopologyLinkLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLabelLabel(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/label/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLinkLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLabelLabelById(uuid,linkUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _link", notes = "Retrieve operation of resource: _link", response = InlineResponse2005.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2005.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2005.class) })
    public Response retrieveContextTopologyLinkLink(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLink(uuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _link by ID", notes = "Retrieve operation of resource: _link", response = Link.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_linkPort/{localId}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse2008.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2008.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2008.class) })
    public Response retrieveContextTopologyLinkLinkPortExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLinkPortExtensionsExtensions(uuid,linkUuid,localId,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_linkPort/{localId}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyLinkLinkPortExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLinkPortExtensionsExtensionsById(uuid,linkUuid,localId,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_linkPort/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _linkPort", notes = "Retrieve operation of resource: _linkPort", response = InlineResponse2007.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2007.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2007.class) })
    public Response retrieveContextTopologyLinkLinkPortLinkPort(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLinkPortLinkPort(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_linkPort/{localId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _linkPort by ID", notes = "Retrieve operation of resource: _linkPort", response = LinkPort.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkPort.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkPort.class) })
    public Response retrieveContextTopologyLinkLinkPortLinkPortById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkLinkPortLinkPortById(uuid,linkUuid,localId,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_lpTransition/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _lpTransition", notes = "Retrieve operation of resource: _lpTransition", response = LayerProtocolTransitionPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = InlineResponse20015.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20015.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20015.class) })
    public Response retrieveContextTopologyLinkNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkNameName(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/name/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyLinkNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkNameNameById(uuid,linkUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_riskParameter/riskCharacteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve riskCharacteristic", notes = "Retrieve operation of resource: riskCharacteristic", response = InlineResponse2009.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2009.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2009.class) })
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_riskParameter/riskCharacteristic/{riskCharacteristicName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve riskCharacteristic by ID", notes = "Retrieve operation of resource: riskCharacteristic", response = RiskCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = RiskCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = RiskCharacteristic.class) })
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristicById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of riskCharacteristicName",required=true) @PathParam("riskCharacteristicName") String riskCharacteristicName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristicById(uuid,linkUuid,riskCharacteristicName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_riskParameter/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _riskParameter", notes = "Retrieve operation of resource: _riskParameter", response = RiskParameterPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _state", notes = "Retrieve operation of resource: _state", response = AdminStatePac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCapacity/availableCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve availableCapacity", notes = "Retrieve operation of resource: availableCapacity", response = Capacity.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCapacity/capacityAssignedToUserView/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacityAssignedToUserView", notes = "Retrieve operation of resource: capacityAssignedToUserView", response = InlineResponse20010.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20010.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20010.class) })
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCapacity/capacityAssignedToUserView/{totalSize}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacityAssignedToUserView by ID", notes = "Retrieve operation of resource: capacityAssignedToUserView", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of totalSize",required=true) @PathParam("totalSize") String totalSize
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(uuid,linkUuid,totalSize,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCapacity/totalPotentialCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve totalPotentialCapacity", notes = "Retrieve operation of resource: totalPotentialCapacity", response = Capacity.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferCapacity", notes = "Retrieve operation of resource: _transferCapacity", response = TransferCapacityPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCost/costCharacteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve costCharacteristic", notes = "Retrieve operation of resource: costCharacteristic", response = InlineResponse20011.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20011.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20011.class) })
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCost/costCharacteristic/{costName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve costCharacteristic", notes = "Retrieve operation of resource: costCharacteristic", response = CostCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = CostCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = CostCharacteristic.class) })
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicCostName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of costName costValue costAlgorithm",required=true) @PathParam("costName") String costName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicCostName(uuid,linkUuid,costName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferCost/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferCost", notes = "Retrieve operation of resource: _transferCost", response = TransferCostPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferIntegrity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferIntegrity", notes = "Retrieve operation of resource: _transferIntegrity", response = TransferIntegrityPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferTiming/latencyCharacteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latencyCharacteristic", notes = "Retrieve operation of resource: latencyCharacteristic", response = InlineResponse20012.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20012.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20012.class) })
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristic(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferTiming/latencyCharacteristic/{trafficPropertyName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latencyCharacteristic", notes = "Retrieve operation of resource: latencyCharacteristic", response = LatencyCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LatencyCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LatencyCharacteristic.class) })
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of trafficPropertyName",required=true) @PathParam("trafficPropertyName") String trafficPropertyName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(uuid,linkUuid,trafficPropertyName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_transferTiming/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferTiming", notes = "Retrieve operation of resource: _transferTiming", response = TransferTimingPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_validation/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _validation", notes = "Retrieve operation of resource: _validation", response = ValidationPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_validation/validationMechanism/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve validationMechanism", notes = "Retrieve operation of resource: validationMechanism", response = InlineResponse20013.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20013.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20013.class) })
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanism(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkValidationValidationMechanismValidationMechanism(uuid,linkUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_link/{link_uuid}/_validation/validationMechanism/{validationMechanism}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve validationMechanism", notes = "Retrieve operation of resource: validationMechanism", response = ValidationMechanism.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ValidationMechanism.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ValidationMechanism.class) })
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismValidationMechanism(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of link_uuid",required=true) @PathParam("link_uuid") String linkUuid
,@ApiParam(value = "ID of validationMechanism",required=true) @PathParam("validationMechanism") String validationMechanism
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismValidationMechanism(uuid,linkUuid,validationMechanism,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = InlineResponse20030.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20030.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20030.class) })
    public Response retrieveContextTopologyNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNameName(uuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/name/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNameNameById(uuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse20017.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20017.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20017.class) })
    public Response retrieveContextTopologyNodeExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeExtensionsExtensions(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyNodeExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeExtensionsExtensionsById(uuid,nodeUuid,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = InlineResponse20027.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20027.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20027.class) })
    public Response retrieveContextTopologyNodeLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeLabelLabel(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/label/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeLabelLabelById(uuid,nodeUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = InlineResponse20028.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20028.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20028.class) })
    public Response retrieveContextTopologyNodeNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNameName(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/name/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNameNameById(uuid,nodeUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _node", notes = "Retrieve operation of resource: _node", response = InlineResponse20016.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20016.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20016.class) })
    public Response retrieveContextTopologyNodeNode(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeNode(uuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _node by ID", notes = "Retrieve operation of resource: _node", response = Node.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse20019.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20019.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20019.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensions(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensionsById(uuid,nodeUuid,ownedNodeEdgePointUuid,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/label/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label", notes = "Retrieve operation of resource: label", response = InlineResponse20022.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20022.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20022.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabel(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabel(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/label/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve label by ID", notes = "Retrieve operation of resource: label", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabelById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabelById(uuid,nodeUuid,ownedNodeEdgePointUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_layerProtocol/{localId}/_extensions/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions", notes = "Retrieve operation of resource: _extensions", response = InlineResponse20021.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20021.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20021.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensions(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensions(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_layerProtocol/{localId}/_extensions/{extensionsSpecification}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _extensions by ID", notes = "Retrieve operation of resource: _extensions", response = ExtensionsSpec.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ExtensionsSpec.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ExtensionsSpec.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensionsById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@ApiParam(value = "ID of extensionsSpecification",required=true) @PathParam("extensionsSpecification") String extensionsSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensionsById(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,extensionsSpecification,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_layerProtocol/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _layerProtocol", notes = "Retrieve operation of resource: _layerProtocol", response = InlineResponse20020.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20020.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20020.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocol(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocol(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_layerProtocol/{localId}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _layerProtocol by ID", notes = "Retrieve operation of resource: _layerProtocol", response = LayerProtocol.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LayerProtocol.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LayerProtocol.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocolById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of localId",required=true) @PathParam("localId") String localId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocolById(uuid,nodeUuid,ownedNodeEdgePointUuid,localId,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/name/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name", notes = "Retrieve operation of resource: name", response = InlineResponse20023.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20023.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20023.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointNameName(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/name/{valueName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve name by ID", notes = "Retrieve operation of resource: name", response = NameAndValue.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NameAndValue.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NameAndValue.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@ApiParam(value = "ID of valueName",required=true) @PathParam("valueName") String valueName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid,nodeUuid,ownedNodeEdgePointUuid,valueName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _ownedNodeEdgePoint", notes = "Retrieve operation of resource: _ownedNodeEdgePoint", response = InlineResponse20018.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20018.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20018.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _ownedNodeEdgePoint by ID", notes = "Retrieve operation of resource: _ownedNodeEdgePoint", response = NodeEdgePoint.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NodeEdgePoint.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NodeEdgePoint.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_ownedNodeEdgePoint/{ownedNodeEdgePoint_uuid}/_state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _state", notes = "Retrieve operation of resource: _state", response = AdminStatePac.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AdminStatePac.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AdminStatePac.class) })
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointStateState(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of ownedNodeEdgePoint_uuid",required=true) @PathParam("ownedNodeEdgePoint_uuid") String ownedNodeEdgePointUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeOwnedNodeEdgePointStateState(uuid,nodeUuid,ownedNodeEdgePointUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_state/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _state", notes = "Retrieve operation of resource: _state", response = AdminStatePac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCapacity/availableCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve availableCapacity", notes = "Retrieve operation of resource: availableCapacity", response = Capacity.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCapacity/capacityAssignedToUserView/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacityAssignedToUserView", notes = "Retrieve operation of resource: capacityAssignedToUserView", response = InlineResponse20024.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20024.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20024.class) })
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCapacity/capacityAssignedToUserView/{totalSize}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capacityAssignedToUserView by ID", notes = "Retrieve operation of resource: capacityAssignedToUserView", response = Capacity.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Capacity.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Capacity.class) })
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of totalSize",required=true) @PathParam("totalSize") String totalSize
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(uuid,nodeUuid,totalSize,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCapacity/totalPotentialCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve totalPotentialCapacity", notes = "Retrieve operation of resource: totalPotentialCapacity", response = Capacity.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCapacity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferCapacity", notes = "Retrieve operation of resource: _transferCapacity", response = TransferCapacityPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCost/costCharacteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve costCharacteristic", notes = "Retrieve operation of resource: costCharacteristic", response = InlineResponse20025.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20025.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20025.class) })
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristic(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCost/costCharacteristic/{costName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve costCharacteristic", notes = "Retrieve operation of resource: costCharacteristic", response = CostCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = CostCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = CostCharacteristic.class) })
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicCostName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of costName costValue costAlgorithm",required=true) @PathParam("costName") String costName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicCostName(uuid,nodeUuid,costName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferCost/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferCost", notes = "Retrieve operation of resource: _transferCost", response = TransferCostPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferIntegrity/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferIntegrity", notes = "Retrieve operation of resource: _transferIntegrity", response = TransferIntegrityPac.class, tags={  })
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
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferTiming/latencyCharacteristic/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latencyCharacteristic", notes = "Retrieve operation of resource: latencyCharacteristic", response = InlineResponse20026.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse20026.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse20026.class) })
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristic(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristic(uuid,nodeUuid,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferTiming/latencyCharacteristic/{trafficPropertyName}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve latencyCharacteristic", notes = "Retrieve operation of resource: latencyCharacteristic", response = LatencyCharacteristic.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LatencyCharacteristic.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LatencyCharacteristic.class) })
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@ApiParam(value = "ID of node_uuid",required=true) @PathParam("node_uuid") String nodeUuid
,@ApiParam(value = "ID of trafficPropertyName",required=true) @PathParam("trafficPropertyName") String trafficPropertyName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(uuid,nodeUuid,trafficPropertyName,securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/_node/{node_uuid}/_transferTiming/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _transferTiming", notes = "Retrieve operation of resource: _transferTiming", response = TransferTimingPac.class, tags={  })
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
    @Path("/Context/_topology/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _topology", notes = "Retrieve operation of resource: _topology", response = InlineResponse2003.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InlineResponse2003.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InlineResponse2003.class) })
    public Response retrieveContextTopologyTopology(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyTopology(securityContext);
    }
    @GET
    @Path("/Context/_topology/{uuid}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve _topology by ID", notes = "Retrieve operation of resource: _topology", response = Topology.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Topology.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Topology.class) })
    public Response retrieveContextTopologyTopologyById(@ApiParam(value = "ID of uuid",required=true) @PathParam("uuid") String uuid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveContextTopologyTopologyById(uuid,securityContext);
    }
}
