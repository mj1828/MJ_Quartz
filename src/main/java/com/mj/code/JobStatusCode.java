package com.mj.code;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 任务状态字典表
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年10月19日
 */
public class JobStatusCode {

	public static Integer RUNNING = 1; // 执行中
	public static Integer STOPPED = 0; // 已停止

	/**
	 * 获取value值
	 * @Description:   
	 * @return: String      
	 * @throws
	 */
	public static String getCode(String jobStatus) {
		if (RUNNING.toString().equals(jobStatus)) {
			return "执行中";
		} else if (STOPPED.toString().equals(jobStatus)) {
			return "已停止";
		} else {
			return "其他";
		}
	}

	/**
	 * 转换
	 * @Description:   
	 * @return: void      
	 * @throws
	 */
	public static void decodeCode(JSONArray array, String key) {
		for (Object object : array) {
			JSONObject item = (JSONObject) object;
			if (item.containsKey(key)) {
				item.put(key + "Name", JobStatusCode.getCode(item.getString(key)));
			}
		}
	}
}
