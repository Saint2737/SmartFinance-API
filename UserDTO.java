package com.example.demo3A;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	
	@NotBlank(message="please provide a username")
	String username;
	
	@NotBlank(message ="password is mandatory")
	@Size(min=8, message="password must have atleast 8 characters")
	String password;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username =username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
