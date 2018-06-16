package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.OrderMeal_MealList;

@Component
public interface OrderMeal_MealListRepository extends CrudRepository<OrderMeal_MealList, Long> {
	List<OrderMeal_MealList> findByOrderMeal_id(Long id);
	List<OrderMeal_MealList> findByMealList_id(Long id);
}

