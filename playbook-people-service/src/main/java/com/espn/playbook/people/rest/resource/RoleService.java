package com.espn.playbook.people.rest.resource;

import javax.annotation.security.PermitAll;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/role")
@PermitAll
@ApiModel(value = "Playbook Role API")
public interface RoleService {
	    @GET
	    @Path("/all")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getRoles();
	    
	    @GET
	    @Path("/{deptId}")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getRolesByDepartment(@PathParam("deptId") String deptId);
 

}
