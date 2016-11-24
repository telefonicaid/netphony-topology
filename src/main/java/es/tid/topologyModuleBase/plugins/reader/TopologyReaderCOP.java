package es.tid.topologyModuleBase.plugins.reader;


import java.io.File;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.MaximumBandwidth;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.TEDB;
import es.tid.tedb.TE_Information;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.COPServiceTopology.client.ApiClient;
import es.tid.topologyModuleBase.COPServiceTopology.client.ApiException;
import es.tid.topologyModuleBase.COPServiceTopology.client.Configuration;
import es.tid.topologyModuleBase.COPServiceTopology.client.api.DefaultApi;
import es.tid.topologyModuleBase.COPServiceTopology.model.EdgeEnd;
import es.tid.topologyModuleBase.COPServiceTopology.model.TopologiesSchema;
import es.tid.topologyModuleBase.COPServiceTopology.model.Edge.EdgeTypeEnum;
import es.tid.topologyModuleBase.COPServiceTopology.model.*;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.reader.TopologyReader;

public class TopologyReaderCOP extends TopologyReader
{

	private boolean isRunning=false;

	public TopologyReaderCOP(TopologiesDataBase ted,TopologyModuleParams params, Lock lock)
	{
		super(ted,params,lock);
	}

	@Override
	public void readTopology() 
	{
		
		//Initialize Traffic Engineering Database
		/*ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://"+params.getRemoteCOPhost()+":"+params.getRemoteCOPPort()+"/restconf");
		readNetwork(new DefaultApi(apiClient));
		*/
		ApiClient defaultClient = new ApiClient();
		defaultClient.setBasePath("http://"+params.getRemoteCOPhost()+":"+params.getRemoteCOPPort()+"/restconf");
		log.info("New COPTopologyReader trying to read topology from: "+defaultClient.getBasePath());
		//Timer timer = new Timer();
		//timer.schedule(new ReadTopologyTask(ted,lock,new DefaultApi(defaultClient)), 0, 20000);
		(new ReadTopologyTask(ted,lock,new DefaultApi(defaultClient))).run();

	}
	@Override
	public void run(){
		readTopology();
	}
 private class ReadTopologyTask extends TimerTask {
		private TopologiesDataBase ted;
		private Lock lock;
		private DefaultApi api;
		
		
		
		public ReadTopologyTask(TopologiesDataBase ted, Lock lock, DefaultApi api) {
			super();
			this.ted = ted;
			this.lock = lock;
			this.api = api;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			lock.lock();
			isRunning=true;
			try {
				TopologiesSchema retrieveTopologies = api.retrieveTopologies();
				//EdgeEnd retrieveLocalIf = api.retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById("1", "ADVA_2_CTTC_2");
				//log.info(retrieveTopologies.toString());
				//System.out.println("DESPUES retrieveTopologies: "+retrieveTopologies.toString());
				//Topology top = api.retrieveTopologiesTopologyTopologyById("0.0.0.1");
			
				
				for(Topology top : retrieveTopologies.getTopology()){
					
					DomainTEDB db = (DomainTEDB)this.ted.getDB(top.getTopologyId());
					System.out.println("COP reader, reading db with domainID: "+top.getTopologyId()+ " bd->"+db);
					if(db != null){
						ted.getTeds().remove(top.getTopologyId());
					}
					db = new SimpleTEDB();
					((SimpleTEDB)db).createGraph();
						
					for(Node n : top.getNodes()){
						es.tid.tedb.elements.Node node = TranslateModel.translate2Node(n);
						((SimpleTEDB)db).getNetworkGraph().addVertex(node);
					}
					for(Edge e: top.getEdges()){
						es.tid.tedb.elements.Link link = TranslateModel.translate2Link(e);
						fromLinkToIntradomainlink((SimpleTEDB)db, link, e);
					}
					
					this.ted.addTEDB(top.getTopologyId(), db);
					
				}
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				log.info("APIException in COPtopologyReader from: " + api.getApiClient().getBasePath());
				e.printStackTrace();
			}catch (Exception e){
				log.info("GeneralException in COPtopologyReader from: " + api.getApiClient().getBasePath());
				e.printStackTrace();
			}finally{
				isRunning=false;
				lock.unlock();
			}
		}

		private void fromLinkToIntradomainlink(SimpleTEDB db, es.tid.tedb.elements.Link link, Edge e){
			boolean finished=false;
			System.out.println("From link To Intradomianlink, link: "+link.toString());
			Iterator<Object> vertices=db.getNetworkGraph().vertexSet().iterator();
			es.tid.tedb.elements.Node src=null; es.tid.tedb.elements.Node dst=null;
			while (vertices.hasNext() && !finished){
				es.tid.tedb.elements.Node node=(es.tid.tedb.elements.Node) vertices.next();
				System.out.println("Nodes in graph: "+node.getNodeID());
				if (link.getDest().getNode().equals(node.getNodeID()))
					dst=node;
				else if (link.getSource().getNode().equals(node.getNodeID()))
					src=node;
	
			}
			IntraDomainEdge edge= new IntraDomainEdge();
			edge.setBw(link.getBandwidth());
			edge.setDirectional(link.isDirectional());
			edge.setLinkID(link.getLinkID());
			edge.setType(link.getType());
			edge.setDst_Numif_id(link.getDest());
			edge.setSrc_Numif_id(link.getSource());
			if (src==null){
				log.info("SRC NULL");
			}
			if (dst==null){
				log.info("DST NULL");
			}
			if(link.getType().equals(EdgeTypeEnum.dwdm_edge.toString())){
				DwdmEdge dEdge = (DwdmEdge)e;
				TE_Information tE_info= new TE_Information();
				//tE_info.createBitmapLabelSet(numLabels, grid,  cs, n);
				
				byte[] bitmap=new byte[(dEdge.getBitmap().getNumChannels()/8)+1];
				for(int i=0;i<dEdge.getBitmap().getNumChannels();i++){
					if(dEdge.getBitmap().getArrayBits().get(i)==1){
						bitmap[i/8]|=(128 >>(i%8));
					}
				}
				((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).setNumLabels(dEdge.getBitmap().getNumChannels());
				((BitmapLabelSet)edge.getTE_info().getAvailableLabels().getLabelSet()).setBytesBitmap(bitmap);
				edge.setTE_info(tE_info);
			}
	
			db.getNetworkGraph().addEdge(src, dst, edge);
			db.getIntraDomainEdges().add(edge);
	
		}

	

		/*public static String getCharacterDataFromElement(Element e) {
			org.w3c.dom.Node child = e.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				return cd.getData();
			} else {
				return "?";
			}
		}*/
 
 }
@Override
public boolean isRunning() {
	// TODO Auto-generated method stub
	return isRunning;
}

@Override
public String getPluginName() {
	// TODO Auto-generated method stub
	return "COP client-importer";
}

@Override
public String displayInfo() {
	// TODO Auto-generated method stub
	String str=getPluginName()+"\n";
	str+="Status: ";
	if(isRunning())str+="running";
	else str+="stop";
	str+="\nBase path:"+"http://"+params.getRemoteCOPhost()+":"+params.getRemoteCOPPort()+"/restconf";
	return str;
}
}
