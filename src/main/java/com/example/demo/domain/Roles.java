package com.example.demo.domain;

public enum Roles {
	ADMIN("Admin"),
	USER("User");
	
	public String value;
	
	private Roles(String value) {
		this.value = value;
	}
}
