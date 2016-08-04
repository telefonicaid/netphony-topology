package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.L3Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class AddressesSchema   {
  
  private String l4 = null;
  private String l2 = null;
  private List<L3Address> l3 = new ArrayList<L3Address>();

  /**
   * e.g., request: {tcp/22, tcp/8080}; response {tcp/22: (192.168.1.100, 1001)
   **/
  public AddressesSchema l4(String l4) {
    this.l4 = l4;
    return this;
  }

  
  @ApiModelProperty(value = "e.g., request: {tcp/22, tcp/8080}; response {tcp/22: (192.168.1.100, 1001)")
  @JsonProperty("l4")
  public String getL4() {
    return l4;
  }
  public void setL4(String l4) {
    this.l4 = l4;
  }

  /**
   * Requested or provided
   **/
  public AddressesSchema l2(String l2) {
    this.l2 = l2;
    return this;
  }

  
  @ApiModelProperty(value = "Requested or provided")
  @JsonProperty("l2")
  public String getL2() {
    return l2;
  }
  public void setL2(String l2) {
    this.l2 = l2;
  }

  /**
   **/
  public AddressesSchema l3(List<L3Address> l3) {
    this.l3 = l3;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("l3")
  public List<L3Address> getL3() {
    return l3;
  }
  public void setL3(List<L3Address> l3) {
    this.l3 = l3;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressesSchema addressesSchema = (AddressesSchema) o;
    return Objects.equals(l4, addressesSchema.l4) &&
        Objects.equals(l2, addressesSchema.l2) &&
        Objects.equals(l3, addressesSchema.l3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(l4, l2, l3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressesSchema {\n");
    
    sb.append("    l4: ").append(toIndentedString(l4)).append("\n");
    sb.append("    l2: ").append(toIndentedString(l2)).append("\n");
    sb.append("    l3: ").append(toIndentedString(l3)).append("\n");
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

