package com.revature;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);

static UserRepository up  = new UserRepositoryImpl();
	public static void main(String[] args) {
		
		logger.info("Starting the main class");
		
		UserServiceImpl usl = new UserServiceImpl(up);
		

		User m  = new User("Marcus", "Glass", "cortez.glass@yahoo.com" , "123", "male", "1994-10-19");		

		
		logger.info(m);

		
		usl.registerUser(m);
		
		logger.info("user registered");
	}

}
