package com.revature.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.User;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

@Component
public class ControllerTests {
	
	private static UserRepositoryImpl uri = new UserRepositoryImpl();
	
	@Autowired
	private static UserService userService;
	
	
	@BeforeClass
	public static void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ac.getBean(UserService.class);
		User me  = new User("Demarques", "Glass", "cortez.glass@yahoo.com" , "123", "male", "1994-10-19");
		User user = new User("Demarques", "Grass", "dg@example.com" , "123", "male", "1994-10-19");
		
		userService.registerUser(me);
		userService.registerUser(user);
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
	

	//No two userIds return the same person
	@Test
	public void test4() {

		assertNotSame(userService.findUser(1), userService.findUser(2));
		
		
	}
	
	//Find users that have matching birthdays
	@Test
	public void test5() {

		assertEquals(userService.findUser("dg@example.com").getdate_of_birth(), userService.findUser("cortez.glass@yahoo.com").getdate_of_birth());
		
		
		
	
	}
	
	@Test
	public void test6() {

		assertEquals(userService.findUser("dg@example.com").getfirst_name(), "Demarques");
		
		
		
	
	}
	
	@Test
	public void test7() {

		assertNotEquals(userService.findUser("dg@example.com").getlast_name(), "Glass");
		
		
		
	
	}
	
	

}
