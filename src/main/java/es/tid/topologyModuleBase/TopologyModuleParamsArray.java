package es.tid.topologyModuleBase;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.jws.soap.InitParam;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.tid.topologyModuleBase.util.UtilsFunctions;

/**
 * 
 * @author La humiltat
 *
 */

public class TopologyModuleParamsArray 
{
	private ArrayList<TopologyModuleParams> paramList;
	/**
	 * 
	 */
	private int managementPort;
	
	/**
	 * 
	 */
	private String managementIP;
	/**
	 * Logger
	 */
	private static Logger log=Logger.getLogger("TMController");
	
	/**
	 * Name of the configuration file
	 */
	private String confFile;
	
	
	public TopologyModuleParamsArray(String confFile)
	{
		paramList = new ArrayList<TopologyModuleParams>();
		if (confFile!=null){
			this.setConfFile(confFile);
		}
		else
		{
			confFile="TMConfiguration.xml";
		}
	}
	public TopologyModuleParamsArray(){
		paramList = new ArrayList<TopologyModuleParams>();
		setConfFile("TMConfiguration.xml");
	}

	public void initialize()
	{
		log.info("Reading from file::"+this.confFile);
		try
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File confFile = new File(this.confFile);
			Document doc = builder.parse(confFile);
			
			managementPort = Integer.parseInt((getCharacterDataFromElement((Element) doc.getElementsByTagName("managementPort").item(0))));
			managementIP = getCharacterDataFromElement((Element) doc.getElementsByTagName("managementIP").item(0));
			
			
			NodeList list_nodes_OSPF = doc.getElementsByTagName("OSPF");
			
			for (int i = 0; i < list_nodes_OSPF.getLength(); i++) 
			{
				TopologyModuleParams littleParams = new TopologyModuleParams();
				Element nodes_OSPF = (Element) list_nodes_OSPF.item(i);
				

				littleParams.setOSPFSession(Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFSession").item(0)))));
				littleParams.setOSPFListenerIP(getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFListenerIP").item(0)));
				littleParams.setReachabilityFile(getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("reachabilityFile").item(0)));
				littleParams.setOSPFMulticast(Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFMulticast").item(0)))));
				littleParams.setOSPFUnicast(Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFUnicast").item(0)))));
				littleParams.setOSPFTCPSession(Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFTCPSession").item(0)))));
				
				littleParams.setOSPF(true);
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_Openflow = doc.getElementsByTagName("Openflow");
			for (int i = 0; i < list_nodes_Openflow.getLength(); i++) 
			{
				TopologyModuleParams littleParams = new TopologyModuleParams();
				Element nodes_Openflow = (Element) list_nodes_Openflow.item(i);
				

				littleParams.setControllerIP(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerIP").item(0)));
				littleParams.setControllerPORT(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerPort").item(0)));
				littleParams.setTopologyPath(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerTopoQueryLinks").item(0)));
				littleParams.setTopologyNodesPath(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerTopoQueryNodes").item(0)));
				littleParams.setControllerListFile(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("controllerListFile").item(0)));
				littleParams.setInterDomainFile(getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("interDomainFile").item(0)));
				
				littleParams.setFloodLight(true);
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_Gson = doc.getElementsByTagName("Gson");
						
			for (int i = 0; i < list_nodes_Gson.getLength(); i++) 
			{
				TopologyModuleParams littleParams = new TopologyModuleParams();
				Element nodes_Gson = (Element) list_nodes_Gson.item(i);
				
				littleParams.setGsonPort(Integer.parseInt(getCharacterDataFromElement((Element) nodes_Gson.getElementsByTagName("GsonPort").item(0))));
				
				littleParams.setGSON(true);
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_BGPLS = doc.getElementsByTagName("BGPLS");
			
			for (int i = 0; i < list_nodes_BGPLS.getLength(); i++) 
			{

				TopologyModuleParams littleParams = new TopologyModuleParams();
				Element nodes_BGPLS= (Element) list_nodes_BGPLS.item(i);
				
				littleParams.setBGPSConfigurationFile(getCharacterDataFromElement((Element) nodes_BGPLS.getElementsByTagName("BGPLSconfigFile").item(0)));
				if(getCharacterDataFromElement((Element) nodes_BGPLS.getElementsByTagName("Reader").item(0)).equals("True")){
					littleParams.setBGPLSReading(true);
					log.info("BGPLS receiver configured!!");
				};
				if(getCharacterDataFromElement((Element) nodes_BGPLS.getElementsByTagName("Writer").item(0)).equals("True")){
					littleParams.setBGPLSWriting(true);
					log.info("BGPLS sender configured!!");
				};
				
				if(!littleParams.isBGPLSReading() && !littleParams.isBGPLSWriting()){
					log.warning("BGPLS not configured properly (Neither a sender nor a receiver). Please check .xml file");
				}
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_XML = doc.getElementsByTagName("XML");
			
			for (int i = 0; i < list_nodes_XML.getLength(); i++) 
			{
				Element nodes_xml = (Element) list_nodes_XML.item(i);

				
				TopologyModuleParams littleParams = new TopologyModuleParams();
				littleParams.setModexml(getCharacterDataFromElement(((Element) nodes_xml.getElementsByTagName("mode").item(0))));
				littleParams.setNetworkDescriptionFile(getCharacterDataFromElement(((Element) nodes_xml.getElementsByTagName("XMLFileTopology").item(0))));
				littleParams.setXML(true);
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_COP = doc.getElementsByTagName("COP");
			
			for (int i = 0; i < list_nodes_COP.getLength(); i++) 
			{
				Element nodes_cop = (Element) list_nodes_COP.item(i);
				TopologyModuleParams littleParams = new TopologyModuleParams();
				if(nodes_cop.getElementsByTagName("import_ip").getLength()>0){
					
					littleParams.setRemoteCOPhost((getCharacterDataFromElement(((Element) nodes_cop.getElementsByTagName("import_ip").item(0)))));
					littleParams.setRemoteCOPPort(Integer.parseInt((getCharacterDataFromElement(((Element) nodes_cop.getElementsByTagName("import_port").item(0))))));
					littleParams.setCOPReading(true);
				}
				if(nodes_cop.getElementsByTagName("serve_port").getLength()>0){
					littleParams.setExportCOPPort(Integer.parseInt((getCharacterDataFromElement(((Element) nodes_cop.getElementsByTagName("serve_port").item(0))))));
					littleParams.setCOPWriting(true);
				}
				paramList.add(littleParams);
			}
			
			NodeList list_nodes_ws = doc.getElementsByTagName("WSOld");
			
			for (int i = 0; i < list_nodes_ws.getLength(); i++) 
			{
				Element nodes_ws = (Element) list_nodes_ws.item(i);

				
				TopologyModuleParams littleParams = new TopologyModuleParams();
				littleParams.setIpWSOld(getCharacterDataFromElement(((Element) nodes_ws.getElementsByTagName("ip").item(0))));
				littleParams.setPortWSOld(Integer.parseInt(getCharacterDataFromElement(((Element) nodes_ws.getElementsByTagName("port").item(0)))));
				littleParams.setWSOld(true);
				paramList.add(littleParams);
			}
			
			
		}
		catch (Exception e)
		{
			log.info(UtilsFunctions.exceptionToString(e));
		}
	
		
	}
	
	//Private functions
	
		private String getCharacterDataFromElement(Element e) {
			if (e == null)
			{
				return null;
			}
			Node child = e.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				return cd.getData();
			} else {
				return "?";
			}
		}
		
		//GETTERS AND SETTERS
	
	public int getMangementPort()
	{
		return managementPort;
	}
	
	public void setMangementPort(int mangementPort)
	{
		this.managementPort = mangementPort;
	}
	
	public String getMangementIP()
	{
		return managementIP;
	}
	
	public void setMangementIP(String mangementIP)
	{
		this.managementIP = mangementIP;
	}
	
	public String getConfFile()
	{
		return confFile;
	}
	
	public void setConfFile(String confFile)
	{
		this.confFile = confFile;
	}
	
	public ArrayList<TopologyModuleParams> getParamList() 
	{
		return paramList;
	}
	
	public void setParamList(ArrayList<TopologyModuleParams> paramList) 
	{
		this.paramList = paramList;
	}
}
