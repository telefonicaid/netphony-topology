package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class LinkResource   {
  
  private String delay = null;
  private String bandwidth = null;
  private String cost = null;

  /**
   **/
  public LinkResource delay(String delay) {
    this.delay = delay;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("delay")
  public String getDelay() {
    return delay;
  }
  public void setDelay(String delay) {
    this.delay = delay;
  }

  /**
   **/
  public LinkResource bandwidth(String bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("bandwidth")
  public String getBandwidth() {
    return bandwidth;
  }
  public void setBandwidth(String bandwidth) {
    this.bandwidth = bandwidth;
  }

  /**
   * Administrative metric.
   **/
  public LinkResource cost(String cost) {
    this.cost = cost;
    return this;
  }

  
  @ApiModelProperty(value = "Administrative metric.")
  @JsonProperty("cost")
  public String getCost() {
    return cost;
  }
  public void setCost(String cost) {
    this.cost = cost;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkResource linkResource = (LinkResource) o;
    return Objects.equals(delay, linkResource.delay) &&
        Objects.equals(bandwidth, linkResource.bandwidth) &&
        Objects.equals(cost, linkResource.cost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delay, bandwidth, cost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkResource {\n");
    
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
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

