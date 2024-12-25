package m99.bookmyseat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long>{

	public List<Theater> findByOwnerId(Long id);
}
