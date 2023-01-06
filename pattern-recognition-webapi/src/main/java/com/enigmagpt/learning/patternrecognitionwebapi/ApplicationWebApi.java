package com.enigmagpt.learning.patternrecognitionwebapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
class ApplicationWebApi {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationWebApi.class, args);
	}

}
