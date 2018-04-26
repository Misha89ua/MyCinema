package ua.myCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.myCinema.entity.Seans;

public interface SeansRepository extends JpaRepository<Seans, Integer>{

}
