package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;

@Service("postService")
public class PostServiceImpl {
	
	@Autowired
	PostRepository pr = new PostRepositoryImpl();

}
