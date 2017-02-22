package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.GlobalClass;
import es.tid.topologyModuleBase.TAPITopoModel.model.NameAndValue;
import es.tid.topologyModuleBase.TAPITopoModel.model.ServiceEndPoint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The Network Control Domain (NCD) object class represents the scope of control that a particular SDN controller has with respect to a particular network, (i.e., encompassing a designated set of interconnected (virtual) network elements).
 **/

/**
 * The Network Control Domain (NCD) object class represents the scope of control that a particular SDN controller has with respect to a particular network, (i.e., encompassing a designated set of interconnected (virtual) network elements).
 */
@ApiModel(description = "The Network Control Domain (NCD) object class represents the scope of control that a particular SDN controller has with respect to a particular network, (i.e., encompassing a designated set of interconnected (virtual) network elements).")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class Context   {
  private List<ServiceEndPoint> serviceEndPoint = new ArrayList<ServiceEndPoint>();

  public Context serviceEndPoint(List<ServiceEndPoint> serviceEndPoint) {
    this.serviceEndPoint = serviceEndPoint;
    return this;
  }

  public Context addServiceEndPointItem(ServiceEndPoint serviceEndPointItem) {
    this.serviceEndPoint.add(serviceEndPointItem);
    return this;
  }

   /**
   * Get serviceEndPoint
   * @return serviceEndPoint
  **/
  @ApiModelProperty(value = "")
  public List<ServiceEndPoint> getServiceEndPoint() {
    return serviceEndPoint;
  }

  public void setServiceEndPoint(List<ServiceEndPoint> serviceEndPoint) {
    this.serviceEndPoint = serviceEndPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Context context = (Context) o;
    return Objects.equals(this.serviceEndPoint, context.serviceEndPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceEndPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Context {\n");
    
    sb.append("    serviceEndPoint: ").append(toIndentedString(serviceEndPoint)).append("\n");
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

