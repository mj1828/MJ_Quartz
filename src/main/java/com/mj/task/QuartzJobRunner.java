package com.mj.task;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mj.code.JobStatusCode;
import com.mj.entity.ScheduleJob;
import com.mj.mapper.ScheduleJobMapper;
import com.mj.service.QuartzJobService;

/**
 * @ClassName: QuartzJobRunner
 * @Description: 项目启动执行定时任务的调度
 * @author: cobra
 * @date: 2018年9月28日
 * @version: v1.0
 */
@Component
public class QuartzJobRunner implements ApplicationRunner {

	private Logger log = LoggerFactory.getLogger(QuartzJobRunner.class);

	@Autowired
	private QuartzJobService quartzJobService;

	@Autowired
	private ScheduleJobMapper mapper;

	@Autowired
	private QuartzJobManager quartzJobManager;

	// 定时任务扫描路径
	@Value("${mj.quartz.jobpath:#{com.mj.task.job}}")
	private String jobPath;

	// 集群环境是否开启
	@Value("${mj.cluster.open:#{false}}")
	private boolean clusterOpen;

	// 集群定时任务
	@Value("${mj.cluster.joblist:#{}}")
	private String jobList;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("**********初始化加载定时任务开始**********");
		List<ScheduleJob> jobList = new ArrayList<>();
		if (clusterOpen) {
			log.info("开启集群环境，定时任务通过配置项获取");
			if (this.jobList != null && !"".equals(this.jobList)) {
				List<String> jobs = Arrays.asList(this.jobList.split(";"));
				scanJobs(jobs, jobList);
			}
		} else {
			log.info("单机环境扫描所有定时任务");
			scanJobs();
			jobList = quartzJobService.findQuartzJobByStatus(JobStatusCode.RUNNING + "");
		}

		if (jobList != null && jobList.size() > 0) {
			jobList.forEach((quartzJob) -> {
				try {
					quartzJobManager.addJob(quartzJob);
				} catch (SchedulerException e) {
					e.printStackTrace();
					log.info("**********初始化加载定时任务异常**********");
				}
			});
		}
	}

	/**
	 * 自动扫描指定文件夹下的定时任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	private void scanJobs() {
		String packageDirName = jobPath.replace('.', '/');
		URL url = this.getClass().getClassLoader().getResource(packageDirName);
		File file = new File(url.getFile());
		String[] files = file.list();
		for (String className : files) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(jobPath);
			stringBuilder.append(".");
			stringBuilder.append(className.substring(0, className.indexOf(".")));
			try {
				Class<?> job = Class.forName(stringBuilder.toString());
				BaseJob baseJob = (BaseJob) job.newInstance();
				String jobName = baseJob.getJobName();
				String jobGroup = baseJob.getJobGroup();
				List<ScheduleJob> list = mapper.findQuartzJobByKey(jobName, jobGroup);
				ScheduleJob jobDetail = new ScheduleJob();
				jobDetail.setJobName(jobName);
				jobDetail.setJobGroup(jobGroup);
				jobDetail.setJobStatus(baseJob.getJobStatus());
				jobDetail.setCronExpression(baseJob.getCronExpression());
				jobDetail.setDescription(baseJob.getDescription());
				jobDetail.setJobClass(stringBuilder.toString());
				jobDetail.setMethodName(baseJob.getMethodName());
				if (list != null && list.size() > 0) {
					log.info("已插入，更新所有定时任务");
					mapper.updateQuartzJobByKey(jobDetail);
				} else {
					log.info("新任务，持久化到数据库");
					mapper.createQuartzJob(jobDetail);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 自动扫描指定文件夹下的定时任务
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	private void scanJobs(List<String> jobList, List<ScheduleJob> scheduleJoblist) {
		String packageDirName = jobPath.replace('.', '/');
		URL url = this.getClass().getClassLoader().getResource(packageDirName);
		File file = new File(url.getFile());
		String[] files = file.list();
		for (String className : files) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(jobPath);
			stringBuilder.append(".");
			stringBuilder.append(className.substring(0, className.indexOf(".")));
			try {
				Class<?> job = Class.forName(stringBuilder.toString());
				BaseJob baseJob = (BaseJob) job.newInstance();
				if (jobList.contains(baseJob.getJobName()) && baseJob.getJobStatus().equals(JobStatusCode.RUNNING)) {
					String jobName = baseJob.getJobName();
					String jobGroup = baseJob.getJobGroup();
					List<ScheduleJob> list = mapper.findQuartzJobByKey(jobName, jobGroup);
					ScheduleJob jobDetail = new ScheduleJob();
					jobDetail.setJobName(jobName);
					jobDetail.setJobGroup(jobGroup);
					jobDetail.setJobStatus(baseJob.getJobStatus());
					jobDetail.setCronExpression(baseJob.getCronExpression());
					jobDetail.setDescription(baseJob.getDescription());
					jobDetail.setJobClass(stringBuilder.toString());
					jobDetail.setMethodName(baseJob.getMethodName());
					if (list != null && list.size() > 0) {
						log.info("已插入，更新所有定时任务");
						mapper.updateQuartzJobByKey(jobDetail);
					} else {
						log.info("新任务，持久化到数据库");
						mapper.createQuartzJob(jobDetail);
					}
					scheduleJoblist.add(jobDetail);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
