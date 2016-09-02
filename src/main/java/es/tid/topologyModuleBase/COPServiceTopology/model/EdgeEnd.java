package es.tid.topologyModuleBase.COPServiceTopology.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class EdgeEnd  {
  
  public enum SwitchingCapEnum {
     lsc,  psc, 
  };
  private SwitchingCapEnum switchingCap = null;
  private String edgeEndId = null;
  private String name = null;
  private String peerNodeId = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("switchingCap")
  public SwitchingCapEnum getSwitchingCap() {
    return switchingCap;
  }
  public void setSwitchingCap(SwitchingCapEnum switchingCap) {
    this.switchingCap = switchingCap;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("edgeEndId")
  public String getEdgeEndId() {
    return edgeEndId;
  }
  public void setEdgeEndId(String edgeEndId) {
    this.edgeEndId = edgeEndId;
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
  @JsonProperty("peerNodeId")
  public String getPeerNodeId() {
    return peerNodeId;
  }
  public void setPeerNodeId(String peerNodeId) {
    this.peerNodeId = peerNodeId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class EdgeEnd {\n");
    
    sb.append("  switchingCap: ").append(switchingCap).append("\n");
    sb.append("  edgeEndId: ").append(edgeEndId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  peerNodeId: ").append(peerNodeId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
