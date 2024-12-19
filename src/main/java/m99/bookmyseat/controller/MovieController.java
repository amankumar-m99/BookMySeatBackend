package m99.bookmyseat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAllMovies(){
		try {
			return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		try {
			return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		try {
			return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
