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
	public void deleteRecepie_Ingredient(Long id) {
		recepie_IngredientRepository.delete(getRecepie_IngredientById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Recepie_Ingredient getRecepie_IngredientById(long articleId) {
		Recepie_Ingredient obj = recepie_IngredientRepository.findById(articleId).get();
		return obj;
	}	
}
