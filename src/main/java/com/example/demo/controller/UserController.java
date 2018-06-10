package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
public class UserController {

	@RequestMapping(value = "/createUser",method = RequestMethod.POST)	
	public Map<User,String> createUser(@RequestBody User user){
		
		return null;
	}
}
