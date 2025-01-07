package m99.bookmyseat.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m99.bookmyseat.entity.Booking;
import m99.bookmyseat.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> findByBookingDate(Date date);

	List<Booking> findByUser(User user);

	List<Booking> findByUserId(Long userId);

	@Query("SELECT b FROM Booking b ORDER BY b.bookingDate DESC")
	List<Booking> findByUserIdDesc(Long userId);
	
	@Query("SELECT b FROM Booking b WHERE b.user.id = :userId and b.showtime.date >= :date ORDER BY b.showtime.date")
	List<Booking> findUpcomingByUserId(Long userId, Date date);

	@Query("SELECT b FROM Booking b WHERE b.user.id = :userId and b.showtime.date < :date")
	List<Booking> findCompletedByUserId(Long userId, Date date);
}
