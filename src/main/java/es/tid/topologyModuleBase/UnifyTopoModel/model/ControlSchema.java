package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Used to connect this port to a UNIFY orchestrator&#39;s Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.
 **/

@ApiModel(description = "Used to connect this port to a UNIFY orchestrator's Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class ControlSchema   {
  
  private String controller = null;
  private String orchestrator = null;

  /**
   * URI of the local controller service at this NF, e.g., http://_*:8080/cf-or/
   **/
  public ControlSchema controller(String controller) {
    this.controller = controller;
    return this;
  }

  
  @ApiModelProperty(value = "URI of the local controller service at this NF, e.g., http://_*:8080/cf-or/")
  @JsonProperty("controller")
  public String getController() {
    return controller;
  }
  public void setController(String controller) {
    this.controller = controller;
  }

  /**
   * URI of the scoped orchestration service offered to this NF specifically, e.g., http://192.168.1.100:8080/cf-or/
   **/
  public ControlSchema orchestrator(String orchestrator) {
    this.orchestrator = orchestrator;
    return this;
  }

  
  @ApiModelProperty(value = "URI of the scoped orchestration service offered to this NF specifically, e.g., http://192.168.1.100:8080/cf-or/")
  @JsonProperty("orchestrator")
  public String getOrchestrator() {
    return orchestrator;
  }
  public void setOrchestrator(String orchestrator) {
    this.orchestrator = orchestrator;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ControlSchema controlSchema = (ControlSchema) o;
    return Objects.equals(controller, controlSchema.controller) &&
        Objects.equals(orchestrator, controlSchema.orchestrator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(controller, orchestrator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ControlSchema {\n");
    
    sb.append("    controller: ").append(toIndentedString(controller)).append("\n");
    sb.append("    orchestrator: ").append(toIndentedString(orchestrator)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

