
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PT_USER_ROLE_PERMISSION_TAB")
public class RolePermission implements Serializable {

	private static final long serialVersionUID = -3866187104177981747L;

	private int userRolePermissionId = 0;
	private String permission = null;

	public RolePermission() {
		
	}

	public String toString() {
		return "{userRolePermissionId = " + userRolePermissionId + ", permission = " + permission + "}";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ROLE_PERMISSION_ID")
	public int getUserRolePermissionId() {
		return userRolePermissionId;
	}

	public void setUserRolePermissionId(int userRolePermissionId) {
		this.userRolePermissionId = userRolePermissionId;
	}

	@Column(name="PERMISSION")
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}