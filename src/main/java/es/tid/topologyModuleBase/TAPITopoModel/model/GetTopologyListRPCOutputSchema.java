package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.Topology;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * GetTopologyListRPCOutputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class GetTopologyListRPCOutputSchema   {
  private List<Topology> topology = new ArrayList<Topology>();

  public GetTopologyListRPCOutputSchema topology(List<Topology> topology) {
    this.topology = topology;
    return this;
  }

  public GetTopologyListRPCOutputSchema addTopologyItem(Topology topologyItem) {
    this.topology.add(topologyItem);
    return this;
  }

   /**
   * Get topology
   * @return topology
  **/
  @ApiModelProperty(value = "")
  public List<Topology> getTopology() {
    return topology;
  }

  public void setTopology(List<Topology> topology) {
    this.topology = topology;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTopologyListRPCOutputSchema getTopologyListRPCOutputSchema = (GetTopologyListRPCOutputSchema) o;
    return Objects.equals(this.topology, getTopologyListRPCOutputSchema.topology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topology);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTopologyListRPCOutputSchema {\n");
    
    sb.append("    topology: ").append(toIndentedString(topology)).append("\n");
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

