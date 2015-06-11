package tid.pce.tedb;

import java.net.Inet4Address;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import es.tid.pce.pcep.objects.tlvs.subtlvs.CostSubTLV;

/**
 * Base de datos de ingenieria de trafico con IT
 * CLASE DE PRUEBA REESTRUCTURAR DESPUES!!!!!!!!!!
 * 
 * Crear una intefaz que implemente la interfaz TEDB y que sea implementada por ITMDTEDB y MDTDEB. Deber�
 * incluir el m�todo addInterdomainLink
 * 
 * 
 * @author Alejandro Tovar
 *
 */
public class ITMDTEDB implements MultiDomainTEDB {

	private long graphId;
	private DirectedWeightedMultigraph<Object,InterDomainEdge> networkDomainGraph;
	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> networkGraph;
	private Hashtable <Object,Object> it_site_id_domain_ed;
	private Hashtable <Object,Object> resource_id_domain_ed;
	private Hashtable <Object,Object> resource_id_it_site_ed;
	
	private Logger log;
	
	private boolean addBidirectional;
	private String File; 
	
	
	public ITMDTEDB(){
		log=Logger.getLogger("PCEServer");
		networkDomainGraph=new DirectedWeightedMultigraph<Object,InterDomainEdge> (InterDomainEdge.class);
		it_site_id_domain_ed=new Hashtable <Object,Object>();
		resource_id_domain_ed=new Hashtable <Object,Object>();
		addBidirectional=true;//FIXME: ESTO ES UN APA�O TEMPORAL
		//Estoy viendo el FIXME este tres años despues y no ha sido tan temporal al final
	}
	
	public DirectedWeightedMultigraph<Object,InterDomainEdge> getDuplicatedMDNetworkGraph(){
		
		DirectedWeightedMultigraph<Object,InterDomainEdge> graphCopy= (DirectedWeightedMultigraph<Object, InterDomainEdge>) networkDomainGraph.clone();
		return graphCopy;
	}
	
	public void initializeFromFile(String file){
		networkDomainGraph=FileTEDBUpdater.readITMDNetwork(file);
//		File= file;
		it_site_id_domain_ed=FileTEDBUpdater.getITSites(file);
		resource_id_domain_ed=FileTEDBUpdater.getResource(file);
	}
	
	public void initializeFullTEDFromFile(String file){
		networkGraph=FileTEDBUpdater.readITNetwork(file);		
//		it_site_id_domain_ed=FileTEDBUpdater.getITSites(file);
//		resource_id_domain_ed=FileTEDBUpdater.getResource(file);
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
	
	public synchronized void addInterdomainLink( Object localDomainID, Object localRouterASBR, long localRouterASBRIf, Object remoteDomainID, Object remoteRouterASBR, long remoteRouterASBRIf, TE_Information te_info ){
		if (!networkDomainGraph.containsVertex(localDomainID)){
			networkDomainGraph.addVertex(localDomainID);
			log.finest("Vertex (domain) "+localDomainID+" added");
		}
		if (!networkDomainGraph.containsVertex(remoteDomainID)){
			networkDomainGraph.addVertex(remoteDomainID);
			log.finest("Vertex (domain) "+remoteDomainID+" added");
		}
		log.finest("Looking to add "+localRouterASBR+":"+localRouterASBRIf+" ("+localDomainID+") -->"+remoteRouterASBR+":"+remoteRouterASBRIf+" ("+remoteDomainID+")");
		Set<InterDomainEdge> edgeset= networkDomainGraph.edgesOf(localDomainID);
		Iterator <InterDomainEdge> iterador=edgeset.iterator();
		boolean edgeFound=false;
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
			networkDomainGraph.addEdge(localDomainID, remoteDomainID, newInterDomainEdge);
			log.info("Edge between "+localDomainID+" and "+remoteDomainID+" added");
//			InterDomainEdge newInterDomainEdge2 =new InterDomainEdge();
//			newInterDomainEdge2.setSrc_router_id(remoteRouterASBR);
//			newInterDomainEdge2.setDst_router_id(localRouterASBR);
//			newInterDomainEdge.setSrc_if_id(remoteRouterASBRIf);
//			newInterDomainEdge.setDst_if_id(localRouterASBRIf);
//			networkDomainGraph.addEdge(remoteDomainID, localDomainID, newInterDomainEdge2);
//			log.info("Edge between "+remoteDomainID+" and "+localDomainID+" added");

		}
	}
	
	public synchronized void addStorage( Object domainID, Object IT_site,int AdvType,Object ResourceID,LinkedList<CostSubTLV> CostsubtlvList, int TotalStorageSize, int AvailableStorageSize ){
		resource_id_it_site_ed = new Hashtable <Object,Object> ();
		if (!networkDomainGraph.containsVertex(domainID)){
			networkDomainGraph.addVertex(domainID);
			log.finest("Vertex (domain) "+domainID+" added");
		}
		
		log.finest("Looking to"+AdvType+" Storage resource:"+ResourceID+" in IT_Site:"+IT_site);
		log.finest("Total storage size:"+TotalStorageSize+" Available storage size:"+AvailableStorageSize+")");
		
		
		if (AdvType == 0x01){
			if (!it_site_id_domain_ed.containsKey(IT_site)){
				log.info("Adding IT_Site "+IT_site+" to topology");
				it_site_id_domain_ed.put(IT_site, domainID);
				
				log.info("Adding Resource "+ResourceID+" to IT_Site");
				resource_id_domain_ed.put(ResourceID, domainID);
				resource_id_it_site_ed.put(ResourceID, IT_site);
			}else{
				log.info("Adding Resource "+ResourceID+" to IT_Site");
				resource_id_domain_ed.put(ResourceID, domainID);
				resource_id_it_site_ed.put(ResourceID, IT_site);
			}
		}
//		if (it_site_id_domain_ed.containsKey(key))
//		//it_site_id_domain_ed=FileTEDBUpdater.getITSites(file);
//		//resource_id_domain_ed=FileTEDBUpdater.getResource(file);
//
//		
//		Set<InterDomainEdge> edgeset= networkDomainGraph.edgesOf(localDomainID);
//		Iterator <InterDomainEdge> iterador=edgeset.iterator();
//		boolean edgeFound=false;
//		while (iterador.hasNext()){
//			InterDomainEdge interDomainEdge=iterador.next();
//			log.finest("existing edge: "+interDomainEdge.toString());
//			if (interDomainEdge.getSrc_router_id().equals(localRouterASBR)){
//				log.finest("Local router is the same!!!");
//				if (interDomainEdge.getDst_router_id().equals(remoteRouterASBR)){
//					log.finest("Destination router is the same!!!");
//					edgeFound=true;
//				}
//				else {
//					log.finest("Destination router is NOT the same!!!");
//				}
//			}else {
//				log.finest("Local router is NOT the same!!!");
//			}			
//		}
//		
//		if (edgeFound==false) {
//			InterDomainEdge newInterDomainEdge =new InterDomainEdge();
//			newInterDomainEdge.setSrc_router_id(localRouterASBR);
//			newInterDomainEdge.setDst_router_id(remoteRouterASBR);
//			newInterDomainEdge.setSrc_if_id(localRouterASBRIf);
//			newInterDomainEdge.setDst_if_id(remoteRouterASBRIf);
//			networkDomainGraph.addEdge(localDomainID, remoteDomainID, newInterDomainEdge);
//			log.info("Edge between "+localDomainID+" and "+remoteDomainID+" added");
//			InterDomainEdge newInterDomainEdge2 =new InterDomainEdge();
//			newInterDomainEdge2.setSrc_router_id(remoteRouterASBR);
//			newInterDomainEdge2.setDst_router_id(localRouterASBR);
//			newInterDomainEdge.setSrc_if_id(remoteRouterASBRIf);
//			newInterDomainEdge.setDst_if_id(localRouterASBRIf);
//			networkDomainGraph.addEdge(remoteDomainID, localDomainID, newInterDomainEdge2);
//			log.info("Edge between "+remoteDomainID+" and "+localDomainID+" added");
//
//		}
	}

	
	public String printTopology() {
		//Hashtable <Object,Object> it_site_id_domain_ed=FileTEDBUpdater.getITSites(File);
		//Hashtable <Object,Object> it_site_id_domain_ed=FileTEDBUpdater.it_site_id_domain_ed;
		//Hashtable <Object,Object> resource_id_domain_ed=FileTEDBUpdater.getResource(File);
		String topoString;
		Set<Object> vetexSet= networkDomainGraph.vertexSet();
		Iterator <Object> vertexIterator=vetexSet.iterator();
		topoString="Domains: \r\n";
		while (vertexIterator.hasNext()){
			Object vertex= vertexIterator.next();
			topoString=topoString+"\t"+vertex.toString()+"\r\n";
			Enumeration<Object> site = it_site_id_domain_ed.keys();
			Enumeration<Object> resource = resource_id_domain_ed.keys();
			if(site.hasMoreElements()){
				while(site.hasMoreElements()){
					Object ele=site.nextElement();
					Object dom=it_site_id_domain_ed.get(ele);
					if(dom.equals(vertex)){
						topoString=topoString+"\t -IT site:\t"+ele.toString()+"\r\n";
						while (resource.hasMoreElements()){
							Object res=resource.nextElement();
							Object dombis=resource_id_domain_ed.get(res);
							if (dombis.equals(vertex))
								topoString=topoString+"\t  -IT Resource:\t"+res.toString()+"\r\n";
							}
					}

				}
			}
			
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

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addReachabilityIPv4(Inet4Address domainId,
			Inet4Address aggregatedIPRange, int prefix) {
		// TODO Auto-generated method stub
		
	}


}
