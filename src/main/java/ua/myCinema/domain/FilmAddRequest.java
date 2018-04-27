package ua.myCinema.domain;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.Person;
import ua.myCinema.entity.enumeration.Category;
import ua.myCinema.entity.enumeration.Country;
import ua.myCinema.validator.CheckIfFilmNameExists;

@NoArgsConstructor
@Getter @Setter
public class FilmAddRequest {
	
	private int id;
	
	@CheckIfFilmNameExists
	@NotEmpty(message = "Потрібно вказати назву фільму")
	private String filmName;
	private int year;
	private int movieLength;
	private String filmDescription;
	private String imagePath;
	private String image;
	private int numberOfLikes;
	private int numberOfDislikes;
	private List<Category> categorysList = Arrays.asList(Category.values());
	private Category category = Category.UNKNOWN;
	private List<Country> countriesList = Arrays.asList(Country.values());
	private Country country = Country.UNKNOWN;
	private List<Person> personList;
	private String var = "add";
}
