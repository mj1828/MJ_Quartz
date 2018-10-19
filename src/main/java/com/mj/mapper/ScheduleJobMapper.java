package com.mj.mapper;

import java.util.List;

import com.mj.entity.ScheduleJob;

public interface ScheduleJobMapper {
	/**
	 * 创建任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void createQuartzJob(ScheduleJob job);

	/**
	 * 修改任务
	 * @Description:   
	 * @return: ScheduleJob      
	 * @throws
	 */
	public ScheduleJob modifyQuartzJob(ScheduleJob job);

	/**
	 * 暂停所有任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void pauseAllQuartzJob();

	/**
	 * 暂停某个任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void pauseQuartzJob(ScheduleJob quartzJob);

	/**
	 * 恢复全部任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void resumeAllQuartzJob();

	/**
	 * 恢复全部任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void resumeQuartzJob(ScheduleJob quartzJob);

	/**
	 * 删除某个任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void deleteQuartzJob(ScheduleJob quartzJob);

	/**
	 * 根据ID查找任务
	 * @Description:   
	 * @return: ScheduleJob      
	 * @throws
	 */
	public ScheduleJob findQuartzJobById(Integer jodId);

	/**
	 * 根据状态获取任务列表
	 * @Description:   
	 * @return: List<ScheduleJob>      
	 * @throws
	 */
	public List<ScheduleJob> findQuartzJobByStatus(String jobStatus);

	/**
	 * 根据key获取任务列表
	 * @Description:   
	 * @return: List<ScheduleJob>      
	 * @throws
	 */
	public List<ScheduleJob> findQuartzJobByKey(String jobName, String jobGroup);

	/**
	 * 根据key更新任务
	 * @Description:   
	 * @return: List<ScheduleJob>      
	 * @throws
	 */
	public void updateQuartzJobByKey(ScheduleJob quartzJob);
}