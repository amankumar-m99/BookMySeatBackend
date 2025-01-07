package m99.bookmyseat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m99.bookmyseat.entity.Booking;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Ticket;
import m99.bookmyseat.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public List<Ticket> addTickets(int rows, int cols, Showtime showtime) {
		List<Ticket> tickets = new ArrayList<>();
		for(char row = 1; row <= rows; row++) {
			for(int col = 1; col <= cols; col++) {
				char alpha = (char) ('A' + (row-1));
				String seatNUmber = "" + alpha + "" + col;
				tickets.add(new Ticket(seatNUmber, 100d, false, showtime, null));
			}
		}
		tickets = ticketRepository.saveAll(tickets);
		return tickets;
	}

	public Ticket getTicketById(Long ticketId) {
		return ticketRepository.findById(ticketId).orElse(null);
	}

	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public List<Ticket> getAllTicketsOfShowtime(Showtime showtime){
		return ticketRepository.findByShowtime(showtime);
	}
	
	public List<Ticket> getAllTicketsOfShowtimeId(Long showtimeId){
		return ticketRepository.findByShowtimeId(showtimeId);
	}

	public List<Ticket> getAllTicketsOfBooking(Booking booking){
		return ticketRepository.findByBooking(booking);
	}
	
	public List<Ticket> getAllTicketsOfBookingId(Long bookingId){
		return ticketRepository.findByBookingId(bookingId);
	}
}
