package es.tid.topologyModuleBase;

import es.tid.topologyModuleBase.util.UtilsFunctions;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Logger;

public class TopologyModuleParams 
{
	/**
	 * Logger
	 */
	private static Logger log=Logger.getLogger("TMController");
	
	/**
	 * Name of the configuration file
	 */
	private String confFile;
	
	/**
	 * How to initialize the topology
	 */
	private String initFrom[];
	
	/**
	 * Which servers will the Topology Module provide
	 */
	private String servers[];
	/**
	 * If the PCE is IT capable
	 */
	public boolean ITcapable=false;
	
	private boolean multilayer=false;
	
	private boolean multidomain=false;
	
	private String networkDescriptionFile="network_101.xml";
	/**
	 * Name of the file that describes the IT network (if there is any)
	 */
	private String ITnetworkDescriptionFile="network_IT_101.xml";
	/**
	 * STRONGEST: Variables used to indicate which lambda subset is being used. 
	 */
	private int lambdaIni=0;
	private int lambdaEnd=Integer.MAX_VALUE;
	
	private String layer=null;
	
	private boolean isWSOld=false;
	private String ipWSOld=null;
	private int portWSOld;
	
	/**
	 * Paramter meaning SSON network computation
	 */
	private boolean isSSOn= false;
	
	/**
	 * Paramter meaning WLAN network computation
	 */
	private boolean isWLAN = false;
	
	/**
	 * 
	 */
	private int mangementPort;
	
	/**
	 * 
	 */
	private String mangementIP;
	
	/**
	 * If it is multicast OSPF
	 */
	private boolean OSPFMulticast=false;
	/**
	 * If it is unicast OSPF
	 */
	private boolean OSPFUnicast=false;
	/** 
	 * 
	 */
	boolean isCompletedAuxGraph = false;
	
	/**
	 * If OSPF with raw socket is used to receive topology.
	 */
	private boolean OSPFSession=false;
	
	/**
	 * If a TCP socket, sending OSPF packets over it is used to receive topology.
	 */
	private boolean OSPFTCPSession=false;
	
	/**
	 * Port of the protocol OSPF over TCP
	 */
	private int OSPFTCPPort=7779;
	/**
	 * IP Address from which the OSPF is listen 
	 */
	private String OSPFListenerIP = "localhost";
	
	
	/**
	 * Controller IP (Openflow)
	 */
	private String controllerIP;
	/**
	 * Port of the controller (Openflow)
	 */
	private String controllerPORT;
	/**
	 * Path for REST request in controller. Gets links (Openflow)
	 */
	private String topologyLinksPath;
	
	/**
	 * Path for REST request in controller. Gets nodes (Openflow)
	 */
	private String topologyNodesPath;
	
	/**
	 * Port for serving with the Gson interface
	 */
	private int gsonPort = 1239;
	
	/**
	 * BGPLS configuration file
	 */
	private String BGPSConfigurationFile;
	
	/**
	 * Interdomain links. Used for floodlight
	 */
	private String interDomainFile;
	
	/**
	 * Used when topology is obtained from more than one controller
	 */
	private String controllerListFile;
	
	/**
	 * Name of the reachability file
	 */


	private String Identifier="";


	private String reachabilityFile;
	
	private String modexml=null;
	
	public boolean isWSOld() {
		return isWSOld;
	}
	public void setWSOld(boolean isWSOld) {
		this.isWSOld = isWSOld;
	}
	public String getIpWSOld() {
		return ipWSOld;
	}
	public void setIpWSOld(String ipWSOld) {
		this.ipWSOld = ipWSOld;
	}
	public int getPortWSOld() {
		return portWSOld;
	}
	public void setPortWSOld(int portWSOld) {
		this.portWSOld = portWSOld;
	}
	
	public String getModexml() {
		return modexml;
	}
	public void setModexml(String modexml) {
		this.modexml = modexml;
	}
	private boolean isBGPLS = false;
	private boolean isBGPLSReading = false;
	private boolean isBGPLSWriting = false;
	private boolean isBGPLSReaderWriting = false;
	private boolean isOSPF = false;
	private boolean isGSON = false;
	private boolean isFloodLight = false;
	private boolean isRYU = false;
	private boolean isXML = false;
	private boolean isRestInfinera = false;
	
	/**
	 * Active IETF service-topology exporter
	 */
	private boolean isIETFWritting=false;
	/**
	 * Active IETF service-topology importer
	 */
	private boolean isIETFReading=false;
	/**
	 * Port of service-topology Server API
	 */
	private int exportIETFPort=8087;
	/**
	 * Host of service-topology remote Server API
	 */
	private String remoteIETFhost="localhost";
	/**
	 * Port of service-topology remote Server API
	 */
	private int remoteIETFPort=8081;
	
	/**
	 * Active Unify service-topology exporter
	 */
	private boolean isUnifyWritting=false;
	/**
	 * Active Unify service-topology importer
	 */
	private boolean isUnifyReading=false;
	/**
	 * Port of service-topology Server API
	 */
	private int exportUnifyPort=8087;
	/**
	 * Host of service-topology remote Server API
	 */
	private String remoteUnifyhost="localhost";
	/**
	 * Port of service-topology remote Server API
	 */
	private int remoteUnifyPort=8081;
	
	
	
	/**
	 * Active COP service-topology exporter
	 */
	private boolean isCOPwritting=false;
	
	/**
	 * Active IETF service-topology importer
	 */
	private boolean isCOPReading=false;
	/**
	 * Port of service-topology Server COP API
	 */
	private int exportCOPPort=8087;
	/**
	 * Host of service-topology remote Server API
	 */
	private String remoteCOPhost="localhost";
	/**
	 * Port of service-topology remote Server API
	 */
	private int remoteCOPPort=8081;
        
       /**
	 * Port of service-topology Server TAPI
	 */
        private int exportTAPIPort=8887;
	
        /**
	 * Active COP service-topology exporter
	 */
	private boolean isTAPIwriting =false;
	
	public TopologyModuleParams(String confFile)
	{
		if (confFile!=null){
			this.setConfFile(confFile);
		}
		else
		{
			confFile="TMConfiguration.xml";
		}
	}
	public TopologyModuleParams(){
		setConfFile("TMConfiguration.xml");
	}
	
	public void initialize()
	{
		try 
		{	
			//log.setLevel(Level.OFF);
			//setConfFile("/home/jaume/Desktop/TopologyModuleNoONE.xml");
			log.info("Reading from file::"+this.confFile);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File confFile = new File(this.confFile);
			Document doc = builder.parse(confFile);
			
			
			mangementPort = Integer.parseInt((getCharacterDataFromElement((Element) doc.getElementsByTagName("mangementPort").item(0))));
			mangementIP = getCharacterDataFromElement((Element) doc.getElementsByTagName("mangementIP").item(0));
			
			NodeList list_nodes_OSPF = doc.getElementsByTagName("OSPF");
			Element nodes_OSPF = (Element) list_nodes_OSPF.item(0);
			
			OSPFSession = Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFSession").item(0))));
			OSPFListenerIP = getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFListenerIP").item(0));
			reachabilityFile = getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("reachabilityFile").item(0));
			OSPFMulticast = Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFMulticast").item(0))));
			OSPFUnicast = Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFUnicast").item(0))));
			OSPFTCPSession = Boolean.parseBoolean((getCharacterDataFromElement((Element) nodes_OSPF.getElementsByTagName("OSPFTCPSession").item(0))));
			
			
			NodeList list_nodes_Openflow = doc.getElementsByTagName("Openflow");
			Element nodes_Openflow = (Element) list_nodes_Openflow.item(0);
			
			controllerIP = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerIP").item(0));
			controllerPORT = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerPort").item(0));
			topologyLinksPath = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerTopoQueryLinks").item(0));
			topologyNodesPath = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("ControllerTopoQueryNodes").item(0));
			controllerListFile = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("controllerListFile").item(0));
			interDomainFile = getCharacterDataFromElement((Element) nodes_Openflow.getElementsByTagName("interDomainFile").item(0));
			
			NodeList list_nodes_xml = doc.getElementsByTagName("XML");
			if (list_nodes_xml!=null){
				Element nodes_xml = (Element) list_nodes_xml.item(0);
			
				//Mode
				modexml=getCharacterDataFromElement((Element) nodes_xml.getElementsByTagName("mode").item(0));
			}
			NodeList list_nodes_Gson = doc.getElementsByTagName("Gson");
			Element nodes_Gson = (Element) list_nodes_Gson.item(0);
			
			gsonPort = Integer.parseInt(getCharacterDataFromElement((Element) nodes_Gson.getElementsByTagName("GsonPort").item(0)));
			
			NodeList list_nodes_BGPLS = doc.getElementsByTagName("BGPLS");
			Element nodes_BGPLS= (Element) list_nodes_BGPLS.item(0);
			
			BGPSConfigurationFile = getCharacterDataFromElement((Element) nodes_BGPLS.getElementsByTagName("BGPLSconfigFile").item(0));
			
			NodeList list_nodes_InitFrom = doc.getElementsByTagName("InitFrom");
			Element nodes_initFrom = (Element) list_nodes_InitFrom.item(0);
			NodeList nodes_init_list = nodes_initFrom.getElementsByTagName("Init");
			
			initFrom = new String[nodes_init_list.getLength()];
			for (int i = 0; i < nodes_init_list.getLength(); i++) 
			{
				initFrom[i] = getCharacterDataFromElement((Element)nodes_init_list.item(i));
			}
			
			NodeList list_nodes_servers = doc.getElementsByTagName("Servers");
			Element nodes_servers = (Element) list_nodes_servers.item(0);
			NodeList nodes_servers_list = nodes_servers.getElementsByTagName("Server");
			
			servers = new String[nodes_servers_list.getLength()];
			for (int i = 0; i < nodes_servers_list.getLength(); i++) 
			{
				servers[i] = getCharacterDataFromElement((Element)nodes_servers_list.item(i));
			}			
		} 
		catch (Exception e) 
		{
			log.info(UtilsFunctions.exceptionToString(e));
		}
	}
	
	//Private functions
	
	private String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		} else {
			return "?";
		}
	}
	
	//GETTERS AND SETTERS

	public String getIdentifier()
	{
		return Identifier;
	}
	public void setIdentifier(String IDx)
	{
		this.Identifier = IDx;
	}

	public void setConfFile(String confFile)
	{
		this.confFile = confFile;
	}
	public String[] getInitFrom() 
	{
		return initFrom;
	}
	public void setInitFrom(String[] initFrom)
	{
		this.initFrom = initFrom;
	}
	public String getConfFile() 
	{
		return confFile;
	}
	public boolean isITcapable() 
	{
		return ITcapable;
	}
	public void setITcapable(boolean iTcapable) 
	{
		ITcapable = iTcapable;
	}
	public boolean isMultilayer() 
	{
		return multilayer;
	}
	public void setMultilayer(boolean multilayer) 
	{
		this.multilayer = multilayer;
	}
	public boolean isMultidomain() 
	{
		return multidomain;
	}
	public void setMultidomain(boolean multidomain) 
	{
		this.multidomain = multidomain;
	}
	public String getNetworkDescriptionFile() 
	{
		return networkDescriptionFile;
	}
	public void setNetworkDescriptionFile(String networkDescriptionFile)
	{
		this.networkDescriptionFile = networkDescriptionFile;
	}
	public boolean isBGPLSReading() {
		return isBGPLSReading;
	}
	public void setBGPLSReading(boolean isBGPLSReading) {
		this.isBGPLSReading = isBGPLSReading;
	}
	public boolean isBGPLSWriting() {
		return isBGPLSWriting;
	}
	public void setBGPLSWriting(boolean isBGPLSWriting) {
		this.isBGPLSWriting = isBGPLSWriting;
	}
	/**
	 * This method is used to verify if the current BGPLS is a reader/writer.
	 * @return True if it's reader/writer, false otherwise.
	 */
	public boolean isBGPLSReadingWriting() {
		return isBGPLSReaderWriting;
	}
	/**
	 * This method is used to set if the BGPLS object is reader/writer of not.
	 * @param isBGPLSReaderWriting True if the current object is reader/writer, false if not.
	 */
	public void setBGPLSReaderWriting(boolean isBGPLSReaderWriting) {
		this.isBGPLSReaderWriting = isBGPLSReaderWriting;
	}
	public String getITnetworkDescriptionFile() 
	{
		return ITnetworkDescriptionFile;
	}
	public void setITnetworkDescriptionFile(String iTnetworkDescriptionFile) 
	{
		ITnetworkDescriptionFile = iTnetworkDescriptionFile;
	}
	public int getLambdaIni() 
	{
		return lambdaIni;
	}
	public void setLambdaIni(int lambdaIni)
	{
		this.lambdaIni = lambdaIni;
	}
	public int getLambdaEnd() 
	{
		return lambdaEnd;
	}
	public void setLambdaEnd(int lambdaEnd) 
	{
		this.lambdaEnd = lambdaEnd;
	}
	public String getLayer() 
	{
		return layer;
	}
	public void setLayer(String layer)
	{
		this.layer = layer;
	}
	public boolean isSSOn() 
	{
		return isSSOn;
	}
	public void setSSOn(boolean isSSOn) 
	{
		this.isSSOn = isSSOn;
	}
	public boolean isWLAN() 
	{
		return isWLAN;
	}
	public void setWLAN(boolean isWLAN) 
	{
		this.isWLAN = isWLAN;
	}
	public boolean isCompletedAuxGraph() 
	{
		return isCompletedAuxGraph;
	}
	public void setCompletedAuxGraph(boolean isCompletedAuxGraph) 
	{
		this.isCompletedAuxGraph = isCompletedAuxGraph;
	}
	public boolean isOSPFSession() 
	{
		return OSPFSession;
	}
	public void setOSPFSession(boolean oSPFSession)
	{
		OSPFSession = oSPFSession;
	}
	public boolean isOSPFTCPSession() 
	{
		return OSPFTCPSession;
	}
	public void setOSPFTCPSession(boolean oSPFTCPSession) 
	{
		OSPFTCPSession = oSPFTCPSession;
	}
	public int getOSPFTCPPort() 
	{
		return OSPFTCPPort;
	}
	public void setOSPFTCPPort(int oSPFTCPPort) 
	{
		OSPFTCPPort = oSPFTCPPort;
	}
	public String getOSPFListenerIP() 
	{
		return OSPFListenerIP;
	}
	public void setOSPFListenerIP(String oSPFListenerIP) 
	{
		OSPFListenerIP = oSPFListenerIP;
	}
	public String getControllerIP() 
	{
		return controllerIP;
	}
	public void setControllerIP(String controllerIP) 
	{
		this.controllerIP = controllerIP;
	}
	public String getControllerPORT()
	{
		return controllerPORT;
	}
	public void setControllerPORT(String controllerPORT)
	{
		this.controllerPORT = controllerPORT;
	}
	public String getTopologyPath() 
	{
		return topologyLinksPath;
	}
	public void setTopologyPath(String topologyPath) 
	{
		this.topologyLinksPath = topologyPath;
	}
	public String[] getServers() 
	{
		return servers;
	}
	public void setServers(String[] servers) 
	{
		this.servers = servers;
	}
	public int getGsonPort() 
	{
		return gsonPort;
	}
	public void setGsonPort(int gsonPort) 
	{
		this.gsonPort = gsonPort;
	}
	public boolean isOSPFMulticast()
	{
		return OSPFMulticast;
	}
	public void setOSPFMulticast(boolean oSPFMulticast) 
	{
		OSPFMulticast = oSPFMulticast;
	}
	public boolean isOSPFUnicast() 
	{
		return OSPFUnicast;
	}
	public void setOSPFUnicast(boolean oSPFUnicast) 
	{
		OSPFUnicast = oSPFUnicast;
	}
	public String getTopologyNodesPath() 
	{
		return topologyNodesPath;
	}
	public void setTopologyNodesPath(String topologyNodesPath) 
	{
		this.topologyNodesPath = topologyNodesPath;
	}
	public String getBGPSConfigurationFile() 
	{
		return BGPSConfigurationFile;
	}
	public void setBGPSConfigurationFile(String bGPSConfigurationFile) 
	{
		BGPSConfigurationFile = bGPSConfigurationFile;
	}
	public String getInterDomainFile() 
	{
		return interDomainFile;
	}
	public void setInterDomainFile(String interDomainFile)
	{
		this.interDomainFile = interDomainFile;
	}
	public String getControllerListFile() 
	{
		return controllerListFile;
	}
	public void setControllerListFile(String controllerListFile)
	{
		this.controllerListFile = controllerListFile;
	}
	public String getReachabilityFile() 
	{
		return reachabilityFile;
	}
	public void setReachabilityFile(String reachabilityFile)
	{
		this.reachabilityFile = reachabilityFile;
	}
	public int getMangementPort()
	{
		return mangementPort;
	}
	public void setMangementPort(int mangementPort) 
	{
		this.mangementPort = mangementPort;
	}
	public String getMangementIP()
	{
		return mangementIP;
	}
	public void setMangementIP(String mangementIP)
	{
		this.mangementIP = mangementIP;
	}
	public boolean isBGPLS() 
	{
		return isBGPLS;
	}
	public void setBGPLS(boolean isBGPLS) 
	{
		this.isBGPLS = isBGPLS;
	}
	public boolean isOSPF()
	{
		return isOSPF;
	}
	public void setOSPF(boolean isOSPF)
	{
		this.isOSPF = isOSPF;
	}
	public boolean isGSON() {
		return isGSON;
	}
	public void setGSON(boolean isGSON) 
	{
		this.isGSON = isGSON;
	}
	public boolean isFloodLight() 
	{
		return isFloodLight;
	}
	public void setFloodLight(boolean isOpenFlow)
	{
		this.isFloodLight = isOpenFlow;
	}
	public boolean isRYU() {
		return isRYU;
	}
	public void setRYU(boolean isRYU) {
		this.isRYU = isRYU;
	}
	public boolean isXML() 
	{
		return isXML;
	}
	public void setXML(boolean isXML) 
	{
		this.isXML = isXML;
	}
	public boolean isRestInfinera() 
	{
		return isRestInfinera;
	}
	public void setRestInfinera(boolean isRestInfinera)
	{
		this.isRestInfinera = isRestInfinera;
	}
	public boolean isCOPWriting() {
		
		return this.isCOPwritting;
	}
	public void setCOPWriting(boolean isCOPwritting)
	{
		this.isCOPwritting = isCOPwritting;
	}
	/**
	 * @return the cOPPort
	 */
	public int getExportCOPPort() {
		return exportCOPPort;
	}
	/**
	 * @param cOPPort the cOPPort to set
	 */
	public void setExportCOPPort(int cOPPort) {
		exportCOPPort = cOPPort;
	}
	public boolean isCOPReading() {
		// TODO Auto-generated method stub
		return isCOPReading;
	}
	public void setCOPReading(boolean isCOPReading)
	{
		this.isCOPReading = isCOPReading;
	}
	/**
	 * @return the remoteCOPhost
	 */
	public String getRemoteCOPhost() {
		return remoteCOPhost;
	}
	/**
	 * @param remoteCOPhost the remoteCOPhost to set
	 */
	public void setRemoteCOPhost(String remoteCOPhost) {
		this.remoteCOPhost = remoteCOPhost;
	}
	/**
	 * @return the remoteCOPPort
	 */
	public int getRemoteCOPPort() {
		return remoteCOPPort;
	}
	/**
	 * @param remoteCOPPort the remoteCOPPort to set
	 */
	public void setRemoteCOPPort(int remoteCOPPort) {
		this.remoteCOPPort = remoteCOPPort;
	}
	public String getTopologyLinksPath() {
		return topologyLinksPath;
	}
	public void setTopologyLinksPath(String topologyLinksPath) {
		this.topologyLinksPath = topologyLinksPath;
	}
	public boolean isIETFWritting() {
		return isIETFWritting;
	}
	public void setIETFWritting(boolean isIETFWritting) {
		this.isIETFWritting = isIETFWritting;
	}
	public boolean isIETFReading() {
		return isIETFReading;
	}
	public void setIETFReading(boolean isIETFReading) {
		this.isIETFReading = isIETFReading;
	}
	public int getExportIETFPort() {
		return exportIETFPort;
	}
	public void setExportIETFPort(int exportIETFPort) {
		this.exportIETFPort = exportIETFPort;
	}
	public String getRemoteIETFhost() {
		return remoteIETFhost;
	}
	public void setRemoteIETFhost(String remoteIETFhost) {
		this.remoteIETFhost = remoteIETFhost;
	}
	public int getRemoteIETFPort() {
		return remoteIETFPort;
	}
	public void setRemoteIETFPort(int remoteIETFPort) {
		this.remoteIETFPort = remoteIETFPort;
	}
	public boolean isCOPwritting() {
		return isCOPwritting;
	}
	public void setCOPwritting(boolean isCOPwritting) {
		this.isCOPwritting = isCOPwritting;
	}
	public boolean isUnifyWritting() {
		return isUnifyWritting;
	}
	public void setUnifyWritting(boolean isUnifyWritting) {
		this.isUnifyWritting = isUnifyWritting;
	}
	public boolean isUnifyReading() {
		return isUnifyReading;
	}
	public void setUnifyReading(boolean isUnifyReading) {
		this.isUnifyReading = isUnifyReading;
	}
	public int getExportUnifyPort() {
		return exportUnifyPort;
	}
	public void setExportUnifyPort(int exportUnifyPort) {
		this.exportUnifyPort = exportUnifyPort;
	}
	public String getRemoteUnifyhost() {
		return remoteUnifyhost;
	}
	public void setRemoteUnifyhost(String remoteUnifyhost) {
		this.remoteUnifyhost = remoteUnifyhost;
	}
	public int getRemoteUnifyPort() {
		return remoteUnifyPort;
	}
	public void setRemoteUnifyPort(int remoteUnifyPort) {
		this.remoteUnifyPort = remoteUnifyPort;
	}
        
        /**
         * This method return the port of the TAPI API
         * @return integer with the port value
         */
        public int getExportTAPIPort() {
            return exportTAPIPort;
        }
        /**
         * this method sets the port for TAPI API
         * @param tAPIPort  with port value to be ussed by the plugin 
         */
        void setExportTAPIPort(int tAPIPort) {
            exportTAPIPort = tAPIPort;
        }

        /**
         * This method returns true if works as exporter or false otherwise
         * @return the boolean value 
         */
        public boolean isTAPIWriting() {
		return this.isTAPIwriting;
	}
        /**
         * this method set the exporter flag to specify value as input argument
         * @param isTAPIwriting  boolean value to set
         */
        void setTAPIWriting(boolean isTAPIwriting) {
            this.isTAPIwriting = isTAPIwriting;
        }

	
}
