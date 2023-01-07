package com.enigmagpt.learning.patternrecognitionapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
class ApplicationApi {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationApi.class, args);
	}

}
