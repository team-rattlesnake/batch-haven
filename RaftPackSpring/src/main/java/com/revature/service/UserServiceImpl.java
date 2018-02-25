package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		System.out.println("Constructor Injection.");
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void registerUser(User user) {
		System.out.println("Registering User...");
		System.out.println("User being registered:" + user);
		userRepository.create(user);
	}

	@Override
	public User findUser(User user) {
		return userRepository.findByUserEmail(user.getUserEmail());
	}
}
