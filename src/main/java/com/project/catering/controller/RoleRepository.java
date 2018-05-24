package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Role;

@Component
public interface RoleRepository extends CrudRepository<Role, Long> {

}
