
package com.nike.app.planner.boot.schedule.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.nike.app.planner.boot.email.service.SimpleEmailService;
import com.nike.app.planner.boot.schedule.util.QuartzHelper;

//@Component
//@DisallowConcurrentExecution
public class JobWithSimpleTrigger implements Job {

	@Value("${samplejob.simple.frequency}")
    private long frequency = 0L;

	@Autowired
	private SimpleEmailService simpleEmailService = null;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		simpleEmailService.sendMail("jitao.liu82@gmail.com", "jitao.liu82@gmail.com", "Test email's subject from spring-boot", "Test email's content from spring-boot");
		System.out.println(":: Testing email is sent out ...");
	}

	@Bean(name="jobWithSimpleTriggerBean")
	public JobDetailFactoryBean sampleJob1() {
		return QuartzHelper.createJobDetail(this.getClass());
	}

	@Bean(name="jobWithSimpleTriggerBeanTrigger")
	public SimpleTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) {
		return QuartzHelper.createTrigger(jobDetail, frequency);
	}
}