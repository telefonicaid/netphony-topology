package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Metadata;
import es.tid.topologyModuleBase.UnifyTopoModel.model.MetadataMetadata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;



/**
 * Container for a single virtualizer
 **/

@ApiModel(description = "Container for a single virtualizer")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class VirtualizerSchema extends Metadata  {
  
  private Object nodes = null;
  private Object links = null;
  private String version = null;

  /**
   **/
  public VirtualizerSchema nodes(Object nodes) {
    this.nodes = nodes;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("nodes")
  public Object getNodes() {
    return nodes;
  }
  public void setNodes(Object nodes) {
    this.nodes = nodes;
  }
  
  /**
   **/
  public VirtualizerSchema links(Object links) {
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
   * yang and virtualizer library version
   **/
  public VirtualizerSchema version(String version) {
    this.version = version;
    return this;
  }

  
  @ApiModelProperty(value = "yang and virtualizer library version")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualizerSchema virtualizerSchema = (VirtualizerSchema) o;
    return Objects.equals(nodes, virtualizerSchema.nodes) &&
    	Objects.equals(links, virtualizerSchema.links) &&
        Objects.equals(version, virtualizerSchema.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, links, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualizerSchema {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

