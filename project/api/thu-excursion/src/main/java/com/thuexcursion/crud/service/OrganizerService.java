package com.thuexcursion.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Organizer;
import com.thuexcursion.crud.repository.OrganizerRepository;
@Service
public class OrganizerService {
	@Autowired
	private OrganizerRepository repository;
	
	public Organizer saveOrganizer(Organizer organizer) {
		return repository.save(organizer);
	}
	
	public List<Organizer> saveOrganizers(List<Organizer> organizers) {
		return repository.saveAll(organizers);
	}
	
	public List<Organizer> getOrganizers(){
		return repository.findAll();
	}
	
	public Organizer getOrganizerById(int id){
		return repository.findById(id).orElse(null);
	}

	//login
	/*public organizer getorganizerByUsername(String username){
		return repository.findByUsername(username);
	}*/
	
	public String deleteOrganizer(int id) {
		 repository.deleteById(id);
		 return "product removed!" + id;
	}


	public Organizer updateOrganizer(Organizer organizer) {
		Organizer existingOrganizer = repository.findById(organizer.getId()).orElse(organizer);
		 existingOrganizer.setName_first(organizer.getName_first());
		 existingOrganizer.setName_last(organizer.getName_last());
		 existingOrganizer.setEmail(organizer.getEmail());
		 existingOrganizer.setAddress(organizer.getAddress());
		 return repository.save(existingOrganizer);
	}
	
}
