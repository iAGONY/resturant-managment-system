package com.resturant.managment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ResturantManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantManagmentSystemApplication.class, args);
	}

}
