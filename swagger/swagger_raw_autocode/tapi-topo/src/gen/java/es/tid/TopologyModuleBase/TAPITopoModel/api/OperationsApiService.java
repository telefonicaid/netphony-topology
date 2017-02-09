package es.tid.TopologyModuleBase.TAPITopoModel.api;

import es.tid.TopologyModuleBase.TAPITopoModel.api.*;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetLinkDetailsRPCInputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetLinkDetailsRPCOutputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetNodeDetailsRPCOutputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetNodeDetailsRPCInputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetNodeEdgePointDetailsRPCOutputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetNodeEdgePointDetailsRPCInputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetTopologyDetailsRPCOutputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetTopologyDetailsRPCInputSchema;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.GetTopologyListRPCOutputSchema;

import java.util.List;
import es.tid.TopologyModuleBase.TAPITopoModel.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-09T12:33:04.057+01:00")
public abstract class OperationsApiService {
    public abstract Response createGetLinkDetailsById(GetLinkDetailsRPCInputSchema getLinkDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetNodeDetailsById(GetNodeDetailsRPCInputSchema getNodeDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetNodeEdgePointDetailsById(GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetTopologyDetailsById(GetTopologyDetailsRPCInputSchema getTopologyDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetTopologyListById(SecurityContext securityContext) throws NotFoundException;
}
