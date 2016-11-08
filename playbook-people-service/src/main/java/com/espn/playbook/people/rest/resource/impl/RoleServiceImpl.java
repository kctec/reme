package com.espn.playbook.people.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.espn.playbook.entities.Role;
import com.espn.playbook.people.rest.resource.RoleService;

public class RoleServiceImpl implements RoleService {

    @PersistenceContext(unitName = "playbookPU")
    private EntityManager    entityManager;
	
	@Override
	public Response getRoles() {
		 
		String query = "FROM Role";
		  List<Role> roles = (List<Role>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

	@Override
	public Response getRolesByDepartment(String deptId) {
		String query = "FROM DepartmentRole d WHERE d.department = '" + deptId + "'";
		  List<Role> roles = (List<Role>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

}
