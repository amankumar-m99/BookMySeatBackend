package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
