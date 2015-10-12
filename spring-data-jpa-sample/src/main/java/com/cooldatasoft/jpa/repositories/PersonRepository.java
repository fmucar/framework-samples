package com.cooldatasoft.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooldatasoft.jpa.data.Person;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
	
}
