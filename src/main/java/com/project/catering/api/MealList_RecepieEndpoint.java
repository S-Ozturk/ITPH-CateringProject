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

import com.project.catering.controller.MealList_RecepieService;
import com.project.catering.domain.MealList_Recepie;

@Path("recepie_ingredient")
@Component
public class MealList_RecepieEndpoint {
	
	@Autowired
	private MealList_RecepieService mealList_RecepieService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <MealList_Recepie> mealList_Recepies= mealList_RecepieService.getAllMealList_Recepies();
		return Response.ok(mealList_Recepies).build();
	}
	
	@Path("/{mealList_Recepieid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleMealList_Recepie ( @PathParam("mealList_Recepieid") int id){
		MealList_Recepie mealList_Recepie =  mealList_RecepieService.getMealList_RecepieById(id);
		return Response.ok(mealList_Recepie).build();
	}
	
	@Path("/{recepieid}/recepie")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByRecepie ( @PathParam("recepieid") int id){
		Iterable<MealList_Recepie> mealList_Recepie =  mealList_RecepieService.getMealList_RecepieByMealRecepie_Id(id);
		return Response.ok(mealList_Recepie).build();
	}
	
	@Path("/{meallistid}/meallist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIngredient ( @PathParam("meallistid") int id){
		Iterable<MealList_Recepie> mealList_Recepie =  mealList_RecepieService.getMealList_RecepieByMealList_id(id);
		return Response.ok(mealList_Recepie).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void changeMealList_Recepie(MealList_Recepie mealList_Recepie){
		mealList_RecepieService.saveMealList_Recepie(mealList_Recepie);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void updateMealList_Recepie(MealList_Recepie mealList_Recepie){
		mealList_RecepieService.saveMealList_Recepie(mealList_Recepie);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteRecepie(Iterable<MealList_Recepie> mealList_Recepie){
		mealList_RecepieService.deleteMealList_RecepieArray(mealList_Recepie);
	}
	
}