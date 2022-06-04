package com.Springbootdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.Springbootdemo.model.Person;

@Repository("personImpl")
public class PersonImpl implements PersonDao{
	
	private static List<Person> list = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		list.add(new Person(id, person.getFname(), person.getLname()));
		return 1;
	}

	@Override
	public List<Person> selectAllPerson() {
		return list;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return list.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	@Override
	public int deletePersonByid(UUID id) {
		Optional<Person> personMaybe = selectPersonById(id);
		if(personMaybe.isPresent()) {
			list.remove(personMaybe.get());
			return 1;
		}
		return 0;
	}

	@Override
	public int updatePersonByid(UUID id, Person person) {
		return selectPersonById(id)
				.map(p -> {
			int indexofPersonToDelete = list.indexOf(p);
			if(indexofPersonToDelete >=0) {
				list.set(indexofPersonToDelete, new Person(id, person.getFname(), person.getLname()));
				return 1;
			}
			return 0;
		})
			.orElse(0);
	}

}
