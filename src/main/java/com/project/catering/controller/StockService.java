package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Stock;

@Service
@Transactional
public class StockService {
	@Autowired
	private StockRepository stockRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Stock saveStock (Stock stock) {
		return stockRepository.save(stock);
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Stock> getAllStocks(){
		return stockRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
		public Iterable<Stock> getStocksForMealLists(){
			return stockRepository.findAll();
		}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteStock(long id) {
		stockRepository.delete(getStockById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Stock getStockById(long stockId) {
		Stock obj = stockRepository.findById(stockId).get();
		return obj;
	}
	
	public Stock getStockByIngredientId(long ingredientId) {
		Stock obj = stockRepository.findByIngredient_id(ingredientId).get(0);
		return obj;
	}
}
