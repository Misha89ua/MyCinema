package ua.myCinema.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seans")
@NoArgsConstructor
@Getter @Setter
public class Seans extends BaseEntity{
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "film_id")
	private Film film;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "hall_id")
	private Hall hall;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "ticket_price")
	private Long ticketPrice;
	
	@Column(name = "sold_tickets")
	private int soldTickets;
	
	@Column(name = "seans_length")
	private int seansLength;
}
