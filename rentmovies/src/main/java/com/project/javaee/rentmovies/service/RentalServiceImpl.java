package com.project.javaee.rentmovies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.javaee.rentmovies.model.Rental;
import com.project.javaee.rentmovies.repository.RentalRepository;

@Service("rentalService")
public class RentalServiceImpl implements RentalService{

	
	@Autowired
	private RentalRepository rentalRepository;
	
	@Override
	@Transactional
	public Rental save(Rental rental) {
		rentalRepository.save(rental);
		return rental;
	}

}
