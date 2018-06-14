package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.OrderMeal;

@Service
@Transactional
public class OrderMealService {
	@Autowired
	private OrderMealRepository orderMealRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public OrderMeal saveOrderMeal(OrderMeal orderMeal) {
		return orderMealRepository.save(orderMeal);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<OrderMeal> getAllOrderMeals(){
		return orderMealRepository.findAll();
	}
	
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_NUTRITIONIST','ROLE_STOCKMANAGER')")
	public void deleteOrderMeal(int id) {
		orderMealRepository.delete(getOrderMealById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public OrderMeal getOrderMealById(long orderMealId) {
		OrderMeal obj = orderMealRepository.findById(orderMealId).get();
		return obj;
	}
}
