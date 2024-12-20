package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Collections;
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

	public Theater addTheater(TheaterFormModel model) {
		User user = userService.getUserById(model.getOwnerId());
		if (user == null) {
			throw new UserNotFoundException("Invalid owner id");
		}
		Theater theater = Theater.builder().name(model.getName()).location(model.getLocation()).owner(user)
				.phoneNumber(model.getPhoneNumber()).createdAt(new Date()).build();
		theater = addTheater(theater);
		theater.setScreens(getScreensFromModel(model.getScreensCapacities(), theater));
		return addTheater(theater);
	}

	private List<Screen> getScreensFromModel(List<Integer> list, Theater theater) {
		if (list.size() == 0) {
			return Collections.emptyList();
		}
		List<Screen> screens = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Screen screen = new Screen(1L, "Screen " + i, null, null, theater);
			screen = screenService.addScreen(screen);
			screen.setSeats(seatService.addSeatsToScreen(screen));
			screen = screenService.addScreen(screen);
			screens.add(screen);
		}
		return screens;
	}

	private Theater addTheater(Theater theater) {
		theaterRepository.save(theater);
		return theater;
	}

	public Theater getTheaterById(Long id) {
		Optional<Theater> findById = theaterRepository.findById(id);
		return findById.orElseThrow(() -> new TheaterNotFoundException("No theater found by given id"));
	}

	public List<Theater> getAllTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		return theaters;
	}

	public Theater updateTheater(Theater theater) {
		getTheaterById(theater.getId());
		return addTheater(theater);
	}
}
