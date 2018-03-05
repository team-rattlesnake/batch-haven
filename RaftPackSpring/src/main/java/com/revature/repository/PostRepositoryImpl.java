package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.Post;

@Repository("postRepository")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class PostRepositoryImpl /*implements PostRepository*/ {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void create(Post post) {
		sessionFactory.getCurrentSession().save(post);
	}

	@SuppressWarnings("unchecked") /* why suppressed */
	public List<Post> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Post.class).list();
	}

	public void update(Post post) {
		sessionFactory.getCurrentSession().update(post);
	}

	public void delete(Post post) {
		sessionFactory.getCurrentSession().delete(post);
	}

	public Post findByPostId(int postId) {
		Post p = (Post)sessionFactory.getCurrentSession().get(Post.class, postId);
		System.out.println(p);
		return p;
	}

}
