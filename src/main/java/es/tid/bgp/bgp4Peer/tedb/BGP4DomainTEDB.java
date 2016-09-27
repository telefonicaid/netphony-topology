package es.tid.bgp.bgp4Peer.tedb;


import es.tid.tedb.InterDomainEdge;
import es.tid.tedb.TEDB;

import java.util.LinkedList;



public class BGP4DomainTEDB implements TEDB {

	@Override
	public void initializeFromFile(String file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeFromFile(String file, String learnFrom) {
		
	}

	@Override
	public boolean isITtedb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String printTopology() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<InterDomainEdge> getInterDomainLinks() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
