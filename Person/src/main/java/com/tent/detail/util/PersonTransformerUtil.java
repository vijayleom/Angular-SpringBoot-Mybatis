package com.tent.detail.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.tent.database.modal.Person;
import com.tent.database.services.PersonService;
import com.tent.detail.mapping.PersonDetailsDO;

public class PersonTransformerUtil {

	private PersonService personService = new PersonService();
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * @param pdo
	 * @return
	 */
	public static Person getPersonObject(PersonDetailsDO pdo) {
		
		Person person = new Person();
		
		person.setPersonPhoneNumber(pdo.getPersonPhoneNumber());
		person.setPersonLastName(pdo.getPersonLastName());
		person.setPersonFirstName(pdo.getPersonFirstName());
		person.setAddress(pdo.getAddress());
		
		return person;
	}
	
	/**
	 * @param pdo
	 * @return
	 */
	private static PersonDetailsDO getPersonDataObject(Person person) {
		
		PersonDetailsDO personDO = new PersonDetailsDO();
		
		personDO.setAddress(person.getAddress());
		personDO.setPersonFirstName(person.getPersonFirstName());
		personDO.setPersonId(person.getPersonId());
		personDO.setPersonLastName(person.getPersonLastName());
		personDO.setPersonPhoneNumber(person.getPersonPhoneNumber());
		
		return personDO;
	}
	
	/**
	 * @param person
	 * @return
	 */
	public int savePersonDetails(final Person person) {
		
		int personId = -1;
		
		try {
			personId = personService.insertUser(person);
			
			if(personId != -1) {
				int personPhoneId = personService.insertAddress(person);
				int personAddressId = personService.insertPhone(person);
				
				log.info("Person Phone ID:"+personPhoneId+" | Person Address ID:"+personAddressId);
			}
			
			log.info("Person Details inserted successfully: Id => "+personId);
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Exception Occurred => "+ex.getMessage());
		}
		
		return personId;
	}
	
	/**
	 * @param personId
	 * @return
	 */
	public PersonDetailsDO getPersonDetails(int personId) {
		PersonDetailsDO personDo = null;
		
		try {
			Person person = personService.getPerson(personId);
			
			log.info("Person Details retrieved: Details => "+person);
			
			if(person != null) {
				personDo = getPersonDataObject(person);
			}
			
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Exception Occurred => "+ex.getMessage());
		}
		
		return personDo;
	}
	
	/**
	 * @param personId
	 * @return
	 */
	public boolean removePersonDetails(int personId) {
		boolean isRemoved = Boolean.FALSE;
		try {
			isRemoved = personService.deletePerson(personId);
			
			log.info("Person Details retrieved: Details => "+isRemoved);
				
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Exception Occurred => "+ex.getMessage());
		}
		
		return isRemoved;
	}
}
