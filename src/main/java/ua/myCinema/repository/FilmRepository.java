package ua.myCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.myCinema.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	
	@Query("SELECT f FROM Film f WHERE f.filmName = :filmName")
	Film findFilmByFilmName(@Param("filmName") String filmName);

}
