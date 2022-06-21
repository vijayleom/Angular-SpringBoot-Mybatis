package com.tent.database.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tent.database.modal.Person;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceTest {
	
	private static PersonService personService;
	
	private static int personId = -1;

	@Before
	public void setUp() throws Exception {
		personService = new PersonService();
	}
	
	@After
	public void teardown() throws Exception {
		personService = null;
	}

	@Test
	public void testA() {
		Person p = new Person();
		p.setPersonFirstName("Vijay Leo");
		p.setPersonLastName("Marcelin");
		int personId = personService.insertUser(p);
		assertNotNull(personId);
		PersonServiceTest.personId = personId;
		p.setPersonPhoneNumber(9394934L);
		int personPhoneId = personService.insertPhone(p);
		assertNotNull(personPhoneId);
		p.setAddress("Chennai");
		int peronAddressId = personService.insertAddress(p);
		assertNotNull(peronAddressId);
	}
	
	@Test
	public void testB() {
		Person person = personService.getPerson(personId);
		assertNotNull(person);
	}
	
	@Test
	public void testC() {
		//boolean isDeleted = personService.deletePerson(personId);
		//assertTrue(isDeleted);
	}
}
