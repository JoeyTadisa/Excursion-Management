package com.thuexcursion.crud.model;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

/**
* Excursion class is an entity/model class which maps to mysql table. Each private variables maps to fields of Excursion table.
* Excursion class also contains the classic setters and getters for all the variables mapped to booking table fields
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "excursion")
//@SecondaryTable(name="excursionapproval",pkJoinColumns=@PrimaryKeyJoinColumn(name="excursion_idexcursion"))
//@SecondaryTable(name="excursionapproval")
public class Excursion {
	

/*
 * ======= EXCURSION TABLE: private variables ========
 * */
	@Id
	@GeneratedValue
	@Column(name = "idexcursion")
	private int id;
	
	@Column(name = "description")
	@Basic
	private String description;
	
	@Basic
	@Column(nullable = false, name = "dateadded", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
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
	private double excursion_fee;

	@Column(nullable = false,name = "approval_status",insertable = false, updatable = true)
	@Basic
	private String approval_status;


	
	/*@Embedded
	ExcursionApproval excursionapprovals;*/
	
	@Column(name = "is_approved")
	private boolean is_approved; 
	
	@Column(name = "date_reviewed")
	private Date date_reviewed;
	
	@Column(name = "reviewed_by")
	private int reviewed_by;


	
	public Excursion() {
		
	}
	
	public Excursion(int id, String description, int max_participants, Date reg_deadline,
			Date dereg_deadline, String meeting_details,String title, int requested_by, boolean is_approved,
			String destination, Date date_of_excursion, double excursion_fee, String approval_status) {

		
			this.id = id;
			this.description = description;
			//this.date_added = date_written;
			this.max_participants = max_participants;
			this.reg_deadline = reg_deadline;
			this.dereg_deadline = dereg_deadline;
			this.meeting_details = meeting_details;
			this.title = title;
			this.requested_by = 1;
			this.destination = destination;
			this.date_of_excursion = date_of_excursion;
			this.excursion_fee = excursion_fee;
			
			
			this.is_approved = false;
			this.date_reviewed = null;
			this.reviewed_by = requested_by;

			this.approval_status = approval_status;
			
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date_written
	 */
	public Date getDate_written() {
		return date_added;
	}

	/**
	 * @param date_written the date_written to set
	 */
	/*public void setDate_written(Date date_written) {
		this.date_added = date_written;
	} */

	/**
	 * @return the max_participants
	 */
	public int getMax_participants() {
		return max_participants;
	}

	/**
	 * @param max_participants the max_participants to set
	 */
	public void setMax_participants(int max_participants) {
		this.max_participants = max_participants;
	}

	/**
	 * @return the reg_deadline
	 */
	public Date getReg_deadline() {
		return reg_deadline;
	}

	/**
	 * @param reg_deadline the reg_deadline to set
	 */
	public void setReg_deadline(Date reg_deadline) {
		this.reg_deadline = reg_deadline;
	}

	/**
	 * @return the dereg_deadline
	 */
	public Date getDereg_deadline() {
		return dereg_deadline;
	}

	/**
	 * @param dereg_deadline the dereg_deadline to set
	 */
	public void setDereg_deadline(Date dereg_deadline) {
		this.dereg_deadline = dereg_deadline;
	}

	/**
	 * @return the meeting_details
	 */
	public String getMeeting_details() {
		return meeting_details;
	}

	/**
	 * @param meeting_details the meeting_details to set
	 */
	public void setMeeting_details(String meeting_details) {
		this.meeting_details = meeting_details;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the requested_by
	 */
	public int getRequested_by() {
		return requested_by;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setRequested_by(int requested_by) {
		this.requested_by = requested_by;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the destination
	 */
	public Date getDate_of_excursion() {
		return date_of_excursion;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setDate_of_excursion(Date date_of_excursion) {
		this.date_of_excursion = date_of_excursion;
	}
	

	/**
	 * @return the excursion_fee
	 */
	public double getExcursion_fee() {
		return excursion_fee;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setExcursion_fee(double excursion_fee) {
		this.excursion_fee = excursion_fee;
	}
	
	
	
	/** 
	 * @return boolean
	 */
	public boolean getIs_approved() {
		return is_approved;
	}

	
	/** 
	 * @param is_approved
	 */
	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}
	
	
	/** 
	 * @return Date
	 */
	public Date getDate_reviewed() {
		return date_reviewed;
	}
	
	
	/** 
	 * @param date_reviewed
	 */
	public void setDate_reviewed(Date date_reviewed) {
		this.date_reviewed = date_reviewed;
	}
	
	
	/** 
	 * @return int
	 */
	public int getReviewed_by() {
		return reviewed_by;
	}
	
	
	/** 
	 * @param reviewed_by
	 */
	public void setReviewed_by(int reviewed_by) {
		this.reviewed_by = reviewed_by;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	

	
}

/*@Embeddable
class ExcursionApproval {
	
	
	
	@Column(name = "isapproved", table="excursionapproval")
	private boolean is_approved;
	
	@Column(name = "datereviewed", table="excursionapproval")
	private Date date_reviewed;
	
	@Column(name = "reviewedby", table="excursionapproval")
	private int reviewed_by;

	
	@Column(table="excursionapproval")
	public boolean getIs_approved() {
		return is_approved;
	}

	@Column(table="excursionapproval")
	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}
	
	@Column(table="excursionapproval")
	public Date getDate_reviewed() {
		return date_reviewed;
	}
	
	@Column(table="excursionapproval")
	public void setDate_reviewed(Date date_reviewed) {
		this.date_reviewed = date_reviewed;
	}
	
	@Column(table="excursionapproval")
	public int getReviewed_by() {
		return reviewed_by;
	}
	
	@Column(table="excursionapproval")
	public void setReviewed_by(int reviewed_by) {
		this.reviewed_by = reviewed_by;
	} 

}*/

	
