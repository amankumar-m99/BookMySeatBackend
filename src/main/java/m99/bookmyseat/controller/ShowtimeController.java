package m99.bookmyseat.controller;

import java.util.Date;
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

import m99.bookmyseat.dto.MovieBookingShowDTO;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.model.ShowtimeFormModel;
import m99.bookmyseat.service.ShowtimeService;

@RestController
@CrossOrigin
@RequestMapping("showtime")
public class ShowtimeController {

	@Autowired
	private ShowtimeService showtimeService;

	@PostMapping
	public ResponseEntity<List<Showtime>> addShowTime(@RequestBody List<ShowtimeFormModel> model) {
		try {
			return new ResponseEntity<>(showtimeService.addShowtime(model), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("movie/{movieId}/{date}")
	public ResponseEntity <List<MovieBookingShowDTO>> findShowtimeByMovieId(@PathVariable Long movieId, @PathVariable Date date){
		return new ResponseEntity<>(showtimeService.findShowtimeByMovieId(movieId, date), HttpStatus.OK);
	}
}
