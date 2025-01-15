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

import jakarta.annotation.PostConstruct;
import m99.bookmyseat.dto.movie.MovieAddFormDTO;
import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.seeder.MovieSeeder;
import m99.bookmyseat.service.MovieService;

@RestController
@RequestMapping("movie")
@CrossOrigin
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostConstruct
	public void seedMovies() {
		if(movieService.getAllMovies().size() != 0) {
			System.out.println("No need to seed movies");
			return;
		}
		System.out.println("Seeding movies...");
		new MovieSeeder().seedMovies(movieService);
		System.out.println("Movie seeded.");
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/count")
	public ResponseEntity<Long> getMoviesCount(){
		try {
			return new ResponseEntity<>(movieService.getMoviesCount(), HttpStatus.OK);
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

	@PostMapping("/all")
	public ResponseEntity<List<Movie>> getAllMoviesById(@RequestBody List<Long> ids){
		try {
			return new ResponseEntity<>(movieService.getAllMoviesById(ids), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody MovieAddFormDTO dto) {
		try {
			return new ResponseEntity<>(movieService.addMovieByDTO(dto), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<Movie> updateMovie(@RequestBody MovieAddFormDTO dto) {
		try {
			return new ResponseEntity<>(movieService.updateMovieByDTO(dto), HttpStatus.CREATED);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
