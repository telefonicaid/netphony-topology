package es.tid.topologyModuleBase.plugins.writer;

import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;

import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.TMPlugin;
/**
 * 
 * @author jaume
 *
 */
public abstract class TopologyServer implements TMPlugin 
{
	/**
	 * Logger
	 */
	protected static Logger log=Logger.getLogger("TMController");
	
	protected TopologiesDataBase ted;
	protected TopologyModuleParams params;
	protected Lock lock;
	protected InformationRetriever infRetriever;
	
	
	public TopologyServer(TopologiesDataBase ted, TopologyModuleParams params, Lock lock)
	{
		this.ted = ted;
		this.params = params;
		this.lock = lock;
		infRetriever = new InformationRetriever(ted, params, lock);
	}
	
	abstract void serveTopology();
}
