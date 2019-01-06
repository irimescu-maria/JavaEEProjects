package com.project.javaee.rentmovies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.javaee.rentmovies.model.Role;
import com.project.javaee.rentmovies.repository.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired 
	private RoleRepository roleRepository; 
	
	@Override
	public List<Role> findAllRoles() {
		
		return roleRepository.findAll();
	}
	
	@Override
	public Role findRoleById(Long id) {
		
		return roleRepository.findById(id);
	}
}
