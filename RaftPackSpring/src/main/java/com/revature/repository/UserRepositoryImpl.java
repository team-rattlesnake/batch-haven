package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.User;

@Repository("userRepository")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findByUserId(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User findByUserEmail(String user_email) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("user_email", user_email))
					.list()
					.get(1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByFirstName(String first_name) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("first_name", first_name))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByLastName(String last_name) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("last_name", last_name))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByDoB(String date_of_birth) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("date_of_birth", date_of_birth))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByGender(String gender) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("gender", gender))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
