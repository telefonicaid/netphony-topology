package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworkRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Contains the information necessary to reference a node.
 **/

@ApiModel(description = "Contains the information necessary to reference a node.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class NodeRef extends NetworkRef  {
  
  private String networkRef = null;
  private String nodeRef = null;

  /**
   * Used to reference a network, for example an underlay\nnetwork.
   **/
  public NodeRef networkRef(String networkRef) {
    this.networkRef = networkRef;
    return this;
  }

  
  @ApiModelProperty(value = "Used to reference a network, for example an underlay\nnetwork.")
  @JsonProperty("networkRef")
  public String getNetworkRef() {
    return networkRef;
  }
  public void setNetworkRef(String networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * Used to reference a node.\nNodes are identified relative to the network they are\ncontained in.
   **/
  public NodeRef nodeRef(String nodeRef) {
    this.nodeRef = nodeRef;
    return this;
  }

  
  @ApiModelProperty(value = "Used to reference a node.\nNodes are identified relative to the network they are\ncontained in.")
  @JsonProperty("nodeRef")
  public String getNodeRef() {
    return nodeRef;
  }
  public void setNodeRef(String nodeRef) {
    this.nodeRef = nodeRef;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeRef nodeRef = (NodeRef) o;
    return Objects.equals(networkRef, nodeRef.networkRef) &&
        Objects.equals(nodeRef, nodeRef.nodeRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkRef, nodeRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
    sb.append("    nodeRef: ").append(toIndentedString(nodeRef)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

