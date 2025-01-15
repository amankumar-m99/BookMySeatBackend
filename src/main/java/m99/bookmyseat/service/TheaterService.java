package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.theater.TheaterNotFoundException;
import m99.bookmyseat.customexception.user.UserNotFoundException;
import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.model.TheaterFormModel;
import m99.bookmyseat.model.TheaterJSONModel;
import m99.bookmyseat.model.TheaterMovieAddModel;
import m99.bookmyseat.repository.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ScreenService screenService;

	private Theater saveTheaterToRepository(Theater theater) {
		theaterRepository.save(theater);
		return theater;
	}

	public Theater addTheater(TheaterFormModel model) {
		User user = userService.getUserById(model.getOwnerId());
		if (user == null) {
			throw new UserNotFoundException("Invalid owner id");
		}
		Theater theater = Theater.builder().name(model.getName()).location(model.getLocation()).owner(user)
				.phoneNumber(model.getPhoneNumber()).createdAt(new Date()).build();
		theater = saveTheaterToRepository(theater);
		theater.setScreens(screenService.addScreenByCount(model.getNumberOfScreens(), theater));
		theater = saveTheaterToRepository(theater);
		return theater;
	}

	public TheaterJSONModel addTheaterJSON(TheaterFormModel model) {
		TheaterJSONModel jsonFromTheater = TheaterJSONModel.getModel(addTheater(model));
		return jsonFromTheater;
	}

	public Long getTheaterCount() {
		return theaterRepository.count();
	}


	public Theater getTheaterById(Long id) {
		Optional<Theater> findById = theaterRepository.findById(id);
		Theater theater = findById.orElseThrow(() -> new TheaterNotFoundException("No theater found by given id"));
		return theater;
	}

	public TheaterJSONModel getTheaterByIdJSON(Long id) {
		return TheaterJSONModel.getModel(getTheaterById(id));
	}

	public List<Theater> getAllTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		return theaters;
	}

	public List<TheaterJSONModel> getAllTheatersJSON() {
		List<TheaterJSONModel> theaterJSONModels = TheaterJSONModel.getModels(getAllTheaters());
		return theaterJSONModels;
	}

	public List<Theater> getAllTheatersByOwner(Long ownerId) {
		List<Theater> theaters = theaterRepository.findByOwnerId(ownerId);
		return theaters;
	}

	public List<TheaterJSONModel> getAllTheatersByOwnerJSON(Long ownerId) {
		List<TheaterJSONModel> theaterJSONModels = TheaterJSONModel.getModels(getAllTheatersByOwner(ownerId));
		return theaterJSONModels;
	}

	public Theater updateTheater(Theater theater) {
		getTheaterById(theater.getId());
		return saveTheaterToRepository(theater);
	}

	public TheaterJSONModel updateTheaterJSON(Theater theater) {
		return TheaterJSONModel.getModel(updateTheater(theater));
	}

	public Theater addMovieToTheater(TheaterMovieAddModel model) {
		Theater theater = getTheaterById(model.getTheaterId());
		Movie movie = movieService.getMovieById(model.getMovieId());
		List<Movie> movies = theater.getMovies();
		if (movies == null) {
			movies = new ArrayList<Movie>();
		}
		movies.add(movie);
		return saveTheaterToRepository(theater);
	}

	public TheaterJSONModel addMovieToTheaterJSON(TheaterMovieAddModel model) {
		return TheaterJSONModel.getModel(addMovieToTheater(model));
	}
}
