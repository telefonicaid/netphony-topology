package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * none
 **/

/**
 * none
 */
@ApiModel(description = "none")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class ExtensionsSpec   {
  private List<String> extensionsSpecTarget = new ArrayList<String>();

  private String extensionsSpecification = null;

  public ExtensionsSpec extensionsSpecTarget(List<String> extensionsSpecTarget) {
    this.extensionsSpecTarget = extensionsSpecTarget;
    return this;
  }

  public ExtensionsSpec addExtensionsSpecTargetItem(String extensionsSpecTargetItem) {
    this.extensionsSpecTarget.add(extensionsSpecTargetItem);
    return this;
  }

   /**
   * Get extensionsSpecTarget
   * @return extensionsSpecTarget
  **/
  @ApiModelProperty(value = "")
  public List<String> getExtensionsSpecTarget() {
    return extensionsSpecTarget;
  }

  public void setExtensionsSpecTarget(List<String> extensionsSpecTarget) {
    this.extensionsSpecTarget = extensionsSpecTarget;
  }

  public ExtensionsSpec extensionsSpecification(String extensionsSpecification) {
    this.extensionsSpecification = extensionsSpecification;
    return this;
  }

   /**
   * none
   * @return extensionsSpecification
  **/
  @ApiModelProperty(value = "none")
  public String getExtensionsSpecification() {
    return extensionsSpecification;
  }

  public void setExtensionsSpecification(String extensionsSpecification) {
    this.extensionsSpecification = extensionsSpecification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtensionsSpec extensionsSpec = (ExtensionsSpec) o;
    return Objects.equals(this.extensionsSpecTarget, extensionsSpec.extensionsSpecTarget) &&
        Objects.equals(this.extensionsSpecification, extensionsSpec.extensionsSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensionsSpecTarget, extensionsSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtensionsSpec {\n");
    
    sb.append("    extensionsSpecTarget: ").append(toIndentedString(extensionsSpecTarget)).append("\n");
    sb.append("    extensionsSpecification: ").append(toIndentedString(extensionsSpecification)).append("\n");
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

