package com.tent.database.mapper;

import com.tent.database.modal.Person;

public interface PersonMapper {
	
	Person getUserById(int personId);
	
	void insertPerson(Person person);
	
	void insertPersonPhone(Person person);
	
	void insertPersonAddress(Person person);
	
	int deletePerson(int personId);
}
