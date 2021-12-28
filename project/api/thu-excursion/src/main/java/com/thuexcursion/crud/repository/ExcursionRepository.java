package com.thuexcursion.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Excursion;


/**
* ExcursionRepository interface extends JpaRepository which contains the api of basic CRUD operations for Excursion entity, pagination and sorting.
* In this way, boilerplate code like sql statements do not need to be written explicitly.
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Charissa Abegail Morales
* 
*/

public interface ExcursionRepository extends JpaRepository<Excursion,Integer>{

	/**
	 * Old version of finding approved excursions
	 */
	@Query(value="select distinct idExcursion,dateadded,maxparticipants,regdeadline,deregdeadline,meetingdetails,title,requestedby,description, is_approved,reviewed_by,date_reviewed,destination,date_of_excursion, excursion_fee, approval_status from excursion where is_approved = :is_approved", nativeQuery=true)
    List<Excursion> findByApprovedExcursion(boolean is_approved);

	/**
	 * Finding excursions by approval_status
	 * Approval statuses are 'a','d','p'
	 * 'a' - approved
	 * 'd' - disapproved
	 * 'p' - pending
	 */
	@Query(value="select distinct idExcursion,dateadded,maxparticipants,regdeadline,deregdeadline,meetingdetails,title,requestedby,description, is_approved,reviewed_by,date_reviewed,destination,date_of_excursion, excursion_fee, approval_status from excursion where approval_status = :approval_status", nativeQuery=true)
    List<Excursion> findExcursionByApprovalStatus(String approval_status);





	/*@Query( "select o from excursionapproval o where is_approved in :is_approved" );
	List<Excursion> findByApprovalStatus(boolean is_approved);*/

}
