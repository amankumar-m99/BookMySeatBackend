package m99.bookmyseat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.model.TheaterFormModel;
import m99.bookmyseat.service.TheaterService;

@RestController
@RequestMapping("theater")
@CrossOrigin
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(theaterService.getTheaterById(id), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Theater>> getAllTheaters(){
		try {
			return new ResponseEntity<>(theaterService.getAllTheaters(), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<Theater> addTheater(@RequestBody TheaterFormModel model) {
		try {
			return new ResponseEntity<>(theaterService.addTheater(model), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<Theater> updateTheater(@RequestBody Theater theater) {
		try {
			return new ResponseEntity<>(theaterService.updateTheater(theater), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
