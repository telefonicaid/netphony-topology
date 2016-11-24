package es.tid.topologyModuleBase.IETFTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworksSchemaNode;
import es.tid.topologyModuleBase.IETFTopoModel.model.NetworksSchemaSupportingNetwork;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T18:59:38.916+02:00")
public class NetworksSchemaNetwork   {
  
  private List<NetworksSchemaNode> node = new ArrayList<NetworksSchemaNode>();
  private String networkId = null;
  private Boolean serverProvided = null;
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
   * Indicates whether the information concerning this\nparticular network is populated by the server\n(server-provided true, the general case for network\ninformation discovered from the server),\nor whether it is configured by a client\n(server-provided true, possible e.g. for\nservice overlays managed through a controller).\nClients should not attempt to make modifications\nto network instances with server-provided set to\ntrue; when they do, they need to be aware that\nany modifications they make are subject to be\nreverted by the server.\nFor servers that support NACM (Netconf Access Control\nModel), data node rules should ideally prevent\nwrite access by other clients to the network instance\nwhen server-provided is set to true.
   **/
  public NetworksSchemaNetwork serverProvided(Boolean serverProvided) {
    this.serverProvided = serverProvided;
    return this;
  }

  
  @ApiModelProperty(value = "Indicates whether the information concerning this\nparticular network is populated by the server\n(server-provided true, the general case for network\ninformation discovered from the server),\nor whether it is configured by a client\n(server-provided true, possible e.g. for\nservice overlays managed through a controller).\nClients should not attempt to make modifications\nto network instances with server-provided set to\ntrue; when they do, they need to be aware that\nany modifications they make are subject to be\nreverted by the server.\nFor servers that support NACM (Netconf Access Control\nModel), data node rules should ideally prevent\nwrite access by other clients to the network instance\nwhen server-provided is set to true.")
  @JsonProperty("serverProvided")
  public Boolean getServerProvided() {
    return serverProvided;
  }
  public void setServerProvided(Boolean serverProvided) {
    this.serverProvided = serverProvided;
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
        Objects.equals(serverProvided, networksSchemaNetwork.serverProvided) &&
        Objects.equals(supportingNetwork, networksSchemaNetwork.supportingNetwork);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, networkId, serverProvided, supportingNetwork);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworksSchemaNetwork {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    networkId: ").append(toIndentedString(networkId)).append("\n");
    sb.append("    serverProvided: ").append(toIndentedString(serverProvided)).append("\n");
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

