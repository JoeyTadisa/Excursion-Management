package com.thuexcursion.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.thuexcursion.crud.model.Excursion;
import com.thuexcursion.crud.repository.ExcursionRepository;
import com.thuexcursion.crud.service.ExcursionService;

/**
* ExcursionController class contains all the REST API endpoints for Booking functionality
* 
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/


@CrossOrigin
@RestController
public class ExcursionController {

	@Autowired
	private ExcursionService service;

	
	
	/** 
	 * @param excursion
	 * @return Excursion
	 */
	@PostMapping("/addExcursion")
	public Excursion addExcursion(@RequestBody Excursion excursion) {
		return service.saveExcursion(excursion);
	}

	
	/** 
	 * @param excursions
	 * @return List<Excursion>
	 */
	@PostMapping("/addExcursions")
	public List<Excursion> addExcursions(@RequestBody List<Excursion> excursions) {
		return service.saveExcursions(excursions);
	}

	
	/** 
	 * @return List<Excursion>
	 */
	@PreAuthorize("hasRole('ROLE_a') or hasRole('ROLE_o') or hasRole('ROLE_s')")
	@GetMapping("/excursions")
	public List<Excursion> findAllExcursions() {
		return service.getExcursions();
	}
	
	
	/** 
	 * @param is_approved
	 * @return List<Excursion>
	 */
	@GetMapping("/approvedExcursions/{is_approved}")
	public List<Excursion> getApprovedExcursions(@PathVariable boolean is_approved) {
		return service.getApprovedExcursions(is_approved);
	}

	
	/** 
	 * @param id
	 * @return Excursion
	 */
	@GetMapping("/excursion/{id}")
	public Excursion getExcursionById(@PathVariable int id) {
		return service.getExcursionById(id);
	}

	
	/** 
	 * @return Excursion
	 */
	/*@GetMapping("/excursion/{username}")
	public Excursion getExcursionByUsername(@PathVariable String username) {
		return service.getExcursionByUsername(username);
	}*/

	@PutMapping("/updateExcursion")
	public Excursion updateExcursion(@RequestBody Excursion excursion) {
		return service.updateExcursion(excursion);
	}

	
	/** 
	 * @param id
	 * @return ResponseEntity<Excursion>
	 */
	@PutMapping("/approveExcursion/{id}")
	public ResponseEntity<Excursion> approveExcursion(@PathVariable(value = "id")int id){
		Excursion excursion = getExcursionById(id);
		excursion.setIs_approved(true);
		final Excursion updatedExcursion = updateExcursion(excursion);
		return ResponseEntity.ok(updatedExcursion);
	}
	
	
	/** 
	 * @param excursion
	 * @return Excursion
	 */
	@PutMapping("/approveExcursion")
	public Excursion approveExcursion(@RequestBody Excursion excursion) {
		return service.approveExcursion(excursion);
	}

	
	/** 
	 * @param id
	 * @return String
	 */
	@DeleteMapping("/deleteExcursion/{id}")
	public String deleteExcursion(@PathVariable int id) {
		return service.deleteExcursion(id);
	}


	@PutMapping("/disapproveExcursion/{id}")
	public ResponseEntity<Excursion> disapproveExcursion(@PathVariable(value = "id")int id){
		Excursion excursion = getExcursionById(id);
		excursion.setIs_approved(false);
		final Excursion updatedExcursion = updateExcursion(excursion);
		return ResponseEntity.ok(updatedExcursion);
	}

	@PutMapping("/disapproveExcursion")
	public Excursion disapproveExcursion(@RequestBody Excursion excursion) {
		return service.disapproveExcursion(excursion);
	}


	

	/**
	 * For the new approach in approval_status
	 * initial status of excursion once created is "pending"
	 * this method set approval status to approved
	 */

	@PutMapping("/api/excursion/approve")
	public Excursion excursionSetToApproved(@RequestBody Excursion excursion) {
		return service.excursionSetToApproved(excursion);
	}

	@PutMapping("/api/excursion/disapprove")
	public Excursion excursionSetToDisapproved(@RequestBody Excursion excursion) {
		return service.excursionSetToDisapproved(excursion);
	}

	@PutMapping("/api/excursion/settopending")
	public Excursion excursionSetToPending(@RequestBody Excursion excursion) {
		return service.excursionSetToPending(excursion);
	}

	/**
	 * This endpoint is for fetching excursions based on approval_status
	 * approval_status: pending, approved, disapproved
	 */

	@PreAuthorize("hasRole('ROLE_a') or hasRole('ROLE_o') or hasRole('ROLE_s')")
	@GetMapping("/api/excursion/approvalstatus/{status}")
	public List<Excursion> getExcursionByApprovalStatus(@PathVariable String status) {
		return service.getExcursionByApprovalStatus(status);
	}


}
