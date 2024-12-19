package m99.bookmyseat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.theater.TheaterNotFoundException;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.repository.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	public Theater addTheater(Theater theater) {
		theaterRepository.save(theater);
		return theater;
	}

	public Theater getTheaterById(Long id) {
		Optional<Theater> findById = theaterRepository.findById(id);
		return findById.orElseThrow(()-> new TheaterNotFoundException("No theater found by id " + id));
	}

	public List<Theater> getAllTheaters(){
		List<Theater> theaters = theaterRepository.findAll();
		return theaters;
	}

	public Theater updateTheater(Theater theater) {
		getTheaterById(theater.getId());
		return addTheater(theater);
	}
}
