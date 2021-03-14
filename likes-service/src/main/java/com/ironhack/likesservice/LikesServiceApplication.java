package com.ironhack.likesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LikesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikesServiceApplication.class, args);
	}

}
