# Topology XML File

This section describes the topology file format, used by the TADS to load the abstracted view of the local provider.

The reference file for this description is 

```
target/conf1wayTest/network1.xml
```

The main tag of the file is **network** that can include multiple **domains**, each domain represents a provider.

```xml
<network>
    <domain>
    </domain>
    <domain>
    </domain>
</network>
```

In this case the network topology includes two providers.

The first part of the each domain contains some general information:

 - **domain_id**: the AS number of the domain represented in IPv4 format 
 - the **reachability_entry**: that summarizes the prefix network for the provider (IPv4 network prefix and mask)
 - **it_resources**: here the information related to overall IT resources availability is described considering 
  - **controller_it**: the entry point for 5GEx orchestration
  - **cpu**: overall available CPUs
  - **mem**: overall available memory
  - **storage**: overall available storage

```xml
<domain_id>0.0.0.1</domain_id>
<reachability_entry>
    <ipv4_address>172.16.101.0</ipv4_address>
    <prefix>24</prefix>
</reachability_entry>
<it_resources>
    <controller_it>https://openstack.5Gex.com/url</controller_it>
    <cpu>100</cpu>
    <mem>100Gbyte</mem>
    <storage>100Tbyte</storage>
</it_resources>
```

Then the file is organized considering a list of nodes and a list unidirectional links.

Each node is represented with a tag **node** and is identified with an IPv4 id called **router_id**

```xml
<node>
    <router_id>172.16.101.101</router_id>
</node>
<node>
    <router_id>172.16.101.102</router_id>
</node>
<node>
    <router_id>172.16.101.103</router_id>
</node>
<node>
    <router_id>172.16.101.104</router_id>
</node>
```

In the reference case 4 nodes are considered.
Each link is identified by the tag **edge**.
The link description include:


 - **source**: the source node of the link, identified with the pair **router_id** and interface id, **if_id**
 - **destination**: the destination node of the link, identified with the pair router_id and interface
 - **TE parameters**: several possibilities are available, in the considered example the focus was on
  - unidirectional link delay
  - minimum experienced delay
  - maximum experienced delay

```xml
<edge>
    <source>
        <router_id>172.16.101.101</router_id>
        <if_id>1</if_id>
    </source>			
    <destination>
        <router_id>172.16.101.104</router_id>
        <if_id>1</if_id>
    </destination>	
    <undir_delay_link>99</undir_delay_link>
    <undir_min_max_delay>
        <min>23</min>
        <max>250</max>
    </undir_min_max_delay>	
</edge>

```

For setting up default TE parameters for all the network links, the **edgeCommon** tag is used.

```xml
<edgeCommon>
    <undir_delay_link>99</undir_delay_link>
    <undir_min_max_delay>
        <min>23</min>
        <max>43</max>	
    </undir_min_max_delay>	
    <undir_delay_variation>1</undir_delay_variation>
    <undir_link_loss>102</undir_link_loss>
    <undir_residual_bandwidth>802</undir_residual_bandwidth>
    <undir_available_bandwidth>500</undir_available_bandwidth>
    <undir_utilized_bandwidth>436</undir_utilized_bandwidth>	
</edgeCommon>
```
