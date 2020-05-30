package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long>{
 
	ApplicationUser findByUsername(String name);
	
	@Query( value = "SELECT * FROM APPLICATION_USER", 
			nativeQuery = true )
	List<ApplicationUser> findAllApplicationUser();

}
