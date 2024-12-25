package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.repository.ScreenRepository;

@Service
public class ScreenService {

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private SeatService seatService;

	public Screen addScreen(Screen screen) {
		return screenRepository.save(screen);
	}

	public List<Screen> addScreenByCount(Integer numberOfScreens, Theater theater) {
		List<Screen> screens = new ArrayList<>();
		for (int i = 1; i <= numberOfScreens; i++) {
			Screen screen = new Screen("Screen " + i, theater);
			screen = addScreen(screen);
			seatService.addSeatsToScreen(screen);
			screens.add(screen);
		}
		return screens;
	}

}
