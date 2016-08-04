package es.tid.topologyModuleBase.UnifyTopoModel.api;

import es.tid.topologyModuleBase.UnifyTopoModel.model.*;
import es.tid.topologyModuleBase.UnifyTopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.UnifyTopoModel.api.factories.ConfigApiServiceFactory;

import io.swagger.annotations.ApiParam;

import es.tid.topologyModuleBase.UnifyTopoModel.model.VirtualizerSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Link;
import es.tid.topologyModuleBase.UnifyTopoModel.model.LinkResource;
import es.tid.topologyModuleBase.UnifyTopoModel.model.LinksSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.MetadataSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.CapabilitiesSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Node;
import es.tid.topologyModuleBase.UnifyTopoModel.model.AddressesSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.L3Address;
import es.tid.topologyModuleBase.UnifyTopoModel.model.ControlSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Port;
import es.tid.topologyModuleBase.UnifyTopoModel.model.SapDataSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.PortsSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.SoftwareResource;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Nodes;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Flowentry;
import es.tid.topologyModuleBase.UnifyTopoModel.model.FlowtableSchema;
import es.tid.topologyModuleBase.UnifyTopoModel.model.InfraNode;
import es.tid.topologyModuleBase.UnifyTopoModel.model.NodesSchema;

import java.util.List;
import es.tid.topologyModuleBase.UnifyTopoModel.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/restconf/data")


@io.swagger.annotations.Api(description = "the config API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class ConfigApi  {
   private final ConfigApiService delegate = ConfigApiServiceFactory.getConfigApi();

    @POST
    @Path("/virtualizer/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create virtualizer by ID", notes = "Create operation of resource: virtualizer", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerById(@ApiParam(value = "virtualizerbody object" ,required=true) VirtualizerSchema virtualizer
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerById(virtualizer,securityContext);
    }
    @POST
    @Path("/virtualizer/links/link/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create link by ID", notes = "Create operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerLinksLinkLinkById(id,link,securityContext);
    }
    @POST
    @Path("/virtualizer/links/link/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerLinksLinkResourcesResourcesById(id,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create links by ID", notes = "Create operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerLinksLinksById(@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerLinksLinksById(links,securityContext);
    }
    @POST
    @Path("/virtualizer/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerMetadataMetadataById(@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerMetadataMetadataById(key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create capabilities by ID", notes = "Create operation of resource: capabilities", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesCapabilitiesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "capabilitiesbody object" ,required=true) CapabilitiesSchema capabilities
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesCapabilitiesById(id,capabilities,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create link by ID", notes = "Create operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(id,odeId,inkId,link,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(id,odeId,inkId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create links by ID", notes = "Create operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(id,odeId,links,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(id,odeId,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create node by ID", notes = "Create operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "nodebody object" ,required=true) Node node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(id,odeId,node,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create addresses by ID", notes = "Create operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(id,odeId,ortId,addresses,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create l3 by ID", notes = "Create operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,l3,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create control by ID", notes = "Create operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(id,odeId,ortId,control,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(id,odeId,ortId,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create port by ID", notes = "Create operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(id,odeId,ortId,port,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create sap_data by ID", notes = "Create operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(id,odeId,ortId,sapData,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create ports by ID", notes = "Create operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(id,odeId,ports,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(id,odeId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create supported_NFs by ID", notes = "Create operation of resource: supported_NFs", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "supported_NFsbody object" ,required=true) Nodes supportedNFs
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(id,supportedNFs,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create flowentry by ID", notes = "Create operation of resource: flowentry", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeFlowtableFlowentryFlowentryById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@ApiParam(value = "flowentrybody object" ,required=true) Flowentry flowentry
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeFlowtableFlowentryFlowentryById(id,lowentryId,flowentry,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(id,lowentryId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/flowtable/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create flowtable by ID", notes = "Create operation of resource: flowtable", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeFlowtableFlowtableById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "flowtablebody object" ,required=true) FlowtableSchema flowtable
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeFlowtableFlowtableById(id,flowtable,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create link by ID", notes = "Create operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeLinksLinkLinkById(id,inkId,link,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeLinksLinkResourcesResourcesById(id,inkId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create links by ID", notes = "Create operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeLinksLinksById(id,links,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeMetadataMetadataById(id,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create NF_instances by ID", notes = "Create operation of resource: NF_instances", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNFInstancesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "NF_instancesbody object" ,required=true) Nodes nFInstances
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNFInstancesById(id,nFInstances,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create link by ID", notes = "Create operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(id,odeId,inkId,link,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(id,odeId,inkId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create links by ID", notes = "Create operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeLinksLinksById(id,odeId,links,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(id,odeId,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create node by ID", notes = "Create operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "nodebody object" ,required=true) Node node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeNodeById(id,odeId,node,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create addresses by ID", notes = "Create operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(id,odeId,ortId,addresses,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create l3 by ID", notes = "Create operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,l3,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create control by ID", notes = "Create operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(id,odeId,ortId,control,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(id,odeId,ortId,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create port by ID", notes = "Create operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortPortById(id,odeId,ortId,port,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create sap_data by ID", notes = "Create operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(id,odeId,ortId,sapData,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create ports by ID", notes = "Create operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodePortsPortsById(id,odeId,ports,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(id,odeId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create node by ID", notes = "Create operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "nodebody object" ,required=true) InfraNode node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeNodeById(id,node,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create addresses by ID", notes = "Create operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortAddressesAddressesById(id,ortId,addresses,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create l3 by ID", notes = "Create operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortAddressesL3L3ById(id,ortId,_3Id,l3,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create control by ID", notes = "Create operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortControlControlById(id,ortId,control,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create metadata by ID", notes = "Create operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortMetadataMetadataById(id,ortId,key,metadata,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create port by ID", notes = "Create operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortPortById(id,ortId,port,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(id,ortId,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create sap_data by ID", notes = "Create operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortSapDataSapDataById(id,ortId,sapData,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create ports by ID", notes = "Create operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodePortsPortsById(id,ports,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/node/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create resources by ID", notes = "Create operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodeResourcesResourcesById(id,resources,securityContext);
    }
    @POST
    @Path("/virtualizer/nodes/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create nodes by ID", notes = "Create operation of resource: nodes", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response createVirtualizerNodesNodesById(@ApiParam(value = "nodesbody object" ,required=true) NodesSchema nodes
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createVirtualizerNodesNodesById(nodes,securityContext);
    }
    @DELETE
    @Path("/virtualizer/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete virtualizer by ID", notes = "Delete operation of resource: virtualizer", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerById(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerById(securityContext);
    }
    @DELETE
    @Path("/virtualizer/links/link/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete link by ID", notes = "Delete operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerLinksLinkLinkById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/links/link/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerLinksLinkResourcesResourcesById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete links by ID", notes = "Delete operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerLinksLinksById(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerLinksLinksById(securityContext);
    }
    @DELETE
    @Path("/virtualizer/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerMetadataMetadataById(@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerMetadataMetadataById(key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete capabilities by ID", notes = "Delete operation of resource: capabilities", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesCapabilitiesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesCapabilitiesById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete link by ID", notes = "Delete operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(id,odeId,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(id,odeId,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete links by ID", notes = "Delete operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(id,odeId,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete node by ID", notes = "Delete operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete addresses by ID", notes = "Delete operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete l3 by ID", notes = "Delete operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete control by ID", notes = "Delete operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(id,odeId,ortId,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete port by ID", notes = "Delete operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete sap_data by ID", notes = "Delete operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete ports by ID", notes = "Delete operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete supported_NFs by ID", notes = "Delete operation of resource: supported_NFs", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete flowentry by ID", notes = "Delete operation of resource: flowentry", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeFlowtableFlowentryFlowentryById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeFlowtableFlowentryFlowentryById(id,lowentryId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(id,lowentryId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/flowtable/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete flowtable by ID", notes = "Delete operation of resource: flowtable", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeFlowtableFlowtableById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeFlowtableFlowtableById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete link by ID", notes = "Delete operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeLinksLinkLinkById(id,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeLinksLinkResourcesResourcesById(id,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete links by ID", notes = "Delete operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeLinksLinksById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeMetadataMetadataById(id,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete NF_instances by ID", notes = "Delete operation of resource: NF_instances", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNFInstancesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNFInstancesById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete link by ID", notes = "Delete operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(id,odeId,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(id,odeId,inkId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete links by ID", notes = "Delete operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeLinksLinksById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(id,odeId,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete node by ID", notes = "Delete operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeNodeById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete addresses by ID", notes = "Delete operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete l3 by ID", notes = "Delete operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete control by ID", notes = "Delete operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(id,odeId,ortId,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete port by ID", notes = "Delete operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortPortById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete sap_data by ID", notes = "Delete operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(id,odeId,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete ports by ID", notes = "Delete operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodePortsPortsById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(id,odeId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete node by ID", notes = "Delete operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeNodeById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete addresses by ID", notes = "Delete operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortAddressesAddressesById(id,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete l3 by ID", notes = "Delete operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortAddressesL3L3ById(id,ortId,_3Id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete control by ID", notes = "Delete operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortControlControlById(id,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete metadata by ID", notes = "Delete operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortMetadataMetadataById(id,ortId,key,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete port by ID", notes = "Delete operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortPortById(id,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(id,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete sap_data by ID", notes = "Delete operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortSapDataSapDataById(id,ortId,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete ports by ID", notes = "Delete operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodePortsPortsById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/node/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete resources by ID", notes = "Delete operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodeResourcesResourcesById(id,securityContext);
    }
    @DELETE
    @Path("/virtualizer/nodes/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete nodes by ID", notes = "Delete operation of resource: nodes", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response deleteVirtualizerNodesNodesById(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteVirtualizerNodesNodesById(securityContext);
    }
    @GET
    @Path("/virtualizer/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve virtualizer", notes = "Retrieve operation of resource: virtualizer", response = VirtualizerSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = VirtualizerSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = VirtualizerSchema.class) })
    public Response retrieveVirtualizer(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizer(securityContext);
    }
    @GET
    @Path("/virtualizer/links/link/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link by ID", notes = "Retrieve operation of resource: link", response = Link.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Link.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Link.class) })
    public Response retrieveVirtualizerLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerLinksLinkLinkById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/links/link/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerLinksLinkResourcesResourcesById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve links", notes = "Retrieve operation of resource: links", response = LinksSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinksSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinksSchema.class) })
    public Response retrieveVirtualizerLinksLinks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerLinksLinks(securityContext);
    }
    @GET
    @Path("/virtualizer/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerMetadataMetadataById(@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerMetadataMetadataById(key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve capabilities by ID", notes = "Retrieve operation of resource: capabilities", response = CapabilitiesSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = CapabilitiesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = CapabilitiesSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesCapabilitiesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesCapabilitiesById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link by ID", notes = "Retrieve operation of resource: link", response = Link.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Link.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Link.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(id,odeId,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(id,odeId,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve links by ID", notes = "Retrieve operation of resource: links", response = LinksSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinksSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinksSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(id,odeId,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node by ID", notes = "Retrieve operation of resource: node", response = Node.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve addresses by ID", notes = "Retrieve operation of resource: addresses", response = AddressesSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AddressesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AddressesSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve l3 by ID", notes = "Retrieve operation of resource: l3", response = L3Address.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = L3Address.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = L3Address.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve control by ID", notes = "Retrieve operation of resource: control", response = ControlSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ControlSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ControlSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(id,odeId,ortId,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve port by ID", notes = "Retrieve operation of resource: port", response = Port.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Port.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Port.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve sap_data by ID", notes = "Retrieve operation of resource: sap_data", response = SapDataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SapDataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SapDataSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve ports by ID", notes = "Retrieve operation of resource: ports", response = PortsSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = PortsSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = PortsSchema.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = SoftwareResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SoftwareResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SoftwareResource.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve supported_NFs by ID", notes = "Retrieve operation of resource: supported_NFs", response = Nodes.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Nodes.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Nodes.class) })
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve flowentry by ID", notes = "Retrieve operation of resource: flowentry", response = Flowentry.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Flowentry.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Flowentry.class) })
    public Response retrieveVirtualizerNodesNodeFlowtableFlowentryFlowentryById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeFlowtableFlowentryFlowentryById(id,lowentryId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(id,lowentryId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/flowtable/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve flowtable by ID", notes = "Retrieve operation of resource: flowtable", response = FlowtableSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = FlowtableSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = FlowtableSchema.class) })
    public Response retrieveVirtualizerNodesNodeFlowtableFlowtableById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeFlowtableFlowtableById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link by ID", notes = "Retrieve operation of resource: link", response = Link.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Link.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Link.class) })
    public Response retrieveVirtualizerNodesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeLinksLinkLinkById(id,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeLinksLinkResourcesResourcesById(id,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve links by ID", notes = "Retrieve operation of resource: links", response = LinksSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinksSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinksSchema.class) })
    public Response retrieveVirtualizerNodesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeLinksLinksById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeMetadataMetadataById(id,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve NF_instances by ID", notes = "Retrieve operation of resource: NF_instances", response = Nodes.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Nodes.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Nodes.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNFInstancesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNFInstancesById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve link by ID", notes = "Retrieve operation of resource: link", response = Link.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Link.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Link.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(id,odeId,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(id,odeId,inkId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve links by ID", notes = "Retrieve operation of resource: links", response = LinksSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinksSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinksSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinksById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(id,odeId,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node by ID", notes = "Retrieve operation of resource: node", response = Node.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Node.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Node.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeNodeById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve addresses by ID", notes = "Retrieve operation of resource: addresses", response = AddressesSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AddressesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AddressesSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve l3 by ID", notes = "Retrieve operation of resource: l3", response = L3Address.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = L3Address.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = L3Address.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve control by ID", notes = "Retrieve operation of resource: control", response = ControlSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ControlSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ControlSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(id,odeId,ortId,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve port by ID", notes = "Retrieve operation of resource: port", response = Port.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Port.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Port.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortPortById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve sap_data by ID", notes = "Retrieve operation of resource: sap_data", response = SapDataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SapDataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SapDataSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(id,odeId,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve ports by ID", notes = "Retrieve operation of resource: ports", response = PortsSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = PortsSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = PortsSchema.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodePortsPortsById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = SoftwareResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SoftwareResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SoftwareResource.class) })
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(id,odeId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve node by ID", notes = "Retrieve operation of resource: node", response = InfraNode.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = InfraNode.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = InfraNode.class) })
    public Response retrieveVirtualizerNodesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeNodeById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve addresses by ID", notes = "Retrieve operation of resource: addresses", response = AddressesSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = AddressesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = AddressesSchema.class) })
    public Response retrieveVirtualizerNodesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortAddressesAddressesById(id,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve l3 by ID", notes = "Retrieve operation of resource: l3", response = L3Address.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = L3Address.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = L3Address.class) })
    public Response retrieveVirtualizerNodesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortAddressesL3L3ById(id,ortId,_3Id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve control by ID", notes = "Retrieve operation of resource: control", response = ControlSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = ControlSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = ControlSchema.class) })
    public Response retrieveVirtualizerNodesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortControlControlById(id,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve metadata by ID", notes = "Retrieve operation of resource: metadata", response = MetadataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MetadataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = MetadataSchema.class) })
    public Response retrieveVirtualizerNodesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortMetadataMetadataById(id,ortId,key,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve port by ID", notes = "Retrieve operation of resource: port", response = Port.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Port.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = Port.class) })
    public Response retrieveVirtualizerNodesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortPortById(id,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = LinkResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = LinkResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = LinkResource.class) })
    public Response retrieveVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(id,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve sap_data by ID", notes = "Retrieve operation of resource: sap_data", response = SapDataSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SapDataSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SapDataSchema.class) })
    public Response retrieveVirtualizerNodesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortSapDataSapDataById(id,ortId,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve ports by ID", notes = "Retrieve operation of resource: ports", response = PortsSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = PortsSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = PortsSchema.class) })
    public Response retrieveVirtualizerNodesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodePortsPortsById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/node/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve resources by ID", notes = "Retrieve operation of resource: resources", response = SoftwareResource.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = SoftwareResource.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = SoftwareResource.class) })
    public Response retrieveVirtualizerNodesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodeResourcesResourcesById(id,securityContext);
    }
    @GET
    @Path("/virtualizer/nodes/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve nodes", notes = "Retrieve operation of resource: nodes", response = NodesSchema.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = NodesSchema.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = NodesSchema.class) })
    public Response retrieveVirtualizerNodesNodes(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrieveVirtualizerNodesNodes(securityContext);
    }
    @PUT
    @Path("/virtualizer/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update virtualizer by ID", notes = "Update operation of resource: virtualizer", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerById(@ApiParam(value = "virtualizerbody object" ,required=true) VirtualizerSchema virtualizer
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerById(virtualizer,securityContext);
    }
    @PUT
    @Path("/virtualizer/links/link/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update link by ID", notes = "Update operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerLinksLinkLinkById(id,link,securityContext);
    }
    @PUT
    @Path("/virtualizer/links/link/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerLinksLinkResourcesResourcesById(id,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update links by ID", notes = "Update operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerLinksLinksById(@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerLinksLinksById(links,securityContext);
    }
    @PUT
    @Path("/virtualizer/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerMetadataMetadataById(@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerMetadataMetadataById(key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update capabilities by ID", notes = "Update operation of resource: capabilities", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesCapabilitiesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "capabilitiesbody object" ,required=true) CapabilitiesSchema capabilities
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesCapabilitiesById(id,capabilities,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update link by ID", notes = "Update operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(id,odeId,inkId,link,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(id,odeId,inkId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update links by ID", notes = "Update operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(id,odeId,links,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(id,odeId,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update node by ID", notes = "Update operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "nodebody object" ,required=true) Node node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(id,odeId,node,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update addresses by ID", notes = "Update operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(id,odeId,ortId,addresses,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update l3 by ID", notes = "Update operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,l3,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update control by ID", notes = "Update operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(id,odeId,ortId,control,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(id,odeId,ortId,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update port by ID", notes = "Update operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(id,odeId,ortId,port,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update sap_data by ID", notes = "Update operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(id,odeId,ortId,sapData,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update ports by ID", notes = "Update operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(id,odeId,ports,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(id,odeId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/capabilities/supported_NFs/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update supported_NFs by ID", notes = "Update operation of resource: supported_NFs", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "supported_NFsbody object" ,required=true) Nodes supportedNFs
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(id,supportedNFs,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update flowentry by ID", notes = "Update operation of resource: flowentry", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeFlowtableFlowentryFlowentryById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@ApiParam(value = "flowentrybody object" ,required=true) Flowentry flowentry
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeFlowtableFlowentryFlowentryById(id,lowentryId,flowentry,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/flowtable/flowentry/{lowentry_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of lowentry_id",required=true) @PathParam("lowentry_id") String lowentryId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(id,lowentryId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/flowtable/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update flowtable by ID", notes = "Update operation of resource: flowtable", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeFlowtableFlowtableById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "flowtablebody object" ,required=true) FlowtableSchema flowtable
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeFlowtableFlowtableById(id,flowtable,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update link by ID", notes = "Update operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeLinksLinkLinkById(id,inkId,link,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeLinksLinkResourcesResourcesById(id,inkId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update links by ID", notes = "Update operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeLinksLinksById(id,links,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeMetadataMetadataById(id,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update NF_instances by ID", notes = "Update operation of resource: NF_instances", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNFInstancesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "NF_instancesbody object" ,required=true) Nodes nFInstances
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNFInstancesById(id,nFInstances,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update link by ID", notes = "Update operation of resource: link", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "linkbody object" ,required=true) Link link
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(id,odeId,inkId,link,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/link/{ink_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ink_id",required=true) @PathParam("ink_id") String inkId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(id,odeId,inkId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/links/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update links by ID", notes = "Update operation of resource: links", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinksById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "linksbody object" ,required=true) LinksSchema links
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeLinksLinksById(id,odeId,links,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(id,odeId,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update node by ID", notes = "Update operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "nodebody object" ,required=true) Node node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeNodeById(id,odeId,node,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update addresses by ID", notes = "Update operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(id,odeId,ortId,addresses,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update l3 by ID", notes = "Update operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(id,odeId,ortId,_3Id,l3,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update control by ID", notes = "Update operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(id,odeId,ortId,control,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(id,odeId,ortId,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update port by ID", notes = "Update operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortPortById(id,odeId,ortId,port,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(id,odeId,ortId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update sap_data by ID", notes = "Update operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(id,odeId,ortId,sapData,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update ports by ID", notes = "Update operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodePortsPortsById(id,odeId,ports,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/NF_instances/node/{ode_id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ode_id",required=true) @PathParam("ode_id") String odeId
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(id,odeId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update node by ID", notes = "Update operation of resource: node", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeNodeById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "nodebody object" ,required=true) InfraNode node
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeNodeById(id,node,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update addresses by ID", notes = "Update operation of resource: addresses", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortAddressesAddressesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "addressesbody object" ,required=true) AddressesSchema addresses
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortAddressesAddressesById(id,ortId,addresses,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/addresses/l3/{3_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update l3 by ID", notes = "Update operation of resource: l3", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortAddressesL3L3ById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of 3_id",required=true) @PathParam("3_id") String _3Id
,@ApiParam(value = "l3body object" ,required=true) L3Address l3
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortAddressesL3L3ById(id,ortId,_3Id,l3,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/control/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update control by ID", notes = "Update operation of resource: control", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortControlControlById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "controlbody object" ,required=true) ControlSchema control
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortControlControlById(id,ortId,control,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/metadata/{key}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update metadata by ID", notes = "Update operation of resource: metadata", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortMetadataMetadataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "ID of key",required=true) @PathParam("key") String key
,@ApiParam(value = "metadatabody object" ,required=true) MetadataSchema metadata
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortMetadataMetadataById(id,ortId,key,metadata,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update port by ID", notes = "Update operation of resource: port", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortPortById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "portbody object" ,required=true) Port port
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortPortById(id,ortId,port,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "resourcesbody object" ,required=true) LinkResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(id,ortId,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/port/{ort_id}/sap_data/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update sap_data by ID", notes = "Update operation of resource: sap_data", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortSapDataSapDataById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "ID of ort_id",required=true) @PathParam("ort_id") String ortId
,@ApiParam(value = "sap_databody object" ,required=true) SapDataSchema sapData
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortSapDataSapDataById(id,ortId,sapData,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/ports/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update ports by ID", notes = "Update operation of resource: ports", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodePortsPortsById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "portsbody object" ,required=true) PortsSchema ports
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodePortsPortsById(id,ports,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/node/{id}/resources/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update resources by ID", notes = "Update operation of resource: resources", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodeResourcesResourcesById(@ApiParam(value = "ID of id",required=true) @PathParam("id") String id
,@ApiParam(value = "resourcesbody object" ,required=true) SoftwareResource resources
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodeResourcesResourcesById(id,resources,securityContext);
    }
    @PUT
    @Path("/virtualizer/nodes/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update nodes by ID", notes = "Update operation of resource: nodes", response = void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Internal Error", response = void.class) })
    public Response updateVirtualizerNodesNodesById(@ApiParam(value = "nodesbody object" ,required=true) NodesSchema nodes
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateVirtualizerNodesNodesById(nodes,securityContext);
    }
}
