package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Ingredient;

@Component
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
