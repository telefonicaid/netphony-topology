package es.tid.topologyModuleBase.plugins.readerwriter;

import es.tid.topologyModuleBase.TopologyModuleParams;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.plugins.TMPlugin;
import es.tid.topologyModuleBase.plugins.writer.InformationRetriever;

import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;

/**
 * Created by <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a> on 23/09/2016.
 */
public abstract class TopologyReaderWriter implements TMPlugin {
    /**
     * Logger object
     */
    protected Logger log = Logger.getLogger("TMController");

    protected TopologiesDataBase ted;
    protected TopologyModuleParams params;
    protected Lock lock;
    protected InformationRetriever infRetriever;

    /**
     * Class constructor.
     *
     * @param ted
     * @param params
     * @param lock
     * @// TODO: 23/09/2016 Write javadoc constructor fields description.
     */
    public TopologyReaderWriter(TopologiesDataBase ted, TopologyModuleParams params, Lock lock) {
        this.ted = ted;
        this.params = params;
        this.lock = lock;
        infRetriever = new InformationRetriever(ted, params, lock);
    }

    /**
     * Read topology abstract class.
     *
     * @// TODO: 23/09/2016 Write javadoc constructor fields description.
     */
    abstract public void readServeTopology();
}
