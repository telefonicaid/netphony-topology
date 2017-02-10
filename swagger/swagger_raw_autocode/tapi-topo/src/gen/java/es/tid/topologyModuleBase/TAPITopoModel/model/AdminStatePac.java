package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.
 **/

/**
 * Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.
 */
@ApiModel(description = "Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class AdminStatePac   {
  private String lifecycleState = null;

  private String administrativeState = null;

  private String operationalState = null;

  public AdminStatePac lifecycleState(String lifecycleState) {
    this.lifecycleState = lifecycleState;
    return this;
  }

   /**
   * Get lifecycleState
   * @return lifecycleState
  **/
  @ApiModelProperty(value = "")
  public String getLifecycleState() {
    return lifecycleState;
  }

  public void setLifecycleState(String lifecycleState) {
    this.lifecycleState = lifecycleState;
  }

  public AdminStatePac administrativeState(String administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

   /**
   * Get administrativeState
   * @return administrativeState
  **/
  @ApiModelProperty(value = "")
  public String getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(String administrativeState) {
    this.administrativeState = administrativeState;
  }

  public AdminStatePac operationalState(String operationalState) {
    this.operationalState = operationalState;
    return this;
  }

   /**
   * Get operationalState
   * @return operationalState
  **/
  @ApiModelProperty(value = "")
  public String getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(String operationalState) {
    this.operationalState = operationalState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminStatePac adminStatePac = (AdminStatePac) o;
    return Objects.equals(this.lifecycleState, adminStatePac.lifecycleState) &&
        Objects.equals(this.administrativeState, adminStatePac.administrativeState) &&
        Objects.equals(this.operationalState, adminStatePac.operationalState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycleState, administrativeState, operationalState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminStatePac {\n");
    
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
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

