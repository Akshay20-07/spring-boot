package com.example.soap.springbootwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.soap.coursemanagement")
@SpringBootApplication
public class SpringBootWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebservicesApplication.class, args);
	}

}
