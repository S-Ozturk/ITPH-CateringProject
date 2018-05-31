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

import com.project.catering.controller.Recepie_IngredientService;
import com.project.catering.domain.Recepie_Ingredient;

@Path("recepie_ingredient")
@Component
public class Recepie_IngredientEndpoint {
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Recepie_Ingredient> recepie_Ingredients= recepie_IngredientService.getAllRecepie_Ingredients();
		return Response.ok(recepie_Ingredients).build();
	}
	
	@Path("/{recepie_Ingredientid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleRecepie_Ingredient ( @PathParam("recepie_Ingredientid") int id){
		Recepie_Ingredient recepie_Ingredient =  recepie_IngredientService.getRecepie_IngredientById(id);
		return Response.ok(recepie_Ingredient).build();
	}
	
	@Path("/{recepieid}/recepie")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByRecepie ( @PathParam("recepieid") int id){
		Iterable<Recepie_Ingredient> recepie_Ingredient =  recepie_IngredientService.getRecepie_IngredientByRecepie_id(id);
		return Response.ok(recepie_Ingredient).build();
	}
	
	@Path("/{ingredientid}/ingredient")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIngredient ( @PathParam("ingredientid") int id){
		Iterable<Recepie_Ingredient> recepie_Ingredient =  recepie_IngredientService.getRecepie_IngredientByIngredient_id(id);
		return Response.ok(recepie_Ingredient).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void changeRecepie_Ingredient(Recepie_Ingredient recepie_Ingredient){
		recepie_IngredientService.saveRecepie_Ingredient(recepie_Ingredient);
	}
	
	/*
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateRecepie_Ingredient(Recepie_Ingredient recepie_Ingredient){
		Recepie_Ingredient result = recepie_IngredientService.saveRecepie_Ingredient(recepie_Ingredient);
		return Response.accepted(result.getId()).build();	
	}
	*/	
}