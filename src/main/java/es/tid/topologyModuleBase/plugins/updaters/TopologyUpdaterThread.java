package es.tid.topologyModuleBase.plugins.updaters;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.LSATypes;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.ospf.ospfv2.lsa.tlv.LinkTLV;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumReservableBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.LabelSetField;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.LabelSetParameters;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiLayerTEDB;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TE_Information;

public class TopologyUpdaterThread extends Thread{

	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue;
	private Logger log;
	private DomainTEDB TEDB;
	/**
	 * Variables used to specify the range of lambdas the PCE is using
	 * Variables para especificar el rango de lambdas que el PCE esta usando, es decir,
	 * el rango de lambdas en el que puede calcular caminos
	 */
	private int lambdaIni=0;
	private int lambdaEnd=Integer.MAX_VALUE;

	private boolean isCompletedAuxGraph=false;

	private boolean multilayer=false;
	private int layer=LayerTypes.SIMPLE_NETWORK;

	public  TopologyUpdaterThread(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue, DomainTEDB TEDB, int lambdaIni, int lambdaEnd) {
		log=LoggerFactory.getLogger("PCEServer");
		this.ospfv2PacketQueue=ospfv2PacketQueue;		
		this.TEDB=TEDB;
		this.lambdaIni=lambdaIni;
		this.lambdaEnd=lambdaEnd;		
	}

	public  TopologyUpdaterThread(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue,DomainTEDB TEDB, int lambdaIni, int lambdaEnd,
			boolean isCompletedAuxGraph, boolean multilayer) {
		log=LoggerFactory.getLogger("PCEServer");
		this.ospfv2PacketQueue=ospfv2PacketQueue;		
		this.TEDB=TEDB;
		this.lambdaIni=lambdaIni;
		this.lambdaEnd=lambdaEnd;
		this.isCompletedAuxGraph=isCompletedAuxGraph;
		this.multilayer=multilayer;
	}

	@Override
	public void run() {
		log.info("Starting Topology Upadater Thread");
		LinkedList<LSA> lsaList;
		OSPFTEv2LSA lsa;
		OSPFv2LinkStateUpdatePacket ospfv2Packet;
		while(true){
			try {
				ospfv2Packet = ospfv2PacketQueue.take();
				//log.info("OSPF PACKET READ");

				//System.out.println("OSPF AREA: "+ospfv2Packet.getAreaID().toString());

				Inet4Address domainId = (Inet4Address) Inet4Address.getByName("0.0.0.1");
				TEDB.getReachabilityEntry().setDomainId(domainId);
				//System.out.println("MY AREA: "+TEDB.getReachabilityEntry().getDomainId());


				// Filtered by domain ID
				if ((TEDB.getReachabilityEntry().getDomainId())!=null){
					if(ospfv2Packet.getAreaID().toString().equalsIgnoreCase(this.TEDB.getReachabilityEntry().getDomainId().toString())){

						//System.out.println("Adding OSPF Message");

						// If ospf packet is from my domain 
						Inet4Address localInterfaceIPAddress = ospfv2Packet.getRouterID();

						lsaList = (ospfv2Packet).getLSAlist();

						for (int i =0;i< lsaList.size();i++){
							if (lsaList.get(i).getLStype() == LSATypes.TYPE_10_OPAQUE_LSA){
								lsa=(OSPFTEv2LSA)lsaList.get(i);
								//log.info("Starting to process LSA");
								LinkTLV linkTLV = lsa.getLinkTLV();
								if (linkTLV!=null){
									//log.info("Link TLV ha llegado "+lsa.toString());
									//System.out.println(linkTLV.toString());
									if (localInterfaceIPAddress == null){
										localInterfaceIPAddress = linkTLV.getLocalInterfaceIPAddress().getLocalInterfaceIPAddress(0);
									}
									log.debug("Local InterfaceIPAddress: "+localInterfaceIPAddress);

									Inet4Address remoteInterfaceIPAddress = linkTLV.getLinkID().getLinkID();
									//Inet4Address remoteInterfaceIPAddress =linkTLV.getRemoteInterfaceIPAddress().getRemoteInterfaceIPAddress(0);
									log.debug("Remote InterfaceIPAddress: "+remoteInterfaceIPAddress);
									AvailableLabels newAvailableLabels = linkTLV.getAvailableLabels();

									IntraDomainEdge edge = null;
									if (multilayer){
										if (isCompletedAuxGraph){
											//tenemos que realizar la conversión a nodos y links del grafo auxiliar
											if (newAvailableLabels!=null){
												//System.out.println("MODIFICACIÓN GRAFO PARA ÓPTICA");
												//Es de las capas 1-Numlabels
												//Modificación en parte óptica
												int lambda = 0;
												lambda = ((BitmapLabelSet)linkTLV.getAvailableLabels().getLabelSet()).getDwdmWavelengthLabel().getN();
												//System.out.println("Modificamos Grafo para la lambda :"+lambda);										

												((MultiLayerTEDB)TEDB).notificationEdgeOPTICAL_AuxGraph(localInterfaceIPAddress, remoteInterfaceIPAddress, lambda);

											}
											else{
												//System.out.println("MODIFICACIÓN GRAFO PARA IP");
												TE_Information informationTEDB = new TE_Information();
												MaximumBandwidth maximumBandwidth = linkTLV.getMaximumBandwidth();
												if (maximumBandwidth!= null){
													informationTEDB.setMaximumBandwidth(maximumBandwidth);
													//System.out.println("Meto el maximumBandwidth :"+maximumBandwidth.getMaximumBandwidth());
												}

												UnreservedBandwidth unreservedBandwidth = linkTLV.getUnreservedBandwidth();
												if (unreservedBandwidth!=null){
													informationTEDB.setUnreservedBandwidth(unreservedBandwidth);
													//System.out.println("Meto el unreservedBandwidth :"+unreservedBandwidth.getUnreservedBandwidth()[0]);
												}

												MaximumReservableBandwidth maximumReservableBandwidth = new MaximumReservableBandwidth();
												maximumReservableBandwidth.setMaximumReservableBandwidth(unreservedBandwidth.getUnreservedBandwidth()[0]);
												if (maximumReservableBandwidth!= null){
													informationTEDB.setMaximumReservableBandwidth(maximumReservableBandwidth);
													//System.out.println("Meto el MaximumReservableBandwidth :"+maximumReservableBandwidth.maximumReservableBandwidth);
												}

												//Es de las capas "NumLabels + 1" o "NumLabels + 2" 
												((MultiLayerTEDB)TEDB).notificationEdgeIP_AuxGraph(localInterfaceIPAddress, remoteInterfaceIPAddress, informationTEDB);
											}
										}
										else {
											if (newAvailableLabels== null){
												// caso Multilayer CAPA MPLS
												//System.out.println("Link de  "+localInterfaceIPAddress+" al dest  "+remoteInterfaceIPAddress);
												edge=((MultiLayerTEDB)TEDB).getUpperLayerGraph().getEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);
												layer = LayerTypes.UPPER_LAYER;
												//System.out.println("Actualización grafo IP --> CAPA SUPERIOR");
											}
											else{
												// caso MULTILAYER capa OPTICA
												edge=((MultiLayerTEDB)TEDB).getLowerLayerGraph().getEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);
												layer = LayerTypes.LOWER_LAYER;
												//System.out.println("Actualización grafo ÓPTICO --> CAPA INFERIOR");
											}
										}
									}
									else{
										edge=((SimpleTEDB)TEDB).getNetworkGraph().getEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);
										layer = LayerTypes.SIMPLE_NETWORK;
									}

									boolean newEdge=false;
									boolean newVertex =false;
									boolean newEdge_virtual=false;
									boolean changeWavelength = false;
									boolean lighpath_flag  = false;
									BitmapLabelSet previousBitmapLabelSet=null;
									BitmapLabelSet newBitmapLabelSet=null;
									if (edge!=null){
										//System.out.println("ACTUALIZACIÓN ÓPTICA O IP/MPLS SIN AÑADIR NUEVO LIGTH PATH");
									}
									if ((edge == null) && !(isCompletedAuxGraph)){

										log.info("ADDING EDGE");

										edge= new IntraDomainEdge();
										if (layer == LayerTypes.SIMPLE_NETWORK){
											((SimpleTEDB)TEDB).getNetworkGraph().addVertex(localInterfaceIPAddress);
											((SimpleTEDB)TEDB).getNetworkGraph().addVertex(remoteInterfaceIPAddress);
											if(linkTLV.getLinkLocalRemoteIdentifiers()!=null){
												long src_if_Id = linkTLV.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
												long dst_if_Id = linkTLV.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();
												edge.setSrc_if_id(src_if_Id);
												edge.setDst_if_id(dst_if_Id);
											}
											((SimpleTEDB)TEDB).getNetworkGraph().addEdge(localInterfaceIPAddress, remoteInterfaceIPAddress, edge);
										}
										else if (layer == LayerTypes.LOWER_LAYER){
											((MultiLayerTEDB)TEDB).getLowerLayerGraph().addVertex(localInterfaceIPAddress);
											((MultiLayerTEDB)TEDB).getLowerLayerGraph().addVertex(remoteInterfaceIPAddress);
											((MultiLayerTEDB)TEDB).getLowerLayerGraph().addEdge(localInterfaceIPAddress, remoteInterfaceIPAddress, edge);
										}
										else {
											//((MultiLayerTEDB)TEDB).getUpperLayerGraph().addEdge(localInterfaceIPAddress, remoteInterfaceIPAddress, edge);
											newEdge_virtual = true;
											if (newEdge_virtual){
												TE_Information informationTEDB = new TE_Information();
												MaximumBandwidth maximumBandwidth = linkTLV.getMaximumBandwidth();
												if (maximumBandwidth!= null){
													informationTEDB.setMaximumBandwidth(maximumBandwidth);
													//	System.out.println("Meto el maximumBandwidth");
												}

												UnreservedBandwidth unreservedBandwidth = linkTLV.getUnreservedBandwidth();
												if (unreservedBandwidth!=null){
													informationTEDB.setUnreservedBandwidth(unreservedBandwidth);
													//System.out.println("Meto el unreservedBandwidth");
												}

												MaximumReservableBandwidth maximumReservableBandwidth = new MaximumReservableBandwidth();
												maximumReservableBandwidth.setMaximumReservableBandwidth(unreservedBandwidth.getUnreservedBandwidth()[0]);
												if (maximumReservableBandwidth!= null){
													informationTEDB.setMaximumReservableBandwidth(maximumReservableBandwidth);
													//System.out.println("Meto el MaximumReservableBandwidth");
												}
												((MultiLayerTEDB)TEDB).notifyNewEdgeIP(localInterfaceIPAddress, remoteInterfaceIPAddress, informationTEDB);
												lighpath_flag = true;
											}
										}
										if (layer == LayerTypes.LOWER_LAYER || layer == LayerTypes.SIMPLE_NETWORK){
											newVertex=true;
											newEdge=true;
										}
									}
									if (lighpath_flag == false && !(isCompletedAuxGraph)){

										TE_Information informationTEDB=edge.getTE_info();
										if (informationTEDB == null){
											informationTEDB = new TE_Information();
										}
										if (layer == LayerTypes.UPPER_LAYER){
											if (newAvailableLabels == null){
												MaximumBandwidth maximumBandwidth = linkTLV.getMaximumBandwidth();
												if (maximumBandwidth!= null)
													informationTEDB.setMaximumBandwidth(maximumBandwidth);

												UnreservedBandwidth unreservedBandwidth = linkTLV.getUnreservedBandwidth();
												if (unreservedBandwidth!=null)
													informationTEDB.setUnreservedBandwidth(unreservedBandwidth);
												//AvailableLabels
												MaximumReservableBandwidth maximumReservableBandwidth = new MaximumReservableBandwidth();
												maximumReservableBandwidth.setMaximumReservableBandwidth(unreservedBandwidth.getUnreservedBandwidth()[0]);
												if (maximumReservableBandwidth!= null)
													informationTEDB.setMaximumReservableBandwidth(maximumReservableBandwidth);
											}
											edge.setTE_info(informationTEDB);
										}
										else if (newAvailableLabels!= null){
											if (newAvailableLabels.getLabelSet()!=null){
												if (newAvailableLabels.getLabelSet().getAction()==LabelSetParameters.BitmapLabelSet){
													//We store here the previous BitmapLabelSet, to know the differences	

													//log.info("TEMA BITMAP LABEL");

													if (informationTEDB.getAvailableLabels() ==  null){
														informationTEDB.setAvailableLabels(new AvailableLabels());
													}
													//Primera vez que llega la topologia. Creamos el LABELSET
													if (informationTEDB.getAvailableLabels().getLabelSet() == null){

														//log.info("TEMA BITMAP LABEL POR PRIMERA VEZ");

														newBitmapLabelSet = new BitmapLabelSet();
														previousBitmapLabelSet=newBitmapLabelSet;
														newBitmapLabelSet.createBytesBitMap(((BitmapLabelSet)newAvailableLabels.getLabelSet()).getBytesBitMap());
														int numLabels = linkTLV.getAvailableLabels().getLabelSet().getNumLabels();
														int numberBytes = getNumberBytes(numLabels);
														log.info("NUM LABELS: "+numLabels+" NUMBER BYTES: "+numberBytes);
														byte[] bytesBitMapReserved =  new byte[numberBytes];
														for (int j=0;j<numberBytes;j++)
															bytesBitMapReserved[j]=0x00;
														newBitmapLabelSet.setBytesBitmap(bytesBitMapReserved);
														newBitmapLabelSet.setBytesBitmapReserved(bytesBitMapReserved);
														log.info("antes");
														log.info("NUM LABELS: "+newBitmapLabelSet.getBytesBitMap().length);
														newBitmapLabelSet.setNumLabels(numLabels);
														informationTEDB.getAvailableLabels().setLabelSet(newBitmapLabelSet);
														newBitmapLabelSet.setDwdmWavelengthLabel(((BitmapLabelSet)linkTLV.getAvailableLabels().getLabelSet()).getDwdmWavelengthLabel());
														changeWavelength = true;
														edge.setTE_info(informationTEDB);

													}else{//La topologia ya esta creada
														previousBitmapLabelSet  = new BitmapLabelSet();
														previousBitmapLabelSet.createBytesBitMap(((BitmapLabelSet)informationTEDB.getAvailableLabels().getLabelSet()).getBytesBitMap());
													}
													if (!newEdge){
														if (hasChanged(previousBitmapLabelSet,newAvailableLabels.getLabelSet())){
															if (lambdaEnd!=Integer.MAX_VALUE){												
																((BitmapLabelSet)informationTEDB.getAvailableLabels().getLabelSet()).arraycopyBytesBitMap(((BitmapLabelSet)newAvailableLabels.getLabelSet()).getBytesBitMap(),getNumberBytes(lambdaIni),getNumberBytes(lambdaEnd));
															}
															else{
																System.out.println("Actualizamos el nuevo bit map label set en la TEDB");
																((BitmapLabelSet)informationTEDB.getAvailableLabels().getLabelSet()).arraycopyBytesBitMap(((BitmapLabelSet)newAvailableLabels.getLabelSet()).getBytesBitMap());
															}
															changeWavelength = true;
														} 
													}
												}
											}else {
												log.info("TopologyUpdaterThread: El label set es null.");
											}
										}
										if (newVertex){
											if (multilayer){
												((MultiLayerTEDB)TEDB).notifyNewVertex(localInterfaceIPAddress);
												((MultiLayerTEDB)TEDB).notifyNewVertex(remoteInterfaceIPAddress);
											}
											else{
												TEDB.notifyNewVertex(localInterfaceIPAddress);
												TEDB.notifyNewVertex(remoteInterfaceIPAddress);
											}
										}
										if (newEdge){
											if (multilayer)
												((MultiLayerTEDB)TEDB).notifyNewEdge(localInterfaceIPAddress,remoteInterfaceIPAddress);
											else
												TEDB.notifyNewEdge(localInterfaceIPAddress,remoteInterfaceIPAddress);
										}
										if (changeWavelength){
											if (multilayer)
												((MultiLayerTEDB)TEDB).notifyWavelengthChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet,(BitmapLabelSet)informationTEDB.getAvailableLabels().getLabelSet());
											else{
												System.out.println("Entramos en el notifyWavelengthChange");
												TEDB.notifyWavelengthChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet,(BitmapLabelSet)informationTEDB.getAvailableLabels().getLabelSet());

											}
										}
									}
								}
								else {
									log.debug("Link TLV de OSPFTEv2LSA esta a null");
								}
								log.debug("Processing LSA to update topology");
							}
						}
					}

					// END area ID comparation

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void LSASDifferences(OSPFTEv2LSA lsaOriginal, OSPFTEv2LSA lsaReceived){
		//RouterAddressTLV
		//LinkTLV:
		//		//LinkType ;
		//
		//		 LinkID ;
		//
		//		 LocalInterfaceIPAddress ;
		//
		//		 RemoteInterfaceIPAddress ;
		//		
		//		 TrafficEngineeringMetric ;
		//
		//		 MaximumBandwidth ; 
		//
		//		 MaximumReservableBandwidth ;
		//
		//		 UnreservedBandwidth ; 
		//
		//		 AdministrativeGroup ;
		//		
		//		 LinkLocalRemoteIdentifiers ;
		//		
		//		- LinkProtectionType ;
		//		
		//		- InterfaceSwitchingCapabilityDescriptor ;
		//		
		//		- SharedRiskLinkGroup ;	
		//		
		//		- RemoteASNumber ;
		//		
		//		- IPv4RemoteASBRID ;
		//
		//		- AvailableLabels: 
		//
		//		
		if ((lsaOriginal.getLinkTLV().getLinkLocalRemoteIdentifiers() != null )&&(lsaReceived.getLinkTLV().getLinkLocalRemoteIdentifiers() != null))
			if (!(lsaOriginal.getLinkTLV().getLinkLocalRemoteIdentifiers().equals(lsaReceived.getLinkTLV().getLinkLocalRemoteIdentifiers())))
				//No son iguales
				log.info("Distinto el LinkLocalRemoteIdentifiers");

		if ((lsaOriginal.getLinkTLV().getLinkProtectionType() != null )&&(lsaReceived.getLinkTLV().getLinkProtectionType() != null))
			if (!(lsaOriginal.getLinkTLV().getLinkProtectionType().equals(lsaReceived.getLinkTLV().getLinkProtectionType())))
				//No son iguales
				log.info("Distinto el LinkProtectionType");

		if ((lsaOriginal.getLinkTLV().getInterfaceSwitchingCapabilityDescriptor() != null )&&(lsaReceived.getLinkTLV().getInterfaceSwitchingCapabilityDescriptor() != null))
			if (!(lsaOriginal.getLinkTLV().getInterfaceSwitchingCapabilityDescriptor().equals(lsaReceived.getLinkTLV().getInterfaceSwitchingCapabilityDescriptor())))
				//No son iguales
				log.info("Distinto el InterfaceSwitchingCapabilityDescriptor");

		if ((lsaOriginal.getLinkTLV().getSharedRiskLinkGroup() != null )&&(lsaReceived.getLinkTLV().getSharedRiskLinkGroup() != null))
			if (!(lsaOriginal.getLinkTLV().getSharedRiskLinkGroup().equals(lsaReceived.getLinkTLV().getSharedRiskLinkGroup())))
				//No son iguales
				log.info("Distinto el getSharedRiskLinkGroup");
		if ((lsaOriginal.getLinkTLV().getRemoteASNumber() != null )&&(lsaReceived.getLinkTLV().getRemoteASNumber() != null))
			if (!(lsaOriginal.getLinkTLV().getRemoteASNumber().equals(lsaReceived.getLinkTLV().getRemoteASNumber())))
				//No son iguales
				log.info("Distinto el getRemoteASNumber");
		if ((lsaOriginal.getLinkTLV().getiPv4RemoteASBRID()!= null )&&(lsaReceived.getLinkTLV().getiPv4RemoteASBRID() !=null))
			if (!(lsaOriginal.getLinkTLV().getiPv4RemoteASBRID().equals(lsaReceived.getLinkTLV().getiPv4RemoteASBRID())))
				log.info("Distinto el getiPv4RemoteASBRID");//No son iguales
		if ((lsaOriginal.getLinkTLV().getAvailableLabels() != null )&&(lsaReceived.getLinkTLV().getAvailableLabels() != null))
			if (!(lsaOriginal.getLinkTLV().getAvailableLabels().equals(lsaReceived.getLinkTLV().getAvailableLabels())))
				//No son iguales
				log.info("Distinto el LinkProtectionType");

	}

	public int getNumberBytes(int lambda){
		int numberBytes = lambda/8;
		if ((numberBytes*8)<lambda){
			numberBytes++;
		}
		return numberBytes;
	}
	//	public boolean changeBytesBitMap(LabelSetField LabelTEinfo ,LabelSetField LabelTElink){
	//		byte[] bytesBitMapTEinfo = (((BitmapLabelSet)LabelTEinfo).getBytesBitMap());
	//		//byte[] bytesBitMapTElink = ((BitmapLabelSet)LabelTElink).getBytesBitMap();
	//		//printByte(bytesBitMapTEinfo,"bytesBitMapTEinfo");
	//		//printByte(bytesBitMapTElink,"bytesBitMapTElink");
	//		if (bytesBitMapTEinfo.length != ((BitmapLabelSet)LabelTElink).getBytesBitMap().length){
	//			return false;
	//		}
	//		byte[] bytesToChange = new byte[bytesBitMapTEinfo.length];
	//
	//		for (int i =0; i<bytesBitMapTEinfo.length;i++){
	//			bytesBitMapTEinfo[i]=(byte) ( (bytesBitMapTEinfo[i]) | (((BitmapLabelSet)LabelTElink).getBytesBitMap()[i]));		
	//		}
	//		((BitmapLabelSet)LabelTEinfo).changeBytesBitMap(bytesToChange);
	//		//printByte(bytesToChange,"bytesToChange");
	//		return true;
	//	}

	public boolean hasChanged(LabelSetField LabelTEinfo ,LabelSetField LabelTElink){
		byte[] bytesBitMapTEinfo = (((BitmapLabelSet)LabelTEinfo).getBytesBitMap());
		byte[] bytesBitMapTElink = ((BitmapLabelSet)LabelTElink).getBytesBitMap();
		//FIXME: mirar que pasa si la lonmgitud no es la misma
		//Si la longitud no es la misma, significa que hay balanceo de carga
		//Entonces tengo que coger los bytes de LabelTElink que quiero, para ello necesito la 'n' 
		//del base label de la topologia del PCE

		if (bytesBitMapTEinfo.length  != bytesBitMapTElink.length){
			int nMin=((SimpleTEDB)TEDB).getWSONinfo().getnMin();
			int numLambdas=((SimpleTEDB)TEDB).getWSONinfo().getNumLambdas();
			int numberBytes = getNumberBytes(numLambdas);

			byte[] newBytes =  new byte[bytesBitMapTElink.length];
			System.arraycopy(bytesBitMapTElink, nMin, newBytes, 0,numberBytes);
			for (int i =0; i<bytesBitMapTEinfo.length;i++){
				if (bytesBitMapTEinfo[i] != newBytes[i])
					return true;
			}
		}
		else if (lambdaEnd!=Integer.MAX_VALUE){
			/*El PCE esta actuando sobre un rango de lambdas determinado*/
			for (int i =getNumberBytes(lambdaIni); i<getNumberBytes(lambdaEnd);i++){
				if (bytesBitMapTEinfo[i] != bytesBitMapTElink[i])
					return true;
			}
		}
		else{
			for (int i =0; i<bytesBitMapTEinfo.length;i++){
				if (bytesBitMapTEinfo[i] != bytesBitMapTElink[i])
					return true;
			}
		}

		return false;
	}

	/*	private void printByte(byte[] bytes,String name){
		if (bytes ==null){
			System.out.println(name + " =  null");
		}
		else {
			System.out.print(name +":  ");

			for (int i =0;i<bytes.length;i++){
				if((bytes[i]&0xFF)<=0x0F){
					System.out.print("0"+Integer.toHexString(bytes[i]&0xFF));

				}else{
					System.out.print(Integer.toHexString(bytes[i]&0xFF));
				}
			}
			System.out.println();
		}
	}
	 */

}
