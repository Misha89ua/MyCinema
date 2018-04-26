package ua.myCinema.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.enumeration.Role;

@NoArgsConstructor
@Getter @Setter
public class UserProfileEditorRequest {
	
	private int id;
	
	@Pattern(regexp = "[a-zA-Z].+[a-zA-Z0-9+.]+@[A-Za-z]{2,5}+.[A-Za-z]{2,4}$", message = "Невірний формат e-mail адреси")
	@NotEmpty (message = "поле E-mail не може бути пустим")
	private String email;
	private String password;
	
	@NotEmpty (message = "поле імені не може бути пустим")
	private String firstName;
	private String lastName;
	private int dateOfBirdthYear;
	private int dateOfBirdthMonth;
	private int dateOfBirdthDay;
	private String imagePath;
	private Role role;
	private String var;
}
