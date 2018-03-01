package com.revature.service;

import java.util.List;

import com.revature.model.Post;
import com.revature.model.User;

public interface UserService {
	List<User> getAllUsers();
	void registerUser(User user);
	User validateUser(User user);
	User findUser(int userId);
	User findUser(String email);
	List<Post> getPosts(int userId);
	User updateUser(User user);
}
