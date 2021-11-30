package com.thuexcursion.crud.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
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
@Table(name ="user")
public class User {
	@Id
	@GeneratedValue
	@ApiModelProperty(required = false, hidden = true)
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_number")
	@Basic
	private int user_number;

	@Column(name = "user_type")
	@Basic
	private char user_type;

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
	
	public User(){
		
	}
	
	public User(int id,
				int user_number,
				char user_type,
				String username,
				String password,
				String name_first,
				String name_last, 
				String email,
				String address
				) {
		this.id = id;
		this.user_number = user_number;
		this.user_type = user_type;
		this.username = username;
		this.password = password;
		this.name_first = name_first;
		this.name_last = name_last;
		this.email = email;
		this.address = address;
	}

	
	  public int getId() { 
		  return id; 
	  }
	  
	  public void setId(int id) { 
		  this.id = id; 
	  }
	  public int getUser_no() { 
		  return user_number;
	  }
	  public void setUser_no(int user_number) { 
		  this.user_number = user_number;
	  } 
	  public char getUser_type() { 
		return user_type;
	}
	public void setUser_type(char user_type) { 
		this.user_type = user_type;
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
