package com.project.javaee.rentmovies.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.User;

@Service
public interface UserService {
	public User findUserByEmail(String email);
	
	public void saveUser(User user);
}
