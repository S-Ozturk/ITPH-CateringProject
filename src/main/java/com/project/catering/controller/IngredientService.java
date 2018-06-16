package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Ingredient;
import com.project.catering.domain.Stock;

@Service
@Transactional
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientRepository;
	
	@Autowired
	private StockRepository stockRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_NUTRITIONIST','ROLE_STOCKMANAGER')")
	public Ingredient saveIngredient(Ingredient ingredient) {
		Ingredient result = ingredientRepository.save(ingredient);
		Stock stock = new Stock();
		stock.setAmount(0);
		stock.setIngredient(result);
		stockRepository.save(stock);
		return result;
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
