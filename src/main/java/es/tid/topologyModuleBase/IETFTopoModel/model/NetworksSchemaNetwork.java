package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-17T12:23:33.037+02:00")
public class NetworksSchemaNetwork   {
  
  private List<NetworksSchemaNode> node = new ArrayList<NetworksSchemaNode>();
  private String networkId = null;
  private List<NetworksSchemaSupportingNetwork> supportingNetwork = new ArrayList<NetworksSchemaSupportingNetwork>();

  /**
   * The inventory of nodes of this network.
   **/
  public NetworksSchemaNetwork node(List<NetworksSchemaNode> node) {
    this.node = node;
    return this;
  }

  
  @ApiModelProperty(value = "The inventory of nodes of this network.")
  @JsonProperty("node")
  public List<NetworksSchemaNode> getNode() {
    return node;
  }
  public void setNode(List<NetworksSchemaNode> node) {
    this.node = node;
  }

  /**
   * Identifies a network.
   **/
  public NetworksSchemaNetwork networkId(String networkId) {
    this.networkId = networkId;
    return this;
  }

  
  @ApiModelProperty(value = "Identifies a network.")
  @JsonProperty("networkId")
  public String getNetworkId() {
    return networkId;
  }
  public void setNetworkId(String networkId) {
    this.networkId = networkId;
  }

  /**
   * An underlay network, used to represent layered network\ntopologies.
   **/
  public NetworksSchemaNetwork supportingNetwork(List<NetworksSchemaSupportingNetwork> supportingNetwork) {
    this.supportingNetwork = supportingNetwork;
    return this;
  }

  
  @ApiModelProperty(value = "An underlay network, used to represent layered network\ntopologies.")
  @JsonProperty("supportingNetwork")
  public List<NetworksSchemaSupportingNetwork> getSupportingNetwork() {
    return supportingNetwork;
  }
  public void setSupportingNetwork(List<NetworksSchemaSupportingNetwork> supportingNetwork) {
    this.supportingNetwork = supportingNetwork;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworksSchemaNetwork networksSchemaNetwork = (NetworksSchemaNetwork) o;
    return Objects.equals(node, networksSchemaNetwork.node) &&
        Objects.equals(networkId, networksSchemaNetwork.networkId) &&
        Objects.equals(supportingNetwork, networksSchemaNetwork.supportingNetwork);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, networkId, supportingNetwork);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworksSchemaNetwork {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    networkId: ").append(toIndentedString(networkId)).append("\n");
    sb.append("    supportingNetwork: ").append(toIndentedString(supportingNetwork)).append("\n");
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

