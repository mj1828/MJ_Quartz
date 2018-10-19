package com.mj.service;

import java.util.List;

import com.mj.entity.ScheduleJob;

/**
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年10月19日
 */
public interface QuartzJobService {

	/**  
	 * @Method: createQuartzJob  
	 * @Description: 创建job
	 * @param: @param job
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */
	public ScheduleJob createQuartzJob(ScheduleJob job);

	/**  
	 * @Method: modifyQuartzJob  
	 * @Description: 修改job
	 * @param: @param job
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */
	public ScheduleJob modifyQuartzJob(ScheduleJob job);

	/**  
	 * @Method: pauseAllQuartzJob  
	 * @Description: 暂停所有job
	 * @param: 
	 * @return: void
	 * @throws  
	 */
	public void pauseAllQuartzJob();

	/**  
	 * @Method: pauseQuartzJob  
	 * @Description: 暂停某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */
	public void pauseQuartzJob(ScheduleJob quartzJob);

	/**  
	 * @Method: resumeAllQuartzJob  
	 * @Description: 恢复所有job
	 * @param: 
	 * @return: void
	 * @throws  
	 */
	public void resumeAllQuartzJob();

	/**  
	 * @Method: resumeQuartzJob  
	 * @Description: 恢复某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */
	public void resumeQuartzJob(ScheduleJob quartzJob);

	/**  
	 * @Method: deleteQuartzJob  
	 * @Description: 删除某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */
	public void deleteQuartzJob(ScheduleJob quartzJob);

	/**  
	 * @Method: findQuartzJobById  
	 * @Description:  查询job
	 * @param: @param jodId
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */
	public ScheduleJob findQuartzJobById(Integer jodId);

	/**  
	 * @Method: findQuartzJobByStatus  
	 * @Description: 根据状态查找job
	 * @param: @param jobStatus
	 * @param: @return
	 * @return: List<QuartzJob>
	 * @throws  
	 */
	public List<ScheduleJob> findQuartzJobByStatus(String jobStatus);

}
