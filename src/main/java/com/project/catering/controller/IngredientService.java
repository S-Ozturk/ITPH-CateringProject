package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Ingredient;

@Service
@Transactional
public class IngredientService {
	@Autowired
	private IngredientRepository amusementRepository;

	public Ingredient saveIngredient(Ingredient ingredient) {
		return amusementRepository.save(ingredient);
	}
	
	public Iterable<Ingredient> getAllIngredients(){
		return amusementRepository.findAll();
	}
}
