package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Profile;
import com.revature.model.User;
import com.revature.service.ProfileServiceImpl;

@Controller("profileController")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
	
	//tomcat admin port 8005. ajp 8009
	//tomcat dev port 8090

	@Autowired
	private ProfileServiceImpl profileService;
	
	@PostMapping("/getProfile.app")
	public @ResponseBody ResponseEntity<Profile> getProfile(@RequestBody User user){
		return new ResponseEntity<>(profileService.findProfile(user),HttpStatus.OK);
	}
}
