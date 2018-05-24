package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
