package com.project.javaee.rentmovies.service;

import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.Rental;

@Service
public interface RentalService {
	public Rental save(Rental rental);
	
}
