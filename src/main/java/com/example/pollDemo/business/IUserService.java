package com.example.pollDemo.business;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.pollDemo.entity.User;
import com.example.pollDemo.model.UserInfo;

public interface IUserService {


	List<User> getAll();
	void add(User user);
	void delete(long userId);
	void update(User user);
	User userFindById(long userId);
	UserInfo findUserInfoById(long userId);
	void customAdd();
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
