package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * The information for a particular cost characteristic.
 **/

/**
 * The information for a particular cost characteristic.
 */
@ApiModel(description = "The information for a particular cost characteristic.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class CostCharacteristic   {
  private String costName = null;

  private String costAlgorithm = null;

  private String costValue = null;

  public CostCharacteristic costName(String costName) {
    this.costName = costName;
    return this;
  }

   /**
   * The cost characteristic will related to some aspect of the TopologicalEntity (e.g. $ cost, routing weight). This aspect will be conveyed by the costName.
   * @return costName
  **/
  @ApiModelProperty(value = "The cost characteristic will related to some aspect of the TopologicalEntity (e.g. $ cost, routing weight). This aspect will be conveyed by the costName.")
  public String getCostName() {
    return costName;
  }

  public void setCostName(String costName) {
    this.costName = costName;
  }

  public CostCharacteristic costAlgorithm(String costAlgorithm) {
    this.costAlgorithm = costAlgorithm;
    return this;
  }

   /**
   * The cost may vary based upon some properties of the TopologicalEntity. The rules for the variation are conveyed by the costAlgorithm.
   * @return costAlgorithm
  **/
  @ApiModelProperty(value = "The cost may vary based upon some properties of the TopologicalEntity. The rules for the variation are conveyed by the costAlgorithm.")
  public String getCostAlgorithm() {
    return costAlgorithm;
  }

  public void setCostAlgorithm(String costAlgorithm) {
    this.costAlgorithm = costAlgorithm;
  }

  public CostCharacteristic costValue(String costValue) {
    this.costValue = costValue;
    return this;
  }

   /**
   * The specific cost.
   * @return costValue
  **/
  @ApiModelProperty(value = "The specific cost.")
  public String getCostValue() {
    return costValue;
  }

  public void setCostValue(String costValue) {
    this.costValue = costValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CostCharacteristic costCharacteristic = (CostCharacteristic) o;
    return Objects.equals(this.costName, costCharacteristic.costName) &&
        Objects.equals(this.costAlgorithm, costCharacteristic.costAlgorithm) &&
        Objects.equals(this.costValue, costCharacteristic.costValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costName, costAlgorithm, costValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CostCharacteristic {\n");
    
    sb.append("    costName: ").append(toIndentedString(costName)).append("\n");
    sb.append("    costAlgorithm: ").append(toIndentedString(costAlgorithm)).append("\n");
    sb.append("    costValue: ").append(toIndentedString(costValue)).append("\n");
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

