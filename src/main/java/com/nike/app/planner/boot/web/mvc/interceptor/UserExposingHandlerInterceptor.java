
package com.nike.app.planner.boot.web.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nike.app.planner.boot.data.entity.UserProfile;
import com.nike.app.planner.boot.data.service.UserService;
import com.nike.app.planner.boot.util.log.SimpleLogger;

public class UserExposingHandlerInterceptor implements HandlerInterceptor {

	private UserService userService = null;

	public UserExposingHandlerInterceptor(UserService userService) {
		this.userService = userService;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final Integer curUserId = (Integer)SecurityUtils.getSubject().getPrincipal();
		if (null != curUserId) {
			UserProfile user = userService.readUserProfileById(curUserId.intValue());
			SimpleLogger.log(SimpleLogger.DEBUG, this.getClass(), "User [" + user.getUserName() + "] is requesting for URL of " + request.getContextPath() + " ...");
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}