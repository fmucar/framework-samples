package com.cooldatasoft.sms.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cooldatasoft.jpa.data.CustomerListPhone;
import com.cooldatasoft.jpa.repositories.CustomerListPhoneRepository;
import com.cooldatasoft.repository.util.ObjectSampler;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public class CustomerListPhoneRepositoryTest extends AbstractRepositoryTest {

	private CustomerListPhone customerListPhone;
	@Autowired
	private CustomerListPhoneRepository customerListPhoneRepository;

	@Before
	public void setUp() {
		customerListPhone = ObjectSampler.createCustomerListPhone();
	}

	@Test
	public void save() {
		CustomerListPhone newEntity = customerListPhoneRepository.save(customerListPhone);
		assertTrue("There must be a CustomerListPhone now", newEntity != null);
	}

}
