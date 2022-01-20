package com.thuexcursion.crud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.StudentBookingExcursion;
import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.model.MaxParticipantsVerification;

/**
* StudentBookingExcursionRepository interface extends JpaRepository which contains the api of basic CRUD operations for Booking entity, pagination and sorting.
* In this way, boilerplate code like sql statements do not need to be written explicitly.
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/
public interface MaxParticipantsVerificationRepository extends JpaRepository<Booking,Integer>{

	@Query(nativeQuery = true, value = "SELECT id_excursion,bookings,max_participants,places_available,is_booking_allowed FROM verify_max_participants WHERE id_excursion = :id_excursion")
	MaxParticipantsVerification getAvailablePlaces(int id_excursion);
 

}
