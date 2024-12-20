package m99.bookmyseat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.repository.ScreenRepository;

@Service
public class ScreenService {

	@Autowired
	private ScreenRepository screenRepository;

	public Screen addScreen(Screen screen) {
		return screenRepository.save(screen);
	}

}
