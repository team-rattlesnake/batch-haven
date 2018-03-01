package com.revature;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class Main {
static UserRepository up  = new UserRepositoryImpl();
	public static void main(String[] args) {
		
		UserServiceImpl usl = new UserServiceImpl(up);
		
		User me  = new User("Demarques", "Glass", "cortez.glass@yahoo.com" , "123", "male", "1994-10-19");		

		System.out.println(me);
		
		usl.registerUser(me);
//		System.out.println(up.findByUserEmail("cortez.glass@yahoo.com").getfirst_name());
	}

}
