
package com.nike.app.planner.boot.web.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nike.app.planner.boot.common.constant.WebAppConstant;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex, Model model) {
		ex.printStackTrace();
		model.addAttribute(WebAppConstant.ERROR_DETAIL, ex.toString());
		return WebAppConstant.GLOBAL_SYSTEM_ERROR_PAGE;
	}

}