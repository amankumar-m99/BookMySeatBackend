package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import m99.bookmyseat.serializer.TheaterBackReferenceSerializer;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Movie extends BaseEntity {

	private String title;

	private String description;

	private String genre;

	private int duration;

	private String language;

	private double rating;

	private String posterUrl;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@ManyToMany(mappedBy = "movies")
    @JsonSerialize(using = TheaterBackReferenceSerializer.class)
	private List<Theater> theaters;

}
