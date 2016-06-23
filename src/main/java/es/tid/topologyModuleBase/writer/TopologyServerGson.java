package es.tid.topologyModuleBase.writer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.locks.Lock;

import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;
import es.tid.topologyModuleBase.writer.gson.GsonSession;
/**
 * 
 * @author jaume
 *
 */
public class TopologyServerGson extends TopologyServer
{	
	public TopologyServerGson(SimpleTopology ted, TopologyModuleParams params, Lock lock)
	{
		super(ted,params,lock);
	}

	@Override
	public void serveTopology() 
	{
		this.start();
	}
	
	@Override
	public void run(){
		ServerSocket serverSocket = null;
		boolean listening=true;
		log.info("Initializing Gson Sever in Topology Module");
		try 
		{	
			log.info("Listening on port: "+params.getGsonPort());	
			serverSocket = new ServerSocket(params.getGsonPort());			
		} catch (IOException e) {
			System.err.println("Could not listen on port: "+params.getGsonPort());
			System.exit(-1);
		}

		try 
		{
			while (listening) 
			{
				new GsonSession(serverSocket.accept(),infRetriever,ted).start();	
			}
			System.out.println("Se cierra");
			serverSocket.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
