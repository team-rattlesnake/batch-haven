package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Post;

@Repository("postRepository")
@Transactional
public class PostRepositoryImpl implements PostRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Post post) {
		sessionFactory.getCurrentSession().save(post);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Post.class).list();
	}

	@Override
	public Post findByPostId(int postId) {
		return (Post) sessionFactory.getCurrentSession().get(Post.class, postId);
	}

	@Override
	public void update(Post post) {
		sessionFactory.getCurrentSession().update(post);
	}

	@Override
	public void delete(Post post) {
		sessionFactory.getCurrentSession().delete(post);
	}

}
