package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Ingredient;

@Service
@Transactional
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	public Ingredient saveIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}
	
	public Iterable<Ingredient> getAllIngredients(){
		return ingredientRepository.findAll();
	}
	
	public Iterable<Ingredient> getIngredientsLike(String search){
		try {
	        long l = Long.parseLong(search);
	        //System.out.println("It's an long: " + l);
	        return ingredientRepository.findByIdLike(l);
	    } catch (NumberFormatException e) {
	        try {
	            double d = Double.parseDouble(search);
	            //System.out.println("It's an double: " + d);
	            return ingredientRepository.findByCaloriePerUnitLike(d);
	        } catch (NumberFormatException e2) {
	        	//System.out.println("It's an string: " + search);
	        	search = "%" + search + "%";
	        	return ingredientRepository.findByNameOrTypeOrUnitTypeLike(search,search,search);
	        }
	    }
	}
	
	public void deleteIngredient(Long id) {
		ingredientRepository.delete(getIngredientById(id));
	}
	
	public Ingredient getIngredientById(long articleId) {
		Ingredient obj = ingredientRepository.findById(articleId).get();
		return obj;
	}	
}
