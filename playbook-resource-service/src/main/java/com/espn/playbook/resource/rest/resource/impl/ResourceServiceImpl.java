package com.espn.playbook.resource.rest.resource.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.espn.playbook.jpa.Prsn;
import com.espn.playbook.jpa.Rsrc;
import com.espn.playbook.jpa.RsrcType;
import com.espn.playbook.resource.rest.resource.ResourceService;


public class ResourceServiceImpl implements ResourceService{

	@PersistenceContext(unitName = "playbookPU")
	private EntityManager    entityManager;

	@Override
	public Response getAllResources(@Context UriInfo ui) {
		MultivaluedMap<String, String> params = ui.getQueryParameters();
		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT r.prsn FROM Rsrc as r");
		/*if (params.containsKey("roleId")) {
			sb.append(" inner join ResourceRole rr");
		}*/
		sb.append(" WHERE r.id IS NOT NULL");
		
		if (params.containsKey("typeId")) {
			sb.append(" AND r.rsrcType = HEXTORAW('" + params.get("typeId").get(0) + "')");
		}
		if (params.containsKey("displayName")) {
			sb.append(" AND LOWER(r.displayNm) LIKE LOWER('%" + params.get("displayName").get(0) + "%')");
		}
		/*if (params.containsKey("roleId")) {
			sb.append(" AND rr = HEXTORAW('" +params.get("roleId").get(0) + "')");
			sb.append(" AND rr.role = r");
		}*/

		@SuppressWarnings("unchecked")
		List<Prsn> people = (List<Prsn>) entityManager.createQuery(sb.toString()).getResultList();
		Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		responseBuilder.entity(people);
		return responseBuilder.build();
	}

	@Override
	public Response getAllResourceTypes() {
		String query = "FROM ResourceType";
		@SuppressWarnings("unchecked")
		List<RsrcType> roles = (List<RsrcType>) entityManager.createQuery(query).getResultList();
		Response.ResponseBuilder responseBuilder = Response.status(Response.Status.OK);
		responseBuilder.entity(roles);
		return responseBuilder.build();
	}
}
