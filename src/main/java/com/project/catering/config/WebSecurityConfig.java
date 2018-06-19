package com.project.catering.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		     .authorizeRequests()
		        .antMatchers("/","/Customer","/api/**","/js/**","/css/**", "/pictures/**").permitAll()
		        .anyRequest().authenticated()
		        .and()  
	         .csrf()
	         	.disable()
		     .formLogin()
			     .loginPage("/login")
	             .permitAll()
                .and()
		    .logout()
		        .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")  // userservıce.getbyıd(3).getusername()
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                   .username("admin")
                   .password("password")
                   .roles("ADMIN")
                   .build();
        	return new InMemoryUserDetailsManager(user,admin);
    }
}