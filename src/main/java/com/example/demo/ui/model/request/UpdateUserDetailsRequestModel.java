package com.example.demo.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "FirstNAme cannot be null")
	@Size(min=2, message="FirstName must be greater than 2 chars")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Size(min=2, message=":LastName must be greater than 2 chars")
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
