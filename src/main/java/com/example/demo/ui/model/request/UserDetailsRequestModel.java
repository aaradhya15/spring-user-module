package com.example.demo.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull(message = "FirstNAme cannot be null")
	@Size(min=2, message="FirstName must be greater than 2 chars")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Size(min=2, message=":LastName must be greater than 2 chars")
	private String lastName;
	
	@NotNull(message = "email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "password cannot be null")
	@Size(min=8, max=16, message="Password must be equal to or greater than 8 or less than 16 chars")
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
