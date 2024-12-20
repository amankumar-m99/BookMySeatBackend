package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Seat;
import m99.bookmyseat.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	public List<Seat> addSeatsToScreen(Screen screen) {
		char maxRows = 'E';
		char maxCols = 8;
		List<Seat> seats = new ArrayList<>();
		for(char row = 'A'; row <= maxRows; row++) {
			for(int col = 1; col <= maxCols; col++) {
				String seatNUmber = ""+row+""+col;
				seats.add(new Seat(1L, seatNUmber, false, null, screen));
			}
		}
		seats = seatRepository.saveAll(seats);
		return seats;
	}

//	public List<Seat> getAllSeatsOfScreen(Screen screen){
//		return Collections.emptyList();
//	}
//
//	public List<Seat> getAllSeatsOfScreen(Long screenId){
//		return Collections.emptyList();
//	}
}
