package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.NoOpPropertyValueTransformer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.service.BookingService;


/*
 * Controller contains all the endpoints related to the associated entity/model
 * 
 * */

@CrossOrigin
@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	
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
	public List<Booking> getBookingByUserId(@PathVariable int user_id) {
		return service.getBookingByUserId(user_id);
	}


	

	/*@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
	}*/





	/*@PutMapping("/updateUser")
	public Booking updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	} */

}
