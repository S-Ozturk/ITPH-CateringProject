package com.project.catering.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.MealList;

@Component
public interface MealListRepository extends CrudRepository<MealList, Long> {

}

