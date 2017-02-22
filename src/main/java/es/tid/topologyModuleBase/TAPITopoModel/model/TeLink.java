package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.LocalClass;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class TeLink   {
  private List<String> node = new ArrayList<String>();

  private List<String> nodeEdgePoint = new ArrayList<String>();

  public TeLink node(List<String> node) {
    this.node = node;
    return this;
  }

  public TeLink addNodeItem(String nodeItem) {
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

  public TeLink nodeEdgePoint(List<String> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

  public TeLink addNodeEdgePointItem(String nodeEdgePointItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeLink teLink = (TeLink) o;
    return Objects.equals(this.node, teLink.node) &&
        Objects.equals(this.nodeEdgePoint, teLink.nodeEdgePoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, nodeEdgePoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeLink {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
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

