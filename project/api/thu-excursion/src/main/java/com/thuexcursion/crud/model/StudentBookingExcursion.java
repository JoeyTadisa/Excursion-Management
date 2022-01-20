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
* This is a class of student_booking_excursion query which combines student, booking and excursion  tables
* This interface only contains the getters as view also is only used for fetching the data
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/

// This represents a native view
public interface StudentBookingExcursion {

	

	/* Setters and Getters */
	public int getUser_id();
	public int getUser_number();
	public char getUser_type();
	public String getUsername();
	public String getFirstname();
	public String getLastname();
	public String getEmail();
	public int getId_booking();
	public Date getBooking_date();
	public int getBooked_by();
	public int getId_excursion();
	public String getDescription();
	public Date getDate_added();
	public int getMax_participants();
	public Date getReg_deadline();
	public Date getDereg_deadline();
	public String getMeeting_details();
	public String getTitle();
	public String getDestination();
	public Date getDate_of_excursion();
	public double getExcursion_fee();

	


	



	
	
}
