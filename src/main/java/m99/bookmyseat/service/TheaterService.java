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

	public TheaterJSONModel addTheater(TheaterFormModel model) {
		User user = userService.getUserById(model.getOwnerId());
		if (user == null) {
			throw new UserNotFoundException("Invalid owner id");
		}
		Theater theater = Theater.builder().name(model.getName()).location(model.getLocation()).owner(user)
				.phoneNumber(model.getPhoneNumber()).createdAt(new Date()).build();
		theater = addTheater(theater);
		theater.setScreens(screenService.addScreenByCount(model.getNumberOfScreens(), theater));
		theater = addTheater(theater);
		TheaterJSONModel jsonFromTheater = TheaterJSONModel.getModel(theater);
		return jsonFromTheater;
	}

	private Theater addTheater(Theater theater) {
		theaterRepository.save(theater);
		return theater;
	}

	public Theater getTheaterById(Long id) {
		Optional<Theater> findById = theaterRepository.findById(id);
		Theater theater = findById.orElseThrow(() -> new TheaterNotFoundException("No theater found by given id"));
		return theater;
	}

	public TheaterJSONModel getTheaterJSONById(Long id) {
		return TheaterJSONModel.getModel(getTheaterById(id));
	}

	public List<TheaterJSONModel> getAllTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		List<TheaterJSONModel> theaterJSONModels = TheaterJSONModel.getModels(theaters);
		return theaterJSONModels;
	}

	public List<TheaterJSONModel> getAllTheatersByOwner(Long ownerId) {
		List<Theater> theaters = theaterRepository.findByOwnerId(ownerId);
		List<TheaterJSONModel> theaterJSONModels = TheaterJSONModel.getModels(theaters);
		return theaterJSONModels;
	}

	public Theater updateTheater(Theater theater) {
		getTheaterById(theater.getId());
		return addTheater(theater);
	}

	public TheaterJSONModel updateTheater(TheaterMovieAddModel model) {
		Theater theater = getTheaterById(model.getTheaterId());
		Movie movie = movieService.getMovieById(model.getMovieId());
		List<Movie> movies = theater.getMovies();
		if(movies == null) {
			movies = new ArrayList<Movie>();
		}
		movies.add(movie);
		return TheaterJSONModel.getModel(addTheater(theater));
	}
}
