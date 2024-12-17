package m99.bookmyseat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		movie = movieService.addMovie(movie);
		return movie;
	}
}
