package es.tid.tedb;

import java.net.Inet4Address;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.pce.pcep.objects.tlvs.StorageTLV;


/**
 * Base de datos de ingenieria de trafico
 * CLASE DE PRUEBA REESTRUCTURAR DESPUES!!!!!!!!!!
 * @author Alejandro Tovar
 *
 */
public class SimpleITTEDB implements DomainTEDB{
	private long graphId;
	private SimpleDirectedWeightedGraph<Object,IntraDomainEdge> networkGraph;
	private LinkedList<InterDomainEdge> interDomainLinks; //MARTA
	//public SimpleDirectedWeightedGraph<Integer,IntraDomainEdge> grafo;
	//private byte[] domainReachabilityIPv4Prefix;
	//private Object domainId;
	//private byte[] mask;
	
	private Hashtable <Object,Object> it_site_id_domain_ed;
	private Hashtable <Object,Object> resource_id_domain_ed;
	
	private Hashtable <StorageTLV,Object> storage_domain_ed;
	ReachabilityEntry reachabilityEntry;
	
	private Logger log;
	
	public SimpleDirectedWeightedGraph<Object,IntraDomainEdge> getDuplicatedNetworkGraph(){
		it_site_id_domain_ed=new Hashtable <Object,Object>();
		resource_id_domain_ed=new Hashtable <Object,Object>();
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> graphCopy= (SimpleDirectedWeightedGraph<Object, IntraDomainEdge>) networkGraph.clone();
		log = Logger.getLogger("PCEServer");
		return graphCopy;
	}
	
	public void initializeFromFile(String file){
		
		interDomainLinks = FileTEDBUpdater.readInterDomainLinks(file);//MARTA
		storage_domain_ed = FileTEDBUpdater.getStorageCharacteristics(file);
		
		it_site_id_domain_ed=FileTEDBUpdater.getITSites(file);
		resource_id_domain_ed=FileTEDBUpdater.getResource(file);
		
		reachabilityEntry = new ReachabilityEntry();
		FileTEDBUpdater.getDomainReachabilityFromFile(file,reachabilityEntry);
		
		networkGraph=FileTEDBUpdater.readITNetwork(file);
//		domainId=FileTEDBUpdater.readNetworkDomain(file);
//		domainReachabilityIPv4Prefix=new byte[4];
//		domainReachabilityIPv4Prefix[0]=(byte)172;
//		domainReachabilityIPv4Prefix[1]=(byte)16;
//		domainReachabilityIPv4Prefix[2]=(byte)101;
//		domainReachabilityIPv4Prefix[3]=(byte)0;
//		mask=new byte[4];
//		mask[0]=(byte)255;
//		mask[1]=(byte)255;
//		mask[2]=(byte)255;
//		mask[3]=(byte)0;
		
	}
	
	public long getGraphId() {
		return graphId;
	}
	public void setGraphId(long graphId) {
		this.graphId = graphId;
	}
	
	
	public boolean belongsToDomain(Object addr){
		int i;
		byte[] addrbytes=((Inet4Address)addr).getAddress();
		for (i=0;i<4;++i){
			int a= ((int)addrbytes[i])&0xFF;
			log.info("addrbytes["+i+"]= "+a);
			addrbytes[i]=(byte) (addrbytes[i]&(reachabilityEntry.getMask())[i]);
			int aa= ((int)addrbytes[i])&0xFF;
			log.info("addrbytesMask["+i+"]= "+aa);
		}
		for (i=0;i<4;++i){
			
		    if (addrbytes[i]!=(reachabilityEntry.getAggregatedIPRange().getAddress())[i]){
		    	log.info("addrbytes[i] "+addrbytes[i]);
		    	log.info("domainAddress[i] "+((int)((reachabilityEntry.getAggregatedIPRange().getAddress())[i])&0xFF));
		    	return false;
		    }
		}
		return true;
	}

//	public byte[] getDomainReachabilityIPv4Prefix() {
//		return domainReachabilityIPv4Prefix;
//	}

//	public void setDomainReachabilityIPv4Prefix(byte[] domainReachabilityIPv4Prefix) {
//		this.domainReachabilityIPv4Prefix = domainReachabilityIPv4Prefix;
//	}

//	public Object getDomainId() {
//		return domainId;
//	}

//	public void setDomainId(Object domainId) {
//		this.domainId = domainId;
//	}
	
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
	
	public Hashtable<StorageTLV, Object> getStorageCharacteristics() {
		return storage_domain_ed;
	}

	public void setStorageCharacteristics(Hashtable<StorageTLV,Object> storage_domain_ed) {
		this.storage_domain_ed = storage_domain_ed;
	}


//	public DirectedWeightedMultigraph<Object, InterDomainEdge> getDuplicatedMDNetworkGraph() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String printTopology() {
		
		String topoString;
		Set<Object> vetexSet= networkGraph.vertexSet();
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
		topoString=topoString+"Intradomain Link list: \r\n";
		Set<IntraDomainEdge> edgeSet= networkGraph.edgeSet();
		Iterator <IntraDomainEdge> edgeIterator=edgeSet.iterator();
		while (edgeIterator.hasNext()){
			IntraDomainEdge edge= edgeIterator.next();
			topoString=topoString+"\t"+edge.toString()+"\r\n";
		}
		topoString=topoString+printInterDomainLinks();
		return topoString;
	}


	@Override
	public String printInterDomainLinks() {
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


	public void notifyWavelengthChange(Object localInterfaceIPAddress,Object remoteInterfaceIPAddress,TE_Information info){
		boolean removeLink=false; 
		if (info.getMaximumBandwidth()!= null){
			if (info.getUnreservedBandwidth()!= null){
				if (info.getUnreservedBandwidth().getUnreservedBandwidth()!= null){
					if (info.getUnreservedBandwidth().getUnreservedBandwidth()[0]== 0){
						IntraDomainEdge intraDomainEdge = networkGraph.getEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);
					if (intraDomainEdge!=null){
						networkGraph.removeEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);	
					}						
					removeLink=true;
					}
				}
			}				
		}
		if (removeLink==false){
			IntraDomainEdge intraDomainEdge = networkGraph.getEdge(localInterfaceIPAddress, remoteInterfaceIPAddress);
			intraDomainEdge.setTE_info(info);
		}
	}
	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean containsVertex(Object vertex) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void register(TEDListener compAlgPreComp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWavelengthChange(Object localInterfaceIPAddress,
			Object remoteInterfaceIPAddress,
			BitmapLabelSet previousBitmapLabelSet,
			BitmapLabelSet newBitmapLabelSet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WSONInformation getWSONinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyNewVertex(Object vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyNewEdge(Object source, Object destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAllReservations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWavelengthReservation(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWavelengthEndReservation(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) {
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
	public void notifyNewEdgeIP(Object source, Object destination,
			TE_Information informationTEDB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWavelengthEndReservationSSON(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerSSON(SSONListener compAlgPreComp) {
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


	
	

}