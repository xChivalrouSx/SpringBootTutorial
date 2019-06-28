package com.chivalrous.app.ws.springbootappwstutorial.ui.model;

import javax.validation.constraints.NotNull;

public class UpdateUserDetails {

	@NotNull(message = "First name cannot e null")
	private String firstName;

	@NotNull(message = "Last name cannot e null")
	private String lastName;

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

}
