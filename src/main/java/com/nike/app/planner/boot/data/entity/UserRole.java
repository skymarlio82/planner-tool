
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PT_USER_ROLE_TAB")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 7994436905276762039L;

	private int userRoleId = 0;
	private String roleName = null;
	private Set<RolePermission> permissions = null;

	public UserRole() {
		
	}

	public String toString() {
		return "{userRoleId = " + userRoleId + ", roleName = " + roleName + ", permissions = " + permissions + "}";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ROLE_ID")
	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="PT_USER_ROLE_PERMISSION_MAPPING_TAB", joinColumns = { @JoinColumn(name="USER_ROLE_ID", nullable=false, updatable=false) }, inverseJoinColumns = { @JoinColumn(name="USER_ROLE_PERMISSION_ID", nullable=false, updatable=false) })
	public Set<RolePermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<RolePermission> permissions) {
		this.permissions = permissions;
	}
}