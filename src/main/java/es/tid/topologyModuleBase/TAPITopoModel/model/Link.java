package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.AdminStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.ExtensionsSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocolTransitionPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.LinkPort;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ResourceSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskParameterPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCapacityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferCostPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferIntegrityPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.TransferTimingPac;
import es.tid.topologyModuleBase.TAPITopoModel.model.ValidationPac;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The Link object class models effective adjacency between two or more ForwardingDomains (FD). 
 **/

/**
 * The Link object class models effective adjacency between two or more ForwardingDomains (FD). 
 */
@ApiModel(description = "The Link object class models effective adjacency between two or more ForwardingDomains (FD). ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class Link   {
  /**
   * The directionality of the Link.  Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL).  Is not present in more complex cases.
   */
  public enum DirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    UNIDIRECTIONAL("UNIDIRECTIONAL"),
    
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

    private String value;

    DirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private DirectionEnum direction = null;

  /**
   * none
   */
  public enum LayerProtocolNameEnum {
    OCH("OCH"),
    
    ODU("ODU"),
    
    ETH("ETH"),
    
    MPLS_TP("MPLS_TP");

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

  private ValidationPac validation = null;

  private LayerProtocolTransitionPac lpTransition = null;

  private AdminStatePac state = null;

  private List<LinkPort> linkPort = new ArrayList<LinkPort>();

  private List<String> node = new ArrayList<String>();

  private TransferCapacityPac transferCapacity = null;

  private TransferCostPac transferCost = null;

  private RiskParameterPac riskParameter = null;

  private TransferTimingPac transferTiming = null;

  private TransferIntegrityPac transferIntegrity = null;

  public Link direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * The directionality of the Link.  Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL).  Is not present in more complex cases.
   * @return direction
  **/
  @ApiModelProperty(value = "The directionality of the Link.  Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL).  Is not present in more complex cases.")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public Link layerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

  public Link addLayerProtocolNameItem(LayerProtocolNameEnum layerProtocolNameItem) {
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

  public Link validation(ValidationPac validation) {
    this.validation = validation;
    return this;
  }

   /**
   * none
   * @return validation
  **/
  @ApiModelProperty(value = "none")
  public ValidationPac getValidation() {
    return validation;
  }

  public void setValidation(ValidationPac validation) {
    this.validation = validation;
  }

  public Link lpTransition(LayerProtocolTransitionPac lpTransition) {
    this.lpTransition = lpTransition;
    return this;
  }

   /**
   * none
   * @return lpTransition
  **/
  @ApiModelProperty(value = "none")
  public LayerProtocolTransitionPac getLpTransition() {
    return lpTransition;
  }

  public void setLpTransition(LayerProtocolTransitionPac lpTransition) {
    this.lpTransition = lpTransition;
  }

  public Link state(AdminStatePac state) {
    this.state = state;
    return this;
  }

   /**
   * none
   * @return state
  **/
  @ApiModelProperty(value = "none")
  public AdminStatePac getState() {
    return state;
  }

  public void setState(AdminStatePac state) {
    this.state = state;
  }

  public Link linkPort(List<LinkPort> linkPort) {
    this.linkPort = linkPort;
    return this;
  }

  public Link addLinkPortItem(LinkPort linkPortItem) {
    this.linkPort.add(linkPortItem);
    return this;
  }

   /**
   * none
   * @return linkPort
  **/
  @ApiModelProperty(value = "none")
  public List<LinkPort> getLinkPort() {
    return linkPort;
  }

  public void setLinkPort(List<LinkPort> linkPort) {
    this.linkPort = linkPort;
  }

  public Link node(List<String> node) {
    this.node = node;
    return this;
  }

  public Link addNodeItem(String nodeItem) {
    this.node.add(nodeItem);
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @ApiModelProperty(value = "")
  public List<String> getNode() {
    return node;
  }

  public void setNode(List<String> node) {
    this.node = node;
  }

  public Link transferCapacity(TransferCapacityPac transferCapacity) {
    this.transferCapacity = transferCapacity;
    return this;
  }

   /**
   * none
   * @return transferCapacity
  **/
  @ApiModelProperty(value = "none")
  public TransferCapacityPac getTransferCapacity() {
    return transferCapacity;
  }

  public void setTransferCapacity(TransferCapacityPac transferCapacity) {
    this.transferCapacity = transferCapacity;
  }

  public Link transferCost(TransferCostPac transferCost) {
    this.transferCost = transferCost;
    return this;
  }

   /**
   * none
   * @return transferCost
  **/
  @ApiModelProperty(value = "none")
  public TransferCostPac getTransferCost() {
    return transferCost;
  }

  public void setTransferCost(TransferCostPac transferCost) {
    this.transferCost = transferCost;
  }

  public Link riskParameter(RiskParameterPac riskParameter) {
    this.riskParameter = riskParameter;
    return this;
  }

   /**
   * none
   * @return riskParameter
  **/
  @ApiModelProperty(value = "none")
  public RiskParameterPac getRiskParameter() {
    return riskParameter;
  }

  public void setRiskParameter(RiskParameterPac riskParameter) {
    this.riskParameter = riskParameter;
  }

  public Link transferTiming(TransferTimingPac transferTiming) {
    this.transferTiming = transferTiming;
    return this;
  }

   /**
   * none
   * @return transferTiming
  **/
  @ApiModelProperty(value = "none")
  public TransferTimingPac getTransferTiming() {
    return transferTiming;
  }

  public void setTransferTiming(TransferTimingPac transferTiming) {
    this.transferTiming = transferTiming;
  }

  public Link transferIntegrity(TransferIntegrityPac transferIntegrity) {
    this.transferIntegrity = transferIntegrity;
    return this;
  }

   /**
   * none
   * @return transferIntegrity
  **/
  @ApiModelProperty(value = "none")
  public TransferIntegrityPac getTransferIntegrity() {
    return transferIntegrity;
  }

  public void setTransferIntegrity(TransferIntegrityPac transferIntegrity) {
    this.transferIntegrity = transferIntegrity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link) o;
    return Objects.equals(this.direction, link.direction) &&
        Objects.equals(this.layerProtocolName, link.layerProtocolName) &&
        Objects.equals(this.validation, link.validation) &&
        Objects.equals(this.lpTransition, link.lpTransition) &&
        Objects.equals(this.state, link.state) &&
        Objects.equals(this.linkPort, link.linkPort) &&
        Objects.equals(this.node, link.node) &&
        Objects.equals(this.transferCapacity, link.transferCapacity) &&
        Objects.equals(this.transferCost, link.transferCost) &&
        Objects.equals(this.riskParameter, link.riskParameter) &&
        Objects.equals(this.transferTiming, link.transferTiming) &&
        Objects.equals(this.transferIntegrity, link.transferIntegrity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, layerProtocolName, validation, lpTransition, state, linkPort, node, transferCapacity, transferCost, riskParameter, transferTiming, transferIntegrity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    validation: ").append(toIndentedString(validation)).append("\n");
    sb.append("    lpTransition: ").append(toIndentedString(lpTransition)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    linkPort: ").append(toIndentedString(linkPort)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    transferCapacity: ").append(toIndentedString(transferCapacity)).append("\n");
    sb.append("    transferCost: ").append(toIndentedString(transferCost)).append("\n");
    sb.append("    riskParameter: ").append(toIndentedString(riskParameter)).append("\n");
    sb.append("    transferTiming: ").append(toIndentedString(transferTiming)).append("\n");
    sb.append("    transferIntegrity: ").append(toIndentedString(transferIntegrity)).append("\n");
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

