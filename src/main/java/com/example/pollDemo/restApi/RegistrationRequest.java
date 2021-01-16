package com.example.pollDemo.restApi;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RegistrationRequest {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;

}
