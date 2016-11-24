package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Metadata;
import es.tid.topologyModuleBase.UnifyTopoModel.model.MetadataMetadata;
import es.tid.topologyModuleBase.UnifyTopoModel.model.SoftwareResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;



/**
 * Any node: infrastructure or NFs
 **/

@ApiModel(description = "Any node: infrastructure or NFs")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class Node extends Metadata  {
  
  private String id = null;
  private Object ports = null;
  private Object links = null;
  private SoftwareResource resources = null;

  /**
   **/
  public Node id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public Node ports(Object ports) {
    this.ports = ports;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("ports")
  public Object getPorts() {
    return ports;
  }
  public void setPorts(Object ports) {
    this.ports = ports;
  }

  /**
   **/
  public Node links(Object links) {
    this.links = links;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("links")
  public Object getLinks() {
    return links;
  }
  public void setLinks(Object links) {
    this.links = links;
  }

  
  /**
   **/
  public Node resources(SoftwareResource resources) {
    this.resources = resources;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("resources")
  public SoftwareResource getResources() {
    return resources;
  }
  public void setResources(SoftwareResource resources) {
    this.resources = resources;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return id.equals(node.id) &&
    		Objects.equals(ports, node.ports) &&
    		Objects.equals(links, node.links) &&
        Objects.equals(resources, node.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ports, links, resources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Node {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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

