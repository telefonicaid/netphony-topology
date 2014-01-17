package tid.bgp.bgp4Peer.tedb;


import java.net.Inet4Address;
import java.util.LinkedList;


import tid.pce.tedb.TEDB;
import tid.pce.tedb.InterDomainEdge;



public class BGP4DomainTEDB implements TEDB {

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

	

}
