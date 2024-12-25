package m99.bookmyseat.entity;

import java.util.Date;
import java.util.List;

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

	@ManyToMany
	private List<Theater> theaters;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

}
