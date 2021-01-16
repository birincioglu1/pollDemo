package com.example.pollDemo.business;

import com.example.pollDemo.entity.UserContact;
import com.example.pollDemo.entity.UserLocation;
import com.example.pollDemo.repository.UserContactEntityRepository;
import com.example.pollDemo.repository.UserLocationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pollDemo.entity.Role;
import com.example.pollDemo.entity.User;
import com.example.pollDemo.repository.RoleEntityRepository;
import com.example.pollDemo.repository.UserEntityRepository;

@Service
public class CustomUserService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired
	private UserLocationEntityRepository userLocationEntityRepository;

	@Autowired
	private UserContactEntityRepository userContactEntityRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public User saveUser(User user)
	{
			Role userRole=roleEntityRepository.findByName("ROLE_USER");
			user.setRole(userRole);
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			return	userEntityRepository.save(user);
		
	}
	public UserLocation saveUserAdress(UserLocation userLocation)
	{
		return userLocationEntityRepository.save(userLocation);
	}
	public void saveUserContact(UserContact userContact)
	{
		userContactEntityRepository.save(userContact);
	}



	public User findByUsername(String username)
	{
		return userEntityRepository.findByUsername(username);
	}
	
	public User findByUsernameAndPassword(String username,String password)
	{
		User user=findByUsername(username);
		if(user !=null)
		{
			if(passwordEncoder.matches(password, user.getPassword()))
					{
						return user;
					}
		}
		return null;
	}
}
