package com.thuexcursion.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@PostMapping("/createBooking")
	public Booking createBooking(@RequestBody Booking organizer) {
		return service.createBooking(organizer);
	}

	/*@PostMapping("/addBooking")
	public List<Booking> addOrganizers(@RequestBody List<Booking> organizers) {
		return service.saveBookings(organizers);
	}*/

	@GetMapping("/bookings")
	public List<Booking> findAllOrganizers() {
		return service.getBookings();
	}

	@GetMapping("/booking/{id}")
	public Booking getOrganizerById(@PathVariable int id) {
		return service.getBookingById(id);
	}

	/*@GetMapping("/organizer/{username}")
	public Organizer getOrganizerByUsername(@PathVariable String username) {
		return service.getOrganizerByUsername(username);
	}*/

	/*@PutMapping("/updateOrganizer")
	public Organizer updateOrganizer(Booking@RequestBody Organizer organizer) {
		return service.updateOrganizer(organizer);
	}*/

	@DeleteMapping("/deleteBooking/{id}")
	public String deleteBooking(@PathVariable int id) {
		return service.deleteBooking(id);
	}

}
