package m99.bookmyseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
