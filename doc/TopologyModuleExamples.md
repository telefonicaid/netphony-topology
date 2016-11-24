#Examples 

##Topology Module Examples

Two sets of basic configuration files are here included with Topology Module software: the setup for running three TM within the same machine (configuration A) and the setup for running three TM in three dedicated machines (configuration B). In both cases three example network topologies are provided to represent the abstract topology of 2 end-point providers and 1 transit provider.

### Configuration A: 1 Way Test in the same virtual machine

The setup has been provided just for testing purpose and configures 3 TADS in the same machine to perform unidirectional information exchange.

![1WayTest](/ifigures/1wayTest.png?raw=true "Test with 3 TM")

The reference files, including Topology Module configuration, BGP-LS Plugin configuration and abstracted topologies are in the folder:
  ```bash
target/conf1wayTest
  ```

To execute TM1 run:
  ```bash
  sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar topology-1.3.2-shaded.jar target/conf1wayTest/TM1.xml
  ```

To execute TM2 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar topology-1.3.2-shaded.jar target/conf1wayTest/TM2.xml
  ```

To execute TM3 run:
   ```bash
 sudo java -Dlog4j.configurationFile=target/log4j2.xml  -jar topology-1.3.2-shaded.jar target/conf1wayTest/TM3.xml
  ```

To verify the retrieved information:
  
## Configuration B
The setup has been provided as reference configuration for the configuration of 3 TM in dedicated machines to perform bidirectional exchange of information 

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
 

