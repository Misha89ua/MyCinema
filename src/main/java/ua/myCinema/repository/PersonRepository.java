package ua.myCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.myCinema.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
