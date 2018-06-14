package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.MealList;
import com.project.catering.controller.MealList_RecepieService;

@Service
@Transactional
public class MealListService {
	@Autowired
	private MealListRepository mealListRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public MealList saveMealList(MealList mealList) {
		return mealListRepository.save(mealList);
	}
		
	//@PreAuthorize("isAuthenticated()")
	public Iterable<MealList> getAllMealLists(){
		return mealListRepository.findAll();
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteMealList(int id) {
		mealListRepository.delete(getMealListById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public MealList getMealListById(long mealListId) {
		MealList obj = mealListRepository.findById(mealListId).get();
		return obj;
	}	
	
}
