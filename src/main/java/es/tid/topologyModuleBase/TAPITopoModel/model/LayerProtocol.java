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
 * Each transport layer is represented by a LayerProtocol (LP) instance. The LayerProtocol instances it can be used for controlling termination and monitoring functionality.  It can also be used for controlling the adaptation (i.e. encapsulation and/or multiplexing of client signal), tandem connection monitoring, traffic conditioning and/or shaping functionality at an intermediate point along a connection.  Where the client – server relationship is fixed 1:1 and immutable, the layers can be encapsulated in a single LTP instance. Where the is a n:1 relationship between client and server, the layers must be split over two separate instances of LTP. 
 **/

/**
 * Each transport layer is represented by a LayerProtocol (LP) instance. The LayerProtocol instances it can be used for controlling termination and monitoring functionality.  It can also be used for controlling the adaptation (i.e. encapsulation and/or multiplexing of client signal), tandem connection monitoring, traffic conditioning and/or shaping functionality at an intermediate point along a connection.  Where the client – server relationship is fixed 1:1 and immutable, the layers can be encapsulated in a single LTP instance. Where the is a n:1 relationship between client and server, the layers must be split over two separate instances of LTP. 
 */
@ApiModel(description = "Each transport layer is represented by a LayerProtocol (LP) instance. The LayerProtocol instances it can be used for controlling termination and monitoring functionality.  It can also be used for controlling the adaptation (i.e. encapsulation and/or multiplexing of client signal), tandem connection monitoring, traffic conditioning and/or shaping functionality at an intermediate point along a connection.  Where the client – server relationship is fixed 1:1 and immutable, the layers can be encapsulated in a single LTP instance. Where the is a n:1 relationship between client and server, the layers must be split over two separate instances of LTP. ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class LayerProtocol   {
  /**
   * Indicates whether the layer is terminated and if so how.
   */
  public enum TerminationStateEnum {
    LP_CAN_NEVER_TERMINATE("LP_CAN_NEVER_TERMINATE"),
    
    LT_NOT_TERMINATED("LT_NOT_TERMINATED"),
    
    TERMINATED_SERVER_TO_CLIENT_FLOW("TERMINATED_SERVER_TO_CLIENT_FLOW"),
    
    TERMINATED_CLIENT_TO_SERVER_FLOW("TERMINATED_CLIENT_TO_SERVER_FLOW"),
    
    TERMINATED_BIDIRECTIONAL("TERMINATED_BIDIRECTIONAL"),
    
    LT_PERMENANTLY_TERMINATED("LT_PERMENANTLY_TERMINATED"),
    
    TERMINATION_STATE_UNKNOWN("TERMINATION_STATE_UNKNOWN");

    private String value;

    TerminationStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TerminationStateEnum terminationState = null;

  /**
   * Indicate the specific layer-protocol described by the LayerProtocol entity.
   */
  public enum LayerProtocolNameEnum {
    OCH("OCH"),
    
    ODU("ODU"),
    
    ETH("ETH"),
    
    MPLS_TP("MPLS_TP");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private LayerProtocolNameEnum layerProtocolName = null;

  /**
   * The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
   */
  public enum TerminationDirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    SINK("SINK"),
    
    SOURCE("SOURCE"),
    
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

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

  public LayerProtocol terminationState(TerminationStateEnum terminationState) {
    this.terminationState = terminationState;
    return this;
  }

   /**
   * Indicates whether the layer is terminated and if so how.
   * @return terminationState
  **/
  @ApiModelProperty(value = "Indicates whether the layer is terminated and if so how.")
  public TerminationStateEnum getTerminationState() {
    return terminationState;
  }

  public void setTerminationState(TerminationStateEnum terminationState) {
    this.terminationState = terminationState;
  }

  public LayerProtocol layerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

   /**
   * Indicate the specific layer-protocol described by the LayerProtocol entity.
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "Indicate the specific layer-protocol described by the LayerProtocol entity.")
  public LayerProtocolNameEnum getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public LayerProtocol terminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
    return this;
  }

   /**
   * The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
   * @return terminationDirection
  **/
  @ApiModelProperty(value = "The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows")
  public TerminationDirectionEnum getTerminationDirection() {
    return terminationDirection;
  }

  public void setTerminationDirection(TerminationDirectionEnum terminationDirection) {
    this.terminationDirection = terminationDirection;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LayerProtocol layerProtocol = (LayerProtocol) o;
    return Objects.equals(this.terminationState, layerProtocol.terminationState) &&
        Objects.equals(this.layerProtocolName, layerProtocol.layerProtocolName) &&
        Objects.equals(this.terminationDirection, layerProtocol.terminationDirection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(terminationState, layerProtocolName, terminationDirection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LayerProtocol {\n");
    
    sb.append("    terminationState: ").append(toIndentedString(terminationState)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    terminationDirection: ").append(toIndentedString(terminationDirection)).append("\n");
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

