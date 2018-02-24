package com.revature.repository;

import java.util.List;

import com.revature.model.Profile;

public interface ProfileRepository {
	void create(Profile profile);
	List<Profile> findAll();
	Profile findByProfileId(int profileId);
	List<Profile> findByProfileImage(String profileImage);
	void update(Profile profile);
	void delete(Profile profile);
}
