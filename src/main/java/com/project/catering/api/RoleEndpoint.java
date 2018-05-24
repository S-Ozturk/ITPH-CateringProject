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

import com.project.catering.controller.RoleService;
import com.project.catering.domain.Role;

@Path("settings/role")
@Component
public class RoleEndpoint {
	
	@Autowired
	private RoleService roleService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Role> roles= roleService.getAllRoles();
		return Response.ok(roles).build();
	}
	
	@Path("/{roleid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleRole ( @PathParam("roleid") int id){
		Role role =  roleService.getRoleById(id);
		return Response.ok(role).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeRole(Role role){
		Role result = roleService.saveRole(role);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateRole(Role role){
		Role result = roleService.saveRole(role);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteRole(Long roleid){
		roleService.deleteRole(roleid);
	}
	
}