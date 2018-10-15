package com.mj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CScheduleTrigger;
import com.mj.mapper.CScheduleTriggerMapper;
import com.mj.service.QuartzJobService;

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

	@Override
	public CScheduleTrigger createQuartzJob(CScheduleTrigger job) {
		mapper.insertSelective(job);
		return job;
	}

	@Override
	public CScheduleTrigger modifyQuartzJob(CScheduleTrigger job) {
		mapper.updateByPrimaryKeySelective(job);
		return job;
	}

	@Override
	public void pauseAllQuartzJob() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pauseQuartzJob(CScheduleTrigger quartzJob) {
		mapper.updateByPrimaryKeySelective(quartzJob);

	}

	@Override
	public void resumeAllQuartzJob() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resumeQuartzJob(CScheduleTrigger quartzJob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuartzJob(CScheduleTrigger quartzJob) {
		mapper.deleteByPrimaryKey(quartzJob.getJobId());

	}

	@Override
	public CScheduleTrigger findQuartzJobById(Integer jodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CScheduleTrigger> findQuartzJobByStatus(String jobStatus) {
		return mapper.cornList();
	}

}
