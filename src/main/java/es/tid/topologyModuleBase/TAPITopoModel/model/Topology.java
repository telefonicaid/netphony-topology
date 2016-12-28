package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ExtensionsSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.Link;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.Node;
import es.tid.topologyModuleBase.TAPITopoModel.model.ResourceSpec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). 
 **/

/**
 * The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). 
 */
@ApiModel(description = "The ForwardingDomain (FD) object class models the “ForwardingDomain” topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding.  At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class Topology   {
  private List<Node> node = new ArrayList<Node>();

  /**
   * none
   */
  public enum LayerProtocolNameEnum {
    OCH("OCH"),
    
    ODU("ODU"),
    
    ETH("ETH"),
    
    MPLS_TP("MPLS_TP");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private List<LayerProtocolNameEnum> layerProtocolName = new ArrayList<LayerProtocolNameEnum>();

  private List<Link> link = new ArrayList<Link>();

  public Topology node(List<Node> node) {
    this.node = node;
    return this;
  }

  public Topology addNodeItem(Node nodeItem) {
    this.node.add(nodeItem);
    return this;
  }

   /**
   * none
   * @return node
  **/
  @ApiModelProperty(value = "none")
  public List<Node> getNode() {
    return node;
  }

  public void setNode(List<Node> node) {
    this.node = node;
  }

  public Topology layerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

  public Topology addLayerProtocolNameItem(LayerProtocolNameEnum layerProtocolNameItem) {
    this.layerProtocolName.add(layerProtocolNameItem);
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "")
  public List<LayerProtocolNameEnum> getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public Topology link(List<Link> link) {
    this.link = link;
    return this;
  }

  public Topology addLinkItem(Link linkItem) {
    this.link.add(linkItem);
    return this;
  }

   /**
   * none
   * @return link
  **/
  @ApiModelProperty(value = "none")
  public List<Link> getLink() {
    return link;
  }

  public void setLink(List<Link> link) {
    this.link = link;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Topology topology = (Topology) o;
    return Objects.equals(this.node, topology.node) &&
        Objects.equals(this.layerProtocolName, topology.layerProtocolName) &&
        Objects.equals(this.link, topology.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, layerProtocolName, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Topology {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

