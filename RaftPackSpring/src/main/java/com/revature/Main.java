package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class Main {
	
	public static ApplicationContext appContext= new ClassPathXmlApplicationContext("applicationContext.xml");

	public static void main(String[] args) {
		
		
		UserServiceImpl usl = appContext.getBean("userService", UserServiceImpl.class);
		
		User me  = new User("Demarques", "Glass", "cortez.glass@yahoo.com" , "123", "male", "1994-10-19");		

		System.out.println(me);
		
		usl.registerUser(me);
//		System.out.println(up.findByUserEmail("cortez.glass@yahoo.com").getfirst_name());
	}

}
