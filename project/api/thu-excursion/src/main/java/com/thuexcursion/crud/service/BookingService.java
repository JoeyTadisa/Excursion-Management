package com.thuexcursion.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository repository;
	
	public Booking createBooking(Booking booking) {
		return repository.save(booking);
	}
	
	/*public List<Booking> saveBookings(List<Booking> bookings) {
		return repository.saveAll(bookings);
	}*/
	
	public List<Booking> getBookings(){
		return repository.findAll();
	}

    public List<Booking> getBookingsByStudent(int matriculation_no){
		return repository.findByStudentMatriculationNo(matriculation_no);
	}
	
	public Booking getBookingById(int id){
		return repository.findById(id).orElse(null);
	}

	public String deleteBooking(int id) {
		 repository.deleteById(id);
		 return "product removed!" + id;
	}

	/*public Booking updateBooking(Booking booking) {
		Booking existingBooking = repository.findById(booking.getId()).orElse(booking);
		 return repository.save(existingBooking);
	}*/
	
	
}
