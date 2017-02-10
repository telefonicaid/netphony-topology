package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * A scoped name-value pair
 **/

/**
 * A scoped name-value pair
 */
@ApiModel(description = "A scoped name-value pair")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class NameAndValue   {
  private String value = null;

  private String valueName = null;

  public NameAndValue value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value
   * @return value
  **/
  @ApiModelProperty(value = "The value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public NameAndValue valueName(String valueName) {
    this.valueName = valueName;
    return this;
  }

   /**
   * The name of the value. The value need not have a name.
   * @return valueName
  **/
  @ApiModelProperty(value = "The name of the value. The value need not have a name.")
  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NameAndValue nameAndValue = (NameAndValue) o;
    return Objects.equals(this.value, nameAndValue.value) &&
        Objects.equals(this.valueName, nameAndValue.valueName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NameAndValue {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueName: ").append(toIndentedString(valueName)).append("\n");
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

