package es.tid.tedb;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import es.tid.of.DataPathID;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;

/**
 * Traffic Engineering Database of a Domain.
 * 
 * 
 * @author ogondio, mcs, b.mvas
 *
 */
public class SimpleTEDB implements DomainTEDB{
	
	private Inet4Address domainID;

	/**
	 * List of algorithms that will be notified when there are significant changes in the TED
	 */
	private ArrayList<TEDListener> registeredAlgorithms;
	/**
	 * List of algorithms SSON that will be notified when there are significant changes in the TED
	 */
	private ArrayList<SSONListener> registeredAlgorithmssson;
	/**
	 * Graph of the Network
	 */
	private SimpleDirectedWeightedGraph<Object,IntraDomainEdge> networkGraph;

	/**
	 * List of interdomain Links
	 */
	private LinkedList<InterDomainEdge> interDomainLinks = new LinkedList<InterDomainEdge>(); 

	/*
	 * List of Intradomain Edges
	 * Please, It's not the same as intraDomainLinks
	 * This has been created to support multiedges between two nodes
	 */
	private LinkedList<IntraDomainEdge> intraDomainEdges = new LinkedList<IntraDomainEdge>(); 


	/**
	 * Reachability information
	 */
	private ReachabilityEntry reachabilityEntry;
	/**
	 * Information about the labels in a WSON network.
	 */
	private WSONInformation WSONinfo=null;
	/**
	 * Information about the labels in a SSON network.
	 */
	private SSONInformation SSONinfo=null;

	private Lock TEDBlock;

	private Hashtable<Object , Node_Info> NodeTable;

	private boolean multidomain=false;//By default, the TED has only one domain
	Logger log;
	public SimpleTEDB(){
		log=Logger.getLogger("TEDBParser");		
		registeredAlgorithms= new ArrayList<TEDListener>();
		registeredAlgorithmssson= new ArrayList<SSONListener>();
		TEDBlock=new ReentrantLock();
		NodeTable = new Hashtable<Object, Node_Info>();
	}

	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> getDuplicatedNetworkGraph(){
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graphCopy;
		TEDBlock.lock();
		try{
			graphCopy= (SimpleDirectedWeightedGraph<Object, IntraDomainEdge>) networkGraph.clone();
		} finally{
			TEDBlock.unlock();
		}
		return graphCopy;
	}
	public void createGraph(){
		networkGraph = new SimpleDirectedWeightedGraph<Object, IntraDomainEdge>(IntraDomainEdge.class);
		reachabilityEntry = new ReachabilityEntry();
	}

	public void initializeFromFile(String file){
		initializeFromFile(file, null, false,0,Integer.MAX_VALUE, false,false);
	}
	public void initializeFromFile(String file, String layer){
		initializeFromFile(file, layer, false,0,Integer.MAX_VALUE, false,false);
	}
	public void initializeFromFile(String file, String layer, boolean multidomain){
		initializeFromFile(file, layer, multidomain,0,Integer.MAX_VALUE, false,false);
	}
	public void initializeFromFile(String file, String layer, boolean multidomain, boolean isSSON){
		initializeFromFile(file, layer, multidomain,0,Integer.MAX_VALUE, isSSON,false);
	}
	public void initializeFromFile(String file, String layer, boolean multidomain,int lambdaIni, int lambdaEnd){
		initializeFromFile(file, layer, multidomain,0,Integer.MAX_VALUE, false,false);
	}
	public void initializeFromFile(String file, String layer, boolean multidomain, int lambdaIni, int lambdaEnd, boolean isSSON,boolean readOnlyInterDomainLinks){	
		initializeFromFile( file,  layer,  multidomain,  lambdaIni,  lambdaEnd,  isSSON, readOnlyInterDomainLinks, false);
	}

	public void initializeFromFile(String file, String layer, boolean multidomain, int lambdaIni, int lambdaEnd, boolean isSSON,boolean readOnlyInterDomainLinks, boolean isWLAN){
		domainID=FileTEDBUpdater.getDomainIDfromSimpleDomain(file);
		if (readOnlyInterDomainLinks){
			log.info("Read Only Inter Domain Links");
			networkGraph = new SimpleDirectedWeightedGraph<Object, IntraDomainEdge>(IntraDomainEdge.class);
			if (!multidomain){
				interDomainLinks = FileTEDBUpdater.readInterDomainLinks(file);	
			}
			reachabilityEntry = new ReachabilityEntry();
			if (!multidomain){
				FileTEDBUpdater.getDomainReachabilityFromFile(file,reachabilityEntry);
			}
			if((isSSON==true)&(!isWLAN)){
				SSONinfo = FileTEDBUpdater.getSSONInformation(file);
			}else if (isWLAN)
			{

			}
			else
			{
				WSONinfo = FileTEDBUpdater.getWSONInformation(file);
			}
		}else{
			if((isSSON==true)&&(!isWLAN)){
				networkGraph=FileTEDBUpdater.readNetwork(file,layer, multidomain,lambdaIni,lambdaEnd, isSSON);
				SSONinfo = FileTEDBUpdater.getSSONInformation(file);
			}
			else if (isWLAN)
			{
				networkGraph=FileTEDBUpdater.readNetwork(file,layer, multidomain,lambdaIni,lambdaEnd, isSSON);
			}
			else{
				networkGraph=FileTEDBUpdater.readNetwork(file,layer, multidomain,lambdaIni,lambdaEnd);
				WSONinfo = FileTEDBUpdater.getWSONInformation(file);
			}
			//		if (lambdaEnd!=Integer.MAX_VALUE){
			//			notifyAlgorithms( lambdaIni, lambdaEnd);
			//		}
			Iterator<Object> itervertex=networkGraph.vertexSet().iterator();

			/** Se podrian sacar a una funcion externa ambos 'while'
			 *  Rellenar info table
			 *  Rellenar info edge
			 *  Preguntar a Oscar
			 */
			while (itervertex.hasNext()) {
				Object address = itervertex.next();
				Node_Info ni = new Node_Info();
				if (address instanceof Inet4Address){
					ni.setIpv4AddressLocalNode((Inet4Address)address);
					ni.setIpv4Address((Inet4Address)address);//de momento asumimos que aprendemos ospf					
				} else if (address instanceof DataPathID) {
					ni.setDataPathLocalNode((DataPathID)address); 
				}
				ni.setLearntFrom("Fom XML");
				ni.setAs_number(domainID);
				NodeTable.put(address, ni);	
			}

			Iterator<IntraDomainEdge> iteredge=networkGraph.edgeSet().iterator();
			while (iteredge.hasNext()) {
				IntraDomainEdge id =  (IntraDomainEdge) iteredge.next();
				try{
					Inet4Address ipSource = (Inet4Address) (id.getSource());
					Inet4Address ipDest = (Inet4Address) (id.getTarget());
					id.setLearntFrom("From XML");
					Node_Info origin = new Node_Info();
					Node_Info destination = new Node_Info();
					origin.setIpv4AddressLocalNode(ipSource);
					origin.setAs_number(domainID);
					origin.setLearntFrom("FromXML");
					destination.setIpv4AddressLocalNode(ipDest);
					destination.setAs_number(domainID);
					destination.setLearntFrom("FromXML");
					id.setLocal_Node_Info(origin);
					id.setRemote_Node_Info(destination);
					NodeTable.get(ipSource).setSID(id.getSrc_sid());
					NodeTable.get(ipDest).setSID(id.getDst_sid());
				}catch (Exception e1){
					DataPathID dpSource = (DataPathID) (id.getSource());
					DataPathID dpDest = (DataPathID) (id.getTarget());
					id.setLearntFrom("From XML");
					Node_Info origin = new Node_Info();
					Node_Info destination = new Node_Info();
					origin.setDataPathLocalNode(dpSource);
					origin.setAs_number(domainID);
					origin.setLearntFrom("FromXML");
					destination.setDataPathLocalNode(dpDest);
					destination.setAs_number(domainID);
					destination.setLearntFrom("FromXML");
					id.setLocal_Node_Info(origin);
					id.setRemote_Node_Info(destination);
					//NodeTableDataPath.get(dpSource).setSID(id.getSrc_sid());
					//NodeTableDataPath.get(dpDest).setSID(id.getDst_sid());
				}

			}
		}


		if (!multidomain){
			interDomainLinks = FileTEDBUpdater.readInterDomainLinks(file);	
		}
		else {
			interDomainLinks = new LinkedList<InterDomainEdge>();	
		}
		reachabilityEntry = new ReachabilityEntry();
		if (!multidomain){
			FileTEDBUpdater.getDomainReachabilityFromFile(file,reachabilityEntry);
		}

		Iterator<InterDomainEdge> edgeIt = interDomainLinks.iterator();
		while (edgeIt.hasNext()) {
			InterDomainEdge id =  (InterDomainEdge) edgeIt.next();
			try {
				Inet4Address ipSource = (Inet4Address) (id.src_router_id);
				Inet4Address ipDest = (Inet4Address) (id.dst_router_id);
				id.setLearntFrom("From XML");
				Node_Info origin = new Node_Info();
				Node_Info destination = new Node_Info();
				origin.setIpv4AddressLocalNode(ipSource);
				origin.setAs_number(domainID);
				origin.setLearntFrom("FromXML");
				destination.setIpv4AddressLocalNode(ipDest);
				destination.setAs_number((Inet4Address) id.domain_dst_router);
				destination.setLearntFrom("FromXML");
				id.setLocal_Node_Info(origin);
				id.setRemote_Node_Info(destination);
			} catch (Exception e) {
				DataPathID dpSource = (DataPathID) (id.src_router_id);
				DataPathID dpDest = (DataPathID) (id.dst_router_id);
				id.setLearntFrom("From XML");
				Node_Info origin = new Node_Info();
				Node_Info destination = new Node_Info();
				origin.setDataPathLocalNode(dpSource);
				origin.setAs_number(domainID);
				origin.setLearntFrom("FromXML");
				destination.setDataPathLocalNode(dpDest);
				destination.setAs_number((Inet4Address) id.domain_dst_router);
				destination.setLearntFrom("FromXML");
				id.setLocal_Node_Info(origin);
				id.setRemote_Node_Info(destination);
			}
		}

	}	

	public void notifyAlgorithms( int lambdaIni,int lambdaEnd){	
		LinkedList<Object>  ipListScr = new  LinkedList<Object> ();
		LinkedList<Object>  ipListDst = new  LinkedList<Object> ();
		Set<IntraDomainEdge> it =this.networkGraph.edgeSet();
		int numLabels=0;
		for (IntraDomainEdge edge:it){	
			numLabels=edge.TE_info.getAvailableLabels().getLabelSet().getNumLabels();
			for (int i=0;i<lambdaIni;i++){		
				ipListScr.add(edge.getSource());
				ipListDst.add(edge.getTarget());
				for (int j=0;j<registeredAlgorithms.size();++j){
					registeredAlgorithms.get(j).notifyWavelengthReservation(ipListScr, ipListDst, i);
				}
				for (int j=0;j<registeredAlgorithmssson.size();++j){
					registeredAlgorithmssson.get(j).notifyWavelengthReservation(ipListScr, ipListDst, i);
				}
				this.notifyWavelengthReservation(ipListScr,ipListDst,i,false);
				ipListScr.remove();
				ipListDst.remove();
			}

			for (int i=lambdaEnd;i<numLabels;i++){				
				ipListScr.add(edge.getSource());
				ipListDst.add(edge.getTarget());
				for (int j=0;j<registeredAlgorithms.size();++j){
					registeredAlgorithms.get(j).notifyWavelengthReservation(ipListScr, ipListDst, i);
				}
				for (int j=0;j<registeredAlgorithmssson.size();++j){
					registeredAlgorithmssson.get(j).notifyWavelengthReservation(ipListScr, ipListDst, i);
				}
				this.notifyWavelengthReservation(ipListScr,ipListDst,i,false);
				ipListScr.remove();
				ipListDst.remove();
			}
		}
	}
	public boolean belongsToDomain(Object addr){
		int i;
		byte[] addrbytes=((Inet4Address)addr).getAddress();
		//log.info("Entramos en belong to domain: "+ reachabilityEntry.getMask());
		//UtilsFunctions.printByte(reachabilityEntry.getMask(), "Entramos en belong to domain: ", log);
		for (i=0;i<4;++i){
			addrbytes[i]=(byte) (addrbytes[i]&(reachabilityEntry.getMask())[i]);
		}
		//UtilsFunctions.printByte(addrbytes, "addrbytes", log);
		//UtilsFunctions.printByte(reachabilityEntry.getAggregatedIPRange().getAddress(), "reachabilityEntry.getAggregatedIPRange", log);
		//log.info("addrbytes "+addrbytes+" reachabilityEntry.getAggregatedIPRange().getAddress()"+reachabilityEntry.getAggregatedIPRange().getAddress());
		log.info("Belongs to domain retunrs: "+Arrays.equals(addrbytes,reachabilityEntry.getAggregatedIPRange().getAddress()));
		return Arrays.equals(addrbytes,reachabilityEntry.getAggregatedIPRange().getAddress());

	}


	public LinkedList<IntraDomainEdge> getIntraDomainEdges() {
		return intraDomainEdges;
	}

	public void setIntraDomainEdges(LinkedList<IntraDomainEdge> intraDomainEdges) {
		this.intraDomainEdges = intraDomainEdges;
	}

	public ReachabilityEntry getReachabilityEntry() {
		return reachabilityEntry;
	}

	public void setReachabilityEntry(ReachabilityEntry reachabilityEntry) {
		this.reachabilityEntry = reachabilityEntry;
	}

	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getNetworkGraph() {
		return networkGraph;
	}

	public void setNetworkGraph(
			SimpleDirectedWeightedGraph<Object, IntraDomainEdge> networkGraph) {
		this.networkGraph = networkGraph;
	}

	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		return interDomainLinks;
	}
	public void setInterDomainLinks(LinkedList<InterDomainEdge> interDomainLinks) {
		this.interDomainLinks = interDomainLinks;
	}
	
	
	//	@Override
	//	public DirectedWeightedMultigraph<Object, InterDomainEdge> getDuplicatedMDNetworkGraph() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}


	/**
	 * Return true if scr and dst are linked by an InterDomainLink
	 */
	public InterDomainEdge getInterdomainLink(Object src, Object dst){

		int size = interDomainLinks.size();
		InterDomainEdge edge= new InterDomainEdge(src,dst);
		for (int i=0;i<size;i++){    		
			//por pantalla  
			InterDomainEdge edge_i = interDomainLinks.get(i);
			if (edge_i.equals(edge)){
				return edge_i;
			}
		}
		return null;
	}

	public String printTopology(){
		String topoString;
		Set<Object> vetexSet= networkGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="Nodes: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"Node Information Table::: \r\n"+NodeTable.toString()+"\r\n";
		Set<IntraDomainEdge> edgeSet= networkGraph.edgeSet();
		if (edgeSet != null){
			Iterator <IntraDomainEdge> edgeIterator=edgeSet.iterator();
			topoString=topoString+"Intradomain Link list: \r\n";
			while (edgeIterator.hasNext()){
				IntraDomainEdge edge= edgeIterator.next();
				topoString=topoString+"\t"+edge.toString()+"\n";
			}
		}
		if (interDomainLinks != null)
			topoString=topoString+printInterDomainLinks();
		return topoString;
	}

	public String printInterDomainLinks(){
		String topoString="";

		int size = interDomainLinks.size();
		topoString="Interdomain Link list: \r\n";
		for (int i=0;i<size;i++){
			//por pantalla  
			InterDomainEdge edge = interDomainLinks.get(i);
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		return topoString;
	}

	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notifyWavelengthReservationWLAN(LinkedList<Object> sourceVertexList,LinkedList<Object> targetVertexList,LinkedList<Integer> wlans, boolean bidirectional) 
	{
		TEDBlock.lock();
		try {
			for (int i=0;i<sourceVertexList.size();++i){		
				IntraDomainEdge edge=networkGraph.getEdge(sourceVertexList.get(i), targetVertexList.get(i));
				edge.getTE_info().setWavelengthReserved(wlans.get(i));
				log.info("Reservo: "+sourceVertexList.get(i).toString() + "-"+ targetVertexList.get(i).toString() +" wavelength: "+wlans.get(i)+" bidirectional"+bidirectional);
				if (bidirectional == true){
					edge=networkGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
					edge.getTE_info().setWavelengthReserved(wlans.get(i));
					//log.info(""+edge.toString());
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthReservation(sourceVertexList, targetVertexList, wlans.get(i));
			if (bidirectional == true){
				registeredAlgorithms.get(i).notifyWavelengthReservation(targetVertexList, sourceVertexList, wlans.get(i));
			}
		}

	}

	@Override
	public void notifyWavelengthReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional){
		TEDBlock.lock();
		try {
			for (int i=0;i<sourceVertexList.size();++i){		
				IntraDomainEdge edge=networkGraph.getEdge(sourceVertexList.get(i), targetVertexList.get(i));
				edge.getTE_info().setWavelengthReserved(wavelength);
				log.info("Reservo: "+sourceVertexList.get(i).toString() + "-"+ targetVertexList.get(i).toString() +" wavelength: "+wavelength+" bidirectional"+bidirectional);
				if (bidirectional == true){
					edge=networkGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
					edge.getTE_info().setWavelengthReserved(wavelength);
					//log.info(""+edge.toString());
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthReservation(sourceVertexList, targetVertexList, wavelength);
			if (bidirectional == true){
				registeredAlgorithms.get(i).notifyWavelengthReservation(targetVertexList, sourceVertexList, wavelength);
			}
		}
	}

	public void notifyWavelengthReservationSSON(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional, int m){
		TEDBlock.lock();
		try {
			for (int j=0;j<2*m;j++){
				for (int i=0;i<sourceVertexList.size();++i){		
					IntraDomainEdge edge=networkGraph.getEdge(sourceVertexList.get(i), targetVertexList.get(i));
					//log.info("sourceVertexList.size()"+sourceVertexList.size());
					edge.getTE_info().setWavelengthReserved(wavelength-m+j);
					//log.info("Reserving in TEDB: "+edge.toString());
					if (bidirectional == true){
						edge=networkGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
						edge.getTE_info().setWavelengthReserved(wavelength-m+j);
						//log.info("Reserving in TEDB: "+edge.toString());
					}
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithmssson.size();++i){
			(registeredAlgorithmssson.get(i)).notifyWavelengthReservationSSON(sourceVertexList, targetVertexList, wavelength, m);
			if (bidirectional == true){
				(registeredAlgorithmssson.get(i)).notifyWavelengthReservationSSON(targetVertexList, sourceVertexList, wavelength, m);
			}
		}
	}

	@Override
	public void notifyWavelengthEndReservationSSON(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional, int m){
		// TODO Auto-generated method stub
		//Delete the resource reservation
		TEDBlock.lock();
		try {
			for (int j=0;j<2*m;j++){
				for (int i=0;i<sourceVertexList.size();++i){
					//			SimpleDirectedWeightedGraph<Object,FiberLinkEdge> graph= ted.getNetworkGraph();
					IntraDomainEdge edge=networkGraph.getEdge(sourceVertexList.get(i),targetVertexList.get(i) );
					edge.getTE_info().setWavelengthUnReserved(wavelength-m+j);
					//log.info("Derreserving in TEDB: "+edge.toString());
					if (bidirectional == true)
					{
						edge=networkGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
						edge.getTE_info().setWavelengthUnReserved(wavelength-m+j);
						//log.info("Derreserving in TEDB: "+edge.toString());
					}
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithmssson.size();++i){
			(registeredAlgorithmssson.get(i)).notifyWavelengthEndReservationSSON(sourceVertexList, targetVertexList, wavelength, m);
			if (bidirectional == true){
				(registeredAlgorithmssson.get(i)).notifyWavelengthEndReservationSSON(targetVertexList, sourceVertexList, wavelength, m);
			}
		}
		//FIXME:TEMPORAL!!!!!!
		//requestDispatcher.moveRetryQueueToComputingRequestQueue();
		//Call request dispatcher to pass requests to queue?
	}

	@Override
	public void notifyWavelengthEndReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional){
		// TODO Auto-generated method stub
		//Delete the resource reservation
		TEDBlock.lock();
		try {
			for (int i=0;i<sourceVertexList.size();++i){
				//			SimpleDirectedWeightedGraph<Object,FiberLinkEdge> graph= ted.getNetworkGraph();
				IntraDomainEdge edge=networkGraph.getEdge(sourceVertexList.get(i),targetVertexList.get(i) );
				edge.getTE_info().setWavelengthUnReserved(wavelength);
				//log.info(""+edge.toString());
				if (bidirectional == true)
				{
					edge=networkGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
					edge.getTE_info().setWavelengthUnReserved(wavelength);
					//log.info(""+edge.toString());
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthEndReservation(sourceVertexList, targetVertexList, wavelength);
			if (bidirectional == true){
				registeredAlgorithms.get(i).notifyWavelengthEndReservation(targetVertexList, sourceVertexList, wavelength);
			}
		}
		//FIXME:TEMPORAL!!!!!!
		//requestDispatcher.moveRetryQueueToComputingRequestQueue();
		//Call request dispatcher to pass requests to queue?
	}

	@Override
	public boolean containsVertex(Object vertex) {
		return networkGraph.containsVertex(vertex);
	}

	public Hashtable<Object, Node_Info> getNodeTable() {
		return NodeTable;
	}

	public void setNodeTable(Hashtable<Object, Node_Info> nodeTable) {
		NodeTable = nodeTable;
	}

	public boolean isMultidomain() {
		return multidomain;
	}

	public void setMultidomain(boolean multidomain) {
		this.multidomain = multidomain;
	}

	public void registerSSON (SSONListener algo){
		registeredAlgorithmssson.add(algo);		
	}

	public void register (TEDListener algo){
		registeredAlgorithms.add(algo);		
	}

	@Override
	public void notifyWavelengthChange(Object localInterfaceIPAddress, Object remoteInterfaceIPAddress,	BitmapLabelSet previousBitmapLabelSet, BitmapLabelSet newBitmapLabelSet) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthStatusChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
		}
		if (registeredAlgorithms.isEmpty()){
			for (int i=0;i<registeredAlgorithmssson.size();++i){
				registeredAlgorithmssson.get(i).notifyWavelengthStatusChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
			}
		}
	}

	@Override
	public void notifyNewVertex(Object vertex) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyNewVertex(vertex);
		}	
	}

	@Override
	public void notifyNewEdge(Object source, Object destination) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyNewEdge(source,destination);
		}	
	}

	@Override
	public WSONInformation getWSONinfo() {
		return WSONinfo;
	}

	@Override
	public SSONInformation getSSONinfo() {
		return SSONinfo;
	}

	@Override
	public void clearAllReservations() {
		if (WSONinfo!=null){
			TEDBlock.lock();
			try{	
				Set<IntraDomainEdge> edgeSet= networkGraph.edgeSet();
				Iterator <IntraDomainEdge> edgeIterator=edgeSet.iterator();
				while (edgeIterator.hasNext()){
					IntraDomainEdge edge= edgeIterator.next();
					edge.TE_info.setAllWavelengtshUnReserved();
				}
			}finally{
				TEDBlock.unlock();
			}
			for (int i=0;i<registeredAlgorithms.size();++i){
				registeredAlgorithms.get(i).notifyTEDBFullUpdate();
			}	
		}
	}

	public Lock getTEDBlock() {
		return TEDBlock;
	}

	public void setTEDBlock(Lock tEDBlock) {
		TEDBlock = tEDBlock;
	}

	@Override
	public void notifyNewEdgeIP(Object source, Object destination,
			TE_Information informationTEDB) {
		// TODO Auto-generated method stub
	}

	public void setWSONinfo(WSONInformation wSONinfo) {
		WSONinfo = wSONinfo;
	}

	public void setSSONinfo(SSONInformation sSONinfo) {
		SSONinfo = sSONinfo;
	}

	
	public String printBaseTopology(){
		String topoString;
		Set<Object> vetexSet= networkGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="NodesFEO: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"Intradomain Link list: \r\n";
		Set<IntraDomainEdge> edgeSet= networkGraph.edgeSet();
		Iterator <IntraDomainEdge> edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			IntraDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}		
		return topoString;
	}

	@Override
	public Inet4Address getDomainID() {
		// TODO Auto-generated method stub
		return domainID;
	}

	@Override
	public Set<IntraDomainEdge> getIntraDomainLinks() {
		// TODO Auto-generated method stub
		//FIXME
		return null;
	}
}