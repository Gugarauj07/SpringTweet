package com.springtweet.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtweet.models.ApplicationUser;
import com.springtweet.models.Role;
import com.springtweet.repositories.RoleRepository;
import com.springtweet.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	
	@Autowired
	public UserService(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	
	public ApplicationUser registerUser(ApplicationUser user) {
		Set<Role> roles = user.getAuthorities();
		roles.add(roleRepo.findByAuthority("USER").get());
		
		return userRepo.save(user);
	}
}
