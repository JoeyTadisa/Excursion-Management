package com.thuexcursion.crud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Booking;

/**
* BookingRepository interface extends JpaRepository which contains the api of basic CRUD operations for Booking entity, pagination and sorting.
* In this way, boilerplate code like sql statements do not need to be written explicitly.
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/
public interface BookingRepository extends JpaRepository<Booking,Integer>{

	@Query(value="select id_booking,date_booked,booked_by,id_excursion,is_deregistered,date_deregistered from booking where booked_by = :user_id", nativeQuery=true)
	List<Booking> findByUserId(int user_id);


}
