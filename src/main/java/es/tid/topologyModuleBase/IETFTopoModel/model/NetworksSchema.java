package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworksSchemaNetwork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Serves as top-level container for a list of networks.
 **/

@ApiModel(description = "Serves as top-level container for a list of networks.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class NetworksSchema   {
  
  private List<NetworksSchemaNetwork> network = new ArrayList<NetworksSchemaNetwork>();

  /**
   * Describes a network.\nA network typically contains an inventory of nodes,\ntopological information (augmented through\nnetwork-topology model), as well as layering\ninformation.
   **/
  public NetworksSchema network(List<NetworksSchemaNetwork> network) {
    this.network = network;
    return this;
  }

  
  @ApiModelProperty(value = "Describes a network.\nA network typically contains an inventory of nodes,\ntopological information (augmented through\nnetwork-topology model), as well as layering\ninformation.")
  @JsonProperty("network")
  public List<NetworksSchemaNetwork> getNetwork() {
    return network;
  }
  public void setNetwork(List<NetworksSchemaNetwork> network) {
    this.network = network;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworksSchema networksSchema = (NetworksSchema) o;
    return Objects.equals(network, networksSchema.network);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworksSchema {\n");
    
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
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

