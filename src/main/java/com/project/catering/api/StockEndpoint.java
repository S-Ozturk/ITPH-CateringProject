package com.project.catering.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.catering.controller.MealListService;
import com.project.catering.controller.StockService;
import com.project.catering.domain.MealList;
import com.project.catering.domain.MealList_Recepie;
import com.project.catering.domain.Recepie;
import com.project.catering.domain.Recepie_Ingredient;
import com.project.catering.domain.Stock;

@Path("stock")
@Component
public class StockEndpoint {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private MealListService mealListService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Stock> stocks= stockService.getAllStocks();
		return Response.ok(stocks).build();
	}
	
	@Path("/{stockid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleStock ( @PathParam("stockid") int id){
		Stock stock =  stockService.getStockById(id);
		return Response.ok(stock).build();
	}
	
	@Path("/{meallistid}/meallist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStocksForMealList ( @PathParam("meallistid") int id){
		List<List<String>> resultList = new ArrayList<List<String>>();
		MealList mealList = mealListService.getMealListById(id);
		for(MealList_Recepie mr: mealList.getRecepies()) {
			int recepieAmount = mr.getRecepie_amount();
			Recepie re = mr.getRecepie();
			for(Recepie_Ingredient ri : re.getIngredients()) {
				Double ingredientAmount = ri.getIngredient_amount();
				Long ingredientId = ri.getIngredient_Id();
				String ingredientName = ri.getIngredient().getName();
				Double ingredientNeed = recepieAmount * ingredientAmount;
				Double stockAmount = stockService.getStockByIngredientId(ingredientId).getAmount();
				int control = -1;
				for(int i=0;i<resultList.size();i++) {
					if(resultList.get(i).get(0).equals(ingredientId.toString())) {
						control = i;
						break;
					}
				}
				if(control >= 0) {
					Double temp = Double.parseDouble(resultList.get(control).get(2));
					temp += ingredientNeed;
					resultList.get(control).set(2, temp.toString());
				}else {
					List<String> result = new ArrayList<>();
					result.add(ingredientId.toString());
					result.add(ingredientName);
					result.add(ingredientNeed.toString());
					result.add(stockAmount.toString());
					resultList.add(result);
				}
			}
		}
		//Stock stock =  stockService.getStockById(id);
		return Response.ok(resultList).build();
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResult ( @PathParam("search") String search){
		Iterable <Stock> stocks = stockService.getStocksLike(search);
		return Response.ok(stocks).build();
	}
	*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeStock(Stock stock){
		Stock result = stockService.saveStock(stock);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateStock(Stock stock){
		Stock result = stockService.saveStock(stock);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteStock(Long stockid){
		stockService.deleteStock(stockid);
	}
	
}