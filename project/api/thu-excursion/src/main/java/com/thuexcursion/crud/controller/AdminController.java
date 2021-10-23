package com.thuexcursion.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Admin;
import com.thuexcursion.crud.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PostMapping("/addAdmins")
	public List<Admin> addAdmins(@RequestBody List<Admin> admins) {
		return service.saveAdmins(admins);
	}

	@GetMapping("/admins")
	public List<Admin> findAllAdmins() {
		return service.getAdmins();
	}

	@GetMapping("/admin/{id}")
	public Admin getAdminById(@PathVariable int id) {
		return service.getAdminById(id);
	}

	/*@GetMapping("/admin/{username}")
	public Admin getAdminByUsername(@PathVariable String username) {
		return service.getAdminByUsername(username);
	}*/

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable int id) {
		return service.deleteAdmin(id);
	}

}
