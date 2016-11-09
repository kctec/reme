package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.espn.playbook.entities.Resource;
import com.espn.playbook.entities.ResourceType;
import com.espn.playbook.resource.rest.resource.ResourceService;


public class ResourceServiceImpl implements ResourceService{

	@PersistenceContext(unitName = "playbookPU")
	private EntityManager    entityManager;

	@Override
	public Response getAllResources(@Context UriInfo ui) {
		MultivaluedMap<String, String> params = ui.getQueryParameters();
		StringBuilder sb = new StringBuilder();

		sb.append("FROM Resource r WHERE r.id IS NOT NULL");
		if (params.containsKey("typeId")) {
			sb.append(" AND r.resourceType = HEXTORAW('" + params.get("typeId").get(0) + "')");
		}
		if (params.containsKey("displayName")) {
			sb.append(" AND LOWER(r.displayName) LIKE LOWER('%" + params.get("displayName").get(0) + "%')");
		}
		if (params.containsKey("roleId")) {
			sb.append(" AND r in (SELECT rr.resource FROM ResourceRole rr where rr.role = HEXTORAW('" +params.get("roleId").get(0) + "'))");
		}
		
		@SuppressWarnings("unchecked")
		List<Resource> roles = (List<Resource>) entityManager.createQuery(sb.toString()).getResultList();
		Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		responseBuilder.entity(roles);
		return responseBuilder.build();
	}

	@Override
	public Response getAllResourceTypes() {
		String query = "FROM ResourceType";
		@SuppressWarnings("unchecked")
		List<ResourceType> roles = (List<ResourceType>) entityManager.createQuery(query).getResultList();
		Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		responseBuilder.entity(roles);
		return responseBuilder.build();
	}
}
