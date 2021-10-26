package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Excursion;
import com.thuexcursion.crud.service.ExcursionService;

/*
 * Controller contains all the endpoints related to the associated entity/model
 * 
 * */

@RestController
public class ExcursionController {

	@Autowired
	private ExcursionService service;

	
	@PostMapping("/addExcursion")
	public Excursion addExcursion(@RequestBody Excursion excursion) {
		return service.saveExcursion(excursion);
	}

	@PostMapping("/addExcursions")
	public List<Excursion> addExcursions(@RequestBody List<Excursion> excursions) {
		return service.saveExcursions(excursions);
	}

	@GetMapping("/excursions")
	public List<Excursion> findAllExcursions() {
		return service.getExcursions();
	}
	
	/*@GetMapping("/approvedExcursions/{is_approved}")
	public List<Excursion> getApprovedExcursions(@PathVariable boolean is_approved) {
		return service.getApprovedExcursions();
	}*/

	@GetMapping("/excursion/{id}")
	public Excursion getExcursionById(@PathVariable int id) {
		return service.getExcursionById(id);
	}

	/*@GetMapping("/excursion/{username}")
	public Excursion getExcursionByUsername(@PathVariable String username) {
		return service.getExcursionByUsername(username);
	}*/

	@PutMapping("/updateExcursion")
	public Excursion updateExcursion(@RequestBody Excursion excursion) {
		return service.updateExcursion(excursion);
	}
	
	@PutMapping("/approveExcursion")
	public Excursion approveExcursion(@RequestBody Excursion excursion) {
		return service.approveExcursion(excursion);
	}

	@DeleteMapping("/deleteExcursion/{id}")
	public String deleteExcursion(@PathVariable int id) {
		return service.deleteExcursion(id);
	}
}
