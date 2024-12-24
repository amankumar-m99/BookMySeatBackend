package m99.bookmyseat.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m99.bookmyseat.entity.Theater;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterJSONModel {

	private Long id;
	private String name;
	private String location;
	private String phoneNumber;
	private Date createdAt;
	private Long ownerId;
	private List<Long> screenIds;
	private List<Long> movieIds;

	public static TheaterJSONModel getJSONFromTheater(Theater theater) {
		return TheaterJSONModel.builder().id(theater.getId()).name(theater.getName()).location(theater.getName())
				.phoneNumber(theater.getPhoneNumber()).createdAt(theater.getCreatedAt())
				.ownerId(theater.getOwner().getId())
				.screenIds(theater.getScreens().stream().map(s -> s.getId()).collect(Collectors.toList()))
				.movieIds(theater.getMovies().stream().map(m -> m.getId()).collect(Collectors.toList())).build();
	}
}
