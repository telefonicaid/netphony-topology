package es.tid.TopologyModuleBase.TAPITopoModel.api.factories;

import es.tid.TopologyModuleBase.TAPITopoModel.api.ConfigApiService;
import es.tid.TopologyModuleBase.TAPITopoModel.api.impl.ConfigApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-09T11:18:25.638+01:00")
public class ConfigApiServiceFactory {
    private final static ConfigApiService service = new ConfigApiServiceImpl();

    public static ConfigApiService getConfigApi() {
        return service;
    }
}
