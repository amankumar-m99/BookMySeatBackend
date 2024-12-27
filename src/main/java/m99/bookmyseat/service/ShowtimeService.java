package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Theater;
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

	public List<Showtime> addShowtime(List<ShowtimeFormModel> models) {
		List<Showtime> showtimes = new ArrayList<Showtime>();
		for(ShowtimeFormModel model: models) {
			Movie movie = movieService.getMovieById(model.getMovieId());
			Screen screen = screenService.getScreenById(model.getScreenId());
			Theater theater = theaterService.getTheaterById(model.getTheaterId());
			Showtime showtime = Showtime.builder()
					.movie(movie)
					.screen(screen)
					.theater(theater)
					.startHH(model.getStartHH())
					.startMM(model.getStartMM())
					.startTime(new Date())
					.build();
			showtimes.add(showtimeRepository.save(showtime));
		}
		return showtimes;
	}
}
