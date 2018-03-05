package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	// tomcat admin port 8005. ajp 8009
	// tomcat dev port 8090

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The ps. */
	@Autowired
	private PostService ps;

	/**
	 * Register user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	// @RequestMapping(value="/registerHero.app", method=RequestMethod.POST)
	@PostMapping("/registerUser.app")
	public @ResponseBody ResponseEntity<String> registerUser(@RequestBody User user) {
		System.out.println("Sending this now: " + user);
		userService.registerUser(user);
		return new ResponseEntity<>("USER REGISTERED SUCCESSFULLY...", HttpStatus.OK);
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/getAllUsers.app")
	public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	/**
	 * Gets the user.
	 *
	 * @param email the email
	 * @return the user
	 */
	@GetMapping("/getUserByEmail.app")
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody String email) {
		return new ResponseEntity<>(userService.findUser(email), HttpStatus.OK);
	}
	
	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@PostMapping("/getUser.app")
	public @ResponseBody ResponseEntity<User> getUser(@RequestBody int userId) {
		return new ResponseEntity<>(userService.findUser(userId), HttpStatus.OK);
	}

	/**
	 * Gets the post.
	 *
	 * @param userId the user id
	 * @return the post
	 */
	@PostMapping("/getPosts.app")
	public @ResponseBody ResponseEntity<List<Post>> getPost(@RequestBody int userId) {
		return new ResponseEntity<>(userService.getPosts(userId), HttpStatus.OK);
	}
	
	/**
	 * Gets the users by first name.
	 *
	 * @param firstName the first name
	 * @return the users by first name
	 */
	@RequestMapping(value = "/getUsersByFirstName.app", params = {"firstName"})
    public @ResponseBody ResponseEntity<List<User>> getUsersByFirstName(@RequestParam(value = "firstName") String firstName) {
        return new ResponseEntity<>(userService.findUsersByFirstName(firstName), HttpStatus.OK);
    }
    
    /**
     * Gets the user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    @RequestMapping(value = "/getUserById.app", params = {"userId"})
    public @ResponseBody ResponseEntity<User> getUserById(@RequestParam(value = "userId") int userId ) {
        return new ResponseEntity<>(userService.findUser(userId), HttpStatus.OK);
    }

	/**
	 * Gets the all posts.
	 *
	 * @return the all posts
	 */
	@GetMapping("/getAllPosts.app")
	public @ResponseBody ResponseEntity<List<Post>> getAllPosts() {
		List<Post> post = ps.getAllPosts();
		for(Post string: post ) {
			System.out.println(string);
		}
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	/**
	 * Creates the post.
	 *
	 * @param post the post
	 * @return the response entity
	 */
	@PostMapping("/createPost.app")
	public @ResponseBody ResponseEntity<String> createPost(@RequestBody Post post) {
		ps.createPost(post);
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/login.app")
	public @ResponseBody ResponseEntity<User> login(@RequestBody User user) {
		return new ResponseEntity<>(userService.validateUser(user), HttpStatus.OK);
	}

	/**
	 * Update.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/update.app")
	public @ResponseBody ResponseEntity<User> update(@RequestBody User user) {

		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}
	
	/**
	 * Like post.
	 *
	 * @param req the req
	 * @return the response entity
	 */
	@PostMapping("/likePost")
	public @ResponseBody ResponseEntity<String> likePost(@RequestBody Map<String, Integer> req) {
		System.out.println(req.get("postId") + " " + req.get("userId"));
		ps.likePost(req.get("postId"), req.get("userId"));
		return new ResponseEntity<>("Liked", HttpStatus.OK);
	}
	
	/**
	 * Gets the image.
	 *
	 * @param post the post
	 * @return the image
	 */
	@GetMapping("/getImage.app")
	public @ResponseBody ResponseEntity<String> getImage(@RequestBody Post post){
		return new ResponseEntity<>(ps.getImage(post.getPostId()), HttpStatus.OK);
	}
	
	@PostMapping("/forgot.app")
	public @ResponseBody ResponseEntity<String> forgotPassword(@RequestBody String email) {
		return new ResponseEntity<>(userService.forgotPassword(email.replace('"', ' ').trim()), HttpStatus.OK);
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("rp.do.not.reply@gmail.com");
	    mailSender.setPassword("qwe123abc");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}

}
