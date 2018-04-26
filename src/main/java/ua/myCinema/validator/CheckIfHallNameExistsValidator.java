package ua.myCinema.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.myCinema.service.HallService;

public class CheckIfHallNameExistsValidator implements ConstraintValidator<CheckIfHallNameExists, String>{
	
	@Autowired 
	private HallService hallService;
	
	@Override
	public void initialize(CheckIfHallNameExists arg0) {
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return hallService.findHallByHallName(name) != null ? false : true;
	}	

}
