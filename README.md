netphony-topology v1.2
=======

This software is a BGP-LS Speaker and a Java based Traffic Engineering Database. 

Also, There are Connectors to some controllers (RYU, TREMA, Floodlight). Upate is needed.

Dependencies are included in pom.xml (*)

(*) Note: OSPF support is removed, as OSPF raw socket with multicast support is a modification of Savarese Rocksaw library. The changes are still to be released. This dependency is not added yet.


## Compilation and use

The library can be built using the maven tool. There is a junit test included that test building two BGP-LS Speakers, one acting as sender of topology, and the other as consumer. Contributions on expanding the test suite are welcomed!!

To build the .jar file and run the tests, first you need to install the netphony-network-protocols (the upload process to maven central is in progress)
 ```bash
    git clone https://github.com/telefonicaid/netphony-network-protocols.git
    cd netphony-network-protocols
    mvn package
    mvn install
 ```
 Then, once the netphony-network-protocols is installed, you can proceed with the netphony-topology.
  ```bash
    cd ..
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-network-protocols
    mvn package
    mvn install
 ```
# BGP-LS Speaker

The BGPPeer is the principal class to run a BGP Speaker. It represents a BGP4 peer. It launches the BGP connections with its peers and waits for incoming connections. 

To run the BGP Peer as a standalone application use the class BGPPeerMain.

The parameters are configured in an xml file. By default, if used with BGPPeerMain, or it is not specified a file name, BGP4Parameters.xml should be used. An example of the file is located in examples/BGP4Parameters.xml

## The parameters to be configured are:
 ```
BGP4Port: TCP port where the BGP is listening for incoming bgp4 connections. Optional Parameter. Default value: 179 (BGP Port)
BGPIdentifier: 
BGP4ManagementPort: TCP port to connect to manage the BGP connection. Default value: 1112 
configPeer: Peers to which this Peer is going to establish connection. One entry per peer.
    peer: IP Address of the peer
    export: If we need to export the topology to this peer. False by default
    import: If we are going to import topology from this peer. True by default
 ```
