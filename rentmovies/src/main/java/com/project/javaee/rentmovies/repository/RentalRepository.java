package com.project.javaee.rentmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.javaee.rentmovies.model.Rental;

@Repository("rentalRepository")
public interface RentalRepository extends JpaRepository<Rental, Long>{

}
