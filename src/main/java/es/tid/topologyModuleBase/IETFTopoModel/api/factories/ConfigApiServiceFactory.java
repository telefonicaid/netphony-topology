package es.tid.topologyModuleBase.IETFTopoModel.api.factories;

import es.tid.topologyModuleBase.IETFTopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.IETFTopoModel.api.impl.ConfigApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-18T19:03:40.260+02:00")
public class ConfigApiServiceFactory {

   private final static ConfigApiService service = new ConfigApiServiceImpl();

   public static ConfigApiService getConfigApi()
   {
      return service;
   }
}
