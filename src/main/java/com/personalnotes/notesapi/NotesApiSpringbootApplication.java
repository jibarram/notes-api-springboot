package com.personalnotes.notesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "Personal Notes API (Java 17 & Spring Boot)",
    version = "1.0",
    description = "Microservicio CRUD de notas personales."
))
public class NotesApiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApiSpringbootApplication.class, args);
	}

}
