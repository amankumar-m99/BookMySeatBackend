package m99.bookmyseat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m99.bookmyseat.dto.BookingRequestDTO;
import m99.bookmyseat.dto.BookingResponseDTO;
import m99.bookmyseat.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<BookingResponseDTO> addBooking(@RequestBody BookingRequestDTO requestDTO){
		return new ResponseEntity<>(bookingService.addBooking(requestDTO), HttpStatus.CREATED);
	}

	@GetMapping("/id/{bookingId}")
	public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long bookingId){
		return new ResponseEntity<>(bookingService.getByBookingId(bookingId), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BookingResponseDTO>> getBookingByUserId(@PathVariable Long userId){
		return new ResponseEntity<>(bookingService.getByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/user/upcoming/{userId}")
	public ResponseEntity<List<BookingResponseDTO>> getUpcomingBookingByUserId(@PathVariable Long userId){
		return new ResponseEntity<>(bookingService.getUpcomingBookingByUserId(userId, new Date()), HttpStatus.OK);
	}

	@GetMapping("/user/completed/{userId}")
	public ResponseEntity<List<BookingResponseDTO>> getCompletedBookingByUserId(@PathVariable Long userId){
		return new ResponseEntity<>(bookingService.getCompletedBookingByUserId(userId, new Date()), HttpStatus.OK);
	}
	
	@GetMapping("/date/{date}")
	public ResponseEntity<List<BookingResponseDTO>> getBookingByDate(@PathVariable Date date){
		return new ResponseEntity<>(bookingService.getByDate(date), HttpStatus.OK);
	}

}
