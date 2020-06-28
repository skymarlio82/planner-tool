
package com.nike.app.planner.boot.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nike.app.planner.boot.data.dao.UserProfileDao;
import com.nike.app.planner.boot.data.entity.RolePermission;
import com.nike.app.planner.boot.data.entity.UserProfile;
import com.nike.app.planner.boot.data.entity.UserRole;

@SuppressWarnings("deprecation")
@Component("simpleRealm")
public class SimpleRealm extends AuthorizingRealm {

	protected UserProfileDao userProfileDao = null;

	@Autowired
	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

	public SimpleRealm() {
		// This name must match the name in the User class's getPrincipals() method
		setName("simpleRealm");
		setCredentialsMatcher(new Md5CredentialsMatcher());
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		UserProfile user = userProfileDao.findByUserName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getUserId(), user.getUserPassword(), getName());
		} else {
			return null;
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Integer userId = (Integer)principals.fromRealm(getName()).iterator().next();
		UserProfile user = userProfileDao.findOne(userId);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (UserRole role : user.getRoles()) {
				info.addRole(role.getRoleName());
				Set<String> perms = new HashSet<String>();
				for (RolePermission permission : role.getPermissions()) {
					perms.add(permission.getPermission());
				}
				info.addStringPermissions(perms);
			}
			return info;
		} else {
			return null;
		}
	}
}