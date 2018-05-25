package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Ingredient;

@Component
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	List<Ingredient> findByIdLike(Long search);
	List<Ingredient> findByNameContainingOrTypeContainingOrUnitTypeContaining(String searchName,String searchType,String searchUnit);
	List<Ingredient> findByCaloriePerUnitLike(Double search);
}

