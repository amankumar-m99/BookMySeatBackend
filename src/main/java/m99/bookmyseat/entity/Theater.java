package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import m99.bookmyseat.serializer.MovieBackReferenceSerializer;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Theater extends BaseEntity {

	private String name;

	private String location;

	private String phoneNumber;

	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@ManyToOne
	private User owner;

	@OneToMany(mappedBy = "theater")
	private List<Timeslot> timeslots;

	@ManyToMany(fetch = FetchType.EAGER)
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonSerialize(using = MovieBackReferenceSerializer.class)
	private List<Movie> movies;

	@OneToMany(mappedBy =  "theater")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Showtime> showtimes;

	@OneToMany(mappedBy = "theater")
//	@JsonManagedReference
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Screen> screens;

}