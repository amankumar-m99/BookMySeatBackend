package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.dto.MovieBookingShowDTO;
import m99.bookmyseat.dto.ShowtimeDTO;
import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.entity.Timeslot;
import m99.bookmyseat.model.ShowtimeFormModel;
import m99.bookmyseat.repository.ShowtimeRepository;

@Service
public class ShowtimeService {

	@Autowired
	private ShowtimeRepository showtimeRepository;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ScreenService screenService;

	@Autowired
	private TheaterService theaterService;

	@Autowired
	private TicketService ticketService;

	public List<Showtime> addShowtime(List<ShowtimeFormModel> models) {
		List<Showtime> showtimes = new ArrayList<Showtime>();
		for (ShowtimeFormModel model : models) {
			Movie movie = movieService.getMovieById(model.getMovieId());
			Screen screen = screenService.getScreenById(model.getScreenId());
			Theater theater = theaterService.getTheaterById(model.getTheaterId());
			Timeslot timeslot = theater.getTimeslots().stream().filter(t -> t.getId() == model.getTimeslotId())
					.findFirst().orElse(null);

			Showtime showtime = Showtime.builder().timeslot(timeslot).date(model.getDate()).movie(movie).screen(screen)
					.theater(theater).build();
			showtime = showtimeRepository.save(showtime);
			showtime.setTickets(ticketService.addTickets(screen.getMaximumRows(), screen.getMaximumCols(), showtime));
			showtime = showtimeRepository.save(showtime);
			showtimes.add(showtime);
		}
		return showtimes;
	}

	public Showtime getShowtimeById(Long showtimeId) {
		return showtimeRepository.findById(showtimeId).orElse(null);
	}

	public List<MovieBookingShowDTO> findShowtimeByMovieId(Long movieId, Date date){
		List<MovieBookingShowDTO> dtoList = new ArrayList<>();
		List<Showtime> shows = showtimeRepository.findShowsByMovieId(movieId, date);
		Map<Theater, List<Showtime>> theaters = new HashMap<>();
		for(Showtime show: shows) {
			Theater theater = show.getTheater();
			if(!theaters.containsKey(theater)) {
				theaters.put(theater, new ArrayList<>());
			}
			theaters.get(theater).add(show);
		}
		theaters.forEach((theater,showtimes) -> {
			MovieBookingShowDTO dto = MovieBookingShowDTO.builder()
					.theaterId(theater.getId())
					.theaterName(theater.getName())
					.theaterLocation(theater.getLocation())
					.theaterPhoneNumber(theater.getPhoneNumber())
					.showtimeDTOs(ShowtimeDTO.getObjects(showtimes))
					.build();
			dtoList.add(dto);
		});
		return dtoList;
	}
}
