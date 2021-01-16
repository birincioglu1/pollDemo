package com.example.pollDemo.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pollDemo.business.IUserService;

import com.example.pollDemo.entity.User;
import com.example.pollDemo.model.UserInfo;



@RequestMapping("/rest/user")
@RestController
public class UserController {

	private IUserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	public UserController(IUserService userService, 
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userService = userService;
	
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
    }

	
	
	
	
	@GetMapping("/all")
	public List<User> hello()
	{
		return userService.getAll();
	}
	
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello()
	{
		return "Secured Hello";
	}
	
	@GetMapping("/addCustom")
	public String addCustom()
	{
		userService.customAdd();
		return "Secured Hello";
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable long userId)
	{
		return userService.userFindById(userId);
	}
	
	@PostMapping("/delete/{userId}")
	public  void deleteUser(@PathVariable long userId)
	{
		 userService.delete(userId);
		 
	}
	@PostMapping("/update")
	public  void updateUser(@RequestBody User user)
	{
		 userService.update(user);
		 
	}
	
	@PostMapping("/add")
	public  void addUser(@RequestBody User user)
	{
		 userService.add(user);		 
	}
	
	@GetMapping("/info/{userId}")
	public UserInfo getUserInfoById(@PathVariable long userId)
	{
		return userService.findUserInfoById(userId);
	}
	
	
	
}
