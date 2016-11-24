package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.Flowentry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class FlowtableFlowtable   {
  
  private List<Flowentry> flowentry = new ArrayList<Flowentry>();

  /**
   **/
  public FlowtableFlowtable flowentry(List<Flowentry> flowentry) {
    this.flowentry = flowentry;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("flowentry")
  public List<Flowentry> getFlowentry() {
    return flowentry;
  }
  public void setFlowentry(List<Flowentry> flowentry) {
    this.flowentry = flowentry;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowtableFlowtable flowtableFlowtable = (FlowtableFlowtable) o;
    return Objects.equals(flowentry, flowtableFlowtable.flowentry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flowentry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowtableFlowtable {\n");
    
    sb.append("    flowentry: ").append(toIndentedString(flowentry)).append("\n");
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

