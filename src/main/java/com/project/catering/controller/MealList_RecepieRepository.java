package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.MealList_Recepie;

@Component
public interface MealList_RecepieRepository extends CrudRepository<MealList_Recepie, Long> {
	List<MealList_Recepie> findByMealRecepie_Id(Long id);
	List<MealList_Recepie> findByMealList_id(Long id);
}

