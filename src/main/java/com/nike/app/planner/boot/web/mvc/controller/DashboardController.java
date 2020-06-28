
package com.nike.app.planner.boot.web.mvc.controller;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.util.log.SimpleLogger;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean = null;

	@RequestMapping(value="/user/home", method=RequestMethod.GET)
	public String redirectUserDashboardHome() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "start to load home page (dashboard) ...");
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		try {
			System.out.println("++++++++++++++++++++++++++++" + scheduler.getJobDetail(JobKey.jobKey("jobWithCronTriggerBean")));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return WebAppConstant.USER_DASHBOARD_HOME_PAGE;
	}
}