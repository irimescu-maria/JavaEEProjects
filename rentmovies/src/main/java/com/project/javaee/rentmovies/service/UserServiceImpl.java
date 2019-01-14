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

import com.project.javaee.rentmovies.dto.UserDTO;
import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.model.User;
import com.project.javaee.rentmovies.repository.RoleRepository;
import com.project.javaee.rentmovies.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

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
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	@Transactional
	public User findUserByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstname(firstname);
	}

	@Override
	@Transactional
	public User loginUser(String email, String password) {

		User user = this.findUserByEmail(email);

		// String encodePassword = passwordEncoder.encode(password);
		if (user != null && passwordEncoder.matches(password, user.getPassword().toString())
				&& user.getEmail().equals(email)) {
			return user;
		}
		return null;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

}
