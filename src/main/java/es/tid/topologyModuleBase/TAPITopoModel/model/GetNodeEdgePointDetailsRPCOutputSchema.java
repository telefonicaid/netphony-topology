package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.NodeEdgePoint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * GetNodeEdgePointDetailsRPCOutputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class GetNodeEdgePointDetailsRPCOutputSchema   {
  private NodeEdgePoint nodeEdgePoint = null;

  public GetNodeEdgePointDetailsRPCOutputSchema nodeEdgePoint(NodeEdgePoint nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public NodeEdgePoint getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(NodeEdgePoint nodeEdgePoint) {
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
    GetNodeEdgePointDetailsRPCOutputSchema getNodeEdgePointDetailsRPCOutputSchema = (GetNodeEdgePointDetailsRPCOutputSchema) o;
    return Objects.equals(this.nodeEdgePoint, getNodeEdgePointDetailsRPCOutputSchema.nodeEdgePoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeEdgePoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNodeEdgePointDetailsRPCOutputSchema {\n");
    
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

