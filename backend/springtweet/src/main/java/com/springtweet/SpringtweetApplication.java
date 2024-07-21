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

@SpringBootApplication
public class SpringtweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtweetApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepo, UserRepository userRepo) {
		return args -> {
			roleRepo.save(new Role(1, "USER"));
			ApplicationUser u = new ApplicationUser();
			u.setFirstName("Gustavo");
			u.setLastName("Lima");
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepo.findByAuthority("USER").get());
			u.setAuthorities(roles);
			userRepo.save(u);
		};
	}

}
