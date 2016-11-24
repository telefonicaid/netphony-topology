package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.tid.topologyModuleBase.COPServiceTopology.model.Bitmap;
import es.tid.topologyModuleBase.COPServiceTopology.model.DwdmChannel;
import es.tid.topologyModuleBase.COPServiceTopology.model.Edge;
import es.tid.topologyModuleBase.COPServiceTopology.model.EdgeEnd;
import es.tid.topologyModuleBase.COPServiceTopology.model.Node;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class DwdmEdge extends Edge {
  
  private String unreservBw = null;
  private Bitmap bitmap = null;
  private List<DwdmChannel> channels = new ArrayList<DwdmChannel>();
  private EdgeEnd localIfid = null;
  private EdgeEnd remoteIfid = null;
  private String edgeId = null;
  private Node source = null;
  private String metric = null;
  private String name = null;
  private Node target = null;
  private String maxResvBw = null;
  private String switchingCap = null;

  
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
  @JsonProperty("bitmap")
  public Bitmap getBitmap() {
    return bitmap;
  }
  public void setBitmap(Bitmap bitmap) {
    this.bitmap = bitmap;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("channels")
  public List<DwdmChannel> getChannels() {
    return channels;
  }
  public void setChannels(List<DwdmChannel> channels) {
    this.channels = channels;
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
  @JsonProperty("target")
  public Node getTarget() {
    return target;
  }
  public void setTarget(Node target) {
    this.target = target;
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
  @JsonProperty("switchingCap")
  public String getSwitchingCap() {
    return switchingCap;
  }
  public void setSwitchingCap(String switchingCap) {
    this.switchingCap = switchingCap;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DwdmEdge {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  unreservBw: ").append(unreservBw).append("\n");
    sb.append("  bitmap: ").append(bitmap).append("\n");
    sb.append("  channels: ").append(channels).append("\n");
    sb.append("  localIfid: ").append(localIfid).append("\n");
    sb.append("  remoteIfid: ").append(remoteIfid).append("\n");
    sb.append("  edgeId: ").append(edgeId).append("\n");
    sb.append("  source: ").append(source).append("\n");
    sb.append("  metric: ").append(metric).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  target: ").append(target).append("\n");
    sb.append("  maxResvBw: ").append(maxResvBw).append("\n");
    sb.append("  switchingCap: ").append(switchingCap).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
