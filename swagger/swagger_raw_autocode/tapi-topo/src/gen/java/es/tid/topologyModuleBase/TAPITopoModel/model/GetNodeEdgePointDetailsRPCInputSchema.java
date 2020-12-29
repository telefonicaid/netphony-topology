package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * GetNodeEdgePointDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class GetNodeEdgePointDetailsRPCInputSchema   {
  private String topologyIdOrName = null;

  private String nodeIdOrName = null;

  private String epIdOrName = null;

  public GetNodeEdgePointDetailsRPCInputSchema topologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
    return this;
  }

   /**
   * Get topologyIdOrName
   * @return topologyIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getTopologyIdOrName() {
    return topologyIdOrName;
  }

  public void setTopologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
  }

  public GetNodeEdgePointDetailsRPCInputSchema nodeIdOrName(String nodeIdOrName) {
    this.nodeIdOrName = nodeIdOrName;
    return this;
  }

   /**
   * Get nodeIdOrName
   * @return nodeIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getNodeIdOrName() {
    return nodeIdOrName;
  }

  public void setNodeIdOrName(String nodeIdOrName) {
    this.nodeIdOrName = nodeIdOrName;
  }

  public GetNodeEdgePointDetailsRPCInputSchema epIdOrName(String epIdOrName) {
    this.epIdOrName = epIdOrName;
    return this;
  }

   /**
   * Get epIdOrName
   * @return epIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getEpIdOrName() {
    return epIdOrName;
  }

  public void setEpIdOrName(String epIdOrName) {
    this.epIdOrName = epIdOrName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetailsRPCInputSchema = (GetNodeEdgePointDetailsRPCInputSchema) o;
    return Objects.equals(this.topologyIdOrName, getNodeEdgePointDetailsRPCInputSchema.topologyIdOrName) &&
        Objects.equals(this.nodeIdOrName, getNodeEdgePointDetailsRPCInputSchema.nodeIdOrName) &&
        Objects.equals(this.epIdOrName, getNodeEdgePointDetailsRPCInputSchema.epIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyIdOrName, nodeIdOrName, epIdOrName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNodeEdgePointDetailsRPCInputSchema {\n");
    
    sb.append("    topologyIdOrName: ").append(toIndentedString(topologyIdOrName)).append("\n");
    sb.append("    nodeIdOrName: ").append(toIndentedString(nodeIdOrName)).append("\n");
    sb.append("    epIdOrName: ").append(toIndentedString(epIdOrName)).append("\n");
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

