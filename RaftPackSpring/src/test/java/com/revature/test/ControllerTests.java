package com.revature.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

@Component
public class ControllerTests {
	
	@Autowired
	private static UserService userService;
	
	@BeforeClass
	public static void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ac.getBean(UserService.class);
		User me  = new User("Demarques", "Glass", "cortez.glass@yahoo.com" , "123", "male", "1994-10-19");	
		userService.registerUser(me);
	}
	

	//This is a test of the userService findUserBy Id and Email methods
	//The two methods should return the same user object
	@Test
	public void test1() {
	assertEquals(userService.findUser(1).getuser_email(), "cortez.glass@yahoo.com");
	
		
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
