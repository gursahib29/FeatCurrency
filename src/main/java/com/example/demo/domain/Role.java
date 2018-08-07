package com.example.demo.domain;

public enum Role {
	ADMIN("ADMIN"),
	USER("User");
	
	public String value;
	
	private Role(String value) {
		this.value = value;
	}
}
