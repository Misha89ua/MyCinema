package ua.myCinema.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.myCinema.service.FilmService;

@Component
public class CheckIfFilmNameExistsValidator implements ConstraintValidator<CheckIfFilmNameExists, String>{
	
	@Autowired 
	private FilmService filmService;
	
	@Override
	public void initialize(CheckIfFilmNameExists arg0) {
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return filmService.findFilmByFilmName(name) != null ? false : true;
	}	

}
