package ua.myCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.myCinema.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer>{
	
	@Query("SELECT h FROM Hall h WHERE h.hallName = :hallName")
	Hall findHallByHallName(@Param("hallName") String hallName);

}
