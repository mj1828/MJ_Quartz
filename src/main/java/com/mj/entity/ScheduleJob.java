package com.mj.entity;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 任务id */
	private Integer jobId;
	/** 任务名称 */
	private String jobName;
	/** 任务分组，任务名称+组名称应该是唯一的 */
	private String jobGroup;
	/** 任务初始状态 0禁用 1启用 2删除 */
	private Integer jobStatus;
	/** 任务是否有状态（并发与否） */
	private String isConcurrent;
	/** 任务运行时间表达式 */
	private String cronExpression;
	/** 任务描述 */
	private String description;
	/** 任务调用类在spring中注册的bean id，如果spingId不为空，则按springId查找 */
	private String springId;
	/** 任务调用类名，包名+类名，通过类反射调用 ，如果spingId为空，则按jobClass查找 */
	private String jobClass;
	/** 任务调用的方法名 */
	private String methodName;
	/** 启动时间 */
	private Date startTime;
	/** 前一次运行时间 */
	private Date previousTime;
	/** 下次运行时间 */
	private Date nextTime;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getIsConcurrent() {
		return isConcurrent;
	}

	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpringId() {
		return springId;
	}

	public void setSpringId(String springId) {
		this.springId = springId;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getPreviousTime() {
		return previousTime;
	}

	public void setPreviousTime(Date previousTime) {
		this.previousTime = previousTime;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}
}