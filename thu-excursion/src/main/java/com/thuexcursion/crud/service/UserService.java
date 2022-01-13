package com.thuexcursion.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.repository.UserRepository;


/**
* 
* UserService class is part of Service Layer which main goal is to handle the details of the persistence mechanism.
* UserService class handles business requirements related to User entity
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Joey Mafukidze
* 
*/
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	/** 
	 * @param user
	 * @return User
	 */
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	
	/** 
	 * @param users
	 * @return List<User>
	 */
	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}
	
	
	/** 
	 * @return List<User>
	 */
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	
	/** 
	 * @param id
	 * @return User
	 */
	public User getUserById(int id){
		return repository.findById(id).orElse(null);
	}

    
	/** 
	 * @param user_type
	 * @return List<User>
	 */
	public List<User> getUsersByType(char user_type){
        return repository.findByType(user_type);
    }

	
	/** 
	 * @param username
	 * @param password
	 * @return User
	 */
	//login
	public User login(String username,String password){
		return repository.findLoginCredentials(username,password);
	}
	
	
	/** 
	 * @param id
	 * @return String
	 */
	public String deleteUser(int id) {
		 repository.deleteById(id);
		 return "User " + id  + " removed successfully.";
	}

	
	/** 
	 * @param user
	 * @return User
	 */
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getId()).orElse(user);
		 existingUser.setName_first(user.getName_first());
		 existingUser.setName_last(user.getName_last());
		 existingUser.setEmail(user.getEmail());
		 existingUser.setAddress(user.getAddress());
         existingUser.setUser_type(user.getUser_type());
         existingUser.setPassword(user.getPassword());
         existingUser.setUsername(user.getUsername());
		 return repository.save(existingUser);
	}	
}
