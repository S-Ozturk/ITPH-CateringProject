package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Role;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Iterable<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	public Role getRoleById(long roleId) {
		return roleRepository.findById(roleId).get();
	}	
	
	public void deleteRole(Long id) {
		roleRepository.delete(getRoleById(id));
	}
}