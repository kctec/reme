package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.espn.playbook.entities.Role;
import com.espn.playbook.resource.rest.resource.RolesService;

public class RolesServiceImpl implements RolesService {

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
		String query = "SELECT d.role FROM DepartmentRole d WHERE d.department = HexToRaw('89586E59710210B4E043AC16FA5410B4')";
		  List<Role> roles = (List<Role>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

}
