package com.petstore.rest;

import com.petstore.dao.PetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PetRepository.class)
public class PetStoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}
}
