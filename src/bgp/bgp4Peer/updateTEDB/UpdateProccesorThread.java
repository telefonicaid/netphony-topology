package tid.bgp.bgp4Peer.updateTEDB;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import tid.bgp.bgp4.messages.BGP4Update;
import tid.bgp.bgp4.update.fields.LinkNLRI;
import tid.bgp.bgp4.update.fields.LinkStateNLRI;
import tid.bgp.bgp4.update.fields.NLRITypes;
import tid.bgp.bgp4.update.fields.PathAttribute;
import tid.bgp.bgp4.update.fields.PrefixNLRI;
import tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumReservableBandwidth;
import tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import tid.pce.tedb.IntraDomainEdge;
import tid.pce.tedb.MultiDomainTEDB;
import tid.pce.tedb.SSONInformation;
import tid.pce.tedb.SimpleTEDB;
import tid.pce.tedb.TE_Information;
import tid.pce.tedb.WSONInformation;
import tid.bgp.bgp4.update.fields.NodeNLRI;
import tid.bgp.bgp4.update.fields.pathAttributes.AFICodes;
import tid.bgp.bgp4.update.fields.pathAttributes.BGP_LS_MP_Reach_Attribute;
import tid.bgp.bgp4.update.fields.pathAttributes.LinkStateAttribute;
import tid.bgp.bgp4.update.fields.pathAttributes.MP_Reach_Attribute;
import tid.bgp.bgp4.update.fields.pathAttributes.PathAttributesTypeCode;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.AdministrativeGroupLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.DefaultTEMetricLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IGPFlagBitsPrefixAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IPv4RouterIDLocalNodeLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IPv4RouterIDRemoteNodeLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.IS_IS_AreaIdentifierNodeAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.LinkProtectionTypeLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MetricLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.NodeFlagBitsNodeAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.NodeNameNodeAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.OSPFForwardingAddressPrefixAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.PrefixMetricPrefixAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.RouteTagPrefixAttribTLV;
import tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.UnreservedBandwidthLinkAttribTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AreaIDNodeDescriptorSubTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AutonomousSystemNodeDescriptorSubTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.BGPLSIdentifierNodeDescriptorSubTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.IGPRouterIDNodeDescriptorSubTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLV;
import tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLVTypes;
import tid.bgp.bgp4Peer.tedb.IntraTEDBS;
/**
 * This class process the update messages updating the TEDB.
 * 
 *  WARNING: it is suppose to be a SimpleTEDB!!! It is not finished yet.
 * @author pac
 *
 */
public class UpdateProccesorThread extends Thread {
	/**
	 * Parameter to run the class if it is true
	 */
	private boolean running;
	/**
	 * Queue which stores the BGP4 update messages to be read and process
	 */
	private LinkedBlockingQueue<BGP4Update> updateList;
	
	private AvailableLabels availableLabels;
	/**
	 * Logger
	 */
	private Logger log;
	/**
	 * Topology database for interDomain Links which will be updated.
	 */
	private MultiDomainTEDB multiTedb;
	/**
	 * Topology database for intradomain Links. It owns several domains and.
	 */
	private IntraTEDBS intraTEDB;
	
	private LinkedList<UpdateLink> updateLinks;
	
	private SimpleTEDB simpleTEDB;
	public UpdateProccesorThread(LinkedBlockingQueue<BGP4Update> updateList,MultiDomainTEDB multiTedb ,SimpleTEDB simpleTEDB /*, IntraTEDBS intraTEDB*/){
		running=true;
		this.updateList=updateList;
		this.multiTedb = multiTedb;
		log=Logger.getLogger("BGP4Server");
		log.info("In constructor::: simpleTEDB::"+simpleTEDB);
		this.simpleTEDB=simpleTEDB;
		this.availableLabels= new AvailableLabels();
		this.updateLinks=new LinkedList<UpdateLink>();
	}
	public void run(){	
		BGP4Update updateMsg;
		while (running) {
			try {
				updateMsg= updateList.take();
				log.info("Update Procesor Thread Reading the message: \n"+ updateMsg.toString());
				ArrayList<PathAttribute> pathAttributeList = updateMsg.getPathAttributes();
				PathAttribute att;
				
				/** LINK ATTRIBUTE TLVs */
				MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV= null;
				MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV= null;
				UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV= null;
				AdministrativeGroupLinkAttribTLV administrativeGroupTLV = null;
				LinkProtectionTypeLinkAttribTLV linkProtectionTLV = null;
				MetricLinkAttribTLV metricTLV = null;
				IPv4RouterIDLocalNodeLinkAttribTLV IPv4RouterIDLocalNodeLATLV = null;
				IPv4RouterIDRemoteNodeLinkAttribTLV IPv4RouterIDRemoteNodeLATLV = null;
				DefaultTEMetricLinkAttribTLV TEMetricTLV = null;
				
				/** NODE ATTRIBUTE TLVs */
				NodeFlagBitsNodeAttribTLV nodeFlagBitsTLV = null;
				NodeNameNodeAttribTLV nodeNameTLV = null;
				IS_IS_AreaIdentifierNodeAttribTLV areaIDTLV = null;
				
				/**PREFIX ATTRIBUTE TLVs */
				IGPFlagBitsPrefixAttribTLV igpFlagBitsTLV = null;
				RouteTagPrefixAttribTLV routeTagTLV = null;
				PrefixMetricPrefixAttribTLV prefixMetricTLV = null;
				OSPFForwardingAddressPrefixAttribTLV OSPFForwardingAddrTLV = null;
				
				if (pathAttributeList != null){
					log.info("There is path attribute List");
				for (int i=0;i<pathAttributeList.size();i++){
					att = pathAttributeList.get(i);
					log.info("Taking the first element of the path att list");
					int typeCode = att.getTypeCode();
					log.info("Type Code is "+ typeCode);
					switch (typeCode){	
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_ORIGIN:		
						log.info("ORIGIN Attribute found");	
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_LINKSTATE:
						log.info("Link State Attribute found");		
						fillAttributeLinkState((LinkStateAttribute) att, maximumLinkBandwidthTLV, maxReservableBandwidthTLV,unreservedBandwidthTLV, administrativeGroupTLV, linkProtectionTLV, metricTLV, IPv4RouterIDLocalNodeLATLV, IPv4RouterIDRemoteNodeLATLV, TEMetricTLV, nodeFlagBitsTLV, nodeNameTLV, areaIDTLV,
								igpFlagBitsTLV, routeTagTLV, prefixMetricTLV, OSPFForwardingAddrTLV);
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_ASPATH:
						log.info("AS_SET Attribute found");		
						break;
					
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_NEXTHOP:
						log.info("NEXT HOP Attribute found");
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_MULTI_EXIT_DISC:
						log.info("MULTI_EXIT_DISC Attribute found");
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_LOCAL_PREF:
						log.info("LOCAL_PREF Attribute found");
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_ATOMIC_AGGREGATE:
						log.info("ATOMIC_AGGREGATE Attribute found");
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_AGGREGATOR:
						log.info("AGGREGATOR Attribute found");
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_MP_REACH_NLRI:
						log.info("PATH_ATTRIBUTE_TYPECODE_MP_REACH_NLRI Attribute found");
						int afi;
						afi = ((MP_Reach_Attribute)att).getAddressFamilyIdentifier();
						if (afi == AFICodes.AFI_BGP_LS){
							LinkStateNLRI nlri = (LinkStateNLRI) ((BGP_LS_MP_Reach_Attribute)att).getLsNLRI();
							int nlriType =  nlri.getNLRIType();
							switch (nlriType){					
							case NLRITypes.Link_NLRI:
								log.info("Link NLRI found");//AQUI HABRIA QUE PASAR TODOS LOS LINK ATTRIBUTES
								fillLinkNLRI((LinkNLRI)(nlri), maximumLinkBandwidthTLV, maxReservableBandwidthTLV,unreservedBandwidthTLV);					
								break;
							case NLRITypes.Node_NLRI:
								log.info("Node NLRI found");//AQUI TODOS LOS NODE ATTRIBUTES
								 fillNodeNLRI((NodeNLRI)(nlri),nodeFlagBitsTLV, nodeNameTLV, areaIDTLV);
								break;
							case NLRITypes.Prefix_v4_NLRI://AQUI TODOS LOS PREFIX ATTRIBUTES
								log.info("Prefix NLRI found");
								fillPrefixNLRI((PrefixNLRI)nlri, igpFlagBitsTLV, OSPFForwardingAddrTLV, prefixMetricTLV, routeTagTLV);
							default:
								log.finest("Attribute Code unknown");
							}
						}
						break;
					default:
						log.finest("Attribute Code unknown");
						}
					}
				}
				
				

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	private void fillPrefixNLRI(PrefixNLRI nlri, IGPFlagBitsPrefixAttribTLV igpFlagBitsTLV, OSPFForwardingAddressPrefixAttribTLV oSPFForwardingAddrTLV, PrefixMetricPrefixAttribTLV prefixMetricTLV, RouteTagPrefixAttribTLV routeTagTLV) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Function which process the attribute link State. It updates the fields passed by argument. 
	 * @param lsAtt
	 * @param maximumLinkBandwidthTLV
	 * @param maxReservableBandwidthTLV
	 * @param unreservedBandwidthTLV
	 * @param nodeNameTLV 
	 * @param nodeFlagBitsTLV 
	 * @param tEMetricTLV 
	 * @param iPv4RouterIDRemoteNodeLATLV 
	 * @param iPv4RouterIDLocalNodeLATLV 
	 * @param metricTLV 
	 * @param linkProtectionTLV 
	 * @param administrativeGroupTLV 
	 * @param areaIDTLV 
	 * @param oSPFRouteTypeTLV 
	 * @param iPReachabiltyTLV 
	 * @param availableLabels
	 */
	private void fillAttributeLinkState(LinkStateAttribute lsAtt,MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV ,MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV,UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV, AdministrativeGroupLinkAttribTLV administrativeGroupTLV, LinkProtectionTypeLinkAttribTLV linkProtectionTLV, MetricLinkAttribTLV metricTLV, IPv4RouterIDLocalNodeLinkAttribTLV iPv4RouterIDLocalNodeLATLV, IPv4RouterIDRemoteNodeLinkAttribTLV iPv4RouterIDRemoteNodeLATLV, DefaultTEMetricLinkAttribTLV tEMetricTLV, NodeFlagBitsNodeAttribTLV nodeFlagBitsTLV, NodeNameNodeAttribTLV nodeNameTLV, IS_IS_AreaIdentifierNodeAttribTLV areaIDTLV, IGPFlagBitsPrefixAttribTLV igpFlagBitsTLV,
	RouteTagPrefixAttribTLV routeTagTLV,PrefixMetricPrefixAttribTLV prefixMetricTLV,OSPFForwardingAddressPrefixAttribTLV OSPFForwardingAddrTLV){

		if (lsAtt.getMaximumLinkBandwidthTLV() != null)
			maximumLinkBandwidthTLV = lsAtt.getMaximumLinkBandwidthTLV();
		if (lsAtt.getMaxReservableBandwidthTLV() != null)
			maxReservableBandwidthTLV = lsAtt.getMaxReservableBandwidthTLV();
		if (lsAtt.getUnreservedBandwidthTLV() != null)
			unreservedBandwidthTLV = lsAtt.getUnreservedBandwidthTLV();
		if(lsAtt.getAdministrativeGroupTLV() != null)
			administrativeGroupTLV = lsAtt.getAdministrativeGroupTLV();
		if(lsAtt.getLinkProtectionTLV() != null)
			linkProtectionTLV = lsAtt.getLinkProtectionTLV();
		if(lsAtt.getIPv4RouterIDLocalNodeLATLV()!= null)
			iPv4RouterIDLocalNodeLATLV = lsAtt.getIPv4RouterIDLocalNodeLATLV();
		if(lsAtt.getIPv4RouterIDRemoteNodeLATLV()!=null)
			iPv4RouterIDRemoteNodeLATLV = lsAtt.getIPv4RouterIDRemoteNodeLATLV();
		if(lsAtt.getMetricTLV() != null)
			metricTLV = lsAtt.getMetricTLV();
		if(lsAtt.getTEMetricTLV()!=null)
			tEMetricTLV = lsAtt.getTEMetricTLV();
		if(lsAtt.getNodeFlagBitsTLV()!= null)
			nodeFlagBitsTLV = lsAtt.getNodeFlagBitsTLV();
		if(lsAtt.getNodeNameTLV() != null)
			nodeNameTLV = lsAtt.getNodeNameTLV();
		if(lsAtt.getAreaIDTLV() != null)
			areaIDTLV = lsAtt.getAreaIDTLV();
		if(lsAtt.getIgpFlagBitsTLV() != null)
			 igpFlagBitsTLV= lsAtt.getIgpFlagBitsTLV();
		if(lsAtt.getRouteTagTLV() != null)
			routeTagTLV = lsAtt.getRouteTagTLV();
		if(lsAtt.getOSPFForwardingAddrTLV() != null)
			OSPFForwardingAddrTLV = lsAtt.getOSPFForwardingAddrTLV();
		/**if(lsAtt.getIPv4RouterIDLocalNodeNATLV()!=null)
			IPv4RouterIDLocalNodeNodeAttribTLV = lsAtt.getIPv4RouterIDLocalNodeNATLV();*/
		/**if(lsAtt.getIPv4RouterIDLocalNodeNATLV()!=null)
			IPv4RouterIDLocalNodeNodeAttribTLV = lsAtt.getIPv4RouterIDLocalNodeNATLV();*/
		if (lsAtt.getAvailableLabels() != null){
			this.availableLabels =lsAtt.getAvailableLabels();
			log.info("Available Labels : "+((BitmapLabelSet)availableLabels.getLabelSet()).toString());
		}

	}
	/**
	 * Function which process the link NLRI. It updates the fields passed by argument.
	 * @param linkNLRI
	 * @param maximumLinkBandwidthTLV
	 * @param maxReservableBandwidthTLV
	 * @param unreservedBandwidthTLV
	 * @param availableLabels
	 */
	private void fillLinkNLRI(LinkNLRI linkNLRI, MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV ,MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV,UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV){
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLV;
		//Dominios
		Inet4Address remoteDomainID = null ;
		Inet4Address localDomainID= null ;
		Inet4Address areaID= null ;
		Inet4Address bgplsID = null;
		//IPs de los routers de borde
		Inet4Address localRouterASBR = null ;
		Inet4Address  remoteRouterASBR = null ;
		//Interfaces de los routers de borde
		long localRouterASBRIf = -1;
		long remoteRouterASBRIf = -1;
		//Local Node descriptors 
		nodeDescriptorsSubTLV = linkNLRI.getLocalNodeDescriptors().getNodeDescriptorsSubTLVList();
		for (int i = 0;i<nodeDescriptorsSubTLV.size();i++){
			int subTLVType = nodeDescriptorsSubTLV.get(i).getSubTLVType();
			switch (subTLVType){	
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AUTONOMOUS_SYSTEM:
				localDomainID = ((AutonomousSystemNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAS_ID();
				log.info("AUTONOMOUS_SYSTEM found in LINK_NLRI(local_node). as_local "+localDomainID);
				break;
				
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AREA_ID:
				areaID = ((AreaIDNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAREA_ID();
				log.info("AREA_ID found in LINK_NLRI(local_node). area_id "+areaID);
				break;
				
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_BGP_LS_IDENTIFIER:
				bgplsID = ((BGPLSIdentifierNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getBGPLS_ID();
				log.info("BGPLS IDENTIFIER found in LINK_NLRI(local_node). bgpls_id "+bgplsID);
				break;
			
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_IGP_ROUTER_ID:
				log.info("IGP ROUTER ID found in LINK_NLRI(local_node). igp_id "+null);
				break;		
			default:
				log.finest("Attribute Code unknown");
			}
		}
		//Remote Node descriptors, AUN ESTA SI HACER
		nodeDescriptorsSubTLV = linkNLRI.getRemoteNodeDescriptorsTLV().getNodeDescriptorsSubTLVList();
		for (int i = 0;i<nodeDescriptorsSubTLV.size();i++){
			int subTLVType = nodeDescriptorsSubTLV.get(i).getSubTLVType();
			switch (subTLVType){	
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AUTONOMOUS_SYSTEM:
				remoteDomainID = ((AutonomousSystemNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAS_ID();
				log.info("AUTONOMOUS_SYSTEM found in LINK_NLRI(remote_node). as_remote "+remoteDomainID);
				break;
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AREA_ID:
				areaID = ((AreaIDNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAREA_ID();
				log.info("AREA_ID found in LINK_NLRI(remote_node). area_id "+areaID);
				break;
				
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_BGP_LS_IDENTIFIER:
				log.info("BGPLS IDENTIFIER found in LINK_NLRI(remote_node). bgpls_id "+bgplsID);
				break;
			
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_IGP_ROUTER_ID:
				log.info("IGP ROUTER ID found in LINK_NLRI(remote_node). igp_id "+null);
				break;
					
			default:
				log.finest("Attribute Code unknown");
			}
		}

		if ((localRouterASBR != null)&&(remoteRouterASBR != null)){
			log.info("Existe nodo origen y destino");
			TE_Information te_info=null;
			if ((localDomainID != null)&&(remoteDomainID != null)){
				//FIXME: no se si hay que ver que los dominios sean iguales o no hace falta.				
				if (!(localDomainID.equals(remoteDomainID))){//InterDomain
					log.info("InterDomain link");
					if (linkNLRI.getLinkIdentifiersTLV() != null){				
						localRouterASBRIf=linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier();
						remoteRouterASBRIf=linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier();						
						te_info =  createTE_Info( maximumLinkBandwidthTLV , maxReservableBandwidthTLV, unreservedBandwidthTLV, this.availableLabels);		
						multiTedb.addInterdomainLink(localDomainID, localRouterASBR, localRouterASBRIf, remoteDomainID, remoteRouterASBR, remoteRouterASBRIf,te_info);
					}else{
						log.info("linkNLRI.getLinkIdentifiersTLV() == null");
					}
				}else{//Intradomain
					log.info("IntraDomain link simpleTEDB::"+simpleTEDB);
					if (simpleTEDB != null) {
						IntraDomainEdge intraEdge = new IntraDomainEdge();
						if (linkNLRI.getLinkIdentifiersTLV() != null){	
							log.info("Leyendo los interfaces no numerados");
							intraEdge.setSrc_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier());
							intraEdge.setDst_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier());
						}
						
						log.info("Inside if simpleTEDB != null");
						
						te_info =  createTE_Info( maximumLinkBandwidthTLV , maxReservableBandwidthTLV, unreservedBandwidthTLV, this.availableLabels);
						intraEdge.setTE_info(te_info);
						UpdateLink link= new UpdateLink(localRouterASBR, remoteRouterASBR,((BitmapLabelSet) te_info.getAvailableLabels().getLabelSet()).getBytesBitMap(), ((BitmapLabelSet) te_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved());
						int index = updateLinks.indexOf(link);
						if ((index==-1) || !(((UpdateLink)updateLinks.get(index)).getBitmap().equals(((BitmapLabelSet)te_info.getAvailableLabels().getLabelSet()).getBytesBitMap()))){
							
							if (!(simpleTEDB.getNetworkGraph().containsVertex(localRouterASBR)))
								simpleTEDB.getNetworkGraph().addVertex(localRouterASBR);
							if (!(simpleTEDB.getNetworkGraph().containsVertex(remoteRouterASBR)))
								simpleTEDB.getNetworkGraph().addVertex(remoteRouterASBR);
							if (!(simpleTEDB.getNetworkGraph().containsEdge(localRouterASBR, remoteRouterASBR))){
								simpleTEDB.getNetworkGraph().addEdge(localRouterASBR, remoteRouterASBR, intraEdge);
								IntraDomainEdge edge=simpleTEDB.getNetworkGraph().getEdge(localRouterASBR, remoteRouterASBR);
								//Metemos ceros en el reservation
								((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).initializeReservation(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap());
							}
							else {
								log.info("The Link exists");
								IntraDomainEdge edge;
								edge=simpleTEDB.getNetworkGraph().getEdge(localRouterASBR, remoteRouterASBR);
								log.info(intraEdge.toString());
								log.info(edge.toString());
								if(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel()!=null){
									((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).arraycopyBytesBitMap(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap());
									if (((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitmapReserved()!=null)
										((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).arraycopyReservedBytesBitMap(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitmapReserved());
								}
							}
							if (index!=-1)
								updateLinks.remove(index);
							updateLinks.add(link);
						} 
						if (((BitmapLabelSet)te_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved()!=null){
			/*			if ((index!=-1) && !(((UpdateLink)updateLinks.get(index)).getBitmapRserved().equals(((BitmapLabelSet)te_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved()))){
							IntraDomainEdge edge;
							edge=simpleTEDB.getNetworkGraph().getEdge(localRouterASBR, remoteRouterASBR);
							((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).arraycopyReservedBytesBitMap(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitmapReserved());
							UpdateLink link2= new UpdateLink(localRouterASBR, remoteRouterASBR,((BitmapLabelSet) te_info.getAvailableLabels().getLabelSet()).getBytesBitMap(), ((BitmapLabelSet) te_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved());
							updateLinks.remove(index);
							updateLinks.add(link2);
						}*/}
						log.info("Se comprueba que existe la info de la topologia");
						log.info("Available Labels : "+(availableLabels.toString()));
						if(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel()!=null){
							log.info("Entrando donde hay que rellenar la WSONInfo");
							if(simpleTEDB.getSSONinfo()==null){
								log.info("NEW SSON INFO");
								SSONInformation ssonInfo = new SSONInformation();
								ssonInfo.setCs(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getChannelSpacing());
								ssonInfo.setGrid(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getGrid());
								ssonInfo.setNumLambdas(((BitmapLabelSet)this.availableLabels.getLabelSet()).getNumLabels());
								ssonInfo.setCommonAvailableLabels(this.availableLabels);
								ssonInfo.setnMin(0);
								simpleTEDB.setSSONinfo(ssonInfo);
							}
							if(simpleTEDB.getWSONinfo()==null){
								log.info("NEW WSON INFO");
								WSONInformation wsonInfo = new WSONInformation();
								wsonInfo.setCs(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getChannelSpacing());
								wsonInfo.setGrid(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getGrid());
								wsonInfo.setNumLambdas(((BitmapLabelSet)this.availableLabels.getLabelSet()).getNumLabels());
								wsonInfo.setCommonAvailableLabels(this.availableLabels);
								wsonInfo.setnMin(0);
								simpleTEDB.setWSONinfo(wsonInfo);
							}
						}
					}
				}
			}else{//Intradomain
				log.info("Other if");
				if (simpleTEDB != null) {
					log.info("Something is going to be added to simpleTEDB");
					IntraDomainEdge intraEdge = new IntraDomainEdge();
					if (linkNLRI.getLinkIdentifiersTLV() != null){				
						intraEdge.setSrc_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier());
						intraEdge.setDst_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier());						
					}					
					te_info =  createTE_Info( maximumLinkBandwidthTLV , maxReservableBandwidthTLV, unreservedBandwidthTLV, availableLabels);
					intraEdge.setTE_info(te_info);
					if (simpleTEDB.getNetworkGraph() == null){					
						simpleTEDB.createGraph();
					}
					simpleTEDB.getNetworkGraph().addVertex(localRouterASBR);
					simpleTEDB.getNetworkGraph().addVertex(remoteRouterASBR);
					simpleTEDB.getNetworkGraph().addEdge(localRouterASBR, remoteRouterASBR, intraEdge);					
				} 
			}
		}
		else
			log.info("sourceAddress null o dstAddress null");

	}

	private TE_Information createTE_Info (MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV ,MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV,UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV,AvailableLabels availableLabels){
		TE_Information te_info = new TE_Information();
		if (maximumLinkBandwidthTLV != null){
			MaximumBandwidth maximumBandwidth = new MaximumBandwidth();
			maximumBandwidth.setMaximumBandwidth(maximumLinkBandwidthTLV.getMaximumBandwidth());
			te_info.setMaximumBandwidth(maximumBandwidth);
		}
		if (maxReservableBandwidthTLV != null){
			MaximumReservableBandwidth maximumReservableBandwidth = new MaximumReservableBandwidth();
			maximumReservableBandwidth.setMaximumReservableBandwidth(maxReservableBandwidthTLV.getMaximumReservableBandwidth());
			te_info.setMaximumReservableBandwidth(maximumReservableBandwidth);
		}
		if (unreservedBandwidthTLV != null){
			UnreservedBandwidth unreservedBandwidth = new UnreservedBandwidth();
			unreservedBandwidth.setUnreservedBandwidth(unreservedBandwidthTLV.getUnreservedBandwidth());
			te_info.setUnreservedBandwidth(unreservedBandwidth);
		}			
		if (availableLabels != null)
			te_info.setAvailableLabels(availableLabels);
		
		return te_info;
	}
	private void fillNodeNLRI(NodeNLRI nodeNLRI, NodeFlagBitsNodeAttribTLV nodeFlagBitsTLV, NodeNameNodeAttribTLV nodeNameTLV, IS_IS_AreaIdentifierNodeAttribTLV areaIDTLV){
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLV;
		nodeDescriptorsSubTLV =  nodeNLRI.getLocalNodeDescriptors().getNodeDescriptorsSubTLVList();
		Inet4Address domain = null;
		Inet4Address areaID= null ;
		Inet4Address bgplsID = null;
		int IGP_type = 0;
		Inet4Address IGPID = null;

		ArrayList<Inet4Address> address = new ArrayList<Inet4Address>();
		for (int i = 0;i<nodeDescriptorsSubTLV.size();i++){
			int subTLVType = nodeDescriptorsSubTLV.get(i).getSubTLVType();
			switch (subTLVType){	
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AUTONOMOUS_SYSTEM:
				domain = ((AutonomousSystemNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAS_ID();
				log.info("AUTONOMOUS_SYSTEM found in NODE_NLRI. as_remote "+domain);
				break;
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_AREA_ID:
				areaID = ((AreaIDNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getAREA_ID();
				log.info("AREA_ID found. area_id in NODE_NLRI"+areaID);
				break;
				
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_BGP_LS_IDENTIFIER:
				bgplsID = ((BGPLSIdentifierNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getBGPLS_ID();
				log.info("BGPLS IDENTIFIER found in NODE_NLRI. bgpls_id "+bgplsID);
				break;
			
			case NodeDescriptorsSubTLVTypes.NODE_DESCRIPTORS_SUBTLV_TYPE_IGP_ROUTER_ID:
				IGP_type = ((IGPRouterIDNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getIGP_router_id_type();
				switch(IGP_type){
					case 3:
						IGPID = ((IGPRouterIDNodeDescriptorSubTLV) nodeDescriptorsSubTLV.get(i)).getIpv4AddressOSPF();
						log.info("IGP ROUTER ID found in NODE_NLRI. igp_id "+IGPID);
						break;
					default:
						log.info("añadir este tipo de IGP Identifier por implementar ");
						break;
				}
				break;			
			default:
				log.finest("Attribute Code unknown");
			}
		}
		for (int i = 0; i<address.size();i++)
			intraTEDB.addIntradomainNode(domain,address.get(i));
	}
}