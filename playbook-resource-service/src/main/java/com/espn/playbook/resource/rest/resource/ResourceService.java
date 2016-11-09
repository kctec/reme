package com.espn.playbook.resource.rest.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.ApiModel;

@Path("/resource")
@PermitAll
@ApiModel(value = "Playbook Resource API")
public interface ResourceService {
	
	  @GET
	    @Path("/all")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getAllResources();
	  
	  @GET
	    @Path("/type/all")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getAllResourceTypes();

}
