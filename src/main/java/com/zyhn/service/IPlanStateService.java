package com.zyhn.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author wcy
 * @date 2021/9/16 下午4:52
 */
public interface IPlanStateService {

	/**
	 * 添加状态
	 * @param jsonObject
	 */
	int addPlanState(JSONObject jsonObject);

	/**
	 * 修改状态
	 * @param jsonObject
	 */
	int updatePlanState(JSONObject jsonObject);

	/**
	 * 查询code
	 * @param code
	 * @return
	 */
	List<String> selectCode(String code);

}
