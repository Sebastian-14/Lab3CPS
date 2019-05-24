package com.tecsup.petclinic.service;

import java.util.List;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param firstName
	 * @return
	 */
	List<Owner> findByFirstName(String firstName);

	/**
	 * 
	 * @param lastName
	 * @return
	 */
	List<Owner> findByLastName(String lastName);

	/**
	 * 
	 * @param city
	 * @return
	 */
	List<Owner> findByCity(String city);

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();
}
