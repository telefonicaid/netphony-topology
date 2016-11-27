package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.IdName;
import es.tid.topologyModuleBase.UnifyTopoModel.model.LinkResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class Link   {
  private String id = null;
  private String src = null;
  private String dst = null;
  private LinkResource resources = null;

  /**
   **/
  public Link id(String id) {
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
  public Link src(String src) {
    this.src = src;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("src")
  public String getSrc() {
    return src;
  }
  public void setSrc(String src) {
    this.src = src;
  }
  
  /**
   **/
  public Link dst(String dst) {
    this.dst = dst;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("dst")
  public String getDst() {
    return dst;
  }
  public void setDst(String dst) {
    this.dst = dst;
  }

  /**
   **/
  public Link resources(LinkResource resources) {
    this.resources = resources;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("resources")
  public LinkResource getResources() {
    return resources;
  }
  public void setResources(LinkResource resources) {
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
    Link link = (Link) o;
    return Objects.equals(id, link.id) &&
    	Objects.equals(src, link.src) &&
        Objects.equals(dst, link.dst) &&
        Objects.equals(resources, link.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, src, dst, resources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    src: ").append(toIndentedString(src)).append("\n");
    sb.append("    dst: ").append(toIndentedString(dst)).append("\n");
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

