package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Role;

@Component
public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findByIdLike(Long search);
	List<Role> findByNameContaining(String searchName);
}
