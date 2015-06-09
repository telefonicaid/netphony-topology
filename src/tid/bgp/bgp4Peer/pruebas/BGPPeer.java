package tid.bgp.bgp4Peer.pruebas;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.Receiver;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;












import es.tid.bgp.bgp4.messages.BGP4Update;
import es.tid.bgp.bgp4.update.fields.LinkNLRI;
import es.tid.bgp.bgp4.update.fields.NodeNLRI;
import es.tid.bgp.bgp4.update.fields.PathAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.AS_Path_Attribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.LinkStateAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.OriginAttribute;
import es.tid.bgp.bgp4.update.fields.pathAttributes.PathAttributesTypeCode;
import es.tid.bgp.bgp4.update.tlv.LocalNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.RemoteNodeDescriptorsTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.LinkStateAttributeTLVTypes;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.UnreservedBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AutonomousSystemNodeDescriptorSubTLV;
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
import tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import tid.bgp.bgp4Peer.bgp4session.GenericBGP4Session;
import tid.bgp.bgp4Peer.management.BGP4ManagementServer;
import tid.bgp.bgp4Peer.tedb.IntraTEDBS;
import tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;
import tid.pce.tedb.DomainTEDB;
import tid.pce.tedb.InterDomainEdge;
import tid.pce.tedb.IntraDomainEdge;
import tid.pce.tedb.MDTEDB;
import tid.pce.tedb.MultiDomainTEDB;
import tid.pce.tedb.SimpleTEDB;
import tid.pce.tedb.TEDB;
import tid.pce.tedb.TE_Information;

/**
 * Principal class. 
 * This is a BGP4 peer. It launches the BGP connections with its peers.
 * 
 * @author pac
 *
 */
public class BGPPeer {
	/**
	 * Session server. It opens a socket to listen to new connections.
	 */
	private BGP4SessionServerManager bgp4SessionServer;
	/**
	 * Session client. It connects to peers.
	 */
	private  BGP4SessionClientManager  bgp4SessionClientManager;
	/**
	 * BGP4 parameters. Needed to configure the connections.
	 */
	private BGP4Parameters params;
	
	/**
	 * List of opened BGP4 sessions. 
	 */
	private BGP4SessionsInformation bgp4SessionsInformation;
	
	/**
	 * Topology database for interDomain Links.
	 */
	private MultiDomainTEDB writeMultiTEDB;
	/**
	 * Topology database for intradomain Links. It owns several domains.
	 */
	private IntraTEDBS intraTEDB;
	private SimpleTEDB simpleTEDB;
	
	/**
	 * Class to send periodically the topology
	 */
	private DomainTEDB readDomainTEDB;
	
	/**
	 * True: This peer sends the topology to other peers
	 * False: This peer does NOT send the topology to other peers
	 */
	private boolean sendTopology;
	/**
	 * 
	 */
	private SendTopology sendTopologyTask;
	/**
	 * List of peers to establish connection.
	 */
	private LinkedList<String> peersToConnect;
	
	/**
	 * List of boolean to decide wether to send or not to send to the correspondent peer
	 */
	private LinkedList<Boolean> sendToPeer;
	
	/**
	 * List of boolean to decide wether to update or not to update from the correspondent peer
	 */
	private LinkedList<Boolean> updateFromPeer;
	//Lista de "peers" aceptables (son los que dejo que se conecten a mi)
	
	//Lista negra de "peers" NO aceptables (no les dejo que se conecten a mi, siempre les rechazare)
	/**
	 * Loggers
	 */
	private Logger logParser;
	private Logger logClient;
	private Logger logServer;
	/**
	 * Class to read and process the BGP4 update messages
	 */
	private UpdateDispatcher ud;
	/**
	 * Executor. To execute the session server, to execute periodically the session client.
	 */
	private ScheduledThreadPoolExecutor executor;
	
	
	/**
	 * Function to configure the BGP4 Peer without specifying the file. It will read a file with name: BGP4Parameters.xml
	 */
	public void  configure (){
		this.configure (null);
	}
	/**
	 * Function to configure the BGP4 peer. 
	 * It created the loggers, the executor, 
	 * @param args
	 */
	public void configure(String nameParametersFile){
		//First of all, read the parameters	
		if (nameParametersFile != null){
			params=new BGP4Parameters(nameParametersFile);
		}else{
			params=new BGP4Parameters();
		}
		params.initialize();
		peersToConnect = params.getPeersToConnect();
		sendTopology = params.isSendTopology();
		this.setSendToPeer(params.getSendToPeer());
		this.setUpdateFromPeer(params.getUpdateFromPeer());
		
		//Initialize loggers
		FileHandler fh;
		FileHandler fh1;
		FileHandler fh2;
		try {			
			fh=new FileHandler(params.getBGP4LogFile());		
			logParser=Logger.getLogger("BGP4Parser");
			logParser.addHandler(fh);
			logParser.setLevel(Level.ALL);
			fh1=new FileHandler(params.getBGP4LogFileClient());		
			logClient=Logger.getLogger("BGP4Client");
			logClient.addHandler(fh1);
			logClient.setLevel(Level.ALL);		
			fh2=new FileHandler(params.getBGP4LogFileServer());		
			logServer=Logger.getLogger("BGP4Server");
			logServer.addHandler(fh2);
			logServer.setLevel(Level.ALL);

		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		logParser.info("Inizializing BGP4 Peer");
		// Create Thread executor
		//FIXME: Actualizar n�mero de threads que se crean
		executor = new ScheduledThreadPoolExecutor(10);//1 para el servidor, 1 para el que lanza y vigila los clientes
		// Information about all the sessions of the PCE
		bgp4SessionsInformation = new BGP4SessionsInformation();
		//Create the task to send the topology. It has to be created because you can start sending the topology in the management (wirting): send topology on.
		sendTopologyTask = new SendTopology();
	}
	
	
	public void setWriteMultiTEDB(MultiDomainTEDB multiTEDB) {
		this.writeMultiTEDB = multiTEDB;
	}

	public void setIntraTEDB(IntraTEDBS intraTEDB) {
		this.intraTEDB = intraTEDB;
	}
	
	public void setReadDomainTEDB(DomainTEDB readDomainTEDB) {
		this.readDomainTEDB = readDomainTEDB;
	}
	public void createUpdateDispatcher(){
		//Updater dispatcher
		ud = new UpdateDispatcher(writeMultiTEDB,simpleTEDB);
	}
	/**
	 * Function to create the TEDBs of the peer.
	 *
	 * @param args
	 */
	public void  createTEDB (String nameParametersFile){
		//Topology database
		writeMultiTEDB = new MDTEDB();
		
		if (params.getLearnTopology().equals("fromXML")){	
			writeMultiTEDB.initializeFromFile(params.getTopologyFile());
			//intraTEDB.initializeFromFile(params.getTopologyFile());		
		}
		

	}
	
	/**
	 * Start the session for the management of the BGP4.
	 */
	public void startManagementServer(){
		logServer.info("Initializing Management Server");	
		BGP4ManagementServer bms=new BGP4ManagementServer(params.getBGP4ManagementPort(),writeMultiTEDB,intraTEDB, simpleTEDB,bgp4SessionsInformation,sendTopologyTask,readDomainTEDB);	
		bms.start();
	}
	/**
	 * Function which start the peer as a client which try to establish new sessions with peers.
	 * It starts a new process for each peer.  
	 */
	public void startClient(){
		logClient.info("Initializing Session Manager to connect as client");
		if (params.getBGPIdentifier() != null){
			Inet4Address BGPIdentifier=null;
			try {
				BGPIdentifier = (Inet4Address) InetAddress.getByName(params.getBGPIdentifier());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			for (int i =0;i<peersToConnect.size();i++){		
				bgp4SessionClientManager=new BGP4SessionClientManager(bgp4SessionsInformation,ud, peersToConnect.get(i), params.getBGP4Port(),params.getLocalBGPAddress(),params.getLocalBGPPort(),params.getHoldTime(),BGPIdentifier,params.getVersion(),params.getMyAutonomousSystem(),params.getKeepAliveTimer());
				bgp4SessionClientManager.setSendTo(sendToPeer.get(i));
				bgp4SessionClientManager.setUpdateFrom(updateFromPeer.get(i));
				//FIXME: Ver si dejamos delay fijo o variable	
				executor.scheduleWithFixedDelay(bgp4SessionClientManager, 0,params.getDelay(), TimeUnit.MILLISECONDS);
			}
		}
		else{
			logClient.info("ERROR: BGPIdentifier is not configured. To configure: XML file (BGP4Parameters.xml) <localBGPAddress>.");
			System.exit(1);
		}
		
	}
	/**
	 * Function which starts the peer (listening BGP4 protocol) as a server.
	 * It starts once the session server manager.
	 */
	public  void startServer(){
		logServer.info("Initializing Session Manager to connect as server");
		Inet4Address localAddress=null;
		Inet4Address BGPIdentifier=null;
		if (params.getBGPIdentifier() != null){
			try {
				localAddress = (Inet4Address) InetAddress.getByName(params.getLocalBGPAddress());
				BGPIdentifier = (Inet4Address) InetAddress.getByName(params.getBGPIdentifier());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			bgp4SessionServer = new BGP4SessionServerManager(bgp4SessionsInformation,writeMultiTEDB, ud,params.getBGP4Port(),params.getHoldTime(),BGPIdentifier,params.getVersion(),params.getMyAutonomousSystem(), params.isNodelay(),localAddress,params.getKeepAliveTimer() );
			executor.execute(bgp4SessionServer);
		}else{
			logServer.severe("ERROR: BGPIdentifier is not configured. To configure: XML file (BGP4Parameters.xml) <localBGPAddress>.");
			System.exit(1);
		}
	}
	
	public void startSendTopology(){
		sendTopologyTask.configure(readDomainTEDB, bgp4SessionsInformation, sendTopology, params.getInstanceID(),params.isSendIntradomainLinks());
		executor.scheduleWithFixedDelay(sendTopologyTask, 0,params.getDelay(), TimeUnit.MILLISECONDS);
	}
	public UpdateDispatcher getUd() {
		return ud;
	}
	public void setUd(UpdateDispatcher ud) {
		this.ud = ud;
	}
	public SimpleTEDB getSimpleTEDB() {
		return simpleTEDB;
	}
	public void setSimpleTEDB(SimpleTEDB simpleTEDB) {
		this.simpleTEDB = simpleTEDB;
	}
	public LinkedList<Boolean> getSendToPeer() {
		return sendToPeer;
	}
	public void setSendToPeer(LinkedList<Boolean> sendToPeer) {
		this.sendToPeer = sendToPeer;
	}
	public LinkedList<Boolean> getUpdateFromPeer() {
		return updateFromPeer;
	}
	public void setUpdateFromPeer(LinkedList<Boolean> updateFromPeer) {
		this.updateFromPeer = updateFromPeer;
	}
}