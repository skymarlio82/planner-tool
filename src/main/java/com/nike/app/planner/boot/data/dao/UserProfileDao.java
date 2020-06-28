
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.UserProfile;

@Repository("userProfileDao")
public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {

	@Query("from UserProfile up order by up.userName")
	List<UserProfile> findAll();
	UserProfile findByUserName(String userName);
}