package com.mind.ak47.begin.service;

import java.util.List;

import com.mind.ak47.begin.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
