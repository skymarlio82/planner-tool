
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name="PT_USER_PROFILE_TAB")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 7791433472455728003L;

	private int userId = 0;
	private String userName = null;
	private String userPassword = null;
	private Set<UserRole> roles = new HashSet<UserRole>();

	public UserProfile() {
		
	}

	public String toString() {
		return "userId = " + userId + ", userName = " + userName + ", userPassword = " + userPassword + ", roles = " + roles;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="USER_PASSWORD")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="PT_USER_ROLE_MAPPING_TAB", joinColumns = { @JoinColumn(name="USER_ID", nullable=false, updatable=false) }, inverseJoinColumns = { @JoinColumn(name="USER_ROLE_ID", nullable=false, updatable=false) })
	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}