package com.mj.task;

import java.util.List;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mj.entity.CScheduleTrigger;
import com.mj.service.QuartzJobService;

/**
 * @ClassName: QuartzJobRunner
 * @Description: 项目启动执行定时任务的调度
 * @author: cobra
 * @date: 2018年9月28日
 * @version: v1.0
 */
@Component
public class QuartzJobRunner implements ApplicationRunner {

	private Logger log = LoggerFactory.getLogger(QuartzJobRunner.class);

	@Autowired
	private QuartzJobService quartzJobService;

	@Autowired
	private QuartzJobManager quartzJobManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("**********初始化加载定时任务开始**********");
		List<CScheduleTrigger> jobList = quartzJobService.findQuartzJobByStatus(CScheduleTrigger.STATUS_RUNNING);
		if (jobList != null && jobList.size() > 0) {
			jobList.forEach((quartzJob) -> {
				try {
					quartzJobManager.addJob(quartzJob);
				} catch (SchedulerException e) {
					e.printStackTrace();
					log.info("**********初始化加载定时任务异常**********");
				}
			});
			log.info("**********初始化加载定时任务结束**********");
		} else {
			log.info("**********没有加载到定时任务**********");
		}

	}
}
