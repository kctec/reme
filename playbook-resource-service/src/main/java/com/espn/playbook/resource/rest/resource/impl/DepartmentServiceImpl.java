package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.espn.playbook.entities.Department;
import com.espn.playbook.resource.rest.resource.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext(unitName = "playbookPU")
    private EntityManager    entityManager;
	
	@Override
	public Response getDepartments() {
		 
		String query = "FROM Department";
		  List<Department> roles = (List<Department>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

}
