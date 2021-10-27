package com.thuexcursion.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Organizer;
import com.thuexcursion.crud.service.OrganizerService;


/*
 * Controller contains all the endpoints related to the associated entity/model
 * 
 * */

@RestController
public class OrganizerController {

	@Autowired
	private OrganizerService service;

	
	@PostMapping("/addOrganizer")
	public Organizer addOrganizer(@RequestBody Organizer organizer) {
		return service.saveOrganizer(organizer);
	}

	@PostMapping("/addOrganizers")
	public List<Organizer> addOrganizers(@RequestBody List<Organizer> organizers) {
		return service.saveOrganizers(organizers);
	}

	@GetMapping("/organizers")
	public List<Organizer> findAllOrganizers() {
		return service.getOrganizers();
	}

	@GetMapping("/organizer/{id}")
	public Organizer getOrganizerById(@PathVariable int id) {
		return service.getOrganizerById(id);
	}

	/*@GetMapping("/organizer/{username}")
	public Organizer getOrganizerByUsername(@PathVariable String username) {
		return service.getOrganizerByUsername(username);
	}*/

	@PutMapping("/updateOrganizer")
	public Organizer updateOrganizer(@RequestBody Organizer organizer) {
		return service.updateOrganizer(organizer);
	}

	@DeleteMapping("/deleteOrganizer/{id}")
	public String deleteOrganizer(@PathVariable int id) {
		return service.deleteOrganizer(id);
	}

}
