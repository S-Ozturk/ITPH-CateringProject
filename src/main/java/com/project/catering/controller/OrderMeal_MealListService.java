package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.OrderMeal_MealList;

@Service
@Transactional
public class OrderMeal_MealListService {
	@Autowired
	private OrderMeal_MealListRepository orderMeal_MealListRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public OrderMeal_MealList saveOrderMeal_MealList(OrderMeal_MealList orderMeal_MealList) {
		return orderMeal_MealListRepository.save(orderMeal_MealList);
	}
	
	public void saveAllOrderMeal_MealList(Iterable<OrderMeal_MealList> orderMeal_MealList, long orderMealId) {
		for(OrderMeal_MealList om : orderMeal_MealList) {
			om.setOrderMeal_Id(orderMealId);
			orderMeal_MealListRepository.save(om);
		}
	}
	
	public void updateAllOrderMeal_MealList(Iterable<OrderMeal_MealList> orderMeal_MealList) {
		orderMeal_MealListRepository.saveAll(orderMeal_MealList);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<OrderMeal_MealList> getAllOrderMeal_MealLists(){
		return orderMeal_MealListRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<OrderMeal_MealList> getOrderMeal_MealListByOrderMeal_id(int search){
		try {
			long d = (long)(search);
            return orderMeal_MealListRepository.findByOrderMeal_id(d);
        } catch (NumberFormatException e) {
    		return orderMeal_MealListRepository.findAll();
        }
	};
	
	//@PreAuthorize("isAuthenticated()")
		public Iterable<OrderMeal_MealList> getOrderMeal_MealListByMealList_id(int search){
			try {
	            long d = (long)(search);
	            return orderMeal_MealListRepository.findByMealList_id(d);
	        } catch (NumberFormatException e) {
	        	return orderMeal_MealListRepository.findAll();
	        }
		};
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteOrderMeal_MealList(OrderMeal_MealList orderMeal_MealList) {
		orderMeal_MealListRepository.delete(orderMeal_MealList);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public OrderMeal_MealList getOrderMeal_MealListById(long id) {
		OrderMeal_MealList obj = orderMeal_MealListRepository.findById(id).get();
		return obj;
	}

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteOrderMeal_MealListArray(Iterable<OrderMeal_MealList> orderMeal_MealList) {
		for(OrderMeal_MealList om: orderMeal_MealList) {
			deleteOrderMeal_MealList(om);
		}
	}
}
