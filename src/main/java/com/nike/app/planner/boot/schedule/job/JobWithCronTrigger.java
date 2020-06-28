
package com.nike.app.planner.boot.schedule.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.nike.app.planner.boot.data.entity.UserProfile;
import com.nike.app.planner.boot.data.service.UserService;
import com.nike.app.planner.boot.message.websock.model.UserWebSockMessage;
import com.nike.app.planner.boot.message.websock.model.SimpleWebSockMessage.MessageType;
import com.nike.app.planner.boot.schedule.util.QuartzHelper;

@Component
@DisallowConcurrentExecution
public class JobWithCronTrigger implements Job {

	@Value("${samplejob.cron.frequency}")
	private String frequency;

	@Value("${server.contextPath}")
    private String contextPath = null;

	@Autowired
	private UserService userService = null;

	@Autowired
	private SimpMessageSendingOperations messagingTemplate = null;

	private static int idx = 0;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		if (idx < 3) {
			UserProfile user = userService.readUserProfileById(++idx);
			UserWebSockMessage message = new UserWebSockMessage();
			message.setType(MessageType.SAFE);
			message.setUser(user.getUserName().toUpperCase());
			message.setContent(idx + " new plan records in Step 0" + idx + " had been committed.");
			message.setUserInfo(user);
			message.setImgUrl(contextPath + "/resources/image/avatar_" + user.getUserId() + ".png");
			messagingTemplate.convertAndSend("/topic/public", message);
			idx = idx%3;
		}
	}

	@Bean(name="jobWithCronTriggerBean")
	public JobDetailFactoryBean sampleJob() {
		return QuartzHelper.createJobDetail(this.getClass());
	}

	@Bean(name="jobWithCronTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithCronTriggerBean") JobDetail jobDetail) {
		return QuartzHelper.createCronTrigger(jobDetail, frequency);
	}
}