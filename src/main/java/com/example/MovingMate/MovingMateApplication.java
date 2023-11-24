package com.example.MovingMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MovingMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovingMateApplication.class, args);
	}

}
