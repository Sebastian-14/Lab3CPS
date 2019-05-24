package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	// Fetch pets by firstName
	List<Owner> findByFirstName(String firstName);

	// Fetch pets by lastName
	List<Owner> findByLastName(String lastName);

	// Fetch pets by city
	List<Owner> findByCity(String city);
}
