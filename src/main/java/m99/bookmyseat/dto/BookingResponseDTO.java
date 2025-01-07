package m99.bookmyseat.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import m99.bookmyseat.entity.BaseEntity;
import m99.bookmyseat.entity.Booking;

@Getter
@Setter
public class BookingResponseDTO {
	private Long id;
	private Date bookingDate;
	private ShowtimeDTO showtimeDTO;
	private List<Long> tickets;

	public static BookingResponseDTO getObject(Booking booking) {
		if(booking == null) {
			return null;
		}
		BookingResponseDTO response = new BookingResponseDTO();
		response.setId(booking.getId());
		response.setBookingDate(booking.getBookingDate());
		response.setShowtimeDTO(ShowtimeDTO.getObject(booking.getTickets().get(0).getShowtime()));
		response.setTickets(BaseEntity.getIdsFromList(booking.getTickets()));
		return response;
	}

	public static List<BookingResponseDTO> getObjects(List<Booking> bookings){
		List<BookingResponseDTO> list = bookings.stream().map(e -> BookingResponseDTO.getObject(e)).collect(Collectors.toList());
		return list;
	}
}  
