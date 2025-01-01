package m99.bookmyseat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.Timeslot;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long>{

	public List<Timeslot> findByTheaterId(Long theaterId);
}
