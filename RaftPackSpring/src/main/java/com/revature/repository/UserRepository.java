package com.revature.repository;

import java.util.List;

import com.revature.model.Post;
import com.revature.model.User;

public interface UserRepository {
	
	void create(User user);
	List<User> findAll();
	User findByUserId(int userId);
	User findByUserEmail(String user_email);
	List<User> findByFirstName(String first_name);
	List<User> findByLastName(String last_name);
	List<User> findByDoB(String date_of_birth);
	List<User> findByGender(String gender);
	void update(User user);
	void delete(User user);
	List<Post> findPostByUserId(int userId);

}
