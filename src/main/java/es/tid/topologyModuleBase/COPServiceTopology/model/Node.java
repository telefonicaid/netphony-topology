package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.tid.topologyModuleBase.COPServiceTopology.model.EdgeEnd;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class Node  {
  
  private String domain = null;
  private String nodetype = null;
  private String name = null;
  private List<EdgeEnd> edgeEnd = new ArrayList<EdgeEnd>();
  private String nodeId = null;
  private List<String> underlayAbstractTopology = new ArrayList<String>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }
  public void setDomain(String domain) {
    this.domain = domain;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("nodetype")
  public String getNodetype() {
    return nodetype;
  }
  public void setNodetype(String nodetype) {
    this.nodetype = nodetype;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("edgeEnd")
  public List<EdgeEnd> getEdgeEnd() {
    return edgeEnd;
  }
  public void setEdgeEnd(List<EdgeEnd> edgeEnd) {
    this.edgeEnd = edgeEnd;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("nodeId")
  public String getNodeId() {
    return nodeId;
  }
  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("underlayAbstractTopology")
  public List<String> getUnderlayAbstractTopology() {
    return underlayAbstractTopology;
  }
  public void setUnderlayAbstractTopology(List<String> underlayAbstractTopology) {
    this.underlayAbstractTopology = underlayAbstractTopology;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Node {\n");
    
    sb.append("  domain: ").append(domain).append("\n");
    sb.append("  nodetype: ").append(nodetype).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  edgeEnd: ").append(edgeEnd).append("\n");
    sb.append("  nodeId: ").append(nodeId).append("\n");
    sb.append("  underlayAbstractTopology: ").append(underlayAbstractTopology).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
