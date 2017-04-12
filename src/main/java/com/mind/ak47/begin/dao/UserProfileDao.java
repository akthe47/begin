package com.mind.ak47.begin.dao;

import java.util.List;

import com.mind.ak47.begin.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
