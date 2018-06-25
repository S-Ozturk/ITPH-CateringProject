package com.project.catering;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.project.catering.storage.StorageProperties;
import com.project.catering.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CateringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CateringApplication.class, args);
		
	}
	
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll(); //Remove At Final Project
            storageService.init();
        };
    }
}
