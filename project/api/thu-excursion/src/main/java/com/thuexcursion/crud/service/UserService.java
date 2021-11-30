package com.thuexcursion.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.User;
import com.thuexcursion.crud.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public User getUserById(int id){
		return repository.findById(id).orElse(null);
	}

    public List<User> getUsersByType(char user_type){
        return repository.findByType(user_type);
    }

	//login
	public User login(String username,String password){
		return repository.findLoginCredentials(username,password);
	}
	
	public String deleteUser(int id) {
		 repository.deleteById(id);
		 return "User " + id  + " removed successfully.";
	}

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
