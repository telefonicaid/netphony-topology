package es.tid.topologyModuleBase.session.ws;


/**
 * This class contains the different types of opperations the web service can send to TopologyModule.
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
 *   </pre>
 *     
 * @author Telefonica I+D
 *
 */
public class TopologyModuleMessageTypes {

	/**
	 *  CLASS To request Topology Module functions  (Update) 
	 */
	public static final int TOPOLOGY_UPDATER_CLASS = 0;
	/**
	 *  CLASS To request Information Retrieveer functions (Obtain information of topology) 
	 */
	public static final int INFORMATION_RETRIEVER_CLASS = 1;
	
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get full topology
	 */
	public static final int GET_FULL_TOPOLOGY_OP = 0;	
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get opposite node
	 */
	public static final int GET_OPPOSITE_NODE_OP = 1;	
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get neighnours of a node in the same layer
	 */
	public static final int GET_NEIGHBOUR_NODES_OP = 2;
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Measurement module
	 */
	public static final int MEASUREMENT_MODULE_OP = 3;
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get node by name
	 */
	public static final int GET_NODE_BY_NAME_OP = 4;
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get interface by name
	 */
	public static final int GET_INTF_BY_NAME_OP = 5;
	/**
	 * OPERATION_FOR_INFORMATION_RETRIEVER_CLASS
	 * Get opposite interface
	 */
	public static final int GET_OPPOSITE_INTERFACE_OP = 6;
	/**
	 * OPERATION_FOR_TOPOLOGY_MODULE_CLASS
	 * Update node
	 */
	public static final int UPDATE_NODE_OP = 0;
	/**
	 * OPERATION_FOR_TOPOLOGY_MODULE_CLASS
	 * Update interface
	 */
	public static final int UPDATE_INTERFACE_OP = 1;	
	/**
	 * OPERATION_FOR_TOPOLOGY_MODULE_CLASS
	 * Update link
	 */
	public static final int UPDATE_LINK_OP = 2;
	/**
	 * OPERATION_FOR_TOPOLOGY_MODULE_CLASS
	 * Update all
	 */
	public static final int UPDATE_ALL_OP = 3;


	public static final int DELETE_NODE_OP = 4;	
	public static final int DELETE_INTERFACE_OP = 5;	
	public static final int DELETE_LINK_OP = 6;
}
