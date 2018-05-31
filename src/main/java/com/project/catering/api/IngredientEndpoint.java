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

import com.project.catering.controller.IngredientService;
import com.project.catering.domain.Ingredient;

@Path("ingredient")
@Component
public class IngredientEndpoint {
	
	@Autowired
	private IngredientService ingredientService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Ingredient> ingredients= ingredientService.getAllIngredients();
		return Response.ok(ingredients).build();
	}
	
	@Path("/{ingredientid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleIngredient ( @PathParam("ingredientid") int id){
		Ingredient ingredient =  ingredientService.getIngredientById(id);
		return Response.ok(ingredient).build();
	}
	
	@Path("/{search}/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResult ( @PathParam("search") String search){
		Iterable <Ingredient> ingredients = ingredientService.getIngredientsLike(search);
		return Response.ok(ingredients).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeIngredient(Ingredient ingredient){
		Ingredient result = ingredientService.saveIngredient(ingredient);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateIngredient(Ingredient ingredient){
		Ingredient result = ingredientService.saveIngredient(ingredient);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteIngredient(int ingredientid){
		ingredientService.deleteIngredient(ingredientid);
	}
	
}