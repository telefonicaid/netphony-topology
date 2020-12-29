package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class ServiceEndPoint   {
  private List<LayerProtocol> layerProtocol = new ArrayList<LayerProtocol>();

  /**
   * Gets or Sets direction
   */
  public enum DirectionEnum {
    BIDIRECTIONAL("bidirectional"),
    
    SINK("sink"),
    
    SOURCE("source"),
    
    UNDEFINED_OR_UNKNOWN("undefined-or-unknown");

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

  private LifecycleStatePac state = null;

  public ServiceEndPoint layerProtocol(List<LayerProtocol> layerProtocol) {
    this.layerProtocol = layerProtocol;
    return this;
  }

  public ServiceEndPoint addLayerProtocolItem(LayerProtocol layerProtocolItem) {
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

  public ServiceEndPoint direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * Get direction
   * @return direction
  **/
  @ApiModelProperty(value = "")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public ServiceEndPoint state(LifecycleStatePac state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public LifecycleStatePac getState() {
    return state;
  }

  public void setState(LifecycleStatePac state) {
    this.state = state;
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
    return Objects.equals(this.layerProtocol, serviceEndPoint.layerProtocol) &&
        Objects.equals(this.direction, serviceEndPoint.direction) &&
        Objects.equals(this.state, serviceEndPoint.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(layerProtocol, direction, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceEndPoint {\n");
    
    sb.append("    layerProtocol: ").append(toIndentedString(layerProtocol)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

