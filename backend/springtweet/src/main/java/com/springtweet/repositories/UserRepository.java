package com.springtweet.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.springtweet.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
	Optional<ApplicationUser> findByUsername(String username);
}
