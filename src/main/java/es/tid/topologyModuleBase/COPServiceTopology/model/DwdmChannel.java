package es.tid.topologyModuleBase.COPServiceTopology.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class DwdmChannel  {
  
  private Integer state = null;
  private Integer g694Id = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("state")
  public Integer getState() {
    return state;
  }
  public void setState(Integer state) {
    this.state = state;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("g694Id")
  public Integer getG694Id() {
    return g694Id;
  }
  public void setG694Id(Integer g694Id) {
    this.g694Id = g694Id;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DwdmChannel {\n");
    
    sb.append("  state: ").append(state).append("\n");
    sb.append("  g694Id: ").append(g694Id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
