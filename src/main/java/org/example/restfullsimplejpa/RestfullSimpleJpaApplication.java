package org.example.restfullsimplejpa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Data analytic RestfulApi",
//description = "This is free api",
//		contact = @Contact(name = "The name", email = "email@gmail.com",url = "ww.ff.com")
//))
public class RestfullSimpleJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullSimpleJpaApplication.class, args);
	}

}
