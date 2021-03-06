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

import com.project.catering.controller.MealListService;
import com.project.catering.controller.MealList_RecepieService;
import com.project.catering.domain.MealList;
import com.project.catering.domain.MealList_Recepie;
import com.project.catering.domain.Recepie_Ingredient;

@Path("meallist")
@Component
public class MealListEndpoint {
	
	@Autowired
	private MealListService mealListService;
	
	@Autowired
	private MealList_RecepieService mealList_RecepieService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <MealList> mealLists= mealListService.getAllMealLists();
		return Response.ok(mealLists).build();
	}
	
	@Path("/{mealListid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleMealList ( @PathParam("mealListid") int id){
		MealList mealList =  mealListService.getMealListById(id);
		return Response.ok(mealList).build();
	}
	
	/*@Path("/{search}/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResult ( @PathParam("search") String search){
		Iterable <MealList> mealLists = mealListService.getMealListsLike(search);
		return Response.ok(mealLists).build();
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeMealList(MealList mealList){
		MealList result = mealListService.saveMealList(mealList);
		if(mealList.getRecepies() != null) {
			mealList_RecepieService.saveAllMealList_Recepie(mealList.getRecepies(), result.getId());
		}
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateMealList(MealList mealList){
		if(mealList.getRecepies() != null) {
			List<MealList_Recepie> oldRecepies = (List<MealList_Recepie>) mealListService.getMealListById(mealList.getId()).getRecepies();
			for(MealList_Recepie i : mealList.getRecepies()) {
				if(oldRecepies.contains(i)) oldRecepies.remove(i);	
			}
			mealList_RecepieService.deleteMealList_RecepieArray(oldRecepies);
			mealList_RecepieService.updateAllMealList_Recepie(mealList.getRecepies());
		}
		MealList result = mealListService.saveMealList(mealList);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteMealList(int mealListid){
		mealListService.deleteMealList(mealListid);
	}
	
}