package es.tid.tedb;

import java.io.File;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.DefaultTEMetricLinkAttribTLV;
import es.tid.of.DataPathID;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.UnreservedBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.pce.pcep.objects.tlvs.StorageTLV;
import es.tid.pce.pcep.objects.tlvs.subtlvs.CostSubTLV;
import es.tid.pce.pcep.objects.tlvs.subtlvs.ResourceIDSubTLV;
import es.tid.pce.pcep.objects.tlvs.subtlvs.StorageSizeSubTLV;
import es.tid.rsvp.constructs.gmpls.DWDMWavelengthLabel;
import es.tid.rsvp.objects.subobjects.IPv4prefixEROSubobject;


/**
 * Convenience class to read Traffic Engineering Databases from XML files.
 * 
 * @author ogondio
 *
 */
public class FileTEDBUpdater {


	/**
	 * Read a full network (no specific layer)
	 * @param fileName Name of the XML file
	 */
	public static SimpleDirectedWeightedGraph<Object, IntraDomainEdge> readNetwork(String fileName){
		return FileTEDBUpdater.readNetwork(fileName,null,false,0,Integer.MAX_VALUE);
	}

	/**
	 * Reads a specific layer from a Network XML file
	 * @param fileName Name of the XML file
	 * @param layer
	 */
	public static SimpleDirectedWeightedGraph<Object, IntraDomainEdge> readNetwork(String fileName,String layer){
		return FileTEDBUpdater.readNetwork(fileName,layer,false,0,Integer.MAX_VALUE, false);
	}
	/**
	 * Reads a specific layer from a Network XML file
	 * It can treat all domains as a single domain
	 * @param fileName Name of the XML file
	 * @param layer
	 * @param allDomains
	 */
	public static SimpleDirectedWeightedGraph<Object, IntraDomainEdge> readNetwork(String fileName,String layer,boolean allDomains){
		return FileTEDBUpdater.readNetwork(fileName,layer,allDomains,0,Integer.MAX_VALUE, false);
	}
	/**
	 * Reads a specific layer from a Network XML file
	 * It can treat all domains as a single domain
	 * @param fileName Name of the XML file
	 * @param layer
	 * @param allDomains
	 * @param lambdaIni
	 * @param lambdaEnd
	 */

	public static SimpleDirectedWeightedGraph<Object, IntraDomainEdge> readNetwork(String fileName, String layer,boolean allDomains,int lambdaIni, int lambdaEnd) {
		return FileTEDBUpdater.readNetwork(fileName,layer,allDomains,0,Integer.MAX_VALUE, false);
	}


	/**
	 * Reads a specific layer from a Network XML file. 
	 * It can treat all domains as a single domain.
	 * 
	 * @param fileName
	 * @param layer
	 * @param allDomains
	 */
	public static SimpleDirectedWeightedGraph<Object, IntraDomainEdge> readNetwork(String fileName, String layer,boolean allDomains,int lambdaIni, int lambdaEnd, boolean isSSONnetwork) {
		Logger log = Logger.getLogger("PCEPServer");
		Object router_id_addr = null;
		Object s_router_id_addr = null;
		Object d_router_id_addr = null;
		Object src_Numif_id = null;
		Object dst_Numif_id = null;


		//First, create the graph
		SimpleDirectedWeightedGraph<Object, IntraDomainEdge> graph = new SimpleDirectedWeightedGraph<Object, IntraDomainEdge>(IntraDomainEdge.class);

		log.info("1. SimpleDirectedWeightedGraph");

		File file = new File(fileName);
		try {
			String domain_id = "";
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);			
			HashMap<Inet4Address, Integer >SIDS = new HashMap<Inet4Address,Integer>();
			HashMap<DataPathID, Integer >SIDSDP = new HashMap<DataPathID,Integer>();

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			if (layer!=null){
				log.info("Reading topology, looking for layer "+ layer);	
			}


			//First pass to get all the nodes
			//If we need to read all the domains
			for (int j = 0; j < nodes_domains.getLength(); j++) {
				boolean readNetwork=false;
				Element element1 = (Element) nodes_domains.item(j);

				if (layer!=null){				
					NodeList domain_layer = element1.getElementsByTagName("layer");					
					if (domain_layer.getLength()==1){						
						Element layer_type = (Element) domain_layer.item(0);
						log.info("Layer: " + layer_type.getAttributeNode("type").getValue());
						log.info("Reading network topology");
						if (layer_type.getAttributeNode("type").getValue().equals(layer)){
							readNetwork = true;

						}
						if (layer.equals("interlayer")){
							readNetwork = true;
						}
					}															
				}else {
					readNetwork=true;
				}
				if (readNetwork){
					Element element_domain = (Element) nodes_domains.item(j);
					NodeList nodes_domain_id = element_domain.getElementsByTagName("domain_id");
					for (int k = 0; k < nodes_domain_id.getLength(); k++) {
						Element domain_id_e = (Element) nodes_domain_id.item(0);
						domain_id = getCharacterDataFromElement(domain_id_e);
						log.info("Looking for nodes in domain: " + domain_id);
					}

					NodeList nodes = element1.getElementsByTagName("node");
					for (int i = 0; i < nodes.getLength(); i++) {
						Element element = (Element) nodes.item(i);
						NodeList router_id_node = element.getElementsByTagName("router_id");
						Element router_id_e = (Element) router_id_node.item(0);
						String router_id = getCharacterDataFromElement(router_id_e);

						log.info("Adding router_id " + router_id);
						router_id_addr = EdgeUtils.getEdge(router_id);
						graph.addVertex(router_id_addr);

						log.info("About to look for SID");
						NodeList SID_aux = element.getElementsByTagName("sid");
						Element SID_e = (Element) SID_aux.item(0);
						if (SID_e!=null)
						{ 
							log.info("SID existe");
							int SID = Integer.parseInt(getCharacterDataFromElement(SID_e));

							try { //Router_type: DatapathID
								SIDS.put((Inet4Address) router_id_addr,SID);
								log.info("SID of node Inet4Address: "+SID);
							} catch (Exception e) { //Router_type: DatapathID
								SIDSDP.put((DataPathID)router_id_addr, SID);
								log.info("SID of node DataPathID: "+SID);
							}
						}
						else
						{
							log.info("SID not found");
						}

					}
				}
			}	


			//Next pass to get all the links
			for (int j = 0; j < nodes_domains.getLength(); j++) {

				boolean readNetwork=false;
				Element element1 = (Element) nodes_domains.item(j);

				if (layer!=null){				
					NodeList domain_layer = element1.getElementsByTagName("layer");					
					if (domain_layer.getLength()==1){						
						Element layer_type = (Element) domain_layer.item(0);
						log.info("Layer: " + layer_type.getAttributeNode("type").getValue());
						log.info("Reading Topology");
						if (layer_type.getAttributeNode("type").getValue().equals(layer)){
							readNetwork = true;
						}	
					}															
				}else {
					readNetwork=true;
				}
				log.info("Read network = "+readNetwork);
				if (readNetwork){
					Element element_domain = (Element) nodes_domains.item(j);
					NodeList nodes_domain_id = element_domain.getElementsByTagName("domain_id");

					for (int k = 0; k < nodes_domain_id.getLength(); k++) {
						Element domain_id_e = (Element) nodes_domain_id.item(0);
						domain_id = getCharacterDataFromElement(domain_id_e);
						log.info("Looking for links in domain: " + domain_id);
					}
					int numLabels=0;

					Boolean commonBitmapLabelSet = false;
					NodeList edgeCommon = doc.getElementsByTagName("edgeCommon");
					int grid=0;
					int cs=0;
					int n=0;
					for (int i = 0; i < edgeCommon.getLength(); i++) {

						Element edgeCommonElement = (Element) edgeCommon.item(i);
						NodeList availableLabels_node = edgeCommonElement.getElementsByTagName("AvailableLabels");
						for (int k = 0; k < availableLabels_node.getLength(); k++) {

							Element availableLabels_e = (Element) availableLabels_node.item(k);
							NodeList labelSetField_node = availableLabels_e.getElementsByTagName("LabelSetField");
							Element labelSetField_el = (Element) labelSetField_node.item(0);
							if (labelSetField_el.getAttributeNode("type").getValue().equals("4")){//Tengo BitMapSet
								//Crear un BitMapSet

								NodeList numbLabels_node = labelSetField_el.getElementsByTagName("numLabels");

								Element numbLabels_e = (Element) numbLabels_node.item(0);
								String numbLabels_s = getCharacterDataFromElement(numbLabels_e);						
								numLabels=Integer.parseInt(numbLabels_s);	

								NodeList baseLabel_node = labelSetField_el.getElementsByTagName("baseLabel");
								Element baseLabel_e = (Element) baseLabel_node.item(0);

								float min_frequency;

								grid= Integer.parseInt(baseLabel_e.getAttributeNode("grid").getValue());

								cs = Integer.parseInt(baseLabel_e.getAttributeNode("cs").getValue());
								boolean n_frequency_included=false;
								if (baseLabel_e.getAttributeNode("n") != null ){
									n = Integer.parseInt(baseLabel_e.getAttributeNode("n").getValue());
									n_frequency_included = true;
								}
								else if (baseLabel_e.getAttributeNode("min_frequency") != null){
									String s_min_frequency = labelSetField_el.getAttributeNode("min_frequency").getValue();

									min_frequency=Float.parseFloat(s_min_frequency);	
									n = ((int)min_frequency - 1471)/20;
									n_frequency_included=true;
								}
								if (n_frequency_included){
									commonBitmapLabelSet = true;
								}else{
									log.info("ERROR reading the xml file of the topology, you should enter <baseLabel grid=\"1\" cs=\"2\" n=\"-11\"></baseLabel> ");
								}

							}
						}

					}
					/*if(isSSONnetwork ==true){
						if(cs==4){
							numLabels=numLabels*4;
						}
						else if (cs==5){
							numLabels=numLabels*8;
						}
					}*/

					NodeList edges = element_domain.getElementsByTagName("edge");
					for (int i = 0; i < edges.getLength(); i++) {
						log.info("New Edge");
						Element element = (Element) edges.item(i);
						//By default, all nodes are intradomain
						String type;
						Attr attr_type=element.getAttributeNode("type");
						if (attr_type==null){
							type="intradomain";
						}else {
							type=attr_type.getValue();
							if (allDomains){
								if (type.equals("interdomain")){
									type="intradomain";
								}
							}

							else if (type.equals("interlayer")){
								if (layer.equals("interlayer")){
									type="intradomain";
								}

							}
						}	
						log.info("type::"+type);
						if (type.equals("intradomain")) {						
							IntraDomainEdge edge = new IntraDomainEdge();
							log.info("New Intradomain Edge");
							NodeList source = element.getElementsByTagName("source");
							Element source_router_el = (Element) source.item(0);

							NodeList source_router_id = source_router_el.getElementsByTagName("router_id");
							Element source_router_id_el = (Element) source_router_id.item(0);
							String s_r_id = getCharacterDataFromElement(source_router_id_el);
							s_router_id_addr= EdgeUtils.getEdge(s_r_id);

							NodeList source_if_id_nl = source_router_el.getElementsByTagName("if_id");
							Element source_if_id_el = (Element) source_if_id_nl.item(0);
							String s_source_if_id;
							int src_if_id = -1;
							if (source_if_id_el!=null){
								s_source_if_id = getCharacterDataFromElement(source_if_id_el);
								src_if_id = Integer.parseInt(s_source_if_id);
							}
							log.info("SRC if id: "+src_if_id);

							NodeList source_Numif_id_nl = source_router_el.getElementsByTagName("NumIf_id");
							Element source_Numif_id_el = (Element) source_Numif_id_nl.item(0);
							String s_source_Numif_id;
							if (source_Numif_id_el!=null){
								s_source_Numif_id = getCharacterDataFromElement(source_Numif_id_el);
								try { // src_Numif_id type : Inet4Address
									src_Numif_id = (Inet4Address) Inet4Address.getByName(s_source_Numif_id);
								} catch (Exception e) { // src_Numif_id type : DataPathID
									src_Numif_id =  DataPathID.getByName(s_source_Numif_id);
								}
							}

							NodeList dest_nl = element.getElementsByTagName("destination");
							Element dest_el = (Element) dest_nl.item(0);

							NodeList dest_router_id_nl = dest_el.getElementsByTagName("router_id");
							Element dest_router_id_el = (Element) dest_router_id_nl.item(0);
							String d_r_id = getCharacterDataFromElement(dest_router_id_el);
							d_router_id_addr= EdgeUtils.getEdge(d_r_id);

							//Anyadimos los SID
							if (SIDS.get(s_router_id_addr)!=null && SIDS.get(d_router_id_addr)!=null)
							{
								log.info("setting SIDS src: "+SIDS.get(s_router_id_addr)+" dst: "+SIDS.get(d_router_id_addr));
								edge.setSrc_sid(SIDS.get(s_router_id_addr));
								edge.setDst_sid(SIDS.get(d_router_id_addr));
								log.info("edge.getSrc_sid(): "+edge.getSrc_sid());
								log.info("edge.getDst_sid(): "+edge.getDst_sid());
							}
							else if (SIDSDP.get(s_router_id_addr)!=null && SIDSDP.get(d_router_id_addr)!=null)
							{
								log.info("setting SIDSDP src: "+SIDSDP.get(s_router_id_addr)+" dst: "+SIDSDP.get(d_router_id_addr));
								edge.setSrc_sid(SIDSDP.get(s_router_id_addr));
								edge.setDst_sid(SIDSDP.get(d_router_id_addr));
								log.info("edge.getSrc_sid(): "+edge.getSrc_sid());
								log.info("edge.getDst_sid(): "+edge.getDst_sid());
							}


							NodeList dest_if_id_nl = dest_el.getElementsByTagName("if_id");
							Element dest_if_id_el= (Element) dest_if_id_nl.item(0);
							String s_dest_if_id;
							int dst_if_id = -1;
							if (dest_if_id_el!=null){
								s_dest_if_id = getCharacterDataFromElement(dest_if_id_el);
								dst_if_id = Integer.parseInt(s_dest_if_id);
							}
							log.info("DST if id: "+dst_if_id);

							NodeList dest_Numif_id_nl = dest_el.getElementsByTagName("NumIf_id");
							Element dest_Numif_id_el = (Element) dest_Numif_id_nl.item(0);
							String s_dest_Numif_id;

							if (source_Numif_id_el!=null){
								s_dest_Numif_id = getCharacterDataFromElement(dest_Numif_id_el);

								try { // s_dest_Numif_id type : Inet4Address
									dst_Numif_id = (Inet4Address) Inet4Address.getByName(s_dest_Numif_id);
								} catch (Exception e) { // s_dest_Numif_id type : DataPathID 
									dst_Numif_id =  DataPathID.getByName(s_dest_Numif_id);
								}
							}
							// Añadimos interfaces Numeradas
							if (src_Numif_id!=null){
								edge.setSrc_Numif_id(src_Numif_id);
							}if (dst_Numif_id!=null){
								edge.setDst_Numif_id(dst_Numif_id);
							}else{
								if (src_if_id != -1){
									edge.setSrc_if_id(src_if_id);
								}
								if (dst_if_id != -1){
									edge.setDst_if_id(dst_if_id);
								}
							}

							//DELAY, IF IT COMES..
							NodeList delay_ms_nl = element.getElementsByTagName("delay");
							if (delay_ms_nl.getLength()>0){

								Element delay_ms_el = (Element)delay_ms_nl.item(0);
								String s_delay_ms=getCharacterDataFromElement(delay_ms_el);
								double delay_ms=Double.parseDouble(s_delay_ms);
								edge.setDelay_ms(delay_ms);
							}

							//TE Link information
							NodeList maximum_bandwidth_nl = element.getElementsByTagName("maximum_bandwidth");
							if (maximum_bandwidth_nl!=null){
								if (maximum_bandwidth_nl.getLength()>0){
									if(edge.getTE_info()==null){
										TE_Information tE_info= new TE_Information();
										if (commonBitmapLabelSet){
											if(lambdaEnd!=Integer.MAX_VALUE){

												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n,lambdaIni,lambdaEnd);
											}
											else
												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n);
										}
										//tid.util.FuncionesUtiles.printByte(((BitmapLabelSet)tE_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved(),"getBytesBitmapReserved1:");
										edge.setTE_info(tE_info);

									} else {
										TE_Information te_info = edge.getTE_info();
										if (commonBitmapLabelSet){
											//	if(lambdaEnd!=Integer.MAX_VALUE){

											//	te_info.createBitmapLabelSet(numLabels, grid,  cs, n,lambdaIni,lambdaEnd);
											//	}
											//	else
											te_info.createBitmapLabelSet(numLabels, grid,  cs, n);
										}
										//tid.util.FuncionesUtiles.printByte(((BitmapLabelSet)tE_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved(),"getBytesBitmapReserved1:");
										edge.setTE_info(te_info);
									}

									Element maximum_bandwidth_el = (Element) maximum_bandwidth_nl.item(0);
									String s_maximum_bandwidth = getCharacterDataFromElement(maximum_bandwidth_el);

									float maximum_bandwidth=Float.parseFloat(s_maximum_bandwidth);
									MaximumBandwidth maximumBandwidth =new MaximumBandwidth();
									maximumBandwidth.setMaximumBandwidth(maximum_bandwidth);
									(edge.getTE_info()).setMaximumBandwidth(maximumBandwidth);

								}
							}
							/**
							 * NodeList SID_aux = element.getElementsByTagName("sid");
						Element SID_e = (Element) SID_aux.item(0);
						if (SID_e!=null)
						{ 
							log.info("SID existe");
							int SID = Integer.parseInt(getCharacterDataFromElement(SID_e));
							SIDS.put(router_id_addr,SID);
							log.info("SID of node: "+SID);
						}
						else
						{
							log.info("SID not found");
						}
							 */

							NodeList defaultmetric = element.getElementsByTagName("default_te_metric");
							Element metric_aux = (Element) defaultmetric.item(0);

							if (metric_aux != null){
								String s_metric_aux = getCharacterDataFromElement(metric_aux);
								TE_Information tE_info;
								int metric = Integer.parseInt(s_metric_aux);
								DefaultTEMetricLinkAttribTLV defaultTeMetric= new DefaultTEMetricLinkAttribTLV();
								if(edge.getTE_info()==null){
									tE_info= new TE_Information();
								}
								else{
									tE_info = edge.getTE_info();
								}
								defaultTeMetric.setLinkMetric((long)metric);
								tE_info.setDefaultTEMetric(defaultTeMetric);
								edge.setTE_info(tE_info);
							}

							NodeList unreserved_bandwidth_nl = element.getElementsByTagName("unreserved_bandwidth");
							if (unreserved_bandwidth_nl!=null){
								int num_u_b=unreserved_bandwidth_nl.getLength();
								UnreservedBandwidth unreservedBandwidth;
								if (num_u_b>0){
									if(edge.getTE_info()==null){
										TE_Information tE_info= new TE_Information();
										if (commonBitmapLabelSet){
											if(lambdaEnd!=Integer.MAX_VALUE)
												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n,lambdaIni,lambdaEnd);
											else
												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n);
										}
										edge.setTE_info(tE_info);
									}
									unreservedBandwidth =new UnreservedBandwidth();
									(edge.getTE_info()).setUnreservedBandwidth(unreservedBandwidth);
									for(int k=0;k<num_u_b;++k){
										Element unreserved_bandwidth_el = (Element) unreserved_bandwidth_nl.item(k);
										String s_unreserved_bandwidth = getCharacterDataFromElement(unreserved_bandwidth_el);

										String s_priority=unreserved_bandwidth_el.getAttributeNode("priority").getValue();
										Integer priority = Integer.valueOf(s_priority);
										float unreserved_bandwidth=Float.parseFloat(s_unreserved_bandwidth);	

										(unreservedBandwidth.getUnreservedBandwidth())[priority]=unreserved_bandwidth;
									}
								}


							}

							NodeList maximum_wlans_nl = element.getElementsByTagName("number_wlans");
							if (maximum_wlans_nl!=null){
								if (maximum_wlans_nl.getLength()>0){
									if(edge.getTE_info()==null){
										TE_Information tE_info= new TE_Information();

										if (commonBitmapLabelSet){
											if(lambdaEnd!=Integer.MAX_VALUE){

												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n,lambdaIni,lambdaEnd);
											}
											else
												tE_info.createBitmapLabelSet(numLabels, grid,  cs, n);
										}
										//tid.util.FuncionesUtiles.printByte(((BitmapLabelSet)tE_info.getAvailableLabels().getLabelSet()).getBytesBitmapReserved(),"getBytesBitmapReserved1:");
										edge.setTE_info(tE_info);

									}

									Element number_wlan_el = (Element) maximum_wlans_nl.item(0);
									String s_number_wlans = getCharacterDataFromElement(number_wlan_el);

									int number_wlans=Integer.parseInt(s_number_wlans.replace("\n", "").replaceAll("\\s",""));
									(edge.getTE_info()).setNumberWLANs(number_wlans);
									(edge.getTE_info()).initWLANs();

								}
							}

							if(edge.getTE_info()==null){
								TE_Information tE_info= new TE_Information();							
								edge.setTE_info(tE_info);
							}
							if (commonBitmapLabelSet){
								if(lambdaEnd!=Integer.MAX_VALUE)
									edge.getTE_info().createBitmapLabelSet(numLabels, grid,  cs, n,lambdaIni,lambdaEnd);
								else
									edge.getTE_info().createBitmapLabelSet(numLabels, grid,  cs, n);
							}

							NodeList availableLabels_node = element.getElementsByTagName("AvailableLabels");
							if ( availableLabels_node != null){
								for (int k = 0; k < availableLabels_node.getLength(); k++) {
									Element availableLabels_e = (Element) availableLabels_node.item(k);
									NodeList labelSetField_node = availableLabels_e.getElementsByTagName("LabelSetField");
									Element labelSetField_el = (Element) labelSetField_node.item(0);
									if (labelSetField_el.getAttributeNode("type").getValue().equals("4")){//Tengo BitMapSet

										NodeList numbLabels_node = labelSetField_el.getElementsByTagName("numLabels");

										Element numbLabels_e = (Element) numbLabels_node.item(0);
										String numbLabels_s = getCharacterDataFromElement(numbLabels_e);						
										numLabels=Integer.parseInt(numbLabels_s);	

										NodeList baseLabel_node = labelSetField_el.getElementsByTagName("baseLabel");
										Element baseLabel_e = (Element) baseLabel_node.item(0);

										byte[] bitmap=new byte[1];
										NodeList bitmap_node = labelSetField_el.getElementsByTagName("bitmap");
										int result=0;
										Element bitmap_e = (Element) bitmap_node.item(0);
										if (bitmap_e!=null){
											String bitmap_string=getCharacterDataFromElement(bitmap_e);
											System.out.println("Bitmap read: "+bitmap_string);
											for (int p =0; p<bitmap_string.length(); p++)
												result= (int) (result+Math.pow(2, bitmap_string.length()-p-1)*(bitmap_string.charAt(p)-48));
											bitmap[0]=(byte) result;
											((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).setBytesBitmap(bitmap);
										}
										float min_frequency;

										grid= Integer.parseInt(baseLabel_e.getAttributeNode("grid").getValue());

										cs = Integer.parseInt(baseLabel_e.getAttributeNode("cs").getValue());
										boolean n_frequency_included=false;
										if (baseLabel_e.getAttributeNode("n") != null ){
											n = Integer.parseInt(baseLabel_e.getAttributeNode("n").getValue());
											n_frequency_included = true;
										}
										else if (baseLabel_e.getAttributeNode("min_frequency") != null){
											String s_min_frequency = labelSetField_el.getAttributeNode("min_frequency").getValue();

											min_frequency=Float.parseFloat(s_min_frequency);	
											n = ((int)min_frequency - 1471)/20;
											n_frequency_included=true;
										}
										if (n_frequency_included){/*Modify availableLabels*/
											((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).setNumLabels(numLabels);
											((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).getDwdmWavelengthLabel().setGrid(grid);
											((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).getDwdmWavelengthLabel().setChannelSpacing(cs);
											((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).getDwdmWavelengthLabel().setN(n);
										}
										else{
											log.info("ERROR reading the xml file of the topology, you should enter <baseLabel grid=\"1\" cs=\"2\" n=\"-11\"></baseLabel> ");
										}
									}
								}

							}
							log.info("Preparing to add edge");
							try{
								if(graph.containsEdge(s_router_id_addr, d_router_id_addr)){
									graph.getEdge(s_router_id_addr, d_router_id_addr).setNumberFibers(graph.getEdge(s_router_id_addr, d_router_id_addr).getNumberFibers()+1);
								}else{
									log.info("s_router_id_addr: "+s_router_id_addr.toString()+"; d_router_id_addr: "+d_router_id_addr.toString()+"; edge: "+edge);
									graph.addEdge(s_router_id_addr, d_router_id_addr, edge);
									graph.getEdge(s_router_id_addr, d_router_id_addr).setNumberFibers(1);
								}
							}catch(Exception e){
								log.info("Problem with source "+s_router_id_addr+" destination "+d_router_id_addr);
								e.printStackTrace();
								System.exit(-1);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Info graph edge :: "+graph.edgeSet());
		return graph;
	}



	public static SimpleDirectedWeightedGraph<Object,IntraDomainEdge> readITNetwork(String fileName){
		Logger log=Logger.getLogger("PCEPServer");
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graph =new SimpleDirectedWeightedGraph<Object,IntraDomainEdge>(IntraDomainEdge.class);
		Object router_id_addr = null;
		Object it_site_id_addr = null;
		Object resource_addr = null;
		Object s_id_addr = null;
		Object d_id_addr = null;
		Object s_router_id_addr = null;
		Object d_router_id_addr = null;
		Object s_it_site_id_addr = null;
		Object d_it_site_id_addr = null;
		Object s_resource_id_addr = null;
		Object d_resource_id_addr = null;

		log.info("2. SimpleDirectedWeightedGraph");

		File file = new File(fileName);
		try {
			DocumentBuilder builder =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodes_domains = doc.getElementsByTagName("domain");
			HashMap<Inet4Address, Integer >SIDS   = new HashMap<Inet4Address,Integer>();
			HashMap<DataPathID,   Integer >SIDSDP = new HashMap<DataPathID,Integer>();

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
				for (int k = 0; k < nodes_domain_id.getLength(); k++) {
					Element domain_id_e = (Element) nodes_domain_id.item(0);
					String domain_id=getCharacterDataFromElement(domain_id_e);
					log.info("Network domain: "+domain_id);
				}

				NodeList nodes = doc.getElementsByTagName("node");
				for (int i = 0; i < nodes.getLength(); i++) {
					Element element = (Element) nodes.item(i);
					NodeList router_id_node = element.getElementsByTagName("router_id");
					Element router_id_e = (Element) router_id_node.item(0);
					String router_id=getCharacterDataFromElement(router_id_e);
					log.info("El router_id es "+router_id);

					try { // router_id_addr type: Inet4Address
						router_id_addr = (Inet4Address) Inet4Address.getByName(router_id);
					} catch (Exception e) { // router_id_addr type: DataPathID
						router_id_addr =  DataPathID.getByName(router_id);
					}

					graph.addVertex(router_id_addr);

					Element SID_e = (Element) element.getElementsByTagName("sid");
					if (SID_e!=null)
					{	int SID = Integer.parseInt(getCharacterDataFromElement(SID_e));

					try { // router_id_addr type: Inet4Address
						SIDS.put((Inet4Address)router_id_addr,SID);
					} catch (Exception e) { // router_id_addr type: DataPathID
						SIDSDP.put((DataPathID)router_id_addr,SID);
					}
					}					
				}

				NodeList it_sites = doc.getElementsByTagName("it_site");
				for (int i = 0; i < it_sites.getLength(); i++) {
					Element element = (Element) it_sites.item(i);
					NodeList it_site_id_node = element.getElementsByTagName("it_site_id");
					Element it_site_id_e = (Element) it_site_id_node.item(0);
					String it_site_id=getCharacterDataFromElement(it_site_id_e);
					log.info("El IT_site_id es "+it_site_id);

					try { // it_site_id_addr type: Inet4Address
						it_site_id_addr = (Inet4Address) Inet4Address.getByName(it_site_id);
					} catch (Exception e) { // it_site_id_addr type: DataPathID
						it_site_id_addr =  DataPathID.getByName(it_site_id);
					}
					graph.addVertex(it_site_id_addr);
				}

				NodeList storages = doc.getElementsByTagName("storage");
				for (int i = 0; i < storages.getLength(); i++) {
					Element element = (Element) storages.item(i);
					NodeList resource_id_node = element.getElementsByTagName("resource_id");
					Element resource_id_e = (Element) resource_id_node.item(0);
					String resource_id=getCharacterDataFromElement(resource_id_e);
					log.info("El resource_id es "+resource_id);

					try {
						resource_addr = (Inet4Address) Inet4Address.getByName(resource_id);
					} catch (Exception e) {
						resource_addr =  DataPathID.getByName(resource_id);
					}
					graph.addVertex(resource_addr);
				}

				NodeList edges = doc.getElementsByTagName("edge");
				for (int i = 0; i < edges.getLength(); i++) {

					Element element = (Element) edges.item(i);

					// We only want those routers which have type="intradomain" //MARTA
					if (element.getAttributeNode("type").getValue().equals("intradomain")) {//MARTA
						//IntraDomainEdge edge = new IntraDomainEdge();

						IntraDomainEdge edge = new IntraDomainEdge();

						NodeList source = element.getElementsByTagName("source");
						Element source_router_el = (Element)source.item(0);
						NodeList source_router_id= source_router_el.getElementsByTagName("router_id");
						if (source_router_id.getLength()>0){
							Element source_router_id_el=(Element)source_router_id.item(0);
							String s_r_id=getCharacterDataFromElement(source_router_id_el);

							try { // s_router_id_addr type: Inet4Address
								s_router_id_addr = (Inet4Address) Inet4Address.getByName(s_r_id);
							} catch (Exception e) { // s_router_id_addr type: DataPathID
								s_router_id_addr =  DataPathID.getByName(s_r_id);
							}

							s_id_addr=s_router_id_addr;
						}

						NodeList source_it_site_id= source_router_el.getElementsByTagName("it_site_id");
						if (source_it_site_id.getLength()>0){
							Element source_it_site_id_el=(Element)source_it_site_id.item(0);
							String s_itsite_id=getCharacterDataFromElement(source_it_site_id_el);
							log.info("Edge Source IT_site_id: "+s_itsite_id);

							try { // s_it_site_id_addr type: Inet4Address
								s_it_site_id_addr = (Inet4Address) Inet4Address.getByName(s_itsite_id);
							} catch (Exception e) { // s_it_site_id_addr type: DataPathID
								s_it_site_id_addr =  DataPathID.getByName(s_itsite_id);
							}
							s_id_addr=s_it_site_id_addr;
						}

						NodeList source_resource_id= source_router_el.getElementsByTagName("resource_id");
						if (source_resource_id.getLength()>0){
							Element source_resource_id_el=(Element)source_resource_id.item(0);
							String s_resource_id=getCharacterDataFromElement(source_resource_id_el);
							log.info("Edge Source resource_id: "+s_resource_id);

							try {// s_resource_id_addr type: Inet4Address
								s_resource_id_addr = (Inet4Address) Inet4Address.getByName(s_resource_id);
							} catch (Exception e) { // s_resource_id_addr type: DataPathID
								s_resource_id_addr =  DataPathID.getByName(s_resource_id);
							}
							s_id_addr=s_resource_id_addr;
						}

						NodeList source_if_id_nl= source_router_el.getElementsByTagName("if_id");
						Element source_if_id_el=(Element)source_if_id_nl.item(0);
						String s_source_if_id=getCharacterDataFromElement(source_if_id_el);
						log.info("Edge Source if_id: "+s_source_if_id);
						int src_if_id=Integer.parseInt(s_source_if_id);



						NodeList dest_nl = element.getElementsByTagName("destination");
						Element dest_el = (Element)dest_nl.item(0);
						NodeList dest_router_id_nl= dest_el.getElementsByTagName("router_id");
						if (dest_router_id_nl.getLength()>0){
							Element dest_router_id_el=(Element)dest_router_id_nl.item(0);
							String d_r_id=getCharacterDataFromElement(dest_router_id_el);
							log.info("Edge Destination router_id: "+d_r_id);

							try { // d_router_id_addr type: Inet4Address
								d_router_id_addr = (Inet4Address) Inet4Address.getByName(d_r_id);
							} catch (Exception e) { // d_router_id_addr type: DataPathID
								d_router_id_addr =  DataPathID.getByName(d_r_id);

							}
							d_id_addr=d_router_id_addr;
						}


						NodeList dest_it_site_id_nl= dest_el.getElementsByTagName("it_site_id");
						if (dest_it_site_id_nl.getLength()>0){
							Element dest_it_site_id_el=(Element)dest_it_site_id_nl.item(0);
							String d_it_site_id=getCharacterDataFromElement(dest_it_site_id_el);
							log.info("Edge Destination IT_site_id: "+d_it_site_id);

							try { // d_it_site_id_addr type: Inet4Address
								d_it_site_id_addr = (Inet4Address) Inet4Address.getByName(d_it_site_id);
							} catch (Exception e) { // d_it_site_id_addr type: DataPathID
								d_it_site_id_addr =  DataPathID.getByName(d_it_site_id);
							}
							d_id_addr=d_it_site_id_addr;
						}

						NodeList dest_resource_id_nl= dest_el.getElementsByTagName("resource_id");
						if (dest_resource_id_nl.getLength()>0){
							Element dest_resource_id_el=(Element)dest_resource_id_nl.item(0);
							String d_resource_id=getCharacterDataFromElement(dest_resource_id_el);
							log.info("Edge Destination resource_id: "+d_resource_id);
							try { // d_resource_id_addr type: Inet4Address
								d_resource_id_addr = (Inet4Address) Inet4Address.getByName(d_resource_id);
							} catch (Exception e) { // d_resource_id_addr type: DataPathID
								d_resource_id_addr =  DataPathID.getByName(d_resource_id);

							}
							d_id_addr=d_resource_id_addr;
						}

						NodeList dest_if_id_nl= dest_el.getElementsByTagName("if_id");
						Element dest_if_id_el=(Element)dest_if_id_nl.item(0);
						String s_dest_if_id=getCharacterDataFromElement(dest_if_id_el);
						log.info("Edge Dest if_id: "+s_dest_if_id);
						int dst_if_id=Integer.parseInt(s_dest_if_id);


						edge.setSrc_if_id(src_if_id);
						edge.setDst_if_id(dst_if_id);


						//TODO: Tal vez pete aqui
						//Anyadimos los SID
						if (SIDS.get(s_id_addr)!=null && SIDS.get(d_id_addr)!=null)
						{
							edge.setSrc_sid(SIDS.get(s_id_addr));
							edge.setSrc_sid(SIDS.get(d_id_addr));
						}	

						graph.addEdge(s_id_addr, d_id_addr,edge);		       
					}//MARTA
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		 

		return graph;
	}


	public static Inet4Address readNetworkDomain(String fileName) {
		Logger log = Logger.getLogger("PCEPServer");
		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			Element element_domain = (Element) nodes_domains.item(0);
			NodeList nodes_domain_id = element_domain.getElementsByTagName("domain_id");
			Element domain_id_e = (Element) nodes_domain_id.item(0);
			String domain_id = getCharacterDataFromElement(domain_id_e);
			log.info("Network domain: " + domain_id);
			Inet4Address domId = (Inet4Address) Inet4Address
					.getByName(domain_id);
			return domId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		} else {
			return "?";
		}
	}
	
	/**
	 * Reads the inter-domain Topology from a topology XML file.
	 * Needs update to work with datapath IDs.
	 * @param fileName
	 */
	public static DirectedWeightedMultigraph<Object, InterDomainEdge> readMDNetwork(
			String fileName) {
		Logger log = Logger.getLogger("PCEPServer");
		DirectedWeightedMultigraph<Object, InterDomainEdge> graph = new DirectedWeightedMultigraph<Object, InterDomainEdge>(
				InterDomainEdge.class);
		Hashtable<Object, Inet4Address> router_id_domain_ed  = new Hashtable<Object, Inet4Address>();
		Hashtable<Object, DataPathID> router_id_domain_ed_dp = new Hashtable<Object, DataPathID>();

		HashMap<Inet4Address, Integer >SIDS   = new HashMap<Inet4Address,Integer>();
		HashMap<DataPathID,   Integer >SIDSDP = new HashMap<DataPathID,Integer>();

		Object router_id_addr = null;
		Object s_router_id_addr = null;
		Object d_router_id_addr = null;

		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			// First pass to read all the nodes and domains
			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id = element_domain
						.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str = getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id = (Inet4Address) Inet4Address
						.getByName(domain_id_str);

				log.info("Adding Domain: " + domain_id);
				graph.addVertex(domain_id);
				NodeList nodes = element_domain.getElementsByTagName("node");
				for (int i = 0; i < nodes.getLength(); i++) {
					Element element = (Element) nodes.item(i);
					NodeList router_id_node = element
							.getElementsByTagName("router_id");
					Element router_id_e = (Element) router_id_node.item(0);
					String router_id = getCharacterDataFromElement(router_id_e);
					log.fine("Router_id: " + router_id);
					try { // router_id_addr type: Inet4Address
						router_id_addr = (Inet4Address) Inet4Address.getByName(router_id);
					} catch (Exception e) { // router_id_addr type: DataPathID
						router_id_addr =  DataPathID.getByName(router_id);
					}
					router_id_domain_ed.put(router_id_addr, domain_id);
					NodeList nl_sid=element.getElementsByTagName("sid");

					Element SID_e = (Element) nl_sid.item(0);
					if (SID_e!=null)
					{	int SID = Integer.parseInt(getCharacterDataFromElement(SID_e));
					try {
						SIDS.put((Inet4Address)router_id_addr,SID);
					} catch (Exception e) {
						SIDSDP.put((DataPathID)router_id_addr,SID);
					}
					}
				}
				
			}
			log.fine("Domain_ids read");
			NodeList edges = doc.getElementsByTagName("edge");
			boolean a =true;




			for (int i = 0; i < edges.getLength(); i++) {
				log.fine("Looking at edge");

				Element element = (Element) edges.item(i);
				InterDomainEdge edge = new InterDomainEdge();

				NodeList source = element.getElementsByTagName("source");
				Element source_router_el = (Element) source.item(0);
				NodeList source_router_id = source_router_el
						.getElementsByTagName("router_id");
				Element source_router_id_el = (Element) source_router_id
						.item(0);
				String s_r_id = getCharacterDataFromElement(source_router_id_el);
				log.fine("Edge Source router_id: " + s_r_id);

				try { // s_router_id_addr type: Inet4Address
					s_router_id_addr = (Inet4Address) Inet4Address.getByName(s_r_id);
				} catch (Exception e) {// s_router_id_addr type: DataPathID
					s_router_id_addr =  DataPathID.getByName(s_r_id);
				}
				Inet4Address source_domain_id = router_id_domain_ed.get(s_router_id_addr);
				log.fine("Edge Source domain_id: " + source_domain_id);

				NodeList source_if_id_nl = source_router_el
						.getElementsByTagName("if_id");
				Element source_if_id_el = (Element) source_if_id_nl.item(0);
				String s_source_if_id = getCharacterDataFromElement(source_if_id_el);
				log.fine("Edge Source if_id: " + s_source_if_id);
				int src_if_id = Integer.parseInt(s_source_if_id);

				NodeList dest_nl = element.getElementsByTagName("destination");
				Element dest_el = (Element) dest_nl.item(0);
				NodeList dest_router_id_nl = dest_el
						.getElementsByTagName("router_id");
				Element dest_router_id_el = (Element) dest_router_id_nl.item(0);
				String d_r_id = getCharacterDataFromElement(dest_router_id_el);
				log.fine("Edge Destination router_id: " + d_r_id);
				try { // d_router_id_addr type: Inet4Address
					d_router_id_addr = (Inet4Address) Inet4Address.getByName(d_r_id);
				} catch (Exception e) { // d_router_id_addr type: DataPathID
					d_router_id_addr =  DataPathID.getByName(d_r_id);
				}
				Inet4Address dest_domain_id = router_id_domain_ed.get(d_router_id_addr);
				log.fine("Destination domain_id: " + dest_domain_id);

				NodeList dest_if_id_nl = dest_el.getElementsByTagName("if_id");
				Element dest_if_id_el = (Element) dest_if_id_nl.item(0);
				String s_dest_if_id = getCharacterDataFromElement(dest_if_id_el);
				log.fine("Edge Dest if_id: " + s_dest_if_id);
				int dst_if_id = Integer.parseInt(s_dest_if_id);

				//router_id_domain_ed
				//edge.setDomain_src_router(source_domain_id);

				edge.setSrc_if_id(src_if_id);
				edge.setDst_if_id(dst_if_id);
				edge.setDomain_src_router(source_domain_id);
				edge.setDomain_dst_router(dest_domain_id);

				edge.setSrc_router_id(s_router_id_addr);
				edge.setDst_router_id(d_router_id_addr);
				if (!source_domain_id.equals(dest_domain_id)) {
					log.info("Interdomain link added: "+edge.toString());
					//Only add if the source and destination domains are different
					graph.addEdge(source_domain_id, dest_domain_id, edge);
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return graph;

	}

	public static void initializeReachabilityFromFile(String fileName,
			ReachabilityManager rm) {
		Logger log = Logger.getLogger("PCEPServer");
		log.info("Initializng reachability from " + fileName);
		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id = element_domain
						.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str = getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id = (Inet4Address) Inet4Address
						.getByName(domain_id_str);

				log.info("Network domain es: " + domain_id);

				NodeList nodes = element_domain
						.getElementsByTagName("reachability_entry");
				log.info("HAY : " + nodes.getLength());

				for (int i = 0; i < nodes.getLength(); i++) {
					Element element = (Element) nodes.item(i);
					NodeList ipv4_address_node = element
							.getElementsByTagName("ipv4_address");
					Element ipv4_address_el = (Element) ipv4_address_node
							.item(0);
					String ipv4_address_str = getCharacterDataFromElement(ipv4_address_el);
					log.info("ipv4_address: " + ipv4_address_str);
					Inet4Address ipv4_address = (Inet4Address) Inet4Address
							.getByName(ipv4_address_str);
					IPv4prefixEROSubobject eroso = new IPv4prefixEROSubobject();
					eroso.setIpv4address(ipv4_address);
					NodeList prefix_node = element
							.getElementsByTagName("prefix");
					Element prefix_el = (Element) prefix_node.item(0);
					String prefix_str = getCharacterDataFromElement(prefix_el);
					int prefix = Integer.parseInt(prefix_str);
					eroso.setPrefix(prefix);
					rm.addEROSubobject(domain_id, eroso);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// IT update del GEYSERS

	public static DirectedWeightedMultigraph<Object,InterDomainEdge> readITMDNetwork(String fileName){
		Logger log=Logger.getLogger("PCEPServer");
		DirectedWeightedMultigraph<Object,InterDomainEdge>graph =new DirectedWeightedMultigraph<Object,InterDomainEdge>(InterDomainEdge.class);
		Hashtable <Object,Object> router_id_domain_ed=new Hashtable <Object,Object>();
		Hashtable <Object,Object> it_site_id_domain_ed2=new Hashtable <Object,Object>();
		Hashtable <Object,Object> resource_id_domain_ed=new Hashtable <Object,Object>();

		File file = new File(fileName);
		try {
			DocumentBuilder builder =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str=getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id= (Inet4Address) Inet4Address.getByName(domain_id_str);

				log.info("Network domain: "+domain_id);   
				graph.addVertex(domain_id);
				NodeList nodes = element_domain.getElementsByTagName("node");
				for (int i = 0; i < nodes.getLength(); i++) {
					Element element = (Element) nodes.item(i);
					NodeList router_id_node = element.getElementsByTagName("router_id");
					Element router_id_e = (Element) router_id_node.item(0);
					String router_id=getCharacterDataFromElement(router_id_e);
					log.info("El router_id es "+router_id);
					Inet4Address router_id_addr= (Inet4Address) Inet4Address.getByName(router_id);

					NodeList domain_id_node = element.getElementsByTagName("domain_id");
					router_id_domain_ed.put(router_id_addr, domain_id);
					//graph.addVertex(router_id_addr);

				}

				NodeList ITsites = element_domain.getElementsByTagName("it_site");
				for (int i = 0; i < ITsites.getLength(); i++) {
					Element element = (Element) ITsites.item(i);
					NodeList it_site_id_node = element.getElementsByTagName("it_site_id");
					Element it_site_id_e = (Element) it_site_id_node.item(0);
					String it_site_id=getCharacterDataFromElement(it_site_id_e);
					log.info("El it_site_id es "+it_site_id);
					Inet4Address it_site_id_addr= (Inet4Address) Inet4Address.getByName(it_site_id);

					NodeList domain_id_node = element.getElementsByTagName("domain_id");
					it_site_id_domain_ed2.put(it_site_id_addr, domain_id);
					//graph.addVertex(router_id_addr);

				}

				NodeList storages = element_domain.getElementsByTagName("storage");
				for (int i = 0; i < storages.getLength(); i++) {
					Element element = (Element) storages.item(i);
					NodeList resource_id_node = element.getElementsByTagName("resource_id");
					Element resource_id_e = (Element) resource_id_node.item(0);
					String resource_id=getCharacterDataFromElement(resource_id_e);
					log.info("El resource_id es "+resource_id);
					Inet4Address resource_id_addr= (Inet4Address) Inet4Address.getByName(resource_id);

					NodeList domain_id_node = element.getElementsByTagName("domain_id");
					resource_id_domain_ed.put(resource_id_addr, domain_id);
					//graph.addVertex(router_id_addr);

				}


			}



			NodeList edges = doc.getElementsByTagName("edge");
			for (int i = 0; i < edges.getLength(); i++) {
				log.info("New interdomain edge");
				Inet4Address s_router_id_addr= null;
				Inet4Address d_router_id_addr= null;
				Inet4Address s_itsite_id_addr= null;
				Inet4Address d_itsite_id_addr= null;
				Inet4Address s_resource_id_addr= null;
				Inet4Address d_resource_id_addr= null;
				Inet4Address source_domain_id=null;
				Inet4Address dest_domain_id=null;


				Element element = (Element) edges.item(i);
				InterDomainEdge edge =new InterDomainEdge();

				NodeList source = element.getElementsByTagName("source");
				Element source_router_el = (Element)source.item(0);
				NodeList source_router_id= source_router_el.getElementsByTagName("router_id");
				if (source_router_id.getLength()>0){
					Element source_router_id_el=(Element)source_router_id.item(0);
					String s_r_id=getCharacterDataFromElement(source_router_id_el);
					log.info("Edge Source router_id: "+s_r_id);
					s_router_id_addr= (Inet4Address) Inet4Address.getByName(s_r_id);
					source_domain_id=  (Inet4Address)router_id_domain_ed.get(s_router_id_addr);
					log.info("Edge Source domain_id: "+source_domain_id);
				}

				NodeList source_it_site_id= source_router_el.getElementsByTagName("it_site_id");
				if (source_it_site_id.getLength()>0){
					Element source_it_site_id_el=(Element)source_it_site_id.item(0);
					String s_itsite_id=getCharacterDataFromElement(source_it_site_id_el);
					log.info("Edge Source it_site_id: "+s_itsite_id);
					s_itsite_id_addr= (Inet4Address) Inet4Address.getByName(s_itsite_id);						
					source_domain_id=  (Inet4Address)it_site_id_domain_ed2.get(s_itsite_id_addr);
					log.info("Edge Source ITsite domain_id: "+source_domain_id);
				}

				NodeList source_resource_id= source_router_el.getElementsByTagName("resource_id");
				if (source_resource_id.getLength()>0){
					Element source_resource_id_el=(Element)source_resource_id.item(0);
					String s_resource_id=getCharacterDataFromElement(source_resource_id_el);
					log.info("Edge Source resource_id: "+s_resource_id);
					s_resource_id_addr= (Inet4Address) Inet4Address.getByName(s_resource_id);						
					source_domain_id=  (Inet4Address)resource_id_domain_ed.get(s_resource_id_addr);
					log.info("Edge Source ITsite domain_id: "+source_domain_id);
				}

				NodeList source_if_id_nl= source_router_el.getElementsByTagName("if_id");
				Element source_if_id_el=(Element)source_if_id_nl.item(0);
				String s_source_if_id=getCharacterDataFromElement(source_if_id_el);
				log.info("Edge Source if_id: "+s_source_if_id);
				int src_if_id=Integer.parseInt(s_source_if_id);

				NodeList dest_nl = element.getElementsByTagName("destination");
				Element dest_el = (Element)dest_nl.item(0);
				NodeList dest_router_id_nl= dest_el.getElementsByTagName("router_id");
				if (dest_router_id_nl.getLength()>0){
					Element dest_router_id_el=(Element)dest_router_id_nl.item(0);	
					String d_r_id=getCharacterDataFromElement(dest_router_id_el);
					log.info("Edge Destination router_id: "+d_r_id);
					d_router_id_addr= (Inet4Address) Inet4Address.getByName(d_r_id);
					dest_domain_id=  (Inet4Address)router_id_domain_ed.get(d_router_id_addr);
					log.info("Destination domain_id: "+dest_domain_id);
				}

				NodeList dest_it_site_id_nl= dest_el.getElementsByTagName("it_site_id");
				if (dest_it_site_id_nl.getLength()>0){				
					Element dest_it_site_id_el=(Element)dest_it_site_id_nl.item(0);
					String d_itsite_id=getCharacterDataFromElement(dest_it_site_id_el);
					log.info("Edge Destination it_site_id: "+d_itsite_id);
					d_itsite_id_addr= (Inet4Address) Inet4Address.getByName(d_itsite_id);						
					dest_domain_id=  (Inet4Address)it_site_id_domain_ed2.get(d_itsite_id_addr);						
					log.info("Destination ITsite domain_id: "+dest_domain_id);
				}

				NodeList dest_resource_id_nl= dest_el.getElementsByTagName("resource_id");
				if (dest_resource_id_nl.getLength()>0){				
					Element dest_resource_id_el=(Element)dest_resource_id_nl.item(0);
					String d_resource_id=getCharacterDataFromElement(dest_resource_id_el);
					log.info("Edge Destination resource_id: "+d_resource_id);
					d_resource_id_addr= (Inet4Address) Inet4Address.getByName(d_resource_id);						
					dest_domain_id=  (Inet4Address)resource_id_domain_ed.get(d_resource_id_addr);						
					log.info("Destination ITsite domain_id: "+dest_domain_id);
				}

				NodeList dest_if_id_nl= dest_el.getElementsByTagName("if_id");
				Element dest_if_id_el=(Element)dest_if_id_nl.item(0);
				String s_dest_if_id=getCharacterDataFromElement(dest_if_id_el);
				log.info("Edge Dest if_id: "+s_dest_if_id);
				int dst_if_id=Integer.parseInt(s_dest_if_id);

				edge.setSrc_if_id(src_if_id);
				edge.setDst_if_id(dst_if_id);

				if (source_router_id.getLength()>0){
					edge.setSrc_router_id(s_router_id_addr);
				}else if(source_it_site_id.getLength()>0){
					edge.setSrc_router_id(s_itsite_id_addr);
				}else if(source_resource_id.getLength()>0){
					edge.setSrc_router_id(s_resource_id_addr);
				}

				if (dest_router_id_nl.getLength()>0){
					edge.setDst_router_id(d_router_id_addr);
				}else if(dest_it_site_id_nl.getLength()>0){
					edge.setDst_router_id(d_itsite_id_addr);
				}else if(dest_resource_id_nl.getLength()>0){
					edge.setDst_router_id(d_resource_id_addr);
				}
				graph.addEdge(source_domain_id, dest_domain_id,edge);
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		

		return graph;

	}


	public static WSONInformation getWSONInformation(String fileName){
		return FileTEDBUpdater.getWSONInformation(fileName,null);
	}

	public static WSONInformation getWSONInformation(String fileName, String layer){
		Logger log = Logger.getLogger("PCEPServer");
		File file = new File(fileName);
		AvailableLabels commonAvailableLabels = null;
		WSONInformation WSONinfo = null;
		int numLabels = 0;
		int grid=0;
		int cs=0;
		int n=0;
		log.info("FileName:::"+fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);
			//			NodeList nodes_domains = doc.getElementsByTagName("domain");
			//			for (int j = 0; j < nodes_domains.getLength(); j++) {
			//				Element element_domain = (Element) nodes_domains.item(j);

			NodeList edgeCommon = doc.getElementsByTagName("edgeCommon");

			for (int i = 0; i < edgeCommon.getLength(); i++) {

				Element edgeCommonElement = (Element) edgeCommon.item(i);
				NodeList availableLabels_node = edgeCommonElement.getElementsByTagName("AvailableLabels");
				for (int k = 0; k < availableLabels_node.getLength(); k++) {
					commonAvailableLabels = new AvailableLabels();
					Element availableLabels_e = (Element) availableLabels_node.item(k);
					NodeList labelSetField_node = availableLabels_e.getElementsByTagName("LabelSetField");
					Element labelSetField_el = (Element) labelSetField_node.item(0);
					if (labelSetField_el.getAttributeNode("type").getValue().equals("4")){//Tengo BitMapSet
						//Crear un BitMapSet

						NodeList numbLabels_node = labelSetField_el.getElementsByTagName("numLabels");

						Element numbLabels_e = (Element) numbLabels_node.item(0);
						String numbLabels_s = getCharacterDataFromElement(numbLabels_e);						
						numLabels=Integer.parseInt(numbLabels_s);	

						NodeList baseLabel_node = labelSetField_el.getElementsByTagName("baseLabel");
						Element baseLabel_e = (Element) baseLabel_node.item(0);

						float min_frequency;

						grid= Integer.parseInt(baseLabel_e.getAttributeNode("grid").getValue());

						cs = Integer.parseInt(baseLabel_e.getAttributeNode("cs").getValue());
						boolean n_frequency_included=false;
						if (baseLabel_e.getAttributeNode("n") != null ){
							n = Integer.parseInt(baseLabel_e.getAttributeNode("n").getValue());
							n_frequency_included = true;
						}
						else if (baseLabel_e.getAttributeNode("min_frequency") != null){
							String s_min_frequency = labelSetField_el.getAttributeNode("min_frequency").getValue();

							min_frequency=Float.parseFloat(s_min_frequency);	
							n = ((int)min_frequency - 1471)/20;
							n_frequency_included=true;
						}
						if (n_frequency_included){
							createBitmapLabelSet(commonAvailableLabels,numLabels,grid,cs,n);
						}else{
							log.info("ERROR reading the xml file of the topology, you should enter <baseLabel grid=\"1\" cs=\"2\" n=\"-11\"></baseLabel> ");
						}

					}
				}

			}
			//}
		} catch (Exception e) {
			log.info(e.toString());
			e.printStackTrace();
		}
		if (commonAvailableLabels !=null){
			WSONinfo = new WSONInformation();
			WSONinfo.setCommonAvailableLabels(commonAvailableLabels);
			WSONinfo.setNumLambdas(numLabels);
			WSONinfo.setCs(cs);
			WSONinfo.setGrid(grid);
			WSONinfo.setnMin(n);
		}
		return WSONinfo;

	}

	public static SSONInformation getSSONInformation(String fileName){
		return FileTEDBUpdater.getSSONInformation(fileName,null);
	}

	public static SSONInformation getSSONInformation(String fileName, String layer){
		Logger log = Logger.getLogger("PCEPServer");
		File file = new File(fileName);
		AvailableLabels commonAvailableLabels = null;
		SSONInformation SSONinfo = null;
		int numLabels = 0;
		int grid=0;
		int cs=0;
		int n=0;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);
			//			NodeList nodes_domains = doc.getElementsByTagName("domain");
			//			for (int j = 0; j < nodes_domains.getLength(); j++) {
			//				Element element_domain = (Element) nodes_domains.item(j);

			NodeList edgeCommon = doc.getElementsByTagName("edgeCommon");

			for (int i = 0; i < edgeCommon.getLength(); i++) {

				Element edgeCommonElement = (Element) edgeCommon.item(i);
				NodeList availableLabels_node = edgeCommonElement.getElementsByTagName("AvailableLabels");
				for (int k = 0; k < availableLabels_node.getLength(); k++) {
					commonAvailableLabels = new AvailableLabels();
					Element availableLabels_e = (Element) availableLabels_node.item(k);
					NodeList labelSetField_node = availableLabels_e.getElementsByTagName("LabelSetField");
					Element labelSetField_el = (Element) labelSetField_node.item(0);
					if (labelSetField_el.getAttributeNode("type").getValue().equals("4")){//Tengo BitMapSet
						//Crear un BitMapSet

						NodeList numbLabels_node = labelSetField_el.getElementsByTagName("numLabels");

						Element numbLabels_e = (Element) numbLabels_node.item(0);
						String numbLabels_s = getCharacterDataFromElement(numbLabels_e);						
						numLabels=Integer.parseInt(numbLabels_s);	

						NodeList baseLabel_node = labelSetField_el.getElementsByTagName("baseLabel");
						Element baseLabel_e = (Element) baseLabel_node.item(0);

						float min_frequency;

						grid= Integer.parseInt(baseLabel_e.getAttributeNode("grid").getValue());

						cs = Integer.parseInt(baseLabel_e.getAttributeNode("cs").getValue());
						boolean n_frequency_included=false;
						if (baseLabel_e.getAttributeNode("n") != null ){
							n = Integer.parseInt(baseLabel_e.getAttributeNode("n").getValue());
							n_frequency_included = true;
						}
						else if (baseLabel_e.getAttributeNode("min_frequency") != null){
							String s_min_frequency = labelSetField_el.getAttributeNode("min_frequency").getValue();

							min_frequency=Float.parseFloat(s_min_frequency);	
							n = ((int)min_frequency - 1471)/20;
							n_frequency_included=true;
						}
						if (n_frequency_included){
							createBitmapLabelSet(commonAvailableLabels,numLabels,grid,cs,n);
						}else{
							log.info("ERROR reading the xml file of the topology, you should enter <baseLabel grid=\"1\" cs=\"2\" n=\"-11\"></baseLabel> ");
						}

					}
				}

			}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (commonAvailableLabels !=null){
			SSONinfo = new SSONInformation();
			SSONinfo.setCommonAvailableLabels(commonAvailableLabels);
			//			if(cs==5){
			//				SSONinfo.setNumLambdas(numLabels*8);
			//			}
			SSONinfo.setNumLambdas(numLabels);
			SSONinfo.setCs(cs);
			SSONinfo.setGrid(grid);
			SSONinfo.setnMin(n);
		}
		return SSONinfo;

	}
	public static void createBitmapLabelSet(AvailableLabels availableLabels,int numLabels,int grid, int cs,int n){
		//FIXME: no hay problema de que se salga el ancho de banda
		BitmapLabelSet bitmapLabelSet = new BitmapLabelSet();
		DWDMWavelengthLabel dwdmWavelengthLabel = new DWDMWavelengthLabel();
		dwdmWavelengthLabel.setGrid(grid);
		dwdmWavelengthLabel.setChannelSpacing(cs);
		dwdmWavelengthLabel.setN(n);
		bitmapLabelSet.setDwdmWavelengthLabel(dwdmWavelengthLabel);

		int numberBytes = numLabels/8;
		if ((numberBytes*8)<numLabels){
			numberBytes++;
		}
		byte[] bytesBitMap =  new byte[numberBytes];
		for (int i=0;i<numberBytes;i++)
			bytesBitMap[i]=0x00;	

		bitmapLabelSet.setBytesBitmap(bytesBitMap);
		bitmapLabelSet.setNumLabels(numLabels);

		availableLabels.setLabelSet(bitmapLabelSet);

	}
	public static void getDomainReachabilityFromFile(String fileName, ReachabilityEntry reachabilityEntry) {
		FileTEDBUpdater.getDomainReachabilityFromFile(fileName, reachabilityEntry,null);
	}

	public static Inet4Address getDomainIDfromSimpleDomain(String fileName) {
		Logger log = Logger.getLogger("PCEPServer");
		log.info("Initializng reachability from " + fileName);
		File file = new File(fileName);
		Inet4Address domain_id = null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			Element element_domain = (Element) nodes_domains.item(0);
			NodeList nodes_domain_id = element_domain.getElementsByTagName("domain_id");
			Element domain_id_e = (Element) nodes_domain_id.item(0);
			String domain_id_str = getCharacterDataFromElement(domain_id_e);
			domain_id = (Inet4Address) Inet4Address.getByName(domain_id_str);
			log.info("El dominio leido es: " + domain_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return domain_id;
	}

	public static void getDomainReachabilityFromFile(String fileName,
			/*byte[] domainReachabilityIPv4Prefix,*/ ReachabilityEntry reachabilityEntry,String layer) {
		Logger log = Logger.getLogger("PCEPServer");
		log.info("Initializng reachability from " + fileName);
		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			for (int j = 0; j < nodes_domains.getLength(); j++) {
				boolean readNetwork=false;
				if (layer!=null){
					NodeList nodes_layer = doc.getElementsByTagName("layer");
					for (int i = 0; i < nodes_layer.getLength(); i++) {
						Element element = (Element) nodes_layer.item(i);
						String layer2 =getCharacterDataFromElement(element);
						if (layer2.equals(layer)){
							readNetwork=true;
						}

					}
				}else {
					readNetwork=true;
				}
				if (readNetwork){


					Element element_domain = (Element) nodes_domains.item(j);
					NodeList nodes_domain_id = element_domain
							.getElementsByTagName("domain_id");
					Element domain_id_e = (Element) nodes_domain_id.item(0);
					String domain_id_str = getCharacterDataFromElement(domain_id_e);
					Inet4Address domain_id = (Inet4Address) Inet4Address
							.getByName(domain_id_str);
					reachabilityEntry.setDomainId(domain_id);
					log.info("Network domain es: " + domain_id);
					NodeList nodes = element_domain
							.getElementsByTagName("reachability_entry");


					for (int i = 0; i < nodes.getLength(); i++) {
						Element element = (Element) nodes.item(i);
						NodeList ipv4_address_node = element
								.getElementsByTagName("ipv4_address");
						Element ipv4_address_el = (Element) ipv4_address_node
								.item(0);
						String ipv4_address_str = getCharacterDataFromElement(ipv4_address_el);
						log.info("ipv4_address: " + ipv4_address_str);
						Inet4Address ipv4_address = (Inet4Address) Inet4Address
								.getByName(ipv4_address_str);
						reachabilityEntry.setAggregatedIPRange(ipv4_address);
						//FIXME: dudas de esto. Si asignar la IP o copiarla byte a byte con arraycopy
						/*	System.arraycopy(ipv4_address.getAddress(), 0,
							reachabilityEntry.getAggregatedIPRange(), 0, 4);*/
						IPv4prefixEROSubobject eroso = new IPv4prefixEROSubobject();
						NodeList prefix_node = element
								.getElementsByTagName("prefix");
						Element prefix_el = (Element) prefix_node.item(0);
						String prefix_str = getCharacterDataFromElement(prefix_el);
						int prefix = Integer.parseInt(prefix_str);
						//Meto el prefijo
						reachabilityEntry.setPrefix(prefix);
						long resta = ((long) 0x1 << prefix) - 1;
						long maskLong = resta << (32 - prefix);
						byte[] mask = new byte[4];
						mask[0] = (byte) (maskLong >>> 24 & 0xFF);
						mask[1] = (byte) (maskLong >>> 16 & 0xFF);
						mask[2] = (byte) (maskLong >>> 8 & 0xFF);
						mask[3] = (byte) (maskLong & 0xFF);
						//Meto la mascara
						reachabilityEntry.setMask(mask);


					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Read the interdomain Topology from a topology file
	 */
	public static LinkedList<InterDomainEdge> readInterDomainLinks(String fileName) {

		LinkedList<InterDomainEdge> interDomainLinks = new LinkedList<InterDomainEdge>();
		Logger log = Logger.getLogger("PCEPServer");
		File file = new File(fileName);
		Inet4Address domain_id=null;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);

			NodeList nodes_domains = doc.getElementsByTagName("domain");
			if (nodes_domains!=null){
				if (nodes_domains.getLength()>=1){
					for (int j = 0; j < nodes_domains.getLength(); j++) {
						Element element_domain = (Element) nodes_domains.item(j);
						NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
						Element domain_id_e = (Element) nodes_domain_id.item(0);
						String domain_id_str=getCharacterDataFromElement(domain_id_e);
						domain_id= (Inet4Address) Inet4Address.getByName(domain_id_str);
					}
				}
			}



			Boolean commonBitmapLabelSet = false;
			NodeList edgeCommon = doc.getElementsByTagName("edgeCommon");
			int grid=0;
			int cs=0;
			int n=0;
			int numLabels=0;
			for (int i = 0; i < edgeCommon.getLength(); i++) {

				Element edgeCommonElement = (Element) edgeCommon.item(i);
				NodeList availableLabels_node = edgeCommonElement.getElementsByTagName("AvailableLabels");
				for (int k = 0; k < availableLabels_node.getLength(); k++) {

					Element availableLabels_e = (Element) availableLabels_node.item(k);
					NodeList labelSetField_node = availableLabels_e.getElementsByTagName("LabelSetField");
					Element labelSetField_el = (Element) labelSetField_node.item(0);
					if (labelSetField_el.getAttributeNode("type").getValue().equals("4")){//Tengo BitMapSet
						//Crear un BitMapSet

						NodeList numbLabels_node = labelSetField_el.getElementsByTagName("numLabels");

						Element numbLabels_e = (Element) numbLabels_node.item(0);
						String numbLabels_s = getCharacterDataFromElement(numbLabels_e);						
						numLabels=Integer.parseInt(numbLabels_s);	

						NodeList baseLabel_node = labelSetField_el.getElementsByTagName("baseLabel");
						Element baseLabel_e = (Element) baseLabel_node.item(0);

						float min_frequency;

						grid= Integer.parseInt(baseLabel_e.getAttributeNode("grid").getValue());

						cs = Integer.parseInt(baseLabel_e.getAttributeNode("cs").getValue());
						boolean n_frequency_included=false;
						if (baseLabel_e.getAttributeNode("n") != null ){
							n = Integer.parseInt(baseLabel_e.getAttributeNode("n").getValue());
							n_frequency_included = true;
						}
						else if (baseLabel_e.getAttributeNode("min_frequency") != null){
							String s_min_frequency = labelSetField_el.getAttributeNode("min_frequency").getValue();

							min_frequency=Float.parseFloat(s_min_frequency);	
							n = ((int)min_frequency - 1471)/20;
							n_frequency_included=true;
						}
						if (n_frequency_included){
							commonBitmapLabelSet = true;
						}else{
							log.info("ERROR reading the xml file of the topology, you should enter <baseLabel grid=\"1\" cs=\"2\" n=\"-11\"></baseLabel> ");
						}

					}
				}

			}


			// Read the nodes of the domain which has interdomain connection
			NodeList edges = doc.getElementsByTagName("edge");
			for (int i = 0; i < edges.getLength(); i++) {
				Element element = (Element) edges.item(i);

				// We only want those routers which have type="interdomain"
				//if (((String)element.getAttributeNode("type").getValue()).equals("interdomain")) {

				if (element.getAttributeNode("type")!=null) {


					if (element.getAttributeNode("type").getValue().equals("interdomain")) {

						// Create a variable InterDomainEdge where we include
						// the two nodes of the connection.
						InterDomainEdge connection = new InterDomainEdge();
						NodeList source = element.getElementsByTagName("source");
						Element source_router_el = (Element) source.item(0);
						//Read the source router IP
						NodeList source_router_id = source_router_el.getElementsByTagName("router_id");
						Element source_router_id_el = (Element) source_router_id.item(0);
						String s_r_id = getCharacterDataFromElement(source_router_id_el);

						Inet4Address s_router_id_addr = (Inet4Address) Inet4Address.getByName(s_r_id);
						//Read the source router interface identifier of the connection
						NodeList source_if_id_nl = source_router_el.getElementsByTagName("if_id");
						Element source_if_id_el = (Element) source_if_id_nl.item(0);
						String s_source_if_id = getCharacterDataFromElement(source_if_id_el);

						int src_if_id = Integer.parseInt(s_source_if_id);
						NodeList src_domain_nl = source_router_el.getElementsByTagName("domain_id");
						Inet4Address s_router_domain=null;

						if (src_domain_nl!=null)
						{
							if (src_domain_nl.getLength()>=1){
								Element domain_id_el = (Element) src_domain_nl.item(0);
								String s_r_domain = getCharacterDataFromElement(domain_id_el).trim();
								s_router_domain = (Inet4Address) Inet4Address.getByName(s_r_domain);

							}else{
								s_router_domain= domain_id;

							}
						}else {
							s_router_domain= domain_id;

						}



						//Read the router destination
						NodeList dest_nl = element.getElementsByTagName("destination");
						Element dest_el = (Element) dest_nl.item(0);
						NodeList dest_router_id_nl = dest_el.getElementsByTagName("router_id");
						Element dest_router_id_el = (Element) dest_router_id_nl.item(0);
						String d_r_id = getCharacterDataFromElement(dest_router_id_el);
						log.info("Edge Destination router_id: "+ d_r_id);
						Inet4Address d_router_id_addr = (Inet4Address) Inet4Address.getByName(d_r_id);
						NodeList dest_if_id_nl = dest_el.getElementsByTagName("if_id");
						Element dest_if_id_el = (Element) dest_if_id_nl.item(0);
						String s_dest_if_id = getCharacterDataFromElement(dest_if_id_el);
						log.info("Edge Dest if_id: " + s_dest_if_id);
						int dst_if_id = Integer.parseInt(s_dest_if_id);
						NodeList domain = dest_el.getElementsByTagName("domain_id");
						Element domain_id_el = (Element) domain.item(0);
						String d_r_domain = getCharacterDataFromElement(domain_id_el);
						log.info("Destination router domain: "+ d_r_domain);
						Inet4Address d_router_domain= (Inet4Address) Inet4Address.getByName(d_r_domain);


						// Include the connection between both nodes
						connection.setSrc_if_id(src_if_id);
						connection.setSrc_router_id(s_router_id_addr);
						connection.setDst_if_id(dst_if_id);
						connection.setDst_router_id(d_router_id_addr);
						connection.setDomain_src_router(s_router_domain);
						connection.setDomain_dst_router(d_router_domain);
						if(connection.getTE_info()==null){
							TE_Information tE_info= new TE_Information();							
							if (commonBitmapLabelSet){	
								tE_info.createBitmapLabelSet(numLabels, grid,  cs, n);
							}
							connection.setTE_info(tE_info);
						}
						//add the connection to the LinkedList.
						interDomainLinks.add(connection);

					}
				}
			}
			//}//end for domains
		} catch (Exception e) {
			e.printStackTrace();
		}

		return interDomainLinks;

	}

	public static int readWSONLambdas(String fileName){
		Logger log=Logger.getLogger("PCEPServer");
		File file = new File(fileName);
		int num_wavelengths=4;
		try {
			DocumentBuilder builder =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodes_domains = doc.getElementsByTagName("domain");

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_wl=  element_domain.getElementsByTagName("num_wavelengths");
				for (int k = 0; k < nodes_wl.getLength(); k++) {
					Element nodes_wl_e = (Element) nodes_wl.item(0);
					String num_wavelengths_id=getCharacterDataFromElement(nodes_wl_e );
					num_wavelengths=Integer.parseInt(num_wavelengths_id);
					log.info("num_wavelength: "+num_wavelengths);
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		 

		return num_wavelengths;
	}


	public static Hashtable <Object,Object> getITSites(String fileName){
		Hashtable <Object,Object> it_site_id_domain_ed=new Hashtable <Object,Object>();

		File file2 = new File(fileName);
		try {
			DocumentBuilder builder2 =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc2 = builder2.parse(file2);

			NodeList nodes_domains = doc2.getElementsByTagName("domain");

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str=getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id= (Inet4Address) Inet4Address.getByName(domain_id_str);

				NodeList ITsites = element_domain.getElementsByTagName("it_site");
				for (int i = 0; i < ITsites.getLength(); i++) {
					Element element = (Element) ITsites.item(i);
					NodeList it_site_id_node = element.getElementsByTagName("it_site_id");
					Element it_site_id_e = (Element) it_site_id_node.item(0);
					String it_site_id=getCharacterDataFromElement(it_site_id_e);
					Inet4Address it_site_id_addr= (Inet4Address) Inet4Address.getByName(it_site_id);

					NodeList domain_id_node = element.getElementsByTagName("domain_id");
					it_site_id_domain_ed.put(it_site_id_addr, domain_id);
					//graph.addVertex(router_id_addr);					
				}

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}		 

		return it_site_id_domain_ed;

	}


	public static Hashtable <Object,Object> getResource(String fileName){
		Hashtable <Object,Object> resource_id_domain_ed=new Hashtable <Object,Object>();

		File file2 = new File(fileName);
		try {
			DocumentBuilder builder2 =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc2 = builder2.parse(file2);

			NodeList nodes_domains = doc2.getElementsByTagName("domain");

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str=getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id= (Inet4Address) Inet4Address.getByName(domain_id_str);

				NodeList storages = element_domain.getElementsByTagName("storage");
				for (int i = 0; i < storages.getLength(); i++) {
					Element element = (Element) storages.item(i);
					NodeList resource_id_node = element.getElementsByTagName("resource_id");
					Element resource_id_e = (Element) resource_id_node.item(0);
					String resource_id=getCharacterDataFromElement(resource_id_e);
					Inet4Address resource_id_addr= (Inet4Address) Inet4Address.getByName(resource_id);

					NodeList domain_id_node = element.getElementsByTagName("domain_id");
					resource_id_domain_ed.put(resource_id_addr, domain_id);
					//graph.addVertex(router_id_addr);

				}

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}		 
		return resource_id_domain_ed;

	}

	public static Hashtable<StorageTLV,Object> getStorageCharacteristics(String fileName){
		Hashtable <StorageTLV,Object> storage_site_ed=new Hashtable <StorageTLV,Object>();
		//		StorageTLV storagetlv = new StorageTLV();
		//		ResourceIDSubTLV resourceidsubtlv = new ResourceIDSubTLV();
		//		CostSubTLV costsubtlv = new CostSubTLV();
		//		LinkedList<CostSubTLV> costlist = new LinkedList<CostSubTLV> (); 
		//		StorageSizeSubTLV storagesizesubtlv = new StorageSizeSubTLV();

		File file2 = new File(fileName);
		try {
			DocumentBuilder builder2 =	DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc2 = builder2.parse(file2);

			NodeList nodes_domains = doc2.getElementsByTagName("domain");

			for (int j = 0; j < nodes_domains.getLength(); j++) {
				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id =  element_domain.getElementsByTagName("domain_id");
				Element domain_id_e = (Element) nodes_domain_id.item(0);
				String domain_id_str=getCharacterDataFromElement(domain_id_e);
				Inet4Address domain_id= (Inet4Address) Inet4Address.getByName(domain_id_str);

				NodeList storages = element_domain.getElementsByTagName("storage");
				for (int i = 0; i < storages.getLength(); i++) {
					StorageTLV storagetlv = new StorageTLV();
					ResourceIDSubTLV resourceidsubtlv = new ResourceIDSubTLV();
					CostSubTLV costsubtlv = new CostSubTLV();
					LinkedList<CostSubTLV> costlist = new LinkedList<CostSubTLV> (); 
					StorageSizeSubTLV storagesizesubtlv = new StorageSizeSubTLV();


					Element element = (Element) storages.item(i);
					NodeList resource_id_node = element.getElementsByTagName("resource_id");
					Element resource_id_e = (Element) resource_id_node.item(0);
					String resource_id=getCharacterDataFromElement(resource_id_e);
					Inet4Address resource_id_addr= (Inet4Address) Inet4Address.getByName(resource_id);

					resourceidsubtlv.setResourceID(resource_id_addr);

					Inet4Address virtual_TI_site= (Inet4Address) Inet4Address.getByName((element.getAttributeNode("it_site").getValue()).toString());
					costsubtlv.setUsageUnit((element.getAttributeNode("UsageUnit").getValue()).getBytes());
					costsubtlv.setUnitaryPrice((element.getAttributeNode("UnitaryPrice").getValue()).getBytes());
					costlist.add(costsubtlv);
					storagesizesubtlv.setTotalSize(Integer.parseInt(element.getAttributeNode("TotalSize").getValue()));
					storagesizesubtlv.setAvailableSize(Integer.parseInt(element.getAttributeNode("AvailableSize").getValue()));

					storagetlv.setResourceIDSubTLV(resourceidsubtlv);
					storagetlv.setCostList(costlist);
					storagetlv.setStorageSizeSubTLV(storagesizesubtlv);

					storage_site_ed.put(storagetlv, virtual_TI_site);					
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		 
		return storage_site_ed;
	}
}