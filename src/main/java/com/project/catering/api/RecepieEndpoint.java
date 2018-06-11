package com.project.catering.api;


import java.util.List;

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

import com.project.catering.controller.RecepieService;
import com.project.catering.controller.Recepie_IngredientService;
import com.project.catering.domain.Recepie;
import com.project.catering.domain.Recepie_Ingredient;

@Path("recepie")
@Component
public class RecepieEndpoint {
	
	@Autowired
	private RecepieService recepieService;
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Recepie> recepies= recepieService.getAllRecepies();
		return Response.ok(recepies).build();
	}
	
	@Path("/{recepieid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleRecepie ( @PathParam("recepieid") int id){
		Recepie recepie =  recepieService.getRecepieById(id);
		return Response.ok(recepie).build();
	}
	
	@Path("/{search}/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResult ( @PathParam("search") String search){
		Iterable <Recepie> recepies = recepieService.getRecepiesLike(search);
		return Response.ok(recepies).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeRecepie(Recepie recepie){
		Recepie result = recepieService.saveRecepie(recepie);
		if(recepie.getIngredients() != null) recepie_IngredientService.saveAllRecepie_Ingredient(recepie.getIngredients(), result.getId());
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateRecepie(Recepie recepie){
		if(recepie.getIngredients() != null) {
			List<Recepie_Ingredient> oldIngredients = (List<Recepie_Ingredient>) recepieService.getRecepieById(recepie.getId()).getIngredients();
			for(Recepie_Ingredient i : recepie.getIngredients()) {
				if(oldIngredients.contains(i)) oldIngredients.remove(i);	
			}
			recepie_IngredientService.deleteRecepie_IngredientArray(oldIngredients);
			recepie_IngredientService.updateAllRecepie_Ingredient(recepie.getIngredients());
		}
		Recepie result = recepieService.saveRecepie(recepie);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteRecepie(int recepieid){
		recepie_IngredientService.deleteRecepie_IngredientArray(recepie_IngredientService.getRecepie_IngredientByRecepie_id(recepieid));
		recepieService.deleteRecepie(recepieid);
	}
	
}