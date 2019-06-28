package com.chivalrous.app.ws.springbootappwstutorial.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetails {

	@NotNull(message = "First name cannot e null")
	private String firstName;

	@NotNull(message = "Last name cannot e null")
	private String lastName;

	@Email
	@NotNull(message = "Email cannot e null")
	private String email;

	@NotNull(message = "Password cannot e null")
	@Size(min = 8, max = 16, message = "Password must be greater than 8 characters")
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
