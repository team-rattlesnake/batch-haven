package com.revature.service;

import java.util.List;

import com.revature.model.Post;

public interface PostService {
public void createPost(Post post);
public List<Post> getAllPosts();
public Post updatePost(Post post);
}
