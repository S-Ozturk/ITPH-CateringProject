package com.project.catering.controller;

import java.rmi.Remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Iterable<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Customer getCustomerById(long customerId) {
		return customerRepository.findById(customerId).get();
	}	
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteCustomer(Long id) {
		customerRepository.delete(getCustomerById(id));
	}
	
}