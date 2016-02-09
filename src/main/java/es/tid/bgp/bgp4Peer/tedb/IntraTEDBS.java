package es.tid.bgp.bgp4Peer.tedb;

import java.net.Inet4Address;

import es.tid.tedb.TEDB;

public interface IntraTEDBS extends TEDB {

	
	//Metodo (annadir enlace intradominio) que le pases un domain id, + cosas que necesites para el intradomain edge.
	//Las clases que implemente para esta interface ya tengra que ver c�mo hacerlo. Tener una hashtable. 
	public void addIntradomainEdge();
	public void addIntradomainNode(Inet4Address domain, Inet4Address node);
	
	
}
