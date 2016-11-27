package es.tid.topologyModuleBase.UnifyTopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.tid.topologyModuleBase.UnifyTopoModel.model.IdName;
import es.tid.topologyModuleBase.UnifyTopoModel.model.LinkResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * The flowentry syntax will follow ovs-ofctrl string format. The UNIFY general tagging mechanism will be use like &#39;mpls&#39;-&gt; &#39;tag&#39;, i.e., push_tag:tag; pop_tag:tag...
 **/

@ApiModel(description = "The flowentry syntax will follow ovs-ofctrl string format. The UNIFY general tagging mechanism will be use like 'mpls'-> 'tag', i.e., push_tag:tag; pop_tag:tag...")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T10:14:24.517Z")
public class Flowentry   {
  
  private String priority = null;
  private String match = null;
  private String action = null;
  private String port = null;
  private LinkResource resources = null;
  private String out = null;

  /**
   **/
  public Flowentry priority(String priority) {
    this.priority = priority;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("priority")
  public String getPriority() {
    return priority;
  }
  public void setPriority(String priority) {
    this.priority = priority;
  }

  /**
   * The match syntax will follow ovs-ofctrl string format with 'mpls'->'tag', e.g.,: in_port=port, dl_tag=A, where port is the leafref above
   **/
  public Flowentry match(String match) {
    this.match = match;
    return this;
  }

  
  @ApiModelProperty(value = "The match syntax will follow ovs-ofctrl string format with 'mpls'->'tag', e.g.,: in_port=port, dl_tag=A, where port is the leafref above")
  @JsonProperty("match")
  public String getMatch() {
    return match;
  }
  public void setMatch(String match) {
    this.match = match;
  }

  /**
   * The action syntax will follow ovs-ofctrl string format with 'mpls'->'tag', e.g.,: push_tag:A, set_tag_label:A, output:out, where out is the leafref below
   **/
  public Flowentry action(String action) {
    this.action = action;
    return this;
  }

  
  @ApiModelProperty(value = "The action syntax will follow ovs-ofctrl string format with 'mpls'->'tag', e.g.,: push_tag:A, set_tag_label:A, output:out, where out is the leafref below")
  @JsonProperty("action")
  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  /**
   **/
  public Flowentry port(String port) {
    this.port = port;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("port")
  public String getPort() {
    return port;
  }
  public void setPort(String port) {
    this.port = port;
  }

  /**
   **/
  public Flowentry resources(LinkResource resources) {
    this.resources = resources;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("resources")
  public LinkResource getResources() {
    return resources;
  }
  public void setResources(LinkResource resources) {
    this.resources = resources;
  }

  /**
   **/
  public Flowentry out(String out) {
    this.out = out;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("out")
  public String getOut() {
    return out;
  }
  public void setOut(String out) {
    this.out = out;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flowentry flowentry = (Flowentry) o;
    return Objects.equals(priority, flowentry.priority) &&
        Objects.equals(match, flowentry.match) &&
        Objects.equals(action, flowentry.action) &&
        Objects.equals(port, flowentry.port) &&
        Objects.equals(resources, flowentry.resources) &&
        Objects.equals(out, flowentry.out);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, match, action, port, resources, out);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flowentry {\n");
    
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    out: ").append(toIndentedString(out)).append("\n");
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

