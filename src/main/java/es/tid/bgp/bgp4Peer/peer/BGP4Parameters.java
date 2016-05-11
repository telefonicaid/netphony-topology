package es.tid.bgp.bgp4Peer.peer;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Parameters to configure the BGP4 session
 * @author mcs
 *
 */
public class BGP4Parameters {
	
	private Logger log = LoggerFactory.getLogger("TMController");
	/**
	 * TCP port where the BGP is listening for incoming bgp4 connections
	 * Experimental use only. Default and standard is 179
	 */
	private int BGP4Port = 179;

	/**
	 * TCP port to connect to manage the BGP connection
	 */
	private int BGP4ManagementPort = 1112;
	/**
	 * Local BGP4 address of this peer
	 */
	private String localBGPAddress = "127.0.0.1";
	/**
	 * Local port to connect with BGP Peer.
	 */
	private int localBGPPort = 0;
	/**
	 * Log file
	 */
	private String BGP4LogFile="BGP4Parser.log";
	/**
	 * Log file Client
	 */
	private String BGP4LogFileClient="BGP4Client.log";


	/**
	 * Log file Client
	 */
	private String BGP4LogFileServer="BGP4Server.log";


	/**
	 * Name of the configuration file
	 */
	private String confFile;

	/**
	 * If the tcp no delay option is used or not.
	 */
	private boolean nodelay=false;
	/**
	 * Waiting Time to connect to clients
	 */
	long delay = 6000;
	/**
	 * List of peers to establish connection.
	 */
	private LinkedList<BGP4LSPeerInfo> peersToConnect;
	
	/**
	 * Parameter used to set traces meanwhile the execution.
	 */
	private boolean setTraces=true;
	/**
	 * OPEN PARAMENTERS
	 */
	int holdTime=90;
	
	/**
	 * Time between sending keepalives
	 */
	int keepAliveTimer=30;
	
	/**
	 * Time between topology updates
	 */
	long sendTopoDelay=30000;
	
	private boolean saveTopologyDB=false;
	
	private Inet4Address topologyDBIP;
	
	private int topologyDBport;
	
	public int getKeepAliveTimer() {
		return keepAliveTimer;
	}
	public void setKeepAliveTimer(int keepAliveTimer) {
		this.keepAliveTimer = keepAliveTimer;
	}
	String BGPIdentifier = null;
	int myAutonomousSystem=1;
	int version=0x04;
	
	/**
	 * This parameter can have three options: fromXML, fromOSPF, fromBGP 
	 * Explain the way the topology module learns the topology
	 */
	private String learnTopology="fromBGP";
	/**
	 * XML File to read and generate the topology
	 */
	private String topologyFile;
	

	private int numberTriesToConnect=3;
	/**
	 * True: This peer sends the interdomain links of the topology to other peers
	 * False: This peer does NOT send the topology to other peers
	 */
	private boolean sendTopology=false;
	/**
	 * True: This peer sends the whole topology to other peers
	 * False: This peer does NOT send the intradomain linksto other peers
	 */
	private boolean sendIntradomainLinks=false;
	


	/**
	 * Instance identifier for NodeNLRI (Types defined in class InstanceIDTypes)
	 */
	private int instanceID=0;
	/**
	 * Constructor 
	 */
	BGP4Parameters(){
		confFile="BGP4Parameters.xml";
		peersToConnect =new LinkedList<BGP4LSPeerInfo>();
	}
	/**
	 * Constructor 
	 */
	BGP4Parameters(String confFile){
		peersToConnect =new LinkedList<BGP4LSPeerInfo>();

		if (confFile!=null){
			this.confFile=confFile;
		}else {
			confFile="BGP4Parameters.xml";
		}
		
	}
		
	
	
	public void initialize(){
		
		try {

			System.out.println("Parsing Config File::"+confFile);
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			

			DefaultHandler handler = new DefaultHandler() {
				boolean peer = false;
				boolean send = false;
				boolean receive = false;
				boolean peerPort = false;
				BGP4LSPeerInfo peerInfo=null;

				String tempVal;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
								throws SAXException {
					
					if (qName.equalsIgnoreCase("configPeer")){
						log.debug("Found peer configuration");
					}
					else if (qName.equalsIgnoreCase("peer")){
						peer = true;
					}
					else if (qName.equalsIgnoreCase("export")){
						send = true;
					}
					else if (qName.equalsIgnoreCase("import")){
						receive = true;
					}else if (qName.equalsIgnoreCase("peerPort")){
						peerPort = true;
					}
						
				}

				public void endElement(String uri, String localName,
						String qName)
								throws SAXException {
					if(qName.equalsIgnoreCase("BGP4Port")) {
						BGP4Port=Integer.parseInt(tempVal.trim());
						
					}
					else if (qName.equalsIgnoreCase("BGP4ManagementPort")){
						BGP4ManagementPort = Integer.parseInt(tempVal.trim());
					}
					
					else if (qName.equalsIgnoreCase("BGP4LogFile")) {
						BGP4LogFile=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("BGP4LogFileClient")) {
						BGP4LogFileClient=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("BGP4LogFileServer")) {
						BGP4LogFileServer=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("nodelay")) {
						nodelay=Boolean.parseBoolean(tempVal.trim());
					}
					
					else if (qName.equalsIgnoreCase("setTraces")) {
						setTraces=Boolean.parseBoolean(tempVal.trim());
					} 
					else if (qName.equalsIgnoreCase("saveTopologyDB")) {
						saveTopologyDB=Boolean.parseBoolean(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("topologyDBIP")) {
						try {
							topologyDBIP =(Inet4Address)Inet4Address.getByName(tempVal.trim());
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if (qName.equalsIgnoreCase("topologyDBport")) {
						topologyDBport=Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("sendTopology")) {
						sendTopology=Boolean.parseBoolean(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("sendIntradomainLinks")) {
						sendIntradomainLinks=Boolean.parseBoolean(tempVal.trim());
						sendTopology = true;//si se envian los intradomain entonces se enviara la topologia entera
					}
			
					
					else if(qName.equalsIgnoreCase("holdTime")) {
						holdTime=Integer.parseInt(tempVal.trim());
					}
					else if(qName.equalsIgnoreCase("keepAliveTimer")) {
						keepAliveTimer=Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("version")){
						version = Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("myAutonomousSystem")){
						myAutonomousSystem = Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("localBGPAddress")){//El BGP Identifier es la local BGP Address.
						//BGPIdentifier = tempVal.trim();
						localBGPAddress=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("BGPIdentifier")){//El BGP Identifier es la local BGP Address.
						BGPIdentifier = tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("delay")){
						delay = Long.parseLong(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("sendTopoDelay")){
						sendTopoDelay = Long.parseLong(tempVal.trim());
					}
					/*
					else if (qName.equalsIgnoreCase("peer")){
						String peerBGP_IPaddress = tempVal.trim();
						peersToConnect.add(peerBGP_IPaddress);					
					}*/					
					else if (qName.equalsIgnoreCase("TopologyFile")) {
						topologyFile=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("learnTopology")) {
						learnTopology=tempVal.trim();
					}
					else if (qName.equalsIgnoreCase("numberTriesToConnect")){
						numberTriesToConnect = Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("instanceID")){
						instanceID = Integer.parseInt(tempVal.trim());
					}
					else if (qName.equalsIgnoreCase("localBGPPort")){
						localBGPPort = Integer.parseInt(tempVal.trim());
					}
//					else if (qName.equalsIgnoreCase("configPeer")){
//						log.info("peers....." + peersToConnect.toString());
//					}
				}	
				

				public void characters(char[] ch, int start, int length) throws SAXException {
					tempVal = new String(ch,start,length);
					
					if(peer){
						peerInfo= new BGP4LSPeerInfo();
						
						String peerBGP_IPaddress = new String(ch, start, length);
						Inet4Address peerBGPIP;
						try {
							peerBGPIP=(Inet4Address)Inet4Address.getByName(peerBGP_IPaddress.trim());
							peerInfo.setPeerIP(peerBGPIP);
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						peersToConnect.add(peerInfo);
						peer = false;
					}
					else if(send){
						String sendInfo = new String(ch, start, length);
						peerInfo.setSendToPeer(Boolean.parseBoolean(sendInfo.trim()));
						send = false;
					}
					else if(receive){
						String update_from = new String(ch, start, length);
						peerInfo.setUpdateFromPeer(Boolean.parseBoolean(update_from.trim()));
						receive = false;
					}else if (peerPort){
						String peer_port = new String(ch, start, length);
						peerInfo.setPeerPort(Integer.parseInt(peer_port.trim()));
						peerPort = false;
					}
				}
			};
			saxParser.parse(confFile, handler);     

		}catch (Exception e) {
			log.error("Problems reading config");	
			e.printStackTrace();
			System.exit(1);
		}

	}
	public int getBGP4Port() {
		return BGP4Port;
	}
	public void setBGP4Port(int bGP4Port) {
		BGP4Port = bGP4Port;
	}
	public int getBGP4ManagementPort() {
		return BGP4ManagementPort;
	}
	public void setBGP4ManagementPort(int bGP4ManagementPort) {
		BGP4ManagementPort = bGP4ManagementPort;
	}
	public String getBGP4LogFile() {
		return BGP4LogFile;
	}
	public void setBGP4LogFile(String bGP4LogFile) {
		BGP4LogFile = bGP4LogFile;
	}
	public boolean isSetTraces() {
		return setTraces;
	}
	public void setSetTraces(boolean setTraces) {
		this.setTraces = setTraces;
	}
	public String getConfFile() {
		return confFile;
	}
	public void setConfFile(String confFile) {
		this.confFile = confFile;
	}
	public boolean isNodelay() {
		return nodelay;
	}
	public void setNodelay(boolean nodelay) {
		this.nodelay = nodelay;
	}
	public int getHoldTime() {
		return holdTime;
	}
	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}
	public String getBGPIdentifier() {
		return BGPIdentifier;
	}
	public void setBGPIdentifier(String bGPIdentifier) {
		BGPIdentifier = bGPIdentifier;
	}
	public int getMyAutonomousSystem() {
		return myAutonomousSystem;
	}
	public void setMyAutonomousSystem(int myAutonomousSystem) {
		this.myAutonomousSystem = myAutonomousSystem;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public LinkedList<BGP4LSPeerInfo> getPeersToConnect() {
		return peersToConnect;
	}
	public void setPeersToConnect(LinkedList<BGP4LSPeerInfo> peersToConnect) {
		this.peersToConnect = peersToConnect;
	}

	public String getLearnTopology() {
		return learnTopology;
	}
	public void setLearnTopology(String learnTopology) {
		this.learnTopology = learnTopology;
	}
	public String getTopologyFile() {
		return topologyFile;
	}
	public void setTopologyFile(String topologyFile) {
		this.topologyFile = topologyFile;
	}

	public int getNumberTriesToConnect() {
		return numberTriesToConnect;
	}
	public void setNumberTriesToConnect(int numberTriesToConnect) {
		this.numberTriesToConnect = numberTriesToConnect;
	}
	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
	public boolean isSendTopology() {
		return sendTopology;
	}
	public void setSendTopology(boolean sendTopology) {
		this.sendTopology = sendTopology;
	}
	public String getBGP4LogFileClient() {
		return BGP4LogFileClient;
	}
	public void setBGP4LogFileClient(String bGP4LogFileClient) {
		BGP4LogFileClient = bGP4LogFileClient;
	}
	public String getBGP4LogFileServer() {
		return BGP4LogFileServer;
	}
	public void setBGP4LogFileServer(String bGP4LogFileServer) {
		BGP4LogFileServer = bGP4LogFileServer;
	}
	public int getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(int instanceID) {
		this.instanceID = instanceID;
	}
	public boolean isSendIntradomainLinks() {
		return sendIntradomainLinks;
	}
	
	public void setSendIntradomainLinks(boolean sendIntradomainLinks) {
		this.sendIntradomainLinks = sendIntradomainLinks;
	}
	
		
	public String getLocalBGPAddress() {
		return localBGPAddress;
	}
	public void setLocalBGPAddress(String localBGPAddress) {
		this.localBGPAddress = localBGPAddress;
	}
	public int getLocalBGPPort() {
		return localBGPPort;
	}
	
	public long getSendTopoDelay() {
		return sendTopoDelay;
	}
	public void setSendTopoDelay(long sendTopoDelay) {
		this.sendTopoDelay = sendTopoDelay;
	}
	public boolean isSaveTopologyDB() {
		return saveTopologyDB;
	}
	public void setSaveTopologyDB(boolean saveTopologyDB) {
		this.saveTopologyDB = saveTopologyDB;
	}
	public Inet4Address getTopologyDBIP() {
		return topologyDBIP;
	}
	public void setTopologyDBIP(Inet4Address topologyDBIP) {
		this.topologyDBIP = topologyDBIP;
	}
	public int getTopologyDBport() {
		return topologyDBport;
	}
	public void setTopologyDBport(int topologyDBport) {
		this.topologyDBport = topologyDBport;
	}
	
	
	
	
	
}
