package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Metadata;
import es.tid.topologyModuleBase.UnifyTopoModel.model.MetadataMetadata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class Port extends Metadata  {
  
  private String id = null;
  private Object control = null;
  private Object addresses = null;
  private String capability = null;
  private Object sapData = null;
  private String portType = null;
  private String sap = null;

  /**
   * Used to connect this port to a UNIFY orchestrator's Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.
   **/
  public Port id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "Used to connect this port to a UNIFY orchestrator's Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Used to connect this port to a UNIFY orchestrator's Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.
   **/
  public Port control(Object control) {
    this.control = control;
    return this;
  }

  
  @ApiModelProperty(value = "Used to connect this port to a UNIFY orchestrator's Cf-Or reference point. Support controller - orchestrator or orchestrator - controller connection establishment.")
  @JsonProperty("control")
  public Object getControl() {
    return control;
  }
  public void setControl(Object control) {
    this.control = control;
  }

  /**
   **/
  public Port addresses(Object addresses) {
    this.addresses = addresses;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("addresses")
  public Object getAddresses() {
    return addresses;
  }
  public void setAddresses(Object addresses) {
    this.addresses = addresses;
  }

  /**
   * To describe match and action capabilities associated with the port, e.g., match=port,tag,ip,tcp,udp,mpls,of1.0, where port: based forwarding; tag: unify abstract tagging; ip: ip address matching etc.
   **/
  public Port capability(String capability) {
    this.capability = capability;
    return this;
  }

  
  @ApiModelProperty(value = "To describe match and action capabilities associated with the port, e.g., match=port,tag,ip,tcp,udp,mpls,of1.0, where port: based forwarding; tag: unify abstract tagging; ip: ip address matching etc.")
  @JsonProperty("capability")
  public String getCapability() {
    return capability;
  }
  public void setCapability(String capability) {
    this.capability = capability;
  }

  /**
   **/
  public Port sapData(Object sapData) {
    this.sapData = sapData;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("sapData")
  public Object getSapData() {
    return sapData;
  }
  public void setSapData(Object sapData) {
    this.sapData = sapData;
  }

  /**
   * {port-abstract, port-sap} port-sap is to represent UNIFY domain boundary; port-abstract is to represent UNIFY native port. Technology specific attributes of a SAP is in the metadata.
   **/
  public Port portType(String portType) {
    this.portType = portType;
    return this;
  }

  
  @ApiModelProperty(value = "{port-abstract, port-sap} port-sap is to represent UNIFY domain boundary; port-abstract is to represent UNIFY native port. Technology specific attributes of a SAP is in the metadata.")
  @JsonProperty("portType")
  public String getPortType() {
    return portType;
  }
  public void setPortType(String portType) {
    this.portType = portType;
  }

  /**
   **/
  public Port sap(String sap) {
    this.sap = sap;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("sap")
  public String getSap() {
    return sap;
  }
  public void setSap(String sap) {
    this.sap = sap;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Port port = (Port) o;
    return Objects.equals(id, port.id) &&
    	Objects.equals(control, port.control) &&
        Objects.equals(addresses, port.addresses) &&
        Objects.equals(capability, port.capability) &&
        Objects.equals(sapData, port.sapData) &&
        Objects.equals(portType, port.portType) &&
        Objects.equals(sap, port.sap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, control, addresses, capability, sapData, portType, sap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Port {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    control: ").append(toIndentedString(control)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
    sb.append("    sapData: ").append(toIndentedString(sapData)).append("\n");
    sb.append("    portType: ").append(toIndentedString(portType)).append("\n");
    sb.append("    sap: ").append(toIndentedString(sap)).append("\n");
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

