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

import com.project.catering.controller.UserService;
import com.project.catering.domain.User;

@Path("settings/user")
@Component
public class UserEndpoint {
	
	@Autowired
	private UserService userService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <User> users= userService.getAllUsers();
		return Response.ok(users).build();
	}
	
	@Path("/{userid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleUser ( @PathParam("userid") int id){
		User user =  userService.getUserById(id);
		return Response.ok(user).build();
	}
	
	@Path("/{search}/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResult ( @PathParam("search") String search){
		Iterable <User> users = userService.getUsersLike(search);
		return Response.ok(users).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeUser(User user){
		User result = userService.saveUser(user);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateUser(User user){
		User result = userService.saveUser(user);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteUser(Long userid){
		userService.deleteUser(userid);
	}
	
}