package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The information for a particular risk characteristic where there is a list of risk identifiers related to that characteristic.
 **/

/**
 * The information for a particular risk characteristic where there is a list of risk identifiers related to that characteristic.
 */
@ApiModel(description = "The information for a particular risk characteristic where there is a list of risk identifiers related to that characteristic.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class RiskCharacteristic   {
  private List<String> riskIdentifierList = new ArrayList<String>();

  private String riskCharacteristicName = null;

  public RiskCharacteristic riskIdentifierList(List<String> riskIdentifierList) {
    this.riskIdentifierList = riskIdentifierList;
    return this;
  }

  public RiskCharacteristic addRiskIdentifierListItem(String riskIdentifierListItem) {
    this.riskIdentifierList.add(riskIdentifierListItem);
    return this;
  }

   /**
   * Get riskIdentifierList
   * @return riskIdentifierList
  **/
  @ApiModelProperty(value = "")
  public List<String> getRiskIdentifierList() {
    return riskIdentifierList;
  }

  public void setRiskIdentifierList(List<String> riskIdentifierList) {
    this.riskIdentifierList = riskIdentifierList;
  }

  public RiskCharacteristic riskCharacteristicName(String riskCharacteristicName) {
    this.riskCharacteristicName = riskCharacteristicName;
    return this;
  }

   /**
   * The name of the risk characteristic. The characteristic may be related to a specific degree of closeness.  For example a particular characteristic may apply to failures that are localized (e.g. to one side of a road) where as another characteristic may relate to failures that have a broader impact (e.g. both sides of a road that crosses a bridge). Depending upon the importance of the traffic being routed different risk characteristics will be evaluated.
   * @return riskCharacteristicName
  **/
  @ApiModelProperty(value = "The name of the risk characteristic. The characteristic may be related to a specific degree of closeness.  For example a particular characteristic may apply to failures that are localized (e.g. to one side of a road) where as another characteristic may relate to failures that have a broader impact (e.g. both sides of a road that crosses a bridge). Depending upon the importance of the traffic being routed different risk characteristics will be evaluated.")
  public String getRiskCharacteristicName() {
    return riskCharacteristicName;
  }

  public void setRiskCharacteristicName(String riskCharacteristicName) {
    this.riskCharacteristicName = riskCharacteristicName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RiskCharacteristic riskCharacteristic = (RiskCharacteristic) o;
    return Objects.equals(this.riskIdentifierList, riskCharacteristic.riskIdentifierList) &&
        Objects.equals(this.riskCharacteristicName, riskCharacteristic.riskCharacteristicName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskIdentifierList, riskCharacteristicName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskCharacteristic {\n");
    
    sb.append("    riskIdentifierList: ").append(toIndentedString(riskIdentifierList)).append("\n");
    sb.append("    riskCharacteristicName: ").append(toIndentedString(riskCharacteristicName)).append("\n");
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

