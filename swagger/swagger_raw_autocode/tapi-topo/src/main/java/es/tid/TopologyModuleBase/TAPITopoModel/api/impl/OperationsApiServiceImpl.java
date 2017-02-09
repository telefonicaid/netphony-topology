package es.tid.TopologyModuleBase.TAPITopoModel.api.impl;

import es.tid.TopologyModuleBase.TAPITopoModel.api.*;
import es.tid.es.tid.opologyModuleBase.TAPITopoModel.api.model.*;

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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-09T11:18:25.638+01:00")
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
