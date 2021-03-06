package ua.myCinema.domain;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.validator.CheckIfUserEmailExists;
import ua.myCinema.validator.CheckMailToken;

@NoArgsConstructor
@Getter @Setter
@CheckMailToken
public class RegisterRequest1 {
	
	@Pattern(regexp = "[a-zA-Z].+[a-zA-Z0-9+.]+@[A-Za-z]{2,5}+.[A-Za-z]{2,4}$", message = "Невірний формат e-mail адреси")
	@CheckIfUserEmailExists
	@NotEmpty (message = "поле E-mail не може бути пустим")
	private String email;
	
	private String token;
	
	private String tokenConfirmation;
}
