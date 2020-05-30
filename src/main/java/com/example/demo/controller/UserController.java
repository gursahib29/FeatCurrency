package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Security.SecurityConstants;
import com.example.demo.domain.ApplicationUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
//@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@RequestMapping(value = "/users/sign-up",method = RequestMethod.POST)
	public String createUser(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    return userService.createUser(user);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/users/getUser")	
	public String getUser(  @RequestHeader("Authorization") String accessToken ) {
		return "welcome user";		
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/users/getAllUsers")	
	public ResponseEntity< List<ApplicationUser> > getAllUsers( @RequestHeader("Authorization") String accessToken ) {
		List<ApplicationUser> appUsersList = userService.getAllUsers();
		return new ResponseEntity< List<ApplicationUser> >(appUsersList,HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST) 
	public String login(@RequestBody ApplicationUser user) throws ServletException {		
		String jwtToken = "";
		if(user.getUsername() == null || user.getPassword() == null)
		{
			throw new ServletException("Please fill in username and password");
		}
		String username = user.getUsername();
		String password = user.getPassword();
		
		ApplicationUser applicationUser =  userRepository.findByUsername(username);
		if(applicationUser == null) {
			throw new ServletException("User not found.");
		}
		String pwd = applicationUser.getPassword();
		if(!bCryptPasswordEncoder.matches(password, pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}
		jwtToken = Jwts.builder()
                .setSubject(username).setSubject(applicationUser.getRole().toString())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();
		return "token is:"+jwtToken;
	}
}
