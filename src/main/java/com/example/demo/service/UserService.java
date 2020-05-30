package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ApplicationUser;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String createUser(ApplicationUser user) {		
		userRepository.save(user);
		return "Signup successful";
	}
	
	public List<ApplicationUser> getAllUsers()
	{
		return userRepository.findAllApplicationUser();
	}
	
}
