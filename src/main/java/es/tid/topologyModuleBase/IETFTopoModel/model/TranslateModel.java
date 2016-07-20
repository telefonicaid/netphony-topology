package es.tid.topologyModuleBase.IETFTopoModel.model;

import es.tid.tedb.DomainTEDB;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.TEDB;
import es.tid.topologyModuleBase.COPServiceTopology.model.Node;
import static es.tid.topologyModuleBase.COPServiceTopology.model.TranslateModel.translateNode;
import static es.tid.topologyModuleBase.COPServiceTopology.model.TranslateModel.translateNodeIp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to translate TEDB model to a topology container following 
 * IETEF model.
 */
public class TranslateModel {
    /**
     * This method translate a MultiDomainTEDB object to a NetworksSchemaNetwork
     * @param topId String with the identification for the current multi domain
     * model.
     * @param ted MultiDomainTEDB object.
     * @return Network topology container object.
     */
    public static NetworksSchemaNetwork translateTopology(String topId, MultiDomainTEDB ted){
        // TODO: Need to be developed.
        NetworksSchemaNetwork topology = common(topId, ted);
        // LinkedList<InterDomainEdge> ted.getInterDomainLinks();
        /*List<InterDomainEdge> node = new ArrayList<InterDomainEdge>();
        for(InterDomainEdge link : ted.getInterDomainLinks()){
			  node.add(translateEdge(ted, link));
		  }
        topology.setNode(node);
		  topology.setNode(node);.setEdges(node);
        */
        return topology;

    }
    
    /**
     * This method translate a DomainTEDB object to a NetworksSchemaNetwork
     * @param topId String with the identification for the current domain model.
     * @param ted DomainTEDB object.
     * @return Network topology container object.
     */
    public static NetworksSchemaNetwork translateTopology(String topId, DomainTEDB ted) {
        NetworksSchemaNetwork topology = common(topId, ted);
	List<NetworksSchemaNode> edges = new ArrayList<NetworksSchemaNode>();
		  
        List<Node> nodes = new ArrayList<Node>();
        for(Object node : ted.getIntraDomainLinksvertexSet()){
             if(node instanceof es.tid.tedb.elements.Node){
                     nodes.add(translateNode(ted, (es.tid.tedb.elements.Node)node));
             }
             else if(node instanceof java.net.Inet4Address){
                     nodes.add(translateNodeIp(ted, (java.net.Inet4Address)node, ted.getNodeTable().get(node)));
             }
        }
        topology.setNode(edges);
        return topology;
    }
    
    /**
     * Common code for the previous methods.
     * @param topId String with the identification for the current domain model.
     * @param ted TEDB object.
     * @return Initialized NetworksSchemaNetwork object.
     */
    private static NetworksSchemaNetwork common(String topId, TEDB ted){
        NetworksSchemaNetwork topology = new NetworksSchemaNetwork();
        topology.setNetworkId(topId);
        return topology;
    }
}
