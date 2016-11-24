package es.tid.topologyModuleBase.COPServiceTopology.client.auth;

import java.util.Map;

import es.tid.topologyModuleBase.COPServiceTopology.client.Pair;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-27T13:24:30.808+02:00")
public interface Authentication {
  /** Apply authentication settings to header and query params. */
  void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
