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
import m99.bookmyseat.model.TheaterJSONModel;
import m99.bookmyseat.model.TheaterMovieAddModel;
import m99.bookmyseat.service.TheaterService;

@RestController
@RequestMapping("theater")
@CrossOrigin
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@GetMapping("/get/count")
	public ResponseEntity<Long> getTheaterCount(){
		try {
			return new ResponseEntity<>(theaterService.getTheaterCount(), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(theaterService.getTheaterById(id), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/json/get/{id}")
	public ResponseEntity<TheaterJSONModel> getTheaterByIdJSON(@PathVariable Long id){
		try {
			return new ResponseEntity<>(theaterService.getTheaterByIdJSON(id), HttpStatus.OK);
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

	@GetMapping("/json/all")
	public ResponseEntity<List<TheaterJSONModel>> getAllTheatersJSON(){
		try {
			return new ResponseEntity<>(theaterService.getAllTheatersJSON(), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Theater>> getAllTheatersByOwner(@PathVariable Long ownerId){
		try {
			return new ResponseEntity<>(theaterService.getAllTheatersByOwner(ownerId), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/json/owner/{ownerId}")
	public ResponseEntity<List<TheaterJSONModel>> getAllTheatersByOwnerJSON(@PathVariable Long ownerId){
		try {
			return new ResponseEntity<>(theaterService.getAllTheatersByOwnerJSON(ownerId), HttpStatus.OK);
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

	@PostMapping("/json")
	public ResponseEntity<TheaterJSONModel> addTheaterJSON(@RequestBody TheaterFormModel model) {
		try {
			return new ResponseEntity<>(theaterService.addTheaterJSON(model), HttpStatus.CREATED);
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

	@PutMapping("/json")
	public ResponseEntity<TheaterJSONModel> updateTheaterJSON(@RequestBody Theater theater) {
		try {
			return new ResponseEntity<>(theaterService.updateTheaterJSON(theater), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/addMovie")
	public ResponseEntity<Theater> addMoviesToTheater(@RequestBody TheaterMovieAddModel model) {
		try {
			return new ResponseEntity<>(theaterService.addMovieToTheater(model), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/json/addMovie")
	public ResponseEntity<TheaterJSONModel> addMoviesToTheaterJSON(@RequestBody TheaterMovieAddModel model) {
		try {
			return new ResponseEntity<>(theaterService.addMovieToTheaterJSON(model), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
