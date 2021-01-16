package com.example.pollDemo.dataAccess;

import java.util.List;


import com.example.pollDemo.entity.User;

import com.example.pollDemo.model.UserInfo;


public interface IUserDal  {

	List<User> getAll();
	void add(User user);
	void delete(long userId);
	void update(User user);
	User userFindById(long userId);
	UserInfo findUserInfoById(long userId);
	void addCustom();
	
	
}
