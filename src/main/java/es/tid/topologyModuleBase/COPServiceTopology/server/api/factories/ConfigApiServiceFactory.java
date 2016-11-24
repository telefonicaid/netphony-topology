package es.tid.topologyModuleBase.COPServiceTopology.server.api.factories;

import es.tid.topologyModuleBase.COPServiceTopology.server.api.ConfigApiService;
import es.tid.topologyModuleBase.COPServiceTopology.server.api.impl.ConfigApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-05-23T12:45:37.903+02:00")
public class ConfigApiServiceFactory {

   private final static ConfigApiService service = new ConfigApiServiceImpl();

   public static ConfigApiService getConfigApi()
   {
      return service;
   }
}
