package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.theater.TheaterNotFoundException;
import m99.bookmyseat.customexception.user.UserNotFoundException;
import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.model.TheaterFormModel;
import m99.bookmyseat.model.TheaterJSONModel;
import m99.bookmyseat.repository.TheaterRepository;

@Service
public class TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private UserService userService;


	@Autowired
	private ScreenService screenService;

	@Autowired
	private SeatService seatService;

	public TheaterJSONModel addTheater(TheaterFormModel model) {
		User user = userService.getUserById(model.getOwnerId());
		if (user == null) {
			throw new UserNotFoundException("Invalid owner id");
		}
		Theater theater = Theater.builder().name(model.getName()).location(model.getLocation()).owner(user)
				.phoneNumber(model.getPhoneNumber()).createdAt(new Date()).build();
		theater = addTheater(theater);
		theater.setScreens(insertScreensInDB(model.getNumberOfScreens(), theater));
		theater = addTheater(theater);
		return TheaterJSONModel.getJSONFromTheater(theater);
	}

	private List<Screen> insertScreensInDB(Integer numberOfScreens, Theater theater) {
		List<Screen> screens = new ArrayList<>();
		for (int i = 1; i <= numberOfScreens; i++) {
			Screen screen = new Screen("Screen " + i, null, theater);
			screen = screenService.addScreen(screen);
			seatService.addSeatsToScreen(screen);
			screens.add(screen);
		}
		return screens;
	}

	private Theater addTheater(Theater theater) {
		theaterRepository.save(theater);
		return theater;
	}

	public TheaterJSONModel getTheaterById(Long id) {
		Optional<Theater> findById = theaterRepository.findById(id);
		Theater theater = findById.orElseThrow(() -> new TheaterNotFoundException("No theater found by given id"));
		return TheaterJSONModel.getJSONFromTheater(theater);
	}

	public List<Theater> getAllTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		return theaters;
	}

	public List<Theater> getAllTheatersByOwner(Long ownerId) {
		List<Theater> theaters = theaterRepository.findAll();
		return theaters;
	}

	public Theater updateTheater(Theater theater) {
		getTheaterById(theater.getId());
		return addTheater(theater);
	}
}
