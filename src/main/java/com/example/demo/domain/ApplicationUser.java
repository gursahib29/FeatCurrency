package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "User")
public class ApplicationUser {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "fullname")
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private long mobile;
	
	@NotNull
	private String password;
	private String country;
	private String address;
	
	@Enumerated
	Role roles;
	
	public ApplicationUser() {
		
	}

	public ApplicationUser(long id, @NotNull String username, @NotNull String email, @NotNull long mobile,
			@NotNull String password, String country, String address, Role roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.country = country;
		this.address = address;
		this.roles = roles;
	}

	public ApplicationUser(@NotNull String username, @NotNull String password, Role roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return roles;
	}

	public void setRole(Role roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
