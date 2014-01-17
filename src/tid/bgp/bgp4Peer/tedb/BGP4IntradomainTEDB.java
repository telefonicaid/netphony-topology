package tid.bgp.bgp4Peer.tedb;

import java.net.Inet4Address;
import java.util.Hashtable;
import java.util.LinkedList;

import tid.pce.tedb.InterDomainEdge;
import tid.pce.tedb.TEDB;

public class BGP4IntradomainTEDB implements IntraTEDBS {
	
	Hashtable<Inet4Address,BGP4DomainTEDB> tedb;
	@Override
	public void initializeFromFile(String file) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void addIntradomainEdge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIntradomainNode(Inet4Address domain, Inet4Address node) {
		BGP4DomainTEDB bgp4TEDB = tedb.get(domain);
		
	}

}
