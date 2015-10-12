package com.cooldatasoft.sms.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cooldatasoft.jpa.data.Person;
import com.cooldatasoft.jpa.repositories.PersonRepository;
import com.cooldatasoft.repository.util.ObjectSampler;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public class PersonRepositoryTest extends AbstractRepositoryTest {

	private Person entity;
	
	@Autowired
	private PersonRepository personRepository;

	@Before
	public void setUp() {
		entity = ObjectSampler.createPerson();
	}

	@Test
	public void save() {
		Person newEntity = personRepository.save(entity);
		assertTrue("There must be a person now", newEntity != null);
	}

}
