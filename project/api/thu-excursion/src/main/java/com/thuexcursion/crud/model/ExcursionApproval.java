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
@Table(name = "excursionapproval")
public class ExcursionApproval {
	
	@Id
	@GeneratedValue
	@Column(name = "idexcursionapproval")
	private int id;
	
	@Column(name = "isapproved")
	private boolean is_approved; 
	
	@Column(name = "datereviewed")
	private Date date_reviewed;
	
	@Column(name = "reviewedby")
	private int reviewed_by;
	
	
	/*@Column(name = "excursion_idexcursion")
	private int excursion_id_excursion;*/
	
	

}
