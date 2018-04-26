package ua.myCinema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.enumeration.Category;
import ua.myCinema.entity.enumeration.Country;

@Entity
@Table(name = "film")
@NoArgsConstructor
@Getter @Setter
public class Film extends BaseEntity{
	
	@Column(name = "film_name")
	private String filmName;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	private int year;
	
	@Enumerated(EnumType.STRING)
	private Country country;
	
	@Column(name = "movie_length")
	private int movieLength;
	
	@Column(name = "film_description", columnDefinition = "TEXT")
	private String filmDescription;
	
	@Column(name = "number_of_likes")
	private int numberOfLikes = 0;
	
	@Column(name = "number_of_dislikes")
	private int numberOfDislikes = 0;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@ManyToMany
	@JoinTable(name = "film_person",
	joinColumns = @JoinColumn(name = "film_id"),
	inverseJoinColumns = @JoinColumn(name = "person_id"))
	List<Person> personList = new ArrayList<>();
	
	@OneToMany(mappedBy = "film", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Seans>seanses = new ArrayList<>();

}
