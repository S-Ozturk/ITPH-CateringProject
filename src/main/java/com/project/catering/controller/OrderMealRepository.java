package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.OrderMeal;

@Component
public interface OrderMealRepository extends CrudRepository<OrderMeal, Long> {

}

