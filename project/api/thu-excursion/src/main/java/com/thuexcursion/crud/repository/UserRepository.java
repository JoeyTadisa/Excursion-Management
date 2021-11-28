package com.thuexcursion.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.thuexcursion.crud.model.User;

/*
 * This interface extends JpaRepository which contains the api of basic CRUD operations, pagination and sorting
 * In this way, boilerplate code like sql statements do not need to be written explicitly 
 * */
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value="select u.user_id, u.user_number, u.user_type, u.username, u.password, u.firstname, u.lastname, u.email, u.address, u.is_active from user u where username = :username and password = :password", nativeQuery = true)
    User findLoginCredentials(String username, String password);
    
    @Query(value="select u.user_id, u.user_number, u.user_type, u.username, u.password, u.firstname, u.lastname, u.email, u.address, u.is_active from user u where user_type = :user_type", nativeQuery = true)
    List<User> findByType(String user_type);
}
