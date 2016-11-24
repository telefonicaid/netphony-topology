package es.tid.topologyModuleBase.plugins.writer.gson;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Logger;

import es.tid.topologyModuleBase.TopologyModuleConstants;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.writer.InformationRetriever;
import es.tid.topologyModuleBase.util.UtilsFunctions;
/**
 * 
 * @author carlos,jaume
 *
 */
public class GsonSession extends Thread
{
	/**
	 * Data input to read the messages
	 */
	private DataInputStream in;	
	/**
	 * Data output to send the responses
	 */
	private DataOutputStream out;
	/**
	 * Socket
	 */
	Socket socket;
	/**
	 * Logger
	 */
	Logger log;
	InformationRetriever informationRetriever;
	TopologiesDataBase ted;
	
	/**
	 * It indicates wether to continue serving
	 */
	private boolean continueServing = true;
	
	public GsonSession(Socket s,InformationRetriever informationRetriever,TopologiesDataBase ted)
	{
		this.socket=s;
		log=Logger.getLogger("TMController");
		this.informationRetriever=informationRetriever;
		this.ted = ted;
	}
	
	@Override
	public void run()
	{
		log.info("Opening new Gson session");
		try
		{
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException e) 
		{
			log.info(UtilsFunctions.exceptionToString(e));
		}
		
		while(continueServing)
		{
			boolean readMessage = true; 
			String topologyModuleMessage = null;
			

			log.info("Reading message inside readMessage");
			topologyModuleMessage = readMsg(in);
			
			log.info("topologyModuleMessage::"+topologyModuleMessage);
			
			if (topologyModuleMessage == null)
			{
				log.info("Error, topologyModuleMessage should not be null");
			}
			if (getOperationType(topologyModuleMessage).equals(TopologyModuleConstants.GSON_GET_NODES))
			{
				String nodes;
				
				nodes = informationRetriever.getNodes(getDBIdentifier(topologyModuleMessage));
				
				log.info("Nodes::"+nodes);
				
				//String links = informationRetriever.getLinks(getDBIdentifier(topologyModuleMessage));
				
				//log.info("Links::"+links);
				
				sendResponse(nodes);
				
				continueServing = false;
			}
			else if (getOperationType(topologyModuleMessage).equals(TopologyModuleConstants.GSON_GET_LINKS))
			{
				
				String links;
				
				links = informationRetriever.getLinks(getDBIdentifier(topologyModuleMessage));
				
				log.info("Links::"+links);
				
				sendResponse(links);
				
				log.info("Unimplemented!!");
			}
			else if (getOperationType(topologyModuleMessage).equals(TopologyModuleConstants.END_COMMUNICATION))
			{
				continueServing = false;
				log.info("Ending Gson communication!!");
			}
		}
	}
	
	/**
	 * This function write in the socket (DataOutputStream) the message received by the InformationRetriever or by the TopologyUpdater
	 * @param response
	 */
	public void sendResponse(String response)
	{
		String finalResponse = TopologyModuleConstants.GSON_RESPONSE_TYPE+response;
		
		try 
		{
			PrintStream ps = new PrintStream(out, true);
			ps.println(finalResponse);
		} 
		catch (Exception e) 
		{
			log.info(UtilsFunctions.exceptionToString(e));
		}		
	}
	
	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 */
	protected String readMsg(DataInputStream in) 
	{
		
		//Receiving information
		BufferedReader br = new BufferedReader(new InputStreamReader(in));	
		
		String response ="";
		log.info("Reading inside readMsg");
		try
		{
			response = br.readLine();
		}
		catch(Exception e)
		{
			log.info(UtilsFunctions.exceptionToString(e));
		}
		log.info("Ended reading");
		return response;
	}


	private String getOperationType(String response)
	{
		return ""+response.charAt(0);
	}
	
	private String getDBIdentifier(String response)
	{
		return response.substring(1);
	}
}
