package m99.bookmyseat.seeder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.service.MovieService;

public class MovieSeeder {

	@SuppressWarnings("deprecation")
	public void seedMovies(MovieService movieService) {
		List<Movie> movies = new ArrayList<>();
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Golmal").genre("Comdey").language("Hindi").
				releaseDate(new Date(2024, 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Hera Pheri").genre("Comedy").language("Hindi")
				.releaseDate(new Date(2023, 10, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Passengers").genre("Sci-fi").language("English")
				.releaseDate(new Date(2022, 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Dark").genre("Sci-fi").language("German")
				.releaseDate(new Date(2024, 9, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Hindi Medium").genre("Drama").language("Urdu")
				.releaseDate(new Date(2024, 8, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Ajab prem ki gajab kahani").genre("Rom-com").language("Spanish")
				.releaseDate(new Date(2024, 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Conjuring").genre("Horror").language("English")
				.releaseDate(new Date(2022, 6, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Maidan").genre("Action").language("Hindi")
				.releaseDate(new Date(2024, 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Jab we met").genre("Love Story").language("German")
				.releaseDate(new Date(2024, 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl("no.url.set").title("Serious men").genre("Phil").language("Kannad")
				.releaseDate(new Date(2024, 12, 7)).build());
		movieService.addMovies(movies);
	}
}
