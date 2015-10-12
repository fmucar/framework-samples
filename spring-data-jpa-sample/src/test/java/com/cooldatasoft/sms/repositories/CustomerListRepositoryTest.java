package com.cooldatasoft.sms.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cooldatasoft.jpa.data.CustomerList;
import com.cooldatasoft.jpa.repositories.CustomerListRepository;
import com.cooldatasoft.repository.util.ObjectSampler;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public class CustomerListRepositoryTest extends AbstractRepositoryTest {

	private CustomerList customerList;
	@Autowired
	private CustomerListRepository customerListRepository;

	@Before
	public void setUp() {
		customerList = ObjectSampler.createCustomerList();
	}

	@Test
	public void save() {
		CustomerList newEntity = customerListRepository.save(customerList);
		assertTrue("There must be a CustomerList now", newEntity != null);
	}

}
