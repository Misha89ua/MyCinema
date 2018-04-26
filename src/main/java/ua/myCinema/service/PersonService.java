package ua.myCinema.service;

import java.util.List;

import ua.myCinema.entity.Person;

public interface PersonService {
	
	void savePerson(Person entity);
	
	void updatePerson(Person entity);
	
	void deletePerson(int personId);
	
	Person findPersonById(int id);
	
	List<Person> showAllPersons();

}
