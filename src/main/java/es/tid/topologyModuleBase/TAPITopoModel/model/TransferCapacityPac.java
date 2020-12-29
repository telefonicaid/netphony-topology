package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.tid.topologyModuleBase.TAPITopoModel.model.Capacity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The TopologicalEntity derives capacity from the underlying realization.  A TopologicalEntity may be an abstraction and virtualization of a subset of the underlying capability offered in a view or may be directly reflecting the underlying realization. A TopologicalEntity may be directly used in the view or may be assigned to another view for use. The clients supported by a multi-layer TopologicalEntity may interact such that the resources used by one client may impact those available to another. This is derived from the LTP spec details. Represents the capacity available to user (client) along with client interaction and usage.  A TopologicalEntity may reflect one or more client protocols and one or more members for each profile.
 **/

/**
 * The TopologicalEntity derives capacity from the underlying realization.  A TopologicalEntity may be an abstraction and virtualization of a subset of the underlying capability offered in a view or may be directly reflecting the underlying realization. A TopologicalEntity may be directly used in the view or may be assigned to another view for use. The clients supported by a multi-layer TopologicalEntity may interact such that the resources used by one client may impact those available to another. This is derived from the LTP spec details. Represents the capacity available to user (client) along with client interaction and usage.  A TopologicalEntity may reflect one or more client protocols and one or more members for each profile.
 */
@ApiModel(description = "The TopologicalEntity derives capacity from the underlying realization.  A TopologicalEntity may be an abstraction and virtualization of a subset of the underlying capability offered in a view or may be directly reflecting the underlying realization. A TopologicalEntity may be directly used in the view or may be assigned to another view for use. The clients supported by a multi-layer TopologicalEntity may interact such that the resources used by one client may impact those available to another. This is derived from the LTP spec details. Represents the capacity available to user (client) along with client interaction and usage.  A TopologicalEntity may reflect one or more client protocols and one or more members for each profile.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class TransferCapacityPac   {
  private Capacity availableCapacity = null;

  private Capacity totalPotentialCapacity = null;

  private String capacityInteractionAlgorithm = null;

  private List<Capacity> capacityAssignedToUserView = new ArrayList<Capacity>();

  public TransferCapacityPac availableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

   /**
   * Capacity available to be assigned.
   * @return availableCapacity
  **/
  @ApiModelProperty(value = "Capacity available to be assigned.")
  public Capacity getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
  }

  public TransferCapacityPac totalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
    return this;
  }

   /**
   * An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.
   * @return totalPotentialCapacity
  **/
  @ApiModelProperty(value = "An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.")
  public Capacity getTotalPotentialCapacity() {
    return totalPotentialCapacity;
  }

  public void setTotalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
  }

  public TransferCapacityPac capacityInteractionAlgorithm(String capacityInteractionAlgorithm) {
    this.capacityInteractionAlgorithm = capacityInteractionAlgorithm;
    return this;
  }

   /**
   * A reference to an algorithm that describes how various chunks of allocated capacity interact (e.g. when shared)
   * @return capacityInteractionAlgorithm
  **/
  @ApiModelProperty(value = "A reference to an algorithm that describes how various chunks of allocated capacity interact (e.g. when shared)")
  public String getCapacityInteractionAlgorithm() {
    return capacityInteractionAlgorithm;
  }

  public void setCapacityInteractionAlgorithm(String capacityInteractionAlgorithm) {
    this.capacityInteractionAlgorithm = capacityInteractionAlgorithm;
  }

  public TransferCapacityPac capacityAssignedToUserView(List<Capacity> capacityAssignedToUserView) {
    this.capacityAssignedToUserView = capacityAssignedToUserView;
    return this;
  }

  public TransferCapacityPac addCapacityAssignedToUserViewItem(Capacity capacityAssignedToUserViewItem) {
    this.capacityAssignedToUserView.add(capacityAssignedToUserViewItem);
    return this;
  }

   /**
   * Capacity already assigned
   * @return capacityAssignedToUserView
  **/
  @ApiModelProperty(value = "Capacity already assigned")
  public List<Capacity> getCapacityAssignedToUserView() {
    return capacityAssignedToUserView;
  }

  public void setCapacityAssignedToUserView(List<Capacity> capacityAssignedToUserView) {
    this.capacityAssignedToUserView = capacityAssignedToUserView;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferCapacityPac transferCapacityPac = (TransferCapacityPac) o;
    return Objects.equals(this.availableCapacity, transferCapacityPac.availableCapacity) &&
        Objects.equals(this.totalPotentialCapacity, transferCapacityPac.totalPotentialCapacity) &&
        Objects.equals(this.capacityInteractionAlgorithm, transferCapacityPac.capacityInteractionAlgorithm) &&
        Objects.equals(this.capacityAssignedToUserView, transferCapacityPac.capacityAssignedToUserView);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableCapacity, totalPotentialCapacity, capacityInteractionAlgorithm, capacityAssignedToUserView);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferCapacityPac {\n");
    
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    totalPotentialCapacity: ").append(toIndentedString(totalPotentialCapacity)).append("\n");
    sb.append("    capacityInteractionAlgorithm: ").append(toIndentedString(capacityInteractionAlgorithm)).append("\n");
    sb.append("    capacityAssignedToUserView: ").append(toIndentedString(capacityAssignedToUserView)).append("\n");
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

