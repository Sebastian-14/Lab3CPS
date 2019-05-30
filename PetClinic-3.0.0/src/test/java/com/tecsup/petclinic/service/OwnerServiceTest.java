package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String LAST_NAME = "Franklin";
		Owner owner = null;
		
		try {
			owner = ownerService.findById(ID);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(LAST_NAME, owner.getLastName());

	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByLastName() {

		String FIND_LAST_NAME = "Franklin";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByLastName(FIND_LAST_NAME);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByCity() {

		String CITY = "Madison";
		int SIZE_EXPECTED = 4;

		List<Owner> owners = ownerService.findByCity(CITY);

		assertEquals(SIZE_EXPECTED, owners.size());
	}

	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String OWNER_LAST_NAME = "Sanchez";
		String OWNER_FIRST_NAME = "Sebas";
		String OWNER_CITY = "Lima";

		Owner owner = new Owner(OWNER_FIRST_NAME, OWNER_LAST_NAME, OWNER_CITY);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		assertThat(owner.getId()).isNotNull();
		assertEquals(OWNER_FIRST_NAME, owner.getFirstName());
		assertEquals(OWNER_LAST_NAME, owner.getLastName());
		assertEquals(OWNER_CITY, owner.getCity());

	}
	

}
