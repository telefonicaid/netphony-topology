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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class Capacity   {
  private String committedInformationRate = null;

  private String peakBurstSize = null;

  /**
   * Total capacity of the TopologicalEntity in MB/s
   */
  public enum TotalSizeEnum {
    NOT_APPLICABLE("NOT_APPLICABLE"),
    
    _10MBPS("10MBPS"),
    
    _100MBPS("100MBPS"),
    
    _1GBPS("1GBPS"),
    
    _2_4GBPS("2_4GBPS"),
    
    _10GBPS("10GBPS"),
    
    _40GBPS("40GBPS"),
    
    _100GBPS("100GBPS"),
    
    _200GBPS("200GBPS"),
    
    _400GBPS("400GBPS");

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

  private String committedBurstSize = null;

  /**
   * none
   */
  public enum PacketBwProfileTypeEnum {
    NOT_APPLICABLE("NOT_APPLICABLE"),
    
    MEF_10_X("MEF_10_x"),
    
    RFC_2697("RFC_2697"),
    
    RFC_2698("RFC_2698"),
    
    RFC_4115("RFC_4115");

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

  private String peakInformationRate = null;

  private Boolean couplingFlag = null;

  private Boolean colorAware = null;

  public Capacity committedInformationRate(String committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
    return this;
  }

   /**
   * none
   * @return committedInformationRate
  **/
  @ApiModelProperty(value = "none")
  public String getCommittedInformationRate() {
    return committedInformationRate;
  }

  public void setCommittedInformationRate(String committedInformationRate) {
    this.committedInformationRate = committedInformationRate;
  }

  public Capacity peakBurstSize(String peakBurstSize) {
    this.peakBurstSize = peakBurstSize;
    return this;
  }

   /**
   * none
   * @return peakBurstSize
  **/
  @ApiModelProperty(value = "none")
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

  public Capacity committedBurstSize(String committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
    return this;
  }

   /**
   * none
   * @return committedBurstSize
  **/
  @ApiModelProperty(value = "none")
  public String getCommittedBurstSize() {
    return committedBurstSize;
  }

  public void setCommittedBurstSize(String committedBurstSize) {
    this.committedBurstSize = committedBurstSize;
  }

  public Capacity packetBwProfileType(PacketBwProfileTypeEnum packetBwProfileType) {
    this.packetBwProfileType = packetBwProfileType;
    return this;
  }

   /**
   * none
   * @return packetBwProfileType
  **/
  @ApiModelProperty(value = "none")
  public PacketBwProfileTypeEnum getPacketBwProfileType() {
    return packetBwProfileType;
  }

  public void setPacketBwProfileType(PacketBwProfileTypeEnum packetBwProfileType) {
    this.packetBwProfileType = packetBwProfileType;
  }

  public Capacity peakInformationRate(String peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
    return this;
  }

   /**
   * none
   * @return peakInformationRate
  **/
  @ApiModelProperty(value = "none")
  public String getPeakInformationRate() {
    return peakInformationRate;
  }

  public void setPeakInformationRate(String peakInformationRate) {
    this.peakInformationRate = peakInformationRate;
  }

  public Capacity couplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
    return this;
  }

   /**
   * none
   * @return couplingFlag
  **/
  @ApiModelProperty(value = "none")
  public Boolean getCouplingFlag() {
    return couplingFlag;
  }

  public void setCouplingFlag(Boolean couplingFlag) {
    this.couplingFlag = couplingFlag;
  }

  public Capacity colorAware(Boolean colorAware) {
    this.colorAware = colorAware;
    return this;
  }

   /**
   * none
   * @return colorAware
  **/
  @ApiModelProperty(value = "none")
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
    return Objects.equals(this.committedInformationRate, capacity.committedInformationRate) &&
        Objects.equals(this.peakBurstSize, capacity.peakBurstSize) &&
        Objects.equals(this.totalSize, capacity.totalSize) &&
        Objects.equals(this.committedBurstSize, capacity.committedBurstSize) &&
        Objects.equals(this.packetBwProfileType, capacity.packetBwProfileType) &&
        Objects.equals(this.peakInformationRate, capacity.peakInformationRate) &&
        Objects.equals(this.couplingFlag, capacity.couplingFlag) &&
        Objects.equals(this.colorAware, capacity.colorAware);
  }

  @Override
  public int hashCode() {
    return Objects.hash(committedInformationRate, peakBurstSize, totalSize, committedBurstSize, packetBwProfileType, peakInformationRate, couplingFlag, colorAware);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Capacity {\n");
    
    sb.append("    committedInformationRate: ").append(toIndentedString(committedInformationRate)).append("\n");
    sb.append("    peakBurstSize: ").append(toIndentedString(peakBurstSize)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
    sb.append("    committedBurstSize: ").append(toIndentedString(committedBurstSize)).append("\n");
    sb.append("    packetBwProfileType: ").append(toIndentedString(packetBwProfileType)).append("\n");
    sb.append("    peakInformationRate: ").append(toIndentedString(peakInformationRate)).append("\n");
    sb.append("    couplingFlag: ").append(toIndentedString(couplingFlag)).append("\n");
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

