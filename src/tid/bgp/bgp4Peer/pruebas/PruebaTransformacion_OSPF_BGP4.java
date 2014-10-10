package tid.bgp.bgp4Peer.pruebas;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4.update.fields.LinkNLRI;
import es.tid.bgp.bgp4.update.fields.NodeNLRI;
import es.tid.bgp.bgp4.update.fields.PathAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.AS_Path_Attribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.LinkStateAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.OriginAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.PathAttributesTypeCode;
import es.tid.bgp.bgp4.update.tlv.LocalNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.ProtocolIDCodes;
import es.tid.bgp.bgp4.update.tlv.RemoteNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.UnreservedBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AutonomousSystemNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IGPRouterIDNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IPv4InterfaceAddressLinkDescriptorsSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IPv4NeighborAddressLinkDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.LinkLocalRemoteIdentifiersLinkDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLV;
import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.LSATypes;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.ospf.ospfv2.lsa.tlv.LinkTLV;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LinkID;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LinkLocalRemoteIdentifiers;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LocalInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.RemoteInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.LabelSetField;
import es.tid.rsvp.constructs.gmpls.DWDMWavelengthLabel;


public class PruebaTransformacion_OSPF_BGP4 {
	static Logger log;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize loggers
		FileHandler fh;
		FileHandler fh1;
		try {
			fh=new FileHandler("BGP4LogFile.log");		
			log=Logger.getLogger("BGP4LogFile");
			log.addHandler(fh);
			log.setLevel(Level.ALL);
			fh1=new FileHandler("BGP4Parser.log");		
			Logger log1=Logger.getLogger("BGP4Parser");
			log1.addHandler(fh1);
			log1.setLevel(Level.ALL);
			

		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		OSPFv2LinkStateUpdatePacket ospf = createMsgOSPF();
		decodificarMsgOSPF(ospf);
	}
	/**
	 * Solo se meten en el mensaje los campos:
	 * - source
	 * - destino
	 * - maximun bandwithd
	 */
	public static OSPFv2LinkStateUpdatePacket createMsgOSPF(){
		Inet4Address src = null;
		Inet4Address dst = null;

		LocalInterfaceIPAddress localInterfaceIPAddress = new LocalInterfaceIPAddress();
		RemoteInterfaceIPAddress remoteInterfaceIPAddress = new RemoteInterfaceIPAddress();
		
		MaximumBandwidth maximumBandwidth = new MaximumBandwidth();
		maximumBandwidth.setMaximumBandwidth(100);
		UnreservedBandwidth unreservedBandwidth = new UnreservedBandwidth();
		float[] unReservedB = new float[8];
		unReservedB[0]=18309;
		unReservedB[1]=130;
		unreservedBandwidth.setUnreservedBandwidth(unReservedB);
		try {
			src = (Inet4Address) Inet4Address.getByName( "172.16.1.38");
			dst = (Inet4Address) Inet4Address.getByName( "179.123.123.111");
			
			Inet4Address localInterface = (Inet4Address) Inet4Address.getByName( "31.31.31.2");
			Inet4Address remoteInterface = (Inet4Address) Inet4Address.getByName( "31.31.31.1");
			
			LinkedList<Inet4Address> localInterfaceIPAddressList = new LinkedList<Inet4Address>();
			localInterfaceIPAddressList.add(localInterface);
			localInterfaceIPAddress.setLocalInterfaceIPAddressList(localInterfaceIPAddressList);
			
			LinkedList<Inet4Address> remoteInterfaceIPAddressList = new LinkedList<Inet4Address>();
			remoteInterfaceIPAddressList.add(remoteInterface);
			remoteInterfaceIPAddress.setRemoteInterfaceIPAddressList(remoteInterfaceIPAddressList);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		OSPFv2LinkStateUpdatePacket ospfv2Packet = new OSPFv2LinkStateUpdatePacket();
		//SOURCE
		ospfv2Packet.setRouterID(src);
		LinkedList<LSA> lsaList = new LinkedList<LSA>();
		OSPFTEv2LSA lsa = new OSPFTEv2LSA();
		LinkTLV linkTLV=new LinkTLV();
		lsa.setLinkTLV(linkTLV);
		//DESTINATION
		LinkID linkID = new LinkID();
		linkID.setLinkID(dst);
		linkTLV.setLinkID(linkID);
		
		//Local/Remote interface IP address
		linkTLV.setLocalInterfaceIPAddress(localInterfaceIPAddress);
		linkTLV.setRemoteInterfaceIPAddress(remoteInterfaceIPAddress);
		
		//MPLS 
		linkTLV.setMaximumBandwidth(maximumBandwidth);
		linkTLV.setUnreservedBandwidth(unreservedBandwidth);
		
		//Link Local Remote id
		LinkLocalRemoteIdentifiers	linkLocalRemoteIdentifiers = new LinkLocalRemoteIdentifiers();
		linkLocalRemoteIdentifiers.setLinkLocalIdentifier(2);
		linkLocalRemoteIdentifiers.setLinkRemoteIdentifier(1);
		linkTLV.setLinkLocalRemoteIdentifiers(linkLocalRemoteIdentifiers);
		//GMPLS
		AvailableLabels al=new AvailableLabels();
		LabelSetField labelSet = new  BitmapLabelSet(); 
		DWDMWavelengthLabel dwdmWavelengthLabel = new DWDMWavelengthLabel();
		labelSet.setNumLabels(8*8);
		dwdmWavelengthLabel.setN(56);
		
		byte[] bytesBitMap = new byte[8];
		bytesBitMap[3] = 0xF;
		bytesBitMap[5]=0x3;
		((BitmapLabelSet)labelSet).setDwdmWavelengthLabel(dwdmWavelengthLabel);
		((BitmapLabelSet)labelSet).setBytesBitmap(bytesBitMap);
		((BitmapLabelSet)labelSet).setBytesBitmapReserved(bytesBitMap);
		al.setLabelSet(labelSet);
		linkTLV.setAvailableLabels(al);
//		if (edge.getTE_info().getAvailableLabels() != null){
//			linkTLV.setAvailableLabels(edge.getTE_info().getAvailableLabels());			
//		}
		lsaList.add(lsa);

		ospfv2Packet.setLSAlist(lsaList);
		return ospfv2Packet;
	}
	
	public static void decodificarMsgOSPF(OSPFv2LinkStateUpdatePacket ospfv2Packet){
		Inet4Address localIPAddress = ospfv2Packet.getRouterID();
		Inet4Address remoteIPAddress = null;
		Inet4Address localInterfaceIPAddress = null;
		Inet4Address remoteInterfaceIPAddress = null;
		LinkedList<LSA> lsaList;
		OSPFTEv2LSA lsa;
		AvailableLabels al = null;
		float maxBandwidth = 0;
		float[] unBandwidth = null;
		long localId = 0;
		long remoteId = 0; 
		lsaList = ((OSPFv2LinkStateUpdatePacket)ospfv2Packet).getLSAlist();
		for (int i =0;i< lsaList.size();i++){
			if (lsaList.get(i).getLStype() == LSATypes.TYPE_10_OPAQUE_LSA){
				lsa=(OSPFTEv2LSA)lsaList.get(i);
				log.info("Starting to process LSA");
				LinkTLV linkTLV = lsa.getLinkTLV();
				al = linkTLV.getAvailableLabels(); 
				if (linkTLV!=null){
					//log.info("Link TLV ha llegado "+lsa.toString());
					//System.out.println(linkTLV.toString());
					if (localInterfaceIPAddress == null){
						localInterfaceIPAddress = linkTLV.getLocalInterfaceIPAddress().getLocalInterfaceIPAddress(0);
					}
					log.info("Local InterfaceIPAddress: "+localInterfaceIPAddress);

					remoteIPAddress = linkTLV.getLinkID().getLinkID();					
					log.info("Remote InterfaceIPAddress: "+remoteIPAddress);
					
					 remoteInterfaceIPAddress =linkTLV.getRemoteInterfaceIPAddress().getRemoteInterfaceIPAddress(0);

					MaximumBandwidth maximumBandwidth = linkTLV.getMaximumBandwidth();
					maxBandwidth = maximumBandwidth.getMaximumBandwidth();
					UnreservedBandwidth unreservedBandwidth = linkTLV.getUnreservedBandwidth();
					unBandwidth = unreservedBandwidth.getUnreservedBandwidth();
					
					if (unBandwidth == null){
						unBandwidth = new float[8];
						unBandwidth[0]=1809;
						unreservedBandwidth.setUnreservedBandwidth(unBandwidth);
					}
					 localId = linkTLV.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
					 remoteId = linkTLV.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();
				}
			}
			
	}
		ArrayList<Inet4Address> addressList = new ArrayList<Inet4Address>();
		addressList.add(localIPAddress);
		addressList.add(remoteIPAddress);
		
		ArrayList<Inet4Address> addressInterfaceList = new ArrayList<Inet4Address>();
		addressInterfaceList.add(localInterfaceIPAddress);
		addressInterfaceList.add(remoteInterfaceIPAddress);
		ArrayList<Long> localRemoteIfList = null;
		if (localId != 0 && remoteId != 0){
			localRemoteIfList = new ArrayList<Long>();
			localRemoteIfList.add(localId);
			localRemoteIfList.add(remoteId);
		}
		
		//mandarMsgUpdateNodeNLRI(addressList,23);
		if (unBandwidth != null){
			mandarMsgUpdateLinkNLRI_IntraDomain(addressList,addressInterfaceList,localRemoteIfList,23,maxBandwidth,unBandwidth, 23,al);
		}
		mandarMsgUpdateLinkNLRI_InterDomain(addressList,addressInterfaceList,localRemoteIfList,23,maxBandwidth,unBandwidth, 23,al);
		

	}
	private static void mandarMsgUpdateNodeNLRI(ArrayList<Inet4Address> addressList,int lanID){
		BGP4Update update= new BGP4Update();	
		//Path Attributes
		ArrayList<PathAttribute> pathAttributes = new ArrayList<PathAttribute>();
		//Origin
		OriginAttribute or = new OriginAttribute(); 
		or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_INCOMPLETE);
		pathAttributes.add(or);
		
		//AS_PATH
		AS_Path_Attribute as_path = new AS_Path_Attribute();
		as_path.setType(PathAttributesTypeCode.PATH_ATTRIBUTE_ASPATH_AS_SEQUENCE);
		as_path.setNumberASes(1);
		as_path.setValue(65002);
		pathAttributes.add(as_path);
		update.setPathAttributes(pathAttributes);
		//NLRI
		NodeNLRI nodeNLRI = new NodeNLRI();
		nodeNLRI.setProtocolID(ProtocolIDCodes.OSPF_Protocol_ID);
		//nodeNLRI.setInstanceIdentifier(123);
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		
		for (int i=0; i< addressList.size(); i++ ) {
			IGPRouterIDNodeDescriptorSubTLV ipv4RouterIDSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
			ipv4RouterIDSubTLV.setIGP_router_id_type(2);
			ipv4RouterIDSubTLV.setIpv4AddressOSPF(addressList.get(i));		
			nodeDescriptorsSubTLVList.add(ipv4RouterIDSubTLV);
		}
		localNodeDescriptors.setNodeDescriptorsSubTLVList(nodeDescriptorsSubTLVList);
		nodeNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		update.setNlri(nodeNLRI);
		update.encode();
		
		byte[] bytes = update.getBytes();

		BGP4Update updateReceived= new BGP4Update(bytes);
		//System.out.println(" "+updateReceived.toString());
	}
	
	
	private static void mandarMsgUpdateLinkNLRI_IntraDomain(ArrayList<Inet4Address> addressList,ArrayList<Inet4Address> addressInterfaceList,ArrayList<Long> localRemoteIfList,int lanID,  float maximumBandwidth, float[] unreservedBandwidth, float maximumReservableBandwidth , AvailableLabels availableLabels){
		BGP4Update update= new BGP4Update();	
		//Path Attributes
		ArrayList<PathAttribute> pathAttributes = new ArrayList<PathAttribute>();
		//Origin
//		OriginAttribute or = new OriginAttribute(); 
//		or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_INCOMPLETE);
//		pathAttributes.add(or);
//		
//		//AS_PATH
//		AS_Path_Attribute as_path = new AS_Path_Attribute();
//		as_path.setType(PathAttributesTypeCode.PATH_ATTRIBUTE_ASPATH_AS_SEQUENCE);
//		as_path.setNumberASes(1);
//		as_path.setValue(65002);
//		pathAttributes.add(as_path);
	
		
		//LINK-STATE
		LinkStateAttribute  linkStateAttribute = new LinkStateAttribute();
		//MaxReservableBandwidth
		MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV = new MaxReservableBandwidthLinkAttribTLV();
		maxReservableBandwidthTLV.setMaximumReservableBandwidth(maximumReservableBandwidth);
		linkStateAttribute.setMaxReservableBandwidthTLV(maxReservableBandwidthTLV);
		//maxBandwidth
		MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV = new MaximumLinkBandwidthLinkAttribTLV();
		maximumLinkBandwidthTLV.setMaximumBandwidth(maximumBandwidth);
		linkStateAttribute.setMaximumLinkBandwidthTLV(maximumLinkBandwidthTLV);
		//unreservedBandwidth
		UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV = new UnreservedBandwidthLinkAttribTLV();
		unreservedBandwidthTLV.setUnreservedBandwidth(unreservedBandwidth);
		linkStateAttribute.setUnreservedBandwidthTLV(unreservedBandwidthTLV);		
		//AvailableLabels
		if (availableLabels != null){
			linkStateAttribute.setAvailableLabels(availableLabels);
		}
		pathAttributes.add(linkStateAttribute);
		//add PathAttributes
		update.setPathAttributes(pathAttributes);
		//NLRI
		LinkNLRI linkNLRI = new LinkNLRI();
		linkNLRI.setProtocolID(ProtocolIDCodes.OSPF_Protocol_ID);
		linkNLRI.setInstanceIdentifier(123);
		//Local Y Remote Descriptors
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		RemoteNodeDescriptorsTLV remoteNodeDescriptors = new RemoteNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> sourceDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		ArrayList<NodeDescriptorsSubTLV> dstDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		
		IGPRouterIDNodeDescriptorSubTLV ipv4RouterIDOrigSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		ipv4RouterIDOrigSubTLV.setIpv4AddressOSPF(addressList.get(0));	
		ipv4RouterIDOrigSubTLV.setIGP_router_id_type(2);
		sourceDescriptorsSubTLVList.add(ipv4RouterIDOrigSubTLV);
			
		IGPRouterIDNodeDescriptorSubTLV ipv4RouterIDDestSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		ipv4RouterIDDestSubTLV.setIpv4AddressOSPF(addressList.get(1));
		ipv4RouterIDDestSubTLV.setIGP_router_id_type(2);
		dstDescriptorsSubTLVList.add(ipv4RouterIDDestSubTLV);
			
		
		localNodeDescriptors.setNodeDescriptorsSubTLVList(sourceDescriptorsSubTLVList);
		remoteNodeDescriptors.setNodeDescriptorsSubTLVList(dstDescriptorsSubTLVList);
		linkNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		linkNLRI.setRemoteNodeDescriptorsTLV(remoteNodeDescriptors);
		//Link Descriptors
		//LinkDescriptors linkDescriptors = new LinkDescriptors();
		
		IPv4InterfaceAddressLinkDescriptorsSubTLV ipv4InterfaceAddressTLV = new IPv4InterfaceAddressLinkDescriptorsSubTLV();
		IPv4NeighborAddressLinkDescriptorSubTLV ipv4NeighborAddressTLV = new IPv4NeighborAddressLinkDescriptorSubTLV();
		ipv4InterfaceAddressTLV.setIpv4Address(addressInterfaceList.get(0));
		ipv4NeighborAddressTLV.setIpv4Address(addressInterfaceList.get(1));
		//linkDescriptors.setIpv4InterfaceAddressTLV(ipv4InterfaceAddressTLV);
		//linkDescriptors.setIpv4NeighborAddressTLV(ipv4NeighborAddressTLV);
		linkNLRI.setIpv4InterfaceAddressTLV(ipv4InterfaceAddressTLV);
		linkNLRI.setIpv4NeighborAddressTLV(ipv4NeighborAddressTLV);
		if (localRemoteIfList !=  null){
			LinkLocalRemoteIdentifiersLinkDescriptorSubTLV linkIdentifiersTLV = new LinkLocalRemoteIdentifiersLinkDescriptorSubTLV();
			linkIdentifiersTLV.setLinkLocalIdentifier(localRemoteIfList.get(0));
			linkIdentifiersTLV.setLinkRemoteIdentifier(localRemoteIfList.get(1));
			linkNLRI.setLinkIdentifiersTLV(linkIdentifiersTLV);
		}
		//linkNLRI.setLinkDescriptors(linkDescriptors);
		update.setNlri(linkNLRI);

		update.encode();
		//System.out.println(" Encoded : "+update.toString());
		//FuncionesUtiles.printByte(update.getBytes(), "MENSAJE FINAL:");
		
		byte[] bytes = update.getBytes();

		BGP4Update updateReceived= new BGP4Update(bytes);
		//System.out.println(" REceived:  "+updateReceived.toString());
	}
	
	
	private static void mandarMsgUpdateLinkNLRI_InterDomain(ArrayList<Inet4Address> addressList,ArrayList<Inet4Address> addressInterfaceList,ArrayList<Long> localRemoteIfList,int lanID,  float maximumBandwidth, float[] unreservedBandwidth, float maximumReservableBandwidth , AvailableLabels availableLabels){
		BGP4Update update= new BGP4Update();	
		//Path Attributes
		ArrayList<PathAttribute> pathAttributes = new ArrayList<PathAttribute>();
		//Origin
//		OriginAttribute or = new OriginAttribute(); 
//		or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_INCOMPLETE);
//		pathAttributes.add(or);
//		
//		//AS_PATH
//		AS_Path_Attribute as_path = new AS_Path_Attribute();
//		as_path.setType(PathAttributesTypeCode.PATH_ATTRIBUTE_ASPATH_AS_SEQUENCE);
//		as_path.setNumberASes(1);
//		as_path.setValue(65002);
//		pathAttributes.add(as_path);
	
		
		//LINK-STATE
		LinkStateAttribute  linkStateAttribute = new LinkStateAttribute();
		//MaxReservableBandwidth
		MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV = new MaxReservableBandwidthLinkAttribTLV();
		maxReservableBandwidthTLV.setMaximumReservableBandwidth(maximumReservableBandwidth);
		linkStateAttribute.setMaxReservableBandwidthTLV(maxReservableBandwidthTLV);
		//maxBandwidth
		MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV = new MaximumLinkBandwidthLinkAttribTLV();
		maximumLinkBandwidthTLV.setMaximumBandwidth(maximumBandwidth);
		linkStateAttribute.setMaximumLinkBandwidthTLV(maximumLinkBandwidthTLV);
		//unreservedBandwidth
		UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV = new UnreservedBandwidthLinkAttribTLV();
		unreservedBandwidthTLV.setUnreservedBandwidth(unreservedBandwidth);
		linkStateAttribute.setUnreservedBandwidthTLV(unreservedBandwidthTLV);		
		//AvailableLabels
		if (availableLabels != null){
			linkStateAttribute.setAvailableLabels(availableLabels);
		}
		pathAttributes.add(linkStateAttribute);
		//add PathAttributes
		update.setPathAttributes(pathAttributes);
		//NLRI
		LinkNLRI linkNLRI = new LinkNLRI();
		linkNLRI.setProtocolID(ProtocolIDCodes.OSPF_Protocol_ID);
		linkNLRI.setInstanceIdentifier(123);
		//Local Y Remote Descriptors
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		RemoteNodeDescriptorsTLV remoteNodeDescriptors = new RemoteNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> sourceDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		ArrayList<NodeDescriptorsSubTLV> dstDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		//IPv4
		IGPRouterIDNodeDescriptorSubTLV ipv4RouterIDOrigSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		ipv4RouterIDOrigSubTLV.setIpv4AddressOSPF(addressList.get(0));	
		ipv4RouterIDOrigSubTLV.setIGP_router_id_type(2);
		sourceDescriptorsSubTLVList.add(ipv4RouterIDOrigSubTLV);
			
		IGPRouterIDNodeDescriptorSubTLV ipv4RouterIDDestSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		ipv4RouterIDDestSubTLV.setIpv4AddressOSPF(addressList.get(1));
		ipv4RouterIDDestSubTLV.setIGP_router_id_type(2);
		dstDescriptorsSubTLVList.add(ipv4RouterIDDestSubTLV);
			
		//AS
		ArrayList<Inet4Address> aS_ID = new ArrayList<Inet4Address>();
		try {
			aS_ID.add((Inet4Address) Inet4Address.getByName("1.1.1.1"));
			aS_ID.add((Inet4Address) Inet4Address.getByName("1.1.1.2"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AutonomousSystemNodeDescriptorSubTLV as_local = new AutonomousSystemNodeDescriptorSubTLV();
		as_local.setAS_ID(aS_ID.get(0));
		sourceDescriptorsSubTLVList.add(as_local);
		AutonomousSystemNodeDescriptorSubTLV as_remote = new AutonomousSystemNodeDescriptorSubTLV();
		as_remote.setAS_ID(aS_ID.get(1));
		dstDescriptorsSubTLVList.add(as_remote);
		
		
		localNodeDescriptors.setNodeDescriptorsSubTLVList(sourceDescriptorsSubTLVList);
		remoteNodeDescriptors.setNodeDescriptorsSubTLVList(dstDescriptorsSubTLVList);
		linkNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		linkNLRI.setRemoteNodeDescriptorsTLV(remoteNodeDescriptors);
		//Link Descriptors
		//LinkDescriptors linkDescriptors = new LinkDescriptors();
		
		IPv4InterfaceAddressLinkDescriptorsSubTLV ipv4InterfaceAddressTLV = new IPv4InterfaceAddressLinkDescriptorsSubTLV();
		IPv4NeighborAddressLinkDescriptorSubTLV ipv4NeighborAddressTLV = new IPv4NeighborAddressLinkDescriptorSubTLV();
		ipv4InterfaceAddressTLV.setIpv4Address(addressInterfaceList.get(0));
		ipv4NeighborAddressTLV.setIpv4Address(addressInterfaceList.get(1));
		//linkDescriptors.setIpv4InterfaceAddressTLV(ipv4InterfaceAddressTLV);
		//linkDescriptors.setIpv4NeighborAddressTLV(ipv4NeighborAddressTLV);
		linkNLRI.setIpv4InterfaceAddressTLV(ipv4InterfaceAddressTLV);
		linkNLRI.setIpv4NeighborAddressTLV(ipv4NeighborAddressTLV);
		if (localRemoteIfList !=  null){
			LinkLocalRemoteIdentifiersLinkDescriptorSubTLV linkIdentifiersTLV = new LinkLocalRemoteIdentifiersLinkDescriptorSubTLV();
			linkIdentifiersTLV.setLinkLocalIdentifier(localRemoteIfList.get(0));
			linkIdentifiersTLV.setLinkRemoteIdentifier(localRemoteIfList.get(1));
			linkNLRI.setLinkIdentifiersTLV(linkIdentifiersTLV);
		}

		//linkNLRI.setLinkDescriptors(linkDescriptors);
		update.setNlri(linkNLRI);

		update.encode();
		//System.out.println(" Encoded : "+update.toString());
		//FuncionesUtiles.printByte(update.getBytes(), "MENSAJE FINAL:");
		
		byte[] bytes = update.getBytes();

		BGP4Update updateReceived= new BGP4Update(bytes);
		//System.out.println(" REceived:  "+updateReceived.toString());
	}
}
