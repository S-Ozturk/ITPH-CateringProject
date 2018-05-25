package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByIdLike(Long search);
	List<User> findByUsernameContainingOrFirstNameContainingOrLastNameContainingOrEmailContaining(String username,String firstName,String lastName,String email);

}
