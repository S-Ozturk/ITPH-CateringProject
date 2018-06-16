package com.project.catering.api;

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

import com.project.catering.controller.OrderMeal_MealListService;
import com.project.catering.domain.OrderMeal_MealList;

@Path("ordermeal_meallist")
@Component
public class OrderMeal_MealListEndpoint {
	
	@Autowired
	private OrderMeal_MealListService orderMeal_MealListService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <OrderMeal_MealList> orderMeal_MealLists= orderMeal_MealListService.getAllOrderMeal_MealLists();
		return Response.ok(orderMeal_MealLists).build();
	}
	
	@Path("/{orderMeal_MealListid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleOrderMeal_MealList ( @PathParam("orderMeal_MealListid") int id){
		OrderMeal_MealList orderMeal_MealList =  orderMeal_MealListService.getOrderMeal_MealListById(id);
		return Response.ok(orderMeal_MealList).build();
	}
	
	@Path("/{ordermealid}/ordermeal")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByOrderMeal ( @PathParam("ordermealid") int id){
		Iterable<OrderMeal_MealList> orderMeal_MealList =  orderMeal_MealListService.getOrderMeal_MealListByOrderMeal_id(id);
		return Response.ok(orderMeal_MealList).build();
	}
	
	@Path("/{meallistid}/meallist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByMealList ( @PathParam("meallistid") int id){
		Iterable<OrderMeal_MealList> orderMeal_MealList =  orderMeal_MealListService.getOrderMeal_MealListByMealList_id(id);
		return Response.ok(orderMeal_MealList).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void changeOrderMeal_MealList(OrderMeal_MealList orderMeal_MealList){
		orderMeal_MealListService.saveOrderMeal_MealList(orderMeal_MealList);
	}	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateOrderMeal_MealList(OrderMeal_MealList orderMeal_MealList){
		orderMeal_MealListService.saveOrderMeal_MealList(orderMeal_MealList);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteRecepie(Iterable<OrderMeal_MealList> orderMeal_MealList){
		orderMeal_MealListService.deleteOrderMeal_MealListArray(orderMeal_MealList);
	}
	
}