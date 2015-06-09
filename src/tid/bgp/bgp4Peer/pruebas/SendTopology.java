package tid.bgp.bgp4Peer.pruebas;

import java.io.UnsupportedEncodingException;
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
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.SidLabelNodeAttribTLV;
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
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.LocalInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.RemoteInterfaceIPAddress;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import tid.bgp.bgp4Peer.bgp4session.GenericBGP4Session;
import tid.pce.tedb.DomainTEDB;
import tid.pce.tedb.InterDomainEdge;
import tid.pce.tedb.IntraDomainEdge;
import tid.pce.tedb.Node_Info;
import tid.pce.tedb.SimpleTEDB;
import tid.pce.tedb.TE_Information;

/**
 * Class to send periodically the topology. It sends the topology to the active BGP4 sessions.
 * @author pac
 *
 */
public class SendTopology implements Runnable {

	//TEDB de lectura
	private DomainTEDB domainTedb;

	private boolean sendTopology;
	private BGP4SessionsInformation bgp4SessionsInformation;
	private Logger log;
	private int instanceId=0;
	private boolean sendIntraDomainLinks=false;
	public SendTopology(){
		log = Logger.getLogger("BGP4Parser");
	}

	public void configure(DomainTEDB domainTedb,BGP4SessionsInformation bgp4SessionsInformation,boolean sendTopology,int instanceId,boolean sendIntraDomainLinks){
		this.domainTedb=domainTedb;
		this.bgp4SessionsInformation=bgp4SessionsInformation;
		this.sendTopology= sendTopology;
		this.instanceId = instanceId;
		this.sendIntraDomainLinks=sendIntraDomainLinks;
	}

	/**
	 * Function to send the topology database.
	 */

	/**
	 *  public void run(){	
		if (sendTopology){
			log.info("Sending topology Cambio");
			//Esperar hasta que haya sesiones
			if (!(bgp4SessionsInformation.getSessionList().isEmpty())){
				 Send Link NLRI for each link

				sendLinkNLRI(domainTedb.getInterDomainLinks());//Interdomain Links
				if (sendIntraDomainLinks){//Intradomain Links
					/Send Nodes (Node NLRI for each node) 				
					sendLinkNLRI(domainTedb.getIntraDomainLinks());
					}
				else{log.info("send intra "+sendIntraDomainLinks);}
			}
		}

	}
	 */

	public void run(){	
		if (sendTopology){
			log.info("Sending topology");
			//Esperar hasta que haya sesiones
			if (!(bgp4SessionsInformation.getSessionList().isEmpty())){
				sendLinkNLRI(((SimpleTEDB)domainTedb).getInterDomainLinks());//Interdomain Links
				if (sendIntraDomainLinks){//Intradomain Links
					/* Send Link NLRI for each link */
					sendLinkNLRI(((SimpleTEDB)domainTedb).getNetworkGraph().edgeSet());
				}
				sendNodeNLRI(((SimpleTEDB)domainTedb).getNetworkGraph().vertexSet(), ((SimpleTEDB) domainTedb).getNodeTable());
			}
		}

	}
	/**
	 * This function sends a BGP4 update message (encoded in a NodeNLRI) for each node in the set 
	 * @param vertexIt
	 */
	private void sendNodeNLRI(Set<Object> vertexSet, Hashtable<Inet4Address , Node_Info> NodeTable){
		Iterator<Object> vertexIt = vertexSet.iterator();	
		//Enviamos primero los nodos. Un Node NLRI por cada nodo.
		while (vertexIt.hasNext()){		
			Inet4Address node = (Inet4Address)vertexIt.next();
			Node_Info node_info = NodeTable.get(node);
			log.info("Sending node: ("+node+")");
			//Mandamos NodeNLRI
			BGP4Update update = createMsgUpdateNodeNLRI(node_info);
			sendMessage(update);	

		}
	}
	/**
	 * This function sends a BGP4 update message (encoded in a LinkNLRI) for each link in the list
	 * @param interdomainLinks
	 */
	private void sendLinkNLRI(LinkedList<InterDomainEdge> interdomainLinks){
		System.out.print("Los links son:"+interdomainLinks);
		if (true){
			int lanID = 1; ///INVENTADOO
			ArrayList<Inet4Address> addressList = new ArrayList<Inet4Address>();
			Iterator<InterDomainEdge> edgeIt = interdomainLinks.iterator();
			while (edgeIt.hasNext()){

				InterDomainEdge edge = edgeIt.next();

				Inet4Address source = (Inet4Address)edge.getSrc_router_id();
				Inet4Address dst = (Inet4Address)edge.getDst_router_id();
				log.info("Sending: ("+source.toString() +","+dst.toString()+")");
				addressList = new ArrayList<Inet4Address>();
				addressList.add(0,source);
				addressList.add(1,dst);

				//Link Local Remote Identifiers
				ArrayList<Long> localRemoteIfList =null;
				localRemoteIfList= new ArrayList<Long> ();
				localRemoteIfList.add(0,((InterDomainEdge) edge).getSrc_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier());
				localRemoteIfList.add(0,((InterDomainEdge) edge).getDst_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier());

				//MPLS
				float maximumBandwidth = 0; 
				float[] unreservedBandwidth = null;
				float maximumReservableBandwidth = 0; 	
				//GMPLS
				AvailableLabels availableLabels = null;

				int metric = 0;

				TE_Information te_info = ((InterDomainEdge) edge).getTE_info();
				if (te_info != null){
					if (te_info.getLinkLocalRemoteIdentifiers() != null){

					}
					//MPLS
					if (te_info.getMaximumBandwidth() != null) {
						maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
					}
					if (te_info.getUnreservedBandwidth() != null)
						unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth();
					if (te_info.getMaximumReservableBandwidth() != null)
						maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
					//GMPLS
					if (te_info.getAvailableLabels() != null)
						availableLabels = te_info.getAvailableLabels();
					if(te_info.getDefaultTEMetric()!=null){
						metric = (int) te_info.getDefaultTEMetric().getLinkMetric();
					}

				}else{
					log.info("TE_Info es null");
				}

				/**
				 * try{
			domainList.add(edge.getLocal_Node_Info().getAs_number());
			domainList.add(edge.getRemote_Node_Info().getAs_number());
			}catch(Exception e){
				e.printStackTrace();
			}
				 */
				ArrayList<Inet4Address> domainList = new ArrayList<Inet4Address>(2);								try{
					domainList.add( domainTedb.getReachabilityEntry().getDomainId());
					domainList.add((Inet4Address)edge.getDomain_dst_router());
				}catch(Exception e){
					e.printStackTrace();
				}

				BGP4Update update = createMsgUpdateLinkNLRI(addressList,localRemoteIfList, lanID,   maximumBandwidth, unreservedBandwidth,  maximumReservableBandwidth ,  availableLabels, metric, domainList, false);
				log.info("Update message Created");	
				sendMessage(update);				
			}
		}

	}
	/**
	 * This function sends a BGP4 update message (encoded in a LinkNLRI) for each link in the set
	 * @param edgeIt
	 */
	private void sendLinkNLRI(Set<IntraDomainEdge> edgeSet){
		int lanID = 1; ///INVENTADOO
		ArrayList<Inet4Address> addressList = new ArrayList<Inet4Address>();
		Iterator<IntraDomainEdge> edgeIt = edgeSet.iterator();	
		while (edgeIt.hasNext()){

			IntraDomainEdge edge = edgeIt.next();
			Inet4Address source = (Inet4Address)edge.getSource();
			Inet4Address dst = (Inet4Address)edge.getTarget();
			log.info("Sending: ("+source.toString() +","+dst.toString()+")");
			addressList = new ArrayList<Inet4Address>();
			addressList.add(0,source);
			addressList.add(1,dst);
			//Link Local Remote Identifiers
			ArrayList<Long> localRemoteIfList =null;
			localRemoteIfList= new ArrayList<Long> ();
			localRemoteIfList.add(0,((IntraDomainEdge) edge).getSrc_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier());
			localRemoteIfList.add(1,((IntraDomainEdge) edge).getDst_if_id());//te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier());

			//MPLS
			float maximumBandwidth = 0; 
			float[] unreservedBandwidth = null;
			float maximumReservableBandwidth = 0; 
			int metric = 0;
			//GMPLS
			AvailableLabels availableLabels = null;


			TE_Information te_info = ((IntraDomainEdge) edge).getTE_info();
			if (te_info != null){
				if (te_info.getLinkLocalRemoteIdentifiers() != null){

				}
				//MPLS
				if (te_info.getMaximumBandwidth() != null) {
					maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
				}
				if (te_info.getUnreservedBandwidth() != null)
					unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth();
				if (te_info.getMaximumReservableBandwidth() != null)
					maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
				//GMPLS
				if (te_info.getAvailableLabels() != null){
					availableLabels = te_info.getAvailableLabels();
				}
				if(te_info.getDefaultTEMetric()!=null){
					metric = (int) te_info.getDefaultTEMetric().getLinkMetric();
				}
			}else{
				log.info("TE_Info es null");
			}
			ArrayList<Inet4Address> domainList = new ArrayList<Inet4Address>(2);

			try{
				domainList.add(edge.getLocal_Node_Info().getAs_number());
				domainList.add(edge.getRemote_Node_Info().getAs_number());
			}catch(Exception e){
				e.printStackTrace();
			}
			BGP4Update update = createMsgUpdateLinkNLRI(addressList,localRemoteIfList, lanID,   maximumBandwidth, unreservedBandwidth,  maximumReservableBandwidth ,  availableLabels, metric, domainList, true);
			update.setLearntFrom(edge.getLearntFrom());
			sendMessage(update);

		}

	}
	/**
	 * Function to send a BGP4 update message to the connected peers. 
	 * @param update
	 */
	private void sendMessage (BGP4Update update){

		Enumeration <GenericBGP4Session > sessions = bgp4SessionsInformation.getSessionList().elements();

		log.info("Sending a BGP4 update message:"+update.toString());
		while (sessions.hasMoreElements()){	
			log.info("Sending a BGP4 update message");
			GenericBGP4Session session = sessions.nextElement();
			String destination = session.getRemotePeerIP().getHostAddress();
			log.info("update learnt from:" + update.getLearntFrom());
			try{
				if (!destination.equals(update.getLearntFrom())){
					log.info("we send update to:" + destination);
					session.sendBGP4Message(update);
				}
				else
					log.info("destination " + destination + " and source of information " + update.getLearntFrom() + " are equal");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * This function create a BGP4 Message with NodeNLRI field
	 * @param addressList 
	 * @param node_info
	 * @return
	 */
	private  BGP4Update createMsgUpdateNodeNLRI(Node_Info node_info){
		BGP4Update update= new BGP4Update();	
		//Path Attributes
		ArrayList<PathAttribute> pathAttributes = update.getPathAttributes();
		//Origin
		OriginAttribute or = new OriginAttribute(); 
		or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_IGP);
		pathAttributes.add(or);

		//AS_PATH
		AS_Path_Attribute as_path = new AS_Path_Attribute();
		as_path.setType(PathAttributesTypeCode.PATH_ATTRIBUTE_ASPATH_AS_SEQUENCE);
		as_path.setNumberASes(1);
		as_path.setValue(65002);
		pathAttributes.add(as_path);

		//Node Attribute

		LinkStateAttribute  linkStateAttribute = new LinkStateAttribute();
		boolean linkStateNeeded=false;

		if (node_info.getSid()!=0){
			int sid = node_info.getSid();
			SidLabelNodeAttribTLV sidLabelTLV = new SidLabelNodeAttribTLV();
			sidLabelTLV.setSid(sid);
			linkStateAttribute.setSidLabelTLV(sidLabelTLV);			
			linkStateNeeded=true;
		}

		if (linkStateNeeded){
			log.info("Node Attribute added....");
			pathAttributes.add(linkStateAttribute);
		}

		//NLRI
		NodeNLRI nodeNLRI = new NodeNLRI();
		nodeNLRI.setProtocolID(ProtocolIDCodes.Unknown_Protocol_ID);				
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();

		//igp router id
		if(node_info.getIpv4AddressLocalNode()!=null){
			IGPRouterIDNodeDescriptorSubTLV igpRouterIDLNSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
			igpRouterIDLNSubTLV.setIpv4AddressOSPF(node_info.getIpv4AddressLocalNode());	
			igpRouterIDLNSubTLV.setIGP_router_id_type(IGPRouterIDNodeDescriptorSubTLV.IGP_ROUTER_ID_TYPE_OSPF_NON_PSEUDO);
			nodeDescriptorsSubTLVList.add(igpRouterIDLNSubTLV);
		}

		//as number
		if(node_info.getAs_number()!=null){
			AutonomousSystemNodeDescriptorSubTLV asNodeDescrSubTLV = new AutonomousSystemNodeDescriptorSubTLV();
			asNodeDescrSubTLV.setAS_ID(node_info.getAs_number());
			nodeDescriptorsSubTLVList.add(asNodeDescrSubTLV);
		}

		localNodeDescriptors.setNodeDescriptorsSubTLVList(nodeDescriptorsSubTLVList);
		nodeNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		log.info("Creamos el MP Reach Attribute");
		BGP_LS_MP_Reach_Attribute ra= new BGP_LS_MP_Reach_Attribute();
		log.info("Añadimos el Node NLRI");
		ra.setLsNLRI(nodeNLRI);
		pathAttributes.add(ra);
		update.setLearntFrom(node_info.getLearntFrom());
		return update;
	}

	/**
	 * Function to create a BGP4 update message with a link NRLI field. To send the links.
	 * 				
	 * @param addressList
	 * @param addressInterfaceList
	 * @param localRemoteIfList
	 * @param lanID
	 * @param maximumBandwidth
	 * @param unreservedBandwidth
	 * @param maximumReservableBandwidth
	 * @param availableLabels
	 * @param metric 
	 * @param domainList
	 * @param intradomain
	 * @return
	 */
	private BGP4Update createMsgUpdateLinkNLRI(ArrayList<Inet4Address> addressList,ArrayList<Long> localRemoteIfList,int lanID,  float maximumBandwidth, float[] unreservedBandwidth, float maximumReservableBandwidth , AvailableLabels availableLabels, int metric, ArrayList<Inet4Address> domainList, boolean intradomain ){
		BGP4Update update= new BGP4Update();	
		//1. Path Attributes
		log.info("Cogemos el Path Attributes");
		ArrayList<PathAttribute> pathAttributes = update.getPathAttributes();
		//1.1. Origin
		OriginAttribute or = new OriginAttribute(); 
		if (intradomain)
			or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_IGP);
		else
			or.setValue(PathAttributesTypeCode.PATH_ATTRIBUTE_ORIGIN_EGP);
		pathAttributes.add(or);	

		//1.2. AS-PATH
		AS_Path_Attribute as_path = new AS_Path_Attribute();
		as_path.setType(PathAttributesTypeCode.PATH_ATTRIBUTE_ASPATH_AS_SEQUENCE);
		as_path.setNumberASes(1);
		as_path.setValue(300);
		pathAttributes.add(as_path);


		//1.2. LINK-STATE
		boolean linkStateNeeded = false;
		LinkStateAttribute  linkStateAttribute = new LinkStateAttribute();
		//1.2.1. MaxReservableBandwidth
		if (maximumReservableBandwidth != 0){
			MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV = new MaxReservableBandwidthLinkAttribTLV();
			maxReservableBandwidthTLV.setMaximumReservableBandwidth(maximumReservableBandwidth);
			linkStateAttribute.setMaxReservableBandwidthTLV(maxReservableBandwidthTLV);
			linkStateNeeded=true;
		}
		//1.2.2. maxBandwidth
		if (maximumBandwidth != 0){
			MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV = new MaximumLinkBandwidthLinkAttribTLV();
			maximumLinkBandwidthTLV.setMaximumBandwidth(maximumBandwidth);
			linkStateAttribute.setMaximumLinkBandwidthTLV(maximumLinkBandwidthTLV);
			linkStateNeeded=true;
		}
		//1.2.3. unreservedBandwidth
		if (unreservedBandwidth != null){
			UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV = new UnreservedBandwidthLinkAttribTLV();
			unreservedBandwidthTLV.setUnreservedBandwidth(unreservedBandwidth);
			linkStateAttribute.setUnreservedBandwidthTLV(unreservedBandwidthTLV);
			linkStateNeeded=true;
		}
		//1.2.4. AvailableLabels
		if (availableLabels != null){
			log.info("Metemos Available labels");
			log.info("Available labels fields: "+availableLabels.getLabelSet().getNumLabels());
			AvailableLabels al = new AvailableLabels();

			BitmapLabelSet bl = new BitmapLabelSet();
			bl.setBytesBitmap(((BitmapLabelSet)availableLabels.getLabelSet()).getBytesBitMap());
			bl.setNumLabels(availableLabels.getLabelSet().getNumLabels());
			bl.setDwdmWavelengthLabel(((BitmapLabelSet)availableLabels.getLabelSet()).getDwdmWavelengthLabel());

			bl.setBytesBitmapReserved(((BitmapLabelSet)availableLabels.getLabelSet()).getBytesBitmapReserved());

			al.setLabelSet(bl);

			log.info("Campo setBytesBitmap: "+bl.getBytesBitMap()[0]);
			log.info("Campo setDwdmWavelengthLabel: "+bl.getDwdmWavelengthLabel());
			log.info("Campo setBytesBitmapReserved: "+bl.getBytesBitmapReserved()[0]);

			linkStateAttribute.setAvailableLabels(al);

			linkStateNeeded=true;
		}

		//1.2.5 metric
		if (metric != 0){
			DefaultTEMetricLinkAttribTLV defaultMetric = new DefaultTEMetricLinkAttribTLV();
			defaultMetric.setLinkMetric(metric);
			linkStateAttribute.setTEMetricTLV(defaultMetric);
			linkStateNeeded=true;
		}
		if (linkStateNeeded){
			log.info("Metemos linkStateAttribute");
			pathAttributes.add(linkStateAttribute);
		}

		//2. NLRI
		LinkNLRI linkNLRI = new LinkNLRI();
		linkNLRI.setProtocolID(ProtocolIDCodes.Unknown_Protocol_ID);
		linkNLRI.setInstanceIdentifier(instanceId);
		//2.1. Local Y Remote Descriptors
		LocalNodeDescriptorsTLV localNodeDescriptors = new LocalNodeDescriptorsTLV();
		RemoteNodeDescriptorsTLV remoteNodeDescriptors = new RemoteNodeDescriptorsTLV();
		ArrayList<NodeDescriptorsSubTLV> sourceDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();
		ArrayList<NodeDescriptorsSubTLV> dstDescriptorsSubTLVList = new ArrayList<NodeDescriptorsSubTLV>();

		//2.1.1. IPv4
		IGPRouterIDNodeDescriptorSubTLV igpRouterIDLNSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		igpRouterIDLNSubTLV.setIpv4AddressOSPF(addressList.get(0));	
		igpRouterIDLNSubTLV.setIGP_router_id_type(IGPRouterIDNodeDescriptorSubTLV.IGP_ROUTER_ID_TYPE_OSPF_NON_PSEUDO);
		sourceDescriptorsSubTLVList.add(igpRouterIDLNSubTLV);

		IGPRouterIDNodeDescriptorSubTLV igpRouterIDDNSubTLV = new IGPRouterIDNodeDescriptorSubTLV();
		igpRouterIDDNSubTLV.setIpv4AddressOSPF(addressList.get(1));	
		igpRouterIDDNSubTLV.setIGP_router_id_type(IGPRouterIDNodeDescriptorSubTLV.IGP_ROUTER_ID_TYPE_OSPF_NON_PSEUDO);
		dstDescriptorsSubTLVList.add(igpRouterIDDNSubTLV);

		//2.1.2. AS
		if (domainList != null){
			AutonomousSystemNodeDescriptorSubTLV as_local = new AutonomousSystemNodeDescriptorSubTLV();
			as_local.setAS_ID(domainList.get(0));
			sourceDescriptorsSubTLVList.add(as_local);
			AutonomousSystemNodeDescriptorSubTLV as_remote = new AutonomousSystemNodeDescriptorSubTLV();
			as_remote.setAS_ID(domainList.get(1));
			dstDescriptorsSubTLVList.add(as_remote);	
		}
		localNodeDescriptors.setNodeDescriptorsSubTLVList(sourceDescriptorsSubTLVList);
		remoteNodeDescriptors.setNodeDescriptorsSubTLVList(dstDescriptorsSubTLVList);
		linkNLRI.setLocalNodeDescriptors(localNodeDescriptors);
		linkNLRI.setRemoteNodeDescriptorsTLV(remoteNodeDescriptors);

		//2.2. Link NLRI TLVs 
		//2.2.1. Ipv4 interface and neighbour address
		IPv4InterfaceAddressLinkDescriptorsSubTLV ipv4InterfaceAddressTLV = new IPv4InterfaceAddressLinkDescriptorsSubTLV();
		IPv4NeighborAddressLinkDescriptorSubTLV ipv4NeighborAddressTLV = new IPv4NeighborAddressLinkDescriptorSubTLV();
		ipv4InterfaceAddressTLV.setIpv4Address(addressList.get(0));
		ipv4NeighborAddressTLV.setIpv4Address(addressList.get(1));
		linkNLRI.setIpv4InterfaceAddressTLV(ipv4InterfaceAddressTLV);
		linkNLRI.setIpv4NeighborAddressTLV(ipv4NeighborAddressTLV);

		//2.2.2. Link Local/Remote identifiers TLV
		if (localRemoteIfList !=  null){
			LinkLocalRemoteIdentifiersLinkDescriptorSubTLV linkIdentifiersTLV = new LinkLocalRemoteIdentifiersLinkDescriptorSubTLV();
			linkIdentifiersTLV.setLinkLocalIdentifier(localRemoteIfList.get(0));
			linkIdentifiersTLV.setLinkRemoteIdentifier(localRemoteIfList.get(1));
			linkNLRI.setLinkIdentifiersTLV(linkIdentifiersTLV);
		}
		log.info("Creamos el Reach Attribute");
		BGP_LS_MP_Reach_Attribute ra= new BGP_LS_MP_Reach_Attribute();
		log.info("Añadimos el Link NLRI");
		ra.setLsNLRI(linkNLRI);
		pathAttributes.add(ra);		
		return update;
	}
	/**
	 * Funcion que crea un mensaje OSPF inventado desde cero.
	 * Solo se meten en el mensaje los campos:
	 * - source
	 * - destino
	 * - maximun bandwithd
	 */
	public static OSPFv2LinkStateUpdatePacket createMsgOSPF(){
		Inet4Address src = null;
		Inet4Address dst = null;
		MaximumBandwidth maximumBandwidth = new MaximumBandwidth();
		maximumBandwidth.setMaximumBandwidth(100);
		UnreservedBandwidth unreservedBandwidth = new UnreservedBandwidth();
		float[] unReservedB = new float[8];
		unReservedB[0]=18309;
		unReservedB[1]=130;
		unreservedBandwidth.setUnreservedBandwidth(unReservedB);
		try {
			src = (Inet4Address) Inet4Address.getByName( "179.123.123.123");
			dst = (Inet4Address) Inet4Address.getByName( "179.123.123.111");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OSPFv2LinkStateUpdatePacket ospfv2Packet = new OSPFv2LinkStateUpdatePacket();
		ospfv2Packet.setRouterID(src);
		LinkedList<LSA> lsaList = new LinkedList<LSA>();
		OSPFTEv2LSA lsa = new OSPFTEv2LSA();
		LinkTLV linkTLV=new LinkTLV();
		lsa.setLinkTLV(linkTLV);

		linkTLV.setMaximumBandwidth(maximumBandwidth);
		linkTLV.setUnreservedBandwidth(unreservedBandwidth);
		LocalInterfaceIPAddress localInterfaceIPAddress= new LocalInterfaceIPAddress();
		LinkedList<Inet4Address> lista =localInterfaceIPAddress.getLocalInterfaceIPAddressList();
		lista.add(src);
		linkTLV.setLocalInterfaceIPAddress(localInterfaceIPAddress);
		RemoteInterfaceIPAddress remoteInterfaceIPAddress= new RemoteInterfaceIPAddress();
		LinkedList<Inet4Address> listar = remoteInterfaceIPAddress.getRemoteInterfaceIPAddressList();
		listar.add(dst);
		linkTLV.setRemoteInterfaceIPAddress(remoteInterfaceIPAddress);
		LinkID linkID = new LinkID();
		linkID.setLinkID(dst);
		linkTLV.setLinkID(linkID);
		//		if (edge.getTE_info().getAvailableLabels() != null){
		//			linkTLV.setAvailableLabels(edge.getTE_info().getAvailableLabels());			
		//		}
		lsaList.add(lsa);

		ospfv2Packet.setLSAlist(lsaList);
		return ospfv2Packet;
	}

	/**
	 * Funci�n que decodifica un mensaje OSPFv2LinkStateUpdatePacket creando con los campos extraidos un mensaje BGP4 update.
	 * @param ospfv2Packet
	 * @return 
	 */
	public BGP4Update decodificarMsgOSPF(OSPFv2LinkStateUpdatePacket ospfv2Packet){
		boolean intradomain = true;
		Inet4Address localIPAddress = ospfv2Packet.getRouterID();
		Inet4Address remoteIPAddress = null;
		long localInterfaceIPAddress = -1;
		long remoteInterfaceIPAddress = -1;
		Inet4Address remoteASNumber = null;
		LinkedList<LSA> lsaList;
		OSPFTEv2LSA lsa;
		//GMPLS Parameter
		AvailableLabels al = null;
		//MPLS Parameter
		float maxBandwidth = 0;
		float[] unBandwidth = null;
		float maximumReservableBandwidth=0;

		lsaList = ((OSPFv2LinkStateUpdatePacket)ospfv2Packet).getLSAlist();
		for (int i =0;i< lsaList.size();i++){
			if (lsaList.get(i).getLStype() == LSATypes.TYPE_10_OPAQUE_LSA){
				lsa=(OSPFTEv2LSA)lsaList.get(i);
				log.info("Starting to process LSA");

				LinkTLV linkTLV = lsa.getLinkTLV();
				if (linkTLV!=null){
					//Local and Remote interface IP address
					remoteIPAddress = linkTLV.getLinkID().getLinkID();					
					log.info("Remote IP Address: "+remoteIPAddress);	
					localInterfaceIPAddress = linkTLV.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
					log.info("Local Interface: "+localInterfaceIPAddress);
					remoteInterfaceIPAddress =linkTLV.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();					
					log.info("Remote Interface: "+remoteInterfaceIPAddress);

					//MPLS fields
					if (linkTLV.getMaximumBandwidth() != null)
						maxBandwidth = linkTLV.getMaximumBandwidth().getMaximumBandwidth();					
					if (linkTLV.getUnreservedBandwidth() != null)
						unBandwidth = linkTLV.getUnreservedBandwidth().getUnreservedBandwidth();					
					if (linkTLV.getMaximumReservableBandwidth()!= null)
						maximumReservableBandwidth = linkTLV.getMaximumReservableBandwidth().getMaximumReservableBandwidth();

					//GMPLS
					al = linkTLV.getAvailableLabels(); 
					//FIXME: Como ver si es inter o intra domain
					if (linkTLV.getRemoteASNumber() != null)
						remoteASNumber = linkTLV.getRemoteASNumber().getRemoteASNumber();

				}
			}

		}
		//Create the address list
		ArrayList<Inet4Address> addressList = new ArrayList<Inet4Address>();
		addressList.add(localIPAddress);
		addressList.add(remoteIPAddress);
		//Create the interface list
		ArrayList<Long> localRemoteIfList = new ArrayList<Long>();
		localRemoteIfList.add(localInterfaceIPAddress);
		localRemoteIfList.add(remoteInterfaceIPAddress);


		//Create the domain List
		ArrayList<Inet4Address> domainList = new ArrayList<Inet4Address>(2);

		return createMsgUpdateLinkNLRI(addressList,localRemoteIfList,23,maxBandwidth,unBandwidth,maximumReservableBandwidth,al, 0, domainList, intradomain);

	}

	public void setTedb(DomainTEDB tedb) {
		this.domainTedb = tedb;
	}


	public boolean isSendTopology() {
		return sendTopology;
	}


	public void setSendTopology(boolean sendTopology) {
		this.sendTopology = sendTopology;
	}


	public BGP4SessionsInformation getBgp4SessionsInformation() {
		return bgp4SessionsInformation;
	}


	public void setBgp4SessionsInformation(
			BGP4SessionsInformation bgp4SessionsInformation) {
		this.bgp4SessionsInformation = bgp4SessionsInformation;
	}


	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}


}
