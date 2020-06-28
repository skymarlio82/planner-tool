
package com.nike.app.planner.boot.web.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.data.service.AssortmentService;
import com.nike.app.planner.boot.util.log.SimpleLogger;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/assortment")
public class AssortmentController {

	@Autowired
	private AssortmentService assortmentService = null;

	@RequestMapping(value="/template/home", method=RequestMethod.GET)
	@RequiresPermissions("user:view")
	public String redirectAssortmentPlanHome() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "start to load assortment home page ...");
		return WebAppConstant.ASSORTMENT_PLAN_HOME_PAGE;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/rest/api", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@ApiOperation(value="Get all the assortment entities.", notes="Get all the assortment entities.")
	@RequiresPermissions("user:read")
	public <T> Map<String, List<T>> apiOfAssortment() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "try to load all the assortment entities ...");
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		result.put("data", (List<T>)assortmentService.readAllAssortmentDetails());
		result.put("options", (List<T>)(new ArrayList<String>()));
		result.put("files", (List<T>)(new ArrayList<String>()));
		return result;
	}
}