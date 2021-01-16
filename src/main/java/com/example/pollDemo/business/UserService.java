package com.example.pollDemo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.pollDemo.dataAccess.IUserDal;
import com.example.pollDemo.entity.User;

import com.example.pollDemo.model.UserInfo;


@Service
public class UserService implements IUserService{
	 
	private IUserDal userDal;
	
	@Autowired
	public UserService(IUserDal userDal) {
		this.userDal = userDal;
	}

	@Override
	public List<User> getAll() {
		return userDal.getAll();
	}

	@Override
	public void add(User user) {
		this.userDal.add(user);
		
	}

	@Override
	public void delete(long userId) {
		this.userDal.delete(userId);
		
	}

	@Override
	public void update(User user) {
		//tektek update etme metotları yaz
		   this.userDal.update(user);
		
	}

	@Override
	public User userFindById(long userId) {
		return userDal.userFindById(userId);
	}

	@Override
	public UserInfo findUserInfoById(long userId) {
		return this.userDal.findUserInfoById(userId);
	}

	@Override
	public void customAdd() {
		userDal.addCustom();
		
	}
	
	

	


}
