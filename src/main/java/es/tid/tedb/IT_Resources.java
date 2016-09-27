package es.tid.tedb;

import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.DefaultTEMetricLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IPv4RouterIDLocalNodeLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IPv4RouterIDRemoteNodeLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.LinkProtectionTypeLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MF_OTPAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MetricLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.TransceiverClassAndAppAttribTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.MinMaxUndirectionalLinkDelayDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalAvailableBandwidthDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalDelayVariationDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalLinkDelayDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalLinkLossDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalResidualBandwidthDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.UndirectionalUtilizedBandwidthDescriptorSubTLV;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AdministrativeGroup;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.IPv4RemoteASBRID;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.InterfaceSwitchingCapabilityDescriptor;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LinkLocalRemoteIdentifiers;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LinkProtectionType;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumReservableBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.RemoteASNumber;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.SharedRiskLinkGroup;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.TrafficEngineeringMetric;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.rsvp.constructs.gmpls.DWDMWavelengthLabel;

public class IT_Resources {
	
	private String controllerIT;
	private String cpu;
	private String mem;
	private String storage;
	private String learntFrom;
	private String domainID;

	/**
	 * TEDB logger
	 */
	public IT_Resources()
	{
		//initWLANs();
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	
	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}
	
	
	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	/**
	 * Funcion que transforma una cantidad de bits en el numero de bytes que necesita 
	 * @param numBit
	 */
	private int getNumberBytes(int numBits){
		int numberBytes = numBits/8;
		if ((numberBytes*8)<numBits){
			numberBytes++;
		}
		return numberBytes;
	}
	
	
	public String toString(){
		String ret="";

		if (controllerIT!=null){
			ret=ret+controllerIT.toString()+"\t";
		}
		if (cpu!=null){
			ret=ret+cpu.toString()+"\t";
		}
		if (mem!=null){
			ret=ret+mem.toString()+"\t";
		}
		if (storage!=null){
			ret=ret+storage.toString()+"\t";
		}
		
		
		return ret;
	}

	public String getControllerIT() {
		return controllerIT;
	}

	public void setControllerIT(String controllerIT) {
		this.controllerIT = controllerIT;
	}


	public String getLearntFrom() {
		return learntFrom;
	}
	public void setLearntFrom(String learntFrom) {
		this.learntFrom = learntFrom;
	}

	public String getITdomainID() {
		return domainID;
	}

	public void setITdomainID(String ID) {
		this.domainID = ID;
	}

	
}
