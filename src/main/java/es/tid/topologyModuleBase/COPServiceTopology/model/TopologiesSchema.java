package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.tid.topologyModuleBase.COPServiceTopology.model.Topology;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class TopologiesSchema  {
  
  private List<Topology> topology = new ArrayList<Topology>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("topology")
  public List<Topology> getTopology() {
    return topology;
  }
  public void setTopology(List<Topology> topology) {
    this.topology = topology;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopologiesSchema {\n");
    
    sb.append("  topology: ").append(topology).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
