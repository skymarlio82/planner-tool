
package com.nike.app.planner.boot.config;

import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.nike.app.planner.boot.schedule.common.AutowiringSpringBeanJobFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Configuration
@ConditionalOnProperty(name="quartz.enabled")
public class QuartzConfig {

	@Autowired
	private List<Trigger> listOfTrigger = null;

	@Value("${qrtz.config.file}")
    private String qrtzConfigFile = null;

	@Bean(name="jobFactory")
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean(name="schedulerFactoryBean")
	public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource, JobFactory jobFactory) throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setOverwriteExistingJobs(true);
		factory.setAutoStartup(true);
		factory.setDataSource(dataSource);
		factory.setJobFactory(jobFactory);
		factory.setQuartzProperties(quartzProperties());
		factory.setTriggers(listOfTrigger.toArray(new Trigger[listOfTrigger.size()]));
		return factory;
	}

	@Bean(name="quartzProperties")
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(qrtzConfigFile));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}
}