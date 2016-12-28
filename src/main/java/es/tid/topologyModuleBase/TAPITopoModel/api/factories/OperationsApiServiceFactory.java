package es.tid.topologyModuleBase.TAPITopoModel.api.factories;

import es.tid.topologyModuleBase.TAPITopoModel.api.OperationsApiService;
import es.tid.topologyModuleBase.TAPITopoModel.api.impl.OperationsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-28T15:11:12.465+01:00")
public class OperationsApiServiceFactory {
    private final static OperationsApiService service = new OperationsApiServiceImpl();

    public static OperationsApiService getOperationsApi() {
        return service;
    }
}
