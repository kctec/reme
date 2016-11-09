package com.espn.playbook.resource.rest.resource.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espn.playbook.resource.rest.resource.ApplicationStatusService;

import javax.persistence.EntityManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//~--- classes ----------------------------------------------------------------

/**
 * Application Status EndPoint
 *
 * @author gillj
 */
public class ApplicationStatusServiceImpl implements ApplicationStatusService {
    private static final Log log = LogFactory.getLog(ApplicationStatusServiceImpl.class);
    protected EntityManager  entityManager;

    /**
     * @TODO: Fix db check
     */
    public boolean checkDBStatus() {
        try {
            entityManager.createNativeQuery("select 1 from dual").getSingleResult();

            return true;
        } catch (Exception exc) {
            log.error("Exception, The DB is down!");

            return false;
        }
    }

    @Override
    public Response statusMessage() {
        log.info("statusMessage called");

        return Response.status(Response.Status.OK.getStatusCode())
                       .type(MediaType.TEXT_HTML)
                       .entity("The Event-Access-Service is up and running.")
                       .build();
    }
}


