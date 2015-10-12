package com.cooldatasoft.sms.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cooldatasoft.jpa.data.Customer;
import com.cooldatasoft.jpa.repositories.CustomerRepository;
import com.cooldatasoft.repository.util.ObjectSampler;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public class CustomerRepositoryTest extends AbstractRepositoryTest {

	private Customer customer;
	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setUp() {
		customer = ObjectSampler.createCustomer();
	}

	@Test
	public void save() {
		Customer newEntity = customerRepository.save(customer);
		assertTrue("There must be a customer now", newEntity != null);
	}

}
