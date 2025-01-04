package m99.bookmyseat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m99.bookmyseat.entity.Booking;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findByShowtimeId(Long showtimeId);

	List<Ticket> findByShowtime(Showtime showtime);

	List<Ticket> findByBookingId(Long bookingId);
	
	List<Ticket> findByBooking(Booking booking);
}
