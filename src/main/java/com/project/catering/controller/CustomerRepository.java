package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
