package com.example.pollDemo.restApi;

import javax.validation.Valid;

import com.example.pollDemo.business.IUserService;
import com.example.pollDemo.entity.UserContact;
import com.example.pollDemo.entity.UserLocation;
import com.example.pollDemo.model.AuthRequest;
import com.example.pollDemo.model.AuthResponse;
import com.example.pollDemo.model.RegistrationRequest;
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

	private IUserService userService;
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	@PostMapping("/register")
	public RegistrationResponse registerUser(@RequestBody @Valid RegistrationRequest registrationRequest)
	{
		try {

			User user=new  User();
			user.setPassword(registrationRequest.getPassword());
			user.setUsername(registrationRequest.getUsername());

			user.setAge(registrationRequest.getAge());
			user.setStatus(1);
			user.setName(registrationRequest.getName());
			user.setSurname(registrationRequest.getSurname());
			user.setIntro(registrationRequest.getIntro());

			user.setPhoto(registrationRequest.getPhoto());
			user.setGender(registrationRequest.getGender());
			user.setEducation(registrationRequest.getEducation());

			UserLocation userLocation= new UserLocation();
			userLocation.setLatitude(registrationRequest.getLatitude());
			userLocation.setLongitude(registrationRequest.getLongitude());


			UserContact userContact=new UserContact();
			userContact.setType("Email");
			userContact.setValue(registrationRequest.getEmail());
			userContact.setIsValid(false);


			UserContact userContact2=new UserContact();
			userContact2.setType("Phone");
			userContact2.setValue(registrationRequest.getPhone());
			userContact2.setIsValid(false);


			customUserService.saveUserAdress(userLocation);
			user.setUserLocation(userLocation);
			customUserService.saveUser(user);

			userContact.setUser(user);
			userContact2.setUser(user);
			customUserService.saveUserContact(userContact);
			customUserService.saveUserContact(userContact2);
			return new RegistrationResponse(true,"SUCCESS");
		}catch (Exception e)
		{
			return new RegistrationResponse(false,"ERROR");
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
