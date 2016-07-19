package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Contains the information necessary to reference a network,\nfor example an underlay network.
 **/

@ApiModel(description = "Contains the information necessary to reference a network,\nfor example an underlay network.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class NetworkRef   {
  
  private String networkRef = null;

  /**
   * Used to reference a network, for example an underlay\nnetwork.
   **/
  public NetworkRef networkRef(String networkRef) {
    this.networkRef = networkRef;
    return this;
  }

  
  @ApiModelProperty(value = "Used to reference a network, for example an underlay\nnetwork.")
  @JsonProperty("networkRef")
  public String getNetworkRef() {
    return networkRef;
  }
  public void setNetworkRef(String networkRef) {
    this.networkRef = networkRef;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkRef networkRef = (NetworkRef) o;
    return Objects.equals(networkRef, networkRef.networkRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkRef {\n");
    
    sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
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

