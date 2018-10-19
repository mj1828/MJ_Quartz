package com.mj.task;

import org.quartz.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mj.code.YesOrNoCode;

public interface BaseJob extends Job {

	Logger log = LoggerFactory.getLogger(BaseJob.class);

	public String getJobName();

	default String getJobGroup() {
		return "mj";
	};

	public Integer getJobStatus();

	default String getIsConcurrent() {
		return YesOrNoCode.YES;
	}

	public String getCronExpression();

	public String getDescription();

	default String getMethodName() {
		return "execute";
	}
}
