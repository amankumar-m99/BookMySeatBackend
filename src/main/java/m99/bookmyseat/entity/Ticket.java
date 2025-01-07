package m99.bookmyseat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Ticket extends BaseEntity {
	
	private String seatNumber;

	private double price;

	private Boolean isBooked;

	@ManyToOne
	@JsonIgnore
	private Showtime showtime;

	@ManyToOne
	@JsonIgnore
	private Booking booking;

}
