package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository pr = new PostRepositoryImpl();

	public void createPost(Post post) {
		pr.create(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return pr.findAll();

	}

}
