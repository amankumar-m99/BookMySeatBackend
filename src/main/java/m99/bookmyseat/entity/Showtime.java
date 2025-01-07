package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m99.bookmyseat.serializer.MovieBackReferenceSerializer;
import m99.bookmyseat.serializer.TheaterBackReferenceSerializer;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Showtime extends BaseEntity {

	@ManyToOne
	private Timeslot timeslot;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	@JsonSerialize(using = MovieBackReferenceSerializer.class)
	private Movie movie;

	@ManyToOne
	private Screen screen;

	@ManyToOne
	@JsonSerialize(using = TheaterBackReferenceSerializer.class)
	private Theater theater;

	@OneToMany(mappedBy = "showtime")
	@JsonIgnore
	private List<Booking> bookings;

	@OneToMany(mappedBy = "showtime")
	private List<Ticket> tickets;

}
