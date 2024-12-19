package m99.bookmyseat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.movie.MovieNotFoundException;
import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	public Movie getMovieById(Long id) {
		Optional<Movie> findById = movieRepository.findById(id);
		return findById.orElseThrow(()-> new MovieNotFoundException("No movie found by id " + id));
	}

	public List<Movie> getAllMovies(){
		List<Movie> theaters = movieRepository.findAll();
		return theaters;
	}

	public Movie updateMovie(Movie movie) {
		getMovieById(movie.getId());
		return addMovie(movie);
	}
}
