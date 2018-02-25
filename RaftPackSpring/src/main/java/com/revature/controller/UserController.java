package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.pojo.Message;
import com.revature.service.UserService;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	//tomcat admin port 8005. ajp 8009
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value="/registerHero.app", method=RequestMethod.POST)
	@PostMapping("/registerUser.app")
	public @ResponseBody ResponseEntity<Message> registerUser(@RequestBody User user) {
		System.out.println("Sending: " + user);
		userService.registerUser(user);
		return new ResponseEntity<>(new Message("USER REGISTERED SUCCESSFULLY."), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers.app")
	public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/getUser.app")
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.findUser(user), HttpStatus.OK);
	}
}
