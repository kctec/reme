package com.espn.playbook.people.rest.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.ApiModel;

@Path("/dept")
@PermitAll
@ApiModel(value = "Playbook Deprtment API")
public interface DepartmentService {

	    @GET
	    @Path("/all")
	    @Produces({ MediaType.APPLICATION_JSON })
	    Response getDepartments();
}
