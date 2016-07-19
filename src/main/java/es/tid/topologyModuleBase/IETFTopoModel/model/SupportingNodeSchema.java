package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class SupportingNodeSchema   {
  
  private String nodeRef = null;
  private String networkRef = null;

  /**
   * References the underlay node itself.
   **/
  public SupportingNodeSchema nodeRef(String nodeRef) {
    this.nodeRef = nodeRef;
    return this;
  }

  
  @ApiModelProperty(value = "References the underlay node itself.")
  @JsonProperty("nodeRef")
  public String getNodeRef() {
    return nodeRef;
  }
  public void setNodeRef(String nodeRef) {
    this.nodeRef = nodeRef;
  }

  /**
   * References the underlay network that the\nunderlay node is part of.
   **/
  public SupportingNodeSchema networkRef(String networkRef) {
    this.networkRef = networkRef;
    return this;
  }

  
  @ApiModelProperty(value = "References the underlay network that the\nunderlay node is part of.")
  @JsonProperty("networkRef")
  public String getNetworkRef() {
    return networkRef;
  }
  public void setNetworkRef(String networkRef) {
    this.networkRef = networkRef;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupportingNodeSchema supportingNodeSchema = (SupportingNodeSchema) o;
    return Objects.equals(nodeRef, supportingNodeSchema.nodeRef) &&
        Objects.equals(networkRef, supportingNodeSchema.networkRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeRef, networkRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SupportingNodeSchema {\n");
    
    sb.append("    nodeRef: ").append(toIndentedString(nodeRef)).append("\n");
    sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
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

