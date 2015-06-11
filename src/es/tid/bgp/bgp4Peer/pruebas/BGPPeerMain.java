package es.tid.bgp.bgp4Peer.pruebas;



public class BGPPeerMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BGPPeer bgpPeer = new BGPPeer();
		if (args.length != 0)
			bgpPeer.configure(args[0]);
		else
			bgpPeer.configure();
		
		bgpPeer.startClient();		
		bgpPeer.startServer();
		bgpPeer.startManagementServer();
		bgpPeer.startSendTopology();
		

	}
}
