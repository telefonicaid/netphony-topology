package tid.pce.tedb;


import java.util.LinkedList;
import java.util.Set;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;


public interface DomainTEDB extends TEDB {
	 
	
	public boolean belongsToDomain(Object addr);

	//public Object getDomainId();
	public ReachabilityEntry getReachabilityEntry();

	//public byte[]  getDomainReachabilityIPv4Prefix();

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
}
