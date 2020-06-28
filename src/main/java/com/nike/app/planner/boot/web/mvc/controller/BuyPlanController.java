
package com.nike.app.planner.boot.web.mvc.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nike.app.planner.boot.common.constant.WebAppConstant;

@Controller
@RequestMapping("/buyplan")
public class BuyPlanController {

	@RequestMapping(value="/t2d/home", method=RequestMethod.GET)
	@RequiresPermissions("suser:view")
	public String redirectBuyPlanT2dHome(Model model) {
		model.addAttribute(WebAppConstant.BUYPLAN_T2D_STEP_ID, 1);
		return WebAppConstant.BUY_PLAN_T2D_HOME_PAGE;
	}

	private String preprocessBuyPlanT2dStepPageLoading(Model model, int stepId) {
		String pageRedirected = null;
		switch (stepId) {
			case 1:
				pageRedirected = WebAppConstant.BUY_PLAN_T2D_HOME_PAGE;
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				pageRedirected = WebAppConstant.BUY_PLAN_T2D_HOME_PAGE;
				break;
		}
		model.addAttribute(WebAppConstant.BUYPLAN_T2D_STEP_ID, stepId);
		return pageRedirected;
	}

	@RequestMapping(value="/t2d/page", method=RequestMethod.GET)
	@RequiresPermissions("suser:view")
	public String redirectBuyPlanT2dPageStep(@RequestParam(required=true, name="stepid") int stepId, Model model) {
		return preprocessBuyPlanT2dStepPageLoading(model, stepId);
	}
}