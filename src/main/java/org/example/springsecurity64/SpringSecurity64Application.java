package org.example.springsecurity64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecurity64Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity64Application.class, args);
	}

}
