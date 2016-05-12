package es.tid.bgp.bgp4Peer.tests;

import static org.junit.Assert.*;

import java.net.Inet4Address;
import java.util.Set;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.MDTEDB;

public class BGP4PeerIT {
	
	public BGP4PeerIT(){
		
	}
	
	/**
	 * This tests starts a BGL-LS Speaker, reads the topology from a File and Sends it.
	 * A second speaker is started and reads the topology.
	 * The first speaker is configured to read only the multidomain topology and send the 
	 * multidomain topology
	 * The second speaker is configured as Consumer. 
	 * The speakers are launched in separated non-standard ports for testing purposes.
	 * Both speakers talk and the topology is sent from BGP-Speaker 1 to BGP-Speaker 2
	 * It checks after 10 seconds if the topology of BGP-Speaker 2 is the same as BGP
	 * Speaker 1. 
	 */
	@org.junit.Test
	public void testPeer(){
		try {
		//Create BGP4Peer 1 
		BGPPeer bgpPeer = new BGPPeer();
		bgpPeer.configure("src/test/resources/BGP4Parameters_1.xml");
		//Create the TEDB
		//bgpPeer.createTEDB("test"); //did it in configure
		assertTrue("Checking MD Topology has 2 domains",((MDTEDB)bgpPeer.getMultiDomainTEDB()).getNetworkDomainGraph().vertexSet().size()==2);
		//bgpPeer.createUpdateDispatcher();
		//bgpPeer.startClient();		
		//bgpPeer.startServer();
		//bgpPeer.startSaveTopology();
		//bgpPeer.startManagementServer();
		//bgpPeer.startSendTopology();
		String topoOriginal=bgpPeer.getMultiDomainTEDB().printTopology();
		System.out.println("<----INTEGRATION TEST---->");
		System.out.println("Topology1: ");
		System.out.println(topoOriginal);
		
		
		//Launch BGP4Peer
		//bgpPeer.stopPeer();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BGPPeer bgpPeer2 = new BGPPeer();
		bgpPeer2.configure("src/test/resources/BGP4Parameters_2.xml");
		//Create the TEDB
		//bgpPeer2.createTEDB("test"); //did it in configure
		bgpPeer2.createUpdateDispatcher();
		bgpPeer2.startClient();		
		bgpPeer2.startServer();
		bgpPeer2.startSaveTopology();
		bgpPeer2.startManagementServer();
		bgpPeer2.startSendTopology();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String topo2=bgpPeer2.getMultiDomainTEDB().printTopology();
		
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("Topology of BGP-LS Speaker 1: ");
		System.out.println("---------------------------------------");
		System.out.println(topoOriginal);
		Set<Inet4Address> keySet = bgpPeer.getIntraTEDBs().keySet();
		for(Inet4Address key : keySet){
			System.out.println("---IntraTEDB: domain_id= "+key.toString());
			System.out.println(bgpPeer.getIntraTEDBs().get(key).printTopology());
		}
		System.out.println("---------------------------------------");
		System.out.println("Topology of  BGP-LS Speaker 2: ");
		System.out.println("---------------------------------------");		
		System.out.println(topo2);
		System.out.println("---------------------------------------");
		Set<Inet4Address> keySet2 = bgpPeer2.getIntraTEDBs().keySet();
		for(Inet4Address key : keySet2){
			System.out.println("---IntraTEDB: domain_id= "+key.toString());
			System.out.println(bgpPeer2.getIntraTEDBs().get(key).printTopology());
		}
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for(Inet4Address key : keySet){
			assertTrue("Checking if topos, IntraTEDBs, have the same domains", keySet.contains(key));
			assertTrue("Checking if topos, IntraTEDB (domain="+key+") are equal", bgpPeer.getIntraTEDBs().get(key).equals(bgpPeer2.getIntraTEDBs().get(key)));
		}
		assertTrue("Checking if topos are equal",topoOriginal.equals(topo2));
		} catch (Exception exc){
			exc.printStackTrace();
			assertTrue("Exception "+exc.getMessage(),false);
		}
			
		
	}

}
