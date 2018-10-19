package com.mj.service.impl;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CScheduleTrigger;
import com.mj.mapper.CScheduleTriggerMapper;
import com.mj.service.QuartzJobService;
import com.mj.task.QuartzJobManager;

/**
 * @ClassName: QuartzJobServiceImpl
 * @Description: job操作实现类
 * @author: cobra
 * @date: 2018年9月28日
 * @version: v1.0
 */
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	private CScheduleTriggerMapper mapper;

	@Autowired
	private QuartzJobManager quartzJobManager;

	@Override
	public CScheduleTrigger createQuartzJob(CScheduleTrigger job) {
		mapper.createQuartzJob(job);
		try {
			quartzJobManager.addJob(job);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public CScheduleTrigger modifyQuartzJob(CScheduleTrigger job) {
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
	public void pauseQuartzJob(CScheduleTrigger quartzJob) {
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
	public void resumeQuartzJob(CScheduleTrigger quartzJob) {
		mapper.resumeQuartzJob(quartzJob);
		try {
			quartzJobManager.resumeJob(quartzJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteQuartzJob(CScheduleTrigger quartzJob) {
		mapper.deleteQuartzJob(quartzJob);
		try {
			quartzJobManager.deleteJob(quartzJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CScheduleTrigger findQuartzJobById(Integer jodId) {
		return mapper.findQuartzJobById(jodId);
	}

	@Override
	public List<CScheduleTrigger> findQuartzJobByStatus(String jobStatus) {
		return mapper.findQuartzJobByStatus(jobStatus);
	}

}
