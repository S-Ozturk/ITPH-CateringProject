package com.project.catering.api;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import com.project.catering.controller.IngredientService;
import com.project.catering.controller.MealListService;
import com.project.catering.controller.MealList_RecepieService;
import com.project.catering.controller.RecepieService;
import com.project.catering.controller.Recepie_IngredientService;
import com.project.catering.controller.RoleService;
import com.project.catering.controller.UserRepository;
import com.project.catering.controller.UserService;
import com.project.catering.domain.Customer;
import com.project.catering.domain.Ingredient;
import com.project.catering.domain.MealList;
import com.project.catering.domain.MealList_Recepie;
import com.project.catering.domain.Recepie;
import com.project.catering.domain.Recepie_Ingredient;
import com.project.catering.domain.Role;
import com.project.catering.domain.User;

import javassist.expr.NewArray;

@Path("dummy")
@Component
public class DummyDataEndpoint {
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private RecepieService recepieService;
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientService;
	
	@Autowired
	private MealListService mealListService;
	
	@Autowired
	private MealList_RecepieService mealList_RecepieService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addDummyData(){
		
		String roleArr[]= {"ROLE_USER","ROLE_ADMIN","ROLE_CHEF","ROLE_CUSTOMER"};
		for(String arr:roleArr) {
			Role role = new Role();
			role.setName(arr);
			roleService.saveRole(role);
			System.out.println("role - "+ role.getName() + " - " + role.getId());
		};	
		
		String userArr[][]= {{"user","user name","user last name","user@cateringproject.nl","password","1"},
		{"admin","admin name","admin last name","admin@cateringproject.nl","password","2"},
		{"chef","chef name","chef last name","chef@cateringproject.nl","password","3"}};
		for(String[] arr:userArr) {
			User user = new User();
			user.setUsername(arr[0]);
			user.setFirstName(arr[1]);
			user.setLastName(arr[2]);
			user.setEmail(arr[3]);
			user.setPassword(arr[4]);
			user.setRole(roleService.getRoleById(Integer.parseInt(arr[5])));
			userService.saveUser(user);
			System.out.println("user - "+ user.getUsername()+" - " + user.getId());
		};
		
		String ingredientArr[][]= {{"Romige Kwark Stracciatella","Kaas","Piece","225"},{"Brown Bread Roll","Bread","Piece","150"},{"Filet Americain","Sauce","Gr","3.60"}
		,{"Egg","Egg","Piece","72.00"},{"Brown Beans","Vegetable","Gr","0.70"},{"Mix for Chili Con Carne","Sauce","Gr","3.50"},{"Silver Rice","Rice","Gr","3.70"},
		{"Red Onion","Vegetable","Piece","0.40"},{"Red Paprika Pepper (Medium)","Vegetable","Piece","37.00"},{"Ground Beef (70% Lean Meat / 30% Fat)","Meat","Gr","3.32"}};
		for(String[] arr:ingredientArr) {
			Ingredient ingredient = new Ingredient();
			ingredient.setName(arr[0]);
			ingredient.setType(arr[1]);
			ingredient.setUnitType(arr[2]);
			ingredient.setCaloriePerUnit(Double.parseDouble(arr[3]));
			ingredientService.saveIngredient(ingredient);
			System.out.println("ingredient - "+ ingredient.getName() + " - " + ingredient.getId());
		};
		
		String recepieArr[][]= {{"Romige Kwark Stracciatella","Piece","Aperatief","225","1","8-1"},{"Filet American","Piece","Aperatief","225","10","10-150,9-40"},
			{"Boiled Egg","Piece","Breakfast","78","1","11-1"},{"Chili Con Carne","Plate","Warm Meal","256","4","12-220,13-13,15-115,16-1,17-100"},
			{"Silver Rice","Plate","Warm Meal","185","10","14-1000"}};
		for(String[] arr:recepieArr) {
			Recepie recepie = new Recepie();
			recepie.setName(arr[0]);
			recepie.setUnitType(arr[1]);
			recepie.setRecepieType(arr[2]);
			recepie.setCaloriePerPortion(Double.parseDouble(arr[3]));
			recepie.setPortionPerRecepie(Double.parseDouble(arr[4]));
			String [] ingredients = arr[5].split(",");
			Recepie result = recepieService.saveRecepie(recepie);
			for(String ingredient : ingredients) {
				Recepie_Ingredient ri = new Recepie_Ingredient();
				String [] ingredientDetails = ingredient.split("-");
				ri.setIngredient_Id(Integer.parseInt(ingredientDetails[0]));
				ri.setIngredient_amount(Double.parseDouble(ingredientDetails[1]));
				ri.setRecepie_Id(result.getId());
				recepie_IngredientService.saveRecepie_Ingredient(ri);
			}
			System.out.println("recepie - "+ recepie.getName() + " - " + recepie.getId());
		};

		String MealListArr[][]= {{"Romige Kwark","Breakfast","225","18-1"},{"Filet American + Boiled Eggs","Lunch","303","19-1,20-2"},
		{"Chili Con Carne + Silver Rice","Dinner","441","21-1,22-1"}};
		for(String[] arr:MealListArr) {
			MealList mealList = new MealList();
			mealList.setName(arr[0]);
			mealList.setMealType(arr[1]);
			mealList.setCaloriePerPerson(Double.parseDouble(arr[2]));
			String [] recepies = arr[3].split(",");
			MealList result = mealListService.saveMealList(mealList);
			for(String recepie : recepies) {
				MealList_Recepie mr = new MealList_Recepie();
				String [] recepieDetails = recepie.split("-");
				mr.setRecepie_Id(Integer.parseInt(recepieDetails[0]));
				mr.setRecepie_amount(Integer.parseInt(recepieDetails[1]));
				mr.setMealList_Id(result.getId());
				mealList_RecepieService.saveMealList_Recepie(mr);
			}
			System.out.println("mealList - "+ mealList.getName() + " - " + mealList.getId());
		};
		
		//postData("customer",'{"name":"asd","adress":"asdasd","phone":"06 252","user":{"id":5}}');
		
		String CustomerArr[][]= {{"Dirk Schaap Co.","Bla Bla - Leiden","06 4670","Dirk","Schaap","dirkissuper","1234","dirk@itph.nl"}};
		for(String[] arr:CustomerArr) {
			User user = new User();
			user.setFirstName(arr[3]);
			user.setLastName(arr[4]);
			user.setUsername(arr[5]);
			user.setPassword(arr[6]);
			user.setEmail(arr[7]);
			user.setRole(roleService.getRoleCustomer());
			User result = userService.saveUser(user);
			Customer customer = new Customer();
			customer.setName(arr[0]);
			customer.setAdress(arr[1]);
			customer.setPhone(arr[2]);
			customer.setUser(result);
			customerService.saveCustomer(customer);
			System.out.println("customer - "+ customer.getName() + " - " + customer.getId() + " / " + result.getUsername() + " - " + result.getId());
		};
		System.out.println("Dummy Data is working");
		return Response.accepted("Dummy Data Added").build();	
	};
	
};
/*public Response addNewCustomer(Customer customer){
		User user = customer.getUser();
		user.setRole(roleService.getRoleCustomer());
		User resultUser = userService.saveUser(user);
		customer.setUser(userService.getUserById(resultUser.getId()));
		Customer result = customerService.saveCustomer(customer);
		return Response.accepted(result.getId()).build();	
	}

function postDummyOrderMeals() {
postData("ordermeal",'{"name": "Sevket","deliveryAdress": "leiden","orderDate": "2018-06-12","deliveryDate": "2018-06-13","minCalorie": 4000,"peopleAmount": 10,"mealLists": [{"id": 9},{"id": 10},{"id": 11}]}');
};

function postDummyCustomers() {
postData("customer",'{"name":"asd","adress":"asdasd","phone":"06 252","user":{"id":5}}');
postData("customer",'{"name":"dsa","adress":"dsadsa","phone":"06 ","user":{"id":7}}');	
};
*/