package es.tid.topologyModuleBase.reader;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.elements.EndPoint;
import es.tid.tedb.elements.IPNodeParams;
import es.tid.tedb.elements.Intf;
import es.tid.tedb.elements.Link;
import es.tid.tedb.elements.Location;
import es.tid.tedb.elements.Node;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;

public class TopologyReaderXML extends TopologyReader
{

	public TopologyReaderXML(SimpleTopology ted,TopologyModuleParams params, Lock lock)
	{

		super(ted,params,lock);
	}

	@Override
	public void readTopology() 
	{
		lock.lock();
		//Initialize Traffic Engineering Database
		if (params.getModexml()!=null){
			if (params.getModexml().equals("IP"))
				readNetwork(params.getNetworkDescriptionFile());
		}
		else if(params.ITcapable==true){
			log.info("Initializing IT capable TEDB");
			ted.initializeFromFile(params.getITnetworkDescriptionFile());
		}else{
			if (params.isMultilayer()){
				log.info("Initializing Multilayer TEDB");
				ted.initializeFromFile(params.getNetworkDescriptionFile());
			}else {
				if (params.isMultidomain()){
					log.info("Initializing TEDB joining all domains in a single one");
				}else {
					log.info("Initializing Single Layer TEDB");	
				}
				//STRONGEST: Independent PCE's with lambdas' sub-set assignment
				if (params.getLambdaEnd()!=Integer.MAX_VALUE){
					log.info("Entro en Max Value");
					((SimpleTEDB)ted.getDB()).initializeFromFile(params.getNetworkDescriptionFile(),params.getLayer() ,params.isMultidomain(),params.getLambdaIni(),params.getLambdaEnd(),params.isSSOn(),false);
				}
				else{
					log.info("Entro en el elsee:::"+params.isSSOn()+",params.isWLAN()"+params.isWLAN());
					((SimpleTEDB)ted.getDB()).initializeFromFile(params.getNetworkDescriptionFile(),params.getLayer() ,params.isMultidomain(),0,Integer.MAX_VALUE ,params.isSSOn(),false, params.isWLAN());
				}
			}
		}
		lock.unlock();

	}

	public void readNetwork(String fileName) {
		//First, create the graph		
		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(file);	
			//			NodeList controllers_ip = doc.getElementsByTagName("controller_list");
			//			for (int j = 0; j < controllers_ip.getLength(); j++) {
			//			}

			NodeList nodes_domains = doc.getElementsByTagName("domain");

			System.out.println("isAllowingMultipleEdges?: "+((SimpleTEDB)this.ted.getDB()).getNetworkGraph().isAllowingMultipleEdges());
			//First pass to get all the nodes

			for (int j = 0; j < nodes_domains.getLength(); j++) {

				Element element1 = (Element) nodes_domains.item(j);

				Element element_domain = (Element) nodes_domains.item(j);
				NodeList nodes_domain_id = element_domain.getElementsByTagName("domain_id");
				
				for (int k = 0; k < nodes_domain_id.getLength(); k++) {
					Element domain_id_e = (Element) nodes_domain_id.item(0);
					String domain_id = getCharacterDataFromElement(domain_id_e);
					//((SimpleTEDB)ted.getDB()).setDomainID(domainID);
				}
				NodeList nodes = element1.getElementsByTagName("node");
				log.info("Number of nodes: "+nodes.getLength());
				if (nodes.getLength()>0){
					for (int i = 0; i < nodes.getLength(); i++) {
						Element element = (Element) nodes.item(i);
						//Node Name
						NodeList nodeName_node = element.getElementsByTagName("nodeName");
						Element nodeName_e = (Element) nodeName_node.item(0);
						String nodeName = getCharacterDataFromElement(nodeName_e);
						log.info("Nodename: "+nodeName);
						NodeList addressList_node = element.getElementsByTagName("addressList");
						ArrayList<String> addresses = null;
						if (addressList_node.getLength()>0){
							addresses= new ArrayList<String>();
							for (int k = 0; k < addressList_node.getLength(); k++) {
								Element addressList_e = (Element) addressList_node.item(k);
								NodeList address_node = addressList_e.getElementsByTagName("address");
								Element address_el = (Element) address_node.item(0);
								String address = getCharacterDataFromElement(address_el);
								addresses.add(address);
							}
						}
						//DataPathID
						String dpid=null;
						NodeList dpid_nodeList = element.getElementsByTagName("dpid");
						if (dpid_nodeList.getLength()>0){
							Element dpid_el = (Element) dpid_nodeList.item(0);									
							dpid = getCharacterDataFromElement(dpid_el);

						}
						
						//Is physical Node
						boolean isPhysical_node = true;
						NodeList isPhysical_nodeList = element.getElementsByTagName("isPhysical");
						if (isPhysical_nodeList.getLength()>0){
							Element isPhysical_el = (Element) isPhysical_nodeList.item(0);									
							String isPhysical_s = getCharacterDataFromElement(isPhysical_el);
							isPhysical_node = Boolean.parseBoolean(isPhysical_s);
						}
						//Is physical Node
						String layerNode = null;
						NodeList layerNode_nodeList = element.getElementsByTagName("layerNode");
						if (layerNode_nodeList.getLength()>0){
							Element layerNode_el = (Element) layerNode_nodeList.item(0);									
							layerNode = getCharacterDataFromElement(layerNode_el);

						}

						String configurationMode=null;
						NodeList configurationMode_nodeList = element.getElementsByTagName("configurationMode");
						if (configurationMode_nodeList.getLength()>0){
							Element configurationMode_el = (Element) configurationMode_nodeList.item(0);									
							configurationMode = getCharacterDataFromElement(configurationMode_el);
						}
						
						String controllerIP=null;
						NodeList controllerIP_nodeList = element.getElementsByTagName("controllerIP");
						if (controllerIP_nodeList.getLength()>0){
							Element controllerIP_el = (Element) controllerIP_nodeList.item(0);									
							controllerIP = getCharacterDataFromElement(controllerIP_el);
						}
						
						String controllerPort=null;
						NodeList controllerPort_nodeList = element.getElementsByTagName("controllerPort");
						if (controllerPort_nodeList.getLength()>0){
							Element controllerPort_el = (Element) controllerPort_nodeList.item(0);									
							controllerPort = getCharacterDataFromElement(controllerPort_el);
						}
						
						String routerType=null;
						NodeList routerType_nodeList = element.getElementsByTagName("routerType");
						if (routerType_nodeList.getLength()>0){
							Element routerType_el = (Element) routerType_nodeList.item(0);									
							routerType = getCharacterDataFromElement(routerType_el);

						}

						//Interface List
						ArrayList<Intf> intfList = null;
						NodeList interfacesList_node = element.getElementsByTagName("interfacesList");
						if (interfacesList_node.getLength()>0){
							ArrayList<String> layer= null;
							ArrayList<String> addressesIntf = null;
							ArrayList<String> supportedCounters = null;
							intfList = new ArrayList<Intf>();							
							Element interface_e = (Element) interfacesList_node.item(0);
							NodeList interface_node = interface_e.getElementsByTagName("interface");
							if (interface_node.getLength()>0){									
								for (int k = 0; k < interface_node.getLength(); k++) {
									Element interface_el = (Element) interface_node.item(k);
									//name interface
									NodeList nameIntf_node = interface_el.getElementsByTagName("nameIntf");
									Element nameIntf_el = (Element) nameIntf_node.item(0);										
									String nameIntf = getCharacterDataFromElement(nameIntf_el);
									//addressesIntf
									NodeList addressIntfList_node = interface_el.getElementsByTagName("addressIntfList");
									if (addressIntfList_node.getLength()>0){
										addressesIntf = new ArrayList<String>();										
										for (int it = 0; it < addressIntfList_node.getLength(); it++) {
											Element addressIntf_e = (Element) addressIntfList_node.item(it);
											NodeList addressIntf_node = addressIntf_e.getElementsByTagName("addressIntf");
											Element addressIntf_el = (Element) addressIntf_node.item(0);										
											String addressIntf = getCharacterDataFromElement(addressIntf_el);												
											addressesIntf.add(addressIntf);
										}
									}

									NodeList label_node = interface_el.getElementsByTagName("label");
									String label="0";
									if (label_node.getLength()>0){
										Element label_el = (Element) label_node.item(0);										
										label = getCharacterDataFromElement(label_el);
										if (label.equals("?"))
											label="0";
									}

									//IntfUp
									//name interface
									NodeList intfUp_node = interface_el.getElementsByTagName("intfUp");
									boolean intfUp = true;
									if (intfUp_node.getLength()>0){
										Element intfUp_el = (Element) intfUp_node.item(0);										
										String intfUp_s = getCharacterDataFromElement(intfUp_el);
										intfUp = Boolean.parseBoolean(intfUp_s);

									}

									//layeringList
									NodeList layeringList_node = interface_el.getElementsByTagName("layeringList");										
									if (layeringList_node.getLength()>0){
										layer = new ArrayList<String>();										
										for (int it = 0; it < layeringList_node.getLength(); it++) {
											Element layering_e = (Element) layeringList_node.item(it);
											NodeList layering_node = layering_e.getElementsByTagName("layering");
											Element layering_el = (Element) layering_node.item(0);										
											String layering = getCharacterDataFromElement(layering_el);
											layer.add(layering);
										}
									}
									//supportedCountersList
									NodeList supportedCountersList_node = interface_el.getElementsByTagName("supportedCountersList");										
									if (supportedCountersList_node.getLength()>0){
										supportedCounters = new ArrayList<String>();										
										for (int it = 0; it < supportedCountersList_node.getLength(); it++) {
											Element  supportedCounters_e = (Element) supportedCountersList_node.item(it);
											NodeList supportedCounters_node = supportedCounters_e.getElementsByTagName("supportedCounters");
											Element supportedCounters_el = (Element) supportedCounters_node.item(0);										
											String supportedCounters_s = getCharacterDataFromElement(supportedCounters_el);
											supportedCounters.add(supportedCounters_s);
										}
									}
									//isPhysical
									//Is physical Node
									NodeList isPhysicalIntf_node = interface_el.getElementsByTagName("isPhysical");
									boolean isPhysical_intf=true;
									if (isPhysicalIntf_node.getLength()>0){
										Element isPhysical_el = (Element) isPhysicalIntf_node.item(0);									
										String isPhysical_s = getCharacterDataFromElement(isPhysical_el);
										isPhysical_intf= Boolean.parseBoolean(isPhysical_s);
									}
									//Is physical Node
									NodeList parentInterfaceName_node = interface_el.getElementsByTagName("parentInterfaceName");
									String parentInterfaceName=null;
									if (parentInterfaceName_node.getLength()>0){
										Element parentInterfaceName_el = (Element) parentInterfaceName_node.item(0);									
										parentInterfaceName = getCharacterDataFromElement(parentInterfaceName_el);												
									}

									Intf intf=new Intf();
									intf.setLabel(Integer.parseInt(label));
									intf.setName(nameIntf);
									intf.setPhysical(isPhysical_intf);												
									intf.setLayering(layer);
									intf.setAddress(addressesIntf);
									intf.setParentInterfaceName(parentInterfaceName);
									intf.setSupportedCounters(supportedCounters);		
									intf.setIntfUp(intfUp);
									intfList.add(intf);					

								}
							}
						}
						//domain
						int domain=1;
						NodeList domain_node = element.getElementsByTagName("domain");
						if (domain_node.getLength()>0){
							Element domain_e = (Element)domain_node.item(0);
							String domain_s = getCharacterDataFromElement(domain_e);
							domain= Integer.parseInt(domain_s);
						}
						//location
						NodeList location_node = element.getElementsByTagName("location");
						Location location= null;
						if (location_node.getLength()>0){							
							Element location_el = (Element) location_node.item(0);
							//Xcord
							NodeList Xcord_node = location_el.getElementsByTagName("Xcord");
							Element Xcord_el = (Element) Xcord_node.item(0);										
							String Xcord_s = getCharacterDataFromElement(Xcord_el);
							double Xcord = Double.parseDouble(Xcord_s);

							//Xcord
							NodeList Ycord_node = location_el.getElementsByTagName("Ycord");
							Element Ycord_el = (Element) Ycord_node.item(0);										
							String Ycord_s = getCharacterDataFromElement(Ycord_el);
							double Ycord = Double.parseDouble(Ycord_s);
							location= new Location(Xcord,Ycord);
						}
						//ipParams
						NodeList ipParams_node = element.getElementsByTagName("ipParams");
						IPNodeParams ipNodeParams = null;
						if (ipParams_node.getLength()>0){
							ipNodeParams= new IPNodeParams();
						}
						//parentRouter
						NodeList parentRouter_node = element.getElementsByTagName("parentRouter");
						String parentRouter = null;
						if (parentRouter_node.getLength()>0){
							Element parentRouter_e = (Element)parentRouter_node.item(0);
							parentRouter = getCharacterDataFromElement(parentRouter_e);
						}


						Node node = new Node();	
						node.setNodeID(nodeName);
						node.setDomain(domain);
						//ip.setLocation(new Location(1, 1));
						node.setPhysical(isPhysical_node);
						node.setParentRouter(parentRouter);
						node.setIpParams(ipNodeParams);
						node.setAddress(addresses);
						node.setIntfList(intfList);
						node.setLayer(layerNode);
						node.setDataPathID(dpid);
						node.setConfigurationMode(configurationMode);
						node.setControllerIP(controllerIP);
						node.setControllerPort(controllerPort);
						node.setRouterType(routerType);
						((SimpleTEDB)ted.getDB()).getNetworkGraph().addVertex(node);
						//this.addNode(node);
					}
				}

				NodeList links = element1.getElementsByTagName("link");
				if (links.getLength()>0){
					for (int i = 0; i < links.getLength(); i++) {
						Element element = (Element) links.item(i);
						//linkID
						NodeList linkID_node = element.getElementsByTagName("linkID");
						Element linkID_e = (Element) linkID_node.item(0);
						String linkID = getCharacterDataFromElement(linkID_e);
						//isDirectional
						NodeList isDirectional_node = element.getElementsByTagName("isDirectional");
						Element isDirectional_e = (Element) isDirectional_node.item(0);
						boolean isDirectional = Boolean.parseBoolean(getCharacterDataFromElement(isDirectional_e));

						//source
						NodeList source_node = element.getElementsByTagName("source");
						EndPoint source = null;
						if (source_node.getLength()>0){		
							Element source_e = (Element) source_node.item(0);
							//node
							String node = null;
							NodeList node_node = source_e.getElementsByTagName("nodeLink");

							if (node_node.getLength()>0){		
								Element node_el = (Element) node_node.item(0);
								node = getCharacterDataFromElement(node_el);
							}
							//intf
							NodeList intf_node = source_e.getElementsByTagName("intfLink");
							String intf =null;	 
							if (intf_node.getLength()>0){	
								Element intf_el = (Element) intf_node.item(0);
								intf= getCharacterDataFromElement(intf_el);
							}
							if ((intf != null)&&(node != null))
								source=new EndPoint(node,intf);



						}

						//destination
						NodeList destination_node = element.getElementsByTagName("destination");
						EndPoint destination = null;
						if (destination_node.getLength()>0){							
							Element destination_e = (Element) destination_node.item(0);
							//node
							NodeList node_node = destination_e.getElementsByTagName("nodeLink");
							Element node_el = (Element) node_node.item(0);
							String node = getCharacterDataFromElement(node_el);
							//intf
							NodeList intf_node = destination_e.getElementsByTagName("intfLink");
							Element intf_el = (Element) intf_node.item(0);
							String intf = getCharacterDataFromElement(intf_el);
							destination=new EndPoint(node,intf);							
						}

						//type
						String type_link = null;
						NodeList type_nodeList = element.getElementsByTagName("typeLink");
						if (type_nodeList.getLength()>0){
							Element type_el = (Element) type_nodeList.item(0);									
							type_link = getCharacterDataFromElement(type_el);

						}
						//layerLink
						String layerLink = null;
						NodeList layerLink_nodeList = element.getElementsByTagName("layerLink");
						if (layerLink_nodeList.getLength()>0){
							Element layerLink_el = (Element) layerLink_nodeList.item(0);									
							layerLink = getCharacterDataFromElement(layerLink_el);

						}

						Link link = new Link();
						link.setLinkID(linkID);
						link.setSource(source);
						link.setDest(destination);	
						link.setDirectional(isDirectional);
						link.setType(type_link);
						fromLinkToIntradomainlink(link);
						//this.addLink(layerLink,link);

					}
				}


			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void fromLinkToIntradomainlink(Link link){
		boolean finished=false;
		Iterator<Object> vertices=((SimpleTEDB)this.ted.getDB()).getNetworkGraph().vertexSet().iterator();
		Node src=null; Node dst=null;
		while (vertices.hasNext() && !finished){
			Node node=(Node) vertices.next();
			if (link.getDest().getNode().equals(node.getNodeID()))
				dst=node;
			else if (link.getSource().getNode().equals(node.getNodeID()))
				src=node;

		}
		IntraDomainEdge edge= new IntraDomainEdge();
		edge.setBw(link.getBandwidth());
		edge.setDirectional(link.isDirectional());
		edge.setLinkID(link.getLinkID());
		edge.setType(link.getType());
		edge.setDst_Numif_id(link.getDest());
		edge.setSrc_Numif_id(link.getSource());
		if (src==null){
			log.info("SRC NULL");
		}
		if (dst==null){
			log.info("DST NULL");
		}

		((SimpleTEDB)this.ted.getDB()).getNetworkGraph().addEdge(src, dst, edge);
		((SimpleTEDB)this.ted.getDB()).getIntraDomainEdges().add(edge);

	}

	public static String getCharacterDataFromElement(Element e) {
		org.w3c.dom.Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		} else {
			return "?";
		}
	}
}
