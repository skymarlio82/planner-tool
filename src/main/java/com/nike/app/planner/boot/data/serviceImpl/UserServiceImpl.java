
package com.nike.app.planner.boot.data.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nike.app.planner.boot.data.dao.UserProfileDao;
import com.nike.app.planner.boot.data.entity.UserProfile;
import com.nike.app.planner.boot.data.service.UserService;
import com.nike.app.planner.boot.util.log.SimpleLogger;

@CacheConfig(cacheNames="userServiceCache")
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserProfileDao userProfileDao = null;

	@Cacheable
	@Transactional(readOnly=true)
	public UserProfile readUserProfileByUserName(String username) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readUserProfileByUserName : username = " + username);
		UserProfile user = userProfileDao.findByUserName(username);
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readUserProfileByUserName : user = " + user);
		return user;
	}

	@Cacheable
	@Transactional(readOnly=true)
	public UserProfile readUserProfileById(int id) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readUserProfileById : id = " + id);
		UserProfile user = userProfileDao.findOne(id);
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readUserProfileById : user = " + user);
		return user;
	}
}