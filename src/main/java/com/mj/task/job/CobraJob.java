package com.mj.task.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CobraJob implements Job{
	private Logger log = LoggerFactory.getLogger(CobraJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("定时job:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
