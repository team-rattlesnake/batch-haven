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
	public User findUser(String email) {
		return userRepository.findByUserEmail(email);
	}

	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("User: " + user);
		User temp = userRepository.findByUserEmail(user.getuser_email());
		//System.out.println("Temp: " + temp);
		if(user.getuser_password().equals(temp.getuser_password())) {
			return temp;
		}
		return user;
	}
	
}
