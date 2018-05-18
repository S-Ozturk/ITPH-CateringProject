package com.project.catering.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeIngredient(Ingredient ingredient){
		Ingredient result = ingredientService.saveIngredient(ingredient);
		return Response.accepted(result.getId()).build();	
	}
}