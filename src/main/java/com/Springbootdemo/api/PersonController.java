package com.Springbootdemo.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springbootdemo.model.Person;
import com.Springbootdemo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@PostMapping
	public void insertPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
	@GetMapping(path = "{id}")
	public Optional<Person> personById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		 personService.deletePerson(id);
	}

	@PutMapping(path = "{id}")
	public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person person) {
		personService.updatePerson(id, person);
	}
}
