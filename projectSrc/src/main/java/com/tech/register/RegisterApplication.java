package com.tech.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tech.register")
public class RegisterApplication {	
	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);		
	}

}
