package m99.bookmyseat.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import m99.bookmyseat.entity.BaseEntity;
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

	public static TheaterJSONModel getModel(Theater theater) {
		return TheaterJSONModel.builder().id(theater.getId()).name(theater.getName()).location(theater.getLocation())
				.phoneNumber(theater.getPhoneNumber()).createdAt(theater.getCreatedAt())
				.ownerId(theater.getOwner().getId())
				.screenIds(BaseEntity.getIdsFromList(theater.getScreens()))
				.movieIds(BaseEntity.getIdsFromList(theater.getMovies())).build();
	}

	public static List<TheaterJSONModel> getModels(List<Theater> theaters) {
		return theaters.stream().map(e-> getModel(e)).collect(Collectors.toList());
	}
}


