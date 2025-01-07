package m99.bookmyseat.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import m99.bookmyseat.entity.Showtime;

@Getter
@Setter
public class ShowtimeDTO {

	private Long id;
	private int startHH;
	private int startMM;
	private Date date;
	private String movie;
	private String screen;
	private String theater;

	public static ShowtimeDTO getObject(Showtime showtime) {
		ShowtimeDTO response = new ShowtimeDTO();
		response.setId(showtime.getId());
		response.setStartHH(showtime.getTimeslot().getStartHH());
		response.setStartMM(showtime.getTimeslot().getStartMM());
		response.setDate(showtime.getDate());
		response.setMovie(showtime.getMovie().getTitle());
		response.setScreen(showtime.getScreen().getName());
		response.setTheater(showtime.getTheater().getName()+", " + showtime.getTheater().getLocation());
		return response;
	}

	public static List<ShowtimeDTO> getObjects(List<Showtime> showtimes){
		List<ShowtimeDTO> dtos = new ArrayList<>();
		for(Showtime showtime: showtimes) {
			dtos.add(getObject(showtime));
		}
		return dtos;
	}
}
