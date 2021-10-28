package com.thuexcursion.crud.repository;



//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Admin;

/*
 * This interface extends JpaRepository which contains the api of basic CRUD operations, pagination and sorting
 * In this way, boilerplate code like sql statements do not need to be written explicitly 
 * */

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	@Query(value="select a.idAdmin, a.employeeNumber, a.firstName, a.lastName, a.email, a.address, a.username, a.password, a.isActive from admin a where username = :username and password = :password", nativeQuery = true)
    Admin findLoginCredentials(String username, String password);

	//Admin findByUsername(String username);

	//Optional<Admin> findByUsername(int username);

}
