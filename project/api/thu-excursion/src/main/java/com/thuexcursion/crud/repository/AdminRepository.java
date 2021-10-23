package com.thuexcursion.crud.repository;



//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thuexcursion.crud.model.Admin;



public interface AdminRepository extends JpaRepository<Admin,Integer> {

	//Admin findByUsername(String username);

	//Optional<Admin> findByUsername(int username);

}
