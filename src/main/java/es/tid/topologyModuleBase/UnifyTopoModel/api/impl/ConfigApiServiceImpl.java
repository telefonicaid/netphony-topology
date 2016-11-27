package es.tid.topologyModuleBase.UnifyTopoModel.api.impl;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.TEDB;
import es.tid.topologyModuleBase.UnifyTopoModel.api.*;
import es.tid.topologyModuleBase.UnifyTopoModel.model.*;

import es.tid.topologyModuleBase.UnifyTopoModel.model.VirtualizerSchema;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.writer.TopologyServerUnify;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.tid.topologyModuleBase.UnifyTopoModel.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class ConfigApiServiceImpl extends ConfigApiService {
    @Override
    public Response createVirtualizerById(VirtualizerSchema virtualizer, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerLinksLinkLinkById(String id, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerLinksLinkResourcesResourcesById(String id, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerLinksLinksById(LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerMetadataMetadataById(String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesCapabilitiesById(String id, CapabilitiesSchema capabilities, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(String id, String odeId, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(String id, String odeId, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(String id, String odeId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(String id, String odeId, Node node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(String id, String odeId, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(String id, String odeId, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(String id, String odeId, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(String id, String odeId, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(String id, Nodes supportedNFs, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeFlowtableFlowentryFlowentryById(String id, String lowentryId, Flowentry flowentry, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(String id, String lowentryId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeFlowtableFlowtableById(String id, FlowtableSchema flowtable, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeLinksLinkLinkById(String id, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeLinksLinkResourcesResourcesById(String id, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeLinksLinksById(String id, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeMetadataMetadataById(String id, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNFInstancesById(String id, Nodes nFInstances, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(String id, String odeId, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeLinksLinksById(String id, String odeId, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(String id, String odeId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeNodeById(String id, String odeId, Node node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(String id, String odeId, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortPortById(String id, String odeId, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodePortsPortsById(String id, String odeId, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(String id, String odeId, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeNodeById(String id, InfraNode node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortAddressesAddressesById(String id, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortAddressesL3L3ById(String id, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortControlControlById(String id, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortMetadataMetadataById(String id, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortPortById(String id, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(String id, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortSapDataSapDataById(String id, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodePortsPortsById(String id, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodeResourcesResourcesById(String id, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createVirtualizerNodesNodesById(NodesSchema nodes, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerById(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerLinksLinkLinkById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerLinksLinkResourcesResourcesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerLinksLinksById(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerMetadataMetadataById(String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesCapabilitiesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(String id, String odeId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeFlowtableFlowentryFlowentryById(String id, String lowentryId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(String id, String lowentryId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeFlowtableFlowtableById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeLinksLinkLinkById(String id, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeLinksLinkResourcesResourcesById(String id, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeLinksLinksById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeMetadataMetadataById(String id, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNFInstancesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeLinksLinksById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(String id, String odeId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeNodeById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortPortById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodePortsPortsById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeNodeById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortAddressesAddressesById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortAddressesL3L3ById(String id, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortControlControlById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortMetadataMetadataById(String id, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortPortById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortSapDataSapDataById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodePortsPortsById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodeResourcesResourcesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteVirtualizerNodesNodesById(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizer(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
    	
    	//Unify Topology Exporter
    	//curl http://localhost:8088/restconf/data/virtualizer
    	
//		TopologiesDataBase ted = TopologyServerUnify.getActualTed();
//		TopologiesSchema tSchema = new TopologiesSchema();
//		List<Topology> tops = new ArrayList<Topology>();
//	  
//		for(Map.Entry<String, TEDB>entry : ted.getTeds().entrySet() ){
//			System.out.println("Topologia servida con id: "+entry.getKey());
//			if (entry.getValue() instanceof DomainTEDB) {
//				tops.add( TranslateModel.translateTopology(entry.getKey(),(DomainTEDB)entry.getValue()));
//			}else {
//				tops.add( TranslateModel.translateTopology(entry.getKey(),(MultiDomainTEDB)entry.getValue()));
//	
//			}
//		}
//		tSchema.setTopology(tops);
//		return Response.ok().entity(tSchema).build();
    	
    	TopologiesDataBase ted = TopologyServerUnify.getActualTed();
    	VirtualizerSchema tSchema = new VirtualizerSchema();
    	Nodes nodes = new Nodes();
    	List<Node> nodelist = new ArrayList<Node>();
    	
    	
    	for(Map.Entry<String, TEDB>entry : ted.getTeds().entrySet() ){
    		System.out.println("Serving topology with id: "+entry.getKey());
    		if (entry.getValue() instanceof DomainTEDB) {
    			nodelist.add( TranslateModel.translateTopology(entry.getKey(),(DomainTEDB)entry.getValue()));
    			
    		}else if(entry.getValue() instanceof MultiDomainTEDB){
    			//Interdomain links
    			tSchema.setLinks(TranslateModel.translateInterDomainLinks(entry.getKey(),(MultiDomainTEDB)entry.getValue()));
    			
    		}else{// unrecognized TED
    			System.out.println("Type of TED not implemented");
    			
    		}
    	}
    	
    	nodes.setNode(nodelist);
    	tSchema.setNodes(nodes);
    	
    	return Response.ok().entity(tSchema).build();
    	
        //return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magico-unify!")).build();
    }
    @Override
    public Response retrieveVirtualizerLinksLinkLinkById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerLinksLinkResourcesResourcesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerLinksLinks(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerMetadataMetadataById(String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesCapabilitiesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(String id, String odeId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeFlowtableFlowentryFlowentryById(String id, String lowentryId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(String id, String lowentryId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeFlowtableFlowtableById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeLinksLinkLinkById(String id, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeLinksLinkResourcesResourcesById(String id, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeLinksLinksById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeMetadataMetadataById(String id, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNFInstancesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeLinksLinksById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(String id, String odeId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeNodeById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortPortById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodePortsPortsById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(String id, String odeId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeNodeById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortAddressesAddressesById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortAddressesL3L3ById(String id, String ortId, String _3Id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortControlControlById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortMetadataMetadataById(String id, String ortId, String key, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortPortById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortSapDataSapDataById(String id, String ortId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodePortsPortsById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodeResourcesResourcesById(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveVirtualizerNodesNodes(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerById(VirtualizerSchema virtualizer, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerLinksLinkLinkById(String id, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerLinksLinkResourcesResourcesById(String id, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerLinksLinksById(LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerMetadataMetadataById(String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesCapabilitiesById(String id, CapabilitiesSchema capabilities, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkLinkById(String id, String odeId, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeLinksLinksById(String id, String odeId, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeMetadataMetadataById(String id, String odeId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeNodeById(String id, String odeId, Node node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortControlControlById(String id, String odeId, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortPortById(String id, String odeId, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodePortsPortsById(String id, String odeId, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsNodeResourcesResourcesById(String id, String odeId, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeCapabilitiesSupportedNFsSupportedNFsById(String id, Nodes supportedNFs, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeFlowtableFlowentryFlowentryById(String id, String lowentryId, Flowentry flowentry, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeFlowtableFlowentryResourcesResourcesById(String id, String lowentryId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeFlowtableFlowtableById(String id, FlowtableSchema flowtable, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeLinksLinkLinkById(String id, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeLinksLinkResourcesResourcesById(String id, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeLinksLinksById(String id, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeMetadataMetadataById(String id, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNFInstancesById(String id, Nodes nFInstances, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinkLinkById(String id, String odeId, String inkId, Link link, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinkResourcesResourcesById(String id, String odeId, String inkId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeLinksLinksById(String id, String odeId, LinksSchema links, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeMetadataMetadataById(String id, String odeId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeNodeById(String id, String odeId, Node node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesAddressesById(String id, String odeId, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortAddressesL3L3ById(String id, String odeId, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortControlControlById(String id, String odeId, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortMetadataMetadataById(String id, String odeId, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortPortById(String id, String odeId, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataResourcesResourcesById(String id, String odeId, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortSapDataSapDataById(String id, String odeId, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodePortsPortsById(String id, String odeId, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNFInstancesNodeResourcesResourcesById(String id, String odeId, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeNodeById(String id, InfraNode node, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortAddressesAddressesById(String id, String ortId, AddressesSchema addresses, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortAddressesL3L3ById(String id, String ortId, String _3Id, L3Address l3, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortControlControlById(String id, String ortId, ControlSchema control, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortMetadataMetadataById(String id, String ortId, String key, MetadataSchema metadata, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortPortById(String id, String ortId, Port port, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortSapDataResourcesResourcesById(String id, String ortId, LinkResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortSapDataSapDataById(String id, String ortId, SapDataSchema sapData, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodePortsPortsById(String id, PortsSchema ports, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodeResourcesResourcesById(String id, SoftwareResource resources, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateVirtualizerNodesNodesById(NodesSchema nodes, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
