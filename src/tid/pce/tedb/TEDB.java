package tid.pce.tedb;

import java.util.LinkedList;

/**
 * Base de datos de ingenieria de trafico
 * CLASE DE PRUEBA REESTRUCTURAR DESPUES!!!!!!!!!!
 * @author ogondio
 *
 */
public interface TEDB {
//	//private long graphId;
//	//private SimpleDirectedWeightedGraph<Inet4Address,IntraDomainEdge> networkGraph;
//	//public SimpleDirectedWeightedGraph<Integer,IntraDomainEdge> grafo;
//	
//	public SimpleDirectedWeightedGraph<Inet4Address, IntraDomainEdge> getDuplicatedNetworkGraph();
//	
//	public DirectedWeightedMultigraph<Inet4Address, InterDomainEdge> getDuplicatedMDNetworkGraph();
//
//	
	public void initializeFromFile(String file);

	public boolean isITtedb();
	
	public String printTopology();

	public LinkedList<InterDomainEdge> getInterDomainLinks();
	
//	{
//		networkGraph=FileTEDBUpdater.readNetwork(file);		
//	}
	
//	public long getGraphId();
////	{
////		return graphId;
////	}
//	public void setGraphId(long graphId);
////	{
////		this.graphId = graphId;
////	}
//	
//	public boolean belongsToDomain(Inet4Address addr);
//	
	
	

}
