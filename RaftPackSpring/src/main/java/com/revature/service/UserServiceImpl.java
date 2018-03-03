package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;
import com.revature.repository.UserRepository;
import com.revature.test.ControllerTests;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	


	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		
	logger.info("UserServiceImpl constructor is being injected with userRepository dependency");
	
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		
		logger.info("Gathering all users");
		
		return userRepository.findAll();
	}

	@Override
	public void registerUser(User user) {

		logger.info("registering user: " + user);
		
		user.setuser_password(securePassword(user.getuser_password()));
		userRepository.create(user);
		
		logger.info("User registered");

	}

	@Override
	public User findUser(String email) {
		
		logger.info("Searching for user with email: " + email);
		return userRepository.findByUserEmail(email);
	}

	@Override
	public User findUser(int userId) {

		logger.info("Searching for user with id: " + userId);
		User u = userRepository.findByUserId(userId);
	
		logger.info("User with id " + userId + " is " + u);
		
		return u;
	}

	private String securePassword(String password) {
		
		logger.info("Hashing password");
		
		String hash = password;
		// TODO: do some algorithm to hash password
		return hash;
	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		logger.info("Validating user: " + user);
		
		User temp = userRepository.findByUserEmail(user.getuser_email());
//		System.out.println("Temp: " + temp);
		if(user.getuser_password().equals(securePassword(temp.getuser_password()))) {
//			System.out.println("Temp password: " + temp.getuser_password());
			return temp;
		}
		return user;
	}
	
	@Override
	public List<Post> getPosts(int userId){
		
		logger.info("Getting user posts with id: " + userId);
		
		return userRepository.findPostByUserId(userId);
	}

	@Override
	public User updateUser(User user) {
		
		logger.info("Updating user: " + user);
		
		userRepository.update(user);
		
		return userRepository.findByUserId(user.getUserId());
		
	}
}
