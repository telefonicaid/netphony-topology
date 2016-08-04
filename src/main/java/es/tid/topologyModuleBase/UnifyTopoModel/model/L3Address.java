package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.IdName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class L3Address   {
  
  private String requested = null;
  private String client = null;
  private String configure = null;
  private String provided = null;

  /**
   * To request port configuration, options: {'public', 'ip/mask'}, where public means the request of public IP address and private ip/mask a given address/mask configuration
   **/
  public L3Address requested(String requested) {
    this.requested = requested;
    return this;
  }

  
  @ApiModelProperty(value = "To request port configuration, options: {'public', 'ip/mask'}, where public means the request of public IP address and private ip/mask a given address/mask configuration")
  @JsonProperty("requested")
  public String getRequested() {
    return requested;
  }
  public void setRequested(String requested) {
    this.requested = requested;
  }

  /**
   * Configuration service support at the client: {'dhcp-client', 'pre-configured'}; if not present it is left to the infrastructure to deal with it.
   **/
  public L3Address client(String client) {
    this.client = client;
    return this;
  }

  
  @ApiModelProperty(value = "Configuration service support at the client: {'dhcp-client', 'pre-configured'}; if not present it is left to the infrastructure to deal with it.")
  @JsonProperty("client")
  public String getClient() {
    return client;
  }
  public void setClient(String client) {
    this.client = client;
  }

  /**
   * True: this is a configuration request; False: this is fyi
   **/
  public L3Address configure(String configure) {
    this.configure = configure;
    return this;
  }

  
  @ApiModelProperty(value = "True: this is a configuration request; False: this is fyi")
  @JsonProperty("configure")
  public String getConfigure() {
    return configure;
  }
  public void setConfigure(String configure) {
    this.configure = configure;
  }

  /**
   * The provided L3 configuration in response to the requested field.
   **/
  public L3Address provided(String provided) {
    this.provided = provided;
    return this;
  }

  
  @ApiModelProperty(value = "The provided L3 configuration in response to the requested field.")
  @JsonProperty("provided")
  public String getProvided() {
    return provided;
  }
  public void setProvided(String provided) {
    this.provided = provided;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    L3Address l3Address = (L3Address) o;
    return Objects.equals(requested, l3Address.requested) &&
        Objects.equals(client, l3Address.client) &&
        Objects.equals(configure, l3Address.configure) &&
        Objects.equals(provided, l3Address.provided);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requested, client, configure, provided);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class L3Address {\n");
    
    sb.append("    requested: ").append(toIndentedString(requested)).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    configure: ").append(toIndentedString(configure)).append("\n");
    sb.append("    provided: ").append(toIndentedString(provided)).append("\n");
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

