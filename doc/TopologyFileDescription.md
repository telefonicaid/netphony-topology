# Topology XML File
This section describes the topology file format, used by the TM to load the abstracted view of the local provider.

The reference file for this description is 
 
The main tag of the file is network that can include multiple domains, each domain represents a provider.
 

In this case the network topology includes two providers.

The first part of the each domain contains some general information:

•	domain_id: the AS number of the domain represented in IPv4 format 
•	the reachability_entry: that summarizes the prefix network for the provider (IPv4 network prefix and mask)
•	it_resources: (optional) here the information related to overall IT resources availability is described considering 
o	controller_it: the entry point for 5GEx orchestration
o	cpu: (optional) overall available CPUs
o	mem: (optional) overall available memory
o	storage: (optional) overall available storage

 
Then the file is organized considering a list of nodes and a list unidirectional links.

Each node is represented with a tag node and is identified with an IPv4 id called router_id

In the reference case 4 nodes are considered.
Each link is identified by the tag edge.
The link description include:
•	source: the source node of the link, identified with the pair router_id and interface id, if_id
•	destination: the destination node of the link, identified with the pair router_id and interface
•	TE parameters: several possibilities are available, in the considered example the focus was on
o	unidirectional link delay
o	minimum experienced delay
o	maximum experienced delay
 


For setting up default TE parameters for all the network links, the edgeCommon tag is used.


In the reported example, all the TE implemented parameters are reported.

Each edge represents a unidirectional link. In case of bidirectional link, two edges have to be used.

The description of an intra-domain link is substantially the same of an inter-domain link.

 
The main differences are:
•	inter-domain links are always described as unidirectional (only the exiting link from the local provider point of view);
•	source node is always an internal node, the destination node is in another domain (source node is in 172.16.101.0/24 while destination node is in 172.16.1020/24).

The second consideration requires that the topology files contains a minimal description of each connected domain, including the information of the node destination of the inter-domain link. No other internal information of other domain are needed. For the reference example, the domain with ID 0.0.0.2 and the node 172.16.102.101 is included in the topology file, 

  
