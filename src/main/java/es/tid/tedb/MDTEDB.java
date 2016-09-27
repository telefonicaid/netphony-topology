package es.tid.tedb;

import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Base de datos de ingenieria de trafico
 * CLASE DE PRUEBA REESTRUCTURAR DESPUES!!!!!!!!!!
 * @author ogondio
 *
 */
public class MDTEDB implements MultiDomainTEDB {
	private long graphId;
	private DirectedWeightedMultigraph<Object,InterDomainEdge> networkDomainGraph;
	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> networkGraph;
	
	//private LinkedList<InterDomainEdge> interDomainLinks;  
		
	public SimpleTEDB simple_ted;
	
	private Logger log;
	
	private boolean addBidirectional;
	
	/**
	 * Table with IP address/prefix --> domain
	 */
	LinkedList<ReachabilityEntry> reachability;
	
	public MDTEDB(){
		log=LoggerFactory.getLogger("BGP4Peer");
		networkDomainGraph=new DirectedWeightedMultigraph<Object,InterDomainEdge> (InterDomainEdge.class);
		addBidirectional=true;//FIXME: ESTO ES UN APA�O TEMPORAL
		reachability=new LinkedList<ReachabilityEntry>();
		//interDomainLinks = new LinkedList<InterDomainEdge>();
	}
	
	public DirectedWeightedMultigraph<Object,InterDomainEdge> getDuplicatedMDNetworkGraph(){
		
		DirectedWeightedMultigraph<Object,InterDomainEdge> graphCopy= (DirectedWeightedMultigraph<Object, InterDomainEdge>) networkDomainGraph.clone();
		return graphCopy;
	}
	
	public DirectedWeightedMultigraph<Object, InterDomainEdge> getNetworkDomainGraph() {
		return networkDomainGraph;
	}

	public void setNetworkDomainGraph(
			DirectedWeightedMultigraph<Object, InterDomainEdge> networkDomainGraph) {
		this.networkDomainGraph = networkDomainGraph;
	}

	public void initializeFromFile(String file){
		networkDomainGraph=FileTEDBUpdater.readMDNetwork(file);		
	}

	public void initializeFromFile(String file, String learntFrom){
		networkDomainGraph=FileTEDBUpdater.readMDNetwork(file, learntFrom);
	}
	
	public void initializeFromFileInterDomainLinks(String file){
	}
	
	public void initializeFullTEDFromFile(String file){
		networkGraph=FileTEDBUpdater.readNetwork(file);		
	}
	
	public long getGraphId() {
		return graphId;
	}
	public void setGraphId(long graphId) {
		this.graphId = graphId;
	}


	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getDuplicatedNetworkGraph() {
		return networkGraph;
	}
	
	public synchronized void addInterdomainLink( Object localDomainID, Object localRouterASBR, long localRouterASBRIf, Object remoteDomainID, Object remoteRouterASBR, long remoteRouterASBRIf, TE_Information te_info){

		if (!networkDomainGraph.containsVertex(localDomainID)){
			networkDomainGraph.addVertex(localDomainID);
			log.debug("Vertex (domain) "+localDomainID+" added");
		}
		if (!networkDomainGraph.containsVertex(remoteDomainID)){
			networkDomainGraph.addVertex(remoteDomainID);
			log.debug("Vertex (domain) "+remoteDomainID+" added");
		}
		log.debug("Looking to add "+localRouterASBR+":"+localRouterASBRIf+" ("+localDomainID+") -->"+remoteRouterASBR+":"+remoteRouterASBRIf+" ("+remoteDomainID+")");
		Set<InterDomainEdge> edgeset= networkDomainGraph.edgesOf(localDomainID);
		Iterator <InterDomainEdge> iterador=edgeset.iterator();
		boolean edgeFound=false;
		InterDomainEdge interDomainEdgeFound=null;
		if (edgeset.size() == 0)
			log.debug("Edge set size = 0");
		while (iterador.hasNext()){
			InterDomainEdge interDomainEdge=iterador.next();
			log.debug("existing edge: "+interDomainEdge.toString());
			if (interDomainEdge.getSrc_router_id().equals(localRouterASBR)){
				log.debug("Local router is the same!!!");
				if (interDomainEdge.getDst_router_id().equals(remoteRouterASBR)){
					log.debug("Destination router is the same!!!");
					edgeFound=true;
					interDomainEdgeFound=interDomainEdge;
				}
				else {
					log.debug("Destination router is NOT the same!!!");
				}
			}else {
				log.debug("Local router is NOT the same!!!");
			}			
		}
		
		if (edgeFound==false) {
			InterDomainEdge newInterDomainEdge =new InterDomainEdge();
			newInterDomainEdge.setSrc_router_id(localRouterASBR);
			newInterDomainEdge.setDst_router_id(remoteRouterASBR);
			newInterDomainEdge.setSrc_if_id(localRouterASBRIf);
			newInterDomainEdge.setDst_if_id(remoteRouterASBRIf);
			newInterDomainEdge.setDomain_dst_router(remoteDomainID);
			newInterDomainEdge.setDomain_src_router(localDomainID);
			if (te_info != null)
				newInterDomainEdge.setTE_info(te_info);
			networkDomainGraph.addEdge(localDomainID, remoteDomainID, newInterDomainEdge);
			log.info("New interdomain edge between "+localDomainID+" and "+remoteDomainID+" received");

		}else {
			
			if (te_info != null){
				//FIXME: Update of TE info to be optimized
				log.debug("TE_info updated");
				interDomainEdgeFound.setTE_info(te_info);
			}
			
			
		}
	}

	
	public void addReachabilityIPv4(Inet4Address domainId,Inet4Address aggregatedIPRange,int prefix){
		ReachabilityEntry ra=new ReachabilityEntry();
		ra.setAggregatedIPRange(aggregatedIPRange);
		long resta=((long)0x1<<prefix)-1;
		long maskLong=resta<<(32-prefix);
		byte[] mask=new byte[4];
		mask[0]=(byte)(maskLong>>>24 & 0xFF);
		mask[1]=(byte)(maskLong>>>16 & 0xFF);
		mask[2]=(byte)(maskLong>>>8 & 0xFF);
		mask[3]=(byte)(maskLong& 0xFF);
		ra.setMask(mask);
		ra.setDomainId(domainId);
		ra.setPrefix(prefix);
		if (!(reachability.contains(ra))){
			reachability.add(ra);
		}	
		return;
	}
	
	
	public String printMDTopology(){
		String topoString;
		Set<Object> vetexSet= networkDomainGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="Domains: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"Interdomain list: \r\n";
		Set<InterDomainEdge> edgeSet= networkDomainGraph.edgeSet();
		Iterator <InterDomainEdge> edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			InterDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		
		return topoString;
	}
	
//	public String printMD2Topology(){
//		String topoString;
//		Set<Object> vetexSet= networkDomainGraph.vertexSet();
//		Iterator <Object> vertexIterator=vetexSet.iterator();
//		topoString="Domains: \r\n";
//		while (vertexIterator.hasNext()){
//			Object vertex= vertexIterator.next();
//			topoString=topoString+"\t"+vertex.toString()+"\r\n";
//		}
//		topoString=topoString+"Interdomain list: \r\n";
//		Iterator <InterDomainEdge> edgeIterator=interDomainLinks.iterator();
//		while (edgeIterator.hasNext()){
//			InterDomainEdge edge= edgeIterator.next();
//			topoString=topoString+"\t"+edge.toString()+"\r\n";
//		}
//		
//		return topoString;
//	}
	
	//Check resources SSON and WSON
	public boolean CheckLocalResources(long ifID, Object ip){
		Iterator<InterDomainEdge> iteredges = networkDomainGraph.edgeSet().iterator();								
		InterDomainEdge link;
		while (iteredges.hasNext())
		{
			link = iteredges.next();
			if ((link.getSrc_if_id()==(ifID)))
			{
				log.info("InterDomain Link Found to "+link.getDst_router_id().toString());
				return true;
			}
		}
		return false;		 
	}
	
	@Override
	public String printTopology() {
		// TODO Auto-generated method stub
		return printMDTopology();
	}

	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		return new LinkedList<InterDomainEdge>(networkDomainGraph.edgeSet());
	}

	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return false;
	}

	public SimpleTEDB getSimple_ted() {
		return simple_ted;
	}

	public void setSimple_ted(SimpleTEDB simple_ted) {
		this.simple_ted = simple_ted;
	}

	public LinkedList<ReachabilityEntry> getReachability() {
		return reachability;
	}

	public void setReachability(LinkedList<ReachabilityEntry> reachability) {
		this.reachability = reachability;
	}
	
	
}
