package online.flussibancari.user.service;

import java.util.List;

import online.flussibancari.user.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
