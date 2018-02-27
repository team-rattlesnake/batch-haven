package com.revature.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.pojo.ModifyUser;
import com.revature.pojo.Message;
import com.revature.service.ModifyuserService;
import com.revature.model.User;

@Controller("modifyUserController")
@CrossOrigin(origins = "http://localhost:4200")// This have no time to validate
public class ModifyUserController {
	@Autowired
	private ModifyuserService moduserService;
	@Autowired
	private User user;
	
	//@RequestMapping(value="/registerHero.app", method=RequestMethod.POST)
	@PostMapping("/modifyUser.app")
	public @ResponseBody ResponseEntity<Message> registerUser(@RequestBody ModifyUser moduser) {
		user.setUserId(moduser.getUserId());
		user.setfirst_name(moduser.getFirstname());
		user.setlast_name(moduser.getLastname());
		user.setuser_email(moduser.getUseremail());
		user.setGender(moduser.getGender());
		//Have to do biography - forgot that one.

		System.out.println("Sending this now: " + user);
		moduserService.modifyUser(user);
		return new ResponseEntity<>(new Message("USER MODIFIED SUCCESSFULLY..."), HttpStatus.OK);
	}
}
