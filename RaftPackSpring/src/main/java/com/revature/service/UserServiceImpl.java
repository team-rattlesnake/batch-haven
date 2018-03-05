package com.revature.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.repository.PostRepositoryImpl;
import com.revature.repository.UserRepositoryImpl;
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
	private UserRepositoryImpl userRepository;
	
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
	public UserServiceImpl(UserRepositoryImpl userRepository) {
		
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
		
		String salt = "salt";
		String generatedPassword = password;
	    try {
	    	MessageDigest md = MessageDigest.getInstance("SHA-1");
	    	md.update(salt.getBytes("UTF-8"));
	    	byte[] bytes = md.digest(password.getBytes("UTF-8"));
	    	StringBuilder sb = new StringBuilder();
	    	for(int i=0; i< bytes.length ;i++) {
	    		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    	}
	    	generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return generatedPassword;
	}

	/* (non-Javadoc)
	 * @see com.revature.service.UserService#validateUser(com.revature.model.User)
	 */
	@Override
	public User validateUser(User user) {
		logger.info("Validating user: " + user);
		
		User temp = userRepository.findByUserEmail(user.getuser_email());
//		System.out.println("Temp: " + temp);
		if(temp.getuser_password().equals(securePassword(user.getuser_password()))) {
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

	@Override 
	public String forgotPassword(String email) {
		
		logger.info("Resetting password: " + email);
		
		User current = userRepository.findByUserEmail(email);
		
		if (current != null) {
			String newPass = "qwe123abc";
			if (emailPassword(email, newPass)) {
				current.setuser_password(securePassword(newPass));
				userRepository.update(current);
				return "Success!";
			}
			else {
				return "Not an email!";
			}
		}
		return "Not a user!";
	}
	
	@Autowired
    public JavaMailSender emailSender;
	
	private boolean emailPassword(String email, String newPass) {
		try {
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(email); 
	        message.setSubject("Password Reset"); 
	        message.setText("Here is your new password: " + newPass + " .\nMake sure to reset it after logging in again.");
	        emailSender.send(message);	        
	        return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
