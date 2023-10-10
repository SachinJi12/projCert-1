package com.appdeveloper.photoapp.api.user.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message = "first name cannot be null")
	@Size(min=4,max=8, message = "User name should be 4-8 length")
	private String firstName;
	@NotNull(message = "last name cannot be null")
	private String lastName;
	@NotNull(message = "email name cannot be null")
	@Email
	private String email;
	@NotNull(message = "password name cannot be null")
	@Size(min=4,max=8, message = "password should be 4-8 length")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
