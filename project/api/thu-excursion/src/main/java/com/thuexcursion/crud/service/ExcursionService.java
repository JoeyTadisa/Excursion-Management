package com.thuexcursion.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Excursion;
import com.thuexcursion.crud.model.Excursion;
import com.thuexcursion.crud.repository.ExcursionRepository;
import com.thuexcursion.crud.repository.ExcursionRepository;

@Service
public class ExcursionService {
	
	@Autowired
	private ExcursionRepository repository;
	
	public Excursion saveExcursion(Excursion excursion) {
		return repository.save(excursion);
	}
	
	public List<Excursion> saveExcursions(List<Excursion> excursions) {
		return repository.saveAll(excursions);
	}
	
	public List<Excursion> getExcursions(){
		return repository.findAll();
	}
	
	/*public List<Excursion> getApprovedExcursions(boolean is_approved){
		return repository.findByApprovalStatus(is_approved);
	}*/
	
	public Excursion getExcursionById(int id){
		return repository.findById(id).orElse(null);
	}

	//login
	/*public Excursion getExcursionByUsername(String username){
		return repository.findByUsername(username);
	}*/
	
	public String deleteExcursion(int id) {
		 repository.deleteById(id);
		 return "excursion removed!" + id;
	}


	public Excursion updateExcursion(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		 existingExcursion.setDescription(excursion.getDescription());
		 existingExcursion.setDate_written(excursion.getDate_written());
		 existingExcursion.setMax_participants(excursion.getMax_participants());
		 existingExcursion.setReg_deadline(excursion.getReg_deadline());
		 existingExcursion.setDereg_deadline(excursion.getDereg_deadline());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setTitle(excursion.getTitle());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setRequested_by(excursion.getRequested_by());
		 return repository.save(existingExcursion);
	}
	
	public Excursion approveExcursion(Excursion excursion) {
		Excursion existingExcursion = repository.findById(excursion.getId()).orElse(excursion);
		  existingExcursion.setIs_approved(excursion.getIs_approved());
		 return repository.save(existingExcursion);
	}
	
	


}
