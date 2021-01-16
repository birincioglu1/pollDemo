package com.example.pollDemo.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.pollDemo.config.CustomUserDetails;
import com.example.pollDemo.entity.User;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomUserService customUserService;
	
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=customUserService.findByUsername(username);
		
		return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
		
	}

}
