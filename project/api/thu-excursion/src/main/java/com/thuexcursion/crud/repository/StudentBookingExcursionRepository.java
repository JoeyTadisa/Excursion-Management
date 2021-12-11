package com.thuexcursion.crud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.model.StudentBookingExcursion;

/**
* StudentBookingExcursionRepository interface extends JpaRepository which contains the api of basic CRUD operations for Booking entity, pagination and sorting.
* In this way, boilerplate code like sql statements do not need to be written explicitly.
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/
public interface StudentBookingExcursionRepository extends JpaRepository<Booking,Integer>{

	@Query(nativeQuery = true, value = "SELECT id_booking,date_booked,booked_by,id_excursion,user_id,user_number,user_type,username,firstname,lastname,email,Description,dateadded,max_participants,regdeadline,deregdeadline,meetingdetails,title,date_of_excursion,destination,excursion_fee FROM student_booking_excursion WHERE user_number = :user_number")
	List<StudentBookingExcursion> getBookingsPerStudent(int user_number);
 

}
