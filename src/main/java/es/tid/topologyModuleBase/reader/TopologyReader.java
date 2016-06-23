package es.tid.topologyModuleBase.reader;

import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;

import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.SimpleTopology;
/**
 * 
 * @author jaume
 *
 */
public abstract class TopologyReader extends Thread
{
	/**
	 * Logger
	 */
	protected Logger log=Logger.getLogger("TMController");
	
	protected SimpleTopology ted;
	protected TopologyModuleParams params;
	protected Lock lock;
	
	public TopologyReader(SimpleTopology ted, TopologyModuleParams params, Lock lock)
	{
		this.ted = ted;
		this.params = params;
		this.lock = lock;
	}
	
	abstract public void readTopology();
	
}
