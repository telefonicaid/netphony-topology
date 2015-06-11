package es.tid.bgp.bgp4Peer.pruebas;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import es.tid.bgp.bgp4.messages.BGP4Open;
import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4.open.BGP4OptionalParameter;
import es.tid.bgp.bgp4.open.MultiprotocolExtensionCapabilityAdvertisement;
import es.tid.bgp.bgp4.update.fields.LinkNLRI;
import es.tid.bgp.bgp4.update.fields.NodeNLRI;
import es.tid.bgp.bgp4.update.fields.PathAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.AS_Path_Attribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.OriginAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.PathAttributesTypeCode;
import es.tid.bgp.bgp4.update.tlv.LocalNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.ProtocolIDCodes;
import es.tid.bgp.bgp4.update.tlv.RemoteNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLV;

public class PruebaCodificacionMensajes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize loggers
		FileHandler fh;
		FileHandler fh1;
		try {
			fh=new FileHandler("BGP4Parser.log");		
			Logger log=Logger.getLogger("BGP4Parser");
			log.addHandler(fh);
			log.setLevel(Level.ALL);
			fh1=new FileHandler("BGP4LogFile.log");		
			Logger log1=Logger.getLogger("BGP4LogFile");
			log1.addHandler(fh1);
			log1.setLevel(Level.ALL);
			

		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		//OPEN
		openMessage_CAPABILITIES();
		//Llega un mensaje OSPF
		//Codifico mensaje OSPF. Saco los campos y los meto en el update de BGP
		//updateMessageConLinkNLRI();
		
			
		System.exit(0);
	}
	
	private static void updateMessageConNodeNLRI(){
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
	//	nodeNLRI.setInstanceIdentifier(123);
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		Inet4Address address = null;
	
		localNodeDescriptors.setNodeDescriptorsSubTLVList(nodeDescriptorsSubTLVList);
		nodeNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		update.setNlri(nodeNLRI);
		update.encode();
		
		byte[] bytes = update.getBytes();

		BGP4Update updateReceived= new BGP4Update(bytes);
		//System.out.println("Hola: "+updateReceived.toString());
	}
	
	private static void updateMessageConLinkNLRI(){
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
		LinkNLRI linkNLRI = new LinkNLRI();
		linkNLRI.setProtocolID(ProtocolIDCodes.OSPF_Protocol_ID);
		linkNLRI.setInstanceIdentifier(123);
		//Local Node Descriptors
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		
		
		localNodeDescriptors.setNodeDescriptorsSubTLVList(nodeDescriptorsSubTLVList);
		linkNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		//Remote Node Descriptors
		RemoteNodeDescriptorsTLV remoteNodeDescriptorsTLV = new RemoteNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLVList1 = new ArrayList<NodeDescriptorsSubTLV>();
		Inet4Address address1 = null;
		
		
		remoteNodeDescriptorsTLV.setNodeDescriptorsSubTLVList(nodeDescriptorsSubTLVList1);
		linkNLRI.setRemoteNodeDescriptorsTLV(remoteNodeDescriptorsTLV);
		update.setNlri(linkNLRI);
		update.encode();
		
		byte[] bytes = update.getBytes();

		BGP4Update updateReceived= new BGP4Update(bytes);
		//System.out.println("Hola: "+updateReceived.toString());
	}
	
	private static void openMessage_SIMPLE(){
		//Parametros necesarios - Obligatorios
		
		Inet4Address BGPIdentifier=null;
		try {
			BGPIdentifier = (Inet4Address) InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		int holdTime = 6;
		int autonomousSystem = 88;
		int version =4; 
		
		BGP4Open open= new BGP4Open();
		open.setBGPIdentifier(BGPIdentifier);
		open.setHoldTime(holdTime);
		open.setMyAutonomousSystem(autonomousSystem);
		open.setVersion(version);
		open.encode();
		
		byte[] bytes = open.getBytes();
		//tid.util.UtilsFunctions.printByte(bytes, "Open Mesage");
		
//		System.out.println("Longitud: "+bytes.length+ "->"+ bytes[18]);
//		BGP4Open openReceived= new BGP4Open(bytes);
//		System.out.println(openReceived.toString());
	}

	private static void openMessage_CAPABILITIES(){
		//Parametros necesarios - Obligatorios

		Inet4Address BGPIdentifier=null;
		try {
			BGPIdentifier = (Inet4Address) InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		int holdTime = 6;//inventado
		int autonomousSystem = 88;//inventado
		int version =4; 
		//Parametros necesarios - Opcionales, capabilities
	
		int aFI = 12;//inventado
		int SAFI=46;//inventado
		
		BGP4Open open= new BGP4Open();
		open.setBGPIdentifier(BGPIdentifier);
		open.setHoldTime(holdTime);
		open.setMyAutonomousSystem(autonomousSystem);
		open.setVersion(version);
		//CAPABILITIES
		LinkedList<BGP4OptionalParameter> parametersList = new LinkedList<BGP4OptionalParameter>();
		MultiprotocolExtensionCapabilityAdvertisement meca= new  MultiprotocolExtensionCapabilityAdvertisement();
		
		
		meca.setAFI(aFI);
		meca.setSAFI(SAFI);
		//parametersList.add(meca);
		open.setParametersList(parametersList);
		open.encode();
		//System.out.println(open.toString());
		byte[] bytes = open.getBytes();
		//tid.util.UtilsFunctions.printByte(bytes, "Open Mesage");
		
		//System.out.println("Longitud: "+bytes.length+ "->"+ bytes[18]);
		BGP4Open openReceived= new BGP4Open(bytes);
		//System.out.println(openReceived.toString());
	}
}
