package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.NoOpPropertyValueTransformer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.model.StudentBookingExcursion;
import com.thuexcursion.crud.service.BookingService;
import com.thuexcursion.crud.service.StudentBookingExcursionService;


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

	
	
	/** 
	 * This method is used to book an excursion. 
	 * @param booking a booking object passed in the requestBody
	 * @return Booking newly booked excursion
	 */
	@PostMapping("/bookAnExcursion")
	public Booking addBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	
	/** 
	 * This method is used to book list of excursions. 
	 * @param List<bookings>
	 * @return List<Booking> newly booked list of excursions
	 */
	@PostMapping("/bookExcursions")
	public List<Booking> addBookings(@RequestBody List<Booking> bookings) {	
		return service.saveBookings(bookings);
	}

	
	/** 
	 * This method fetch all bookings from the database
	 * @return List<Booking> list of all bookings
	 */
	@GetMapping("/bookings")
	public List<Booking> findAllbBookings() {
		return service.getBookings();
	}

	
	/** 
	 * This method fetch all bookings per student id.
	 * @param matriculation_number represents the matriculation number of a student. This is user_id in user table with user_type of ROLE_S
	 * @return List<StudentBookingExcursion> returns list of excursions booked by a student
	 */
	
	@GetMapping("bookingsbystudent/{matriculation_number}")
	public List<StudentBookingExcursion> getBookingByUserId(@PathVariable int matriculation_number) {
		return student_booking_excursion_service.getBookingsyPerStudent(matriculation_number);
	}


	
	/** 
	 * 
	 * @param id id 
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

	

}
