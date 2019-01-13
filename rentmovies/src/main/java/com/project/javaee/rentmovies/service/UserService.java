package com.project.javaee.rentmovies.service;

import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.User;

@Service
public interface UserService {
	public User findUserByEmail(String email);
	
	public User findUserByFirstname(String firstname);
	
	
	
	public User saveUser(User user);
	
	public User loginUser(String email, String password);

	public User findById(Long id);
}
