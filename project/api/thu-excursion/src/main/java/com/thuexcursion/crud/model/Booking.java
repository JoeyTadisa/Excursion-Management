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

 // Booking table has foreign key pointing to User table
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

	
	@Id
	@GeneratedValue
	@Column(name = "id_booking")
	private int id;
	
	@Column(name = "date_booked")
	private Date date_booked;
	
	@Column(name = "booked_by")
	private int booked_by;

	@Column(name = "id_excursion")
	private int id_excursion;

	
	public Booking() {
		
	}
	
	public Booking(int id, Date date_booked, int booked_by, int id_excursion) {
		super();
		this.id = id;
		this.date_booked = date_booked;
		this.booked_by = booked_by;
		this.id_excursion = id_excursion;
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
	public Date getDate_booked() {
		return date_booked;
	}

	/**
	 * @param booking_date the booking_date to set
	 */
	public void setDate_booked(Date date_booked) {
		this.date_booked = date_booked;
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

	public int getId_excursion() {
		return id_excursion;
	}

	public void setId_excursion(int id_excursion) {
		this.id_excursion = id_excursion;
	}
	
	
	
}
