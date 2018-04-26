package ua.myCinema.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.enumeration.Role;

@NoArgsConstructor
@Getter @Setter
public class UserProfileRequest {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String dateOfBirdth;
	private int age;
	private String image;
	private Role role;

}
