package ua.myCinema.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import ua.myCinema.domain.RegisterRequest1;

@Component
public class CheckMailTokenValidator implements ConstraintValidator<CheckMailToken, RegisterRequest1> {

	@Override
	public void initialize(CheckMailToken arg0) {
	}

	@Override
	public boolean isValid(RegisterRequest1 user, ConstraintValidatorContext context) {
		if(String.valueOf(user.getToken()).equals(String.valueOf(user.getTokenConfirmation()))) {
			return true;
		}
		return false;
	}
}
