package es.tid.topologyModuleBase.database;

import java.util.LinkedList;
import java.util.Set;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
//import es.tid.pce.computingEngine.algorithms.ComputingAlgorithmPreComputation;
//import es.tid.pce.computingEngine.algorithms.ComputingAlgorithmPreComputationSSON;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.ReachabilityEntry;
import es.tid.tedb.SSONInformation;
import es.tid.tedb.SSONListener;
import es.tid.tedb.TEDB;
import es.tid.tedb.TEDListener;
import es.tid.tedb.TE_Information;
import es.tid.tedb.WSONInformation;

/**
 * It's just like DomainTEDB and TEDB but every function has an identifier with it.
 * It's thought for you to have a list of TEDB and apply the function on a particular TEDB depending
 * on the identifier.
 * @author jaume
 *
 */

public interface TopologyTEDB 
{
	public boolean belongsToDomain(String id, Object addr);

	public ReachabilityEntry getReachabilityEntry(String id);


	public LinkedList<InterDomainEdge> getInterDomainLinks(String id);
	public Set<IntraDomainEdge> getIntraDomainLinks(String id);
	public String printInterDomainLinks(String id);

	public boolean containsVertex(String id, Object vertex);
	public WSONInformation getWSONinfo(String id);
	public SSONInformation getSSONinfo(String id); 
	public void notifyWavelengthReservation(String id, LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional);
	public void notifyWavelengthReservationSSON (String id, LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional, int m);
	public void notifyWavelengthEndReservation(String id, LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional);
	public void notifyWavelengthChange(String id, Object localInterfaceIPAddress,Object remoteInterfaceIPAddress,BitmapLabelSet previousBitmapLabelSet,BitmapLabelSet newBitmapLabelSet );
	public void notifyNewEdgeIP(String id, Object source, Object destination, TE_Information informationTEDB);
	public void register(String id, TEDListener compAlgPreComp);
	public void registerSSON(String id, SSONListener compAlgPreComp);
	
	public void notifyNewVertex(String id, Object vertex);
	
	public void notifyNewEdge (String id, Object source, Object destination);
	
	public void clearAllReservations(String id);

	public void notifyWavelengthEndReservationSSON(
			String id, 
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m);
	public void notifyWavelengthReservationWLAN(
			String id, 
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, LinkedList<Integer> wlans,
			boolean bidirectional);
	
	public void initializeFromFile(String id, String file);

	public boolean isITtedb(String id);
	
	public String printTopology(String id);
	
	public void addTEDB(String id, DomainTEDB ted);
	
	
	
	public boolean belongsToDomain(Object addr);

	public ReachabilityEntry getReachabilityEntry();


	public LinkedList<InterDomainEdge> getInterDomainLinks();
	public Set<IntraDomainEdge> getIntraDomainLinks();
	public String printInterDomainLinks();

	public boolean containsVertex(Object vertex);
	public WSONInformation getWSONinfo();
	public SSONInformation getSSONinfo(); 
	public void notifyWavelengthReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional);
	public void notifyWavelengthReservationSSON (LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional, int m);
	public void notifyWavelengthEndReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength, boolean bidirectional);
	public void notifyWavelengthChange(Object localInterfaceIPAddress,Object remoteInterfaceIPAddress,BitmapLabelSet previousBitmapLabelSet,BitmapLabelSet newBitmapLabelSet );
	public void notifyNewEdgeIP(Object source, Object destination, TE_Information informationTEDB);
	public void register(TEDListener compAlgPreComp);
	public void registerSSON(SSONListener compAlgPreComp);
	
	public void notifyNewVertex(Object vertex);
	
	public void notifyNewEdge (Object source, Object destination);
	
	public void clearAllReservations();

	public void notifyWavelengthEndReservationSSON(
			
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m);
	public void notifyWavelengthReservationWLAN(
			
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, LinkedList<Integer> wlans,
			boolean bidirectional);
	
	public void initializeFromFile( String file);

	public boolean isITtedb();
	
	public String printTopology();
		
	public TEDB getDB();
	
	public TEDB getDB(String id);
}
