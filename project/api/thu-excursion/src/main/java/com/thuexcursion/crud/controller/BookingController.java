package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.NoOpPropertyValueTransformer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.model.MaxParticipantsVerification;
import com.thuexcursion.crud.model.StudentBookingExcursion;
import com.thuexcursion.crud.service.BookingService;
import com.thuexcursion.crud.service.StudentBookingExcursionService;
import com.thuexcursion.crud.service.MaxParticipantsVerificationService;


/**
* BookingController class contains all the REST API endpoints for Booking functionality
* 
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/

@CrossOrigin
@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@Autowired
	private StudentBookingExcursionService student_booking_excursion_service;

	@Autowired
	private MaxParticipantsVerificationService max_participants_verification_service;

	
	
	/** 
	 * @param booking
	 * @return Booking
	 */
	@PostMapping("/bookAnExcursion")
	public Booking addBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	
	/** 
	 * @param bookings
	 * @return List<Booking>
	 */
	@PostMapping("/bookExcursions")
	public List<Booking> addBookings(@RequestBody List<Booking> bookings) {	
		return service.saveBookings(bookings);
	}

	
	/** 
	 * @return List<Booking>
	 */
	@GetMapping("/bookings")
	public List<Booking> findAllbBookings() {
		return service.getBookings();
	}

	
	/** 
	 * 
	 * @param matriculation_number represents the matriculation number of a student
	 * @return List<StudentBookingExcursion> returns list of excursions booked by a student
	 */
	
	@GetMapping("/bookingsbystudent/{matriculation_number}")
	public List<StudentBookingExcursion> getBookingByUserId(@PathVariable int matriculation_number) {
		return student_booking_excursion_service.getBookingsyPerStudent(matriculation_number);
	}


	
	/** 
	 * @param id
	 * @return Booking
	 */
	@GetMapping("/booking/{id}")
	public Booking getBookingById(@PathVariable int id) {
		return service.getBookingById(id);
	}

	
	/** 
	 * @param id 
	 * @param status
	 * @return Booking
	 */

	@PutMapping("/deregisterBooking/{id}/{status}")
	public Booking deregisterBooking(@PathVariable int id, boolean status) {
		return service.deregisterBooking(id, status);
	}

	/**
	 * This function fetches maximum of participants allowed, actual number of bookings and available places left per excursion
	 * @param excursion_id
	 * @return number of bookings, max_participants, available places left
	 * 
	 */

	@GetMapping("/api/checkavailableplaces/{excursion_id}")
	public MaxParticipantsVerification getAvailablePlacesInformation(@PathVariable int excursion_id) {
		return max_participants_verification_service.getAvailablePlaces(excursion_id);
	}
	

}
