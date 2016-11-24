package es.tid.bgp.bgp4Peer.updateTEDB;

import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4.update.fields.*;
import es.tid.bgp.bgp4.update.fields.pathAttributes.*;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.*;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.*;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.*;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
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

	/** LINK ATTRIBUTE TLVs */
	MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV;
	MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV;
	UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV;
	AdministrativeGroupLinkAttribTLV administrativeGroupTLV;
	LinkProtectionTypeLinkAttribTLV linkProtectionTLV;
	MetricLinkAttribTLV metricTLV;
	IPv4RouterIDLocalNodeLinkAttribTLV iPv4RouterIDLocalNodeLATLV;
	IPv4RouterIDRemoteNodeLinkAttribTLV iPv4RouterIDRemoteNodeLATLV;
	DefaultTEMetricLinkAttribTLV TEMetricTLV;	
	TransceiverClassAndAppAttribTLV transceiverClassAndAppATLV;
	MF_OTPAttribTLV mF_OTP_ATLV;
	int linkDelay;
	int linkDelayVar;
	int minDelay;
	int maxDelay;
	int linkLoss;
	int residualBw;
	int availableBw;
	int utilizedBw;
	/** NODE ATTRIBUTE TLVs 
	 * Ipv4 of local node link attribute TLV also used
	 * 
	 * */
	NodeFlagBitsNodeAttribTLV nodeFlagBitsTLV = new NodeFlagBitsNodeAttribTLV();
	NodeNameNodeAttribTLV nodeNameTLV = new NodeNameNodeAttribTLV();
	IS_IS_AreaIdentifierNodeAttribTLV areaIDTLV = new IS_IS_AreaIdentifierNodeAttribTLV();
	SidLabelNodeAttribTLV sidTLV = new SidLabelNodeAttribTLV();

	/**PREFIX ATTRIBUTE TLVs */
	IGPFlagBitsPrefixAttribTLV igpFlagBitsTLV = new IGPFlagBitsPrefixAttribTLV();
	RouteTagPrefixAttribTLV routeTagTLV = new RouteTagPrefixAttribTLV();
	PrefixMetricPrefixAttribTLV prefixMetricTLV = new PrefixMetricPrefixAttribTLV();
	OSPFForwardingAddressPrefixAttribTLV OSPFForwardingAddrTLV = new OSPFForwardingAddressPrefixAttribTLV();

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
	private Hashtable<String,TEDB> intraTEDBs;

	private LinkedList<UpdateLink> updateLinks;

	private TE_Information te_info;




	public UpdateProccesorThread(LinkedBlockingQueue<BGP4Update> updateList,
			MultiDomainTEDB multiTedb ,Hashtable<String,TEDB> intraTEDBs ){
		log=LoggerFactory.getLogger("BGP4Server");
		running=true;
		this.updateList=updateList;
		this.multiTedb = multiTedb;

		this.intraTEDBs=intraTEDBs;
		this.availableLabels= new AvailableLabels();
		this.updateLinks=new LinkedList<UpdateLink>();
	}

	/**
	 * Starts processing updates
	 */
	public void run(){	
		BGP4Update updateMsg;
		while (running) {
			try {
				clearAttributes();
				PathAttribute att_ls = null;
				PathAttribute att_mpreach  = null; 
				PathAttribute att = null;
				updateMsg= updateList.take();
				log.debug("Update Procesor Thread Reading the message: \n"+ updateMsg.toString());
				//Andrea To be checked
				String learntFrom = updateMsg.getLearntFrom();
				log.debug("Received from "+learntFrom);
				ArrayList<PathAttribute> pathAttributeList = updateMsg.getPathAttributes();
				ArrayList<PathAttribute> pathAttributeListUtil = new ArrayList<PathAttribute>();			

				// buscamos los dos atributos que nos interesan...
				for (int i=0;i<pathAttributeList.size();i++){
					att = pathAttributeList.get(i);
					int typeCode = att.getTypeCode();
					switch (typeCode){
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_BGP_LS_ATTRIBUTE:
						att_ls = att;
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_MP_REACH_NLRI:
						att_mpreach = att;
						break;
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_ASPATH:
						//log.info("We don't use ASPATH");
						break;	
					case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_ORIGIN:
						//log.info("We don't use ORIGIN");
						break;	
					default:
						//log.info("Attribute typecode " + typeCode +"unknown");
						break;
					}

				}	

				//los situamos en el orden correcto para nuestra beloved ted...
				if(att_ls!=null)
					pathAttributeListUtil.add(att_ls);
				if(att_mpreach!=null)
					pathAttributeListUtil.add(att_mpreach);

				if (pathAttributeListUtil != null){
					for (int i=0;i<pathAttributeListUtil.size();i++){
						att = pathAttributeListUtil.get(i);
						int typeCode = att.getTypeCode();
						switch (typeCode){	
						// cuando encontramos el link state attribute rellenamos las tlvs que nos llegan para luego
						// meterlas en la te_info o en la node_info
						case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_BGP_LS_ATTRIBUTE:
							processAttributeLinkState((LinkStateAttribute) att);
							continue;
							// cuando procesamos el mp_reach distinguimos entre nodo y link...
							// prefijo aun por hacer
						case PathAttributesTypeCode.PATH_ATTRIBUTE_TYPECODE_MP_REACH_NLRI:
							int afi;
							afi = ((MP_Reach_Attribute)att).getAddressFamilyIdentifier();
							if (afi == AFICodes.AFI_BGP_LS){
								LinkStateNLRI nlri = (LinkStateNLRI) ((BGP_LS_MP_Reach_Attribute)att).getLsNLRI();
								int nlriType =  nlri.getNLRIType();
								switch (nlriType){					
								case NLRITypes.Link_NLRI:
									processLinkNLRI((LinkNLRI)(nlri), learntFrom);					
									continue;
								case NLRITypes.Node_NLRI:
									fillNodeInformation((NodeNLRI)(nlri), learntFrom);
									continue;
								case NLRITypes.Prefix_v4_NLRI://POR HACER...
									fillPrefixNLRI((PrefixNLRI)nlri, igpFlagBitsTLV, OSPFForwardingAddrTLV, prefixMetricTLV, routeTagTLV);
									continue;
								case NLRITypes.IT_Node_NLRI:
									fillITNodeInformation((ITNodeNLRI)(nlri), learntFrom);
									continue;
								default:
									log.debug("Attribute Code unknown");
								}
							}
							continue;
						default:
							log.debug("Attribute Code unknown");
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
	 */
	private void processAttributeLinkState(LinkStateAttribute lsAtt){

		if (lsAtt.getMaximumLinkBandwidthTLV() != null){
			maximumLinkBandwidthTLV = lsAtt.getMaximumLinkBandwidthTLV();
		}

		if (lsAtt.getMaxReservableBandwidthTLV() != null){
			maxReservableBandwidthTLV = lsAtt.getMaxReservableBandwidthTLV();
		}
		if (lsAtt.getUnreservedBandwidthTLV() != null){
			unreservedBandwidthTLV = lsAtt.getUnreservedBandwidthTLV();
		}
		if(lsAtt.getAdministrativeGroupTLV() != null){
			administrativeGroupTLV = lsAtt.getAdministrativeGroupTLV();
		}
		if(lsAtt.getLinkProtectionTLV() != null){
			linkProtectionTLV = lsAtt.getLinkProtectionTLV();
		}
		if(lsAtt.getIPv4RouterIDLocalNodeLATLV()!= null){
			iPv4RouterIDLocalNodeLATLV = lsAtt.getIPv4RouterIDLocalNodeLATLV();
		}
		if(lsAtt.getIPv4RouterIDRemoteNodeLATLV()!=null){
			iPv4RouterIDRemoteNodeLATLV = lsAtt.getIPv4RouterIDRemoteNodeLATLV();
		}
		if(lsAtt.getMetricTLV() != null){
			metricTLV = lsAtt.getMetricTLV();
		}
		if(lsAtt.getTEMetricTLV()!=null){
			TEMetricTLV = lsAtt.getTEMetricTLV();
		}
		if(lsAtt.getNodeFlagBitsTLV()!= null){
			nodeFlagBitsTLV = lsAtt.getNodeFlagBitsTLV();
		}
		if(lsAtt.getNodeNameTLV() != null){
			nodeNameTLV = lsAtt.getNodeNameTLV();
		}
		if(lsAtt.getAreaIDTLV() != null){
			areaIDTLV = lsAtt.getAreaIDTLV();
		}
		if(lsAtt.getIgpFlagBitsTLV() != null){
			igpFlagBitsTLV= lsAtt.getIgpFlagBitsTLV();
		}
		if(lsAtt.getRouteTagTLV() != null){
			routeTagTLV = lsAtt.getRouteTagTLV();
		}
		if(lsAtt.getOSPFForwardingAddrTLV() != null){
			OSPFForwardingAddrTLV = lsAtt.getOSPFForwardingAddrTLV();
		}
		if(lsAtt.getSidLabelTLV()!=null){
			sidTLV = lsAtt.getSidLabelTLV();
		}

		if (lsAtt.getAvailableLabels() != null){
			this.availableLabels =lsAtt.getAvailableLabels();
		}
		if (lsAtt.getMF_OTP() != null){
			this.mF_OTP_ATLV =lsAtt.getMF_OTP();
		}

		if (lsAtt.getTransceiverClassAndApp() != null){
			this.transceiverClassAndAppATLV =lsAtt.getTransceiverClassAndApp();
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


	/** Procesar un link significa:
	 * crear los vertices si no existen ya
	 * crear la edge si no existe ya
	 * crear la te_info o actualizarla
	 * @param linkNLRI
	 * @param learntFrom 
	 */
	private void processLinkNLRI(LinkNLRI linkNLRI, String learntFrom){
		ArrayList<NodeDescriptorsSubTLV> nodeDescriptorsSubTLV;
		//Dominios
		Inet4Address localDomainID= null ;
		Inet4Address remoteDomainID = null ;

		Inet4Address areaID= null ;
		Inet4Address bgplsID = null;

		Inet4Address LocalNodeIGPId = null;
		Inet4Address RemoteNodeIGPId = null;

		//Local Node descriptors 
		if (linkNLRI.getLocalNodeDescriptors().getAutonomousSystemSubTLV()!=null){
			localDomainID=linkNLRI.getLocalNodeDescriptors().getAutonomousSystemSubTLV().getAS_ID();
		}
		if (linkNLRI.getLocalNodeDescriptors().getAreaID()!=null) {
			areaID=linkNLRI.getLocalNodeDescriptors().getAreaID().getAREA_ID();
		}
		if (linkNLRI.getLocalNodeDescriptors().getBGPLSIDSubTLV()!=null) {
			bgplsID=linkNLRI.getLocalNodeDescriptors().getBGPLSIDSubTLV().getBGPLS_ID();
		}
		if (linkNLRI.getLocalNodeDescriptors().getIGPRouterID()!=null){
			LocalNodeIGPId=linkNLRI.getLocalNodeDescriptors().getIGPRouterID().getIpv4AddressOSPF();
		}

		if (linkNLRI.getRemoteNodeDescriptorsTLV().getAutonomousSystemSubTLV()!=null) {
			remoteDomainID=linkNLRI.getRemoteNodeDescriptorsTLV().getAutonomousSystemSubTLV().getAS_ID();
		}
		if (linkNLRI.getRemoteNodeDescriptorsTLV().getAreaID()!=null) {
			areaID =linkNLRI.getRemoteNodeDescriptorsTLV().getAreaID().getAREA_ID();
		}
		if (linkNLRI.getRemoteNodeDescriptorsTLV().getBGPLSIDSubTLV()!=null) {
			bgplsID=linkNLRI.getRemoteNodeDescriptorsTLV().getBGPLSIDSubTLV().getBGPLS_ID();
		}
		if (linkNLRI.getRemoteNodeDescriptorsTLV().getIGPRouterID()!=null) {
			RemoteNodeIGPId = linkNLRI.getRemoteNodeDescriptorsTLV().getIGPRouterID().getIpv4AddressOSPF();
		}
		if(linkNLRI.getUndirectionalLinkDelayTLV()!=null){
			linkDelay = linkNLRI.getUndirectionalLinkDelayTLV().getDelay();
		}
		if(linkNLRI.getUndirectionalDelayVariationTLV()!=null){
			linkDelayVar = linkNLRI.getUndirectionalDelayVariationTLV().getDelayVar();
		}
		if(linkNLRI.getMinMaxUndirectionalLinkDelayTLV()!=null){
			maxDelay = linkNLRI.getMinMaxUndirectionalLinkDelayTLV().getHighDelay();
			minDelay = linkNLRI.getMinMaxUndirectionalLinkDelayTLV().getLowDelay();
		}
		if(linkNLRI.getUndirectionalLinkLossTLV()!=null){
			linkLoss = linkNLRI.getUndirectionalLinkLossTLV().getLinkLoss();
		}
		if(linkNLRI.getUndirectionalResidualBwTLV()!=null){
			residualBw = linkNLRI.getUndirectionalResidualBwTLV().getResidualBw();
		}
		if(linkNLRI.getUndirectionalAvailableBwTLV()!=null){
			availableBw = linkNLRI.getUndirectionalAvailableBwTLV().getAvailableBw();
		}
		if(linkNLRI.getUndirectionalUtilizedBwTLV()!=null){
			utilizedBw = linkNLRI.getUndirectionalUtilizedBwTLV().getUtilizedBw();
		}
		/**Creamos el grafo*/
		//Let's see if our link is intradomain or interdomain...
		//log.info("as_local "+localDomainID);
		//log.info("as_remote "+remoteDomainID);

		if(localDomainID.equals(remoteDomainID)){
			log.debug("INTRADOMAIN...for domain"+localDomainID.getCanonicalHostName());
			IntraDomainEdge intraEdge = new IntraDomainEdge();

			if (linkNLRI.getLinkIdentifiersTLV() != null){				
				intraEdge.setSrc_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier());
				intraEdge.setDst_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier());						
			}
			/*
			Enumeration el2 = intraTEDBs.keys();
			while (el2.hasMoreElements()) {
				String key = (String) el2.nextElement();
				log.info("Intra-after.....the key is: "+key);
			}
			*/

			DomainTEDB domainTEDB=(DomainTEDB)intraTEDBs.get(localDomainID.getHostAddress());
			SimpleTEDB simpleTEDBxx=null;
			if (domainTEDB instanceof SimpleTEDB){
				simpleTEDBxx = (SimpleTEDB) domainTEDB;
			}else if (domainTEDB==null){
				simpleTEDBxx = new SimpleTEDB();
				simpleTEDBxx.createGraph();
				simpleTEDBxx.setDomainID(localDomainID);
				this.intraTEDBs.put(localDomainID.getHostAddress(), simpleTEDBxx);
			}else {
				log.error("PROBLEM: TEDB not compatible");
				return;
			}


			/**Actualizando TED*/

			if (!(simpleTEDBxx.getNetworkGraph().containsVertex(LocalNodeIGPId))){
				//log.info("Not containing source vertex");
				simpleTEDBxx.getNetworkGraph().addVertex(LocalNodeIGPId);//add vertex ya comprueba si existe el nodo en la ted-->se puede hacer mas limpio
				simpleTEDBxx.notifyNewVertex(LocalNodeIGPId);
			}
			//			else{ 
			//				log.info("Local Vertex: "+LocalNodeIGPId.toString() +" already present in TED...");
			//			}

			if (!(simpleTEDBxx.getNetworkGraph().containsVertex(RemoteNodeIGPId))){
				//log.info("Not containing dst vertex");
				simpleTEDBxx.getNetworkGraph().addVertex(RemoteNodeIGPId);
				simpleTEDBxx.notifyNewVertex(RemoteNodeIGPId);

			}
			//			else {
			//				log.info("Remote Vertex: "+RemoteNodeIGPId.toString() +" already present in TED...");
			//			}

			te_info =  createTE_Info(simpleTEDBxx);
			intraEdge.setTE_info(te_info);
			intraEdge.setLearntFrom(learntFrom);

			if (!(simpleTEDBxx.getNetworkGraph().containsEdge(LocalNodeIGPId, RemoteNodeIGPId))){
				//log.info("Graph does not contain intra-edge");

				log.debug("Adding information of local node to edge..." + simpleTEDBxx.getNodeTable().get(LocalNodeIGPId));
				intraEdge.setLocal_Node_Info(simpleTEDBxx.getNodeTable().get(LocalNodeIGPId));
				log.debug("Adding information of remote node to edge..." + simpleTEDBxx.getNodeTable().get(RemoteNodeIGPId));
				intraEdge.setRemote_Node_Info(simpleTEDBxx.getNodeTable().get(RemoteNodeIGPId));
				log.debug("Adding edge from origin vertex"+LocalNodeIGPId.toString()+ " to destination vertex" +RemoteNodeIGPId.toString());
				
				simpleTEDBxx.getNetworkGraph().addEdge(LocalNodeIGPId, RemoteNodeIGPId, intraEdge);
				simpleTEDBxx.notifyNewEdge(LocalNodeIGPId, RemoteNodeIGPId);
				
				simpleTEDBxx.getNetworkGraph().getEdge(LocalNodeIGPId, RemoteNodeIGPId).setNumberFibers(1);
				IntraDomainEdge edge=simpleTEDBxx.getNetworkGraph().getEdge(LocalNodeIGPId, RemoteNodeIGPId);
				if(intraEdge.getTE_info().getAvailableLabels()!=null)
					((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).initializeReservation(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap());

			}
			else{
				//log.info("Graph contains intra-edge");

				IntraDomainEdge edge;
				edge=simpleTEDBxx.getNetworkGraph().getEdge(LocalNodeIGPId, RemoteNodeIGPId);
				if (this.availableLabels!=null){
					if(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel()!=null){
						((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).arraycopyBytesBitMap(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap());

						if (((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitmapReserved()!=null){
							((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).arraycopyReservedBytesBitMap(((BitmapLabelSet)intraEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitmapReserved());

						}
					}
				}
			}
			/*
			Enumeration el3 = intraTEDBs.keys();
			while (el3.hasMoreElements()) {
				String key = (String) el3.nextElement();
				log.info("Intra-before.....the key is: "+key);
			}
			*/
		}

		else{
			log.debug("INTERDOMAIN...");
			InterDomainEdge interEdge = new InterDomainEdge();
			if (linkNLRI.getLinkIdentifiersTLV() != null){				
				interEdge.setSrc_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier());
				interEdge.setDst_if_id(linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier());						
			}
			//terminamos de caracterizar el interedge...
			interEdge.setSrc_router_id(LocalNodeIGPId);
			interEdge.setDst_router_id(RemoteNodeIGPId);

			interEdge.setDomain_dst_router(remoteDomainID);

			interEdge.setDomain_src_router(localDomainID);

			//check soyrce domain
			DomainTEDB domain= (DomainTEDB)intraTEDBs.get(localDomainID.getHostAddress());
			SimpleTEDB simpleTEDBs=null;
			if (domain instanceof SimpleTEDB){
				//log.info("is instance sssss");
				simpleTEDBs = (SimpleTEDB) domain;
			}else if (domain==null){
				//log.info("nullssss");
				simpleTEDBs = new SimpleTEDB();
				simpleTEDBs.createGraph();
				simpleTEDBs.setDomainID(localDomainID);
				this.intraTEDBs.put(localDomainID.getHostAddress(), simpleTEDBs);
			}
			else {
				log.error("PROBLEM: TEDB not compatible");
				return;
			}


			//check soyrce domain
			DomainTEDB domaind= (DomainTEDB)intraTEDBs.get(remoteDomainID.getHostAddress());
			SimpleTEDB simpleTEDBd=null;
			if (domaind instanceof SimpleTEDB){
				//log.info("is instancedddddd");
				simpleTEDBd = (SimpleTEDB) domaind;
			}else if (domaind==null){
				//log.info("nulldddd");
				simpleTEDBd = new SimpleTEDB();
				simpleTEDBd.createGraph();
				simpleTEDBd.setDomainID(remoteDomainID);
				this.intraTEDBs.put(remoteDomainID.getHostAddress(), simpleTEDBd);

			}else {
				log.error("PROBLEM: TEDB not compatible");
				return;
			}




			/**Actualizando TED*/
			//log.info("Updating Interdomain list...");
			//FIXME: See what to do to create SSON Info
			DomainTEDB simpleTEDB=new SimpleTEDB();
			te_info =  createTE_Info(simpleTEDB);
			interEdge.setTE_info(te_info);
			interEdge.setLearntFrom(learntFrom);

			//FIXME: ADD I-D links to the Simple TEDBs
			/**	
			if(simpleTEDB.getInterdomainLink(LocalNodeIGPId, RemoteNodeIGPId) == null){
				simpleTEDB.getInterDomainLinks().add(interEdge);
				InterDomainEdge edge = simpleTEDB.getInterdomainLink(LocalNodeIGPId, RemoteNodeIGPId);
				((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).initializeReservation(((BitmapLabelSet)interEdge.getTE_info().getAvailableLabels().getLabelSet()).getBytesBitMap());
			}
			 */

			multiTedb.addInterdomainLink(localDomainID, LocalNodeIGPId, linkNLRI.getLinkIdentifiersTLV().getLinkLocalIdentifier(), remoteDomainID, RemoteNodeIGPId, linkNLRI.getLinkIdentifiersTLV().getLinkRemoteIdentifier(), te_info);


		}
	} 

	private TE_Information createTE_Info(DomainTEDB domainTEDB){
		TE_Information te_info = new TE_Information();
		if(linkDelay>0){
			UndirectionalLinkDelayDescriptorSubTLV uSTLV = new UndirectionalLinkDelayDescriptorSubTLV();
			uSTLV.setDelay(linkDelay);
			te_info.setUndirLinkDelay(uSTLV);
		}
		if(linkDelayVar>0){
			UndirectionalDelayVariationDescriptorSubTLV uSTLV = new UndirectionalDelayVariationDescriptorSubTLV();
			uSTLV.setDelayVar(linkDelayVar);
			te_info.setUndirDelayVar(uSTLV);
		}
		if(minDelay>0 && maxDelay>0){
			MinMaxUndirectionalLinkDelayDescriptorSubTLV uSTLV = new MinMaxUndirectionalLinkDelayDescriptorSubTLV();
			uSTLV.setHighDelay(maxDelay);
			uSTLV.setLowDelay(minDelay);
			te_info.setMinMaxUndirLinkDelay(uSTLV);
		}
		if(linkLoss>0){
			UndirectionalLinkLossDescriptorSubTLV uSTLV = new UndirectionalLinkLossDescriptorSubTLV();
			uSTLV.setLinkLoss(linkLoss);
			te_info.setUndirLinkLoss(uSTLV);
		}
		if(residualBw>0){
			UndirectionalResidualBandwidthDescriptorSubTLV uSTLV = new UndirectionalResidualBandwidthDescriptorSubTLV();
			uSTLV.setResidualBw(residualBw);
			te_info.setUndirResidualBw(uSTLV);
		}
		if(availableBw>0){
			UndirectionalAvailableBandwidthDescriptorSubTLV uSTLV = new UndirectionalAvailableBandwidthDescriptorSubTLV();
			uSTLV.setAvailableBw(availableBw);
			te_info.setUndirAvailableBw(uSTLV);
		}
		if(utilizedBw>0){
			UndirectionalUtilizedBandwidthDescriptorSubTLV uSTLV = new UndirectionalUtilizedBandwidthDescriptorSubTLV();
			uSTLV.setUtilizedBw(utilizedBw);
			te_info.setUndirUtilizedBw(uSTLV);
		}
		if (maximumLinkBandwidthTLV!=null){
			MaximumBandwidth maximumBandwidth = new MaximumBandwidth();
			maximumBandwidth.setMaximumBandwidth(maximumLinkBandwidthTLV.getMaximumBandwidth());
			te_info.setMaximumBandwidth(maximumBandwidth);
		}
		if (maxReservableBandwidthTLV!=null){
			MaximumReservableBandwidth maximumReservableBandwidth = new MaximumReservableBandwidth();
			maximumReservableBandwidth.setMaximumReservableBandwidth(maxReservableBandwidthTLV.getMaximumReservableBandwidth());
			te_info.setMaximumReservableBandwidth(maximumReservableBandwidth);
		}
		if (unreservedBandwidthTLV!=null){
			UnreservedBandwidth unreservedBandwidth = new UnreservedBandwidth();
			unreservedBandwidth.setUnreservedBandwidth(unreservedBandwidthTLV.getUnreservedBandwidth());
			te_info.setUnreservedBandwidth(unreservedBandwidth);
		}
		if(iPv4RouterIDLocalNodeLATLV!=null){
			IPv4RouterIDLocalNodeLinkAttribTLV iPv4RouterIDLocalNode = new IPv4RouterIDLocalNodeLinkAttribTLV();
			iPv4RouterIDLocalNode.setIpv4Address(iPv4RouterIDLocalNodeLATLV.getIpv4Address());
			te_info.setiPv4LocalNode(iPv4RouterIDLocalNode);
		}
		if(iPv4RouterIDRemoteNodeLATLV!=null){
			IPv4RouterIDRemoteNodeLinkAttribTLV iPv4RouterIDRemoteNode = new IPv4RouterIDRemoteNodeLinkAttribTLV();
			iPv4RouterIDRemoteNode.setIpv4Address(iPv4RouterIDRemoteNodeLATLV.getIpv4Address());
			te_info.setiPv4RemoteNode(iPv4RouterIDRemoteNode);
		}
		if(metricTLV!=null){
			MetricLinkAttribTLV metric = new MetricLinkAttribTLV();
			metric.setMetric(metricTLV.getMetric());
			te_info.setMetric(metric);
		}
		if(TEMetricTLV!=null){
			TrafficEngineeringMetric teMetric = new TrafficEngineeringMetric();
			teMetric.setLinkMetric((long)TEMetricTLV.getLinkMetric());
			te_info.setTrafficEngineeringMetric(teMetric);
		}
		if(administrativeGroupTLV!=null){
			AdministrativeGroup adminGroup = new AdministrativeGroup();
			adminGroup.setAdministrativeGroup(administrativeGroupTLV.getAdministrativeGroup());
			te_info.setAdministrativeGroup(adminGroup);
		}
		if(linkProtectionTLV!=null){
			LinkProtectionTypeLinkAttribTLV linkProtection = new LinkProtectionTypeLinkAttribTLV();
			linkProtection.setProtection_type(linkProtectionTLV.getProtection_type());
			te_info.setLinkProtectionBGPLS(linkProtection);
		}
		if(this.mF_OTP_ATLV!=null){
			MF_OTPAttribTLV mF_OTP_ATLV = this.mF_OTP_ATLV.duplicate();
			te_info.setMfOTF(mF_OTP_ATLV);
		}

		if(this.transceiverClassAndAppATLV!=null){
			TransceiverClassAndAppAttribTLV tap = new TransceiverClassAndAppAttribTLV();
			tap.setTrans_class(transceiverClassAndAppATLV.getTrans_class());
			tap.setTrans_app_code(transceiverClassAndAppATLV.getTrans_app_code());	
			te_info.setTrans(tap);
		}

		if (availableLabels!= null){
			if(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel()!=null){
				if(domainTEDB.getSSONinfo()==null){
					log.debug("NEW SSON INFO");
					SSONInformation ssonInfo = new SSONInformation();
					ssonInfo.setCs(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getChannelSpacing());
					ssonInfo.setGrid(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getGrid());
					ssonInfo.setNumLambdas(((BitmapLabelSet)this.availableLabels.getLabelSet()).getNumLabels());
					ssonInfo.setCommonAvailableLabels(this.availableLabels.dublicate());
					ssonInfo.setnMin(0);
					domainTEDB.setSSONinfo(ssonInfo);
				}
				if(domainTEDB.getWSONinfo()==null){
					log.debug("NEW WSON INFO");
					WSONInformation wsonInfo = new WSONInformation();
					wsonInfo.setCs(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getChannelSpacing());
					wsonInfo.setGrid(((BitmapLabelSet)this.availableLabels.getLabelSet()).getDwdmWavelengthLabel().getGrid());
					wsonInfo.setNumLambdas(((BitmapLabelSet)this.availableLabels.getLabelSet()).getNumLabels());
					wsonInfo.setCommonAvailableLabels(this.availableLabels.dublicate());
					wsonInfo.setnMin(0);
					domainTEDB.setWSONinfo(wsonInfo);
				}
			}
			te_info.setAvailableLabels(availableLabels.dublicate());
		}


		return te_info;
	}
	

	private void fillITNodeInformation(ITNodeNLRI itNodeNLRI, String learntFrom){
/*		try {
			Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	*/	DomainTEDB domainTEDB= null;

		domainTEDB=(DomainTEDB)intraTEDBs.get(itNodeNLRI.getNodeId());
		SimpleTEDB simpleTEDB=null;
		if (domainTEDB instanceof SimpleTEDB){
			simpleTEDB = (SimpleTEDB) domainTEDB;
		}else if (domainTEDB==null){
			simpleTEDB = new SimpleTEDB();
			simpleTEDB.createGraph();


			try {
				simpleTEDB.setDomainID((Inet4Address) InetAddress.getByName(itNodeNLRI.getNodeId()));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			this.intraTEDBs.put(itNodeNLRI.getNodeId(), simpleTEDB);

		}
		else {
			log.error("PROBLEM: TEDB not compatible");
			return;
		}

		log.info("Received IT info for domain "+itNodeNLRI.getNodeId()+" from peer "+learntFrom);
		IT_Resources itResources = new IT_Resources();
		itResources.setControllerIT(itNodeNLRI.getControllerIT());
		itResources.setCpu(itNodeNLRI.getCpu());
		itResources.setMem(itNodeNLRI.getMem());
		itResources.setStorage(itNodeNLRI.getStorage());
		itResources.setLearntFrom(learntFrom);
		itResources.setITdomainID(itNodeNLRI.getNodeId());

		simpleTEDB.setItResources(itResources);




	}

	private void fillNodeInformation(NodeNLRI nodeNLRI, String learntFrom){

		Inet4Address as_number = null;
		Inet4Address areaID= null ;
		Inet4Address bgplsID = null;
		int IGP_type = 0;
		Inet4Address IGPID = null;
		Node_Info node_info = new Node_Info();
		Hashtable<Object , Node_Info> NodeTable;
		if (nodeNLRI.getLocalNodeDescriptors().getAutonomousSystemSubTLV()!=null){
			as_number=nodeNLRI.getLocalNodeDescriptors().getAutonomousSystemSubTLV().getAS_ID();
			node_info.setAs_number(as_number);
		}
		if (nodeNLRI.getLocalNodeDescriptors().getAreaID()!=null){
			areaID=nodeNLRI.getLocalNodeDescriptors().getAreaID().getAREA_ID();
		}
		if (nodeNLRI.getLocalNodeDescriptors().getBGPLSIDSubTLV()!=null){
			bgplsID=nodeNLRI.getLocalNodeDescriptors().getBGPLSIDSubTLV().getBGPLS_ID();
		}
		if (nodeNLRI.getLocalNodeDescriptors().getIGPRouterID()!=null){
			IGP_type=nodeNLRI.getLocalNodeDescriptors().getIGPRouterID().getIGP_router_id_type();
			switch(IGP_type){
			case 3:
				IGPID = nodeNLRI.getLocalNodeDescriptors().getIGPRouterID().getIpv4AddressOSPF();

				node_info.setIpv4Address(IGPID);
				break;
			default:
				log.info("añadir este tipo de IGP Identifier por implementar ");
			}
		}


		if(iPv4RouterIDLocalNodeLATLV != null){
			log.debug("adding ipv4 of local node to table......");
			node_info.setIpv4AddressLocalNode(iPv4RouterIDLocalNodeLATLV.getIpv4Address());
		}
		if(nodeFlagBitsTLV!= null){
			log.debug("adding flags of local node to table...");
			node_info.setAbr_bit(nodeFlagBitsTLV.isAbr_bit());
			node_info.setAttached_bit(nodeFlagBitsTLV.isAttached_bit());
			node_info.setExternal_bit(nodeFlagBitsTLV.isExternal_bit());
			node_info.setOverload_bit(nodeFlagBitsTLV.isOverload_bit());
		}

		if(nodeNameTLV != null){
			log.debug("adding name of local node to table....");
			node_info.setName(nodeNameTLV.getName());
		}

		if(areaIDTLV != null){
			log.debug("adding areaID of local node to table....");
			node_info.setIpv4areaIDs(areaIDTLV.getIpv4areaIDs());
		}

		if(sidTLV != null){
			log.debug("adding SID of local node to table....");
			node_info.setSID(sidTLV.getSid());
		}
		//.... finally we set the 'learnt from' attribute
		node_info.setLearntFrom(learntFrom);
		log.debug("learnt from: " +learntFrom);
		if (as_number==null){
			log.error(" as_number is NULL");
		}
		DomainTEDB domainTEDB=(DomainTEDB)intraTEDBs.get(as_number.getHostAddress());

		SimpleTEDB simpleTEDB=null;
		if (domainTEDB instanceof SimpleTEDB){
			simpleTEDB = (SimpleTEDB) domainTEDB;
		}else if (domainTEDB==null){
			simpleTEDB = new SimpleTEDB();
			simpleTEDB.createGraph();
			this.intraTEDBs.put(as_number.getHostAddress(), simpleTEDB);
			simpleTEDB.setDomainID(as_number);
		}else {
			log.error("PROBLEM: TEDB not compatible");
			return;
		}

		NodeTable =simpleTEDB.getNodeTable();
		if(NodeTable!=null){
			if(NodeTable.containsKey(IGPID))
				NodeTable.remove(IGPID);
		}


		NodeTable.put(IGPID, node_info);

		simpleTEDB.setNodeTable(NodeTable);
		if (this.multiTedb!=null) {
			if (node_info.getIpv4Address()!=null){
				this.multiTedb.addReachabilityIPv4(as_number, node_info.getIpv4Address(), 32);
			}

		}
		log.debug("Node Table:" + NodeTable.toString());
		log.debug("Node Information Table Updated....");

	}


	private void clearAttributes(){
		maximumLinkBandwidthTLV= null;
		maxReservableBandwidthTLV= null;
		unreservedBandwidthTLV= null;
		administrativeGroupTLV = null;
		linkProtectionTLV =null;
		metricTLV = null;
		iPv4RouterIDLocalNodeLATLV = null;
		iPv4RouterIDRemoteNodeLATLV = null;
		TEMetricTLV = null;				
		transceiverClassAndAppATLV = null;
		mF_OTP_ATLV = null;
		availableLabels=null;
		linkDelay=0;
		linkDelayVar=0;
		minDelay=0;
		maxDelay=0;
		linkLoss=0;
		residualBw=0;
		availableBw=0;
		utilizedBw=0;

	}



}
