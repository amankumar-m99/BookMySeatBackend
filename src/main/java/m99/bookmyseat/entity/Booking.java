package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Booking extends BaseEntity {

	@Temporal(TemporalType.DATE)
	private Date bookingDate;

	@OneToMany(mappedBy = "booking")
	@JsonIgnore
	private List<Ticket> tickets;

	@ManyToOne
	private User user;
}
