package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import com.espn.playbook.entities.Department;
import com.espn.playbook.entities.Resource;
import com.espn.playbook.entities.ResourceType;
import com.espn.playbook.resource.rest.resource.ResourceService;

public class ResourceServiceImpl implements ResourceService{

	 @PersistenceContext(unitName = "playbookPU")
	    private EntityManager    entityManager;
 
	@Override
	public Response getAllResources() {
		String query = "FROM Resource";
		  List<Resource> roles = (List<Resource>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}

	@Override
	public Response getAllResourceTypes() {
		String query = "FROM ResourceType";
		  List<ResourceType> roles = (List<ResourceType>) entityManager.createQuery(query).getResultList();
		  Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		  responseBuilder.entity(roles);
		  return responseBuilder.build();
	}
}
