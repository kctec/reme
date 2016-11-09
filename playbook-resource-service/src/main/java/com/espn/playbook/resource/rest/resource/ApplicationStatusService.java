package com.espn.playbook.resource.rest.resource;


import com.wordnik.swagger.annotations.*;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//~--- interfaces -------------------------------------------------------------

/**
 * Application Status EndPoint
 *
 * @author gillj
 */
@Path("/heartbeat")
@PermitAll
@ApiModel(value = "ApplicationStatusService API")
@Api(
    value       = "ApplicationStatusService",
    description = "Service to check status of Notification-Service."
)
public interface ApplicationStatusService {
    @GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiOperation(
        value    = "playbook-people-service. Check for the DB Status",
        response = String.class
    )
    @ApiResponses(value = { @ApiResponse(
        code     = 200,
        message  = "The playbook-people-service is up and running.",
        response = String.class
    ) , @ApiResponse(
        code     = 500,
        message  = "The playbook-people-service is down!"
    ) })
    Response statusMessage();
}
