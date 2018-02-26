package com.revature.service;

import java.util.List;

import com.revature.model.User;

public interface UserService {
	List<User> getAllUsers();
	void registerUser(User user);
	User validateUser(User user);
	User findUser(User user);
	User findUser(String email);
}
