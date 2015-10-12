package com.cooldatasoft.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooldatasoft.jpa.data.Customer;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
