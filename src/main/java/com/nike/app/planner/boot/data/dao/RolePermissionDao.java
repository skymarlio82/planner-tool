
package com.nike.app.planner.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nike.app.planner.boot.data.entity.RolePermission;

@Repository("rolePermissionDao")
public interface RolePermissionDao extends JpaRepository<RolePermission, Integer> {

	@Query("from RolePermission rp order by rp.userRolePermissionId")
	List<RolePermission> findAll();
}