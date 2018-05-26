package com.project.catering.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.project.catering.api.IngredientEndpoint;
import com.project.catering.api.RoleEndpoint;
import com.project.catering.api.UserEndpoint;



@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(IngredientEndpoint.class);
		register(RoleEndpoint.class);
		register(UserEndpoint.class);
	}
}
