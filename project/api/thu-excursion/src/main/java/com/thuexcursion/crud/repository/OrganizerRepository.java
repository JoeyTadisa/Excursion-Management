package com.thuexcursion.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuexcursion.crud.model.Organizer;

/*
 * This interface extends JpaRepository which contains the api of basic CRUD operations, pagination and sorting
 * In this way, boilerplate code like sql statements do not need to be written explicitly 
 * */
public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {

}
