package com.cooldatasoft.rest.resource.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;

import com.cooldatasoft.rest.data.SampleEntity;
import com.cooldatasoft.rest.resource.SampleResource;
import com.cooldatasoft.rest.util.ObjectSampler;

@Slf4j
public class SampleResourceImpl implements SampleResource {

	@Override
	public Response create(SampleEntity entity) {
		log.info("Received create request");
		return Response.ok(ObjectSampler.createSampleEntity().getId()).build();
	}

	@Override
	public Response read(Long id) {
		log.info("Received read request");
		SampleEntity entity = ObjectSampler.createSampleEntity();
		entity.setId(id);
		return Response.ok(entity).build();
	}

	@Override
	public Response update(SampleEntity entity) {
		log.info("Received update request");
		return Response.ok("updated entity with id: " + entity.getId()).build();
	}

	@Override
	public Response delete(Long id) {
		log.info("Received delete request");
		return Response.ok("deleted entity with id : " + id).build();
	}

	@Override
	public Response list(Long startId, Integer size) {
		log.info("Received list request");
		List<SampleEntity> entities = ObjectSampler.createSampleEntityList(startId, size);
		return Response.ok(entities).build();
	}

}
