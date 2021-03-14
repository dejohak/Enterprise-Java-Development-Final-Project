package com.ironhack.recipesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecipesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesServiceApplication.class, args);
	}

}
