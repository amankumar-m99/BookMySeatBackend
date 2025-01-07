package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.dto.BookingRequestDTO;
import m99.bookmyseat.dto.BookingResponseDTO;
import m99.bookmyseat.entity.Booking;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Ticket;
import m99.bookmyseat.entity.User;
import m99.bookmyseat.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ShowtimeService showtimeService;

	@Autowired
	private TicketService ticketService;

	public BookingResponseDTO addBooking(BookingRequestDTO dto) {
		User user = userService.getUserById(dto.getUserId());
		Showtime showtime = showtimeService.getShowtimeById(dto.getShowtimeId());
		Booking booking = new Booking(new Date(),showtime , null, user);
		booking = bookingRepository.save(booking);
		List<Ticket> tickets = new ArrayList<>();
		for(Long ticketId: dto.getTicketIds()) {
			Ticket ticket = ticketService.getTicketById(ticketId);
			ticket.setIsBooked(true);
			ticket.setBooking(booking);
			ticket = ticketService.updateTicket(ticket);
			tickets.add(ticket);
		}
		booking.setTickets(tickets);
		booking = bookingRepository.save(booking);
		return BookingResponseDTO.getObject(booking);
	}

	public BookingResponseDTO getByBookingId(Long bookingId){
		Booking booking = bookingRepository.findById(bookingId).orElse(null);
		return BookingResponseDTO.getObject(booking);
	}

	public List<BookingResponseDTO> getByUserId(Long userId){
		List<Booking>  bookings = bookingRepository.findByUserIdDesc(userId);
		return BookingResponseDTO.getObjects(bookings);
	}

	public List<BookingResponseDTO> getUpcomingBookingByUserId(Long userId, Date date){
		List<Booking>  bookings = bookingRepository.findUpcomingByUserId(userId, date);
		return BookingResponseDTO.getObjects(bookings);
	}

	public List<BookingResponseDTO> getCompletedBookingByUserId(Long userId, Date date){
		List<Booking>  bookings = bookingRepository.findCompletedByUserId(userId, date);
		return BookingResponseDTO.getObjects(bookings);
	}

	public List<BookingResponseDTO> getByDate(Date date){
		List<Booking>  bookings = bookingRepository.findByBookingDate(date);
		return BookingResponseDTO.getObjects(bookings);
	}
}
