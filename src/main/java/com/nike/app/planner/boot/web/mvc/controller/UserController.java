
package com.nike.app.planner.boot.web.mvc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.common.model.JsonLogonResult;
import com.nike.app.planner.boot.common.model.JsonReturnResult;
import com.nike.app.planner.boot.data.entity.UserProfile;
import com.nike.app.planner.boot.data.service.UserService;
import com.nike.app.planner.boot.util.image.SimpleCaptcha;
import com.nike.app.planner.boot.util.log.SimpleLogger;
import com.nike.app.planner.boot.web.mvc.bean.form.LoginForm;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService = null;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/default/loginform", method=RequestMethod.GET)
	public String loginForm() {
		return WebAppConstant.USER_LOGIN_FORM_PAGE;
	}

	@RequestMapping(value="/default/logout", method=RequestMethod.GET)
	public String logout() {
		SecurityUtils.getSubject().logout();
		return WebAppConstant.USER_LOGIN_FORM_PAGE;
	}

	@RequestMapping(value="/default/loginform", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonLogonResult loginForUser(@RequestBody @Valid LoginForm loginForm) {
		JsonLogonResult result = new JsonLogonResult(JsonReturnResult.FAILURE);
		List<String> errs = new ArrayList<String>();
		UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUserName(), loginForm.getUserPassword(), loginForm.isRememberMe());
		try {
			Subject currSubject = SecurityUtils.getSubject();
			currSubject.login(token);
			Session session = currSubject.getSession();
			final Integer currentUserId = (Integer)currSubject.getPrincipal();
			UserProfile user = userService.readUserProfileById(currentUserId);
			SimpleLogger.log(SimpleLogger.DEBUG, this.getClass(), "User [" + user.getUserName() + "] is signing up into the system");
			session.setAttribute(WebAppConstant.USER_CONFIG, user);
			return new JsonLogonResult(JsonReturnResult.SUCCESS);
		} catch (AuthenticationException e) {
			errs.add("User login failed.");
			result.setErrors(errs);
		}
		return result;
	}

	@RequestMapping(value="/default/image/captcha", method=RequestMethod.GET)
    public void generateCaptchaImage(HttpServletResponse response, HttpSession session) throws IOException {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "load and change captcha picture ...");
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		String captcha = SimpleCaptcha.output2os(os);
		os.close();
		session.setAttribute(WebAppConstant.CAPTCHA_CODE_IN_SESSION, captcha);
	}
}