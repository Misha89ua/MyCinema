package ua.myCinema.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.myCinema.domain.ImageRequest;
import ua.myCinema.entity.Film;
import ua.myCinema.repository.FilmRepository;
import ua.myCinema.service.FilmService;
import ua.myCinema.service.utils.CustomFileUtils;

@Service
public class FilmServiceImpl implements FilmService{
	
	private FilmRepository filmRepository;
	
	@Autowired
	public FilmServiceImpl(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@Override
	public void saveFilm(Film entity) {
		filmRepository.save(entity);
		CustomFileUtils.createFolder("films", "film_" + entity.getId());
	}

	@Override
	public void updateFilm(Film entity) {
		filmRepository.save(entity);
	}

	@Override
	public void deleteFilm(int filmId) {
		filmRepository.delete(filmId);;
	}

	@Override
	public Film findFilmById(int id) {
		return filmRepository.findOne(id);
	}

	@Override
	public List<Film> showAllFilms() {
		return filmRepository.findAll();
	}

	@Override
	public Film findFilmByFilmName(String filmName) {
		return filmRepository.findFilmByFilmName(filmName);
	}
	
	@Override
	public void uploadFilmImage(ImageRequest request, Film entity) throws IOException {
		entity.setImagePath(request.getFile().getOriginalFilename());
		CustomFileUtils.createImage("films", "film_" + entity.getId(), request.getFile());
		this.updateFilm(entity);
	}
	
	

}
