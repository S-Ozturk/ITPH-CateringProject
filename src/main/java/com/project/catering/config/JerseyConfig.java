package com.project.catering.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.project.catering.api.IngredientEndpoint;
import com.project.catering.api.MealListEndpoint;
import com.project.catering.api.MealList_RecepieEndpoint;
import com.project.catering.api.OrderMealEndpoint;
import com.project.catering.api.OrderMeal_MealListEndpoint;
import com.project.catering.api.RecepieEndpoint;
import com.project.catering.api.Recepie_IngredientEndpoint;
import com.project.catering.api.RoleEndpoint;
import com.project.catering.api.StockEndpoint;
import com.project.catering.api.UserEndpoint;
import com.project.catering.api.CustomerEndpoint;
import com.project.catering.api.DummyDataEndpoint;



@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(IngredientEndpoint.class);
		register(RecepieEndpoint.class);
		register(Recepie_IngredientEndpoint.class);
		register(MealListEndpoint.class);
		register(MealList_RecepieEndpoint.class);
		register(OrderMealEndpoint.class);
		register(OrderMeal_MealListEndpoint.class);
		register(RoleEndpoint.class);
		register(UserEndpoint.class);
		register(StockEndpoint.class);
		register(CustomerEndpoint.class);
		register(DummyDataEndpoint.class);
	}
}
