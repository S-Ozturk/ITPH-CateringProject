package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@PreAuthorize("hasRole('ADMIN')")
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public User getUserById(long userId) {
		return userRepository.findById(userId).get();
	}	
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(Long id) {
		userRepository.delete(getUserById(id));
	}
	
	@PreAuthorize("isAuthenticated()")
	public Iterable<User> getUsersLike(String search){
		try {
	        long l = Long.parseLong(search);
	        return userRepository.findByIdLike(l);
	    } catch (NumberFormatException e) {
        	return userRepository.findByUsernameContainingOrFirstNameContainingOrLastNameContainingOrEmailContaining(search,search,search,search);
	    }
	}
}