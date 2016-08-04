package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Port;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class PortsSchema   {
  
  private List<Port> port = new ArrayList<Port>();

  /**
   **/
  public PortsSchema port(List<Port> port) {
    this.port = port;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("port")
  public List<Port> getPort() {
    return port;
  }
  public void setPort(List<Port> port) {
    this.port = port;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PortsSchema portsSchema = (PortsSchema) o;
    return Objects.equals(port, portsSchema.port);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PortsSchema {\n");
    
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

