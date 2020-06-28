
package com.nike.app.planner.boot.data.service;

import com.nike.app.planner.boot.data.entity.UserProfile;

public interface UserService {

	UserProfile readUserProfileByUserName(String username);
	UserProfile readUserProfileById(int id);
}
