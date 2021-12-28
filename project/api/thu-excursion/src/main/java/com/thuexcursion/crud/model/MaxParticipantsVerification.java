package com.thuexcursion.crud.model;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

/**
* StudentBookingExcursion interface is an entity/model which maps to student_booking_excursion view in mysql database. 
* This interface only contains the getters as view also is only used for fetching the data
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/

// This represents a native view
public interface MaxParticipantsVerification {

	/* Setters and Getters */
	public int getId_excursion(); 
	public int getBookings();
	public int getMax_participants(); 
	public int getPlaces_available();
	public int getIs_booking_allowed();

}
