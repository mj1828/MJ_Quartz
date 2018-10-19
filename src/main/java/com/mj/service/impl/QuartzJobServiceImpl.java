package com.mj.service.impl;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.ScheduleJob;
import com.mj.mapper.ScheduleJobMapper;
import com.mj.service.QuartzJobService;
import com.mj.task.QuartzJobManager;

/**
 * job操作实现类
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年10月19日
 */
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	private ScheduleJobMapper mapper;

	@Autowired
	private QuartzJobManager quartzJobManager;

	@Override
	public ScheduleJob createQuartzJob(ScheduleJob job) {
		mapper.createQuartzJob(job);
		try {
			quartzJobManager.addJob(job);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public ScheduleJob modifyQuartzJob(ScheduleJob job) {
		mapper.modifyQuartzJob(job);
		try {
			quartzJobManager.modifyJob(job);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public void pauseAllQuartzJob() {
		mapper.pauseAllQuartzJob();
		try {
			quartzJobManager.pauseAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pauseQuartzJob(ScheduleJob quartzJob) {
		mapper.pauseQuartzJob(quartzJob);
		try {
			quartzJobManager.pauseJob(quartzJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resumeAllQuartzJob() {
		mapper.resumeAllQuartzJob();
		try {
			quartzJobManager.resumeAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resumeQuartzJob(ScheduleJob quartzJob) {
		mapper.resumeQuartzJob(quartzJob);
		try {
			quartzJobManager.resumeJob(quartzJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteQuartzJob(ScheduleJob quartzJob) {
		mapper.deleteQuartzJob(quartzJob);
		try {
			quartzJobManager.deleteJob(quartzJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ScheduleJob findQuartzJobById(Integer jodId) {
		return mapper.findQuartzJobById(jodId);
	}

	@Override
	public List<ScheduleJob> findQuartzJobByStatus(String jobStatus) {
		return mapper.findQuartzJobByStatus(jobStatus);
	}

}
