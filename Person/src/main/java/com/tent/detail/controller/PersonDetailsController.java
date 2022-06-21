package com.tent.detail.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tent.database.modal.Person;
import com.tent.detail.mapping.PersonDetailsDO;
import com.tent.detail.util.PersonTransformerUtil;

@RestController
public class PersonDetailsController {

	Logger log = Logger.getLogger(this.getClass().getName());

	PersonTransformerUtil ptu = new PersonTransformerUtil();

	@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200"})
	@RequestMapping(value = "/saveperson", method = RequestMethod.POST)
	public ResponseEntity<Object> savePerson(@RequestBody PersonDetailsDO personDo) {
		Person person = PersonTransformerUtil.getPersonObject(personDo);
		try {
			int personId = ptu.savePersonDetails(person);
			if(personId > 0) {
			return new ResponseEntity<>("Details of the person saved to the Database. Person ID: "+personId, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Person details were not persisted into the db. Please check application logs.", HttpStatus.CREATED);
			}
		}catch(Exception ex) {
			return new ResponseEntity<>("Exception Occurred in the process:"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200"})
	@RequestMapping(value = "/findperson")
	public ResponseEntity<Object> findPerson(@RequestParam(value = "personId", required = true)int id) {
		log.info("Show the personId:"+id);
		try {
			PersonDetailsDO pdo = ptu.getPersonDetails(id);
			if(pdo != null) {
				return new ResponseEntity<>(pdo, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No data available for the given person id:"+id, HttpStatus.OK);
			}
		}catch(Exception ex) {
			return new ResponseEntity<>("Exception Occurred in the process:"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200"})
	@RequestMapping(value = "/removeperson/{personId}", method =  RequestMethod.DELETE)
	public ResponseEntity<Object> removePerson(@PathVariable("personId") int id) {
		log.info("Show the personId to be removed:"+id);
		try {
			boolean isRemoved = ptu.removePersonDetails(id);
			if(isRemoved) {
				return new ResponseEntity<>("Person with ID: "+id+" removed permanently from the database.", HttpStatus.MOVED_PERMANENTLY);
			}else {
				return new ResponseEntity<>("Person with ID: "+id+" was not found in the database for deletion." , HttpStatus.NOT_MODIFIED);

			}
		}catch(Exception ex) {
			return new ResponseEntity<>("Exception Occurred in the process:"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
