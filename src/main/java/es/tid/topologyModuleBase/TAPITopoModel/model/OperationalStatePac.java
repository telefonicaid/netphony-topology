package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Provides state attributes that are applicable to an entity that reflects operational aspects. Such an entity is expected to also have lifecycle aspects.
 **/

/**
 * Provides state attributes that are applicable to an entity that reflects operational aspects. Such an entity is expected to also have lifecycle aspects.
 */
@ApiModel(description = "Provides state attributes that are applicable to an entity that reflects operational aspects. Such an entity is expected to also have lifecycle aspects.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class OperationalStatePac   {
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

  public OperationalStatePac operationalState(OperationalStateEnum operationalState) {
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

  public OperationalStatePac lifecycleState(LifecycleStateEnum lifecycleState) {
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
    OperationalStatePac operationalStatePac = (OperationalStatePac) o;
    return Objects.equals(this.operationalState, operationalStatePac.operationalState) &&
        Objects.equals(this.lifecycleState, operationalStatePac.lifecycleState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationalState, lifecycleState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationalStatePac {\n");
    
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

