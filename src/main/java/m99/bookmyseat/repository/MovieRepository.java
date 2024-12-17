package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	public Movie findByTitle(String title);
}
