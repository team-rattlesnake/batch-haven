package com.revature.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository pr;

	public void createPost(Post post) {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		post.setDate(sqlDate);
		pr.create(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return pr.findAll();

	}

	@Override
	public Post updatePost(Post post) {
		pr.update(post);
		return pr.findByPostId(post.getPostId());
	}

}
