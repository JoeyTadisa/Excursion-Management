package com.thuexcursion.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Admin;
import com.thuexcursion.crud.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public List<Admin> saveAdmins(List<Admin> admins) {
		return repository.saveAll(admins);
	}
	
	public List<Admin> getAdmins(){
		
		return repository.findAll();
	}
	
	public Admin getAdminById(int id){
		return repository.findById(id).orElse(null);
	}

	//login
	public Admin login(String username,String password){
		return repository.findLoginCredentials(username,password);
	}
	
	public String deleteAdmin(int id) {
		 repository.deleteById(id);
		 return "product removed!" + id;
	}


	public Admin updateAdmin(Admin admin) {
		Admin existingAdmin = repository.findById(admin.getId()).orElse(admin);
		 existingAdmin.setName_first(admin.getName_first());
		 existingAdmin.setName_last(admin.getName_last());
		 existingAdmin.setEmail(admin.getEmail());
		 existingAdmin.setAddress(admin.getAddress());
		 return repository.save(existingAdmin);
	}
	
	

	
}
