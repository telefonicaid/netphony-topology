package es.tid.topologyModuleBase.COPServiceTopology.client.api;

import java.util.*;
import java.io.File;
import java.util.Map;

import es.tid.topologyModuleBase.COPServiceTopology.client.ApiClient;
import es.tid.topologyModuleBase.COPServiceTopology.client.ApiException;
import es.tid.topologyModuleBase.COPServiceTopology.client.Configuration;
import es.tid.topologyModuleBase.COPServiceTopology.client.Pair;
import es.tid.topologyModuleBase.COPServiceTopology.client.TypeRef;
import es.tid.topologyModuleBase.COPServiceTopology.model.*;

import java.util.HashMap;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-27T13:24:30.808+02:00")
public class DefaultApi {
  private ApiClient apiClient;

  public DefaultApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DefaultApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Retrieve topologies
   * Retrieve operation of resource: topologies
   * @return TopologiesSchema
   */
  public TopologiesSchema retrieveTopologies () throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/config/topologies/".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<TopologiesSchema>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve topology by ID
   * Retrieve operation of resource: topology
   * @param topologyId ID of topologyId
   * @return Topology
   */
  public Topology retrieveTopologiesTopologyTopologyById (String topologyId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyTopologyById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Topology>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve edges by ID
   * Retrieve operation of resource: edges
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @return Edge
   */
  public Edge retrieveTopologiesTopologyEdgesEdgesById (String topologyId, String edgeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesEdgesById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesEdgesById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Edge>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve local_ifid by ID
   * Retrieve operation of resource: local_ifid
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @return EdgeEnd
   */
  public EdgeEnd retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById (String topologyId, String edgeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesLocalIfidLocalIfidById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/local_ifid/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<EdgeEnd>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve remote_ifid by ID
   * Retrieve operation of resource: remote_ifid
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @return EdgeEnd
   */
  public EdgeEnd retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById (String topologyId, String edgeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesRemoteIfidRemoteIfidById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/remote_ifid/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<EdgeEnd>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve source by ID
   * Retrieve operation of resource: source
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @return Node
   */
  public Node retrieveTopologiesTopologyEdgesSourceSourceById (String topologyId, String edgeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesSourceSourceById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesSourceSourceById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/source/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Node>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve edge_end by ID
   * Retrieve operation of resource: edge_end
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @param edgeEndId ID of edgeEndId
   * @return EdgeEnd
   */
  public EdgeEnd retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById (String topologyId, String edgeId, String edgeEndId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'edgeEndId' is set
    if (edgeEndId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeEndId' when calling retrieveTopologiesTopologyEdgesSourceEdgeEndEdgeEndById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/source/edge_end/{edgeEndId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()))
      .replaceAll("\\{" + "edgeEndId" + "\\}", apiClient.escapeString(edgeEndId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<EdgeEnd>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve target by ID
   * Retrieve operation of resource: target
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @return Node
   */
  public Node retrieveTopologiesTopologyEdgesTargetTargetById (String topologyId, String edgeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesTargetTargetById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesTargetTargetById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/target/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Node>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve edge_end by ID
   * Retrieve operation of resource: edge_end
   * @param topologyId ID of topologyId
   * @param edgeId ID of edgeId
   * @param edgeEndId ID of edgeEndId
   * @return EdgeEnd
   */
  public EdgeEnd retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById (String topologyId, String edgeId, String edgeEndId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'edgeId' is set
    if (edgeId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeId' when calling retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'edgeEndId' is set
    if (edgeEndId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeEndId' when calling retrieveTopologiesTopologyEdgesTargetEdgeEndEdgeEndById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/edges/{edgeId}/target/edge_end/{edgeEndId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "edgeId" + "\\}", apiClient.escapeString(edgeId.toString()))
      .replaceAll("\\{" + "edgeEndId" + "\\}", apiClient.escapeString(edgeEndId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<EdgeEnd>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve nodes by ID
   * Retrieve operation of resource: nodes
   * @param topologyId ID of topologyId
   * @param nodeId ID of nodeId
   * @return Node
   */
  public Node retrieveTopologiesTopologyNodesNodesById (String topologyId, String nodeId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyNodesNodesById");
    }
    
    // verify the required parameter 'nodeId' is set
    if (nodeId == null) {
       throw new ApiException(400, "Missing the required parameter 'nodeId' when calling retrieveTopologiesTopologyNodesNodesById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/nodes/{nodeId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "nodeId" + "\\}", apiClient.escapeString(nodeId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<Node>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * Retrieve edge_end by ID
   * Retrieve operation of resource: edge_end
   * @param topologyId ID of topologyId
   * @param nodeId ID of nodeId
   * @param edgeEndId ID of edgeEndId
   * @return EdgeEnd
   */
  public EdgeEnd retrieveTopologiesTopologyNodesEdgeEndEdgeEndById (String topologyId, String nodeId, String edgeEndId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'topologyId' is set
    if (topologyId == null) {
       throw new ApiException(400, "Missing the required parameter 'topologyId' when calling retrieveTopologiesTopologyNodesEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'nodeId' is set
    if (nodeId == null) {
       throw new ApiException(400, "Missing the required parameter 'nodeId' when calling retrieveTopologiesTopologyNodesEdgeEndEdgeEndById");
    }
    
    // verify the required parameter 'edgeEndId' is set
    if (edgeEndId == null) {
       throw new ApiException(400, "Missing the required parameter 'edgeEndId' when calling retrieveTopologiesTopologyNodesEdgeEndEdgeEndById");
    }
    

    // create path and map variables
    String path = "/config/topologies/topology/{topologyId}/nodes/{nodeId}/edge_end/{edgeEndId}/".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "topologyId" + "\\}", apiClient.escapeString(topologyId.toString()))
      .replaceAll("\\{" + "nodeId" + "\\}", apiClient.escapeString(nodeId.toString()))
      .replaceAll("\\{" + "edgeEndId" + "\\}", apiClient.escapeString(edgeEndId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };
    
    TypeRef returnType = new TypeRef<EdgeEnd>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
