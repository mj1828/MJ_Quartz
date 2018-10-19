package com.mj.entity;

import java.io.Serializable;

public class CScheduleTrigger implements Serializable {

	private static final long serialVersionUID = 607415834012939242L;

	/** 任务id */
	private Integer jobId;

	/** 任务名称 */
	private String jobName;

	/** 任务分组，任务名称+组名称应该是唯一的 */
	private String jobGroup;

	/** 任务初始状态 0禁用 1启用 2删除 */
	private String jobStatus;

	/** 任务是否有状态（并发与否） */
	private String isConcurrent = "1";

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
	private String startTime;

	/** 前一次运行时间 */
	private String previousTime;

	/** 下次运行时间 */
	private String nextTime;

	public CScheduleTrigger() {
		super();
	}

	public CScheduleTrigger(String jobName, String jobGroup) {
		super();
		this.jobName = jobName;
		this.jobGroup = jobGroup;
	}

	public CScheduleTrigger(String jobName, String jobGroup, String jobStatus, String isConcurrent,
			String cronExpression, String description, String springId, String jobClass, String methodName) {
		super();
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.jobStatus = jobStatus;
		this.isConcurrent = isConcurrent;
		this.cronExpression = cronExpression;
		this.description = description;
		this.springId = springId;
		this.jobClass = jobClass;
		this.methodName = methodName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(120);
		sb.append("QuartzJobBean [jobId=").append(jobId).append(", jobName=").append(jobName).append(", jobGroup=")
				.append(jobGroup).append(", jobStatus=").append(jobStatus).append(", isConcurrent=")
				.append(isConcurrent).append(", cronExpression=").append(cronExpression).append(", jobClass=")
				.append(jobClass).append(", methodName=").append(methodName).append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + jobName.hashCode();
		hash = 31 * hash + jobGroup.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || (obj.getClass() != this.getClass())) {
			return false;
		}
		CScheduleTrigger oBean = (CScheduleTrigger) obj;
		if (this.jobName.equals(oBean.jobName) && this.jobGroup.equals(oBean.jobGroup)) {
			return true;
		}
		return false;
	}

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

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getPreviousTime() {
		return previousTime;
	}

	public void setPreviousTime(String previousTime) {
		this.previousTime = previousTime;
	}

	public String getNextTime() {
		return nextTime;
	}

	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}

}
