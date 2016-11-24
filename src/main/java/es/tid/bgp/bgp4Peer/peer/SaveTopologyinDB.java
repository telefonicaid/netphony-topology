package es.tid.bgp.bgp4Peer.peer;

import java.net.Inet4Address;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import es.tid.tedb.DatabaseControlSimplifiedLSA;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.TEDB;
import es.tid.tedb.TE_Information;

/**
 * Class to save periodically the topology. It sends the topology to the active BGP4 sessions.
 * @author pac
 *
 */
public class SaveTopologyinDB implements Runnable {
	
	//FIXME: Configure from file
		private Jedis jedis;
		private String host="localhost";
		private int port=6379;
		
	//TEDBs 
	 private Hashtable<String,TEDB> intraTEDBs;
	
	// Multi-domain TEDB to redistribute Multi-domain Topology
	private MultiDomainTEDB multiDomainTEDB;

	private boolean writeTopology;

	private Logger log;
	
	
	public SaveTopologyinDB(){
		log = LoggerFactory.getLogger("BGP4Peer");
		jedis = new Jedis(host,port); 
	}

	public void configure( Hashtable<String,TEDB> intraTEDBs,MultiDomainTEDB multiTED,  boolean writeTopology, String host, int port){
		this.intraTEDBs=intraTEDBs;
		this.writeTopology=writeTopology;
		this.multiDomainTEDB=multiTED;
		//rdh.setHost(host);
		//rdh.setPort(port);
		
		
		if (writeTopology){
			jedis = new Jedis(host,port);
			jedis.connect();
		}
	}

	/**
	 * Function to send the topology database.
	 */


	public void run(){		
		try {
		if (writeTopology){
			log.info("Going to save Topology in Redis DB");
			if (jedis==null){
				jedis = new Jedis(host,port);
				jedis.connect();
			}else if (jedis.isConnected()==false){
				jedis.connect();
			}
			if (multiDomainTEDB!=null){
					log.info("save Multi-Domain TEDB");
					writeLinkDBInter( multiDomainTEDB.getInterDomainLinks());
				}
				else {
					log.info("save form TEDB");
					Enumeration<TEDB> iter = intraTEDBs.elements();
					while (iter.hasMoreElements()){
						writeLinkDBInter( iter.nextElement().getInterDomainLinks());
					}
				}			
				
					log.info("sendIntraDomainLinks activated");
					Enumeration<String> iter = intraTEDBs.keys();
					while (iter.hasMoreElements()){						
						String domainID = iter.nextElement();
						log.info("Sending TED from domain "+domainID);
						DomainTEDB ted=(DomainTEDB)intraTEDBs.get(domainID);
						//writeLinkDB( ted.getNetworkGraph().edgeSet(),domainID);
						writeLinkDB(ted.getIntraDomainLinks(),domainID);
					}
					
							
		}
		}catch (Exception e) {
			e.printStackTrace();
			log.error("PROBLEM Writing TOPOLOGY: "+e.toString());
		}

	}

	/**
	 * This function write a BGP4 update message in Data Base for each link in the list
	 * @param intradomainLinks
	 */
	private void writeLinkDB(Set<IntraDomainEdge> intradomainLinks, String domainID){
		
			Iterator<IntraDomainEdge> edgeIt = intradomainLinks.iterator();
			
			while (edgeIt.hasNext()){

				IntraDomainEdge edge = edgeIt.next();
				
				DatabaseControlSimplifiedLSA dcsl =createSimplifiedLSA(edge); 
				String jsonLSA = dcsl.logJsonSimplifiedLSA();
				
				if (jedis == null)
					log.info("JEDIS IS NULL");
				
				String ret = jedis.set("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(), jsonLSA);
			}

	}
	
	private DatabaseControlSimplifiedLSA createSimplifiedLSA(IntraDomainEdge edge){
		DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
		
		//Inet4Address source = (Inet4Address)edge.getSrc_router_id();
		//Inet4Address dst = (Inet4Address)edge.getDst_router_id();
		
		Inet4Address source = (Inet4Address)edge.getSource();
		dcsl.setAdvertisingRouter(source);
		Inet4Address dst = (Inet4Address)edge.getTarget();
		dcsl.setLinkId(dst);
		
		TE_Information te_info = ((IntraDomainEdge) edge).getTE_info();
		
		if (te_info != null){
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkLocalIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
			}
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkRemoteIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();
			}
			
			if (te_info.getMaximumBandwidth() != null) {
				dcsl.maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
			}
			
			if (te_info.getUnreservedBandwidth() != null) {
				dcsl.unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth()[0];
			}
					
			if (te_info.getMaximumReservableBandwidth() != null)
				dcsl.maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
			
			String ret = "";
			
			if (te_info.getAvailableLabels() != null){
				
				if (te_info.getAvailableLabels().getLabelSet() != null){
					
					ret=ret+" Bitmap: {";
					
					for (int i=0;i<te_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					
						ret = ret+ (te_info.isWavelengthFree(i)?"0":"1");		
					}
					
					ret=ret+"}";
					
					dcsl.setBitmapLabelSet(ret);
				
				}
			}
		}
		
		return dcsl;
	
	}
	
	
	/**
	 * This function write a BGP4 update message in Data Base for each link in the list
	 * @param intradomainLinks
	 */
	private void writeLinkDBInter(LinkedList<InterDomainEdge> interdomainLinks){
		
			Iterator<InterDomainEdge> edgeIt = interdomainLinks.iterator();
			
			while (edgeIt.hasNext()){

				InterDomainEdge edge = edgeIt.next();
				
				DatabaseControlSimplifiedLSA dcsl =createSimplifiedLSAInter(edge); 
				String jsonLSA = dcsl.logJsonSimplifiedLSA();
				//rdh.write("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(),jsonLSA);		
				String ret = jedis.set("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(), jsonLSA);
			}

	}
	
	private DatabaseControlSimplifiedLSA createSimplifiedLSAInter(InterDomainEdge edge){
		DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
		
		//Inet4Address source = (Inet4Address)edge.getSrc_router_id();
		//Inet4Address dst = (Inet4Address)edge.getDst_router_id();
		
		Inet4Address source = (Inet4Address)edge.getSource();
		dcsl.setAdvertisingRouter(source);
		Inet4Address dst = (Inet4Address)edge.getTarget();
		dcsl.setLinkId(dst);
		
		TE_Information te_info = ((InterDomainEdge) edge).getTE_info();
		
		if (te_info != null){
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkLocalIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier();
			}
			
			if (te_info.getLinkLocalRemoteIdentifiers() != null){
				dcsl.linkRemoteIdentifier = te_info.getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier();
			}
			
			if (te_info.getMaximumBandwidth() != null) {
				dcsl.maximumBandwidth = te_info.getMaximumBandwidth().getMaximumBandwidth();
			}
			
			if (te_info.getUnreservedBandwidth() != null) {
				dcsl.unreservedBandwidth = te_info.getUnreservedBandwidth().getUnreservedBandwidth()[0];
			}
					
			if (te_info.getMaximumReservableBandwidth() != null)
				dcsl.maximumReservableBandwidth = te_info.getMaximumReservableBandwidth().getMaximumReservableBandwidth();
			
			String ret = "";
			
			if (te_info.getAvailableLabels() != null){
				
				if (te_info.getAvailableLabels().getLabelSet() != null){
					
					ret=ret+" Bitmap: {";
					
					for (int i=0;i<te_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					
						ret = ret+ (te_info.isWavelengthFree(i)?"0":"1");		
					}
					
					ret=ret+"}";
					
					dcsl.setBitmapLabelSet(ret);
				
				}
			}
		}
		
		return dcsl;
	
	}

	public MultiDomainTEDB getMultiDomainTEDB() {
		return multiDomainTEDB;
	}

	public void setMultiDomainTEDB(MultiDomainTEDB multiDomainTEDB) {
		this.multiDomainTEDB = multiDomainTEDB;
	}
	
	
}
				
			


