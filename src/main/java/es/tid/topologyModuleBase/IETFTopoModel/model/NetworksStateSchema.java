package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Serves as top-level container for a list of state information\nfor networks
 **/

@ApiModel(description = "Serves as top-level container for a list of state information\nfor networks")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-17T12:18:44.706+02:00")
public class NetworksStateSchema   {
  
  private String stateId = null;

  /**
   * Identifies a node uniquely within the containing\nnetwork.
   **/
  public NetworksStateSchema stateId(String stateId) {
    this.stateId = stateId;
    return this;
  }

  
  @ApiModelProperty(value = "Identifies a node uniquely within the containing\nnetwork.")
  @JsonProperty("stateId")
  public String getStateId() {
    return stateId;
  }
  public void setStateId(String stateId) {
    this.stateId = stateId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworksStateSchema networksStateSchema = (NetworksStateSchema) o;
    return Objects.equals(stateId, networksStateSchema.stateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworksStateSchema {\n");
    
    sb.append("    stateId: ").append(toIndentedString(stateId)).append("\n");
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

