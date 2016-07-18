package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-17T12:23:33.037+02:00")
public class NetworkSchema extends NetworkRef  {
  
  private String networkRef = null;
  private Boolean serverProvided = null;

  /**
   * Used to reference a network, for example an underlay\nnetwork.
   **/
  public NetworkSchema networkRef(String networkRef) {
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

  /**
   * Indicates whether the information concerning this\nparticular network is populated by the server\n(server-provided true, the general case for network\ninformation discovered from the server),\nor whether it is configured by a client\n(server-provided true, possible e.g. for\nservice overlays managed through a controller).
   **/
  public NetworkSchema serverProvided(Boolean serverProvided) {
    this.serverProvided = serverProvided;
    return this;
  }

  
  @ApiModelProperty(value = "Indicates whether the information concerning this\nparticular network is populated by the server\n(server-provided true, the general case for network\ninformation discovered from the server),\nor whether it is configured by a client\n(server-provided true, possible e.g. for\nservice overlays managed through a controller).")
  @JsonProperty("serverProvided")
  public Boolean getServerProvided() {
    return serverProvided;
  }
  public void setServerProvided(Boolean serverProvided) {
    this.serverProvided = serverProvided;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkSchema networkSchema = (NetworkSchema) o;
    return Objects.equals(networkRef, networkSchema.networkRef) &&
        Objects.equals(serverProvided, networkSchema.serverProvided);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkRef, serverProvided);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkSchema {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
    sb.append("    serverProvided: ").append(toIndentedString(serverProvided)).append("\n");
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

