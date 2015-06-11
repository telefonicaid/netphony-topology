package tid.pce.tedb;

import java.net.Inet4Address;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

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
	
	private LinkedList<InterDomainEdge> interDomainLinks;  
		
	public SimpleTEDB simple_ted;
	
	private Logger log;
	
	private boolean addBidirectional;
	
	/**
	 * Table with IP address/prefix --> domain
	 */
	LinkedList<ReachabilityEntry> reachability;
	
	public MDTEDB(){
		log=Logger.getLogger("PCEServer");
		networkDomainGraph=new DirectedWeightedMultigraph<Object,InterDomainEdge> (InterDomainEdge.class);
		addBidirectional=true;//FIXME: ESTO ES UN APA�O TEMPORAL
		interDomainLinks = new LinkedList<InterDomainEdge>();
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
	
	public void initializeFromFileInterDomainLinks(String file){
		//Cargamos los interdomain Links en una Lista
		interDomainLinks=FileTEDBUpdater.readInterDomainLinks(file);
		
		//FIXME: Faltaría cargar el grafo
		//Ahora tenemos que cargar el grafo
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


	/**
	 * FOR THE FULL UMBRELLA PCE!!!!!!!!
	 */
	public SimpleDirectedWeightedGraph<Object, IntraDomainEdge> getDuplicatedNetworkGraph() {
		// TODO Auto-generated method stub
		return networkGraph;
	}
	
	public synchronized void addInterdomainLink( Object localDomainID, Object localRouterASBR, long localRouterASBRIf, Object remoteDomainID, Object remoteRouterASBR, long remoteRouterASBRIf, TE_Information te_info){

		if (!networkDomainGraph.containsVertex(localDomainID)){
			networkDomainGraph.addVertex(localDomainID);
			log.info("Vertex (domain) "+localDomainID+" added");
		}
		if (!networkDomainGraph.containsVertex(remoteDomainID)){
			networkDomainGraph.addVertex(remoteDomainID);
			log.info("Vertex (domain) "+remoteDomainID+" added");
		}
		log.info("Looking to add "+localRouterASBR+":"+localRouterASBRIf+" ("+localDomainID+") -->"+remoteRouterASBR+":"+remoteRouterASBRIf+" ("+remoteDomainID+")");
		Set<InterDomainEdge> edgeset= networkDomainGraph.edgesOf(localDomainID);
		Iterator <InterDomainEdge> iterador=edgeset.iterator();
		boolean edgeFound=false;
		if (edgeset.size() == 0)
			log.info("Edge set size = 0");
		while (iterador.hasNext()){
			InterDomainEdge interDomainEdge=iterador.next();
			log.finest("existing edge: "+interDomainEdge.toString());
			if (interDomainEdge.getSrc_router_id().equals(localRouterASBR)){
				log.finest("Local router is the same!!!");
				if (interDomainEdge.getDst_router_id().equals(remoteRouterASBR)){
					log.finest("Destination router is the same!!!");
					edgeFound=true;
				}
				else {
					log.finest("Destination router is NOT the same!!!");
				}
			}else {
				log.finest("Local router is NOT the same!!!");
			}			
		}
		
		if (edgeFound==false) {
			InterDomainEdge newInterDomainEdge =new InterDomainEdge();
			newInterDomainEdge.setSrc_router_id(localRouterASBR);
			newInterDomainEdge.setDst_router_id(remoteRouterASBR);
			newInterDomainEdge.setSrc_if_id(localRouterASBRIf);
			newInterDomainEdge.setDst_if_id(remoteRouterASBRIf);
			if (te_info != null)
				newInterDomainEdge.setTE_info(te_info);
			networkDomainGraph.addEdge(localDomainID, remoteDomainID, newInterDomainEdge);
			log.info("Edge between "+localDomainID+" and "+remoteDomainID+" added");
			//InterDomainEdge newInterDomainEdge2 =new InterDomainEdge();
			//newInterDomainEdge2.setSrc_router_id(remoteRouterASBR);
			//newInterDomainEdge2.setDst_router_id(localRouterASBR);
			//newInterDomainEdge.setSrc_if_id(remoteRouterASBRIf);
			//newInterDomainEdge.setDst_if_id(localRouterASBRIf);
			//networkDomainGraph.addEdge(remoteDomainID, localDomainID, newInterDomainEdge2);
			//log.info("Edge between "+remoteDomainID+" and "+localDomainID+" added");

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
	
	public String printMD2Topology(){
		String topoString;
		Set<Object> vetexSet= networkDomainGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="Domains: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
		}
		topoString=topoString+"Interdomain list: \r\n";
		Iterator <InterDomainEdge> edgeIterator=interDomainLinks.iterator();
		while (edgeIterator.hasNext()){
			InterDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		
		return topoString;
	}
	
	//Check resources SSON and WSON
	public boolean CheckLocalResources(long ifID, Object ip){
		Iterator<InterDomainEdge> iteredges = interDomainLinks.iterator();
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

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		// TODO Auto-generated method stub
		return null;
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
