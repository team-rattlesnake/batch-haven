package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository("userRepository")
@Transactional
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
	public User findByUserEmail(String userEmail) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("userEmail", userEmail))
					.list()
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByFirstName(String firstName) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("firstName", firstName))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByLastName(String lastName) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("lastName", lastName))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByMonthOfBirth(String monthOfBirth) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.like("monthOfBirth", monthOfBirth))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByDayOfBirth(int dayOfBirth) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("dayOfBirth", dayOfBirth))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByYearOfBirth(int yearOfBirth) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("yearOfBirth", yearOfBirth))
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
