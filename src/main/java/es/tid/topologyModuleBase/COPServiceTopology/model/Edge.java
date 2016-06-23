package es.tid.topologyModuleBase.COPServiceTopology.model;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.tid.topologyModuleBase.COPServiceTopology.model.EdgeEnd;
import es.tid.topologyModuleBase.COPServiceTopology.model.Node;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class Edge  {
  
  private String name = null;
  private String edgeId = null;
  public enum EdgeTypeEnum {
     dwdm_edge,  eth_edge, 
  };
  private EdgeTypeEnum edgeType = null;
  private String switchingCap = null;
  private String metric = null;
  private String maxResvBw = null;
  private Node source = null;
  private EdgeEnd localIfid = null;
  private EdgeEnd remoteIfid = null;
  private String unreservBw = null;
  private Node target = null;

  
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
  @JsonProperty("edgeId")
  public String getEdgeId() {
    return edgeId;
  }
  public void setEdgeId(String edgeId) {
    this.edgeId = edgeId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("edgeType")
  public EdgeTypeEnum getEdgeType() {
    return edgeType;
  }
  public void setEdgeType(EdgeTypeEnum edgeType) {
    this.edgeType = edgeType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("switchingCap")
  public String getSwitchingCap() {
    return switchingCap;
  }
  public void setSwitchingCap(String switchingCap) {
    this.switchingCap = switchingCap;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("metric")
  public String getMetric() {
    return metric;
  }
  public void setMetric(String metric) {
    this.metric = metric;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("maxResvBw")
  public String getMaxResvBw() {
    return maxResvBw;
  }
  public void setMaxResvBw(String maxResvBw) {
    this.maxResvBw = maxResvBw;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("source")
  public Node getSource() {
    return source;
  }
  public void setSource(Node source) {
    this.source = source;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("localIfid")
  public EdgeEnd getLocalIfid() {
    return localIfid;
  }
  public void setLocalIfid(EdgeEnd localIfid) {
    this.localIfid = localIfid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("remoteIfid")
  public EdgeEnd getRemoteIfid() {
    return remoteIfid;
  }
  public void setRemoteIfid(EdgeEnd remoteIfid) {
    this.remoteIfid = remoteIfid;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("unreservBw")
  public String getUnreservBw() {
    return unreservBw;
  }
  public void setUnreservBw(String unreservBw) {
    this.unreservBw = unreservBw;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("target")
  public Node getTarget() {
    return target;
  }
  public void setTarget(Node target) {
    this.target = target;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Edge {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  edgeId: ").append(edgeId).append("\n");
    sb.append("  edgeType: ").append(edgeType).append("\n");
    sb.append("  switchingCap: ").append(switchingCap).append("\n");
    sb.append("  metric: ").append(metric).append("\n");
    sb.append("  maxResvBw: ").append(maxResvBw).append("\n");
    sb.append("  source: ").append(source).append("\n");
    sb.append("  localIfid: ").append(localIfid).append("\n");
    sb.append("  remoteIfid: ").append(remoteIfid).append("\n");
    sb.append("  unreservBw: ").append(unreservBw).append("\n");
    sb.append("  target: ").append(target).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
