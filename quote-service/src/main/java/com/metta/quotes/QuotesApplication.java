package com.metta.quotes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quote API Documentation", version = "1.0.0", description = "This documentation contains all the API's that are available for Quote service"))
public class QuotesApplication {


	public static void main(String[] args) {
		SpringApplication.run(QuotesApplication.class, args);
	}

}
