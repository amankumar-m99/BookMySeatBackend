package m99.bookmyseat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m99.bookmyseat.entity.Timeslot;
import m99.bookmyseat.model.TimeslotRequestDTO;
import m99.bookmyseat.service.TimeslotService;

@RestController
@CrossOrigin
@RequestMapping("timeslot")
public class TimeslotController {

	@Autowired
	private TimeslotService timeslotService;

	@GetMapping("/{id}")
	public ResponseEntity<Timeslot> getByTimeslotId(@PathVariable Long id){
		return new ResponseEntity<>(timeslotService.getByTimeslotId(id), HttpStatus.OK);
	}

	@GetMapping("/theater/{id}")
	public ResponseEntity<List<Timeslot>> getByTheaterId(@PathVariable Long id){
		return new ResponseEntity<>(timeslotService.getByTheaterId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Timeslot> addTheater(@RequestBody TimeslotRequestDTO requestDTO){
		return new ResponseEntity<>(timeslotService.addTimeSlot(requestDTO), HttpStatus.CREATED);
	}

}
