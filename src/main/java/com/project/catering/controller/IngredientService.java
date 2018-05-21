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
	
	public void deleteIngredient(Long id) {
		ingredientRepository.deleteById(id);
	}
	
}
