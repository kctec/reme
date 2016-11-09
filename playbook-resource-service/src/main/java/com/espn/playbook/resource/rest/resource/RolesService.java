package com.espn.playbook.resource.rest.resource;

import javax.annotation.security.PermitAll;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.wordnik.swagger.annotations.ApiModel;
 

@Path("/role")
@PermitAll
@ApiModel(value = "Playbook Role API")
public interface RolesService {
	    @GET
	    @Path("/")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getRoles(@Context UriInfo ui);
 
}
