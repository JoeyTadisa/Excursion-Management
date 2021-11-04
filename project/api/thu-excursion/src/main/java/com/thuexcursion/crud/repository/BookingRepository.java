package com.thuexcursion.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.thuexcursion.crud.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query(value="select ", nativeQuery=true)
    List<Booking> findByStudentMatriculationNo(int matriculation_no);

}
