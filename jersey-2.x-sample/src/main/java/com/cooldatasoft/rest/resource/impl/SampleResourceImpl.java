package com.cooldatasoft.rest.resource.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;

import com.cooldatasoft.rest.data.SampleEntity;
import com.cooldatasoft.rest.util.ObjectSampler;

@Slf4j
@Path("/sample")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SampleResourceImpl {

	@POST
	@Path("/create")
	public Response create(SampleEntity entity) {
		log.info("Received create request");
		return Response.ok(ObjectSampler.createSampleEntity().getId()).build();
	}

	@GET
	@Path("/read/{id}")
	public Response read(@PathParam("id") Long id) {
		log.info("Received read request");
		SampleEntity entity = ObjectSampler.createSampleEntity();
		entity.setId(id);
		return Response.ok(entity).build();
	}

	@PUT
	@Path("/update")
	public Response update(SampleEntity entity) {
		log.info("Received update request");
		return Response.ok("updated entity with id: " + entity.getId()).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") Long id) {
		log.info("Received delete request");
		return Response.ok("deleted entity with id : " + id).build();
	}

	@GET
	@Path("/list")
	public Response list(@QueryParam("startId") @DefaultValue("1") Long startId, @QueryParam("size") @DefaultValue("20") Integer size) {
		log.info("Received list request");
		List<SampleEntity> entities = ObjectSampler.createSampleEntityList(startId, size);
		return Response.ok(entities).build();
	}

}
