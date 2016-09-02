package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class SoftwareResource   {
  
  private String mem = null;
  private String cost = null;
  private String storage = null;
  private String cpu = null;

  /**
   **/
  public SoftwareResource mem(String mem) {
    this.mem = mem;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("mem")
  public String getMem() {
    return mem;
  }
  public void setMem(String mem) {
    this.mem = mem;
  }

  /**
   * Administrative metric.
   **/
  public SoftwareResource cost(String cost) {
    this.cost = cost;
    return this;
  }

  
  @ApiModelProperty(value = "Administrative metric.")
  @JsonProperty("cost")
  public String getCost() {
    return cost;
  }
  public void setCost(String cost) {
    this.cost = cost;
  }

  /**
   **/
  public SoftwareResource storage(String storage) {
    this.storage = storage;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("storage")
  public String getStorage() {
    return storage;
  }
  public void setStorage(String storage) {
    this.storage = storage;
  }

  /**
   **/
  public SoftwareResource cpu(String cpu) {
    this.cpu = cpu;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("cpu")
  public String getCpu() {
    return cpu;
  }
  public void setCpu(String cpu) {
    this.cpu = cpu;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoftwareResource softwareResource = (SoftwareResource) o;
    return Objects.equals(mem, softwareResource.mem) &&
        Objects.equals(cost, softwareResource.cost) &&
        Objects.equals(storage, softwareResource.storage) &&
        Objects.equals(cpu, softwareResource.cpu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mem, cost, storage, cpu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoftwareResource {\n");
    
    sb.append("    mem: ").append(toIndentedString(mem)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    cpu: ").append(toIndentedString(cpu)).append("\n");
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

