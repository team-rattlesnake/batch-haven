package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Profile;
import com.revature.model.User;
import com.revature.repository.ProfileRepository;

@Service("ProfileService")
public class ProfileServiceImpl   {

	@Autowired
	private ProfileRepository profileRepository;
	
	public ProfileServiceImpl(ProfileRepository profileRepository) {
		System.out.println("Constructor Injection.");
		this.profileRepository = profileRepository;
	}

	//@Override
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	//@Override
	public Profile findProfile(User user) {
		return profileRepository.findByProfileId(user.getUserId());
	}
}
