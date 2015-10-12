package com.cooldatasoft.rest.service;

import com.cooldatasoft.rest.data.SampleEntity;
import com.cooldatasoft.rest.util.ObjectSampler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleService {

	public Long create() {
		return ObjectSampler.createSampleEntity().getId();
	}

	public SampleEntity read(Long id) {
		SampleEntity entity = ObjectSampler.createSampleEntity();
		entity.setId(id);
		return entity;
	}

	public String update(SampleEntity entity) {
		return "updated entity with id: " + entity.getId();
	}

	public String delete(Long id) {
		return "deleted entity with id : " + id;
	}

	public List<SampleEntity> list(long startId, int size) {
		return ObjectSampler.createSampleEntityList(startId, size);
	}
}
