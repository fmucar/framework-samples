package com.cooldatasoft.rest.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cooldatasoft.rest.data.SampleEntity;

/**
 * Generates sample objects
 * 
 * @author Fatih
 *
 */
public class ObjectSampler {

	public static <T> T sample(Class<T> clazz) {
		try {
			T instance = clazz.newInstance();
			Field[] declaredFields = clazz.getDeclaredFields();

			for (Field field : declaredFields) {
				if (Modifier.isFinal(field.getModifiers())) {
					continue;
				}
				String typeStr = field.getType().getName();

				field.setAccessible(true);
				if (typeStr.equals("int") || typeStr.equals("java.lang.Integer")) {
					field.set(instance, (int) (Math.random() * Integer.MAX_VALUE));
				} else if (typeStr.equals("long") || typeStr.equals("java.lang.Long")) {
					field.set(instance, (long) (Math.random() * Long.MAX_VALUE));
				} else if (typeStr.equals("boolean") || typeStr.equals("java.lang.Boolean")) {
					field.set(instance, ((int) (Math.random() * 2) == 1) ? true : false);
				} else if (typeStr.equals("short") || typeStr.equals("java.lang.Short")) {
					field.set(instance, (short) (Math.random() * Short.MAX_VALUE));
				} else if (typeStr.equals("double") || typeStr.equals("java.lang.Double")) {
					field.set(instance, Math.random() * Double.MAX_VALUE);
				} else if (typeStr == "java.lang.String") {
					field.set(instance, RandomString.getString("**********"));
				} else if (typeStr == "java.util.Date") {
					field.set(instance, new Date());
				} else {
					System.out.println("CUSTOM : " + typeStr);
					field.set(instance, sample(field.getType()));
				}
			}

			return instance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static SampleEntity createSampleEntity() {
		return sample(SampleEntity.class);
	}

	public static List<SampleEntity> createSampleEntityList(Long startId, int size) {
		List<SampleEntity> entities = new ArrayList<>();
		for (long id = startId; id < (startId+size); id++) {
			entities.add(createSampleEntity(id));
		}
		return entities;
	}

	private static SampleEntity createSampleEntity(long id) {
		SampleEntity entity = createSampleEntity();
		entity.setId(id);
		return entity;
	}
}