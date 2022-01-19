package com.thuexcursion.crud.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

/**
* User class is an entity/model class which maps to mysql table. Each private variables maps to fields of User table.
* User class also contains the classic setters and getters for all the variables mapped to user table fields
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Joey Mafukidze
* 
*/

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
	private String user_type;

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
				String user_type,
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

	
	  
	  /** 
	   * @return int
	   */
	  public int getId() { 
		  return id; 
	  }
	  
	  
	  /** 
	   * @param id
	   */
	  public void setId(int id) { 
		  this.id = id; 
	  }
	  
	  /** 
	   * @return int
	   */
	  public int getUser_no() { 
		  return user_number;
	  }
	  
	  /** 
	   * @param user_number
	   */
	  public void setUser_no(int user_number) { 
		  this.user_number = user_number;
	  } 
	  
	  /** 
	   * @return char
	   */
	  public String getUser_type() { 
		return user_type;
	}
	
	/** 
	 * @param user_type
	 */
	public void setUser_type(String user_type) { 
		this.user_type = user_type;
	}  
	  
	  /** 
	   * @return String
	   */
	  public String getName_first() { 
		  return name_first; 
	  } 

	    /** 
	   * @return HashSet
	   */
	public Set<String> getRoles(){
		return new HashSet<>(Arrays.asList(String.valueOf(user_type)));
	}
	  
	  /** 
	   * @param name_first
	   */
	  public void setName_first(String name_first) { 
		  this.name_first = name_first; 
	  } 
	  
	  /** 
	   * @return String
	   */
	  public String getName_last() { 
		  return name_last; 
	  } 
	  
	  /** 
	   * @param name_last
	   */
	  public void setName_last(String name_last) { 
		  this.name_last = name_last; 
	  } 
	  
	  /** 
	   * @return String
	   */
	  public String getEmail() { 
		  return email; 
	  } 
	  
	  /** 
	   * @param email
	   */
	  public void setEmail(String email) { 
		  this.email = email; 
	  } 
	  
	  /** 
	   * @return String
	   */
	  public String getAddress() { 
		  return address; 
	  } 
	  
	  /** 
	   * @param address
	   */
	  public void setAddress(String address) { 
		  this.address = address; 
	  } 

	  
	  /** 
	   * @return String
	   */
	  public String getUsername() { 
		return username; 
	  } 

	  
	  /** 
	   * @param username
	   */
	  public void setUsername(String username) { 
		this.username = username; 
	  } 

	  
	  /** 
	   * @return String
	   */
	  public String getPassword() { 
		return password; 
	  } 

	  
	  /** 
	   * @param password
	   */
	  public void setPassword(String password) { 
		this.password = password; 
	  } 
	 
	 

}
