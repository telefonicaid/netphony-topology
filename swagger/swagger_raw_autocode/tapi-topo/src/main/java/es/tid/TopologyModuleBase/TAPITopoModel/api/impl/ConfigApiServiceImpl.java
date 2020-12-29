package es.tid.topologyModuleBase.TAPITopoModel.api.impl;

import es.tid.topologyModuleBase.TAPITopoModel.api.*;
import es.tid.topologyModuleBase.TAPITopoModel.model.*;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class ConfigApiServiceImpl extends ConfigApiService {
    @Override
    public Response createContextById(ContextSchema context, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createContextLabelLabelById(String valueName, NameAndValue label, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createContextNameNameById(String valueName, NameAndValue name, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteContextById(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteContextLabelLabelById(String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteContextNameNameById(String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContext(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextLabelLabel(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextLabelLabelById(String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNameName(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextNameNameById(String valueName, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextServiceEndPointLabelLabel(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointLabelLabelById(String uuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointLayerProtocolLayerProtocol(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointLayerProtocolLayerProtocolById(String uuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointLayerProtocolNameName(String uuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointLayerProtocolNameNameById(String uuid, String localId, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointNameName(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointNameNameById(String uuid, String valueName, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointServiceEndPoint(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointServiceEndPointById(String uuid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextServiceEndPointStateState(String uuid, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyLinkTransferCostCostCharacteristicCostCharacteristicById(String uuid, String linkUuid, String costNameCostValueCostAlgorithm, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyLinkTransferTimingLatencyCharacteristicLatencyCharacteristicById(String uuid, String linkUuid, String trafficPropertyNameTrafficPropertyQueingLatency, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyLinkValidationValidationMechanismValidationMechanismById(String uuid, String linkUuid, String validationMechanismLayerProtocolAdjacencyValidatedValidationRobustness, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameName(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String localId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response retrieveContextTopologyNodeOwnedNodeEdgePointLayerProtocolNameNameById(String uuid, String nodeUuid, String ownedNodeEdgePointUuid, String localId, String valueName, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyNodeTransferCostCostCharacteristicCostCharacteristicById(String uuid, String nodeUuid, String costNameCostValueCostAlgorithm, SecurityContext securityContext) throws NotFoundException {
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
    public Response retrieveContextTopologyNodeTransferTimingLatencyCharacteristicLatencyCharacteristicById(String uuid, String nodeUuid, String trafficPropertyNameTrafficPropertyQueingLatency, SecurityContext securityContext) throws NotFoundException {
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
    @Override
    public Response updateContextById(ContextSchema context, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateContextLabelLabelById(String valueName, NameAndValue label, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateContextNameNameById(String valueName, NameAndValue name, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
