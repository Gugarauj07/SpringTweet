package com.springtweet;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springtweet.models.ApplicationUser;
import com.springtweet.models.Role;
import com.springtweet.repositories.RoleRepository;
import com.springtweet.repositories.UserRepository;
import com.springtweet.services.UserService;

@SpringBootApplication
public class SpringtweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtweetApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepo, UserService userService) {
		return args -> {
			roleRepo.save(new Role(1, "USER"));
			ApplicationUser u = new ApplicationUser();
			
			u.setFirstName("Guga");
			u.setLastName("Lima");
			
			userService.registerUser(u);
		};
	}
}
