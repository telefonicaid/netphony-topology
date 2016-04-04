package es.tid.bgp.bgp4Peer.peer;



public class BGPPeerMain {
	
	/**
	 * @param args Command line arguments. First argument, config file.
	 */
	public static void main(String[] args) {
		BGPPeer bgpPeer = new BGPPeer();
		if (args.length != 0)
			bgpPeer.configure(args[0]);
		else
			bgpPeer.configure();
		
		//bgpPeer.createTEDB("hola"); //did it in configure
		bgpPeer.createUpdateDispatcher();
		bgpPeer.startClient();		
		bgpPeer.startServer();
		bgpPeer.startSaveTopology();
		bgpPeer.startManagementServer();
		bgpPeer.startSendTopology();
	

	}
}
