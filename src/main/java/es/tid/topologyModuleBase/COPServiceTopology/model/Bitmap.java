package es.tid.topologyModuleBase.COPServiceTopology.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class Bitmap  {
  
  private List<Integer> arrayBits = new ArrayList<Integer>();
  private Integer numChannels = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("arrayBits")
  public List<Integer> getArrayBits() {
    return arrayBits;
  }
  public void setArrayBits(List<Integer> arrayBits) {
    this.arrayBits = arrayBits;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("numChannels")
  public Integer getNumChannels() {
    return numChannels;
  }
  public void setNumChannels(Integer numChannels) {
    this.numChannels = numChannels;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bitmap {\n");
    
    sb.append("  arrayBits: ").append(arrayBits).append("\n");
    sb.append("  numChannels: ").append(numChannels).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
