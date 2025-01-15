package m99.bookmyseat.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieBookingShowDTO {

	private Long theaterId;
	private String theaterName;;
	private String theaterLocation;
	private String theaterPhoneNumber;

	private List<ShowtimeDTO> showtimeDTOs;
}
