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

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	


	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Instantiates a new user service impl.
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new user service impl.
	 *
	 * @param userRepository the user repository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		
	logger.info("UserServiceImpl constructor is being injected with userRepository dependency");
	
		this.userRepository = userRepository;
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		
		logger.info("Gathering all users");
		
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#registerUser(com.revature.model.User)
	 */
	@Override
	public void registerUser(User user) {

		logger.info("registering user: " + user);
		
		user.setuser_password(securePassword(user.getuser_password()));
		userRepository.create(user);
		
		logger.info("User registered");

	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String email) {
		
		logger.info("Searching for user with email: " + email);
		return userRepository.findByUserEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#findUser(int)
	 */
	@Override
	public User findUser(int userId) {

		logger.info("Searching for user with id: " + userId);
		User u = userRepository.findByUserId(userId);
	
		logger.info("User with id " + userId + " is " + u);
		
		return u;
	}

	/**
	 * Secure password.
	 *
	 * @param password the password
	 * @return the string
	 */
	private String securePassword(String password) {
		
		logger.info("Hashing password");
		
		String hash = password;
		// TODO: do some algorithm to hash password
		return hash;
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#validateUser(com.revature.model.User)
	 */
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
	
	/* (non-Javadoc)
	 * @see com.revature.service.UserService#getPosts(int)
	 */
	@Override
	public List<Post> getPosts(int userId){
		
		logger.info("Getting user posts with id: " + userId);
		
		return userRepository.findPostByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#updateUser(com.revature.model.User)
	 */
	@Override
	public User updateUser(User user) {
		
		logger.info("Updating user: " + user);
		
		userRepository.update(user);
		
		return userRepository.findByUserId(user.getUserId());
		
	}
	
	/* (non-Javadoc)
	 * @see com.revature.service.UserService#findUsersByFirstName(java.lang.String)
	 */
	@Override
    public List<User> findUsersByFirstName(String first_name) {
        return userRepository.findByFirstName(first_name);
    }
	
}
