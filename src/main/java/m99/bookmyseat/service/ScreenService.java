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

	public Screen addScreen(Screen screen) {
		return screenRepository.save(screen);
	}

	public List<Screen> addScreenByCount(Integer numberOfScreens, Theater theater) {
		List<Screen> screens = new ArrayList<>();
		for (int i = 1; i <= numberOfScreens; i++) {
			Screen screen = new Screen("Screen " + i, 10, 10, theater);
			screens.add(addScreen(screen));
		}
		return screens;
	}

	public Screen getScreenById(Long id) {
		return screenRepository.findById(id).orElse(null);
	}

}
