netphony-topology v1.3.3
=======
Repository branch build status:

| **Master**  | **Develop**   |
|:---:|:---:|
| [![Build Status](https://travis-ci.org/telefonicaid/netphony-topology.svg?branch=master)](https://travis-ci.org/telefonicaid/netphony-topology) | [![Build Status](https://travis-ci.org/telefonicaid/netphony-topology.svg?branch=develop)](https://travis-ci.org/telefonicaid/netphony-topology) |

Latest Maven Central Release: 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/es.tid.netphony/topology/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/es.tid.netphony/topology/)

Netphony-topology is a BGP-LS Speaker, a Java based Traffic Engineering Database and a Topology Module (collection of TEDs and plugins to export and import the TEDs). 

BGP-LS is used for distributing Network Topologies to external elments, for example, a Path Computation Element. 

The BGP-LS speaker can be run as a standalone application, or as a module attached to other software.

The Topology Module can export the topologies via BGP-LS or RESCONF based APIs following standard formats. 

## *Latest news!*
- Apache 2.0 license
- Moved to slf4j logging framework
- Added method to pass multiple TEDs from en external program
- Added docker support in travis
- Supports network-protocols 1.3.2 (chages in reading as_path were needed)
- Update to support reading multiple AS_PATH
- Topology Module added
- Topology Module: Export via RESCONF with COP model
- Topology Module: Export via RESTCONF with IETF model (nodes only)
- Topology Module: Export via UNIFY model
- Topology Module: Import via XML
- Topology Module: Import/Export via BGP-LS

## Traffic Engineering Database

The traffic Engineering Database (TED) is a collection of nodes and links, each of them with Traffic Engineering Attributes. The TED has as an attribute a domain identifier and a network layer.

## Compilation and use

The library can be built using the maven tool. Thus, all the dependencies are included in the pom.xml file. There is a Junit test included that performs the following tests:
* Buils two BGP-LS Speakers, one acting as sender of topology, and the other as consumer. A small topology is loaded from an xml file in BGP-LS Speaker #1. This topology is sent to BGP-LS Speaker #2.   
* Contributions on expanding the test suite are welcomed!!

To build the .jar file and run the tests, you can proceed as a regular maven install:
  ```bash
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-topology
    mvn install
 ```
# BGP-LS Speaker

The BGPPeerMain is an example of a main class to run a BGP Speaker. It represents a BGP4 peer. It launches the BGP connections with its peers and waits for incoming connections. 

To run the BGP Peer as a standalone application use the class BGPPeerMain. You can use maven to create an autoexecutable jar that includes all dependencies in a single file. There is a specific profile called bgp-ls-speaker for this sole purpose. Plase be aware that if you use the real BGP port (179) you need to start as root.  
  ```bash
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-topology
    mvn clean package -P bgp-ls-speaker assembly:single
    sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/bgp-ls-speaker-jar-with-dependencies.jar target/bgpls_example1/BGP4Parameters_1.xml
 ```
 
Before running, you should configure the parameteres. The parameters are configured in an xml file. By default, if used with BGPPeerMain, or it is not specified a file name, BGP4Parameters.xml should be used. An example of the file is located in examples/BGP4Parameters.xml (and with the maven assembly build, it is copied in the target directory).
## Configuration parameters
The parameters to be configured are:

* **BGP4Port:** TCP port where the BGP is listening for incoming bgp4 connections. Optional Parameter. Default value: 179 (BGP Port)
* **localBGPAddress:** IP where the BGP is listening for incoming bgp4 connections. Default value: localhost
* **BGPIdentifier:** 32 Bit ID. Write it like an IP address (e.g. 10.0.0.1) See section 3.2.1.4 of https://datatracker.ietf.org/doc/draft-ietf-idr-ls-distribution/?include_text=1
* **BGP4ManagementPort:** TCP port to connect to manage the BGP connection. Default value: 1112 
* **configPeer:** Peers to which this Peer is going to establish connection. One entry per peer.
  *  **peer:** IP Address of the peer
  *  **export:** If we need to export the topology to this peer. False by default
  *  **import:** If we are going to import topology from this peer. True by default
* **delay:** Waiting Time to re-connect to clients. Default value: 6000 ms.
* **myAutonomousSystem:** RFC 4271.  This 2-octet unsigned integer indicates the Autonomous System number of the sender

# Topology Module

The Topology Module is a collection of Traffic Engineering Databases with a set of plugins that can import or export the TEDs. The available plugins are:

* BGP-LS Plugin. The BGP-LS plugin can run in three different modes. The first one is EXPORT only, so the TEDs are exported via BGP-LS. The second mode is IMPORT only, where BGP-LS is activated to import the TEDS. The last one is IMPORT-EXPORT, so the BGP-LS speaker is used both to import and export topologies. By default, the topologies are exported to all the peers, except the one from which the TED has been learnt. For each domain learn and new TED is created. Also, a multi-domain TED is created connecting all the intradomain topologies. The BGP-LS configuration is expressed in a file, following the format shown in the previous section. 
* XML Plugin. The XML plugin can learn a topology described in an XML file. Current plugin reads only the information once. 
* UNIFY Plugin. The UNIFY plugin exports the topology via RESTCONF following the UNIFY format (https://tools.ietf.org/html/draft-irtf-nfvrg-unify-recursive-programming-00) 
* COP Plugin. The COP plugin exports the topology via RESTCONF following the COP format. 
* IETF Plugin. In development. Current version supports node only. Follows https://tools.ietf.org/html/draft-ietf-teas-yang-te-topo-06
* TAPI Plugin. In development. 

To run the Topology Module as a standalone application use the class es.tid.topologyModuleBase.TopologyModuleMain. You can use maven to create an autoexecutable jar that includes all dependencies in a single file. There is a specific profile called *generate-full-jar* for this sole purpose. Please be aware that if you use the BGP-LS Plugin and need to use the standar port (179) you need to start as root.  
  ```bash
    git clone 
    git clone https://github.com/telefonicaid/netphony-topology.git
    cd netphony-topology
    mvn clean package -P generate-full-jar
    cd target
 ```
 
 For example, to launch a Topology module with BGP-LS import and RECONF COP export (be sure to be in the target directory):
  ```
 sudo java -Dlog4j.configurationFile=log4j2.xml  -jar topology-1.3.2-shaded.jar TMConfiguration_BGPLSreader_COPwriter.xml
  ```
 Sample configuration files are included. 

## Logging
The software is built using the slf4j, Simple Logging Facade for Java (SLF4J), which serves as a facade  for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end final to plug in the desired logging framework at deployment time.  See  http://www.slf4j.org/manual.html for more details.

Thus, you can choose your favourite logging framework.

However, as an example, there is a profile included (bgp-ls-speaker) to build an autoexecutable version of a BGP Peer that uses log4j http://logging.apache.org/log4j/2.x/ A sample configuration file (log4j2.xml) is provided and copied to the target directory. 

If no logging framework is added, by default it will log to /dev/null

# Examples

See [Examples](doc/Examples.md) for several Test scenarios of the BGP-LS Speaker and the Topology Modules.

# XML Format to describe the topology

See [TopologyFileDescription](doc/TopologyFileDescription.md)

#Acknowledgements

The software has been developed by Telefonica I+D Core & Transport Team, led by Juan Pedro Fernandez Palacios, in internal innovation projects and through several EU funded research proyects, which continuously added functionality. The Core & Transport Team group of Telefonica working with the topology is formed by Juan Pedro Fernandez Palacios (team leader), Victor Lopez, Oscar Gonzalez de Dios, Felipe Jiménez, Luis Miguel Contreras, Michel Carnero and Eduardo Yusta. All of them have contributed to the code, either directly of with ideas and as beta-testers.

The effort to release as open source of the code was funded by the E.U. CSA PACE. The code has been upgraded in the E.U. projects STRONGEST, PACE, IDEALIST, ACINO and 5GEx, as well as Telefonica Innovation activities.
The effort to release version 1.3.3 has been partially funded by 5GEx. Special thanks for the 5GEx team in the integration efforts.

The developers of the code are (some of them developed code before it was published in github, so they do not appear there as members): Oscar Gonzalez de Dios, Marta Cuaresma, Arturo Mayoral, Sergio, Alejandro Aguado, Jaume Marhuenda, Maria Victoria, Ruben Rosales, Jose Manuel Gran Josa, Victor Uceda, Andrea Sgambelluri (KTH) AND Victor Lopez.

The institutions contributing to the code are: Telefonica I+D (www.tid.es), KTH (https://www.kth.se/).

As the software is now open source, all contributors, indviduals and insititution will be listed in the Acknowledgement section.
