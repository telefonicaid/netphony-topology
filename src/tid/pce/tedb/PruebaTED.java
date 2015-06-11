package tid.pce.tedb;

import java.net.Inet4Address;
import java.util.Iterator;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.DijkstraShortestPath;
//import org.jgrapht.graph.IntraDomainEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PruebaTED {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTEDBUpdater tu= new FileTEDBUpdater();
		SimpleDirectedWeightedGraph<Object,IntraDomainEdge> networkGraph=tu.readNetwork("network1.xml");
		try 
		
			{
			Iterator<Object> it= networkGraph.vertexSet().iterator();
			while (it.hasNext()){
				System.out.println("Vertex: "+it.next());
			}
			
			
			Object source_router_id_addr = (Inet4Address) Inet4Address.getByName("172.16.101.102");
			System.out.println("Origen: "+ source_router_id_addr);
			
			Object dest_router_id_addr= (Inet4Address) Inet4Address.getByName("172.16.101.101");
	
		
		System.out.println("Computing path");
		long tiempoini =System.currentTimeMillis();
		DijkstraShortestPath<Object,IntraDomainEdge>  dsp=new DijkstraShortestPath<Object,IntraDomainEdge> (networkGraph, source_router_id_addr, dest_router_id_addr);
		GraphPath<Object,IntraDomainEdge> gp=dsp.getPath();
		long tiempofin =System.currentTimeMillis();
		long tiempotot=tiempofin-tiempoini;
		System.out.println("Ha tardado "+tiempotot+" milisegundos");
		
		List<IntraDomainEdge> edge_list=gp.getEdgeList();		 
		for (int i=0;i<edge_list.size();++i){
			System.out.println("IP origen es: "+edge_list.get(i).getSource().toString());
			System.out.println("IP destino es: "+edge_list.get(i).getTarget().toString());
			
//				try {
//					Object ipv4address;
//					ipv4address = (Object) Object.getByName(  ((IntraDomainEdge)edge_list.get(i)).   );
//					eroso.setIpv4address(ipv4address);
//					eroso.setPrefix(32);
//				} catch (UnknownHostException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}							
		 }
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
