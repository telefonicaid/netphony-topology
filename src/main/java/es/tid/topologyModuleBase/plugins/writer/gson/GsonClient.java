package es.tid.topologyModuleBase.plugins.writer.gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Collection;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.tid.provisioningManager.objects.RouterInfoPM;
import es.tid.topologyModuleBase.TopologyModuleConstants;
import es.tid.topologyModuleBase.util.UtilsFunctions;

/**
 * Gson client for GsonSession.
 * @author jaume
 *
 */

public class GsonClient 
{
	String ip;
	int port;
	
	/**
	 * 
	 * Logger
	 */
	Logger log=Logger.getLogger("TMController");
	
	public GsonClient(String ip ,int port)
	{
		this.ip = ip;
		this.port = port;
	}
	public Collection<RouterInfoPM> getTopologyNodes()
	{
		log.info("Opening socket with server in: "+ip+" , port: "+port);
		try 
		{
			Socket connectionToTheServer = new Socket(ip, port);
			
			//Asking for information
			OutputStream out = connectionToTheServer.getOutputStream();
			PrintStream ps = new PrintStream(out, true);
			
			ps.println(queryForNodes());
			
			
			//Receiving information
			BufferedReader br = new BufferedReader(new InputStreamReader(connectionToTheServer.getInputStream()));
			
			
			log.info("Preparing to get response..");
			
			/*
			String inputLine;
			while ((inputLine = br.readLine()) != null) 
			{   
			    log.info("inputLine:::"+(String)inputLine);
			    break;
			}
			*/
			
			String response = br.readLine();
	        
	        log.info("response::"+response);
	        
	        ps.println(endCommunication());
	        
	        connectionToTheServer.close();
	        
	        Type collectionType = new TypeToken<Collection<RouterInfoPM>>(){}.getType();
			
	        
	        Gson gson = new Gson();
	        
	        log.info("Body message:::"+getBodyMessage(response));
	        return gson.fromJson(getBodyMessage(response),collectionType);
		
		} 
		catch (Exception e) 
		{
			System.out.println(UtilsFunctions.exceptionToString(e));
		} 
		
		return null;
	}
	
	private String getBodyMessage(String response)
	{
		return response.substring(TopologyModuleConstants.GSON_RESPONSE_TYPE.length());
	}
	
	private String queryForNodes()
	{
		return TopologyModuleConstants.GSON_GET_NODES;
	}
	
	private String endCommunication()
	{
		return TopologyModuleConstants.END_COMMUNICATION;
	}

}
