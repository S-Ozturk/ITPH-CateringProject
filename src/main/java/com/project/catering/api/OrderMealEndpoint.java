package com.project.catering.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.catering.controller.OrderMealService;
import com.project.catering.domain.OrderMeal;

@Path("ordermeal")
@Component
public class OrderMealEndpoint {
	
	@Autowired
	private OrderMealService orderMealService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <OrderMeal> orderMeals= orderMealService.getAllOrderMeals();
		return Response.ok(orderMeals).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeOrderMeal(OrderMeal orderMeal){
		OrderMeal result = orderMealService.saveOrderMeal(orderMeal);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateOrderMeal(OrderMeal orderMeal){
		OrderMeal result = orderMealService.saveOrderMeal(orderMeal);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteOrderMeal(int orderMealid){
		orderMealService.deleteOrderMeal(orderMealid);
	}
	
}