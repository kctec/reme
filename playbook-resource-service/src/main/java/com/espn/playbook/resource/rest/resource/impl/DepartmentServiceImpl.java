package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.espn.playbook.jpa.Dept;
import com.espn.playbook.resource.rest.resource.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext(unitName = "playbookPU")
    private EntityManager    entityManager;
	
	@Override
	public Response getDepartments(@Context UriInfo ui) {
		 
		String query = "FROM Dept";
		  List<Dept> roles = (List<Dept>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

}
