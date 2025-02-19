package com.javaguides.springboot_restful_webservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring boot application restful web services documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Devendra Mishra",
						email = "devendramishra17@gmail.com",
						url = "https://www.linkedin.com/in/devendra-mishra-cse/"
				),
				license = @License(
						name = "apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot user management Documenttion",
				url = "https://docs.spring.io/spring-boot/index.html"
		)
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
