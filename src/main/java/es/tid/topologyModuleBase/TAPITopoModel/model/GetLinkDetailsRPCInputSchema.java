package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * GetLinkDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class GetLinkDetailsRPCInputSchema   {
  private String linkIdOrName = null;

  private String topologyIdOrName = null;

  public GetLinkDetailsRPCInputSchema linkIdOrName(String linkIdOrName) {
    this.linkIdOrName = linkIdOrName;
    return this;
  }

   /**
   * none
   * @return linkIdOrName
  **/
  @ApiModelProperty(value = "none")
  public String getLinkIdOrName() {
    return linkIdOrName;
  }

  public void setLinkIdOrName(String linkIdOrName) {
    this.linkIdOrName = linkIdOrName;
  }

  public GetLinkDetailsRPCInputSchema topologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
    return this;
  }

   /**
   * none
   * @return topologyIdOrName
  **/
  @ApiModelProperty(value = "none")
  public String getTopologyIdOrName() {
    return topologyIdOrName;
  }

  public void setTopologyIdOrName(String topologyIdOrName) {
    this.topologyIdOrName = topologyIdOrName;
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
    return Objects.equals(this.linkIdOrName, getLinkDetailsRPCInputSchema.linkIdOrName) &&
        Objects.equals(this.topologyIdOrName, getLinkDetailsRPCInputSchema.topologyIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkIdOrName, topologyIdOrName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLinkDetailsRPCInputSchema {\n");
    
    sb.append("    linkIdOrName: ").append(toIndentedString(linkIdOrName)).append("\n");
    sb.append("    topologyIdOrName: ").append(toIndentedString(topologyIdOrName)).append("\n");
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

