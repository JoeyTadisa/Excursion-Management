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


/*
 * Controller contains all the endpoints related to the associated entity/model
 * 
 * */

@CrossOrigin
@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@Autowired
	private StudentBookingExcursionService student_booking_excursion_service;

	
	@PostMapping("/bookAnExcursion")
	public Booking addBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	@PostMapping("/bookExcursions")
	public List<Booking> addBookings(@RequestBody List<Booking> bookings) {	
		return service.saveBookings(bookings);
	}

	@GetMapping("/bookings")
	public List<Booking> findAllbBookings() {
		return service.getBookings();
	}

	//Get bookings by student id - which bookings does student x has? 
	@GetMapping("bookingsbystudent/{user_id}")
	public List<StudentBookingExcursion> getBookingByUserId(@PathVariable int user_id) {
		return student_booking_excursion_service.getBookingsyPerStudent(user_id);
	}


	@GetMapping("/booking/{id}")
	public Booking getBookingById(@PathVariable int id) {
		return service.getBookingById(id);
	}

	/*
		id - booking id
		status - true for deregister, false for re-registration 
	*/
	@PutMapping("/deregisterBooking/{id}/{status}")
	public Booking deregisterBooking(@PathVariable int id, boolean status) {
		return service.deregisterBooking(id, status);
	}

	

}
