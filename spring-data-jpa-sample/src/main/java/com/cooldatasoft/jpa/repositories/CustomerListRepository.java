package com.cooldatasoft.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooldatasoft.jpa.data.CustomerList;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public interface CustomerListRepository extends JpaRepository<CustomerList, Long>{
	
}
