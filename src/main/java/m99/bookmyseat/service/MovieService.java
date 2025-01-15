package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.customexception.movie.MovieNotFoundException;
import m99.bookmyseat.dto.movie.MovieAddFormDTO;
import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	private Movie addMovie(Movie movie) {
		movie = movieRepository.save(movie);
		return movie;

	}

	public Movie addMovieByDTO(MovieAddFormDTO dto) {
		String sampleURL = "https://t4.ftcdn.net/jpg/02/12/52/91/360_F_212529193_YRhcQCaJB9ugv5dFzqK25Uo9Ivm7B9Ca.jpg";
		Movie movie = Movie.builder().title(dto.getTitle()).description(dto.getDescription()).genre(dto.getGenre())
				.duration(dto.getDuration()).language(dto.getLanguage()).rating(dto.getRating()).posterUrl(sampleURL)
				.releaseDate(dto.getReleaseDate()).build();
		return addMovie(movie);
	}

	public Movie updateMovieByDTO(MovieAddFormDTO dto) {
		Movie movie = getMovieById(dto.getId());
		movie.setTitle(dto.getTitle());
		movie.setDescription(dto.getDescription());
		movie.setGenre(dto.getGenre());
		movie.setDuration(dto.getDuration());
		movie.setLanguage(dto.getLanguage());
		movie.setRating(dto.getRating());
		movie.setReleaseDate(dto.getReleaseDate());
		return addMovie(movie);
	}

	public List<Movie> addMovies(List<Movie> movies) {
		movies = movieRepository.saveAll(movies);
		return movies;
	}

	public Long getMoviesCount() {
		long count = movieRepository.count();
		return count;
	}

	public Movie getMovieById(Long id) {
		Optional<Movie> findById = movieRepository.findById(id);
		return findById.orElseThrow(() -> new MovieNotFoundException("No movie found by id " + id));
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

	public Movie updateMovie(Movie movie) {
		getMovieById(movie.getId());
		return addMovie(movie);
	}

	public List<Movie> getAllMoviesById(List<Long> ids) {
		List<Movie> movies = new ArrayList<>();
		for (Long id : ids) {
			try {
				movies.add(getMovieById(id));
			} catch (Exception e) {
			}
		}
		return movies;
	}
}
