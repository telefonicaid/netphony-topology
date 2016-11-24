package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.LinkResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class SapDataSchema   {
  
  private String technology = null;
  private LinkResource resources = null;

  /**
   * e.g., ('IEEE802.1q': '0x00c', 'MPLS': 70, 'IEEE802.1q')
   **/
  public SapDataSchema technology(String technology) {
    this.technology = technology;
    return this;
  }

  
  @ApiModelProperty(value = "e.g., ('IEEE802.1q': '0x00c', 'MPLS': 70, 'IEEE802.1q')")
  @JsonProperty("technology")
  public String getTechnology() {
    return technology;
  }
  public void setTechnology(String technology) {
    this.technology = technology;
  }

  /**
   * Only used for domain boundary ports (port-sap type), where this is used to derive interconnection link characteristics.
   **/
  public SapDataSchema resources(LinkResource resources) {
    this.resources = resources;
    return this;
  }

  
  @ApiModelProperty(value = "Only used for domain boundary ports (port-sap type), where this is used to derive interconnection link characteristics.")
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
    SapDataSchema sapDataSchema = (SapDataSchema) o;
    return Objects.equals(technology, sapDataSchema.technology) &&
        Objects.equals(resources, sapDataSchema.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(technology, resources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SapDataSchema {\n");
    
    sb.append("    technology: ").append(toIndentedString(technology)).append("\n");
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

