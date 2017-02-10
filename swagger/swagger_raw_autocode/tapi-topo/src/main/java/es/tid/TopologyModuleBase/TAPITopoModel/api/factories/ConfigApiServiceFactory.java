package es.tid.topologyModuleBase.TAPITopoModel.api.factories;

import es.tid.topologyModuleBase.TAPITopoModel.api.ConfigApiService;
import es.tid.topologyModuleBase.TAPITopoModel.api.impl.ConfigApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class ConfigApiServiceFactory {
    private final static ConfigApiService service = new ConfigApiServiceImpl();

    public static ConfigApiService getConfigApi() {
        return service;
    }
}
