package es.tid.TopologyModuleBase.TAPITopoModel.api.impl;

import es.tid.TopologyModuleBase.TAPITopoModel.api.*;
import es.tid.TopologyModuleBase.TAPITopoModel.model.*;

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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-09T12:50:28.288+01:00")
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
