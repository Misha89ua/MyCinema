package ua.myCinema.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.enumeration.Role;

@Entity
@Table(name = "user", indexes = @Index(columnList = "email, last_name"))
@NoArgsConstructor
@Getter @Setter
public class UserEntity extends BaseEntity {
	
	private String email;
	
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birdth")
	private Calendar dateOfBirdth;
	
	@Column(name = "image_path")
	private String imagePath;
	
	private Role role;
}
