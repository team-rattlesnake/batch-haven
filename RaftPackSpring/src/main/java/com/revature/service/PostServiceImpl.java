package com.revature.service;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;

@Service("postService")
public class PostServiceImpl implements PostService {
	
	final static Logger logger = Logger.getLogger(PostServiceImpl.class);


	@Autowired
	PostRepository pr;

	public void createPost(Post post) {
		
		logger.info("Creating new post");
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		post.setDate(sqlDate);
		pr.create(post);
		
		logger.info("Post Created");
	}

	@Override
	public List<Post> getAllPosts() {
		
		logger.info("Retrieving all posts");
		
		return pr.findAll();

	}

	@Override
	public Post updatePost(Post post) {
		
		logger.info("Updating post");
		
		pr.update(post);
		
		logger.info("Post updated...");
		return pr.findByPostId(post.getPostId());
	}

}
