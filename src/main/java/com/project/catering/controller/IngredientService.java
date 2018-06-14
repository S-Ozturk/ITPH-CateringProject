package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Ingredient;

@Service
@Transactional
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_NUTRITIONIST','ROLE_STOCKMANAGER')")
	public Ingredient saveIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Ingredient> getAllIngredients(){
		return ingredientRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Ingredient> getIngredientsLike(String search){
		try {
	        long l = Long.parseLong(search);
	        return ingredientRepository.findByIdLike(l);
	    } catch (NumberFormatException e) {
	        try {
	            double d = Double.parseDouble(search);
	            return ingredientRepository.findByCaloriePerUnitLike(d);
	        } catch (NumberFormatException e2) {
	        	return ingredientRepository.findByNameContainingOrTypeContainingOrUnitTypeContaining(search,search,search);
	        }
	    }
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_NUTRITIONIST','ROLE_STOCKMANAGER')")
	public void deleteIngredient(int id) {
		recepie_IngredientRepository.deleteRecepie_IngredientArray(recepie_IngredientRepository.getRecepie_IngredientByIngredient_id(id));
		ingredientRepository.delete(getIngredientById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Ingredient getIngredientById(long ingredientId) {
		Ingredient obj = ingredientRepository.findById(ingredientId).get();
		return obj;
	}
}
