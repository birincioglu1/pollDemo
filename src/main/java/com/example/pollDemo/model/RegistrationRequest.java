package com.example.pollDemo.model;

import javax.validation.constraints.NotEmpty;

import com.example.pollDemo.entity.Role;
import lombok.Data;

@Data
public class RegistrationRequest {

	@NotEmpty
	private String username;
	@NotEmpty
	private String password;


	private String name;
	private String surname;
	private String intro;
	private String photo;
	private String gender;
	private int age;
	private String education;
	private String job;
	private String phone;
	private String email;
	private String latitude;
	private String longitude;



}
