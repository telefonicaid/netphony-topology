package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.InfraNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class NodesSchema   {
  
  private List<InfraNode> node = new ArrayList<InfraNode>();

  /**
   **/
  public NodesSchema node(List<InfraNode> node) {
    this.node = node;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("node")
  public List<InfraNode> getNode() {
    return node;
  }
  public void setNode(List<InfraNode> node) {
    this.node = node;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodesSchema nodesSchema = (NodesSchema) o;
    return Objects.equals(node, nodesSchema.node);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodesSchema {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
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

