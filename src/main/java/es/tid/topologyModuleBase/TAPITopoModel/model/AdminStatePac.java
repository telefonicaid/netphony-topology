package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.
 **/

/**
 * Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.
 */
@ApiModel(description = "Provides state attributes that are applicable to an entity that can be administered. Such an entity also has operational and lifecycle aspects.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class AdminStatePac   {
  /**
   * none
   */
  public enum AdministrativeStateEnum {
    LOCKED("LOCKED"),
    
    UNLOCKED("UNLOCKED");

    private String value;

    AdministrativeStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private AdministrativeStateEnum administrativeState = null;

  /**
   * none
   */
  public enum OperationalStateEnum {
    DISABLED("DISABLED"),
    
    ENABLED("ENABLED");

    private String value;

    OperationalStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private OperationalStateEnum operationalState = null;

  /**
   * none
   */
  public enum LifecycleStateEnum {
    PLANNED("PLANNED"),
    
    POTENTIAL("POTENTIAL"),
    
    INSTALLED("INSTALLED"),
    
    RESTORING("RESTORING"),
    
    PENDING_REMOVAL("PENDING_REMOVAL");

    private String value;

    LifecycleStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private LifecycleStateEnum lifecycleState = null;

  public AdminStatePac administrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

   /**
   * none
   * @return administrativeState
  **/
  @ApiModelProperty(value = "none")
  public AdministrativeStateEnum getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
  }

  public AdminStatePac operationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
    return this;
  }

   /**
   * none
   * @return operationalState
  **/
  @ApiModelProperty(value = "none")
  public OperationalStateEnum getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
  }

  public AdminStatePac lifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
    return this;
  }

   /**
   * none
   * @return lifecycleState
  **/
  @ApiModelProperty(value = "none")
  public LifecycleStateEnum getLifecycleState() {
    return lifecycleState;
  }

  public void setLifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
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
    return Objects.equals(this.administrativeState, adminStatePac.administrativeState) &&
        Objects.equals(this.operationalState, adminStatePac.operationalState) &&
        Objects.equals(this.lifecycleState, adminStatePac.lifecycleState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(administrativeState, operationalState, lifecycleState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminStatePac {\n");
    
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
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

