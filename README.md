netphony-topology v1.1.1
=======

Java based Traffic Engineering Database, BGP-LS peer, OSPF Listener, Connectors to RYU, TREMA, Floodlight

Dependencies are included in pom.xml (*)

(*) Note: OSPF raw socket with multicast support is a modification of Savarese Rocksaw library. The changes are still to be released. This dependency is not added yet.


Build with mavem 

# BGP Peer

The BGPPeer is the principal class. It represents a BGP4 peer. It launches the BGP connections with its peers and waits for incoming connections. 

To run the BGP Peer as a standalone application use the class BGPPeerMain.

The parameters are configured in an xml file. By default, if used with BGPPeerMain, or it is not specified a file name, BGP4Parameters.xml should be used. An example of the file is located in examples/BGP4Parameters.xml

## The parameters to be configured are:
BGP4Port: TCP port where the BGP is listening for incoming bgp4 connections. Optional Parameter. Default value: 179 (BGP Port)
BGPIdentifier: 
BGP4ManagementPort: TCP port to connect to manage the BGP connection. Default value: 1112 
configPeer: Peers to which this Peer is going to establish connection. One entry per peer.
    peer: IP Address of the peer
    export: If we need to export the topology to this peer. False by default
    import: If we are going to import topology from this peer. True by default
