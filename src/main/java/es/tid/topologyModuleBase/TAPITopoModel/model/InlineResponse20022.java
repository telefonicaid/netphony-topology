package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * InlineResponse20022
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class InlineResponse20022   {
  private List<String> itemlist = new ArrayList<String>();

  public InlineResponse20022 itemlist(List<String> itemlist) {
    this.itemlist = itemlist;
    return this;
  }

  public InlineResponse20022 addItemlistItem(String itemlistItem) {
    this.itemlist.add(itemlistItem);
    return this;
  }

   /**
   * Get itemlist
   * @return itemlist
  **/
  @ApiModelProperty(value = "")
  public List<String> getItemlist() {
    return itemlist;
  }

  public void setItemlist(List<String> itemlist) {
    this.itemlist = itemlist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20022 inlineResponse20022 = (InlineResponse20022) o;
    return Objects.equals(this.itemlist, inlineResponse20022.itemlist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemlist);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20022 {\n");
    
    sb.append("    itemlist: ").append(toIndentedString(itemlist)).append("\n");
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

