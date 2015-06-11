package tid.pce.tedb;

import java.util.LinkedList;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;

public interface TEDListener {

	public void notifyNewVertex(Object vertex);
	
	public void notifyNewEdge(Object source, Object destination);

	public void notifyWavelengthStatusChange(Object source, Object destination, BitmapLabelSet previousBitmapLabelSet, BitmapLabelSet newBitmapLabelSet);

	public void notifyWavelengthReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength);

	public void notifyWavelengthEndReservation(LinkedList<Object> sourceVertexList, LinkedList<Object> targetVertexList, int wavelength);

	public void notifyTEDBFullUpdate();

	public void notifyNewEdgeIP(Object source, Object destination, TE_Information informationTEDB);

	public void notificationEdgeIP_AuxGraph(Object src, Object dst, TE_Information informationTEDB);

	public void notificationEdgeOPTICAL_AuxGraph(Object src, Object dst, int lambda);
	
}
