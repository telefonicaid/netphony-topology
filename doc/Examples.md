#Examples 

##Topology Module Examples

Two sets of basic configuration files are here included with Topology Module software: the setup for running three TM within the same machine (configuration A) and the setup for running three TM in three dedicated machines (configuration B). In both cases three example network topologies are provided to represent the abstract topology of 2 end-point providers and 1 transit provider.

### Example TM1: 1 Way Test in the same virtual machine, BPG-LS Plugin and UNIFY Export.

The setup has been provided just for testing purpose and configures 3 TADS in the same machine to perform unidirectional information exchange.

![1WayTest](figures/1wayTest.png?raw=true "Test with 3 TM")

The reference files, including Topology Module configuration, BGP-LS Plugin configuration and abstracted topologies are copiend in the folder target/conf1wayTest after the maven installation. Be sure to compile also the Topology Module as indicated in README.md. 

To execute TM1 run:
  ```bash
  sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM1.xml
  ```

To execute TM2 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM2.xml
  ```

To execute TM3 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM3.xml
  ```

To verify the retrieved information:
  ```bash
curl http://localhost:8087/restconf/data/virtualizer/ | python -m json.tool     
  ```
[for TADS2]
  ```bash
curl http://localhost:8088/restconf/data/virtualizer/ | python -m json.tool     
  ```
[for TADS3]
  ```bash
curl http://localhost:8089/restconf/data/virtualizer/ | python -m json.tool
   ```
  
### Example TM2:   2 Way Test in the different virtual machines, BPG-LS Plugin and UNIFY Export.
The setup has been provided as reference configuration for the configuration of 3 TM in dedicated machines to perform bidirectional exchange of information 
![1WayTest](figures/2wayTest.png?raw=true "Test with 3 TM in 3 different machines")
The reference files, including Topology Module configuration, BGP-LS Plugin configuration and abstracted topologies are in
   ```bash
target/conf2waysReal
  ```
Before running the reference scenario be sure to complete the IP configuration in the 3 modules, in fact, according to previous description, minor ad-hoc changes are needed.

In the Topology Module configuration files (TM*.xml): 
•	set the IP address used for the BGP-LS communication as Identifier

In the BGP-LS Plugin configuration (BGPLS*_2way.xml):
•	set the IP address used for the BGP-LS communication as BGPIdentifier
•	configure the peers as needed (IP address and port) 

[where * = 1,2,3] 

To execute TADS1 in machine 1 run:
  ```bash
  sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM1.xml
  ```

To execute TADS1 in machine 2 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM2.xml
  ```

To execute TADS1 in machine 3 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/topology-1.3.3-shaded.jar target/conf1wayTest/TM3.xml
  ```

To verify the retrieved information:
[for TADS2, in machine 1]
  ```bash
curl http://localhost:8088/restconf/data/virtualizer/ | python -m json.tool     
  ```
[for TADS2, in machine 2]
  ```bash
>curl http://localhost:8088/restconf/data/virtualizer/ | python -m json.tool     
  ```
[for TADS3, in machine 3]
  ```bash
>curl http://localhost:8088/restconf/data/virtualizer/ | python -m json.tool
   ```
###  Topology module with BGP-LS and COP plugins and BGP-LS speaker

In this example there are 2 BGP-LS speakers, one acting as sender of topology, and the other as consumer. A small topology is loaded from an xml file in BGP-LS Speaker #1. This topology is sent to BGP-LS Speaker #2.  
  ```bash
TBD
  ```
### Topology module with BGP-LS and COP plugins and Topology module with BGP-LS speaker

In this example there are 2 BGP-LS speakers, one acting as sender of topology, and the other as consumer. A small topology is loaded from an xml file in BGP-LS Speaker #1. This topology is sent to BGP-LS Speaker #2.  
  ```bash
TBD
  ```
## BGP-LS Speaker Examples

### BPP-LS Speaker Example 1  

In this example there are 2 BGP-LS speakers, one acting as sender of topology, and the other as consumer. A small topology is loaded from an xml file in BGP-LS Speaker #1. This topology is sent to BGP-LS Speaker #2.  
To launch BGP-LS Speaker #1:
  ```bash
sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/bgp-ls-speaker-jar-with-dependencies.jar target/bgpls_example1/BGP4Parameters_1.xml
 ```
 BGP-LS Speaker #2:
  ```bash
sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar target/bgp-ls-speaker-jar-with-dependencies.jar target/bgpls_example1/BGP4Parameters_2.xml
 ```
To verify the retrieved information:
  ```bash
telnet localhost 1112
show topology
 ```
Then, the topology is printed on screen.
