package com.kctec.reme.rest.impl;

import com.kctec.reme.jpa.User;
import com.kctec.reme.util.EntityToDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class UserServiceImpl implements com.kctec.reme.rest.UserService  {

    protected static Log log = LogFactory.getLog(UserServiceImpl.class);

    @PersistenceContext(unitName = "remePU")
    private EntityManager entityManager;

    @Override
    public Response getUsers() {




        @SuppressWarnings("unchecked")
        List<User> user = (List<User>) entityManager.createNamedQuery("User.all");

        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
        responseBuilder.entity(EntityToDTO.getDTO(user));
        return responseBuilder.build();
    }

    @Override
    public Response getUser(int userId) {

 ;

        User user = entityManager.find(User.class, userId);
        if (log.isDebugEnabled()) {
            log.debug("user found = " + userId);
        }
        if (user == null) {
            // Department not found
            Response.ResponseBuilder responseBuilder = Response.status(204);
            return responseBuilder.build();
        }
        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
        responseBuilder.entity(EntityToDTO.getDTO(user));
        return responseBuilder.build();
    }
}
