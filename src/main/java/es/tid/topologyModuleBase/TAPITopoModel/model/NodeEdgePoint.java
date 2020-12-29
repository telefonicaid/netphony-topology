package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.AdminStatePac;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocol;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ResourceSpec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The LogicalTerminationPoint (LTP) object class encapsulates the termination and adaptation functions of one or more transport layers.  The structure of LTP supports all transport protocols including circuit and packet forms.
 **/

/**
 * The LogicalTerminationPoint (LTP) object class encapsulates the termination and adaptation functions of one or more transport layers.  The structure of LTP supports all transport protocols including circuit and packet forms.
 */
@ApiModel(description = "The LogicalTerminationPoint (LTP) object class encapsulates the termination and adaptation functions of one or more transport layers.  The structure of LTP supports all transport protocols including circuit and packet forms.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class NodeEdgePoint   {
  private List<String> clientNodeEdgePoint = new ArrayList<String>();

  private AdminStatePac state = null;

  /**
   * The orientation of defined flow at the LinkEnd.
   */
  public enum LinkPortDirectionEnum {
    BIDIRECTIONAL("bidirectional"),
    
    INPUT("input"),
    
    OUTPUT("output"),
    
    UNIDENTIFIED_OR_UNKNOWN("unidentified-or-unknown");

    private String value;

    LinkPortDirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private LinkPortDirectionEnum linkPortDirection = null;

  private List<LayerProtocol> layerProtocol = new ArrayList<LayerProtocol>();

  /**
   * Gets or Sets terminationDirection
   */
  public enum TerminationDirectionEnum {
    BIDIRECTIONAL("bidirectional"),
    
    SINK("sink"),
    
    SOURCE("source"),
    
    UNDEFINED_OR_UNKNOWN("undefined-or-unknown");

    private String value;

    TerminationDirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TerminationDirectionEnum terminationDirection = null;

  /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   */
  public enum LinkPortRoleEnum {
    SYMMETRIC("symmetric"),
    
    ROOT("root"),
    
    LEAF("leaf"),
    
    UNKNOWN("unknown");

    private String value;

    LinkPortRoleEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private LinkPortRoleEnum linkPortRole = null;

  private List<String> mappedServiceEndPoint = new ArrayList<String>();

  public NodeEdgePoint clientNodeEdgePoint(List<String> clientNodeEdgePoint) {
    this.clientNodeEdgePoint = clientNodeEdgePoint;
    return this;
  }

  public NodeEdgePoint addClientNodeEdgePointItem(String clientNodeEdgePointItem) {
    this.clientNodeEdgePoint.add(clientNodeEdgePointItem);
    return this;
  }

   /**
   * Get clientNodeEdgePoint
   * @return clientNodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<String> getClientNodeEdgePoint() {
    return clientNodeEdgePoint;
  }

  public void setClientNodeEdgePoint(List<String> clientNodeEdgePoint) {
    this.clientNodeEdgePoint = clientNodeEdgePoint;
  }

  public NodeEdgePoint state(AdminStatePac state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public AdminStatePac getState() {
    return state;
  }

  public void setState(AdminStatePac state) {
    this.state = state;
  }

  public NodeEdgePoint linkPortDirection(LinkPortDirectionEnum linkPortDirection) {
    this.linkPortDirection = linkPortDirection;
    return this;
  }

   /**
   * The orientation of defined flow at the LinkEnd.
   * @return linkPortDirection
  **/
  @ApiModelProperty(value = "The orientation of defined flow at the LinkEnd.")
  public LinkPortDirectionEnum getLinkPortDirection() {
    return linkPortDirection;
  }

  public void setLinkPortDirection(LinkPortDirectionEnum linkPortDirection) {
    this.linkPortDirection = linkPortDirection;
  }

  public NodeEdgePoint layerProtocol(List<LayerProtocol> layerProtocol) {
    this.layerProtocol = layerProtocol;
    return this;
  }

  public NodeEdgePoint addLayerProtocolItem(LayerProtocol layerProtocolItem) {
    this.layerProtocol.add(layerProtocolItem);
    return this;
  }

   /**
   * Get layerProtocol
   * @return layerProtocol
  **/
  @ApiModelProperty(value = "")
  public List<LayerProtocol> getLayerProtocol() {
    return layerProtocol;
  }

  public void setLayerProtocol(List<LayerProtocol> layerProtocol) {
    this.layerProtocol = layerProtocol;
  }

  public NodeEdgePoint terminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
    return this;
  }

   /**
   * Get terminationDirection
   * @return terminationDirection
  **/
  @ApiModelProperty(value = "")
  public TerminationDirectionEnum getTerminationDirection() {
    return terminationDirection;
  }

  public void setTerminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
  }

  public NodeEdgePoint linkPortRole(LinkPortRoleEnum linkPortRole) {
    this.linkPortRole = linkPortRole;
    return this;
  }

   /**
   * Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. 
   * @return linkPortRole
  **/
  @ApiModelProperty(value = "Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function. ")
  public LinkPortRoleEnum getLinkPortRole() {
    return linkPortRole;
  }

  public void setLinkPortRole(LinkPortRoleEnum linkPortRole) {
    this.linkPortRole = linkPortRole;
  }

  public NodeEdgePoint mappedServiceEndPoint(List<String> mappedServiceEndPoint) {
    this.mappedServiceEndPoint = mappedServiceEndPoint;
    return this;
  }

  public NodeEdgePoint addMappedServiceEndPointItem(String mappedServiceEndPointItem) {
    this.mappedServiceEndPoint.add(mappedServiceEndPointItem);
    return this;
  }

   /**
   * Get mappedServiceEndPoint
   * @return mappedServiceEndPoint
  **/
  @ApiModelProperty(value = "")
  public List<String> getMappedServiceEndPoint() {
    return mappedServiceEndPoint;
  }

  public void setMappedServiceEndPoint(List<String> mappedServiceEndPoint) {
    this.mappedServiceEndPoint = mappedServiceEndPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeEdgePoint nodeEdgePoint = (NodeEdgePoint) o;
    return Objects.equals(this.clientNodeEdgePoint, nodeEdgePoint.clientNodeEdgePoint) &&
        Objects.equals(this.state, nodeEdgePoint.state) &&
        Objects.equals(this.linkPortDirection, nodeEdgePoint.linkPortDirection) &&
        Objects.equals(this.layerProtocol, nodeEdgePoint.layerProtocol) &&
        Objects.equals(this.terminationDirection, nodeEdgePoint.terminationDirection) &&
        Objects.equals(this.linkPortRole, nodeEdgePoint.linkPortRole) &&
        Objects.equals(this.mappedServiceEndPoint, nodeEdgePoint.mappedServiceEndPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientNodeEdgePoint, state, linkPortDirection, layerProtocol, terminationDirection, linkPortRole, mappedServiceEndPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeEdgePoint {\n");
    
    sb.append("    clientNodeEdgePoint: ").append(toIndentedString(clientNodeEdgePoint)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    linkPortDirection: ").append(toIndentedString(linkPortDirection)).append("\n");
    sb.append("    layerProtocol: ").append(toIndentedString(layerProtocol)).append("\n");
    sb.append("    terminationDirection: ").append(toIndentedString(terminationDirection)).append("\n");
    sb.append("    linkPortRole: ").append(toIndentedString(linkPortRole)).append("\n");
    sb.append("    mappedServiceEndPoint: ").append(toIndentedString(mappedServiceEndPoint)).append("\n");
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

