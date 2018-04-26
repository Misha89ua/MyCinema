package ua.myCinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.myCinema.entity.Person;
import ua.myCinema.repository.PersonRepository;
import ua.myCinema.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void savePerson(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(int personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> showAllPersons() {
		return personRepository.findAll();
	}

}
