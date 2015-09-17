package es.tid.bgp.bgp4Peer.peer;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4.update.fields.LinkNLRI;
import es.tid.bgp.bgp4.update.fields.NodeNLRI;
import es.tid.bgp.bgp4.update.fields.PathAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.AS_Path_Attribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.BGP_LS_MP_Reach_Attribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.LinkStateAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.OriginAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.PathAttributesTypeCode;
import es.tid.bgp.bgp4.update.tlv.LocalNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.ProtocolIDCodes;
import es.tid.bgp.bgp4.update.tlv.RemoteNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.DefaultTEMetricLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MF_OTPAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.SidLabelNodeAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.UnreservedBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AreaIDNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AutonomousSystemNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.BGPLSIdentifierNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IGPRouterIDNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IPv4InterfaceAddressLinkDescriptorsSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IPv4NeighborAddressLinkDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.LinkLocalRemoteIdentifiersLinkDescriptorSubTLV;
import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import es.tid.bgp.bgp4Peer.bgp4session.GenericBGP4Session;
import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.LSATypes;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.ospf.ospfv2.lsa.tlv.LinkTLV;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LinkID;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LocalInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.RemoteInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.pce.server.RedisDatabaseHandler;
import es.tid.tedb.DatabaseControlSimplifiedLSA;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.Node_Info;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TE_Information;

/**
 * Class to send periodically the topology. It sends the topology to the active BGP4 sessions.
 * @author pac
 *
 */
public class SaveTopologyinDB implements Runnable {
	
	/**
	 * 1= optical
	 * 0= L3
	 */
	private int identifier=1;

	//TEDBs 
	 private Hashtable<Inet4Address,SimpleTEDB> intraTEDBs;
	
	// Multi-domain TEDB to redistribute Multi-domain Topology
	private MultiDomainTEDB multiDomainTEDB;

	private boolean sendTopology;
	private BGP4SessionsInformation bgp4SessionsInformation;
	private Logger log;
	private int instanceId=1;
	private boolean sendIntraDomainLinks=false;
	
	
	private Inet4Address localBGPLSIdentifer;
	private Inet4Address localAreaID;
	
	RedisDatabaseHandler rdh;
	
	public SaveTopologyinDB(){
		log = Logger.getLogger("BGP4Parser");
		 rdh= new RedisDatabaseHandler();
	}

	public void configure( Hashtable<Inet4Address,SimpleTEDB> intraTEDBs,BGP4SessionsInformation bgp4SessionsInformation,boolean sendTopology,int instanceId,boolean sendIntraDomainLinks, MultiDomainTEDB multiTED){
		this.intraTEDBs=intraTEDBs;
		this.bgp4SessionsInformation=bgp4SessionsInformation;
		this.sendTopology= sendTopology;
		this.instanceId = instanceId;
		this.sendIntraDomainLinks=sendIntraDomainLinks;
		this.multiDomainTEDB=multiTED;
		try {
			this.localAreaID=(Inet4Address)Inet4Address.getByName("0.0.0.0");
			this.localBGPLSIdentifer=(Inet4Address)Inet4Address.getByName("1.1.1.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Function to send the topology database.
	 */


	public void run(){	
		
		try {
		if (sendTopology){
			if (multiDomainTEDB!=null){
					log.info("Sending Multi-Domain TEDB");
					writeLinkDB( multiDomainTEDB.getInterDomainLinks());
				}
				else {
					log.info("Sending form TEDB");
					Enumeration<SimpleTEDB> iter = intraTEDBs.elements();
					while (iter.hasMoreElements()){
						writeLinkDB( iter.nextElement().getInterDomainLinks());
					}
				}			
				
				if (sendIntraDomainLinks){//Intradomain Links
					log.info("sendIntraDomainLinks activated");
					Enumeration<Inet4Address> iter = intraTEDBs.keys();
					while (iter.hasMoreElements()){						
						Inet4Address domainID = iter.nextElement();
						log.info("Sending TED from domain "+domainID);
						SimpleTEDB ted=intraTEDBs.get(domainID);
						//writeLinkDB( ted.getNetworkGraph().edgeSet(),domainID);
						//sendNodeNLRI(ted.getNetworkGraph().vertexSet(), ted.getNodeTable());
					}
					
	
				}
							
		}
		}catch (Exception e) {
			e.printStackTrace();
			log.severe("PROBLEM SENDING TOPOLOGY: "+e.toString());
		}
	}

	/**
	 * This function write a BGP4 update message in Data Base for each link in the list
	 * @param interdomainLinks
	 */
	private void writeLinkDB(LinkedList<InterDomainEdge> interdomainLinks){
			Iterator<InterDomainEdge> edgeIt = interdomainLinks.iterator();
			while (edgeIt.hasNext()){

				InterDomainEdge edge = edgeIt.next();
				
				DatabaseControlSimplifiedLSA dcsl =createSimplifiedLSA(edge); 
				String jsonLSA = dcsl.logJsonSimplifiedLSA();
				rdh.write("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(),jsonLSA);				
			}

	}
	
	private DatabaseControlSimplifiedLSA createSimplifiedLSA(InterDomainEdge edge){
		DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
		
		Inet4Address source = (Inet4Address)edge.getSrc_router_id();
		Inet4Address dst = (Inet4Address)edge.getDst_router_id();
		
		TE_Information te_info = ((InterDomainEdge) edge).getTE_info();
		
		if (te_info != null){
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkLocalIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
			}
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkRemoteIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();
			}
			
			if (te_info.getMaximumBandwidth() != null) {
				dcsl.maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
			}
			
			if (te_info.getUnreservedBandwidth() != null) {
			//	dcsl.unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth();
			}
		
			
			if (te_info.getMaximumReservableBandwidth() != null)
				dcsl.maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
			
						
//			//GMPLS
//			if (te_info.getAvailableLabels() != null)
//				availableLabels = te_info.getAvailableLabels();
//			if(te_info.getDefaultTEMetric()!=null){
//				metric = (int) te_info.getDefaultTEMetric().getLinkMetric();
//				log.info("Metric en el metodo sendLinkNLRI es: " + metric);
//			}
//			if(te_info.getMfOTF()!=null){
//				mfOTP =  te_info.getMfOTF();
//			}
//
//		}else{
//			log.info("TE_Info es null");
//		}
		
		//dcsl.setBitmapLabelSet(edge.getTE_info().getAvailableLabels());
		
		}
		return dcsl;
	
	}
	}
				
				
				//			ArrayList<Inet4Address> addressList = new ArrayList<Inet4Address>();
//				log.info("Sending: ("+source.toString() +","+dst.toString()+")");
//				addressList = new ArrayList<Inet4Address>();
//				addressList.add(0,source);
//				addressList.add(1,dst);
//
//				//Link Local Remote Identifiers
//				ArrayList<Long> localRemoteIfList =null;
//				localRemoteIfList= new ArrayList<Long> ();
//				localRemoteIfList.add(0,((InterDomainEdge) edge).getSrc_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier());
//				localRemoteIfList.add(0,((InterDomainEdge) edge).getDst_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier());
//
//				//MPLS
//				float maximumBandwidth = 0; 
//				float[] unreservedBandwidth = null;
//				float maximumReservableBandwidth = 0; 	
//				//GMPLS
//				AvailableLabels availableLabels = null;
//				MF_OTPAttribTLV mfOTP = null;
//
//				int metric = 0;
//
//				TE_Information te_info = ((InterDomainEdge) edge).getTE_info();
//				if (te_info != null){
//					if (te_info.getLinkLocalRemoteIdentifiers() != null){
//
//					}
//					//MPLS
//					if (te_info.getMaximumBandwidth() != null) {
//						maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
//					}
//					if (te_info.getUnreservedBandwidth() != null)
//						unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth();
//					if (te_info.getMaximumReservableBandwidth() != null)
//						maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
//					//GMPLS
//					if (te_info.getAvailableLabels() != null)
//						availableLabels = te_info.getAvailableLabels();
//					if(te_info.getDefaultTEMetric()!=null){
//						metric = (int) te_info.getDefaultTEMetric().getLinkMetric();
//						log.info("Metric en el metodo sendLinkNLRI es: " + metric);
//					}
//					if(te_info.getMfOTF()!=null){
//						mfOTP =  te_info.getMfOTF();
//					}
//
//				}else{
//					log.info("TE_Info es null");
//				}
//				ArrayList<Inet4Address> domainList = new ArrayList<Inet4Address>(2);
//				//FIXME: chequear
//				domainList.add((Inet4Address)edge.getDomain_src_router());
//				domainList.add((Inet4Address)edge.getDomain_dst_router());
//
//				//BGP4Update update = createMsgUpdateLinkNLRI(addressList,localRemoteIfList, lanID,   maximumBandwidth, unreservedBandwidth,  maximumReservableBandwidth ,  availableLabels, metric, domainList, false, mfOTP);
//				log.fine("Update message Created");	
//				//sendMessage(update);				


