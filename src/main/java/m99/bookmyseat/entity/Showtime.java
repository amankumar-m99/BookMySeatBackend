package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

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
	@JsonSerialize(using = MovieBackReferenceSerializer.class)
	private Movie movie;

	@ManyToOne
	private Screen screen;

	@ManyToOne
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonSerialize(using = TheaterBackReferenceSerializer.class)
	private Theater theater;

	@OneToMany(mappedBy = "showtime")
	private List<Ticket> tickets;

	private int startHH;

	private int startMM;

	@Temporal(TemporalType.DATE)
	private Date startTime;

}
