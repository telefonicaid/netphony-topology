3.1.7	Sets of configuration files

Two sets of basic configuration files are here included with TADS software: the setup for running three TADS within the same machine (configuration A) and the setup for running three TADS in three dedicated machines (configuration B). In both cases three example network topologies are provided to represent the abstract topology of 2 end-point providers and 1 transit provider.

Configuration A

The setup has been provided just for testing purpose and configures 3 TADS in the same machine to perform unidirectional information exchange 

 

The reference files, including Topology Module configuration, BGP-LS Plugin configuration and abstracted topologies are in 
 

To execute TADS1 run:
 

To execute TADS2 run:
 

To execute TADS3 run:
 

To verify the retrieved information:
  
Configuration B
The setup has been provided as reference configuration for the configuration of 3 TADS in dedicated machines to perform bidirectional exchange of information 



 
The reference files, including Topology Module configuration, BGP-LS Plugin configuration and abstracted topologies are in
 

Before running the reference scenario be sure to complete the IP configuration in the 3 modules, in fact, according to previous description, minor ad-hoc changes are needed.

In the Topology Module configuration files (TM*.xml): 
•	set the IP address used for the BGP-LS communication as Identifier

In the BGP-LS Plugin configuration (BGPLS*_2way.xml):
•	set the IP address used for the BGP-LS communication as BGPIdentifier
•	configure the peers as needed (IP address and port) 

[where * = 1,2,3] 

To execute TADS1 in machine 1 run:
 

To execute TADS2 in machine 2 run:
 

To execute TADS3 in machine 3 run:
 

To verify the retrieved information:
 

