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
//import com.revature.service.ModifyuserService;
import com.revature.model.User;

/*@Controller("modifyUserController")
@CrossOrigin(origins = "http://localhost:4200")// This have no time to validate
public class ModifyUserController {
	@Autowired
	private ModifyuserService moduserService;
	
	//@RequestMapping(value="/registerHero.app", method=RequestMethod.POST)
	@PostMapping("/modifyUser.app")
	public @ResponseBody ResponseEntity<Message> modifyUser(@RequestBody User moduser) {
		moduserService.modifyUser(moduser);
		return new ResponseEntity<>(new Message("USER MODIFIED SUCCESSFULLY..."), HttpStatus.OK);
	}
}*/
