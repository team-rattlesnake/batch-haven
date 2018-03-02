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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.pojo.Message;
import com.revature.service.PostService;
import com.revature.service.PostServiceImpl;
import com.revature.service.UserService;

@RestController("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	// tomcat admin port 8005. ajp 8009
	// tomcat dev port 8090

	@Autowired
	private UserService userService;
	@Autowired
	private PostService ps;

	// @RequestMapping(value="/registerHero.app", method=RequestMethod.POST)
	@PostMapping("/registerUser.app")
	public @ResponseBody ResponseEntity<Message> registerUser(@RequestBody User user) {
		System.out.println("Sending this now: " + user);
		userService.registerUser(user);
		return new ResponseEntity<>(new Message("USER REGISTERED SUCCESSFULLY..."), HttpStatus.OK);
	}

	@GetMapping("/getAllUsers.app")
	public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/getUserByEmail.app")
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody String email) {
		return new ResponseEntity<>(userService.findUser(email), HttpStatus.OK);
	}
	
	@PostMapping("/getUser.app")
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody int userId) {
		return new ResponseEntity<>(userService.findUser(userId), HttpStatus.OK);
	}

	@PostMapping("/getPosts.app")
	public @ResponseBody ResponseEntity<List<Post>> getPost(@RequestBody int userId) {
		return new ResponseEntity<>(userService.getPosts(userId), HttpStatus.OK);
	}

	@GetMapping("/getAllPosts.app")
	public @ResponseBody ResponseEntity<List<Post>> getAllPosts() {
		return new ResponseEntity<>(ps.getAllPosts(), HttpStatus.OK);
	}

	@PostMapping("/createPost.app")
	public @ResponseBody ResponseEntity<Message> createPost(@RequestBody Post post) {
		ps.createPost(post);
		return new ResponseEntity<>(new Message("Ok"), HttpStatus.OK);
	}

	@PostMapping("/login.app")
	public @ResponseBody ResponseEntity<User> login(@RequestBody User user) {
		return new ResponseEntity<>(userService.validateUser(user), HttpStatus.OK);
	}

	@PostMapping("/update.app")
	public @ResponseBody ResponseEntity<User> update(@RequestBody User user) {

		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}

}
