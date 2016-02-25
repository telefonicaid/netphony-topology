netphony-topology v1.2.1
=======

Netphony-topology is a BGP-LS Speaker and a Java based Traffic Engineering Database. 

BGP-LS is used for distributing Network Topologies to external elments, for example, a Path Computation Element. 

The BGP-LS speaker can be run as a standalone application, or as a module attached to other software.

## Traffic Engineering Database

The traffic Engineering Database (TED) is a collection of nodes and links, each of them with Traffic Engineering Attributes. The TED has as an attribute a domain identifier and a network layer.


## Compilation and use

The library can be built using the maven tool. Thus, all the dependencies are included in the pom.xml file. There is a Junit test included that performs the following tests:
* Buils two BGP-LS Speakers, one acting as sender of topology, and the other as consumer. A small topology is loaded from an xml file in BGP-LS Speaker #1. This topology is sent to BGP-LS Speaker #2.   
* 
* Contributions on expanding the test suite are welcomed!!

To build the .jar file and run the tests, first you need to install the netphony-network-protocols (the upload process to maven central is in progress)
 ```bash
    git clone https://github.com/telefonicaid/netphony-network-protocols.git
    cd netphony-network-protocols
    git checkout tags/v1.2.1
    mvn package
    mvn install
 ```
 Then, once the netphony-network-protocols is installed, you can proceed with the netphony-topology.
  ```bash
    cd ..
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-topology
    mvn package
    mvn install
 ```
# BGP-LS Speaker

The BGPPeer is the principal class to run a BGP Speaker. It represents a BGP4 peer. It launches the BGP connections with its peers and waits for incoming connections. 

To run the BGP Peer as a standalone application use the class BGPPeerMain. You can use maven to create an autoexecutable jar that includes all dependencies in a single file. Plase be aware that if you use the real BGP port (179) you need to start as root.
  ```bash
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-topology
    mvn clean compile assembly:single
    cd target
    sudo java -jar topology-1.2-jar-with-dependencies.jar 
 ```
 
 Before running, you should configure the parameteres. The parameters are configured in an xml file. By default, if used with BGPPeerMain, or it is not specified a file name, BGP4Parameters.xml should be used. An example of the file is located in examples/BGP4Parameters.xml (and with the maven assembly build, it is copied in the target directory).

## Configuration parameters
The parameters to be configured are:
 ```
BGP4Port: TCP port where the BGP is listening for incoming bgp4 connections. Optional Parameter. Default value: 179 (BGP Port)
BGPIdentifier: 32 Bit ID. Write it like an IP address (e.g. 10.0.0.1) See section 3.2.1.4 of https://datatracker.ietf.org/doc/draft-ietf-idr-ls-distribution/?include_text=1
BGP4ManagementPort: TCP port to connect to manage the BGP connection. Default value: 1112 
configPeer: Peers to which this Peer is going to establish connection. One entry per peer.
    peer: IP Address of the peer
    export: If we need to export the topology to this peer. False by default
    import: If we are going to import topology from this peer. True by default
 setTraces: true/false if the traces (detailed logs) are active or inactive. 
 BGP4LogFile: File where the logs are dumped
 delay: Waiting Time to re-connect to clients. Default value: 6000 ms.
 
 ```
