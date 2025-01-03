package m99.bookmyseat.service;

import java.util.ArrayList;
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

	public List<Movie> addMovies(List<Movie> movies) {
		movies = movieRepository.saveAll(movies);
		return movies;
	}

	public Movie getMovieById(Long id) {
		Optional<Movie> findById = movieRepository.findById(id);
		return findById.orElseThrow(()-> new MovieNotFoundException("No movie found by id " + id));
	}

	public List<Movie> getAllMovies(){
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

	public Movie updateMovie(Movie movie) {
		getMovieById(movie.getId());
		return addMovie(movie);
	}

	public List<Movie> getAllMoviesById(List<Long> ids) {
		List<Movie> movies = new ArrayList<>();
		for(Long id: ids) {
			try {
				movies.add(getMovieById(id));
			}catch(Exception e) {}
		}
		return movies;
	}
}
