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

/*
 * Model classes contains the mapping of mysql tables and the field definitions as well as setters, getters and constructors
 * */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "idadmin")
	private int id;

	@Column(name = "employeenumber")
	@Basic
	private int employee_no;

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

	@Column(name = "username")
	@Basic
	private String username;

	@Column(name = "password")
	@Basic
	private String password;
	
	
	public Admin() {
		
	}
	
	public Admin(int id,
				int employee_no,
				 String name_first,
				 String name_last,
				 String email,
				 String address,
				 String username,
				 String password) {
		this.id = id;
		this.employee_no = employee_no;
		this.name_first = name_first;
		this.name_last = name_last;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
		
		
	}

	
	  public int getId() { 
		  return id; 
	  }
	  
	  public void setId(int id) { 
		  this.id = id; 
	  }
	  public int getEmployee_no() { 
		  return employee_no;
	  }
	  public void setEmployee_no(int employee_no) { 
		  this.employee_no = employee_no; 
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

	  public String getUsername() { 
		return username; 
	  } 

	  public void setUsername(String username) { 
		this.username = username; 
	  } 

	  public String getPassword() { 
		return password; 
	  } 

	  public void setPassword(String password) { 
		this.password = password; 
	  } 
	 
	 

}
