package com.mj.task;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Repository;

import com.mj.entity.CScheduleTrigger;



/**  
 * @ClassName: QuartzJobManager  
 * @Description: QuartzJob 管理器  
 * @author: cobra  
 * @date: 2018年9月28日  
 * @version: v1.0
 */  
@Repository
public class QuartzJobManager {

	public QuartzJobManager() {
		super();
	}

	/** 任务调度工厂 */
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	/**
	 * 添加job
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param jobClass
	 * @param cronExpression
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Date addJob(CScheduleTrigger quartzJob) throws SchedulerException {
		try {
			// 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			// 使用JobBuilder就可以定义job -任务名、任务组、任务执行类
			Class<Job> jobclass = (Class<Job>) Class.forName(quartzJob.getJobClass());
			JobDetail jobDetail = JobBuilder.newJob(jobclass).withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup()).build();
			// 使用TriggerBuilder就可以构建触发器
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup())
					.withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression())).build();
			// 定时任务由定时任务调度器Scheduler进行管理的，执行结果为第一次触发时间
			return scheduler.scheduleJob(jobDetail, trigger);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改job
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param cronExpression
	 * @return
	 */
	public Date modifyJob(CScheduleTrigger quartzJob) throws SchedulerException {
		try {
			// 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getJobName(), quartzJob.getJobGroup());
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return null;
			}
			String oldCornExpression = trigger.getCronExpression();
			if (oldCornExpression.equals(quartzJob.getCronExpression())) {
				return null;
			} else {
				trigger = TriggerBuilder.newTrigger().withIdentity(quartzJob.getJobName(), quartzJob.getJobGroup())
						.withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression())).build();
				return scheduler.rescheduleJob(triggerKey, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void deleteJob(CScheduleTrigger quartzJob)
			throws SchedulerException {
		/** 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的*/
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		// 停止触发器并移除触发器
		TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getJobName(), quartzJob.getJobGroup());
		scheduler.pauseTrigger(triggerKey);
		scheduler.unscheduleJob(triggerKey);
		// 删除任务job
		JobKey jobKey = new JobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
		scheduler.deleteJob(jobKey);
	}

	/**
	 * 暂停所有任务
	 * 
	 * @throws SchedulerException
	 */
	public void pauseAllJob() throws SchedulerException {
		/** 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的*/
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.pauseAll();
	}

	/**
	 * 暂停某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void pauseJob(CScheduleTrigger quartzJob) throws SchedulerException {
		JobKey jobKey = new JobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
		// 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail != null) {
			scheduler.pauseJob(jobKey);
		}
	}

	/**
	 * 恢复所有任务
	 * 
	 * @throws SchedulerException
	 */
	public void resumeAllJob() throws SchedulerException {
		// 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.resumeAll();
	}

	/**
	 * 恢复某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void resumeJob(CScheduleTrigger quartzJob) throws SchedulerException {
		// 定时任务调度器Scheduler，由于使用spring集成了Quartz，所以Scheduler是由SchedulerFactoryBean进行管理的
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = new JobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail != null) {
			scheduler.resumeJob(jobKey);
		}
	}
}
