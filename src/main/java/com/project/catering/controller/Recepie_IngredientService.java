package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Recepie_Ingredient;

@Service
@Transactional
public class Recepie_IngredientService {
	@Autowired
	private Recepie_IngredientRepository recepie_IngredientRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public Recepie_Ingredient saveRecepie_Ingredient(Recepie_Ingredient recepie_Ingredient) {
		return recepie_IngredientRepository.save(recepie_Ingredient);
	}
	
	public void saveAllRecepie_Ingredient(Iterable<Recepie_Ingredient> recepie_Ingredient, long recepieId) {
		for(Recepie_Ingredient ri : recepie_Ingredient) {
			ri.setRecepie_Id(recepieId);
			recepie_IngredientRepository.save(ri);
		}
	}
	
	public void updateAllRecepie_Ingredient(Iterable<Recepie_Ingredient> recepie_Ingredient) {
		recepie_IngredientRepository.saveAll(recepie_Ingredient);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Recepie_Ingredient> getAllRecepie_Ingredients(){
		return recepie_IngredientRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Recepie_Ingredient> getRecepie_IngredientByRecepie_id(int search){
		try {
			long d = (long)(search);
            return recepie_IngredientRepository.findByRecepie_id(d);
        } catch (NumberFormatException e) {
    		return recepie_IngredientRepository.findAll();
        }
	};
	
	//@PreAuthorize("isAuthenticated()")
		public Iterable<Recepie_Ingredient> getRecepie_IngredientByIngredient_id(int search){
			try {
	            long d = (long)(search);
	            return recepie_IngredientRepository.findByIngredient_id(d);
	        } catch (NumberFormatException e) {
	        	return recepie_IngredientRepository.findAll();
	        }
		};
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteRecepie_Ingredient(Recepie_Ingredient recepie_Ingredient) {
		recepie_IngredientRepository.delete(recepie_Ingredient);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Recepie_Ingredient getRecepie_IngredientById(long ingredient_id) {
		Recepie_Ingredient obj = recepie_IngredientRepository.findById(ingredient_id).get();
		return obj;
	}

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteRecepie_IngredientArray(Iterable<Recepie_Ingredient> recepie_Ingredient) {
		for(Recepie_Ingredient ri: recepie_Ingredient) {
			deleteRecepie_Ingredient(ri);
		}
	}
}
