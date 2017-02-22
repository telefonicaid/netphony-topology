package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Relevant for a Link that is formed by abstracting one or more LTPs (in a stack) to focus on the flow and deemphasize the protocol transformation.  This abstraction is relevant when considering multi-layer routing.  The layer protocols of the LTP and the order of their application to the signal is still relevant and need to be accounted for. This is derived from the LTP spec details. This Pac provides the relevant abstractions of the LTPs and provides the necessary association to the LTPs involved. Links that included details in this Pac are often referred to as Transitional Links.
 **/

/**
 * Relevant for a Link that is formed by abstracting one or more LTPs (in a stack) to focus on the flow and deemphasize the protocol transformation.  This abstraction is relevant when considering multi-layer routing.  The layer protocols of the LTP and the order of their application to the signal is still relevant and need to be accounted for. This is derived from the LTP spec details. This Pac provides the relevant abstractions of the LTPs and provides the necessary association to the LTPs involved. Links that included details in this Pac are often referred to as Transitional Links.
 */
@ApiModel(description = "Relevant for a Link that is formed by abstracting one or more LTPs (in a stack) to focus on the flow and deemphasize the protocol transformation.  This abstraction is relevant when considering multi-layer routing.  The layer protocols of the LTP and the order of their application to the signal is still relevant and need to be accounted for. This is derived from the LTP spec details. This Pac provides the relevant abstractions of the LTPs and provides the necessary association to the LTPs involved. Links that included details in this Pac are often referred to as Transitional Links.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class LayerProtocolTransitionPac   {
  private List<String> nodeEdgePoint = new ArrayList<String>();

  private List<String> transitionedLayerProtocolName = new ArrayList<String>();

  public LayerProtocolTransitionPac nodeEdgePoint(List<String> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

  public LayerProtocolTransitionPac addNodeEdgePointItem(String nodeEdgePointItem) {
    this.nodeEdgePoint.add(nodeEdgePointItem);
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<String> getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(List<String> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }

  public LayerProtocolTransitionPac transitionedLayerProtocolName(List<String> transitionedLayerProtocolName) {
    this.transitionedLayerProtocolName = transitionedLayerProtocolName;
    return this;
  }

  public LayerProtocolTransitionPac addTransitionedLayerProtocolNameItem(String transitionedLayerProtocolNameItem) {
    this.transitionedLayerProtocolName.add(transitionedLayerProtocolNameItem);
    return this;
  }

   /**
   * Get transitionedLayerProtocolName
   * @return transitionedLayerProtocolName
  **/
  @ApiModelProperty(value = "")
  public List<String> getTransitionedLayerProtocolName() {
    return transitionedLayerProtocolName;
  }

  public void setTransitionedLayerProtocolName(List<String> transitionedLayerProtocolName) {
    this.transitionedLayerProtocolName = transitionedLayerProtocolName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LayerProtocolTransitionPac layerProtocolTransitionPac = (LayerProtocolTransitionPac) o;
    return Objects.equals(this.nodeEdgePoint, layerProtocolTransitionPac.nodeEdgePoint) &&
        Objects.equals(this.transitionedLayerProtocolName, layerProtocolTransitionPac.transitionedLayerProtocolName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeEdgePoint, transitionedLayerProtocolName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LayerProtocolTransitionPac {\n");
    
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
    sb.append("    transitionedLayerProtocolName: ").append(toIndentedString(transitionedLayerProtocolName)).append("\n");
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

