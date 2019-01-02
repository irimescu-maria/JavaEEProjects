package com.project.javaee.rentmovies.service;

import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.User;

@Service
public interface UserService {
	public User findUserByEmail(String email);
	
	public User saveUser(User user);
}
