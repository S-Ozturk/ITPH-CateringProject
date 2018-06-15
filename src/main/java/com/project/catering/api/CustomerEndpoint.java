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

import com.project.catering.controller.CustomerService;
import com.project.catering.controller.RoleService;
import com.project.catering.controller.UserService;
import com.project.catering.domain.Customer;
import com.project.catering.domain.User;

@Path("customer")
@Component
public class CustomerEndpoint {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Customer> customers= customerService.getAllCustomers();
		return Response.ok(customers).build();
	}
	
	@Path("/{customerid}/single")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleCustomer ( @PathParam("customerid") int id){
		Customer customer =  customerService.getCustomerById(id);
		return Response.ok(customer).build();
	}
	
	//Long version of add function can be deleted in final version
	/*@Path("/{adress}/{name}/{phone}/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addNewCustomerLongway(User user, @PathParam("adress") String adress, @PathParam("name") String name, @PathParam("phone") String phone){
		user.setRole(roleService.getRoleCustomer());
		User resultUser = userService.saveUser(user);
		Customer customer = new Customer();
		customer.setAdress(adress);
		customer.setName(name);
		customer.setPhone(phone);
		customer.setUser(userService.getUserById(resultUser.getId()));
		Customer result = customerService.saveCustomer(customer);
		return Response.accepted(result.getId()).build();	
	}*/
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addNewCustomer(Customer customer){
		User user = customer.getUser();
		user.setRole(roleService.getRoleCustomer());
		User resultUser = userService.saveUser(user);
		customer.setUser(resultUser);
		Customer result = customerService.saveCustomer(customer);
		return Response.accepted(result.getId()).build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response changeCustomer(Customer customer){
		Customer result = customerService.saveCustomer(customer);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateCustomer(Customer customer){
		Customer result = customerService.saveCustomer(customer);
		return Response.accepted(result.getId()).build();	
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteCustomer(Long customerid){
		customerService.deleteCustomer(customerid);
	}
	
}