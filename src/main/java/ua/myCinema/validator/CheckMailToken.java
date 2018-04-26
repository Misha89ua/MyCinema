package ua.myCinema.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckMailTokenValidator.class)
public @interface CheckMailToken {
	
	String message() default "Не вірний код";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};

}
