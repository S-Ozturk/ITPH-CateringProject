package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Ingredient;
import com.project.catering.domain.Recepie;
import com.project.catering.domain.Recepie_Ingredient;

@Component
public interface RecepieRepository extends CrudRepository<Recepie, Long> {
	List<Recepie> findByNameContainingOrUnitTypeContainingOrRecepieTypeContaining(String searchName,String searchUnitType,String searchRecepieType);
	List<Recepie> findByCaloriePerPortionLikeOrPortionPerRecepieLike(double searchCaloriePerPortion,double searchPortionPerRecepie);
}

