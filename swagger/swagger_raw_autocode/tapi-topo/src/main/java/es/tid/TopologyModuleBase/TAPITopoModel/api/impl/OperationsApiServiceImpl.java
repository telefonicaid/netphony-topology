package es.tid.topologyModuleBase.TAPITopoModel.api.impl;

import es.tid.topologyModuleBase.TAPITopoModel.api.*;
import es.tid.topologyModuleBase.TAPITopoModel.model.*;

import es.tid.topologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetLinkDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetNodeEdgePointDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCOutputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyDetailsRPCInputSchema;
import es.tid.topologyModuleBase.TAPITopoModel.model.GetTopologyListRPCOutputSchema;

import java.util.List;
import es.tid.topologyModuleBase.TAPITopoModel.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-10T14:31:20.668+01:00")
public class OperationsApiServiceImpl extends OperationsApiService {
    @Override
    public Response createGetLinkDetailsById(GetLinkDetailsRPCInputSchema getLinkDetails, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createGetNodeDetailsById(GetNodeDetailsRPCInputSchema getNodeDetails, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createGetNodeEdgePointDetailsById(GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createGetTopologyDetailsById(GetTopologyDetailsRPCInputSchema getTopologyDetails, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response createGetTopologyListById(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
