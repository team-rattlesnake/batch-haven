package com.revature.repository;

import java.util.List;

import com.revature.model.Post;

public interface PostRepository {
	void create(Post post);
	List<Post> findAll();
	Post findByPostId(int postId);
	void update(Post post);
	void delete(Post post);
}
