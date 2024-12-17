package m99.bookmyseat.seeder;

import jakarta.annotation.PostConstruct;

public class DataSeeder {

	@PostConstruct
	public void seedDatabase() {
		System.out.println("seeding data...");
		new MovieSeeder().seedMovies();
		System.out.println("Data seeded.s");
	}
}
