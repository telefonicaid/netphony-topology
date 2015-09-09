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

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;


public class MultiLayerTEDB implements DomainTEDB {
	
	private ArrayList<TEDListener> registeredAlgorithms;
	/**
	 * Graph of the Upper Layer Network
	 */
	/**
	 * 
	 */
	private SimpleDirectedWeightedGraph<Object,IntraDomainEdge> upperLayerGraph;

	/**
	 * Graph of the Upper Layer Network
	 */
	private SimpleDirectedWeightedGraph<Object,IntraDomainEdge> lowerLayerGraph;

	/**
	 * InterLayer Graph
	 */
	private SimpleDirectedWeightedGraph<Object,IntraDomainEdge> interLayerGraph;
	/**
	 * Reachability information
	 */
	private ReachabilityEntry reachabilityEntry;

	/**
	 * WSON Information of the lower Layer
	 */
	private WSONInformation WSONinfo=null;
	
	private Lock TEDBlock;
	

	/**
	 * List of interdomain Links
	 */
	private LinkedList<InterDomainEdge> interDomainLinks; 
	
	private Hashtable<Object,Object> RelationNodesInterlayer;
	
	


	public MultiLayerTEDB(){
		registeredAlgorithms= new ArrayList<TEDListener>(); 
		TEDBlock=new ReentrantLock();
	}
	
	
	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getUpperLayerGraph() {
		return upperLayerGraph;
	}

	public void setUpperLayerGraph(
			SimpleDirectedWeightedGraph<Object, IntraDomainEdge> upperLayerGraph) {
		this.upperLayerGraph = upperLayerGraph;
	}

	
	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getLowerLayerGraph() {
		return lowerLayerGraph;
	}

	public void setLowerLayerGraph(
			SimpleDirectedWeightedGraph<Object, IntraDomainEdge> lowerLayerGraph) {
		this.lowerLayerGraph = lowerLayerGraph;
	}

	
	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getInterLayerGraph() {
		return interLayerGraph;
	}

	public void setInterLayerGraph(
			SimpleDirectedWeightedGraph<Object, IntraDomainEdge> interLayerGraph) {
		this.interLayerGraph = interLayerGraph;
	}



	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> getDuplicatedUpperLayerkGraph(){
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graphCopy;
		TEDBlock.lock();
		try{
			graphCopy= (SimpleDirectedWeightedGraph<Object, IntraDomainEdge>) upperLayerGraph.clone();
		} finally{
			TEDBlock.unlock();
		}
		return graphCopy;
	}
	public Hashtable<Object, Object> getRelationNodesInterlayer() {
		return RelationNodesInterlayer;
	}
	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> getDuplicatedLowerLayerkGraph(){
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graphCopy;
		TEDBlock.lock();
		try{
			graphCopy= (SimpleDirectedWeightedGraph<Object, IntraDomainEdge>) lowerLayerGraph.clone();
		} finally{
			TEDBlock.unlock();
		}
		return graphCopy;
	}
	
	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> getDuplicatedInterLayerGraph(){
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graphCopy;
		TEDBlock.lock();
		try{
			graphCopy= (SimpleDirectedWeightedGraph<Object, IntraDomainEdge>) interLayerGraph.clone();
		} finally{
			TEDBlock.unlock();
		}
		return graphCopy;
	}

	public void initializeFromFile(String file) {
		upperLayerGraph=FileTEDBUpdater.readNetwork(file, "mpls");	
		lowerLayerGraph=FileTEDBUpdater.readNetwork(file, "wson");
		interLayerGraph=FileTEDBUpdater.readNetwork(file, "interlayer");
		WSONinfo = FileTEDBUpdater.getWSONInformation(file, "wson");
		interDomainLinks = FileTEDBUpdater.readInterDomainLinks(file);	
		
		reachabilityEntry = new ReachabilityEntry();
		//domainReachabilityIPv4Prefix=new byte[4];
		FileTEDBUpdater.getDomainReachabilityFromFile(file,reachabilityEntry,"mpls");
	}

	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String printTopology() {
		String topoString;
		Set<Object> vetexSet= upperLayerGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="MPLS Nodes: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"MPLS Link list: \r\n";
		Set<IntraDomainEdge> edgeSet= upperLayerGraph.edgeSet();
		Iterator <IntraDomainEdge> edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			IntraDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		vetexSet= lowerLayerGraph.vertexSet();
		vertexIterator=vetexSet.iterator();
		topoString="GMPLS Nodes: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"gmpls Link list: \r\n";
		edgeSet= lowerLayerGraph.edgeSet();
		edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			IntraDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		topoString=topoString+"InterLayer list: \r\n";
		edgeSet= interLayerGraph.edgeSet();
		edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			IntraDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		
		topoString=topoString+printInterDomainLinks();
		return topoString;
	}

	@Override
	public boolean belongsToDomain(Object addr) {
		int i;
		byte[] addrbytes= ((Inet4Address)addr).getAddress();
		for (i=0;i<4;++i){
			addrbytes[i]=(byte) (addrbytes[i]&(reachabilityEntry.getMask())[i]);
		}
		return Arrays.equals(addrbytes,reachabilityEntry.getAggregatedIPRange().getAddress());
	}

	public ReachabilityEntry getReachabilityEntry() {
		return reachabilityEntry;
	}

	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		return interDomainLinks;
	}

	@Override
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

	public boolean containsVertex(Object vertex) {
		return upperLayerGraph.containsVertex(vertex);

	}

	public WSONInformation getWSONinfo() {
		return WSONinfo;
	}

	@Override
	public void notifyWavelengthReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional){
		TEDBlock.lock();
		try {
			for (int i=0;i<sourceVertexList.size();++i){		
				IntraDomainEdge edge=lowerLayerGraph.getEdge(sourceVertexList.get(i), targetVertexList.get(i));
				
				edge.getTE_info().setWavelengthReserved(wavelength);
				if (bidirectional == true){
					edge=lowerLayerGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
					edge.getTE_info().setWavelengthReserved(wavelength);
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

	@Override
	public void notifyWavelengthEndReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional){
		// TODO Auto-generated method stub
		//Delete the resource reservation
		TEDBlock.lock();
		try {
			for (int i=0;i<sourceVertexList.size();++i){
				//			SimpleDirectedWeightedGraph<Object,FiberLinkEdge> graph= ted.getNetworkGraph();
				IntraDomainEdge edge=lowerLayerGraph.getEdge(sourceVertexList.get(i),targetVertexList.get(i) );
				edge.getTE_info().setWavelengthUnReserved(wavelength);
				if (bidirectional == true)
				{
					edge=lowerLayerGraph.getEdge(targetVertexList.get(i), sourceVertexList.get(i));
					edge.getTE_info().setWavelengthUnReserved(wavelength);
				}
			}
		}finally{
			TEDBlock.unlock();
		}
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthEndReservation(sourceVertexList, targetVertexList, wavelength);
			if (bidirectional == true)
			{
				registeredAlgorithms.get(i).notifyWavelengthEndReservation(targetVertexList, sourceVertexList, wavelength);
			}
		}
		//FIXME:TEMPORAL!!!!!!
		//requestDispatcher.moveRetryQueueToComputingRequestQueue();
		//Call request dispatcher to pass requests to queue?
	}

	@Override
	public void notifyWavelengthChange(Object localInterfaceIPAddress, Object remoteInterfaceIPAddress,	BitmapLabelSet previousBitmapLabelSet, BitmapLabelSet newBitmapLabelSet) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notifyWavelengthStatusChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
		}
	}

	@Override
	public void register(TEDListener compAlgPreComp) {
		registeredAlgorithms.add(compAlgPreComp);		
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
	public void clearAllReservations() {
		if (WSONinfo!=null){
			TEDBlock.lock();
			try{	
				Set<IntraDomainEdge> edgeSet= lowerLayerGraph.edgeSet();
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

	@Override
	public void notifyNewEdgeIP(Object source, Object destination, TE_Information informationTEDB) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			
			registeredAlgorithms.get(i).notifyNewEdgeIP(source,destination, informationTEDB);
		}	
	}


	public void notificationEdgeIP_AuxGraph(Object src, Object dst, TE_Information informationTEDB) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notificationEdgeIP_AuxGraph(src,dst, informationTEDB);
		}	
		
	}
	public void notificationEdgeOPTICAL_AuxGraph(Object src, Object dst, int lambda) {
		for (int i=0;i<registeredAlgorithms.size();++i){
			registeredAlgorithms.get(i).notificationEdgeOPTICAL_AuxGraph(src, dst, lambda);
		}	
	}
	@Override
	public void notifyWavelengthEndReservationSSON(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyWavelengthReservationSSON(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		// TODO Auto-generated method stub
	}

	@Override
	public SSONInformation getSSONinfo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<IntraDomainEdge> getIntraDomainLinks() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void notifyWavelengthReservationWLAN(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList,
			LinkedList<Integer> wlans, boolean bidirectional) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void registerSSON(SSONListener compAlgPreComp) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Inet4Address getDomainID() {
		// TODO Auto-generated method stub
		return null;
	}
}
