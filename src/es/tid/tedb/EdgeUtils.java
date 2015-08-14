package es.tid.tedb;

import java.net.Inet4Address;

import es.tid.of.DataPathID;

public class EdgeUtils {
	
	public static Object getEdge(String edge){
		Object router_id_addr;
		try { //Router_type: IPv4
			router_id_addr = (Inet4Address) Inet4Address.getByName(edge);
		} catch (Exception e) { //Router_type: DatapathID
			router_id_addr =  (DataPathID) DataPathID.getByName(edge);
			//FIXME: See what to do if it is not IPv4 or DatapahID
		}
		return router_id_addr;
	}

}
