package com.example.pollDemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfo {

	private long userId;
	private String name;
	private String surname;
	private String intro;
	private String username;
	private String photo;
	public UserInfo(long userId, String name, String surname, String intro, String username,  String photo) {
	
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.intro = intro;
		this.username = username;
	
		this.photo = photo;
	}
	
	
	
	
	
}
