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

import redis.clients.jedis.Jedis;
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
	
	//TEDBs 
	 private Hashtable<Inet4Address,SimpleTEDB> intraTEDBs;
	
	// Multi-domain TEDB to redistribute Multi-domain Topology
	private MultiDomainTEDB multiDomainTEDB;

	private boolean writeTopology;

	private Logger log;
	
	Jedis jedis;
	
	
    


	
	
	RedisDatabaseHandler rdh;
	
	public SaveTopologyinDB(){
		log = Logger.getLogger("BGP4Parser");
		 rdh= new RedisDatabaseHandler();
	}

	public void configure( Hashtable<Inet4Address,SimpleTEDB> intraTEDBs,MultiDomainTEDB multiTED,  boolean writeTopology, String host, int port){
		this.intraTEDBs=intraTEDBs;
		this.writeTopology= writeTopology;
		this.multiDomainTEDB=multiTED;
		//rdh.setHost(host);
		//rdh.setPort(port);
		
		jedis = new Jedis(host,port);
		jedis.connect();
			
	}

	/**
	 * Function to send the topology database.
	 */


	public void run(){	
		log.info("Going to save Topology in DB");
		try {
		if (writeTopology){
			if (multiDomainTEDB!=null){
					log.info("save Multi-Domain TEDB");
					writeLinkDBInter( multiDomainTEDB.getInterDomainLinks());
				}
				else {
					log.info("save form TEDB");
					Enumeration<SimpleTEDB> iter = intraTEDBs.elements();
					while (iter.hasMoreElements()){
						writeLinkDBInter( iter.nextElement().getInterDomainLinks());
					}
				}			
				
					log.info("sendIntraDomainLinks activated");
					Enumeration<Inet4Address> iter = intraTEDBs.keys();
					while (iter.hasMoreElements()){						
						Inet4Address domainID = iter.nextElement();
						log.info("Sending TED from domain "+domainID);
						SimpleTEDB ted=intraTEDBs.get(domainID);
						writeLinkDB( ted.getNetworkGraph().edgeSet(),domainID);
					}
					
							
		}
		}catch (Exception e) {
			e.printStackTrace();
			log.severe("PROBLEM SENDING TOPOLOGY: "+e.toString());
		}

	}

	/**
	 * This function write a BGP4 update message in Data Base for each link in the list
	 * @param intradomainLinks
	 */
	private void writeLinkDB(Set<IntraDomainEdge> intradomainLinks, Inet4Address domainID){
		
			Iterator<IntraDomainEdge> edgeIt = intradomainLinks.iterator();
			
			while (edgeIt.hasNext()){

				IntraDomainEdge edge = edgeIt.next();
				
				DatabaseControlSimplifiedLSA dcsl =createSimplifiedLSA(edge); 
				String jsonLSA = dcsl.logJsonSimplifiedLSA();
				//rdh.write("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(),jsonLSA);		
				
				if (jedis == null)
					log.info("JEDIS IS NULL");
				
				String ret = jedis.set("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(), jsonLSA);
			}

	}
	
	private DatabaseControlSimplifiedLSA createSimplifiedLSA(IntraDomainEdge edge){
		DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
		
		//Inet4Address source = (Inet4Address)edge.getSrc_router_id();
		//Inet4Address dst = (Inet4Address)edge.getDst_router_id();
		
		Inet4Address source = (Inet4Address)edge.getSource();
		dcsl.setAdvertisingRouter(source);
		Inet4Address dst = (Inet4Address)edge.getTarget();
		dcsl.setLinkId(dst);
		
		TE_Information te_info = ((IntraDomainEdge) edge).getTE_info();
		
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
				dcsl.unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth()[0];
			}
					
			if (te_info.getMaximumReservableBandwidth() != null)
				dcsl.maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
			
			String ret = "";
			
			if (te_info.getAvailableLabels() != null){
				
				if (te_info.getAvailableLabels().getLabelSet() != null){
					
					ret=ret+" Bitmap: {";
					
					for (int i=0;i<te_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					
						ret = ret+ (te_info.isWavelengthFree(i)?"0":"1");		
					}
					
					ret=ret+"}";
					
					dcsl.setBitmapLabelSet(ret);
				
				}
			}
		}
		
		return dcsl;
	
	}
	
	
	/**
	 * This function write a BGP4 update message in Data Base for each link in the list
	 * @param intradomainLinks
	 */
	private void writeLinkDBInter(LinkedList<InterDomainEdge> interdomainLinks){
		
			Iterator<InterDomainEdge> edgeIt = interdomainLinks.iterator();
			
			while (edgeIt.hasNext()){

				InterDomainEdge edge = edgeIt.next();
				
				DatabaseControlSimplifiedLSA dcsl =createSimplifiedLSAInter(edge); 
				String jsonLSA = dcsl.logJsonSimplifiedLSA();
				//rdh.write("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(),jsonLSA);		
				String ret = jedis.set("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(), jsonLSA);
			}

	}
	
	private DatabaseControlSimplifiedLSA createSimplifiedLSAInter(InterDomainEdge edge){
		DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
		
		//Inet4Address source = (Inet4Address)edge.getSrc_router_id();
		//Inet4Address dst = (Inet4Address)edge.getDst_router_id();
		
		Inet4Address source = (Inet4Address)edge.getSource();
		dcsl.setAdvertisingRouter(source);
		Inet4Address dst = (Inet4Address)edge.getTarget();
		dcsl.setLinkId(dst);
		
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
				dcsl.unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth()[0];
			}
					
			if (te_info.getMaximumReservableBandwidth() != null)
				dcsl.maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
			
			String ret = "";
			
			if (te_info.getAvailableLabels() != null){
				
				if (te_info.getAvailableLabels().getLabelSet() != null){
					
					ret=ret+" Bitmap: {";
					
					for (int i=0;i<te_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					
						ret = ret+ (te_info.isWavelengthFree(i)?"0":"1");		
					}
					
					ret=ret+"}";
					
					dcsl.setBitmapLabelSet(ret);
				
				}
			}
		}
		
		return dcsl;
	
	}

	public MultiDomainTEDB getMultiDomainTEDB() {
		return multiDomainTEDB;
	}

	public void setMultiDomainTEDB(MultiDomainTEDB multiDomainTEDB) {
		this.multiDomainTEDB = multiDomainTEDB;
	}
	
	
}
				
			


