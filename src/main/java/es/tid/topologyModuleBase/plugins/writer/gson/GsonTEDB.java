package es.tid.topologyModuleBase.plugins.writer.gson;

import java.util.Collection;

import es.tid.tedb.IntraDomainEdge;
import es.tid.tedb.SimpleTEDB;

/**
 * Class used for sending the TEDB across network with Gson. SimpleTEDB cannot be used because it's too complex
 * @author jaume
 *
 */
public class GsonTEDB 
{
	Collection<IntraDomainEdge> links;
	Collection<Object> nodes;
	
	GsonTEDB(SimpleTEDB ted)
	{
		links = ted.getIntraDomainLinks();
		nodes = ted.getNetworkGraph().vertexSet();
	}
}
