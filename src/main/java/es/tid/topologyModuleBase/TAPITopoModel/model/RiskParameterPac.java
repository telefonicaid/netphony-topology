package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.RiskCharacteristic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The risk characteristics of a TopologicalEntity come directly from the underlying physical realization.  The risk characteristics propagate from the physical realization to the client and from the server layer to the client layer, this propagation may be modified by protection. A TopologicalEntity may suffer degradation or failure as a result of a problem in a part of the underlying realization. The realization can be partitioned into segments which have some relevant common failure modes. There is a risk of failure/degradation of each segment of the underlying realization. Each segment is a part of a larger physical/geographical unit that behaves as one with respect to failure (i.e. a failure will have a high probability of impacting the whole unit (e.g. all cables in the same duct). Disruptions to that larger physical/geographical unit will impact (cause failure/errors to) all TopologicalEntities that use any part of that larger physical/geographical entity. Any TopologicalEntity that uses any part of that larger physical/geographical unit will suffer impact and hence each TopologicalEntity shares risk. The identifier of each physical/geographical unit that is involved in the realization of each segment of a Topological entity can be listed in the RiskParameter_Pac of that TopologicalEntity. A segment has one or more risk characteristic. Shared risk between two TopologicalEntities compromises the integrity of any solution that use one of those TopologicalEntity as a backup for the other. Where two TopologicalEntities have a common risk characteristic they have an elevated probability of failing simultaneously compared to two TopologicalEntities that do not share risk characteristics.
 **/

/**
 * The risk characteristics of a TopologicalEntity come directly from the underlying physical realization.  The risk characteristics propagate from the physical realization to the client and from the server layer to the client layer, this propagation may be modified by protection. A TopologicalEntity may suffer degradation or failure as a result of a problem in a part of the underlying realization. The realization can be partitioned into segments which have some relevant common failure modes. There is a risk of failure/degradation of each segment of the underlying realization. Each segment is a part of a larger physical/geographical unit that behaves as one with respect to failure (i.e. a failure will have a high probability of impacting the whole unit (e.g. all cables in the same duct). Disruptions to that larger physical/geographical unit will impact (cause failure/errors to) all TopologicalEntities that use any part of that larger physical/geographical entity. Any TopologicalEntity that uses any part of that larger physical/geographical unit will suffer impact and hence each TopologicalEntity shares risk. The identifier of each physical/geographical unit that is involved in the realization of each segment of a Topological entity can be listed in the RiskParameter_Pac of that TopologicalEntity. A segment has one or more risk characteristic. Shared risk between two TopologicalEntities compromises the integrity of any solution that use one of those TopologicalEntity as a backup for the other. Where two TopologicalEntities have a common risk characteristic they have an elevated probability of failing simultaneously compared to two TopologicalEntities that do not share risk characteristics.
 */
@ApiModel(description = "The risk characteristics of a TopologicalEntity come directly from the underlying physical realization.  The risk characteristics propagate from the physical realization to the client and from the server layer to the client layer, this propagation may be modified by protection. A TopologicalEntity may suffer degradation or failure as a result of a problem in a part of the underlying realization. The realization can be partitioned into segments which have some relevant common failure modes. There is a risk of failure/degradation of each segment of the underlying realization. Each segment is a part of a larger physical/geographical unit that behaves as one with respect to failure (i.e. a failure will have a high probability of impacting the whole unit (e.g. all cables in the same duct). Disruptions to that larger physical/geographical unit will impact (cause failure/errors to) all TopologicalEntities that use any part of that larger physical/geographical entity. Any TopologicalEntity that uses any part of that larger physical/geographical unit will suffer impact and hence each TopologicalEntity shares risk. The identifier of each physical/geographical unit that is involved in the realization of each segment of a Topological entity can be listed in the RiskParameter_Pac of that TopologicalEntity. A segment has one or more risk characteristic. Shared risk between two TopologicalEntities compromises the integrity of any solution that use one of those TopologicalEntity as a backup for the other. Where two TopologicalEntities have a common risk characteristic they have an elevated probability of failing simultaneously compared to two TopologicalEntities that do not share risk characteristics.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class RiskParameterPac   {
  private List<RiskCharacteristic> riskCharacteristic = new ArrayList<RiskCharacteristic>();

  public RiskParameterPac riskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
    return this;
  }

  public RiskParameterPac addRiskCharacteristicItem(RiskCharacteristic riskCharacteristicItem) {
    this.riskCharacteristic.add(riskCharacteristicItem);
    return this;
  }

   /**
   * A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.
   * @return riskCharacteristic
  **/
  @ApiModelProperty(value = "A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.")
  public List<RiskCharacteristic> getRiskCharacteristic() {
    return riskCharacteristic;
  }

  public void setRiskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RiskParameterPac riskParameterPac = (RiskParameterPac) o;
    return Objects.equals(this.riskCharacteristic, riskParameterPac.riskCharacteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskCharacteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskParameterPac {\n");
    
    sb.append("    riskCharacteristic: ").append(toIndentedString(riskCharacteristic)).append("\n");
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

