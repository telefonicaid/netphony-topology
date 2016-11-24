package es.tid.topologyModuleBase.session.ws;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.json.JSONObject;

import es.tid.topologyModuleBase.database.TopologiesDataBase;

import com.google.gson.Gson;

import es.tid.provisioningManager.objects.Topology;
import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;
import es.tid.tedb.elements.Bandwidth;
import es.tid.tedb.elements.EndPoint;
import es.tid.tedb.elements.Intf;
import es.tid.tedb.elements.Link;
import es.tid.tedb.elements.Location;
import es.tid.tedb.elements.Node;
import es.tid.topologyModuleBase.util.UtilsFunctions;


/**
 *  
 * This class reads and process the messages received from the web service. 
 * Once they are processed it sends the response.
 * 
 * The message structure is
 * <pre>
 *       0                   1                   2                   3
 *      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
 *     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *     |  Class 	    |   Operation    |            Length           |
 *     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *     |                     Web service message                  	   |
 *     :                                                               :
 *     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * </pre>
 * 
 * @author Telefonica I+D
 *
 */
public class WSOldSession extends Thread{

	/**
	 * The socket where the JSON message is received
	 */
	private Socket socket;
	/**
	 * Data input to read the messages
	 */
	private DataInputStream in;	
	/**
	 * Data output to send the responses
	 */
	private DataOutputStream out;	
	/**
	 * Topology module log File
	 */
	Logger log;
	
	private TopologiesDataBase ted;
	
	public WSOldSession(Socket s, TopologiesDataBase ted ){
		this.socket=s;
		log=Logger.getLogger("TopologyModule");
		this.ted=ted;

	}

	/**
	 * Run
	 */
	public void run (){
		log.info("TCPOSPF Socket opened: "+socket);
		boolean salir=true;
		try {
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (salir){
			boolean readMessage = true; 
			byte[] topologyModuleMessage = null;
			while(readMessage) {			
				try {
					topologyModuleMessage = readMsg(in);
					if (topologyModuleMessage != null){
						readMessage = false;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.warning("topology Module Socket ends");
					return;
				}
			}
			JSONObject jsonObject = null;
			int classToCall = getClassToCall(topologyModuleMessage);
			try{
				if (classToCall == TopologyModuleMessageTypes.TOPOLOGY_UPDATER_CLASS){
					log.info("TOPOLOGY_MODULE_CLASS");			
					int opetationType= getOperationType(topologyModuleMessage);
					switch (opetationType){
					case TopologyModuleMessageTypes.UPDATE_NODE_OP:{		
						log.info("UPDATE_NODE");
						int length=getMessageLength(topologyModuleMessage);                	 
						byte[] requestDone=new byte[(length)];	
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						String jsonString = new String (requestDone);
						jsonObject = new JSONObject(jsonString);
						Node node = new Node();							 
						//Mandatory fields
						try{
							//NodeName
							String nodeID = (String) jsonObject.getString("nodeName");
							node.setNodeID(nodeID);
							String address = (String) jsonObject.getString("address");
							ArrayList<String> addressList = new ArrayList<String>();							
							node.setAddress(addressList);	
							addressList.add(address);	
							int domain = jsonObject.getInt("domain");
							node.setDomain(domain);
							String layerNode = (String) jsonObject.getString("layerNode");
							node.setLayer(layerNode);
						}catch (NoSuchElementException e)
						{							
							sendResponse("ERROR: JSON incorrectly written. Needed: nodeName, address, domain, layerNode.");							
							break;
						}
					
						//Optional Parameters
						try{
							//Location
							double xLocation = (Double) Double.parseDouble(jsonObject.getString("xLocation"));
							double yLocation = (Double) Double.parseDouble(jsonObject.getString("yLocation"));
							Location location = new Location(xLocation,yLocation);
							node.setLocation(location);
							
						}catch (NoSuchElementException e)
						{							
							
						}	
						try{
							//Parent Router
							String parentRouter = (String) jsonObject.getString("parentRouter");
							node.setParentRouter(parentRouter);							
						}catch (NoSuchElementException e)
						{							
							
						}
						try{	
							//Is physical
							boolean isPhysical = jsonObject.getBoolean("isPhysical");
							node.setPhysical(isPhysical);
						}catch (NoSuchElementException e)
						{							
							
						}
						//FIXME: Add update vertex (should be easy) DONE!!
						//boolean responseBoolean = this.topologyUpdater.updateNode(node);
						
						((SimpleTEDB)ted.getDB()).getNetworkGraph().addVertex(node);
						
						String response = String.valueOf(true);
						sendResponse(response);					
						break;
					}
					case TopologyModuleMessageTypes.UPDATE_LINK_OP:{
						log.info("UPDATE_LINK");
						int length=getMessageLength(topologyModuleMessage);
						byte[] requestDone=new byte[(length)];	
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						Link link = new Link();	
						String layerLink = null;
						String jsonString = new String (requestDone);
						log.info("json en upsate_link: "+jsonString);
						jsonObject = new JSONObject(jsonString);
						//Mandatory Parameters
						try{
							String linkID = (String) jsonObject.getString("linkID");						
							String nodeSource = (String) jsonObject.getString("srcNode");
							String intfSource = (String) jsonObject.getString("srcIntf");
							String nodeDest = (String) jsonObject.getString("dstNode");
							String intfDest = (String) jsonObject.getString("dstIntf");
							layerLink = (String) jsonObject.getString("layerLink");
							Gson gson= new Gson();
							Bandwidth bw=gson.fromJson(jsonObject.getString("bandwidth"), Bandwidth.class);
							link.setLinkID(linkID);
							EndPoint source = new EndPoint(nodeSource,intfSource);
							EndPoint dest = new EndPoint(nodeDest,intfDest);
							link.setSource(source);
							link.setDest(dest);
							link.setBandwidth(bw);
						}catch (NoSuchElementException e)
						{	
							sendResponse("ERROR: JSON incorrectly written. Needed: linkID, srcNode, srcIntf, dstNode, dstIntf, layerLink.");							
							break;
						}
						//Optional Parameters
						try{
							String typeLink = (String) jsonObject.getString("typeLink");
							link.setType(typeLink);
						}catch (NoSuchElementException e)
						{							

						}
						try{
							boolean isDirectional = (Boolean) jsonObject.getBoolean("isDirectional");
							link.setDirectional(isDirectional);
						}catch (NoSuchElementException e)
						{							
							link.setDirectional(null);
						}
						try{
							double teMetric = (Double) Double.parseDouble(jsonObject.getString("teMetric"));
							link.setTeMetric(teMetric);
						}catch (NoSuchElementException e)
						{							
							link.setTeMetric(-1);
						}
						//FIXME: Add Update Link (Should be easy) DONE!!
						//boolean responseBoolean = this.topologyUpdater.updateLink(layerLink,link);
						
						
						boolean finished=false;
						Iterator<Object> vertices=((SimpleTEDB)this.ted.getDB()).getNetworkGraph().vertexSet().iterator();
						Node src=null; Node dst=null;
						while (vertices.hasNext() && !finished){
							Node node=(Node) vertices.next();
							if (link.getDest().getNode().equals(node.getNodeID()))
								dst=node;
							else if (link.getSource().getNode().equals(node.getNodeID()))
								src=node;
							
						}
						IntraDomainEdge edge= new IntraDomainEdge();
						edge.setBw(link.getBandwidth());
						edge.setDirectional(true);
						edge.setLinkID(link.getLinkID());
						edge.setType(link.getType());
						edge.setDst_Numif_id(link.getDest());
						edge.setSrc_Numif_id(link.getSource());
						
						IntraDomainEdge aux=((SimpleTEDB)this.ted.getDB()).getNetworkGraph().getEdge(src, dst);
						findAndDeleteToUpdateANewEdge(edge);
						
						if (aux==null){
							((SimpleTEDB)this.ted.getDB()).getNetworkGraph().addEdge(src, dst, edge);

						}
						else{
							((SimpleTEDB)this.ted.getDB()).getNetworkGraph().removeEdge(aux);
							((SimpleTEDB)this.ted.getDB()).getNetworkGraph().addEdge(src, dst, edge);
						}
						((SimpleTEDB)this.ted.getDB()).getIntraDomainEdges().add(edge);

						sendResponse(String.valueOf(true));												
						break;

					}
					case TopologyModuleMessageTypes.UPDATE_INTERFACE_OP:{
						//IDLE
						log.info("UPDATE_INTERFACE");
						int length=getMessageLength(topologyModuleMessage);

						byte[] requestDone=new byte[(length)];	
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						Intf intf = new Intf();
						String nodeID;
						String jsonString = new String (requestDone);
						jsonObject = new JSONObject(jsonString);
						//Mandatory Parameters
						try{	
							nodeID = (String) jsonObject.getString("nodeName");
							String nameIntf = (String) jsonObject.getString("intfName");
							String address = (String) jsonObject.getString("address");
							String layering = (String) jsonObject.getString("layering");
							ArrayList<String> addressList = new ArrayList<String>();
							addressList.add(address);
							ArrayList<String> layeringList = new ArrayList<String>();
							layeringList.add(layering);
						
							intf.setAddress(addressList);
							intf.setName(nameIntf);
							intf.setLayering(layeringList);
						}catch (NoSuchElementException e)
						{							
							sendResponse("ERROR: JSON incorrectly written. Needed: nodeName, intfName, address, layering.");														
							break;
						}
						
						try{
							boolean isPhysical = (Boolean) jsonObject.getBoolean("isPhysical");
							intf.setPhysical(isPhysical);
						}catch (NoSuchElementException e)
						{							
							intf.setPhysical(null);
						}
						try{
							boolean intfUp = (Boolean) jsonObject.getBoolean("intfUp");
							intf.setIntfUp(intfUp);
						}catch (NoSuchElementException e)
						{							
							intf.setIntfUp(null);
						}
						//String parentInterfaceName = (String) jsonObject.getString("parentInterfaceName");
						//intf.setParentInterfaceName(parentInterfaceName);
//						boolean responseBoolean = this.topologyUpdater.updateIntf(nodeID,intf);
//						sendResponse(String.valueOf(responseBoolean));						
						break;
					}
					case TopologyModuleMessageTypes.UPDATE_ALL_OP:{

						break;
					}
					case TopologyModuleMessageTypes.DELETE_NODE_OP:{
						log.info("DELETE_NODE_OP");						
						String nodeName=null;
						int length=getMessageLength(topologyModuleMessage);				
						byte[] requestDone=new byte[(length)];
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						String jsonString = new String (requestDone);
						jsonObject = new JSONObject(jsonString);
						//Mandatory Parameters
						try{		            			 
							nodeName = (String) jsonObject.getString("nodeName");
						}catch (NoSuchElementException e)
						{							
							sendResponse("ERROR: JSON incorrectly written. Needed: nodeName.");														
							break;
						}
						//FIXME: Delete Node (Should be easy)
						//boolean responseBoolean = topologyUpdater.deleteNode(nodeName);
						
						Iterator<Object> nodeiter=((SimpleTEDB)ted.getDB()).getNetworkGraph().vertexSet().iterator();
						boolean finished=false;
						Node target=null;
						while ((nodeiter.hasNext())&&!finished){
							Node node=(Node) nodeiter.next();
							if (node.getNodeID().equals(nodeName)){
								target=node;
								finished=true;
							}
						}
						if (target==null){
							sendResponse(String.valueOf(false));						
						}else{
							((SimpleTEDB)ted.getDB()).getNetworkGraph().removeVertex(target);
							sendResponse(String.valueOf(true));							
						}
						break;
					}
					case TopologyModuleMessageTypes.DELETE_INTERFACE_OP:{
						//IDLE
						log.info("DELETE_INTERFACE_OP");						
						String nodeName=null;
						String intfName=null;
						int length=getMessageLength(topologyModuleMessage);				
						byte[] requestDone=new byte[(length)];
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						String jsonString = new String (requestDone);
						jsonObject = new JSONObject(jsonString);
						//Mandatory Parameters
						try{		            			 
							nodeName = (String) jsonObject.getString("nodeName");
							intfName = (String) jsonObject.getString("intfName");
						}catch (NoSuchElementException e)
						{							
							sendResponse("ERROR: JSON incorrectly written. Needed: nodeName, intfName.");														
							break;
						}
//						boolean responseBoolean = topologyUpdater.deleteIntf(nodeName, intfName);
//						sendResponse(String.valueOf(responseBoolean));						
						break;
					}
					case TopologyModuleMessageTypes.DELETE_LINK_OP:{
						log.info("DELETE_LINK_OP");						
						String linkID=null;
						int length=getMessageLength(topologyModuleMessage);				
						byte[] requestDone=new byte[(length)];
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						String jsonString = new String (requestDone);
						jsonObject = new JSONObject(jsonString);
						//Mandatory Parameters
						try{	            			 
							linkID = (String) jsonObject.getString("linkID");
						}catch (NoSuchElementException e)
						{							
							sendResponse("ERROR: JSON incorrectly written. Needed: linkID.");														
							break;
						}
						//FIXME: Delete link (Should be easy)
						//boolean responseBoolean = topologyUpdater.deleteLink(linkID);
						
						boolean finished=false;
						Iterator<IntraDomainEdge> iteredges=((SimpleTEDB)ted.getDB()).getNetworkGraph().edgeSet().iterator();
						IntraDomainEdge target=null;

						while (iteredges.hasNext() && !finished){
							IntraDomainEdge auxedge=iteredges.next();
							if (auxedge.getLinkID().equals(linkID)){
								target=auxedge;
							}				
						}
						if (target==null){
							sendResponse(String.valueOf(false));
						}else {
							((SimpleTEDB)ted.getDB()).getNetworkGraph().removeEdge(target);
							sendResponse(String.valueOf(true));
						}
						break;
					}


					}
				}
				else if (classToCall == TopologyModuleMessageTypes.INFORMATION_RETRIEVER_CLASS){
					log.info("INFORMATION_RETRIEVER_CLASS");
					int opetationType= getOperationType(topologyModuleMessage);
					log.info("opetationType:"+opetationType);

					switch (opetationType){
					case TopologyModuleMessageTypes.GET_FULL_TOPOLOGY_OP:{		
						log.info("GET_FULL_TOPOLOGY_OP");
						//String networkName=null;
						String layerString=null;
						String domainId=null;
						int length=getMessageLength(topologyModuleMessage);				
						byte[] requestDone=new byte[(length)];
						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
						String jsonString = new String (requestDone);

						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
						//networkName= (String) jsonObject.getString("networkName");
						String fullTopology = null;
						//Mandatory Parameters
						
						fullTopology=buildFullTopology();
//						try{
//							domainId = (String) jsonObject.get("domainID");
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: domainID.");							
//							break;
//						}
//						//Optional Parameter
//						try{
//							layerString = (String) jsonObject.getString("layer");
//							fullTopology = informationRetriever.getFullTopology(layerString,domainId);
//						}
//						catch (NoSuchElementException e)
//						{
//							//FIXME: Build fulltopology and send it (other function, no so easy)
//							fullTopology = informationRetriever.getFullTopology(domainId);
//						}	
						sendResponse(fullTopology);
						break;
					} //IDLE
//					case TopologyModuleMessageTypes.GET_NEIGHBOUR_NODES_OP:{
//						log.info("GET_NEIGHBOUR_NODES_OP");
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
//						String nodeID ;
//						//Mandatory Parameters
//						try{
//							nodeID = (String) jsonObject.getString("nodeName");    
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: nodeName.");							
//							break;
//						}
//						ArrayList<Node> neighbours = informationRetriever.getNeighbourNodesOf(nodeID);
//						String response="null";
//						if (neighbours.size() > 0)
//							response = convertNodes(neighbours);
//						sendResponse(response);
//						break;
//					}
//					case TopologyModuleMessageTypes.GET_OPPOSITE_NODE_OP:{
//						log.info("GET_OPPOSITE_NODE_OP");
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//						jsonObject = new JSONObject(jsonString); 	
//						Intf intf = new Intf();
//						//Mandatory Parameters
//						try{
//							String nameInterface= (String) jsonObject.getString("intfName"); 					
//							ArrayList<String> addressList = new ArrayList<String> ();						
//							addressList.add((String) jsonObject.getString("address"));
//							ArrayList<String> layerList = new ArrayList<String> ();					
//							layerList.add( (String) jsonObject.getString("layer"));
//
//							intf.setName(nameInterface);
//							intf.setAddress(addressList);
//							intf.setLayering(layerList);					
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: intfName,address,layer.");							
//							break;
//						}
//						try{
//							Boolean isPhysical = (Boolean) jsonObject.getBoolean("isPhysical");			
//							intf.setPhysical(isPhysical);
//						}
//						catch (ClassCastException e){
//							sendResponse("ERROR: JSON incorrectly written. isPhysical must be a boolean (true or false).");							
//							break;
//						}
//						catch (NoSuchElementException e)
//						{							
//						}				
//						try{
//							String parentInterfaceName=(String) jsonObject.getString("parentIntfName");
//							intf.setParentInterfaceName(parentInterfaceName);
//						}
//						catch (NoSuchElementException e)
//						{							
//						}
//						sendResponse(informationRetriever.getOppositeNode(intf));
//					
//						break;
//					}
//					case TopologyModuleMessageTypes.GET_OPPOSITE_INTERFACE_OP:{
//						log.info("GET_OPPOSITE_INTERFACE_OP");
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
//						Intf intf = new Intf();
//						try{
//							String nameInterface= (String) jsonObject.getString("intfName"); 					
//							ArrayList<String> addressList = new ArrayList<String> ();						
//							addressList.add((String) jsonObject.getString("address"));
//							ArrayList<String> layerList = new ArrayList<String> ();					
//							layerList.add( (String) jsonObject.getString("layer"));
//
//							intf.setName(nameInterface);
//							intf.setAddress(addressList);
//							intf.setLayering(layerList);					
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: intfName,address,layer.");							
//							break;
//						}
//						try{
//							Boolean isPhysical = (Boolean) jsonObject.getBoolean("isPhysical");			
//							intf.setPhysical(isPhysical);
//						}
//						catch (NoSuchElementException e)
//						{							
//						}				
//						try{
//							String parentInterfaceName=(String) jsonObject.getString("parentIntfName");
//							intf.setParentInterfaceName(parentInterfaceName);
//						}
//						catch (NoSuchElementException e)
//						{							
//						}
//
//						sendResponse(informationRetriever.getOppositeInterface(intf));						
//						break;
//					}
//					case TopologyModuleMessageTypes.MEASUREMENT_MODULE_OP:{		
//						log.info("MEASUREMENT_MODULE");
//						String interfaceName=null;
//
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//						log.info("Prueba con el json: "+jsonString);
//						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
//						try{
//							interfaceName= (String) jsonObject.getString("intfName"); 
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: intfName,address,layer.");							
//							break;
//						}
//						sendResponse(informationRetriever.measurementModule(interfaceName));					
//						break;
//					}
//					case TopologyModuleMessageTypes.GET_INTF_BY_NAME_OP:{		
//						log.info("GET_INTF_BY_NAME");
//						String interfaceName=null;
//
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//
//						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
//						try{
//							interfaceName= (String) jsonObject.getString("intfName"); 
//						}catch (NoSuchElementException e)
//						{		
//							sendResponse("ERROR: JSON incorrectly written. Needed: intfName.");							
//							break;
//						}
//						Intf intf = informationRetriever.getIntfByName(interfaceName);
//						String intfString = "null";
//						if (!(intf == null)){
//							Gson gson = new Gson();
//							intfString = gson.toJson(intf);							
//						}
//											
//						sendResponse(intfString);		
//						break;
//					}
//					case TopologyModuleMessageTypes.GET_NODE_BY_NAME_OP:{		
//						log.info("GET_NODE_BY_NAME");
//						String nodeName=null;
//
//						int length=getMessageLength(topologyModuleMessage);				
//						byte[] requestDone=new byte[(length)];
//
//						log.info("topologyModuleMessage length :"+topologyModuleMessage.length);
//						System.arraycopy(topologyModuleMessage, 4, requestDone, 0, (length));
//						String jsonString = new String (requestDone);
//
//						jsonObject = new JSONObject(jsonString);//requestDone.toString()); 	
//						nodeName= (String) jsonObject.getString("nodeName"); 
//						Node node = informationRetriever.getNodeByName(nodeName);
//						String nodeString = "null";
//						if (!(node == null)){							
//							Gson gson = new Gson();
//							nodeString=gson.toJson(node);
//						}
//						sendResponse(nodeString);		
//						break;
//					}
					}
				}
				else {
					log.info("error");
				}

			} 
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				salir=false;
			}

		}
	}
	
	private void findAndDeleteToUpdateANewEdge(IntraDomainEdge edge) {
		LinkedList<IntraDomainEdge> edges=((SimpleTEDB)this.ted.getDB()).getIntraDomainEdges();
		for (int i=0; i<edges.size(); i++){
			if (edges.get(i).getLinkID().equals(edge.getLinkID())){
				edges.remove(i);
				return;
			}
		}
	}

	private String buildFullTopology() {
		
		Topology topologia=new Topology();
		Iterator<Object> iternodes=((SimpleTEDB)ted.getDB()).getNetworkGraph().vertexSet().iterator();
		while (iternodes.hasNext())
			topologia.getNodeList().add((Node) iternodes.next());
		//Iterator<IntraDomainEdge> iteredges=((SimpleTEDB)ted.getDB()).getNetworkGraph().edgeSet().iterator();
		Iterator<IntraDomainEdge> iteredges=((SimpleTEDB)ted.getDB()).getIntraDomainEdges().iterator();
		while (iteredges.hasNext()){
			Link link=new Link();
			IntraDomainEdge edge=iteredges.next();
			link.setBandwidth(edge.getBw()); link.setLinkID(edge.getLinkID()); link.setSource((EndPoint) edge.getSrc_Numif_id()); link.setTeMetric(edge.getTemetric());
			link.setDest((EndPoint)edge.getDst_Numif_id()); link.setIsDirectional(edge.isDirectional()); link.setType(edge.getType()); 
			topologia.getLinkList().add(link);
		}
		Gson gson= new Gson();
		String out=gson.toJson(topologia);
		return out;
	}

	/**
	 * This function write in the socket (DataOutputStream) the message received by the InformationRetriever or by the TopologyUpdater
	 * @param response
	 */
	public void sendResponse(String response){
		int length=response.length();
		byte[] messageToSend = new byte[(response.length() + 4)];
		messageToSend[0]= 0x00;
		messageToSend[1] = 0x00;
		messageToSend[2]=(byte)(length >>> 8 & 0xff);
		messageToSend[3]=(byte)(length & 0xff);
		System.arraycopy(response.getBytes(),0,messageToSend, 4,length);
		try {
			out.write(messageToSend);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 */
	protected byte[] readMsg(DataInputStream in) throws IOException{
		
		byte[] hdr = new byte[4];
		byte[] temp = null;
		boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;

		while (!endMsg) {
			try {

				if (endHdr) {
					r = in.read(temp, offset, 1);
					if (r == -1){
						return null;
					}
				}
				else {		
					if (hdr != null){
						r = in.read(hdr, offset, 1);

						if (r == -1){
							return null;
						}
					}
				}
			}catch (IOException e){
				//System.out.println("Salgo por excepcion");
				log.warning("Error reading data: "+ e.getMessage());
				throw e;

			}catch (Exception e) {		
				throw new IOException();
			}
			if (r > 0) {

				if (offset == 2) {

					length = ((int)hdr[offset]&0xFF) << 8;
					log.info("length 1 "+length);
					//UtilsFunctions.printByte(hdr, "hdr",log);

				}
				if (offset == 3) {

					length = length | (((int)hdr[offset]&0xFF));
					length=length+4;//Cabecera
					log.info("\nLength;"+length);
					temp = new byte[length];
					endHdr = true;
					System.arraycopy(hdr, 0, temp, 0, 4);


				}

				if ((length > 0) && (offset == length - 1)) {
					endMsg = true;
				}

				offset++;

			}
			else if (r==-1){

				//log.warning("End of stream has been reached");
				throw new IOException();

			}
		}


		return temp;

	}

	
	int getClassToCall(byte[] message){		
		return ((message[0]&0xF0)>>>4);
	}
	int getOperationType(byte[] message){		
		return message[0]&0x0F;
	}
	int  getMessageLength(byte[] bytes){
		int length;
		length=(int)(((bytes[2]&0xFF)<<8) |  (bytes[3]&0xFF));
		 return length;
	}
	
	private  String convertNodes(ArrayList<Node> nodes){
		String nodesString="";
		for (int i=0;i<nodes.size();i++){
			Gson gson = new Gson();
			nodesString =nodesString + gson.toJson(nodes.get(i));			
		}
		return nodesString;
	}
	
}
