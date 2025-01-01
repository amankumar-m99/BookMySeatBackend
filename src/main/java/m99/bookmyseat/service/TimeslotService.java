package m99.bookmyseat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Timeslot;
import m99.bookmyseat.model.TimeslotRequestDTO;
import m99.bookmyseat.repository.TimeslotRepository;

@Service
public class TimeslotService {

	@Autowired
	private TimeslotRepository timeslotRepository;

	@Autowired
	private TheaterService theaterService;

	public Timeslot getByTimeslotId(Long id) {
		return timeslotRepository.findById(id).orElse(null);
	}

	public List<Timeslot> getByTheaterId(Long theaterId) {
		return timeslotRepository.findByTheaterId(theaterId);
	}

	public Timeslot addTimeSlot(TimeslotRequestDTO dto) {
		Timeslot timeslot = new Timeslot(dto.getStartHH(), dto.getStartMM(), theaterService.getTheaterById(dto.getTheaterId()));
		return timeslotRepository.save(timeslot);
	}
}
