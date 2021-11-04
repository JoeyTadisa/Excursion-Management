package com.thuexcursion.crud.model;

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

//@Getter
//@Setter
//

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "idstudent")
	private int id;

	@Column(name = "matriculationnumber")
	@Basic
	private int matriculation_no;

	@Column(name = "firstname")
	@Basic
	private String name_first;

	@Column(name = "lastname")
	@Basic
	private String name_last;

	@Column(name = "email")
	@Basic
	private String email;

	@Column(name = "address")
	@Basic
	private String address;

	
	  public int getId() { 
		  return id; 
	  }
	  
	  public void setId(int id) { 
		  this.id = id; 
	  }
	  public int getMatriculation_no() { 
		  return matriculation_no;
	  }
	  public void setMatriculation_no(int matriculation_no) { 
		  this.matriculation_no = matriculation_no; 
	  } 
	  
	  public String getName_first() { 
		  return name_first; 
	  } 
	  public void setName_first(String name_first) { 
		  this.name_first = name_first; 
	  } 
	  public String getName_last() { 
		  return name_last; 
	  } 
	  public void setName_last(String name_last) { 
		  this.name_last = name_last; 
	  } 
	  public String getEmail() { 
		  return email; 
	  } 
	  public void setEmail(String email) { 
		  this.email = email; 
	  } 
	  public String getAddress() { 
		  return address; 
	  } 
	  public void setAddress(String address) { 
		  this.address = address; 
	  } 
	 
	 

}
