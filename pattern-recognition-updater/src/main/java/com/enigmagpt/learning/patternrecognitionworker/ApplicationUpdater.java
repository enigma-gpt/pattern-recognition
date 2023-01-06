package com.enigmagpt.learning.patternrecognitionworker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition
@SpringBootApplication
class ApplicationUpdater {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationUpdater.class, args);
	}
}
