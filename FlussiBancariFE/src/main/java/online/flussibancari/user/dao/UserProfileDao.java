package online.flussibancari.user.dao;

import java.util.List;

import online.flussibancari.user.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
