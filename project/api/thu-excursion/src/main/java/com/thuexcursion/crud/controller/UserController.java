package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.service.UserService;

import net.javaguides.springboot.exception.ResourceNotFoundException;

/**
* UserController class contains all the REST API endpoints for Booking functionality
* 
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Joey Mafukidze
* 
*/

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService service;

	
	
	/** 
	 * @param user
	 * @return User
	 */
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	
	/** 
	 * @param users
	 * @return List<User>
	 */
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {	
		return service.saveUsers(users);
	}

	
	/** 
	 * @return List<User>
	 */
	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	
	/** 
	 * @param id
	 * @return User
	 */
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

    
	/** 
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
