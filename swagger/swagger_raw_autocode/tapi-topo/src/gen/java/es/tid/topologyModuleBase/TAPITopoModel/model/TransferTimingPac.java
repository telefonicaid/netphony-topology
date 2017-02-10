package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.LatencyCharacteristic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * A TopologicalEntity will suffer effects from the underlying physical realization related to the timing of the information passed by the TopologicalEntity.
 **/

/**
 * A TopologicalEntity will suffer effects from the underlying physical realization related to the timing of the information passed by the TopologicalEntity.
 */
@ApiModel(description = "A TopologicalEntity will suffer effects from the underlying physical realization related to the timing of the information passed by the TopologicalEntity.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class TransferTimingPac   {
  private List<LatencyCharacteristic> latencyCharacteristic = new ArrayList<LatencyCharacteristic>();

  public TransferTimingPac latencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
    return this;
  }

  public TransferTimingPac addLatencyCharacteristicItem(LatencyCharacteristic latencyCharacteristicItem) {
    this.latencyCharacteristic.add(latencyCharacteristicItem);
    return this;
  }

   /**
   * The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.
   * @return latencyCharacteristic
  **/
  @ApiModelProperty(value = "The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.")
  public List<LatencyCharacteristic> getLatencyCharacteristic() {
    return latencyCharacteristic;
  }

  public void setLatencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferTimingPac transferTimingPac = (TransferTimingPac) o;
    return Objects.equals(this.latencyCharacteristic, transferTimingPac.latencyCharacteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latencyCharacteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferTimingPac {\n");
    
    sb.append("    latencyCharacteristic: ").append(toIndentedString(latencyCharacteristic)).append("\n");
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

