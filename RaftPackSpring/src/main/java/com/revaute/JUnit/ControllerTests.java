package com.revaute.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class ControllerTests {
	
	@Autowired
	private UserService userService = new UserServiceImpl();
	

	//This is a test of the userService findUserBy Id and Email methods
	//The two methods should return the same user object
	@Test
	public void test1() {
	assertEquals(userService.findUser(1), userService.findUser("cortez.glass@yahoo.com"));
	
		
	//System.out.println(userService.findUser(0));
	
	}
	
	
	@Test
	public void test2() {
	assertEquals(userService.findUser("cortez.glass@yahoo.com").getuser_email(), "cortez.glass@yahoo.com");
	
		
	//System.out.println(userService.findUser(0));
	
	}
	
	
	//Test of getting a user by id and retrieving that user id
	@Test
	public void test3() {
	assertEquals(userService.findUser(1).getUserId(), 1);
	
		
	//System.out.println(userService.findUser(0));
	
	}
	

//	@Test
//	public void test4() {
//	assertEquals(userService.findUsersByFirstName("Demarques"), 1);
//	
//		
//	//System.out.println(userService.findUser(0));
//	
//	}
	
	

}
