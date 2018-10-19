package com.mj.code;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class YesOrNoCode {
	public static String YES = "1"; // 是
	public static String NO = "0"; // 否

	/**
	 * 获取value值
	 * @Description:   
	 * @return: String      
	 * @throws
	 */
	public static String getCode(String jobStatus) {
		if (YES.equals(jobStatus)) {
			return "是";
		} else if (NO.equals(jobStatus)) {
			return "否";
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
				item.put(key + "Name", YesOrNoCode.getCode(item.getString(key)));
			}
		}
	}
}
