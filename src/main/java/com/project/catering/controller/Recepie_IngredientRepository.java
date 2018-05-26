package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Recepie_Ingredient;

@Component
public interface Recepie_IngredientRepository extends CrudRepository<Recepie_Ingredient, Long> {
	List<Recepie_Ingredient> findByRecepie_id(Long id);
	List<Recepie_Ingredient> findByIngredient_id(Long id);
}

