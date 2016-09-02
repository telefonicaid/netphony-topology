package es.tid.topologyModuleBase.plugins.writer;

import java.util.concurrent.locks.Lock;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import es.tid.bgp.bgp4Peer.peer.BGPPeer;
import es.tid.tedb.SimpleTEDB;
import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;

//import javax.servlet.Servlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class TopologyServerCOP extends TopologyServer
{
	
	
	public static TopologiesDataBase actualTed;
	private boolean isRunning=false;
	

	public TopologyServerCOP(TopologiesDataBase ted, TopologyModuleParams params,
			Lock lock) 
	{
		super(ted, params, lock);
		actualTed = ted;
	}
	
	
	public static TopologiesDataBase getActualTed(){
		return actualTed;
	}

	@Override
	public void serveTopology() 
	{
		this.run();
	}
	@Override
	public void run() 
	{
		log.info("Acting as BGP Peer");
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        log.info("Service-Topology Port: "+params.getExportCOPPort());
        Server jettyServer = new Server(params.getExportCOPPort());
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet =  
        		context.addServlet( com.sun.jersey.spi.container.servlet.ServletContainer.class, "/*");


        jerseyServlet.setInitParameter(
                "com.sun.jersey.config.property.packages",
                "io.swagger.jaxrs.json;io.swagger.jaxrs.listing;es.tid.topologyModuleBase.COPServiceTopology.server.api");
        
        jerseyServlet.setInitParameter(
                "com.sun.jersey.spi.container.ContainerRequestFilters",
                "com.sun.jersey.api.container.filter.PostReplaceFilter");
        
        jerseyServlet.setInitParameter(
                "com.sun.jersey.api.json.POJOMappingFeatures",
                "true");
        
        jerseyServlet.setInitOrder(1);
		
        
        try {
        	isRunning=true;
            jettyServer.start();
            //jettyServer.dumpStdErr();
            jettyServer.join();
        } catch(Exception e){
        	log.severe(e.getStackTrace().toString());
        }finally {     
            jettyServer.destroy();
        }
		
	}
	
	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return isRunning;
	}

	@Override
	public String getPluginName() {
		// TODO Auto-generated method stub
		return "COP server-exporter";
	}

	@Override
	public String displayInfo() {
		// TODO Auto-generated method stub
		String str=getPluginName()+"\n";
		str+="Status: ";
		if(isRunning())str+="running";
		else str+="stop";
		str+="\nPort:"+params.getExportCOPPort();
		return str;
	}
}
