package m99.bookmyseat.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieJSON {

	private Long id;
	private String title;
	private String description;
	private String genre;
	private int duration;
	private String language;
	private double rating;
	private String posterUrl;
	private List<Integer> theaterIds;
	private Date releaseDate;
}
