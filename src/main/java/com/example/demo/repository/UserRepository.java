package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long>{
 
	ApplicationUser findByUsername(String name);
}
