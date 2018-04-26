package ua.myCinema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hall")
@NoArgsConstructor
@Getter @Setter
public class Hall extends BaseEntity{
	
	@Column(name = "hall_name")
	private String hallName;
	
	@Column(name = "number_of_seats")
	private int numberOfSeats;
	
	@OneToMany(mappedBy = "hall", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Seans>seanses = new ArrayList<>();

}
