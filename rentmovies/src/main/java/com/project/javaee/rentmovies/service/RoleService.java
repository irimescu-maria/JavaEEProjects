package com.project.javaee.rentmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.Genre;
import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.repository.RoleRepository;

@Service
public interface RoleService {

	public List<Role> findAllRoles();
	
	public Role findRoleById(Long id);

}
