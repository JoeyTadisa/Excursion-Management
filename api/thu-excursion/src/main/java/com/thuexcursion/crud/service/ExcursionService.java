package com.thuexcursion.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Excursion;
import com.thuexcursion.crud.repository.ExcursionRepository;

/**
* 
* ExcursionService class is part of Service Layer which main goal is to handle the details of the persistence mechanism.
* ExcursionService class handles business requirements related to Excursion functionality
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/
@Service
public class ExcursionService {
	
	@Autowired
	private ExcursionRepository repository;
	
	
	/** 
	 * @param excursion
	 * @return Excursion
	 */
	public Excursion saveExcursion(Excursion excursion) {
		return repository.save(excursion);
	}
	
	
	/** 
	 * @param excursions
	 * @return List<Excursion>
	 */
	public List<Excursion> saveExcursions(List<Excursion> excursions) {
		return repository.saveAll(excursions);
	}
	
	
	/** 
	 * @return List<Excursion>
	 */
	public List<Excursion> getExcursions(){
		return repository.findAll();
	}
	
	
	/** 
	 * @param is_approved
	 * @return List<Excursion>
	 */
	public List<Excursion> getApprovedExcursions(boolean is_approved){
		return repository.findByApprovedExcursion(is_approved);
	}
	
	
	/** 
	 * @param id
	 * @return Excursion
	 */
	public Excursion getExcursionById(int id){
		return repository.findById(id).orElse(null);
	}

	
	/** 
	 * @return String
	 */
	//login
	/*public Excursion getExcursionByUsername(String username){
		return repository.findByUsername(username);
	}*/
	
	public String deleteExcursion(int id) {
		 repository.deleteById(id);
		 return "excursion removed!" + id;
	}


	
	/** 
	 * @param excursion
	 * @return Excursion
	 */
	public Excursion updateExcursion(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		 existingExcursion.setDescription(excursion.getDescription());
		 //existingExcursion.setDate_written(excursion.getDate_written());
		 existingExcursion.setMax_participants(excursion.getMax_participants());
		 existingExcursion.setReg_deadline(excursion.getReg_deadline());
		 existingExcursion.setDereg_deadline(excursion.getDereg_deadline());

		 existingExcursion.setDate_of_excursion(excursion.getDate_of_excursion());
		 existingExcursion.setExcursion_fee(excursion.getExcursion_fee());

		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setTitle(excursion.getTitle());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setRequested_by(excursion.getRequested_by());
		 return repository.save(existingExcursion);
	}
	
	
	/** 
	 * @param excursion
	 * @return Excursion
	 */
	public Excursion approveExcursion(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setIs_approved(true);
		 return repository.save(existingExcursion);
	}
	
	public Excursion disapproveExcursion(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setIs_approved(false);
		 return repository.save(existingExcursion);
	}
	

	/** 
	 * New version of approval/disapproval function
	 * the initial status of excursion once created is "pending"
	 * this method will set approval_status to approved or value 1
	 */

	public Excursion excursionSetToApproved(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setApproval_status("a");
		 return repository.save(existingExcursion);
	}

	/** 
	 * New version of approval/disapproval function
	 * initial status of excursion once created is "pending"
	 * this method will set approval_status (int) to disapproved or value 2
	 */

	public Excursion excursionSetToDisapproved(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setApproval_status("d");
		 return repository.save(existingExcursion);
	}

	/** 
	 * New version of approval/disapproval function
	 * initial status of excursion once created is "pending"
	 * this method will set approval_status (int) to pending or value 0
	 */

	public Excursion excursionSetToPending(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setApproval_status("p");
		 return repository.save(existingExcursion);
	}
	
	/**
	 * Fetch excursions based on approval_status
	 */

	public List<Excursion> getExcursionByApprovalStatus(String status){
		return repository.findExcursionByApprovalStatus(status);
	}

}
