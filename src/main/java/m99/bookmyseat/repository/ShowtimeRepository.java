package m99.bookmyseat.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m99.bookmyseat.entity.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long>{

	@Query("SELECT s FROM Showtime s where s.movie.id = :movieId and s.date = :date order by s.theater.id")
	List<Showtime> findShowsByMovieId(Long movieId, Date date);
}
