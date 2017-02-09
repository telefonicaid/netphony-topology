package es.tid.TopologyModuleBase.TAPITopoModel.api;

import es.tid.TopologyModuleBase.TAPITopoModel.api.*;
import es.tid.TopologyModuleBase.TAPITopoModel.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import es.tid.TopologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCInputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCOutputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCOutputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCInputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCOutputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCInputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCOutputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCInputSchema;
import es.tid.TopologyModuleBase.TAPITopoModel.model.GetTopologyListRPCOutputSchema;

import java.util.List;
import es.tid.TopologyModuleBase.TAPITopoModel.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-09T12:50:28.288+01:00")
public abstract class OperationsApiService {
    public abstract Response createGetLinkDetailsById(GetLinkDetailsRPCInputSchema getLinkDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetNodeDetailsById(GetNodeDetailsRPCInputSchema getNodeDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetNodeEdgePointDetailsById(GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetTopologyDetailsById(GetTopologyDetailsRPCInputSchema getTopologyDetails,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createGetTopologyListById(SecurityContext securityContext) throws NotFoundException;
}
