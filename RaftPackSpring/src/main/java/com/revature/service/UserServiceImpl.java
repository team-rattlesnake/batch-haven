package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;
import com.revature.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
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
		user.setuser_password(securePassword(user.getuser_password()));
		userRepository.create(user);
	}

	@Override
	public User findUser(String email) {
		return userRepository.findByUserEmail(email);
	}

	@Override
	public User findUser(int userId) {
		//System.out.println(userId);
		User u = userRepository.findByUserId(userId);
	
		//System.out.println(u);
		return u;
	}

	private String securePassword(String password) {
		String hash = password;
		// TODO: do some algorithm to hash password
		return hash;
	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("User: " + user);
		User temp = userRepository.findByUserEmail(user.getuser_email());
		System.out.println("Temp: " + temp);
		if(user.getuser_password().equals(securePassword(temp.getuser_password()))) {
			System.out.println("Temp password: " + temp.getuser_password());
			return temp;
		}
		return user;
	}
	
	@Override
	public List<Post> getPosts(int userId){
		return userRepository.findPostByUserId(userId);
	}

	@Override
	public User updateUser(User user) {
		userRepository.update(user);
		return userRepository.findByUserId(user.getUserId());
		
	}
}
