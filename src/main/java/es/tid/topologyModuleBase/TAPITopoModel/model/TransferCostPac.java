package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.CostCharacteristic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The cost characteristics of a TopologicalEntity not necessarily correlated to the cost of the underlying physical realization.  They may be quite specific to the individual TopologicalEntity e.g. opportunity cost. Relates to layer capacity There may be many perspectives from which cost may be considered  for a particular TopologicalEntity and hence many specific costs and potentially cost algorithms.  Using an entity will incur a cost. 
 **/

/**
 * The cost characteristics of a TopologicalEntity not necessarily correlated to the cost of the underlying physical realization.  They may be quite specific to the individual TopologicalEntity e.g. opportunity cost. Relates to layer capacity There may be many perspectives from which cost may be considered  for a particular TopologicalEntity and hence many specific costs and potentially cost algorithms.  Using an entity will incur a cost. 
 */
@ApiModel(description = "The cost characteristics of a TopologicalEntity not necessarily correlated to the cost of the underlying physical realization.  They may be quite specific to the individual TopologicalEntity e.g. opportunity cost. Relates to layer capacity There may be many perspectives from which cost may be considered  for a particular TopologicalEntity and hence many specific costs and potentially cost algorithms.  Using an entity will incur a cost. ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class TransferCostPac   {
  private List<CostCharacteristic> costCharacteristic = new ArrayList<CostCharacteristic>();

  public TransferCostPac costCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
    return this;
  }

  public TransferCostPac addCostCharacteristicItem(CostCharacteristic costCharacteristicItem) {
    this.costCharacteristic.add(costCharacteristicItem);
    return this;
  }

   /**
   * The list of costs where each cost relates to some aspect of the TopologicalEntity.
   * @return costCharacteristic
  **/
  @ApiModelProperty(value = "The list of costs where each cost relates to some aspect of the TopologicalEntity.")
  public List<CostCharacteristic> getCostCharacteristic() {
    return costCharacteristic;
  }

  public void setCostCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferCostPac transferCostPac = (TransferCostPac) o;
    return Objects.equals(this.costCharacteristic, transferCostPac.costCharacteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costCharacteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferCostPac {\n");
    
    sb.append("    costCharacteristic: ").append(toIndentedString(costCharacteristic)).append("\n");
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

