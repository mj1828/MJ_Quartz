package com.mj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.common.ResultUtil;
import com.mj.entity.CScheduleTrigger;
import com.mj.service.QuartzJobService;

/**
 * @ClassName: QuartzJobController
 * @Description: quartz定时任务管理
 * @author: cobra
 * @date: 2018年9月28日
 * @version: v1.0
 */
@RestController
@RequestMapping("/quartz")
public class QuartzJobController {

	@Autowired
	private QuartzJobService quartzJobService;

	/**
	 * @Method: createQuartzJob @Description: 创建定时任务 @param: @param
	 *          job @param: @return @return: ResponseResult @throws
	 */
	@PostMapping(value = "/create")
	public String createQuartzJob(CScheduleTrigger job) {
		quartzJobService.createQuartzJob(job);
		return ResultUtil.success("创建成功");
	}

	/**
	 * @Method: modifyQuartzJob @Description: 修改定时任务 @param: @param
	 *          job @param: @return @return: ResponseResult @throws
	 */
	@PostMapping(value = "/modify")
	public String modifyQuartzJob(@RequestBody CScheduleTrigger job) {
		quartzJobService.modifyQuartzJob(job);
		return ResultUtil.success("修改成功");
	}

	/**
	 * @Method: pauseAllQuartzJob @Description: 暂停所有定时任务 @param: @return @return:
	 *          ResponseResult @throws
	 */
	@RequestMapping("/pauseAll")
	public String pauseAllQuartzJob() {
		quartzJobService.pauseAllQuartzJob();
		return ResultUtil.success("成功");

	}

	/**
	 * @Method: pauseQuartzJob @Description: 暂停某个定时任务 @param: @param
	 *          quartzJob @param: @return @return: ResponseResult @throws
	 */
	@RequestMapping("/pause")
	public String pauseQuartzJob(CScheduleTrigger quartzJob) {
		quartzJobService.pauseQuartzJob(quartzJob);
		return ResultUtil.success("成功");
	}

	/**
	 * @Method: resumeAllQuartzJob @Description:
	 *          恢复所有暂停的定时任务 @param: @return @return: ResponseResult @throws
	 */
	@RequestMapping("/resumeAll")
	public String resumeAllQuartzJob() {
		quartzJobService.resumeAllQuartzJob();
		return ResultUtil.success("成功");
	}

	/**
	 * @Method: resumeQuartzJob @Description: 恢复某个暂停的定时任务 @param: @param
	 *          quartzJob @param: @return @return: ResponseResult @throws
	 */
	@RequestMapping("/resume")
	public String resumeQuartzJob(CScheduleTrigger quartzJob) {
		quartzJobService.resumeQuartzJob(quartzJob);
		return ResultUtil.success("成功");
	}

	/**
	 * @Method: deleteQuartzJob @Description: 删除某个定时任务 @param: @param
	 *          quartzJob @param: @return @return: ResponseResult @throws
	 */
	@RequestMapping("/delete")
	public String deleteQuartzJob(CScheduleTrigger quartzJob) {
		System.out.println("jobID:" + quartzJob.getJobId());
		quartzJobService.deleteQuartzJob(quartzJob);
		return ResultUtil.success("成功");
	}

}
