package com.Springbootdemo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.Springbootdemo.model.Person;

public interface PersonDao {

	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> selectAllPerson();
	
	Optional<Person> selectPersonById(UUID id);
	
	int deletePersonByid(UUID id);
	
	int updatePersonByid(UUID id, Person person); 
}
