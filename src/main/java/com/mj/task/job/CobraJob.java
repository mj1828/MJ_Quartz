package com.mj.task.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mj.code.JobStatusCode;
import com.mj.task.BaseJob;

public class CobraJob implements BaseJob {
	private static String ID = "cobrajob";

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("开始定时任务");
	}

	@Override
	public String getJobName() {
		return ID;
	}

	@Override
	public Integer getJobStatus() {
		return JobStatusCode.RUNNING;
	}

	@Override
	public String getCronExpression() {
		return "*/2 * * * * ?";
	}

	@Override
	public String getDescription() {
		return "测试定时任务";
	}

}
