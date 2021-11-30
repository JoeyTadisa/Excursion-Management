package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.service.UserService;

/*
 * Controller contains all the endpoints related to the associated entity/model
 * 
 * */

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService service;

	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {	
		return service.saveUsers(users);
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

    @GetMapping(value = "type/{user_type}")
    public List<User> getUserByType(@PathVariable char user_type){
        return service.getUsersByType(user_type);
    }

	@GetMapping("/login/{username}/{password}")
	public User login(@PathVariable String username,@PathVariable String password) {
		return service.login(username,password);
	}

	/*@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
	}*/

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

}
