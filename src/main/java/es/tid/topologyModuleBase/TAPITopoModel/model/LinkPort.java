package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ExtensionsSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.LocalClass;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;



/**
 * The association of the Link to LTPs is made via LinkEnd. The LinkEnd object class models the access to the Link function.  The traffic forwarding between the associated LinkEnds of the Link depends upon the type of Link.   In cases where there is resilience the LinkEnd may convey the resilience role of the access to the Link.  The Link can be considered as a component and the LinkEnd as a Port on that component
 **/

/**
 * The association of the Link to LTPs is made via LinkEnd. The LinkEnd object class models the access to the Link function.  The traffic forwarding between the associated LinkEnds of the Link depends upon the type of Link.   In cases where there is resilience the LinkEnd may convey the resilience role of the access to the Link.  The Link can be considered as a component and the LinkEnd as a Port on that component
 */
@ApiModel(description = "The association of the Link to LTPs is made via LinkEnd. The LinkEnd object class models the access to the Link function.  The traffic forwarding between the associated LinkEnds of the Link depends upon the type of Link.   In cases where there is resilience the LinkEnd may convey the resilience role of the access to the Link.  The Link can be considered as a component and the LinkEnd as a Port on that component")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class LinkPort   {
  private String nodeEdgePoint = null;

  /**
   * The orientation of defined flow at the LinkEnd.
   */
  public enum DirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    INPUT("INPUT"),
    
    OUTPUT("OUTPUT"),
    
    UNIDENTIFIED_OR_UNKNOWN("UNIDENTIFIED_OR_UNKNOWN");

    private String value;

    DirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private DirectionEnum direction = null;

  /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   */
  public enum RoleEnum {
    SYMMETRIC("SYMMETRIC"),
    
    ROOT("ROOT"),
    
    LEAF("LEAF"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private RoleEnum role = null;

  public LinkPort nodeEdgePoint(String nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

   /**
   * none
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "none")
  public String getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(String nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }

  public LinkPort direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * The orientation of defined flow at the LinkEnd.
   * @return direction
  **/
  @ApiModelProperty(value = "The orientation of defined flow at the LinkEnd.")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public LinkPort role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   * @return role
  **/
  @ApiModelProperty(value = "Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. ")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkPort linkPort = (LinkPort) o;
    return Objects.equals(this.nodeEdgePoint, linkPort.nodeEdgePoint) &&
        Objects.equals(this.direction, linkPort.direction) &&
        Objects.equals(this.role, linkPort.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeEdgePoint, direction, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkPort {\n");
    
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

