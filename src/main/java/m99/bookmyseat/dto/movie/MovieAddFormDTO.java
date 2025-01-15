package m99.bookmyseat.dto.movie;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieAddFormDTO {

	private Long id;

	private String title;

	private String description;

	private String genre;

	private int duration;

	private String language;

	private double rating;

	private Date releaseDate;
}
