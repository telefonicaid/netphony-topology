package es.tid.bgp.bgp4Peer.peer;

import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import es.tid.bgp.bgp4Peer.management.BGP4ManagementServer;
import es.tid.bgp.bgp4Peer.updateTEDB.UpdateDispatcher;
import es.tid.tedb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * BGP-LS Speaker. 
 * This class is a BGP-LS peer which has two modes:
 * - Listens to incoming connections
 * - Launches new BGP session with a list of peers.
 * It can send periodically its learnt topology to other peers.
 * TEDB can be initialized from:
 * - XML file with the topolgoy
 * - Other BGP-LS Sessions 
 * 
 * @author pac ogondio 
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
	 * Topology database only for interDomain Links.
	 */
	private MultiDomainTEDB multiDomainTEDB;
	
	/**
	 * Table with domainID - TEDB.
	 * The BGP-LS Peer can have several domains
	 */
	private Hashtable<String,TEDB> intraTEDBs;
	
	/**
	 * Full TEDB with all Links
	 */
	
	private SimpleTEDB fullTEDB;
	
	
	/**
	 * Class to send periodically the topology
	 */
	//private DomainTEDB readDomainTEDB;
	
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
	 * 
	 */
	private boolean saveTopology;
	
	private SaveTopologyinDB saveTopologyDB;
	
	/**
	 * 
	 */
	/**
	 * List of peers to establish connections.
	 */
	private LinkedList<BGP4LSPeerInfo> peersToConnect;
	
	//Whitelist and blacklist not yet implemented
	
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
	 * @param nameParametersFile Name of the Parameters File
	 */
	public void configure(String nameParametersFile){
		configure(nameParametersFile, null, null);
	}
	
	/**
	 * Function to configure the BGP4 peer. 
	 * It created the loggers, the executor, 
	 * @param nameParametersFile Name of the Parameters File
	 * @param multiTEDB multidomain database
	 * @param iTEDBs internal domains database 
	 */
	public void configure(String nameParametersFile, MultiDomainTEDB multiTEDB, Hashtable<String,TEDB> iTEDBs){
		//First of all, read the parameters
		if (nameParametersFile != null){
			params=new BGP4Parameters(nameParametersFile);
		}else{
			params=new BGP4Parameters();
		}
		params.initialize();
		peersToConnect = params.getPeersToConnect();
		sendTopology = params.isSendTopology();
		saveTopology = params.isSaveTopologyDB();

		//Initialize loggers
//		FileHandler fh;
//		FileHandler fh1;
//		FileHandler fh2;
//		try {
//			fh=new FileHandler(params.getBGP4LogFile());
			logParser=LoggerFactory.getLogger("BGP4Parser");
//			logParser.addHandler(fh);
//			logParser.setLevel(Level.ALL);
//			fh1=new FileHandler(params.getBGP4LogFileClient());
			logClient=LoggerFactory.getLogger("BGP4Client");
//			logClient.addHandler(fh1);
//			logClient.setLevel(Level.ALL);
//			fh2=new FileHandler(params.getBGP4LogFileServer());
			logServer=LoggerFactory.getLogger("BGP4Peer");
//			logServer.addHandler(fh2);
//			logServer.setLevel(Level.ALL);
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			System.exit(1);
//		}
			logServer.info("Inizializing BGP4 Peer");
		if (iTEDBs!= null) intraTEDBs=iTEDBs;
		else intraTEDBs=new Hashtable<String,TEDB>();
		
		if (multiTEDB!= null) multiDomainTEDB = multiTEDB;
		else multiDomainTEDB = new MDTEDB();
	
		if (params.getLearnTopology().equals("fromXML")){
			//intraTEDBs=new Hashtable<Inet4Address,DomainTEDB>();
			//multiDomainTEDB = new MDTEDB();
			//intraTEDBs = FileTEDBUpdater.readMultipleDomainSimpleNetworks(params.getTopologyFile(), null, false,0,Integer.MAX_VALUE, false);
			logParser.info("BGPIdentifier: "+params.getBGPIdentifier());
			intraTEDBs = FileTEDBUpdater.readMultipleDomainSimpleNetworks(params.getTopologyFile(), null, false,0,Integer.MAX_VALUE, false, params.getBGPIdentifier());

			//multiDomainTEDB.initializeFromFile(params.getTopologyFile());
			multiDomainTEDB.initializeFromFile(params.getTopologyFile(), params.getBGPIdentifier());

		}
		// Create Thread executor
		//FIXME: Actualizar n�mero de threads que se crean
		executor = new ScheduledThreadPoolExecutor(20);//1 para el servidor, 1 para el que lanza y vigila los clientes
		// Information about all the sessions of the PCE
		if (params.isTest()) {
			bgp4SessionsInformation = new BGP4SessionsInformation(params.isTest());
		}
		else{
			bgp4SessionsInformation = new BGP4SessionsInformation();
		}
		//Create the task to send the topology. It has to be created because you can start sending the topology in the management (wirting): send topology on.
		sendTopologyTask = new SendTopology();
		saveTopologyDB= new SaveTopologyinDB();
		if (params.isSaveTopologyDB() == true){
			saveTopologyDB.configure(intraTEDBs, multiDomainTEDB, params.isSaveTopologyDB(), params.getTopologyDBIP().getHostAddress(), params.getTopologyDBport());
		}

	}
	
	public void setWriteMultiTEDB(MultiDomainTEDB multiTEDB) {
		
		this.multiDomainTEDB = multiTEDB;
		saveTopologyDB.setMultiDomainTEDB(multiTEDB);
	}

	/*
	//new function from Andrea
	public void setWriteMultiAndIntraTEDB(MultiDomainTEDB multiTEDB, Hashtable<Inet4Address,DomainTEDB> intraTEDBs) {

		this.multiDomainTEDB = multiTEDB;
		this.intraTEDBs = intraTEDBs;
		saveTopologyDB.setMultiDomainTEDB(multiTEDB);
		saveTopologyDB.setIntraTEDBs(intraTEDBs);
	}
	 */


	public void setReadDomainTEDB(DomainTEDB readDomainTEDB) {
		//this.readDomainTEDB = readDomainTEDB;
		//System.out.println("setReadDomain: readFomainTEDB().getDomainID()="+readDomainTEDB.getDomainID());
		//System.out.println("setReadDomain: readFomainTEDB="+readDomainTEDB.printTopology());
		if(readDomainTEDB.getDomainID() == null)
			this.intraTEDBs.put("default", readDomainTEDB);
		else
			this.intraTEDBs.put(readDomainTEDB.getDomainID().toString(), readDomainTEDB);
	}
	public void createUpdateDispatcher(){
		//Updater dispatcher
		ud = new UpdateDispatcher(multiDomainTEDB,intraTEDBs);
	}
	
	/**
	 * Function to create the TEDBs of the peer.
	 * @param nameParametersFile Name of the Parameters File
	 */

	
	/**
	 * Start the session for the management of the BGP4.
	 */
	public void startManagementServer(){
		logServer.debug("Initializing Management Server");
		BGP4ManagementServer bms=new BGP4ManagementServer(params.getBGP4ManagementPort(),multiDomainTEDB,intraTEDBs,bgp4SessionsInformation,sendTopologyTask);	
		bms.start();
	}
	/**
	 * Function which start the peer as a client which try to establish new sessions with peers.
	 * It starts a new process for each peer.  
	 */
	public void startClient(){
		logClient.debug("Initializing Session Manager to connect as client");
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
				//FIXME: Ver si dejamos delay fijo o variable	
				executor.scheduleWithFixedDelay(bgp4SessionClientManager, 0,params.getDelay(), TimeUnit.MILLISECONDS);
			}
		}
		else{
			logClient.error("ERROR: BGPIdentifier is not configured. To configure: XML file (BGP4Parameters.xml) <localBGPAddress>.");
			System.exit(1);
		}
		
	}
	/**
	 * Function which starts the peer (listening BGP4 protocol) as a server.
	 * It starts once the session server manager.
	 */
	public  void startServer(){
		logServer.debug("Initializing Session Manager to connect as server");
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
			if (params.isTest()) {
				bgp4SessionServer = new BGP4SessionServerManager(bgp4SessionsInformation, multiDomainTEDB, ud, params.getBGP4Port(), params.getHoldTime(), BGPIdentifier, params.getVersion(), params.getMyAutonomousSystem(), params.isNodelay(), localAddress, params.getKeepAliveTimer(), peersToConnect, params.isTest());
				executor.execute(bgp4SessionServer);
			}
			else {
				bgp4SessionServer = new BGP4SessionServerManager(bgp4SessionsInformation, multiDomainTEDB, ud, params.getBGP4Port(), params.getHoldTime(), BGPIdentifier, params.getVersion(), params.getMyAutonomousSystem(), params.isNodelay(), localAddress, params.getKeepAliveTimer(), peersToConnect);
				executor.execute(bgp4SessionServer);
			}

		}else{
			logServer.error("ERROR: BGPIdentifier is not configured. To configure: XML file (BGP4Parameters.xml) <localBGPAddress>.");
			System.exit(1);
		}
	}
	
	public void startSendTopology(){
		if (params.isTest()) {
			sendTopologyTask.configure(intraTEDBs, bgp4SessionsInformation, sendTopology, params.getInstanceID(),params.isSendIntradomainLinks(),this.multiDomainTEDB, params.isTest());
		}
		else{
			sendTopologyTask.configure(intraTEDBs, bgp4SessionsInformation, sendTopology, params.getInstanceID(),params.isSendIntradomainLinks(),this.multiDomainTEDB);
		}
		executor.scheduleWithFixedDelay(sendTopologyTask, 0,params.getSendTopoDelay(), TimeUnit.MILLISECONDS);
	}
	
	
	
	public void startSaveTopology(){
		//FIXME: ADD param to configure the delay
		executor.scheduleWithFixedDelay(saveTopologyDB, 0,5000, TimeUnit.MILLISECONDS);
	}
		
	
	public SaveTopologyinDB getSaveTopologyDB() {
		return saveTopologyDB;
	}
	
	public void setSaveTopologyDB(SaveTopologyinDB saveTopologyDB) {
		this.saveTopologyDB = saveTopologyDB;
	}
	
	public boolean isSaveTopology() {
		return saveTopology;
	}
	
	public void setSaveTopology(boolean saveTopology) {
		this.saveTopology = saveTopology;
	}
	
	public UpdateDispatcher getUd() {
		return ud;
	}
	
	public void setUd(UpdateDispatcher ud) {
		this.ud = ud;
	}

	public void addSimpleTEDB(SimpleTEDB simpleTEDB, String domainID) {
			this.intraTEDBs.put(domainID, simpleTEDB);
	}
	
	public void setSimpleTEDB(SimpleTEDB simpleTEDB) {
		if(simpleTEDB.getDomainID() == null)
			this.intraTEDBs.put("default", simpleTEDB);
		else
			this.intraTEDBs.put(simpleTEDB.getDomainID().toString(), simpleTEDB);
	}
	
	
	public void stopPeer(){
		executor.shutdown();
	}
	public MultiDomainTEDB getMultiDomainTEDB() {
		return multiDomainTEDB;
	}
	

	public Hashtable<String, TEDB> getIntraTEDBs() {
		return intraTEDBs;
	}

	public void setIntraTEDBs(Hashtable<String, TEDB> intraTEDBs) {
		this.intraTEDBs = intraTEDBs;
	}

	public void setMultiDomainTEDB(MultiDomainTEDB multiDomainTEDB) {
		this.multiDomainTEDB = multiDomainTEDB;
	}
	
	
	
	
	
}
