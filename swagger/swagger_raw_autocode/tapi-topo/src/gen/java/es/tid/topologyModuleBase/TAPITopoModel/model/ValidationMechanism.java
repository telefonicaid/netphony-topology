package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Identifies the validation mechanism and describes the characteristics of that mechanism
 **/

/**
 * Identifies the validation mechanism and describes the characteristics of that mechanism
 */
@ApiModel(description = "Identifies the validation mechanism and describes the characteristics of that mechanism")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class ValidationMechanism   {
  private String validationRobustness = null;

  private String validationMechanism = null;

  private String layerProtocolAdjacencyValidated = null;

  public ValidationMechanism validationRobustness(String validationRobustness) {
    this.validationRobustness = validationRobustness;
    return this;
  }

   /**
   * Quality of validation (i.e. how likely is the stated validation to be invalid)
   * @return validationRobustness
  **/
  @ApiModelProperty(value = "Quality of validation (i.e. how likely is the stated validation to be invalid)")
  public String getValidationRobustness() {
    return validationRobustness;
  }

  public void setValidationRobustness(String validationRobustness) {
    this.validationRobustness = validationRobustness;
  }

  public ValidationMechanism validationMechanism(String validationMechanism) {
    this.validationMechanism = validationMechanism;
    return this;
  }

   /**
   * Name of mechanism used to validate adjacency
   * @return validationMechanism
  **/
  @ApiModelProperty(value = "Name of mechanism used to validate adjacency")
  public String getValidationMechanism() {
    return validationMechanism;
  }

  public void setValidationMechanism(String validationMechanism) {
    this.validationMechanism = validationMechanism;
  }

  public ValidationMechanism layerProtocolAdjacencyValidated(String layerProtocolAdjacencyValidated) {
    this.layerProtocolAdjacencyValidated = layerProtocolAdjacencyValidated;
    return this;
  }

   /**
   * State of validatiion
   * @return layerProtocolAdjacencyValidated
  **/
  @ApiModelProperty(value = "State of validatiion")
  public String getLayerProtocolAdjacencyValidated() {
    return layerProtocolAdjacencyValidated;
  }

  public void setLayerProtocolAdjacencyValidated(String layerProtocolAdjacencyValidated) {
    this.layerProtocolAdjacencyValidated = layerProtocolAdjacencyValidated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationMechanism validationMechanism = (ValidationMechanism) o;
    return Objects.equals(this.validationRobustness, validationMechanism.validationRobustness) &&
        Objects.equals(this.validationMechanism, validationMechanism.validationMechanism) &&
        Objects.equals(this.layerProtocolAdjacencyValidated, validationMechanism.layerProtocolAdjacencyValidated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validationRobustness, validationMechanism, layerProtocolAdjacencyValidated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationMechanism {\n");
    
    sb.append("    validationRobustness: ").append(toIndentedString(validationRobustness)).append("\n");
    sb.append("    validationMechanism: ").append(toIndentedString(validationMechanism)).append("\n");
    sb.append("    layerProtocolAdjacencyValidated: ").append(toIndentedString(layerProtocolAdjacencyValidated)).append("\n");
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

