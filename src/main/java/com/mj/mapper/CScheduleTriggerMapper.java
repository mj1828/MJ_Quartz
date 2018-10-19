package com.mj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mj.entity.CScheduleTrigger;

@Mapper
public interface CScheduleTriggerMapper {
	/**
	 * 创建任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void createQuartzJob(CScheduleTrigger job);

	/**
	 * 修改任务
	 * @Description:   
	 * @return: CScheduleTrigger      
	 * @throws
	 */
	public CScheduleTrigger modifyQuartzJob(CScheduleTrigger job);

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
	public void pauseQuartzJob(CScheduleTrigger quartzJob);

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
	public void resumeQuartzJob(CScheduleTrigger quartzJob);

	/**
	 * 删除某个任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public void deleteQuartzJob(CScheduleTrigger quartzJob);

	/**
	 * 根据ID查找任务
	 * @Description:   
	 * @return: CScheduleTrigger      
	 * @throws
	 */
	public CScheduleTrigger findQuartzJobById(Integer jodId);

	/**
	 * 根据状态获取任务列表
	 * @Description:   
	 * @return: List<CScheduleTrigger>      
	 * @throws
	 */
	public List<CScheduleTrigger> findQuartzJobByStatus(String jobStatus);

	/**
	 * 根据key获取任务列表
	 * @Description:   
	 * @return: List<CScheduleTrigger>      
	 * @throws
	 */
	public List<CScheduleTrigger> findQuartzJobByKey(String jobName, String jobGroup);

	/**
	 * 根据key更新任务
	 * @Description:   
	 * @return: List<CScheduleTrigger>      
	 * @throws
	 */
	public void updateQuartzJobByKey(CScheduleTrigger quartzJob);

}