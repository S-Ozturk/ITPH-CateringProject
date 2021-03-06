package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.MealList_Recepie;
import com.project.catering.domain.Recepie_Ingredient;

@Service
@Transactional
public class MealList_RecepieService {
	@Autowired
	private MealList_RecepieRepository mealList_RecepieRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public MealList_Recepie saveMealList_Recepie(MealList_Recepie mealList_Recepie) {
		return mealList_RecepieRepository.save(mealList_Recepie);
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void saveAllMealList_Recepie(Iterable<MealList_Recepie> mealList_Recepie, long mealListId) {
		for(MealList_Recepie ri : mealList_Recepie) {
			ri.setMealList_Id(mealListId);
			saveMealList_Recepie(ri);
		}
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void updateAllMealList_Recepie(Iterable<MealList_Recepie> mealList_Recepie) {
		mealList_RecepieRepository.saveAll(mealList_Recepie);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<MealList_Recepie> getAllMealList_Recepies(){
		return mealList_RecepieRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<MealList_Recepie> getMealList_RecepieByMealRecepie_Id(int search){
		try {
			long d = (long)(search);
            return mealList_RecepieRepository.findByRecepie_Id(d);
        } catch (NumberFormatException e) {
    		return mealList_RecepieRepository.findAll();
        }
	};
	
	//@PreAuthorize("isAuthenticated()")
		public Iterable<MealList_Recepie> getMealList_RecepieByMealList_id(int search){
			try {
	            long d = (long)(search);
	            return mealList_RecepieRepository.findByMealList_id(d);
	        } catch (NumberFormatException e) {
	        	return mealList_RecepieRepository.findAll();
	        }
		};
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteMealList_Recepie(MealList_Recepie mealList_Recepie) {
		mealList_RecepieRepository.delete(mealList_Recepie);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public MealList_Recepie getMealList_RecepieById(long recepie_id) {
		MealList_Recepie obj = mealList_RecepieRepository.findById(recepie_id).get();
		return obj;
	}

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteMealList_RecepieArray(Iterable<MealList_Recepie> mealList_Recepie) {
		for(MealList_Recepie mlr: mealList_Recepie) {
			deleteMealList_Recepie(mlr);
		}
	}
}
