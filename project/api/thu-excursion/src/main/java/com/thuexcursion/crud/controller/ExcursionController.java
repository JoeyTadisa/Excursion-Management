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
* For more information about EmailController, check swagger documentatio for endpoints
*/


@CrossOrigin
@RestController
public class ExcursionController {

	@Autowired
	private ExcursionService service;

	
	
	/** 
	 * This method is used to add a single excursion record
	 * @param excursion
	 * @return Excursion a newly added Excursion object
	 */
	@PostMapping("/addExcursion")
	public Excursion addExcursion(@RequestBody Excursion excursion) {
		return service.saveExcursion(excursion);
	}

	
	/** 
	 * This method is used to add list of excursions (NOT YET UI-INTEGRATED)
	 * @param excursions
	 * @return List<Excursion> returns newly added list of excursions
	 */
	@PostMapping("/addExcursions")
	public List<Excursion> addExcursions(@RequestBody List<Excursion> excursions) {
		return service.saveExcursions(excursions);
	}

	
	/** 
	 * This method fetches all excursion records in excursion table.
	 * This method can only be accessed by admin, organizer and student as specified in @PreAuthorize annotation
	 * @return List<Excursion> returns newly added list of excursions
	 */
	@PreAuthorize("hasRole('ROLE_a') or hasRole('ROLE_o') or hasRole('ROLE_s')")
	@GetMapping("/excursions")
	public List<Excursion> findAllExcursions() {
		return service.getExcursions();
	}
	
	
	/** 
	 * 
	 * @param is_approved
	 * @return List<Excursion>
	 */
	/*@GetMapping("/approvedExcursions/{is_approved}")
	public List<Excursion> getApprovedExcursions(@PathVariable boolean is_approved) {
		return service.getApprovedExcursions(is_approved);
	}*/

	
	/** 
	 * This method fetches a specific excursion based on excursion id
	 * @param id id of an excursion
	 * @return Excursion returns an excursion object
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

	/** 
	 * 	This method is used to update excursion record
	 *  @param excursion excursion json object passed in @RequestBody
	 *  @return Excursion returns a newly updated excursion object
	 */
	@PutMapping("/updateExcursion")
	public Excursion updateExcursion(@RequestBody Excursion excursion) {
		return service.updateExcursion(excursion);
	}

	
	/** 
	 * 
	 * @param id
	 * @return ResponseEntity<Excursion>
	 */
	/*@PutMapping("/approveExcursion/{id}")
	public ResponseEntity<Excursion> approveExcursion(@PathVariable(value = "id")int id){
		Excursion excursion = getExcursionById(id);
		excursion.setIs_approved(true);
		final Excursion updatedExcursion = updateExcursion(excursion);
		return ResponseEntity.ok(updatedExcursion);
	} */
	
	
	/** 
	 * This method approves an excursion request. It sets approval_status to 'a'
	 * @param excursion an excursion object 
	 * @return Excursion 
	 */
	/*@PutMapping("/approveExcursion")
	public Excursion approveExcursion(@RequestBody Excursion excursion) {
		return service.approveExcursion(excursion);
	}*/

	
	/** 
	 * This method is used to delete an excursion (NOT YET UI INTEGRATED)
	 * @param id id of an excursion to be deleted
	 * @return String
	 */
	@DeleteMapping("/deleteExcursion/{id}")
	public String deleteExcursion(@PathVariable int id) {
		return service.deleteExcursion(id);
	}


	/*@PutMapping("/disapproveExcursion/{id}")
	public ResponseEntity<Excursion> disapproveExcursion(@PathVariable(value = "id")int id){
		Excursion excursion = getExcursionById(id);
		excursion.setIs_approved(false);
		final Excursion updatedExcursion = updateExcursion(excursion);
		return ResponseEntity.ok(updatedExcursion);
	} */

	/** 
	 * This method is used to delete an excursion (NOT YET UI INTEGRATED)
	 * @param id id of an excursion to be deleted
	 * @return String
	 */
	@PutMapping("/disapproveExcursion")
	public Excursion disapproveExcursion(@RequestBody Excursion excursion) {
		return service.disapproveExcursion(excursion);
	}


	



	/** 
	 * This method approves an excursion request. It sets approval_status to 'a'
	 * @param excursion an excursion object 
	 * @return Excursion 
	 */
	@PutMapping("/api/excursion/approve")
	public Excursion excursionSetToApproved(@RequestBody Excursion excursion) {
		return service.excursionSetToApproved(excursion);
	}

	/** 
	 * This method disapprove an excursion request. It sets approval_status to 'd'
	 * @param excursion an excursion object 
	 * @return Excursion 
	 */
	@PutMapping("/api/excursion/disapprove")
	public Excursion excursionSetToDisapproved(@RequestBody Excursion excursion) {
		return service.excursionSetToDisapproved(excursion);
	}

	/** 
	 * By default, newly created excursion record is set to 'p' (pending).
	 * This method set approved or disapproved excursion request to 'p' 
	 * @param excursion an excursion object 
	 * @return Excursion returns newly updated excursion with approval_status 'p'
	 */

	@PutMapping("/api/excursion/settopending")
	public Excursion excursionSetToPending(@RequestBody Excursion excursion) {
		return service.excursionSetToPending(excursion);
	}

	/**
	 * This endpoint is for fetching excursions based on approval_status
	 * approval_status: pending, approved, disapproved
	 * @param status approval_status (p, a, d)
	 * @return List<Excursion> list of excursions with approval_status specified on parameter status
	 */

	@PreAuthorize("hasRole('ROLE_a') or hasRole('ROLE_o') or hasRole('ROLE_s')")
	@GetMapping("/api/excursion/approvalstatus/{status}")
	public List<Excursion> getExcursionByApprovalStatus(@PathVariable String status) {
		return service.getExcursionByApprovalStatus(status);
	}


}
