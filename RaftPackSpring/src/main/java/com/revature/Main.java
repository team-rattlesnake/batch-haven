package com.revature;

import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class Main {
static UserRepository up  = new UserRepositoryImpl();
	public static void main(String[] args) {
		UserServiceImpl usl = new UserServiceImpl(up);
		System.out.println(up.findByUserEmail("mnguyen5081@gmail.com").getFirstName());
	}

}
