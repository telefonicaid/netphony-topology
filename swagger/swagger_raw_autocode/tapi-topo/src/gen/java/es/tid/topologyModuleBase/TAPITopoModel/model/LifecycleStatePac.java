package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Provides state attributes for an entity that has lifeccycle aspects only.
 **/

/**
 * Provides state attributes for an entity that has lifeccycle aspects only.
 */
@ApiModel(description = "Provides state attributes for an entity that has lifeccycle aspects only.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class LifecycleStatePac   {
  private String lifecycleState = null;

  public LifecycleStatePac lifecycleState(String lifecycleState) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifecycleStatePac lifecycleStatePac = (LifecycleStatePac) o;
    return Objects.equals(this.lifecycleState, lifecycleStatePac.lifecycleState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycleState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifecycleStatePac {\n");
    
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

