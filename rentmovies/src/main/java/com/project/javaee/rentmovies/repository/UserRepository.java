package com.project.javaee.rentmovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.javaee.rentmovies.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	User findByFirstname(String firstname);
}
