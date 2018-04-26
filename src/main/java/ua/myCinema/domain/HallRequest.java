package ua.myCinema.domain;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.myCinema.entity.Seans;
import ua.myCinema.validator.CheckIfHallNameExists;

@NoArgsConstructor
@Getter @Setter
public class HallRequest {
	
	private int id;
	
	@CheckIfHallNameExists
	@NotEmpty(message = "Потрібно вказати назву фільму")
	private String hallName;
	private int numberOfSeats;
	private List<Seans> seanses;

}
