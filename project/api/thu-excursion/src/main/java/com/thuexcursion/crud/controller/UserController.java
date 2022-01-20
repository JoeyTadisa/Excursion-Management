package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.service.UserService;

/**
* UserController class contains all the REST API endpoints for Booking functionality
* 
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Joey Mafukidze
* For more information about EmailController, check swagger documentatio for endpoints
*/

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService service;

	
	
	/** 
	 * This method is used for adding a single user record. 
	 * The access for this function is designed for the administrator (Excursion portal). (NOT YET UI INTEGRATED)
	 * @param user a user object
	 * @return User a newly added user
	 */
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	
	/** 
	 * This method is used for adding list of users. (NOT YET UI INTEGRATED)
	 * @param user a user object
	 * @return List<User> a newly added List of Users
	 */
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {	
		return service.saveUsers(users);
	}

	
	/** 
	 * This method fetches all users from user table
	 * @return List<User> returns list of users
	 */
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	
	/** 
	 * This method fetches a specific user via user id
	 * @param id an specific id of user that we want to fetch
	 * @return List<User> returns a user
	 */
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

    
	/** 
	 * This method
	 * @param user_type
	 * @return List<User>
	 */
	@GetMapping(value = "type/{user_type}")
    public List<User> getUserByType(@PathVariable char user_type){
        return service.getUsersByType(user_type);
    }

	
	/** 
	 * @param username
	 * @param password
	 * @return User
	 */
	@GetMapping("/login/{username}/{password}")
	public User login(@PathVariable String username,@PathVariable String password) {
		return service.login(username,password);
	}

	
	/** 
	 * @return User
	 */
	/*@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
	}*/

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	
	/** 
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

}
