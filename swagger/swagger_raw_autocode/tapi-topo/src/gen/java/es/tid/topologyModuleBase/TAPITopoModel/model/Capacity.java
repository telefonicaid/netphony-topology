package es.tid.topologyModuleBase.TAPITopoModel.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information on capacity of a particular TopologicalEntity.
 **/

/**
 * Information on capacity of a particular TopologicalEntity.
 */
@ApiModel(description = "Information on capacity of a particular TopologicalEntity.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class Capacity   {
  private Boolean couplingFlag = null;

  private String committedBurstSize = null;

  private String peakBurstSize = null;

  /**
   * Total capacity of the TopologicalEntity in MB/s
   */
  public enum TotalSizeEnum {
    NOT_APPLICABLE("not-applicable"),
    
    _10MBPS("10mbps"),
    
    _100MBPS("100mbps"),
    
    _1GBPS("1gbps"),
    
    _2_4GBPS("2.4gbps"),
    
    _10GBPS("10gbps"),
    
    _40GBPS("40gbps"),
    
    _100GBPS("100gbps"),
    
    _200GBPS("200gbps"),
    
    _400GBPS("400gbps");

    private String value;

    TotalSizeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TotalSizeEnum totalSize = null;

  private String committedInformationRate = null;

  private String peakInformationRate = null;

  /**
   * Gets or Sets packetBwProfileType
   */
  public enum PacketBwProfileTypeEnum {
    NOT_APPLICABLE("not-applicable"),
    
    MEF_10_X("mef-10.x"),
    
    RFC_2697("rfc-2697"),
    
    RFC_2698("rfc-2698"),
    
    RFC_4115("rfc-4115");

    private String value;

    PacketBwProfileTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private PacketBwProfileTypeEnum packetBwProfileType = null;

  private Boolean colorAware = null;

  public Capacity couplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
    return this;
  }

   /**
   * Get couplingFlag
   * @return couplingFlag
  **/
  @ApiModelProperty(value = "")
  public Boolean getCouplingFlag() {
    return couplingFlag;
  }

  public void setCouplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
  }

  public Capacity committedBurstSize(String committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
    return this;
  }

   /**
   * Get committedBurstSize
   * @return committedBurstSize
  **/
  @ApiModelProperty(value = "")
  public String getCommittedBurstSize() {
    return committedBurstSize;
  }

  public void setCommittedBurstSize(String committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
  }

  public Capacity peakBurstSize(String peakBurstSize) {
    this.peakBurstSize = peakBurstSize;
    return this;
  }

   /**
   * Get peakBurstSize
   * @return peakBurstSize
  **/
  @ApiModelProperty(value = "")
  public String getPeakBurstSize() {
    return peakBurstSize;
  }

  public void setPeakBurstSize(String peakBurstSize) {
    this.peakBurstSize = peakBurstSize;
  }

  public Capacity totalSize(TotalSizeEnum totalSize) {
    this.totalSize = totalSize;
    return this;
  }

   /**
   * Total capacity of the TopologicalEntity in MB/s
   * @return totalSize
  **/
  @ApiModelProperty(value = "Total capacity of the TopologicalEntity in MB/s")
  public TotalSizeEnum getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(TotalSizeEnum totalSize) {
    this.totalSize = totalSize;
  }

  public Capacity committedInformationRate(String committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
    return this;
  }

   /**
   * Get committedInformationRate
   * @return committedInformationRate
  **/
  @ApiModelProperty(value = "")
  public String getCommittedInformationRate() {
    return committedInformationRate;
  }

  public void setCommittedInformationRate(String committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
  }

  public Capacity peakInformationRate(String peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
    return this;
  }

   /**
   * Get peakInformationRate
   * @return peakInformationRate
  **/
  @ApiModelProperty(value = "")
  public String getPeakInformationRate() {
    return peakInformationRate;
  }

  public void setPeakInformationRate(String peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
  }

  public Capacity packetBwProfileType(PacketBwProfileTypeEnum packetBwProfileType) {
    this.packetBwProfileType = packetBwProfileType;
    return this;
  }

   /**
   * Get packetBwProfileType
   * @return packetBwProfileType
  **/
  @ApiModelProperty(value = "")
  public PacketBwProfileTypeEnum getPacketBwProfileType() {
    return packetBwProfileType;
  }

  public void setPacketBwProfileType(PacketBwProfileTypeEnum packetBwProfileType) {
    this.packetBwProfileType = packetBwProfileType;
  }

  public Capacity colorAware(Boolean colorAware) {
    this.colorAware = colorAware;
    return this;
  }

   /**
   * Get colorAware
   * @return colorAware
  **/
  @ApiModelProperty(value = "")
  public Boolean getColorAware() {
    return colorAware;
  }

  public void setColorAware(Boolean colorAware) {
    this.colorAware = colorAware;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Capacity capacity = (Capacity) o;
    return Objects.equals(this.couplingFlag, capacity.couplingFlag) &&
        Objects.equals(this.committedBurstSize, capacity.committedBurstSize) &&
        Objects.equals(this.peakBurstSize, capacity.peakBurstSize) &&
        Objects.equals(this.totalSize, capacity.totalSize) &&
        Objects.equals(this.committedInformationRate, capacity.committedInformationRate) &&
        Objects.equals(this.peakInformationRate, capacity.peakInformationRate) &&
        Objects.equals(this.packetBwProfileType, capacity.packetBwProfileType) &&
        Objects.equals(this.colorAware, capacity.colorAware);
  }

  @Override
  public int hashCode() {
    return Objects.hash(couplingFlag, committedBurstSize, peakBurstSize, totalSize, committedInformationRate, peakInformationRate, packetBwProfileType, colorAware);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Capacity {\n");
    
    sb.append("    couplingFlag: ").append(toIndentedString(couplingFlag)).append("\n");
    sb.append("    committedBurstSize: ").append(toIndentedString(committedBurstSize)).append("\n");
    sb.append("    peakBurstSize: ").append(toIndentedString(peakBurstSize)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
    sb.append("    committedInformationRate: ").append(toIndentedString(committedInformationRate)).append("\n");
    sb.append("    peakInformationRate: ").append(toIndentedString(peakInformationRate)).append("\n");
    sb.append("    packetBwProfileType: ").append(toIndentedString(packetBwProfileType)).append("\n");
    sb.append("    colorAware: ").append(toIndentedString(colorAware)).append("\n");
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

