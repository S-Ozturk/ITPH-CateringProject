package com.project.catering.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.project.catering.domain.Stock;

@Component
public interface StockRepository extends CrudRepository<Stock, Long> {
	List<Stock> findByIngredient_id(Long id);
}

