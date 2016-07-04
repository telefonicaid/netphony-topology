package es.tid.topologyModuleBase.database;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
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

public class TopologiesDataBase implements TopologyTEDB
{
	

	/**
	 * Used when there are several teds
	 */
	Hashtable<String, DomainTEDB> teds = null;
	
	/**
	 * Used when there is only one ted
	 * This is used so ther user doent have to introuce an identifier if there is only TEDB
	 */
	DomainTEDB ted = null;
	
	public TopologiesDataBase()
	{
		teds = new Hashtable<String, DomainTEDB>();
	}
	
	public TopologiesDataBase(DomainTEDB ted)
	{
		this.ted = ted; 
	}
	
	@Override
	public boolean belongsToDomain(String id, Object addr) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.belongsToDomain(addr);
	}

	@Override
	public ReachabilityEntry getReachabilityEntry(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.getReachabilityEntry();
	}

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.getInterDomainLinks();
	}

	@Override
	public Set<IntraDomainEdge> getIntraDomainLinks(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.getIntraDomainLinks();
	}

	@Override
	public String printInterDomainLinks(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.printInterDomainLinks();
	}

	@Override
	public boolean containsVertex(String id, Object vertex) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.containsVertex(vertex);
	}

	@Override
	public WSONInformation getWSONinfo(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.getWSONinfo();
	}

	@Override
	public SSONInformation getSSONinfo(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.getSSONinfo();
	}

	@Override
	public void notifyWavelengthReservation(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
	}

	@Override
	public void notifyWavelengthReservationSSON(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthReservationSSON(sourceVertexList,targetVertexList,wavelength,bidirectional,m);
	}

	@Override
	public void notifyWavelengthEndReservation(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthEndReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
		
	}

	@Override
	public void notifyWavelengthChange(String id,
			Object localInterfaceIPAddress, Object remoteInterfaceIPAddress,
			BitmapLabelSet previousBitmapLabelSet,
			BitmapLabelSet newBitmapLabelSet) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
		
	}

	@Override
	public void notifyNewEdgeIP(String id, Object source, Object destination,
			TE_Information informationTEDB) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyNewEdgeIP(source, destination, informationTEDB);
		
	}

	@Override
	public void register(String id,
			TEDListener compAlgPreComp) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.register(compAlgPreComp);
		
	}

	@Override
	public void registerSSON(String id,
			SSONListener compAlgPreComp) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.registerSSON(compAlgPreComp);
	}

	@Override
	public void notifyNewVertex(String id, Object vertex) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyNewVertex(vertex);
	}

	@Override
	public void notifyNewEdge(String id, Object source, Object destination) {
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyNewEdge(source, destination);
	}

	@Override
	public void clearAllReservations(String id)
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.clearAllReservations();
	}

	@Override
	public void notifyWavelengthEndReservationSSON(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthEndReservationSSON(sourceVertexList, targetVertexList, wavelength, bidirectional, m);
	}

	@Override
	public void notifyWavelengthReservationWLAN(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, LinkedList<Integer> wlans,
			boolean bidirectional) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.notifyWavelengthReservationWLAN(sourceVertexList, targetVertexList, wlans, bidirectional);
	}

	@Override
	public void initializeFromFile(String id, String file) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		ted.initializeFromFile(file);
	}

	@Override
	public boolean isITtedb(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.isITtedb();
	}

	@Override
	public String printTopology(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted.printTopology();
	}

	@Override
	public void addTEDB(String id, DomainTEDB ted) 
	{
		teds.put(id, ted);
	}

	@Override
	public boolean belongsToDomain(Object addr)
	{
		return ted.belongsToDomain(addr);
	}

	@Override
	public ReachabilityEntry getReachabilityEntry() 
	{
		return ted.getReachabilityEntry();
	}

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks() 
	{
		return ted.getInterDomainLinks();
	}

	@Override
	public Set<IntraDomainEdge> getIntraDomainLinks() 
	{
		return ted.getIntraDomainLinks();
	}

	@Override
	public String printInterDomainLinks() 
	{
		return ted.printInterDomainLinks();
	}

	@Override
	public boolean containsVertex(Object vertex) 
	{
		return ted.containsVertex(vertex);
	}

	@Override
	public WSONInformation getWSONinfo() 
	{
		return ted.getWSONinfo();
	}

	@Override
	public SSONInformation getSSONinfo() 
	{
		return ted.getSSONinfo();
	}

	@Override
	public void notifyWavelengthReservation(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		ted.notifyWavelengthReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
	}

	@Override
	public void notifyWavelengthReservationSSON(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		ted.notifyWavelengthReservationSSON(sourceVertexList, targetVertexList, wavelength, bidirectional, m);
	}

	@Override
	public void notifyWavelengthEndReservation(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		ted.notifyWavelengthEndReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
	}

	@Override
	public void notifyWavelengthChange(Object localInterfaceIPAddress,
			Object remoteInterfaceIPAddress,
			BitmapLabelSet previousBitmapLabelSet,
			BitmapLabelSet newBitmapLabelSet) 
	{
		ted.notifyWavelengthChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
	}

	@Override
	public void notifyNewEdgeIP(Object source, Object destination,
			TE_Information informationTEDB)
	{
		ted.notifyNewEdgeIP(source, destination, informationTEDB);
	}

	@Override
	public void register(TEDListener compAlgPreComp) 
	{
		ted.register(compAlgPreComp);
	}

	@Override
	public void registerSSON(SSONListener compAlgPreComp)
	{
		ted.registerSSON(compAlgPreComp);
	}

	@Override
	public void notifyNewVertex(Object vertex)
	{
		ted.notifyNewVertex(vertex);
	}

	@Override
	public void notifyNewEdge(Object source, Object destination)
	{
		ted.notifyNewEdge(source, destination);
	}

	@Override
	public void clearAllReservations()
	{
		ted.clearAllReservations();
		
	}

	@Override
	public void notifyWavelengthEndReservationSSON(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) 
	{
		ted.notifyWavelengthEndReservationSSON(sourceVertexList, targetVertexList, wavelength, bidirectional, m);
		
	}

	@Override
	public void notifyWavelengthReservationWLAN(
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, LinkedList<Integer> wlans,
			boolean bidirectional) 
	{
		ted.notifyWavelengthReservationWLAN(sourceVertexList, targetVertexList, wlans, bidirectional);
	}

	@Override
	public void initializeFromFile(String file) 
	{
		ted.initializeFromFile(file);
	}

	@Override
	public boolean isITtedb() 
	{
		return ted.isITtedb();
	}

	@Override
	public String printTopology() 
	{
		if(ted!=null)
			return ted.printTopology();
		else{
			if (teds.values().size()>0){
				return teds.values().iterator().next().printTopology();
			}else{
				return null;
			}
		}
	}

	@Override
	public TEDB getDB() 
	{
		if(ted==null){
			if (teds.values().size()>0){
				return teds.values().iterator().next();
			}else{
				return null;
			}
		}else{
			return ted;
		}
	}
	public List<TEDB> getAllDB(){
		List<TEDB> dbs = new ArrayList<TEDB>();
		if(this.ted==null){
			for(DomainTEDB tedb : teds.values()){
				dbs.add(tedb);
			}
		}else{
			dbs.add(this.ted);
		}
		return dbs;
	}
	
	@Override
	public TEDB getDB(String id) 
	{
		DomainTEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted;
	}
	
	public Hashtable<String, DomainTEDB> getTeds() {
		return teds;
	}
}
