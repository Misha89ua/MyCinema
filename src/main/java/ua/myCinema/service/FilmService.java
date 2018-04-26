package ua.myCinema.service;

import java.io.IOException;
import java.util.List;

import ua.myCinema.domain.ImageRequest;
import ua.myCinema.entity.Film;

public interface FilmService {
	
	void saveFilm(Film entity);
	
	void updateFilm(Film entity);
	
	void deleteFilm(int filmId);
	
	Film findFilmById(int id);
	
	List<Film> showAllFilms();
	
	Film findFilmByFilmName(String filmName);
	
	void uploadFilmImage(ImageRequest request, Film entity) throws IOException;

}
