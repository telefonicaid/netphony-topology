package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * GetNodeEdgePointDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class GetNodeEdgePointDetailsRPCInputSchema   {
  private String epIdOrName = null;

  private String topologyIdOrName = null;

  private String nodeIdOrName = null;

  public GetNodeEdgePointDetailsRPCInputSchema epIdOrName(String epIdOrName) {
    this.epIdOrName = epIdOrName;
    return this;
  }

   /**
   * none
   * @return epIdOrName
  **/
  @ApiModelProperty(value = "none")
  public String getEpIdOrName() {
    return epIdOrName;
  }

  public void setEpIdOrName(String epIdOrName) {
    this.epIdOrName = epIdOrName;
  }

  public GetNodeEdgePointDetailsRPCInputSchema topologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
    return this;
  }

   /**
   * none
   * @return topologyIdOrName
  **/
  @ApiModelProperty(value = "none")
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
   * none
   * @return nodeIdOrName
  **/
  @ApiModelProperty(value = "none")
  public String getNodeIdOrName() {
    return nodeIdOrName;
  }

  public void setNodeIdOrName(String nodeIdOrName) {
    this.nodeIdOrName = nodeIdOrName;
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
    return Objects.equals(this.epIdOrName, getNodeEdgePointDetailsRPCInputSchema.epIdOrName) &&
        Objects.equals(this.topologyIdOrName, getNodeEdgePointDetailsRPCInputSchema.topologyIdOrName) &&
        Objects.equals(this.nodeIdOrName, getNodeEdgePointDetailsRPCInputSchema.nodeIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epIdOrName, topologyIdOrName, nodeIdOrName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNodeEdgePointDetailsRPCInputSchema {\n");
    
    sb.append("    epIdOrName: ").append(toIndentedString(epIdOrName)).append("\n");
    sb.append("    topologyIdOrName: ").append(toIndentedString(topologyIdOrName)).append("\n");
    sb.append("    nodeIdOrName: ").append(toIndentedString(nodeIdOrName)).append("\n");
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

