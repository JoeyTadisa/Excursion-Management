package com.thuexcursion.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.MaxParticipantsVerification;
import com.thuexcursion.crud.repository.MaxParticipantsVerificationRepository;

/**
* 
* StudentBookingExcursionService class is part of Service Layer which main goal is to handle the details of the persistence mechanism.
* StudentBookingExcursionService class handles business requirements related to student-booking and excursion relationship
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/
@Service
public class MaxParticipantsVerificationService {
	
	@Autowired
	private MaxParticipantsVerificationRepository repository;
	
	public MaxParticipantsVerification getAvailablePlaces(int excursion_id) {
		return repository.getAvailablePlaces(excursion_id);
	}


	/*public Booking updateExcursion(Booking booking) {
		Booking existingExcursion = repository.findById(booking.getId()).orElse(booking);
		 existingExcursion.setDescription(booking.getDescription());
		 existingExcursion.setDate_written(excursion.getDate_written());
		 existingExcursion.setMax_participants(excursion.getMax_participants());
		 existingExcursion.setReg_deadline(excursion.getReg_deadline());
		 existingExcursion.setDereg_deadline(excursion.getDereg_deadline());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setTitle(excursion.getTitle());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setRequested_by(excursion.getRequested_by());
		 return repository.save(existingExcursion);
	} */
	
	
	
	


}
