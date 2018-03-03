package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.repository.PostRepository;
import com.revature.repository.PostRepositoryImpl;
import com.revature.repository.UserRepository;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository pr;
	
	@Autowired
	private UserRepository ur;

	public void createPost(Post post) {
		pr.create(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return pr.findAll();

	}

	@Override
	public void likePost(int postId, int userId) {
		Post post = pr.findByPostId(postId);
		User poster = post.getUser();
		User liker = ur.findByUserId(userId);
		List<User> likers;
		List<Post> likedPosts;
		
		if(post.getLikers() != null) {
			likers = post.getLikers();
			System.out.println();
		} else {
			likers = new ArrayList<>();
		}
		
		if(liker.getLikedPosts() != null) {
			likedPosts = liker.getLikedPosts();
		} else {
			likedPosts = new ArrayList<>();
		}
		
		boolean isUnliked = false;
		for(User u: likers) {
			System.out.println("Likers: " + u);
			if(u.getUserId() == liker.getUserId()) {
				post.setNumOfLikes(post.getNumOfLikes() - 1);
				isUnliked = likers.remove(u);
				post.setLikers(likers);
				break;
			}
		}
		for(Post p: likedPosts) {
			System.out.println("Liked Posts: " + p);
			if(p.getPostId() == post.getPostId()) {
				//post.setNumOfLikes(post.getNumOfLikes() - 1);
				isUnliked = likedPosts.remove(p);
				System.out.println(isUnliked);
				liker.setLikedPosts(likedPosts);
				break;
			}
		}
		if(!isUnliked) {
			post.setNumOfLikes(post.getNumOfLikes() + 1);
			likedPosts.add(post);
			liker.setLikedPosts(likedPosts);
			likers.add(liker);
			post.setLikers(likers);
		}
		for(Post p: poster.getMyPosts()) {
			if(p.getPostId() == post.getPostId()) {
				p = post;
				post.setUser(poster);
				break;
			}
		}
		System.out.println(liker);
		System.out.println(post);
		ur.update(liker);
		pr.update(post);
		
	}

}
