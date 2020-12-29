package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * GetLinkDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class GetLinkDetailsRPCInputSchema   {
  private String topologyIdOrName = null;

  private String linkIdOrName = null;

  public GetLinkDetailsRPCInputSchema topologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
    return this;
  }

   /**
   * Get topologyIdOrName
   * @return topologyIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getTopologyIdOrName() {
    return topologyIdOrName;
  }

  public void setTopologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
  }

  public GetLinkDetailsRPCInputSchema linkIdOrName(String linkIdOrName) {
    this.linkIdOrName = linkIdOrName;
    return this;
  }

   /**
   * Get linkIdOrName
   * @return linkIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getLinkIdOrName() {
    return linkIdOrName;
  }

  public void setLinkIdOrName(String linkIdOrName) {
    this.linkIdOrName = linkIdOrName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLinkDetailsRPCInputSchema getLinkDetailsRPCInputSchema = (GetLinkDetailsRPCInputSchema) o;
    return Objects.equals(this.topologyIdOrName, getLinkDetailsRPCInputSchema.topologyIdOrName) &&
        Objects.equals(this.linkIdOrName, getLinkDetailsRPCInputSchema.linkIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyIdOrName, linkIdOrName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLinkDetailsRPCInputSchema {\n");
    
    sb.append("    topologyIdOrName: ").append(toIndentedString(topologyIdOrName)).append("\n");
    sb.append("    linkIdOrName: ").append(toIndentedString(linkIdOrName)).append("\n");
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

