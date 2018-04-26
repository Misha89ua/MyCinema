package ua.myCinema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.enumeration.Country;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter @Setter
public class Person extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private int age;
	
	private Country country;
	
	@Column(name = "actor_biography")
	private String actorBiography;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "film_person",
	joinColumns = @JoinColumn(name = "person_id"),
	inverseJoinColumns = @JoinColumn(name = "film_id"))
	List<Film> filmList = new ArrayList<>();

}
