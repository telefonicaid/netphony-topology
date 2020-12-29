package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Provides information on latency characteristic for a particular stated trafficProperty.
 **/

/**
 * Provides information on latency characteristic for a particular stated trafficProperty.
 */
@ApiModel(description = "Provides information on latency characteristic for a particular stated trafficProperty.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class LatencyCharacteristic   {
  private String fixedLatencyCharacteristic = null;

  private String trafficPropertyName = null;

  private String jitterCharacteristic = null;

  private String wanderCharacteristic = null;

  private String trafficPropertyQueingLatency = null;

  public LatencyCharacteristic fixedLatencyCharacteristic(String fixedLatencyCharacteristic) {
    this.fixedLatencyCharacteristic = fixedLatencyCharacteristic;
    return this;
  }

   /**
   * A TopologicalEntity suffers delay caused by the realization of the servers (e.g. distance related; FEC encoding etc.) along with some client specific processing. This is the total average latency effect of the TopologicalEntity
   * @return fixedLatencyCharacteristic
  **/
  @ApiModelProperty(value = "A TopologicalEntity suffers delay caused by the realization of the servers (e.g. distance related; FEC encoding etc.) along with some client specific processing. This is the total average latency effect of the TopologicalEntity")
  public String getFixedLatencyCharacteristic() {
    return fixedLatencyCharacteristic;
  }

  public void setFixedLatencyCharacteristic(String fixedLatencyCharacteristic) {
    this.fixedLatencyCharacteristic = fixedLatencyCharacteristic;
  }

  public LatencyCharacteristic trafficPropertyName(String trafficPropertyName) {
    this.trafficPropertyName = trafficPropertyName;
    return this;
  }

   /**
   * The identifier of the specific traffic property to which the queuing latency applies.
   * @return trafficPropertyName
  **/
  @ApiModelProperty(value = "The identifier of the specific traffic property to which the queuing latency applies.")
  public String getTrafficPropertyName() {
    return trafficPropertyName;
  }

  public void setTrafficPropertyName(String trafficPropertyName) {
    this.trafficPropertyName = trafficPropertyName;
  }

  public LatencyCharacteristic jitterCharacteristic(String jitterCharacteristic) {
    this.jitterCharacteristic = jitterCharacteristic;
    return this;
  }

   /**
   * High frequency deviation from true periodicity of a signal and therefore a small high rate of change of transfer latency. Applies to TDM systems (and not packet).
   * @return jitterCharacteristic
  **/
  @ApiModelProperty(value = "High frequency deviation from true periodicity of a signal and therefore a small high rate of change of transfer latency. Applies to TDM systems (and not packet).")
  public String getJitterCharacteristic() {
    return jitterCharacteristic;
  }

  public void setJitterCharacteristic(String jitterCharacteristic) {
    this.jitterCharacteristic = jitterCharacteristic;
  }

  public LatencyCharacteristic wanderCharacteristic(String wanderCharacteristic) {
    this.wanderCharacteristic = wanderCharacteristic;
    return this;
  }

   /**
   * Low frequency deviation from true periodicity of a signal and therefore a small low rate of change of transfer latency. Applies to TDM systems (and not packet).
   * @return wanderCharacteristic
  **/
  @ApiModelProperty(value = "Low frequency deviation from true periodicity of a signal and therefore a small low rate of change of transfer latency. Applies to TDM systems (and not packet).")
  public String getWanderCharacteristic() {
    return wanderCharacteristic;
  }

  public void setWanderCharacteristic(String wanderCharacteristic) {
    this.wanderCharacteristic = wanderCharacteristic;
  }

  public LatencyCharacteristic trafficPropertyQueingLatency(String trafficPropertyQueingLatency) {
    this.trafficPropertyQueingLatency = trafficPropertyQueingLatency;
    return this;
  }

   /**
   * The specific queuing latency for the traffic property.
   * @return trafficPropertyQueingLatency
  **/
  @ApiModelProperty(value = "The specific queuing latency for the traffic property.")
  public String getTrafficPropertyQueingLatency() {
    return trafficPropertyQueingLatency;
  }

  public void setTrafficPropertyQueingLatency(String trafficPropertyQueingLatency) {
    this.trafficPropertyQueingLatency = trafficPropertyQueingLatency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LatencyCharacteristic latencyCharacteristic = (LatencyCharacteristic) o;
    return Objects.equals(this.fixedLatencyCharacteristic, latencyCharacteristic.fixedLatencyCharacteristic) &&
        Objects.equals(this.trafficPropertyName, latencyCharacteristic.trafficPropertyName) &&
        Objects.equals(this.jitterCharacteristic, latencyCharacteristic.jitterCharacteristic) &&
        Objects.equals(this.wanderCharacteristic, latencyCharacteristic.wanderCharacteristic) &&
        Objects.equals(this.trafficPropertyQueingLatency, latencyCharacteristic.trafficPropertyQueingLatency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fixedLatencyCharacteristic, trafficPropertyName, jitterCharacteristic, wanderCharacteristic, trafficPropertyQueingLatency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LatencyCharacteristic {\n");
    
    sb.append("    fixedLatencyCharacteristic: ").append(toIndentedString(fixedLatencyCharacteristic)).append("\n");
    sb.append("    trafficPropertyName: ").append(toIndentedString(trafficPropertyName)).append("\n");
    sb.append("    jitterCharacteristic: ").append(toIndentedString(jitterCharacteristic)).append("\n");
    sb.append("    wanderCharacteristic: ").append(toIndentedString(wanderCharacteristic)).append("\n");
    sb.append("    trafficPropertyQueingLatency: ").append(toIndentedString(trafficPropertyQueingLatency)).append("\n");
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

