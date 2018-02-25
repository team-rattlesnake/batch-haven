package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.Profile;

@Repository("profileRepository")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileRepositoryImpl implements ProfileRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Profile profile) {
		sessionFactory.getCurrentSession().save(profile);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Profile.class).list();
	}

	@Override
	public Profile findByProfileId(int profileId) {
		try {
			return (Profile) sessionFactory.getCurrentSession().createCriteria(Profile.class)
					.add(Restrictions.like("profileId", profileId))
					.list()
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> findByProfileImage(String profileImage) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(Profile.class)
					.add(Restrictions.like("profileImage", profileImage))
					.list();
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void update(Profile profile) {
		sessionFactory.getCurrentSession().update(profile);
	}

	@Override
	public void delete(Profile profile) {
		sessionFactory.getCurrentSession().delete(profile);
	}

}
