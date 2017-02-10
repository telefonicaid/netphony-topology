package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.AdminStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.NodeEdgePoint;
import es.tid.topologyModuleBase.TAPITopoModel.model.ResourceSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCapacityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCostPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferIntegrityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferTimingPac;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). 
 **/

/**
 * The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). 
 */
@ApiModel(description = "The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class Node   {
  private List<NodeEdgePoint> ownedNodeEdgePoint = new ArrayList<NodeEdgePoint>();

  private TransferCostPac transferCost = null;

  private TransferIntegrityPac transferIntegrity = null;

  private AdminStatePac state = null;

  private String encapTopology = null;

  private TransferCapacityPac transferCapacity = null;

  /**
   * Gets or Sets layerProtocolName
   */
  public enum LayerProtocolNameEnum {
    OCH("och"),
    
    ODU("odu"),
    
    ETH("eth"),
    
    MPLS_TP("mpls-tp");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private List<LayerProtocolNameEnum> layerProtocolName = new ArrayList<LayerProtocolNameEnum>();

  private List<String> aggregatedNodeEdgePoint = new ArrayList<String>();

  private TransferTimingPac transferTiming = null;

  public Node ownedNodeEdgePoint(List<NodeEdgePoint> ownedNodeEdgePoint) {
    this.ownedNodeEdgePoint = ownedNodeEdgePoint;
    return this;
  }

  public Node addOwnedNodeEdgePointItem(NodeEdgePoint ownedNodeEdgePointItem) {
    this.ownedNodeEdgePoint.add(ownedNodeEdgePointItem);
    return this;
  }

   /**
   * Get ownedNodeEdgePoint
   * @return ownedNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<NodeEdgePoint> getOwnedNodeEdgePoint() {
    return ownedNodeEdgePoint;
  }

  public void setOwnedNodeEdgePoint(List<NodeEdgePoint> ownedNodeEdgePoint) {
    this.ownedNodeEdgePoint = ownedNodeEdgePoint;
  }

  public Node transferCost(TransferCostPac transferCost) {
    this.transferCost = transferCost;
    return this;
  }

   /**
   * Get transferCost
   * @return transferCost
  **/
  @ApiModelProperty(value = "")
  public TransferCostPac getTransferCost() {
    return transferCost;
  }

  public void setTransferCost(TransferCostPac transferCost) {
    this.transferCost = transferCost;
  }

  public Node transferIntegrity(TransferIntegrityPac transferIntegrity) {
    this.transferIntegrity = transferIntegrity;
    return this;
  }

   /**
   * Get transferIntegrity
   * @return transferIntegrity
  **/
  @ApiModelProperty(value = "")
  public TransferIntegrityPac getTransferIntegrity() {
    return transferIntegrity;
  }

  public void setTransferIntegrity(TransferIntegrityPac transferIntegrity) {
    this.transferIntegrity = transferIntegrity;
  }

  public Node state(AdminStatePac state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public AdminStatePac getState() {
    return state;
  }

  public void setState(AdminStatePac state) {
    this.state = state;
  }

  public Node encapTopology(String encapTopology) {
    this.encapTopology = encapTopology;
    return this;
  }

   /**
   * Get encapTopology
   * @return encapTopology
  **/
  @ApiModelProperty(value = "")
  public String getEncapTopology() {
    return encapTopology;
  }

  public void setEncapTopology(String encapTopology) {
    this.encapTopology = encapTopology;
  }

  public Node transferCapacity(TransferCapacityPac transferCapacity) {
    this.transferCapacity = transferCapacity;
    return this;
  }

   /**
   * Get transferCapacity
   * @return transferCapacity
  **/
  @ApiModelProperty(value = "")
  public TransferCapacityPac getTransferCapacity() {
    return transferCapacity;
  }

  public void setTransferCapacity(TransferCapacityPac transferCapacity) {
    this.transferCapacity = transferCapacity;
  }

  public Node layerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

  public Node addLayerProtocolNameItem(LayerProtocolNameEnum layerProtocolNameItem) {
    this.layerProtocolName.add(layerProtocolNameItem);
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "")
  public List<LayerProtocolNameEnum> getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public Node aggregatedNodeEdgePoint(List<String> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
    return this;
  }

  public Node addAggregatedNodeEdgePointItem(String aggregatedNodeEdgePointItem) {
    this.aggregatedNodeEdgePoint.add(aggregatedNodeEdgePointItem);
    return this;
  }

   /**
   * Get aggregatedNodeEdgePoint
   * @return aggregatedNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<String> getAggregatedNodeEdgePoint() {
    return aggregatedNodeEdgePoint;
  }

  public void setAggregatedNodeEdgePoint(List<String> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
  }

  public Node transferTiming(TransferTimingPac transferTiming) {
    this.transferTiming = transferTiming;
    return this;
  }

   /**
   * Get transferTiming
   * @return transferTiming
  **/
  @ApiModelProperty(value = "")
  public TransferTimingPac getTransferTiming() {
    return transferTiming;
  }

  public void setTransferTiming(TransferTimingPac transferTiming) {
    this.transferTiming = transferTiming;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(this.ownedNodeEdgePoint, node.ownedNodeEdgePoint) &&
        Objects.equals(this.transferCost, node.transferCost) &&
        Objects.equals(this.transferIntegrity, node.transferIntegrity) &&
        Objects.equals(this.state, node.state) &&
        Objects.equals(this.encapTopology, node.encapTopology) &&
        Objects.equals(this.transferCapacity, node.transferCapacity) &&
        Objects.equals(this.layerProtocolName, node.layerProtocolName) &&
        Objects.equals(this.aggregatedNodeEdgePoint, node.aggregatedNodeEdgePoint) &&
        Objects.equals(this.transferTiming, node.transferTiming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownedNodeEdgePoint, transferCost, transferIntegrity, state, encapTopology, transferCapacity, layerProtocolName, aggregatedNodeEdgePoint, transferTiming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Node {\n");
    
    sb.append("    ownedNodeEdgePoint: ").append(toIndentedString(ownedNodeEdgePoint)).append("\n");
    sb.append("    transferCost: ").append(toIndentedString(transferCost)).append("\n");
    sb.append("    transferIntegrity: ").append(toIndentedString(transferIntegrity)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    encapTopology: ").append(toIndentedString(encapTopology)).append("\n");
    sb.append("    transferCapacity: ").append(toIndentedString(transferCapacity)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    aggregatedNodeEdgePoint: ").append(toIndentedString(aggregatedNodeEdgePoint)).append("\n");
    sb.append("    transferTiming: ").append(toIndentedString(transferTiming)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

