package es.tid.topologyModuleBase.TAPITopoModel.api.impl;

import es.tid.topologyModuleBase.TAPITopoModel.api.*;
import es.tid.topologyModuleBase.TAPITopoModel.model.*;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class ConfigApiServiceImpl extends ConfigApiService {
    @Override
    public Response retrieveContextNwTopologyServiceExtensionsExtensions(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceExtensionsExtensionsById(String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceLabelLabel(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceLabelLabelById(String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceNameName(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceNameNameById(String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNwTopologyServiceNwTopologyService(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyExtensionsExtensions(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyExtensionsExtensionsById(String uuid, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLabelLabel(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLabelLabelById(String uuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkExtensionsExtensions(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkExtensionsExtensionsById(String uuid, String linkUuid, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLabelLabel(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLabelLabelById(String uuid, String linkUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLink(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLinkById(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLinkPortExtensionsExtensions(String uuid, String linkUuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLinkPortExtensionsExtensionsById(String uuid, String linkUuid, String localId, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLinkPortLinkPort(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLinkPortLinkPortById(String uuid, String linkUuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkLpTransitionLpTransition(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkNameName(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkNameNameById(String uuid, String linkUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristic(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkRiskParameterRiskCharacteristicRiskCharacteristicById(String uuid, String linkUuid, String riskCharacteristicName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkRiskParameterRiskParameter(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkStateState(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCapacityAvailableCapacityAvailableCapacity(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(String uuid, String linkUuid, String totalSize, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCapacityTransferCapacity(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristic(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicCostName(String uuid, String linkUuid, String costName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferCostTransferCost(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferIntegrityTransferIntegrity(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristic(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(String uuid, String linkUuid, String trafficPropertyName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkTransferTimingTransferTiming(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkValidationValidation(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanism(String uuid, String linkUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismValidationMechanism(String uuid, String linkUuid, String validationMechanism, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNameName(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNameNameById(String uuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeExtensionsExtensions(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeExtensionsExtensionsById(String uuid, String nodeUuid, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeLabelLabel(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeLabelLabelById(String uuid, String nodeUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeNameName(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeNameNameById(String uuid, String nodeUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeNode(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeNodeById(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensions(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointExtensionsExtensionsById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabel(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLabelLabelById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensions(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolExtensionsExtensionsById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String localId, String extensionsSpecification, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocol(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolLayerProtocolById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameName(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointStateState(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeStateState(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCapacityAvailableCapacityAvailableCapacity(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserView(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCapacityCapacityAssignedToUserViewCapacityAssignedToUserViewById(String uuid, String nodeUuid, String totalSize, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCapacityTotalPotentialCapacityTotalPotentialCapacity(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCapacityTransferCapacity(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristic(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicCostName(String uuid, String nodeUuid, String costName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferCostTransferCost(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferIntegrityTransferIntegrity(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristic(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicTrafficPropertyName(String uuid, String nodeUuid, String trafficPropertyName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeTransferTimingTransferTiming(String uuid, String nodeUuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyTopology(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyTopologyById(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
