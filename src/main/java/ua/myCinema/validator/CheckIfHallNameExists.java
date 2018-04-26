package ua.myCinema.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = CheckIfHallNameExistsValidator.class)
public @interface CheckIfHallNameExists {
	
	String message() default "Зал з такою назвою вже існує!";
	Class<?>[]groups() default{};
	Class<? extends Payload>[] payload() default{};

}
