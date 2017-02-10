package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class LayerProtocol   {
  /**
   * The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows
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
   * Indicate the specific layer-protocol described by the LayerProtocol entity.
   */
  public enum LayerProtocolNameEnum {
    OCH("och"),
    
    ODU("odu"),
    
    ETH("eth"),
    
    MPLS_TP("mpls-tp");

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

  private String terminationState = null;

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

  public LayerProtocol terminationState(String terminationState) {
    this.terminationState = terminationState;
    return this;
  }

   /**
   * Indicates whether the layer is terminated and if so how.
   * @return terminationState
  **/
  @ApiModelProperty(value = "Indicates whether the layer is terminated and if so how.")
  public String getTerminationState() {
    return terminationState;
  }

  public void setTerminationState(String terminationState) {
    this.terminationState = terminationState;
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
    return Objects.equals(this.terminationDirection, layerProtocol.terminationDirection) &&
        Objects.equals(this.layerProtocolName, layerProtocol.layerProtocolName) &&
        Objects.equals(this.terminationState, layerProtocol.terminationState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(terminationDirection, layerProtocolName, terminationState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LayerProtocol {\n");
    
    sb.append("    terminationDirection: ").append(toIndentedString(terminationDirection)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    terminationState: ").append(toIndentedString(terminationState)).append("\n");
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

