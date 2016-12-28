package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ExtensionsSpec;
import es.tid.topologyModuleBase.TAPITopoModel.model.LayerProtocol;
import es.tid.topologyModuleBase.TAPITopoModel.model.LifecycleStatePac;
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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class ServiceEndPoint   {
  private LifecycleStatePac state = null;

  /**
   * none
   */
  public enum DirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    SINK("SINK"),
    
    SOURCE("SOURCE"),
    
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

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

  private List<LayerProtocol> layerProtocol = new ArrayList<LayerProtocol>();

  public ServiceEndPoint state(LifecycleStatePac state) {
    this.state = state;
    return this;
  }

   /**
   * none
   * @return state
  **/
  @ApiModelProperty(value = "none")
  public LifecycleStatePac getState() {
    return state;
  }

  public void setState(LifecycleStatePac state) {
    this.state = state;
  }

  public ServiceEndPoint direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * none
   * @return direction
  **/
  @ApiModelProperty(value = "none")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public ServiceEndPoint layerProtocol(List<LayerProtocol> layerProtocol) {
    this.layerProtocol = layerProtocol;
    return this;
  }

  public ServiceEndPoint addLayerProtocolItem(LayerProtocol layerProtocolItem) {
    this.layerProtocol.add(layerProtocolItem);
    return this;
  }

   /**
   * none
   * @return layerProtocol
  **/
  @ApiModelProperty(value = "none")
  public List<LayerProtocol> getLayerProtocol() {
    return layerProtocol;
  }

  public void setLayerProtocol(List<LayerProtocol> layerProtocol) {
    this.layerProtocol = layerProtocol;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceEndPoint serviceEndPoint = (ServiceEndPoint) o;
    return Objects.equals(this.state, serviceEndPoint.state) &&
        Objects.equals(this.direction, serviceEndPoint.direction) &&
        Objects.equals(this.layerProtocol, serviceEndPoint.layerProtocol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, direction, layerProtocol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceEndPoint {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    layerProtocol: ").append(toIndentedString(layerProtocol)).append("\n");
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

