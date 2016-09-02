package es.tid.topologyModuleBase.plugins.reader;

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
public abstract class TopologyReader implements TMPlugin
{
	/**
	 * Logger
	 */
	protected Logger log=Logger.getLogger("TMController");
	
	protected TopologiesDataBase ted;
	protected TopologyModuleParams params;
	protected Lock lock;
	
	public TopologyReader(TopologiesDataBase ted, TopologyModuleParams params, Lock lock)
	{
		this.ted = ted;
		this.params = params;
		this.lock = lock;
	}
	
	abstract public void readTopology();
	
}
