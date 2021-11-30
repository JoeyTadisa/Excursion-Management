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

/*
 * Model classes contains the mapping of mysql tables and the field definitions as well as setters, getters and constructors
 * */

 // This class is mapped to a query
 // Booking table has foreign key pointing to User table
 // This class relies on Spring for default constructors
/*@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StudentBookingExcursion") */
public class StudentBookingExcursion {

	

	/* Student */
	/*@Column(name = "user_id")
	private int user_id;

	@Column(name = "user_number")
	private int user_number;

	@Column(name = "user_type")
	private char user_type;

	@Column(name = "username")
	private String username;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email; */
	

	/* Booking */
	/*@Column(name = "id_booking")
	private int id_booking;
	
	@Column(name = "booking_date")
	private Date booking_date;
	
	@Column(name = "booked_by")
	private int booked_by;

	@Column(name = "id_excursion")
	private int id_excursion; */

	
	/* Excursion */
	/*@Column(name = "description")
	@Basic
	private String description;
	
	@Column(name = "dateadded")
	@Basic
	private Date date_added;
	
	@Column(name = "maxparticipants")
	@Basic
	private int max_participants;
	
	@Column(name = "regdeadline")
	@Basic
	private Date reg_deadline;
	
	@Column(name = "deregdeadline")
	@Basic
	private Date dereg_deadline;
	
	@Column(name = "meetingdetails")
	@Basic
	private String meeting_details;
	
	@Column(name = "title")
	@Basic
	private String title;
	
	@Column(name = "requestedby")
	@Basic
	private int requested_by;

	@Column(name = "destination")
	@Basic
	private String destination;

	@Column(name = "date_of_excursion")
	@Basic
	private Date date_of_excursion;

	@Column(name = "excursion_fee")
	@Basic
	private double excursion_fee; */


	/* Setters and Getters */
	/*public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public char getUser_type() {
		return user_type;
	}

	public void setUser_type(char user_type) {
		this.user_type = user_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_booking() {
		return id_booking;
	}

	public void setId_booking(int id_booking) {
		this.id_booking = id_booking;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public int getBooked_by() {
		return booked_by;
	}

	public void setBooked_by(int booked_by) {
		this.booked_by = booked_by;
	}

	public int getId_excursion() {
		return id_excursion;
	}

	public void setId_excursion(int id_excursion) {
		this.id_excursion = id_excursion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public int getMax_participants() {
		return max_participants;
	}

	public void setMax_participants(int max_participants) {
		this.max_participants = max_participants;
	}

	public Date getReg_deadline() {
		return reg_deadline;
	}

	public void setReg_deadline(Date reg_deadline) {
		this.reg_deadline = reg_deadline;
	}

	public Date getDereg_deadline() {
		return dereg_deadline;
	}

	public void setDereg_deadline(Date dereg_deadline) {
		this.dereg_deadline = dereg_deadline;
	}

	public String getMeeting_details() {
		return meeting_details;
	}

	public void setMeeting_details(String meeting_details) {
		this.meeting_details = meeting_details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRequested_by() {
		return requested_by;
	}

	public void setRequested_by(int requested_by) {
		this.requested_by = requested_by;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate_of_excursion() {
		return date_of_excursion;
	}

	public void setDate_of_excursion(Date date_of_excursion) {
		this.date_of_excursion = date_of_excursion;
	}

	public double getExcursion_fee() {
		return excursion_fee;
	}

	public void setExcursion_fee(double excursion_fee) {
		this.excursion_fee = excursion_fee;
	}
*/
	


	



	
	
}
