package ua.myCinema.mapper;

import java.io.IOException;

import ua.myCinema.domain.FilmAddRequest;
import ua.myCinema.domain.FilmRequest;
import ua.myCinema.entity.Film;
import ua.myCinema.service.utils.CustomFileUtils;

public interface FilmMapper {
	
	public static Film filmAddRequestToFilmEntity(FilmAddRequest request) {
		Film film = new Film();
		film.setFilmName(request.getFilmName());
		film.setYear(request.getYear());
		film.setMovieLength(request.getMovieLength());
		film.setFilmDescription(request.getFilmDescription());
		film.setCategory(request.getCategory());
		film.setCountry(request.getCountry());
		film.setPersonList(request.getPersonList());
		return film;
	}
	
	public static FilmRequest filmEntityToFilmRequest(Film film) throws IOException {
		FilmRequest request = new FilmRequest();
		request.setId(film.getId());
		request.setFilmName(film.getFilmName());
		request.setYear(film.getYear());
		request.setMovieLength(film.getMovieLength());
		request.setFilmDescription(film.getFilmDescription());
		request.setNumberOfLikes(film.getNumberOfLikes());
		request.setNumberOfDislikes(film.getNumberOfDislikes());
		request.setImagePath(film.getImagePath());
		request.setImage(CustomFileUtils.getImage("films", "film_" + film.getId(),film.getImagePath()));
		request.setCategory(film.getCategory());
		request.setCountry(film.getCountry());
		request.setPersonList(film.getPersonList());
		return request;
	}
	
	public static Film filmRequestToFilmEntity(FilmRequest request) {
		Film film = new Film();
		film.setId(request.getId());
		film.setFilmName(request.getFilmName());
		film.setYear(request.getYear());
		film.setMovieLength(request.getMovieLength());
		film.setFilmDescription(request.getFilmDescription());
		film.setNumberOfLikes(request.getNumberOfLikes());
		film.setNumberOfDislikes(request.getNumberOfDislikes());
		film.setImagePath(request.getImagePath());
		film.setCategory(request.getCategory());
		film.setCountry(request.getCountry());
		film.setPersonList(request.getPersonList());
		return film;
	}
}
