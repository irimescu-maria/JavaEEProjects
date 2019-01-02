package com.project.javaee.rentmovies.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.repository.RoleRepository;
import com.project.javaee.rentmovies.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		System.out.println("Save user " + user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(2);
		
		Role userRole = roleRepository.findByRole("CUSTOMER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
