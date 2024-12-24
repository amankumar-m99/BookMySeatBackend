package m99.bookmyseat.entity;

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
public class Seat extends BaseEntity {

	private String seatNumber;

	private Boolean isBooked;

	@ManyToOne
	private Ticket ticket;

	@ManyToOne
	private Screen screen;

}
