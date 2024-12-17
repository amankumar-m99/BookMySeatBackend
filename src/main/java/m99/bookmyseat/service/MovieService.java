package m99.bookmyseat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		movie = movieRepository.save(movie);
		return movie;
	}
}
