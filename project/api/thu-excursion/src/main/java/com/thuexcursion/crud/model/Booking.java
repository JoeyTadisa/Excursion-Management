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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

	
	@Id
	@GeneratedValue
	@Column(name = "idbooking")
	private int id;
	
	@Column(name = "bookingdate")
	private Date booking_date;
	
	@Column(name = "bookedby")
	private int booked_by;

	
	public Booking() {
		
	}
	
	public Booking(int id, Date booking_date, int booked_by) {
		super();
		this.id = id;
		this.booking_date = booking_date;
		this.booked_by = booked_by;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the booking_date
	 */
	public Date getBooking_date() {
		return booking_date;
	}

	/**
	 * @param booking_date the booking_date to set
	 */
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	/**
	 * @return the booked_by
	 */
	public int getBooked_by() {
		return booked_by;
	}

	/**
	 * @param booked_by the booked_by to set
	 */
	public void setBooked_by(int booked_by) {
		this.booked_by = booked_by;
	}
	
	
	
}
