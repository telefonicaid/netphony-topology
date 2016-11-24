package es.tid.topologyModuleBase.database;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.*;

import java.util.*;

//import es.tid.pce.computingEngine.algorithms.ComputingAlgorithmPreComputation;
//import es.tid.pce.computingEngine.algorithms.ComputingAlgorithmPreComputationSSON;

public class TopologiesDataBase implements TopologyTEDB
{
	

	/**
	 * Used when there are several teds
	 */
	Hashtable<String, TEDB> teds = null;
	
	/**
	 * Used when there is only one ted
	 * This is used so ther user doent have to introuce an identifier if there is only TEDB
	 */
	DomainTEDB ted = null;
	
	/**
	 * 
	 */
	MultiDomainTEDB mdTed = null;
	
	public TopologiesDataBase()
	{
		teds = new Hashtable<String, TEDB>();
	}
	
	public TopologiesDataBase(DomainTEDB ted)
	{
		this.ted = ted; 
	}
	
	@Override
	public boolean belongsToDomain(String id, Object addr) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).belongsToDomain(addr);
		} else {
			return false;
		}
		
	}

	@Override
	public ReachabilityEntry getReachabilityEntry(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).getReachabilityEntry();
		} else {
			return null;
		}
		
	}

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).getInterDomainLinks();
		} else {
			return null;
		}
	}

	@Override
	public Set<IntraDomainEdge> getIntraDomainLinks(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).getIntraDomainLinks();
		} else {
			return null;
		}
		
	}

	@Override
	public String printInterDomainLinks(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).printInterDomainLinks();
		} else {
			return null;
		}
	}

	@Override
	public boolean containsVertex(String id, Object vertex) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).containsVertex(vertex);
		} else {
			return false;
		}
	}

	@Override
	public WSONInformation getWSONinfo(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).getWSONinfo();
		} else {
			return null;
		}
	}

	@Override
	public SSONInformation getSSONinfo(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).getSSONinfo();
		} else {
			return null;
		}
	}

	@Override
	public void notifyWavelengthReservation(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
		}
	}

	@Override
	public void notifyWavelengthReservationSSON(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthReservationSSON(sourceVertexList,targetVertexList,wavelength,bidirectional,m);
	
		}
	}

	@Override
	public void notifyWavelengthEndReservation(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthEndReservation(sourceVertexList, targetVertexList, wavelength, bidirectional);
		}
	}

	@Override
	public void notifyWavelengthChange(String id,
			Object localInterfaceIPAddress, Object remoteInterfaceIPAddress,
			BitmapLabelSet previousBitmapLabelSet,
			BitmapLabelSet newBitmapLabelSet) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthChange(localInterfaceIPAddress, remoteInterfaceIPAddress, previousBitmapLabelSet, newBitmapLabelSet);
		}
	}

	@Override
	public void notifyNewEdgeIP(String id, Object source, Object destination,
			TE_Information informationTEDB) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyNewEdgeIP(source, destination, informationTEDB);
		}
	}

	@Override
	public void register(String id,
			TEDListener compAlgPreComp) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).register(compAlgPreComp);
		}
	}

	@Override
	public void registerSSON(String id,
			SSONListener compAlgPreComp) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).registerSSON(compAlgPreComp);
		}
	}

	@Override
	public void notifyNewVertex(String id, Object vertex) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyNewVertex(vertex);
		}
	}

	@Override
	public void notifyNewEdge(String id, Object source, Object destination) {
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyNewEdge(source, destination);
		}
	}

	@Override
	public void clearAllReservations(String id)
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).clearAllReservations();
		}
	}

	@Override
	public void notifyWavelengthEndReservationSSON(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, int wavelength,
			boolean bidirectional, int m) {
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthEndReservationSSON(sourceVertexList, targetVertexList, wavelength, bidirectional, m);

		}
	}

	@Override
	public void notifyWavelengthReservationWLAN(String id,
			LinkedList<Object> sourceVertexList,
			LinkedList<Object> targetVertexList, LinkedList<Integer> wlans,
			boolean bidirectional) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).notifyWavelengthReservationWLAN(sourceVertexList, targetVertexList, wlans, bidirectional);

		}
	}

	@Override
	public void initializeFromFile(String id, String file) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			((DomainTEDB)ted).initializeFromFile(file);
		}
	}

	@Override
	public boolean isITtedb(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).isITtedb();
		}else {
			return false;
		}
	}

	@Override
	public String printTopology(String id) 
	{
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		if (ted instanceof DomainTEDB) {
			return ((DomainTEDB)ted).printTopology();
		}else {
			return "";
		}
	}

	@Override
	public void addTEDB(String id, DomainTEDB ted) 
	{
		teds.put(id, ted);
	}
	
	public void addTEDB(String id, TEDB ted) 
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
		//teds.putAll(FileTEDBUpdater.readMultipleDomainSimpleNetworks(file, null, false,0,Integer.MAX_VALUE, false, "test"));
		//mdTed.initializeFromFile(file, "test");
	}

	@Override
	public void initializeFromFile(String file, String ID, Boolean test)
	{
		//ted.initializeFromFile(file);
		//System.out.println("It works!!!!");
		teds.putAll(FileTEDBUpdater.readMultipleDomainSimpleNetworks(file, null, false,0,Integer.MAX_VALUE, false, ID));
		mdTed.initializeFromFile(file, ID);
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
			for(TEDB tedb : teds.values()){
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
		TEDB ted = this.ted == null ? teds.get(id) : this.ted;
		return ted;
	}
	
	public Hashtable<String, TEDB> getTeds() {
		return teds;
	}
	
	public Hashtable<String, DomainTEDB> getDomainTeds() {
		Hashtable<String, DomainTEDB> domainTEDS= new Hashtable<String, DomainTEDB>();
		Enumeration <String> tedks= teds.keys();
		while (tedks.hasMoreElements()){
			String teddk= tedks.nextElement();
			TEDB tedd= teds.get(teddk);
			if (tedd instanceof DomainTEDB) {
				domainTEDS.put(teddk, (DomainTEDB) tedd);
			}
		}
		return domainTEDS;
	}

	public MultiDomainTEDB getMdTed() {
		return mdTed;
	}

	public void setMdTed(MultiDomainTEDB mdTed) {
		this.mdTed = mdTed;
		this.teds.put("multidomain", mdTed);
	}
	
	
	
}
