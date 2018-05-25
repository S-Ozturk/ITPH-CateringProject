package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Role;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@PreAuthorize("hasRole('ADMIN')")
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public Iterable<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public Role getRoleById(long roleId) {
		return roleRepository.findById(roleId).get();
	}	
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteRole(Long id) {
		roleRepository.delete(getRoleById(id));
	}
	
	@PreAuthorize("isAuthenticated()")
	public Iterable<Role> getRolesLike(String search){
		try {
	        long l = Long.parseLong(search);
	        return roleRepository.findByIdLike(l);
	    } catch (NumberFormatException e) {
        	return roleRepository.findByNameContaining(search);
	    }
	}
}