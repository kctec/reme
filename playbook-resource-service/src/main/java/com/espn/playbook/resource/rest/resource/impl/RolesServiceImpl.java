package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.espn.playbook.entities.Role;
import com.espn.playbook.resource.rest.resource.RolesService;

public class RolesServiceImpl implements RolesService {

	@PersistenceContext(unitName = "playbookPU")
	private EntityManager    entityManager;

	@Override
	public Response getRoles(@Context UriInfo ui) {
		MultivaluedMap<String, String> params = ui.getQueryParameters();
		String query ;
		if (params.containsKey("deptId")) {
			query= "SELECT d.role FROM DepartmentRole d WHERE d.department = HexToRaw('" + params.get("deptId").get(0) + "')";

		}else{
			query= "FROM Role";
		}
		List<Role> roles = (List<Role>) entityManager.createQuery(query).getResultList();
		Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		responseBuilder.entity(roles);
		return responseBuilder.build();
	}

 

}
