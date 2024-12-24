package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

	@ManyToOne
	private Showcase showcase;

	@OneToMany(mappedBy = "ticket")
	private List<Seat> seats;

	@ManyToOne
	private User user;

	@Temporal(TemporalType.DATE)
	private Date bookingDate;

}
