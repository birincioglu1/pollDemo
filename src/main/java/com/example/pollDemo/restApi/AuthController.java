package com.example.pollDemo.restApi;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pollDemo.business.CustomUserService;
import com.example.pollDemo.config.jwt.JwtProvider;
import com.example.pollDemo.entity.User;



@RestController
public class AuthController {

	@Autowired
	private CustomUserService customUserService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	
	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest)
	{
		try {
			User user=new  User();

			user.setPassword(registrationRequest.getPassword());
			user.setUsername(registrationRequest.getUsername());

			customUserService.saveUser(user);
			return "OK";
		}catch (Exception e)
		{
			return "Username is already exist";
		}

		

	}
	
	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request)
	{
		User user=customUserService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		String token=jwtProvider.generateToken(user.getUsername());
		return new AuthResponse(token);
		
	}
}
