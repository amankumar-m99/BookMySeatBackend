package m99.bookmyseat.seeder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.service.MovieService;

public class MovieSeeder {

	@SuppressWarnings("deprecation")
	public void seedMovies(MovieService movieService) {
		String sampleURL = "https://t4.ftcdn.net/jpg/02/12/52/91/360_F_212529193_YRhcQCaJB9ugv5dFzqK25Uo9Ivm7B9Ca.jpg";
		List<Movie> movies = new ArrayList<>();
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Golmal").genre("Comdey").language("Hindi").
				releaseDate(new Date(getyearMinus1900(2024), 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Hera Pheri").genre("Comedy").language("Hindi")
				.releaseDate(new Date(getyearMinus1900(2023), 10, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Passengers").genre("Sci-fi").language("English")
				.releaseDate(new Date(getyearMinus1900(2022), 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Dark").genre("Sci-fi").language("German")
				.releaseDate(new Date(getyearMinus1900(2024), 9, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Hindi Medium").genre("Drama").language("Urdu")
				.releaseDate(new Date(getyearMinus1900(2024), 8, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Ajab prem ki gajab kahani").genre("Rom-com").language("Spanish")
				.releaseDate(new Date(getyearMinus1900(2024), 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Conjuring").genre("Horror").language("English")
				.releaseDate(new Date(getyearMinus1900(2022), 6, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Maidan").genre("Action").language("Hindi")
				.releaseDate(new Date(getyearMinus1900(2024), 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Jab we met").genre("Love Story").language("German")
				.releaseDate(new Date(getyearMinus1900(2024), 12, 7)).build());
		movies.add(Movie.builder().duration(150).rating(8.1).description("lorem ipsum dolor sit")
				.posterUrl(sampleURL).title("Serious men").genre("Phil").language("Kannad")
				.releaseDate(new Date(getyearMinus1900(2024), 12, 7)).build());
		movieService.addMovies(movies);
	}

	private int getyearMinus1900(int year) {
		return year-1900;
	}
}
