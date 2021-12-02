package com.thuexcursion.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Excursion;

/*
 * This interface extends JpaRepository which contains the api of basic CRUD operations, pagination and sorting
 * In this way, boilerplate code like sql statements do not need to be written explicitly 
 * */
public interface ExcursionRepository extends JpaRepository<Excursion,Integer>{


	@Query(value="select distinct idExcursion,dateadded,maxparticipants,regdeadline,deregdeadline,meetingdetails,title,requestedby,description, is_approved,reviewed_by,date_reviewed,destination,date_of_excursion, excursion_fee from excursion where is_approved = :is_approved", nativeQuery=true)
    List<Excursion> findByApprovedExcursion(boolean is_approved);

	/*@Query( "select o from excursionapproval o where is_approved in :is_approved" );
	List<Excursion> findByApprovalStatus(boolean is_approved);*/

}
